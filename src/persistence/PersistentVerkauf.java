package persistence;


public interface PersistentVerkauf extends PersistentArtikelstatus, Verkauf4Public {
    
    public PersistentVerkauf getThis() throws PersistenceException ;
    
    

}

