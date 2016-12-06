package persistence;



public class ServiceFacade{

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

	

	public ServiceFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -112)) return -112;
        if(Cache.getTheCache().contains(objectId, -116)) return -116;
        if(Cache.getTheCache().contains(objectId, -127)) return -127;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long ServiceId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ServiceId, Service4Public ThisVal) throws PersistenceException {
        
    }

}

