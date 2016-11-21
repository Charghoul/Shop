package persistence;

import model.*;

public class KontoFacade{

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

	

	public KontoFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentKonto newKonto(long kontostand,long limit,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentKonto)PersistentProxi.createProxi(idCreateIfLessZero, 146);
        long id = ConnectionHandler.getTheConnectionHandler().theKontoFacade.getNextId();
        Konto result = new Konto(kontostand,limit,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentKonto)PersistentProxi.createProxi(id, 146);
    }
    
    public PersistentKonto newDelayedKonto(long kontostand,long limit) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theKontoFacade.getNextId();
        Konto result = new Konto(kontostand,limit,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentKonto)PersistentProxi.createProxi(id, 146);
    }
    
    public Konto getKonto(long KontoId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 146)) return 146;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void kontostandSet(long KontoId, long kontostandVal) throws PersistenceException {
        
    }
    public void limitSet(long KontoId, long limitVal) throws PersistenceException {
        
    }
    public void subServiceSet(long KontoId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long KontoId, Konto4Public ThisVal) throws PersistenceException {
        
    }

}

