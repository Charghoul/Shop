package persistence;

import model.*;

public class LieferartFacade{

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

	

	public LieferartFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentLieferart newLieferart(String name,long lieferzeit,long preis,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentLieferart)PersistentProxi.createProxi(idCreateIfLessZero, 138);
        long id = ConnectionHandler.getTheConnectionHandler().theLieferartFacade.getNextId();
        Lieferart result = new Lieferart(name,lieferzeit,preis,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentLieferart)PersistentProxi.createProxi(id, 138);
    }
    
    public PersistentLieferart newDelayedLieferart(String name,long lieferzeit,long preis) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theLieferartFacade.getNextId();
        Lieferart result = new Lieferart(name,lieferzeit,preis,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentLieferart)PersistentProxi.createProxi(id, 138);
    }
    
    public Lieferart getLieferart(long LieferartId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 138)) return 138;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public LieferartSearchList getLieferartByName(String name) throws PersistenceException {
        name = name.replaceAll("%", ".*");
        name = name.replaceAll("_", ".");
        LieferartSearchList result = new LieferartSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(138);
        while (candidates.hasNext()){
            PersistentLieferart current = (PersistentLieferart)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentLieferart)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long LieferartId, String nameVal) throws PersistenceException {
        
    }
    public void lieferzeitSet(long LieferartId, long lieferzeitVal) throws PersistenceException {
        
    }
    public void preisSet(long LieferartId, long preisVal) throws PersistenceException {
        
    }
    public void subServiceSet(long LieferartId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long LieferartId, Lieferart4Public ThisVal) throws PersistenceException {
        
    }

}

