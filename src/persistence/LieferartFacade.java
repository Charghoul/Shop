package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class LieferartFacade{

	private String schemaName;
	private Connection con;

	public LieferartFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentLieferart newLieferart(String name,long lieferzeit,common.Fraction preis,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrrtFacade.newLfrrt(?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, lieferzeit);
            callable.setString(4, preis.toString());
            callable.setLong(5, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Lieferart result = new Lieferart(name,lieferzeit,preis,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentLieferart)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentLieferart newDelayedLieferart(String name,long lieferzeit,common.Fraction preis) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrrtFacade.newDelayedLfrrt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Lieferart result = new Lieferart(name,lieferzeit,preis,null,id);
            Cache.getTheCache().put(result);
            return (PersistentLieferart)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Lieferart getLieferart(long LieferartId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrrtFacade.getLfrrt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, LieferartId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentLieferart This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentLieferart)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Lieferart result = new Lieferart(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                             obj.getLong(3),
                                             (obj.getString(4) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(4))),
                                             This,
                                             LieferartId);
            obj.close();
            callable.close();
            LieferartICProxi inCache = (LieferartICProxi)Cache.getTheCache().put(result);
            Lieferart objectInCache = (Lieferart)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrrtFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public LieferartSearchList getLieferartByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrrtFacade.getLfrrtByNm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            LieferartSearchList result = new LieferartSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentLieferart proxi = (PersistentLieferart)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long LieferartId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrrtFacade.nmSet(?, ?); end;");
            callable.setLong(1, LieferartId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lieferzeitSet(long LieferartId, long lieferzeitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrrtFacade.lfrztSet(?, ?); end;");
            callable.setLong(1, LieferartId);
            callable.setLong(2, lieferzeitVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void preisSet(long LieferartId, common.Fraction preisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrrtFacade.prsSet(?, ?); end;");
            callable.setLong(1, LieferartId);
            callable.setString(2, preisVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long LieferartId, Lieferart4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrrtFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, LieferartId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

