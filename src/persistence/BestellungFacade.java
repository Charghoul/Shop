package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class BestellungFacade{

	private String schemaName;
	private Connection con;

	public BestellungFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentBestellung newBestellung(String ID,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.newBstllng(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, ID);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Bestellung result = new Bestellung(ID,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentBestellung)PersistentProxi.createProxi(id, 136);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentBestellung newDelayedBestellung(String ID) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.newDelayedBstllng(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Bestellung result = new Bestellung(ID,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentBestellung)PersistentProxi.createProxi(id, 136);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Bestellung getBestellung(long BestellungId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.getBstllng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BestellungId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBestellstatus bestellstatus = null;
            if (obj.getLong(3) != 0)
                bestellstatus = (PersistentBestellstatus)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentBestellung This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentBestellung)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Bestellung result = new Bestellung(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                               bestellstatus,
                                               This,
                                               BestellungId);
            obj.close();
            callable.close();
            BestellungICProxi inCache = (BestellungICProxi)Cache.getTheCache().put(result);
            Bestellung objectInCache = (Bestellung)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.getClass(?); end;");
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
    public long positionsListeAdd(long BestellungId, Position4Public positionsListeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.pstnsLstAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, BestellungId);
            callable.setLong(3, positionsListeVal.getId());
            callable.setLong(4, positionsListeVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void positionsListeRem(long positionsListeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BstllngFacade.pstnsLstRem(?); end;");
            callable.setLong(1, positionsListeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PositionList positionsListeGet(long BestellungId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BstllngFacade.pstnsLstGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BestellungId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PositionList result = new PositionList();
            while (list.next()) {
                result.add((PersistentPosition)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void IDSet(long BestellungId, String IDVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BstllngFacade.IDSet(?, ?); end;");
            callable.setLong(1, BestellungId);
            callable.setString(2, IDVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bestellstatusSet(long BestellungId, Bestellstatus4Public bestellstatusVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BstllngFacade.bstllsttsSet(?, ?, ?); end;");
            callable.setLong(1, BestellungId);
            callable.setLong(2, bestellstatusVal.getId());
            callable.setLong(3, bestellstatusVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BestellungId, Bestellung4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BstllngFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BestellungId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

