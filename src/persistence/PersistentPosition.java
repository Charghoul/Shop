package persistence;


public interface PersistentPosition extends Anything, AbstractPersistentProxi, Position4Public {
    
    public Artikel4Public getArtikel() throws PersistenceException ;
    public void setArtikel(Artikel4Public newValue) throws PersistenceException ;
    public long getMenge() throws PersistenceException ;
    public void setMenge(long newValue) throws PersistenceException ;
    public PersistentPosition getThis() throws PersistenceException ;
    
    

}

