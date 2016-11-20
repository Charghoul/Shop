package persistence;

import model.*;

public class VorbestellungFacade{



	public VorbestellungFacade() {
	}

    public PersistentVorbestellung getTheVorbestellung() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBestellstatusFacade.getNextId();
        Vorbestellung result = new Vorbestellung(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentVorbestellung)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 216);
    }
    
    public Vorbestellung getVorbestellung(long VorbestellungId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

