package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class GeliefertFacade{

	private String schemaName;
	private Connection con;

	public GeliefertFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentGeliefert newGeliefert(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".GlfrtFacade.newGlfrt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Geliefert result = new Geliefert(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentGeliefert)PersistentProxi.createProxi(id, 215);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentGeliefert newDelayedGeliefert() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".GlfrtFacade.newDelayedGlfrt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Geliefert result = new Geliefert(null,id);
            Cache.getTheCache().put(result);
            return (PersistentGeliefert)PersistentProxi.createProxi(id, 215);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Geliefert getGeliefert(long GeliefertId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".GlfrtFacade.getGlfrt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, GeliefertId);
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
            Geliefert result = new Geliefert(This,
                                             GeliefertId);
            obj.close();
            callable.close();
            GeliefertICProxi inCache = (GeliefertICProxi)Cache.getTheCache().put(result);
            Geliefert objectInCache = (Geliefert)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

