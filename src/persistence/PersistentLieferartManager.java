package persistence;


public interface PersistentLieferartManager extends Anything, AbstractPersistentProxi, LieferartManager4Public {
    
    public LieferartManager_LieferartenListeProxi getLieferartenListe() throws PersistenceException ;
    public PersistentLieferartManager getThis() throws PersistenceException ;
    
    
    public ServiceAdmin4Public getMyService() 
				throws PersistenceException;

}

