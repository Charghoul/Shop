package persistence;

import model.*;

public class ArtikelFacade{



	public ArtikelFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentArtikel newArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentArtikel)PersistentProxi.createProxi(idCreateIfLessZero, 108);
        long id = ConnectionHandler.getTheConnectionHandler().theKomponenteFacade.getNextId();
        Artikel result = new Artikel(null,null,artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentArtikel)PersistentProxi.createProxi(id, 108);
    }
    
    public PersistentArtikel newDelayedArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theKomponenteFacade.getNextId();
        Artikel result = new Artikel(null,null,artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentArtikel)PersistentProxi.createProxi(id, 108);
    }
    
    public Artikel getArtikel(long ArtikelId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public ArtikelSearchList getArtikelByArtikelnummer(String artikelnummer) throws PersistenceException {
        artikelnummer = artikelnummer.replaceAll("%", ".*");
        artikelnummer = artikelnummer.replaceAll("_", ".");
        ArtikelSearchList result = new ArtikelSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(108);
        while (candidates.hasNext()){
            PersistentArtikel current = (PersistentArtikel)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getArtikelnummer().matches(artikelnummer))
                result.add((PersistentArtikel)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public ArtikelSearchList getArtikelByBezeichnung(String bezeichnung) throws PersistenceException {
        bezeichnung = bezeichnung.replaceAll("%", ".*");
        bezeichnung = bezeichnung.replaceAll("_", ".");
        ArtikelSearchList result = new ArtikelSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(108);
        while (candidates.hasNext()){
            PersistentArtikel current = (PersistentArtikel)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getBezeichnung().matches(bezeichnung))
                result.add((PersistentArtikel)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void artikelnummerSet(long ArtikelId, String artikelnummerVal) throws PersistenceException {
        
    }
    public void bezeichnungSet(long ArtikelId, String bezeichnungVal) throws PersistenceException {
        
    }
    public void preisSet(long ArtikelId, common.Fraction preisVal) throws PersistenceException {
        
    }
    public void minLagerbestandSet(long ArtikelId, long minLagerbestandVal) throws PersistenceException {
        
    }
    public void maxLagerbestandSet(long ArtikelId, long maxLagerbestandVal) throws PersistenceException {
        
    }
    public void hstLieferzeitSet(long ArtikelId, long hstLieferzeitVal) throws PersistenceException {
        
    }
    public void artikelstatusSet(long ArtikelId, Artikelstatus4Public artikelstatusVal) throws PersistenceException {
        
    }
    public void herstellerSet(long ArtikelId, Hersteller4Public herstellerVal) throws PersistenceException {
        
    }

}

