package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class PositionFacade{

	private String schemaName;
	private Connection con;

	public PositionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentPosition newPosition(long menge,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.newPstn(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, menge);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Position result = new Position(null,menge,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentPosition)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentPosition newDelayedPosition(long menge) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.newDelayedPstn(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Position result = new Position(null,menge,null,id);
            Cache.getTheCache().put(result);
            return (PersistentPosition)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Position getPosition(long PositionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.getPstn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PositionId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentArtikel artikel = null;
            if (obj.getLong(2) != 0)
                artikel = (PersistentArtikel)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentPosition This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentPosition)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Position result = new Position(artikel,
                                           obj.getLong(4),
                                           This,
                                           PositionId);
            obj.close();
            callable.close();
            PositionICProxi inCache = (PositionICProxi)Cache.getTheCache().put(result);
            Position objectInCache = (Position)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.getClass(?); end;");
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
    public void artikelSet(long PositionId, Artikel4Public artikelVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.artklSet(?, ?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, artikelVal.getId());
            callable.setLong(3, artikelVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void mengeSet(long PositionId, long mengeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.mngSet(?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, mengeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long PositionId, Position4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

