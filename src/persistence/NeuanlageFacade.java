package persistence;

import model.*;

public class NeuanlageFacade{



	public NeuanlageFacade() {
	}

    public PersistentNeuanlage getTheNeuanlage() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.getNextId();
        Neuanlage result = new Neuanlage(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNeuanlage)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 214);
    }
    
    public Neuanlage getNeuanlage(long NeuanlageId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

