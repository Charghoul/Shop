package persistence;


public interface PersistentLieferartManager extends Anything, SubjInterface, AbstractPersistentProxi, LieferartManager4Public {
    
    public void setRueckversandGebuehr(long newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentLieferartManager getThis() throws PersistenceException ;
    
    

}

