package persistence;


public interface PersistentArtikelManager extends Anything, SubjInterface, AbstractPersistentProxi, ArtikelManager4Public {
    
    public ArtikelManager_ArtikelListeProxi getArtikelListe() throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentArtikelManager getThis() throws PersistenceException ;
    
    

}

