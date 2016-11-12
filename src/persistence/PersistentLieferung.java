package persistence;


public interface PersistentLieferung extends Anything, AbstractPersistentProxi, Lieferung4Public {
    
    public void setBestellung(Bestellung4Public newValue) throws PersistenceException ;
    public void setLieferart(Lieferart4Public newValue) throws PersistenceException ;
    public long getLieferversuche() throws PersistenceException ;
    public void setLieferversuche(long newValue) throws PersistenceException ;
    public PersistentLieferung getThis() throws PersistenceException ;
    
    

}

