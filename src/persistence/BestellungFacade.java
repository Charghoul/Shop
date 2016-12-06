package persistence;

import model.*;

public class BestellungFacade{



	public BestellungFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentBestellung newBestellung(long warenwert,long bestellID,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentBestellung)PersistentProxi.createProxi(idCreateIfLessZero, 146);
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungAbstraktFacade.getNextId();
        Bestellung result = new Bestellung(null,warenwert,null,null,null,null,bestellID,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBestellung)PersistentProxi.createProxi(id, 146);
    }
    
    public PersistentBestellung newDelayedBestellung(long warenwert,long bestellID) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungAbstraktFacade.getNextId();
        Bestellung result = new Bestellung(null,warenwert,null,null,null,null,bestellID,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBestellung)PersistentProxi.createProxi(id, 146);
    }
    
    public Bestellung getBestellung(long BestellungId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public BestellungSearchList getBestellungByBestellID(long bestellID) throws PersistenceException {
        BestellungSearchList result = new BestellungSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(146);
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
    public void kndLieferungSet(long BestellungId, KndLieferung4Public kndLieferungVal) throws PersistenceException {
        
    }
    public void bestellIDSet(long BestellungId, long bestellIDVal) throws PersistenceException {
        
    }
    public void bestellstatusSet(long BestellungId, Bestellstatus4Public bestellstatusVal) throws PersistenceException {
        
    }

}

