package persistence;


public interface PersistentEinkaufsManager extends Anything, SubjInterface, AbstractPersistentProxi, EinkaufsManager4Public {
    
    public BestellManager4Public getBestellManager() throws PersistenceException ;
    public void setBestellManager(BestellManager4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentEinkaufsManager getThis() throws PersistenceException ;
    
    
    public ServiceKunde4Public getMyServiceKunde() 
				throws PersistenceException;

}

