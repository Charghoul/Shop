package persistence;


public interface PersistentServiceAdmin extends PersistentServiceShop, ServiceAdmin4Public {
    
    public void setKundenManager(ServiceAdminKundenManager4Public newValue) throws PersistenceException ;
    public Warenlager4Public getWarenlager() throws PersistenceException ;
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException ;
    public ArtikelManager4Public getArtikelManager() throws PersistenceException ;
    public void setArtikelManager(ArtikelManager4Public newValue) throws PersistenceException ;
    public LieferartManager4Public getLieferartManager() throws PersistenceException ;
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException ;
    public HerstellerManager4Public getHerstellerManager() throws PersistenceException ;
    public void setHerstellerManager(HerstellerManager4Public newValue) throws PersistenceException ;
    public void setZeitManager(ServiceAdminZeitManager4Public newValue) throws PersistenceException ;
    public PersistentServiceAdmin getThis() throws PersistenceException ;
    
    
    public KundenManager4Public getKundenManager() 
				throws PersistenceException;
    public ZeitManager4Public getZeitManager() 
				throws PersistenceException;
    public void setKundenManager(final KundenManager4Public kundenManager) 
				throws PersistenceException;
    public void setZeitManager(final ZeitManager4Public zeitManager) 
				throws PersistenceException;
    public void kundenManager_update(final model.meta.KundenManagerMssgs event) 
				throws PersistenceException;
    public void zeitManager_update(final model.meta.ZeitManagerMssgs event) 
				throws PersistenceException;

}

