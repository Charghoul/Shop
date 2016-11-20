package persistence;

import model.*;

public class ServiceRegisterFacade{



	public ServiceRegisterFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceRegister newServiceRegister(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentServiceRegister)PersistentProxi.createProxi(idCreateIfLessZero, -189);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceRegister result = new ServiceRegister(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceRegister)PersistentProxi.createProxi(id, -189);
    }
    
    public PersistentServiceRegister newDelayedServiceRegister() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceRegister result = new ServiceRegister(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceRegister)PersistentProxi.createProxi(id, -189);
    }
    
    public ServiceRegister getServiceRegister(long ServiceRegisterId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

