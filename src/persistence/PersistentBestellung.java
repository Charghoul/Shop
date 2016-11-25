package persistence;


public interface PersistentBestellung extends PersistentBestellungAbstrakt, Bestellung4Public {
    
    public void setKndLieferung(KndLieferung4Public newValue) throws PersistenceException ;
    public long getBestellID() throws PersistenceException ;
    public void setBestellID(long newValue) throws PersistenceException ;
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException ;
    public PersistentBestellung getThis() throws PersistenceException ;
    
    

}

