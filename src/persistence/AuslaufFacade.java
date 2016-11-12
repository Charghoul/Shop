package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AuslaufFacade{

	private String schemaName;
	private Connection con;

	public AuslaufFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAuslauf newAuslauf(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AslfFacade.newAslf(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Auslauf result = new Auslauf(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAuslauf)PersistentProxi.createProxi(id, 213);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAuslauf newDelayedAuslauf() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AslfFacade.newDelayedAslf(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Auslauf result = new Auslauf(null,id);
            Cache.getTheCache().put(result);
            return (PersistentAuslauf)PersistentProxi.createProxi(id, 213);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Auslauf getAuslauf(long AuslaufId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AslfFacade.getAslf(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AuslaufId);
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
            Auslauf result = new Auslauf(This,
                                         AuslaufId);
            obj.close();
            callable.close();
            AuslaufICProxi inCache = (AuslaufICProxi)Cache.getTheCache().put(result);
            Auslauf objectInCache = (Auslauf)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

