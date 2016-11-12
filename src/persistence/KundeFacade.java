package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class KundeFacade{

	private String schemaName;
	private Connection con;

	public KundeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentKunde newKunde(String benutzername,String passwort,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".KndFacade.newKnd(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, benutzername);
            callable.setString(3, passwort);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Kunde result = new Kunde(benutzername,passwort,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentKunde)PersistentProxi.createProxi(id, 102);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentKunde newDelayedKunde(String benutzername,String passwort) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".KndFacade.newDelayedKnd(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Kunde result = new Kunde(benutzername,passwort,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentKunde)PersistentProxi.createProxi(id, 102);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Kunde getKunde(long KundeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KndFacade.getKnd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, KundeId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentKonto konto = null;
            if (obj.getLong(4) != 0)
                konto = (PersistentKonto)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentKunde This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentKunde)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Kunde result = new Kunde(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                     obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                     konto,
                                     This,
                                     KundeId);
            obj.close();
            callable.close();
            KundeICProxi inCache = (KundeICProxi)Cache.getTheCache().put(result);
            Kunde objectInCache = (Kunde)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KndFacade.getClass(?); end;");
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
    public KundeSearchList getKundeByBenutzername(String benutzername) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KndFacade.getKndByBntzrnm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, benutzername);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            KundeSearchList result = new KundeSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentKunde proxi = (PersistentKunde)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void benutzernameSet(long KundeId, String benutzernameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KndFacade.bntzrnmSet(?, ?); end;");
            callable.setLong(1, KundeId);
            callable.setString(2, benutzernameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void passwortSet(long KundeId, String passwortVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KndFacade.psswrtSet(?, ?); end;");
            callable.setLong(1, KundeId);
            callable.setString(2, passwortVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void kontoSet(long KundeId, Konto4Public kontoVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KndFacade.kntSet(?, ?, ?); end;");
            callable.setLong(1, KundeId);
            callable.setLong(2, kontoVal.getId());
            callable.setLong(3, kontoVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long KundeId, Kunde4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KndFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, KundeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

