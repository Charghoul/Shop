package persistence;



public class BestellstatusFacade{

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

	

	public BestellstatusFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 134)) return 134;
        if(Cache.getTheCache().contains(objectId, 145)) return 145;
        if(Cache.getTheCache().contains(objectId, 154)) return 154;
        if(Cache.getTheCache().contains(objectId, 169)) return 169;
        if(Cache.getTheCache().contains(objectId, 172)) return 172;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long BestellstatusId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long BestellstatusId, Bestellstatus4Public ThisVal) throws PersistenceException {
        
    }

}

