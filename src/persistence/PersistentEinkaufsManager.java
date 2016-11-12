package persistence;


public interface PersistentEinkaufsManager extends Anything, AbstractPersistentProxi, EinkaufsManager4Public {
    
    public EinkaufsManager_EinkaufsListeProxi getEinkaufsListe() throws PersistenceException ;
    public PersistentEinkaufsManager getThis() throws PersistenceException ;
    
    
    public ServiceKunde4Public inverseGetEinkaufsManager() 
				throws PersistenceException;

}

