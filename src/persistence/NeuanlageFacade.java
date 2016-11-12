package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NeuanlageFacade{

	private String schemaName;
	private Connection con;

	public NeuanlageFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentNeuanlage newNeuanlage(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NnlgFacade.newNnlg(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Neuanlage result = new Neuanlage(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentNeuanlage)PersistentProxi.createProxi(id, 214);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentNeuanlage newDelayedNeuanlage() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NnlgFacade.newDelayedNnlg(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Neuanlage result = new Neuanlage(null,id);
            Cache.getTheCache().put(result);
            return (PersistentNeuanlage)PersistentProxi.createProxi(id, 214);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Neuanlage getNeuanlage(long NeuanlageId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NnlgFacade.getNnlg(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NeuanlageId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentArtikelstatus This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentArtikelstatus)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Neuanlage result = new Neuanlage(This,
                                             NeuanlageId);
            obj.close();
            callable.close();
            NeuanlageICProxi inCache = (NeuanlageICProxi)Cache.getTheCache().put(result);
            Neuanlage objectInCache = (Neuanlage)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

