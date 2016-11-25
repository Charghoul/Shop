package persistence;

import model.*;

public class VorbestellungFacade{



	public VorbestellungFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentVorbestellung newVorbestellung(long warenwert,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentVorbestellung)PersistentProxi.createProxi(idCreateIfLessZero, 216);
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungAbstraktFacade.getNextId();
        Vorbestellung result = new Vorbestellung(null,warenwert,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentVorbestellung)PersistentProxi.createProxi(id, 216);
    }
    
    public PersistentVorbestellung newDelayedVorbestellung(long warenwert) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellungAbstraktFacade.getNextId();
        Vorbestellung result = new Vorbestellung(null,warenwert,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentVorbestellung)PersistentProxi.createProxi(id, 216);
    }
    
    public Vorbestellung getVorbestellung(long VorbestellungId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long positionsListeAdd(long VorbestellungId, Position4Public positionsListeVal) throws PersistenceException {
        return 0;
    }
    public void positionsListeRem(long positionsListeId) throws PersistenceException {
        
    }
    public PositionList positionsListeGet(long VorbestellungId) throws PersistenceException {
        return new PositionList(); // remote access for initialization only!
    }

}

