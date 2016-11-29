package persistence;



public class ArtikelstatusFacade{

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

	

	public ArtikelstatusFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 214)) return 214;
        if(Cache.getTheCache().contains(objectId, 212)) return 212;
        if(Cache.getTheCache().contains(objectId, 213)) return 213;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long ArtikelstatusId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ArtikelstatusId, Artikelstatus4Public ThisVal) throws PersistenceException {
        
    }

}

