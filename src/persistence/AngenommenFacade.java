package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AngenommenFacade{

	private String schemaName;
	private Connection con;

	public AngenommenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAngenommen newAngenommen(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AngnmmnFacade.newAngnmmn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Angenommen result = new Angenommen(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAngenommen)PersistentProxi.createProxi(id, 219);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAngenommen newDelayedAngenommen() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AngnmmnFacade.newDelayedAngnmmn(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Angenommen result = new Angenommen(null,id);
            Cache.getTheCache().put(result);
            return (PersistentAngenommen)PersistentProxi.createProxi(id, 219);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Angenommen getAngenommen(long AngenommenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AngnmmnFacade.getAngnmmn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AngenommenId);
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
            Angenommen result = new Angenommen(This,
                                               AngenommenId);
            obj.close();
            callable.close();
            AngenommenICProxi inCache = (AngenommenICProxi)Cache.getTheCache().put(result);
            Angenommen objectInCache = (Angenommen)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

