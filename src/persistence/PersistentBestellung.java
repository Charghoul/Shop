package persistence;


public interface PersistentBestellung extends Anything, SubjInterface, AbstractPersistentProxi, Bestellung4Public {
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException ;
    public void setBestellManager(BestellManager4Public newValue) throws PersistenceException ;
    public long getBestellID() throws PersistenceException ;
    public void setBestellID(long newValue) throws PersistenceException ;
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentBestellung getThis() throws PersistenceException ;
    
    

}

