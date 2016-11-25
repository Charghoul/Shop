package persistence;

import model.*;

public class ServiceKundeFacade{



	public ServiceKundeFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceKunde newServiceKunde(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentServiceKunde)PersistentProxi.createProxi(idCreateIfLessZero, -181);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceKunde result = new ServiceKunde(null,null,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceKunde)PersistentProxi.createProxi(id, -181);
    }
    
    public PersistentServiceKunde newDelayedServiceKunde() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceKunde result = new ServiceKunde(null,null,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceKunde)PersistentProxi.createProxi(id, -181);
    }
    
    public ServiceKunde getServiceKunde(long ServiceKundeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void warenlagerSet(long ServiceKundeId, ServiceKundeWarenlager4Public warenlagerVal) throws PersistenceException {
        
    }
    public void kontoSet(long ServiceKundeId, Konto4Public kontoVal) throws PersistenceException {
        
    }
    public void einkaufsManagerSet(long ServiceKundeId, EinkaufsManager4Public einkaufsManagerVal) throws PersistenceException {
        
    }
    public void lieferartManagerSet(long ServiceKundeId, LieferartManager4Public lieferartManagerVal) throws PersistenceException {
        
    }
    public void bestellManagerSet(long ServiceKundeId, ServiceKundeBestellManager4Public bestellManagerVal) throws PersistenceException {
        
    }
    public ServiceKundeSearchList inverseGetKonto(long objectId, long classId)throws PersistenceException{
        ServiceKundeSearchList result = new ServiceKundeSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(-181);
        while (candidates.hasNext()){
            PersistentServiceKunde current = (PersistentServiceKunde)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getKonto() != null){
                if (current.getKonto().getClassId() == classId && current.getKonto().getId() == objectId) {
                    PersistentServiceKunde proxi = (PersistentServiceKunde)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentServiceKunde)proxi.getThis());
                }
            }
        }
        return result;
    }
    public ServiceKundeSearchList inverseGetEinkaufsManager(long objectId, long classId)throws PersistenceException{
        ServiceKundeSearchList result = new ServiceKundeSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(-181);
        while (candidates.hasNext()){
            PersistentServiceKunde current = (PersistentServiceKunde)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getEinkaufsManager() != null){
                if (current.getEinkaufsManager().getClassId() == classId && current.getEinkaufsManager().getId() == objectId) {
                    PersistentServiceKunde proxi = (PersistentServiceKunde)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentServiceKunde)proxi.getThis());
                }
            }
        }
        return result;
    }

}

