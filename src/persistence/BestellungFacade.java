package persistence;

import model.*;

public class BestellungFacade{

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

	

	public BestellungFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentBestellung newBestellung(long bestellID,long warenwert,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentBestellung)PersistentProxi.createProxi(idCreateIfLessZero, 136);
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungFacade.getNextId();
        Bestellung result = new Bestellung(null,null,bestellID,warenwert,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBestellung)PersistentProxi.createProxi(id, 136);
    }
    
    public PersistentBestellung newDelayedBestellung(long bestellID,long warenwert) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungFacade.getNextId();
        Bestellung result = new Bestellung(null,null,bestellID,warenwert,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBestellung)PersistentProxi.createProxi(id, 136);
    }
    
    public Bestellung getBestellung(long BestellungId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 136)) return 136;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public BestellungSearchList getBestellungByBestellID(long bestellID) throws PersistenceException {
        BestellungSearchList result = new BestellungSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(136);
        while (candidates.hasNext()){
            PersistentBestellung current = (PersistentBestellung)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getBestellID() == bestellID)
                result.add((PersistentBestellung)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public long positionsListeAdd(long BestellungId, PositionInBestellung4Public positionsListeVal) throws PersistenceException {
        return 0;
    }
    public void positionsListeRem(long positionsListeId) throws PersistenceException {
        
    }
    public PositionInBestellungList positionsListeGet(long BestellungId) throws PersistenceException {
        return new PositionInBestellungList(); // remote access for initialization only!
    }
    public void bestellManagerSet(long BestellungId, BestellManager4Public bestellManagerVal) throws PersistenceException {
        
    }
    public void kndLieferungSet(long BestellungId, KndLieferung4Public kndLieferungVal) throws PersistenceException {
        
    }
    public void bestellIDSet(long BestellungId, long bestellIDVal) throws PersistenceException {
        
    }
    public void warenwertSet(long BestellungId, long warenwertVal) throws PersistenceException {
        
    }
    public void bestellstatusSet(long BestellungId, Bestellstatus4Public bestellstatusVal) throws PersistenceException {
        
    }
    public void lieferartSet(long BestellungId, Lieferart4Public lieferartVal) throws PersistenceException {
        
    }
    public void subServiceSet(long BestellungId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long BestellungId, Bestellung4Public ThisVal) throws PersistenceException {
        
    }

}

