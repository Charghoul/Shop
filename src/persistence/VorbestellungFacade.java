package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class VorbestellungFacade{

	private String schemaName;
	private Connection con;

	public VorbestellungFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentVorbestellung newVorbestellung(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".VrbstllngFacade.newVrbstllng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Vorbestellung result = new Vorbestellung(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentVorbestellung)PersistentProxi.createProxi(id, 216);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentVorbestellung newDelayedVorbestellung() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".VrbstllngFacade.newDelayedVrbstllng(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Vorbestellung result = new Vorbestellung(null,id);
            Cache.getTheCache().put(result);
            return (PersistentVorbestellung)PersistentProxi.createProxi(id, 216);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Vorbestellung getVorbestellung(long VorbestellungId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".VrbstllngFacade.getVrbstllng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, VorbestellungId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBestellstatus This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentBestellstatus)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Vorbestellung result = new Vorbestellung(This,
                                                     VorbestellungId);
            obj.close();
            callable.close();
            VorbestellungICProxi inCache = (VorbestellungICProxi)Cache.getTheCache().put(result);
            Vorbestellung objectInCache = (Vorbestellung)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

