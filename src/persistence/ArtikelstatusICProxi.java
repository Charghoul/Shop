package persistence;



public abstract class ArtikelstatusICProxi extends PersistentInCacheProxiOptimistic implements PersistentArtikelstatus{
    
    public ArtikelstatusICProxi(long objectId) {
        super(objectId);
    }
    public ArtikelstatusICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentArtikelstatus)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentArtikelstatus)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentArtikelstatus getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).initializeOnInstantiation();
    }

    
}
