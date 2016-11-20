package persistence;

import model.*;

public class GeliefertFacade{



	public GeliefertFacade() {
	}

    public PersistentGeliefert getTheGeliefert() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellstatusFacade.getNextId();
        Geliefert result = new Geliefert(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentGeliefert)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 215);
    }
    
    public Geliefert getGeliefert(long GeliefertId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

