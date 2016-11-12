package persistence;



public abstract class ArtikelstatusProxi extends PersistentProxi implements PersistentArtikelstatus{
    
    public ArtikelstatusProxi(long objectId) {
        super(objectId);
    }
    public ArtikelstatusProxi(PersistentInCacheProxi object) {
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
