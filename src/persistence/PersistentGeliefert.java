package persistence;


public interface PersistentGeliefert extends PersistentBestellstatus, Geliefert4Public {
    
    public PersistentGeliefert getThis() throws PersistenceException ;
    
    

}

