package persistence;

import model.*;

public class WarenlagerFacade{

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

	

	public WarenlagerFacade() {
	}

    public PersistentWarenlager getTheWarenlager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade.getNextId();
        Warenlager result = new Warenlager(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentWarenlager)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 193);
    }
    
    public Warenlager getWarenlager(long WarenlagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 193)) return 193;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long warenListeAdd(long WarenlagerId, Position4Public warenListeVal) throws PersistenceException {
        return 0;
    }
    public void warenListeRem(long warenListeId) throws PersistenceException {
        
    }
    public PositionList warenListeGet(long WarenlagerId) throws PersistenceException {
        return new PositionList(); // remote access for initialization only!
    }
    public void subServiceSet(long WarenlagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long WarenlagerId, Warenlager4Public ThisVal) throws PersistenceException {
        
    }

}

