package persistence;



public abstract class BestellstatusICProxi extends PersistentInCacheProxiOptimistic implements PersistentBestellstatus{
    
    public BestellstatusICProxi(long objectId) {
        super(objectId);
    }
    public BestellstatusICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBestellstatus)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBestellstatus)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentBestellstatus getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).initializeOnInstantiation();
    }

    
}
