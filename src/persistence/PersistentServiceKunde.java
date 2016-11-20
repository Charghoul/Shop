package persistence;


public interface PersistentServiceKunde extends PersistentServiceShop, ServiceKunde4Public {
    
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException ;
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException ;
    public LieferartManager4Public getLieferartManager() throws PersistenceException ;
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException ;
    public void setBestellManager(ServiceKundeBestellManager4Public newValue) throws PersistenceException ;
    public PersistentServiceKunde getThis() throws PersistenceException ;
    
    
    public BestellManager4Public getBestellManager() 
				throws PersistenceException;
    public void setBestellManager(final BestellManager4Public bestellManager) 
				throws PersistenceException;
    public void bestellManager_update(final model.meta.BestellManagerMssgs event) 
				throws PersistenceException;

}

