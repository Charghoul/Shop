package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class HinversandFacade{

	private String schemaName;
	private Connection con;

	public HinversandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentHinversand newHinversand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".HnvrsndFacade.newHnvrsnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Hinversand result = new Hinversand(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentHinversand)PersistentProxi.createProxi(id, 218);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentHinversand newDelayedHinversand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".HnvrsndFacade.newDelayedHnvrsnd(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Hinversand result = new Hinversand(null,id);
            Cache.getTheCache().put(result);
            return (PersistentHinversand)PersistentProxi.createProxi(id, 218);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Hinversand getHinversand(long HinversandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".HnvrsndFacade.getHnvrsnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, HinversandId);
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
            Hinversand result = new Hinversand(This,
                                               HinversandId);
            obj.close();
            callable.close();
            HinversandICProxi inCache = (HinversandICProxi)Cache.getTheCache().put(result);
            Hinversand objectInCache = (Hinversand)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

