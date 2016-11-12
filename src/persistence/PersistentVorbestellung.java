package persistence;


public interface PersistentVorbestellung extends PersistentBestellstatus, Vorbestellung4Public {
    
    public PersistentVorbestellung getThis() throws PersistenceException ;
    
    

}

