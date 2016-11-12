package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ServiceKundeFacade{

	private String schemaName;
	private Connection con;

	public ServiceKundeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceKunde newServiceKunde(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcKndFacade.newSrvcKnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceKunde result = new ServiceKunde(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentServiceKunde)PersistentProxi.createProxi(id, -181);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentServiceKunde newDelayedServiceKunde() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcKndFacade.newDelayedSrvcKnd(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceKunde result = new ServiceKunde(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentServiceKunde)PersistentProxi.createProxi(id, -181);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ServiceKunde getServiceKunde(long ServiceKundeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcKndFacade.getSrvcKnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ServiceKundeId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentService This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentEinkaufsManager einkaufsManager = null;
            if (obj.getLong(4) != 0)
                einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            ServiceKunde result = new ServiceKunde(This,
                                                   einkaufsManager,
                                                   ServiceKundeId);
            obj.close();
            callable.close();
            ServiceKundeICProxi inCache = (ServiceKundeICProxi)Cache.getTheCache().put(result);
            ServiceKunde objectInCache = (ServiceKunde)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void einkaufsManagerSet(long ServiceKundeId, EinkaufsManager4Public einkaufsManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcKndFacade.enkfsMngrSet(?, ?, ?); end;");
            callable.setLong(1, ServiceKundeId);
            callable.setLong(2, einkaufsManagerVal.getId());
            callable.setLong(3, einkaufsManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServiceKundeSearchList inverseGetEinkaufsManager(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcKndFacade.iGetEnkfsMngr(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServiceKundeSearchList result = new ServiceKundeSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentServiceKunde)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentServiceKunde)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

