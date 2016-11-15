package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ArtikelFacade{

	private String schemaName;
	private Connection con;

	public ArtikelFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentArtikel newArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ArtklFacade.newArtkl(?,?,?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, artikelnummer);
            callable.setString(3, bezeichnung);
            callable.setString(4, preis.toString());
            callable.setLong(5, minLagerbestand);
            callable.setLong(6, maxLagerbestand);
            callable.setLong(7, hstLieferzeit);
            callable.setLong(8, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Artikel result = new Artikel(null,artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentArtikel)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentArtikel newDelayedArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ArtklFacade.newDelayedArtkl(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Artikel result = new Artikel(null,artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentArtikel)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Artikel getArtikel(long ArtikelId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ArtklFacade.getArtkl(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ArtikelId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentKomponente This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentKomponente)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentArtikelstatus artikelstatus = null;
            if (obj.getLong(10) != 0)
                artikelstatus = (PersistentArtikelstatus)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentHersteller hersteller = null;
            if (obj.getLong(12) != 0)
                hersteller = (PersistentHersteller)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            Artikel result = new Artikel(This,
                                         obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                         obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                         (obj.getString(6) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(6))),
                                         obj.getLong(7),
                                         obj.getLong(8),
                                         obj.getLong(9),
                                         artikelstatus,
                                         hersteller,
                                         ArtikelId);
            obj.close();
            callable.close();
            ArtikelICProxi inCache = (ArtikelICProxi)Cache.getTheCache().put(result);
            Artikel objectInCache = (Artikel)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ArtikelSearchList getArtikelByArtikelnummer(String artikelnummer) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ArtklFacade.getArtklByArtklnmmr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, artikelnummer);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ArtikelSearchList result = new ArtikelSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentArtikel proxi = (PersistentArtikel)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ArtikelSearchList getArtikelByBezeichnung(String bezeichnung) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ArtklFacade.getArtklByBzchnng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, bezeichnung);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ArtikelSearchList result = new ArtikelSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentArtikel proxi = (PersistentArtikel)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void artikelnummerSet(long ArtikelId, String artikelnummerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.artklnmmrSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setString(2, artikelnummerVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bezeichnungSet(long ArtikelId, String bezeichnungVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.bzchnngSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setString(2, bezeichnungVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void preisSet(long ArtikelId, common.Fraction preisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.prsSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setString(2, preisVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void minLagerbestandSet(long ArtikelId, long minLagerbestandVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.mnLgrbstndSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setLong(2, minLagerbestandVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void maxLagerbestandSet(long ArtikelId, long maxLagerbestandVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.mxLgrbstndSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setLong(2, maxLagerbestandVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hstLieferzeitSet(long ArtikelId, long hstLieferzeitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.hstLfrztSet(?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setLong(2, hstLieferzeitVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void artikelstatusSet(long ArtikelId, Artikelstatus4Public artikelstatusVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.artklsttsSet(?, ?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setLong(2, artikelstatusVal.getId());
            callable.setLong(3, artikelstatusVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void herstellerSet(long ArtikelId, Hersteller4Public herstellerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ArtklFacade.hrstllrSet(?, ?, ?); end;");
            callable.setLong(1, ArtikelId);
            callable.setLong(2, herstellerVal.getId());
            callable.setLong(3, herstellerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

