package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class VerkaufFacade{

	private String schemaName;
	private Connection con;

	public VerkaufFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentVerkauf newVerkauf(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".VrkfFacade.newVrkf(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Verkauf result = new Verkauf(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentVerkauf)PersistentProxi.createProxi(id, 212);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentVerkauf newDelayedVerkauf() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".VrkfFacade.newDelayedVrkf(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Verkauf result = new Verkauf(null,id);
            Cache.getTheCache().put(result);
            return (PersistentVerkauf)PersistentProxi.createProxi(id, 212);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Verkauf getVerkauf(long VerkaufId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".VrkfFacade.getVrkf(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, VerkaufId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentArtikelstatus This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentArtikelstatus)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Verkauf result = new Verkauf(This,
                                         VerkaufId);
            obj.close();
            callable.close();
            VerkaufICProxi inCache = (VerkaufICProxi)Cache.getTheCache().put(result);
            Verkauf objectInCache = (Verkauf)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

