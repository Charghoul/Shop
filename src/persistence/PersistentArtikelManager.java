package persistence;


public interface PersistentArtikelManager extends Anything, AbstractPersistentProxi, ArtikelManager4Public {
    
    public ArtikelManager_KomponentenListeProxi getKomponentenListe() throws PersistenceException ;
    public PersistentArtikelManager getThis() throws PersistenceException ;
    
    
    public ServiceAdmin4Public inverseGetArtikelManager() 
				throws PersistenceException;

}

