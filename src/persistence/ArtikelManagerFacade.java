package persistence;

import model.*;

public class ArtikelManagerFacade{

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

	

	public ArtikelManagerFacade() {
	}

    public PersistentArtikelManager getTheArtikelManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.getNextId();
        ArtikelManager result = new ArtikelManager(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentArtikelManager)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 228);
    }
    
    public ArtikelManager getArtikelManager(long ArtikelManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 228)) return 228;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long artikelListeAdd(long ArtikelManagerId, Artikel4Public artikelListeVal) throws PersistenceException {
        return 0;
    }
    public void artikelListeRem(long artikelListeId) throws PersistenceException {
        
    }
    public ArtikelList artikelListeGet(long ArtikelManagerId) throws PersistenceException {
        return new ArtikelList(); // remote access for initialization only!
    }
    public void subServiceSet(long ArtikelManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ArtikelManagerId, ArtikelManager4Public ThisVal) throws PersistenceException {
        
    }

}

