package persistence;


public interface PersistentServiceKunde extends PersistentService, ServiceKunde4Public {
    
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException ;
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException ;
    public PersistentServiceKunde getThis() throws PersistenceException ;
    
    

}

