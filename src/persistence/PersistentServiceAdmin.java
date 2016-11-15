package persistence;


public interface PersistentServiceAdmin extends PersistentService, ServiceAdmin4Public {
    
    public Warenlager4Public getWarenlager() throws PersistenceException ;
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException ;
    public ArtikelManager4Public getArtikelManager() throws PersistenceException ;
    public void setArtikelManager(ArtikelManager4Public newValue) throws PersistenceException ;
    public LieferartManager4Public getLieferartManager() throws PersistenceException ;
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException ;
    public HerstellerManager4Public getHerstellerManager() throws PersistenceException ;
    public void setHerstellerManager(HerstellerManager4Public newValue) throws PersistenceException ;
    public PersistentServiceAdmin getThis() throws PersistenceException ;
    
    

}

