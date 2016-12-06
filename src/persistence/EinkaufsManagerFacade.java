package persistence;

import model.*;

public class EinkaufsManagerFacade{

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

	

	public EinkaufsManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentEinkaufsManager newEinkaufsManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentEinkaufsManager)PersistentProxi.createProxi(idCreateIfLessZero, 103);
        long id = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.getNextId();
        EinkaufsManager result = new EinkaufsManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentEinkaufsManager)PersistentProxi.createProxi(id, 103);
    }
    
    public PersistentEinkaufsManager newDelayedEinkaufsManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.getNextId();
        EinkaufsManager result = new EinkaufsManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentEinkaufsManager)PersistentProxi.createProxi(id, 103);
    }
    
    public EinkaufsManager getEinkaufsManager(long EinkaufsManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 103)) return 103;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long einkaufsListeAdd(long EinkaufsManagerId, Position4Public einkaufsListeVal) throws PersistenceException {
        return 0;
    }
    public void einkaufsListeRem(long einkaufsListeId) throws PersistenceException {
        
    }
    public PositionList einkaufsListeGet(long EinkaufsManagerId) throws PersistenceException {
        return new PositionList(); // remote access for initialization only!
    }
    public void bestellManagerSet(long EinkaufsManagerId, BestellManager4Public bestellManagerVal) throws PersistenceException {
        
    }
    public void subServiceSet(long EinkaufsManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long EinkaufsManagerId, EinkaufsManager4Public ThisVal) throws PersistenceException {
        
    }

}

