package persistence;


public interface PersistentLieferartManager extends Anything, SubjInterface, AbstractPersistentProxi, LieferartManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentLieferartManager getThis() throws PersistenceException ;
    
    

}

