package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ServiceAdminFacade{

	private String schemaName;
	private Connection con;

	public ServiceAdminFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceAdmin newServiceAdmin(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.newSrvcAdmn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceAdmin result = new ServiceAdmin(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentServiceAdmin)PersistentProxi.createProxi(id, -182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentServiceAdmin newDelayedServiceAdmin() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.newDelayedSrvcAdmn(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ServiceAdmin result = new ServiceAdmin(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentServiceAdmin)PersistentProxi.createProxi(id, -182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ServiceAdmin getServiceAdmin(long ServiceAdminId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.getSrvcAdmn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ServiceAdminId);
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
            PersistentWarenlager warenlager = null;
            if (obj.getLong(4) != 0)
                warenlager = (PersistentWarenlager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentArtikelManager artikelManager = null;
            if (obj.getLong(6) != 0)
                artikelManager = (PersistentArtikelManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentLieferartManager lieferartManager = null;
            if (obj.getLong(8) != 0)
                lieferartManager = (PersistentLieferartManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ServiceAdmin result = new ServiceAdmin(This,
                                                   warenlager,
                                                   artikelManager,
                                                   lieferartManager,
                                                   ServiceAdminId);
            obj.close();
            callable.close();
            ServiceAdminICProxi inCache = (ServiceAdminICProxi)Cache.getTheCache().put(result);
            ServiceAdmin objectInCache = (ServiceAdmin)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void warenlagerSet(long ServiceAdminId, Warenlager4Public warenlagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcAdmnFacade.wrnlgrSet(?, ?, ?); end;");
            callable.setLong(1, ServiceAdminId);
            callable.setLong(2, warenlagerVal.getId());
            callable.setLong(3, warenlagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void artikelManagerSet(long ServiceAdminId, ArtikelManager4Public artikelManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcAdmnFacade.artklMngrSet(?, ?, ?); end;");
            callable.setLong(1, ServiceAdminId);
            callable.setLong(2, artikelManagerVal.getId());
            callable.setLong(3, artikelManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lieferartManagerSet(long ServiceAdminId, LieferartManager4Public lieferartManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcAdmnFacade.lfrrtMngrSet(?, ?, ?); end;");
            callable.setLong(1, ServiceAdminId);
            callable.setLong(2, lieferartManagerVal.getId());
            callable.setLong(3, lieferartManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServiceAdminSearchList inverseGetWarenlager(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.iGetWrnlgr(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServiceAdminSearchList result = new ServiceAdminSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServiceAdminSearchList inverseGetArtikelManager(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.iGetArtklMngr(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServiceAdminSearchList result = new ServiceAdminSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServiceAdminSearchList inverseGetLieferartManager(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcAdmnFacade.iGetLfrrtMngr(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServiceAdminSearchList result = new ServiceAdminSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentServiceAdmin)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

