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
        if(Cache.getTheCache().contains(objectId, 311)) return 311;
        if(Cache.getTheCache().contains(objectId, 215)) return 215;
        if(Cache.getTheCache().contains(objectId, 217)) return 217;
        if(Cache.getTheCache().contains(objectId, 218)) return 218;
        if(Cache.getTheCache().contains(objectId, 219)) return 219;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long BestellstatusId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long BestellstatusId, Bestellstatus4Public ThisVal) throws PersistenceException {
        
    }

}

