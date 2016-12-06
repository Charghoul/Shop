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
        if(Cache.getTheCache().contains(objectId, 111)) return 111;
        if(Cache.getTheCache().contains(objectId, 142)) return 142;
        if(Cache.getTheCache().contains(objectId, 144)) return 144;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long ArtikelstatusId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ArtikelstatusId, Artikelstatus4Public ThisVal) throws PersistenceException {
        
    }

}

