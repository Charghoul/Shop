package persistence;

import model.*;

public class ServiceAdminFacade{



	public ServiceAdminFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServiceAdmin newServiceAdmin(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentServiceAdmin)PersistentProxi.createProxi(idCreateIfLessZero, -182);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceAdmin result = new ServiceAdmin(null,null,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceAdmin)PersistentProxi.createProxi(id, -182);
    }
    
    public PersistentServiceAdmin newDelayedServiceAdmin() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        ServiceAdmin result = new ServiceAdmin(null,null,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServiceAdmin)PersistentProxi.createProxi(id, -182);
    }
    
    public ServiceAdmin getServiceAdmin(long ServiceAdminId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void warenlagerSet(long ServiceAdminId, Warenlager4Public warenlagerVal) throws PersistenceException {
        
    }
    public void artikelManagerSet(long ServiceAdminId, ArtikelManager4Public artikelManagerVal) throws PersistenceException {
        
    }
    public void lieferartManagerSet(long ServiceAdminId, LieferartManager4Public lieferartManagerVal) throws PersistenceException {
        
    }
    public void herstellerManagerSet(long ServiceAdminId, HerstellerManager4Public herstellerManagerVal) throws PersistenceException {
        
    }
    public void zeitManagerSet(long ServiceAdminId, ServiceAdminZeitManager4Public zeitManagerVal) throws PersistenceException {
        
    }
    public ServiceAdminSearchList inverseGetHerstellerManager(long objectId, long classId)throws PersistenceException{
        ServiceAdminSearchList result = new ServiceAdminSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(-182);
        while (candidates.hasNext()){
            PersistentServiceAdmin current = (PersistentServiceAdmin)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getHerstellerManager() != null){
                if (current.getHerstellerManager().getClassId() == classId && current.getHerstellerManager().getId() == objectId) {
                    PersistentServiceAdmin proxi = (PersistentServiceAdmin)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentServiceAdmin)proxi.getThis());
                }
            }
        }
        return result;
    }

}

