package persistence;

import model.*;

public class HinversandFacade{



	public HinversandFacade() {
	}

    public PersistentHinversand getTheHinversand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellstatusFacade.getNextId();
        Hinversand result = new Hinversand(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentHinversand)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 172);
    }
    
    public Hinversand getHinversand(long HinversandId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

