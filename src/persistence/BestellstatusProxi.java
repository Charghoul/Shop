package persistence;



public abstract class BestellstatusProxi extends PersistentProxi implements PersistentBestellstatus{
    
    public BestellstatusProxi(long objectId) {
        super(objectId);
    }
    public BestellstatusProxi(PersistentInCacheProxi object) {
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
