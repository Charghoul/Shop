package persistence;

import model.*;

public class PositionFacade{



	public PositionFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentPosition newPosition(long menge,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentPosition)PersistentProxi.createProxi(idCreateIfLessZero, 144);
        long id = ConnectionHandler.getTheConnectionHandler().thePositionAbstraktFacade.getNextId();
        Position result = new Position(null,menge,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentPosition)PersistentProxi.createProxi(id, 144);
    }
    
    public PersistentPosition newDelayedPosition(long menge) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thePositionAbstraktFacade.getNextId();
        Position result = new Position(null,menge,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentPosition)PersistentProxi.createProxi(id, 144);
    }
    
    public Position getPosition(long PositionId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

