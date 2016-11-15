package persistence;


public interface PersistentArtikelManager extends Anything, AbstractPersistentProxi, ArtikelManager4Public {
    
    public ArtikelManager_ArtikelListeProxi getArtikelListe() throws PersistenceException ;
    public ArtikelManager_ProduktgruppenProxi getProduktgruppen() throws PersistenceException ;
    public PersistentArtikelManager getThis() throws PersistenceException ;
    
    

}

