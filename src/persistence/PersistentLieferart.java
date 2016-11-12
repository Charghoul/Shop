package persistence;


public interface PersistentLieferart extends Anything, AbstractPersistentProxi, Lieferart4Public {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public long getLieferzeit() throws PersistenceException ;
    public void setLieferzeit(long newValue) throws PersistenceException ;
    public common.Fraction getPreis() throws PersistenceException ;
    public void setPreis(common.Fraction newValue) throws PersistenceException ;
    public PersistentLieferart getThis() throws PersistenceException ;
    
    

}

