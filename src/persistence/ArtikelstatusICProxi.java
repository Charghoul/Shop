package persistence;



public abstract class ArtikelstatusICProxi extends PersistentInCacheProxiOptimistic implements PersistentArtikelstatus{
    
    public ArtikelstatusICProxi(long objectId) {
        super(objectId);
    }
    public ArtikelstatusICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentArtikelstatus getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikelstatus)this.getTheObject()).initialize(This, final$$Fields);
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
