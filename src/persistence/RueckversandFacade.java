package persistence;

import model.*;

public class RueckversandFacade{



	public RueckversandFacade() {
	}

    public PersistentRueckversand getTheRueckversand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellstatusFacade.getNextId();
        Rueckversand result = new Rueckversand(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentRueckversand)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 169);
    }
    
    public Rueckversand getRueckversand(long RueckversandId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

