package persistence;


public interface PersistentLieferart extends Anything, SubjInterface, AbstractPersistentProxi, Lieferart4Public {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public void setLieferzeit(long newValue) throws PersistenceException ;
    public void setPreis(long newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentLieferart getThis() throws PersistenceException ;
    
    

}

