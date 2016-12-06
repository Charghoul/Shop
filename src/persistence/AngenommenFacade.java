package persistence;

import model.*;

public class AngenommenFacade{



	public AngenommenFacade() {
	}

    public PersistentAngenommen getTheAngenommen() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellstatusFacade.getNextId();
        Angenommen result = new Angenommen(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentAngenommen)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 134);
    }
    
    public Angenommen getAngenommen(long AngenommenId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

