package persistence;


public interface PersistentServiceKunde extends PersistentService, ServiceKunde4Public {
    
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException ;
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException ;
    public ArtikelManager4Public getArtikelManager() throws PersistenceException ;
    public void setArtikelManager(ArtikelManager4Public newValue) throws PersistenceException ;
    public Warenlager4Public getWarenlager() throws PersistenceException ;
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException ;
    public PersistentServiceKunde getThis() throws PersistenceException ;
    
    

}

