package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ServiceRegisterFacade{

	private String schemaName;
	private Connection con;

	public ServiceRegisterFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceRegister newServiceRegister(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcRgstrFacade.newSrvcRgstr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceRegister result = new ServiceRegister(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentServiceRegister)PersistentProxi.createProxi(id, -189);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentServiceRegister newDelayedServiceRegister() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcRgstrFacade.newDelayedSrvcRgstr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceRegister result = new ServiceRegister(null,id);
            Cache.getTheCache().put(result);
            return (PersistentServiceRegister)PersistentProxi.createProxi(id, -189);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ServiceRegister getServiceRegister(long ServiceRegisterId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcRgstrFacade.getSrvcRgstr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ServiceRegisterId);
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
            ServiceRegister result = new ServiceRegister(This,
                                                         ServiceRegisterId);
            obj.close();
            callable.close();
            ServiceRegisterICProxi inCache = (ServiceRegisterICProxi)Cache.getTheCache().put(result);
            ServiceRegister objectInCache = (ServiceRegister)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

