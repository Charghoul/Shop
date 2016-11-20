package persistence;


public interface PersistentBestellstatus extends Anything, SubjInterface, AbstractPersistentProxi, Bestellstatus4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentBestellstatus getThis() throws PersistenceException ;
    
    

}

