package persistence;

import model.meta.*;

public class RegisterCommandFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public RegisterCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRegisterCommand newRegisterCommand(String username,String passwort,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentRegisterCommand)PersistentProxi.createProxi(idCreateIfLessZero, 109);
        long id = ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.getNextId();
        RegisterCommand result = new RegisterCommand(username,passwort,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentRegisterCommand)PersistentProxi.createProxi(id, 109);
    }
    
    public PersistentRegisterCommand newDelayedRegisterCommand(String username,String passwort) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.getNextId();
        RegisterCommand result = new RegisterCommand(username,passwort,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentRegisterCommand)PersistentProxi.createProxi(id, 109);
    }
    
    public RegisterCommand getRegisterCommand(long RegisterCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 109)) return 109;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void usernameSet(long RegisterCommandId, String usernameVal) throws PersistenceException {
        
    }
    public void passwortSet(long RegisterCommandId, String passwortVal) throws PersistenceException {
        
    }
    public void invokerSet(long RegisterCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RegisterCommandId, ServiceRegister4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RegisterCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

