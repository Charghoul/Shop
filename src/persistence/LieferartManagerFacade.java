package persistence;

import model.*;

public class LieferartManagerFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public LieferartManagerFacade() {
	}

    public PersistentLieferartManager getTheLieferartManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.getNextId();
        LieferartManager result = new LieferartManager(0, null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentLieferartManager)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 171);
    }
    
    public LieferartManager getLieferartManager(long LieferartManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 171)) return 171;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long lieferartenListeAdd(long LieferartManagerId, Lieferart4Public lieferartenListeVal) throws PersistenceException {
        return 0;
    }
    public void lieferartenListeRem(long lieferartenListeId) throws PersistenceException {
        
    }
    public LieferartList lieferartenListeGet(long LieferartManagerId) throws PersistenceException {
        return new LieferartList(); // remote access for initialization only!
    }
    public void rueckversandGebuehrSet(long LieferartManagerId, long rueckversandGebuehrVal) throws PersistenceException {
        
    }
    public void subServiceSet(long LieferartManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long LieferartManagerId, LieferartManager4Public ThisVal) throws PersistenceException {
        
    }

}

