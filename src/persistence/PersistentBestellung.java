package persistence;


public interface PersistentBestellung extends Anything, AbstractPersistentProxi, Bestellung4Public {
    
    public String getID() throws PersistenceException ;
    public void setID(String newValue) throws PersistenceException ;
    public Bestellstatus4Public getBestellstatus() throws PersistenceException ;
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException ;
    public PersistentBestellung getThis() throws PersistenceException ;
    
    

}

