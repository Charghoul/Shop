package persistence;



public abstract class BestellstatusICProxi extends PersistentInCacheProxiOptimistic implements PersistentBestellstatus{
    
    public BestellstatusICProxi(long objectId) {
        super(objectId);
    }
    public BestellstatusICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentBestellstatus getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBestellstatus)this.getTheObject()).initialize(This, final$$Fields);
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
