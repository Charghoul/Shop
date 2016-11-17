package persistence;



public abstract class LieferungProxi extends ZeitObjektProxi implements PersistentLieferung{
    
    public LieferungProxi(long objectId) {
        super(objectId);
    }
    public LieferungProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentLieferung getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void handleTimeElapsed() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).handleTimeElapsed();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initializeOnInstantiation();
    }
    public void reduceTime() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).reduceTime();
    }

    
}
