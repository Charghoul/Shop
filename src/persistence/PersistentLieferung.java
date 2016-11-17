package persistence;


public interface PersistentLieferung extends PersistentZeitObjekt, Lieferung4Public {
    
    public abstract PersistentLieferung getThis() throws PersistenceException ;
    
    

}

