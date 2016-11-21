package persistence;


public interface PersistentWarenlager extends Anything, SubjInterface, AbstractPersistentProxi, Warenlager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentWarenlager getThis() throws PersistenceException ;
    
    

}

