package persistence;

import model.*;

public class AuslaufFacade{



	public AuslaufFacade() {
	}

    public PersistentAuslauf getTheAuslauf() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.getNextId();
        Auslauf result = new Auslauf(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentAuslauf)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 213);
    }
    
    public Auslauf getAuslauf(long AuslaufId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

