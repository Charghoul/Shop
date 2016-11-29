package persistence;

import model.*;

public class KundeFacade{

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

	

	public KundeFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentKunde newKunde(String benutzername,String passwort,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentKunde)PersistentProxi.createProxi(idCreateIfLessZero, 349);
        long id = ConnectionHandler.getTheConnectionHandler().theKundeFacade.getNextId();
        Kunde result = new Kunde(benutzername,passwort,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentKunde)PersistentProxi.createProxi(id, 349);
    }
    
    public PersistentKunde newDelayedKunde(String benutzername,String passwort) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theKundeFacade.getNextId();
        Kunde result = new Kunde(benutzername,passwort,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentKunde)PersistentProxi.createProxi(id, 349);
    }
    
    public Kunde getKunde(long KundeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 349)) return 349;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public KundeSearchList getKundeByBenutzername(String benutzername) throws PersistenceException {
        benutzername = benutzername.replaceAll("%", ".*");
        benutzername = benutzername.replaceAll("_", ".");
        KundeSearchList result = new KundeSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(349);
        while (candidates.hasNext()){
            PersistentKunde current = (PersistentKunde)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getBenutzername().matches(benutzername))
                result.add((PersistentKunde)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void benutzernameSet(long KundeId, String benutzernameVal) throws PersistenceException {
        
    }
    public void passwortSet(long KundeId, String passwortVal) throws PersistenceException {
        
    }
    public void subServiceSet(long KundeId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long KundeId, Kunde4Public ThisVal) throws PersistenceException {
        
    }

}

