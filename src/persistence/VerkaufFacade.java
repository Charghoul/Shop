package persistence;

import model.*;

public class VerkaufFacade{



	public VerkaufFacade() {
	}

    public PersistentVerkauf getTheVerkauf() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.getNextId();
        Verkauf result = new Verkauf(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentVerkauf)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 212);
    }
    
    public Verkauf getVerkauf(long VerkaufId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

