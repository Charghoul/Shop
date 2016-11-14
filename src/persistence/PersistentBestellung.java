package persistence;


public interface PersistentBestellung extends Anything, AbstractPersistentProxi, Bestellung4Public {
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException ;
    public String getBestellID() throws PersistenceException ;
    public void setBestellID(String newValue) throws PersistenceException ;
    public Bestellstatus4Public getBestellstatus() throws PersistenceException ;
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException ;
    public PersistentBestellung getThis() throws PersistenceException ;
    
    

}

