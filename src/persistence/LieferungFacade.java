package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class LieferungFacade{

	private String schemaName;
	private Connection con;

	public LieferungFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentLieferung newLieferung(long lieferversuche,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrngFacade.newLfrng(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, lieferversuche);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Lieferung result = new Lieferung(null,null,lieferversuche,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentLieferung)PersistentProxi.createProxi(id, 150);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentLieferung newDelayedLieferung(long lieferversuche) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrngFacade.newDelayedLfrng(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Lieferung result = new Lieferung(null,null,lieferversuche,null,id);
            Cache.getTheCache().put(result);
            return (PersistentLieferung)PersistentProxi.createProxi(id, 150);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Lieferung getLieferung(long LieferungId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrngFacade.getLfrng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, LieferungId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBestellung bestellung = null;
            if (obj.getLong(2) != 0)
                bestellung = (PersistentBestellung)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentLieferart lieferart = null;
            if (obj.getLong(4) != 0)
                lieferart = (PersistentLieferart)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentLieferung This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentLieferung)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Lieferung result = new Lieferung(bestellung,
                                             lieferart,
                                             obj.getLong(6),
                                             This,
                                             LieferungId);
            obj.close();
            callable.close();
            LieferungICProxi inCache = (LieferungICProxi)Cache.getTheCache().put(result);
            Lieferung objectInCache = (Lieferung)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LfrngFacade.getClass(?); end;");
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
    public void bestellungSet(long LieferungId, Bestellung4Public bestellungVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrngFacade.bstllngSet(?, ?, ?); end;");
            callable.setLong(1, LieferungId);
            callable.setLong(2, bestellungVal.getId());
            callable.setLong(3, bestellungVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lieferartSet(long LieferungId, Lieferart4Public lieferartVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrngFacade.lfrrtSet(?, ?, ?); end;");
            callable.setLong(1, LieferungId);
            callable.setLong(2, lieferartVal.getId());
            callable.setLong(3, lieferartVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lieferversucheSet(long LieferungId, long lieferversucheVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrngFacade.lfrvrschSet(?, ?); end;");
            callable.setLong(1, LieferungId);
            callable.setLong(2, lieferversucheVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long LieferungId, Lieferung4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LfrngFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, LieferungId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

