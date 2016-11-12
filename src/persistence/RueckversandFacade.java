package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RueckversandFacade{

	private String schemaName;
	private Connection con;

	public RueckversandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRueckversand newRueckversand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RckvrsndFacade.newRckvrsnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Rueckversand result = new Rueckversand(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRueckversand)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRueckversand newDelayedRueckversand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RckvrsndFacade.newDelayedRckvrsnd(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Rueckversand result = new Rueckversand(null,id);
            Cache.getTheCache().put(result);
            return (PersistentRueckversand)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Rueckversand getRueckversand(long RueckversandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RckvrsndFacade.getRckvrsnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RueckversandId);
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
            Rueckversand result = new Rueckversand(This,
                                                   RueckversandId);
            obj.close();
            callable.close();
            RueckversandICProxi inCache = (RueckversandICProxi)Cache.getTheCache().put(result);
            Rueckversand objectInCache = (Rueckversand)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

