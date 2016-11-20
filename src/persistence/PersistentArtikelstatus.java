package persistence;


public interface PersistentArtikelstatus extends Anything, SubjInterface, AbstractPersistentProxi, Artikelstatus4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentArtikelstatus getThis() throws PersistenceException ;
    
    

}

