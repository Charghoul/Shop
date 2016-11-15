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

    public PersistentNeuanlage getTheNeuanlage() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NnlgFacade.getTheNnlg; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
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

