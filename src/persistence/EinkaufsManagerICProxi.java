package persistence;



import model.visitor.*;

public class EinkaufsManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentEinkaufsManager{
    
    public EinkaufsManagerICProxi(long objectId) {
        super(objectId);
    }
    public EinkaufsManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
            .getEinkaufsManager(this.getId());
    }
    
    public long getClassId() {
        return 191;
    }
    
    public EinkaufsManager_EinkaufsListeProxi getEinkaufsListe() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getEinkaufsListe();
    }
    public PersistentEinkaufsManager getThis() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEinkaufsManager(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ServiceKunde4Public inverseGetEinkaufsManager() 
				throws PersistenceException{
        return ((PersistentEinkaufsManager)this.getTheObject()).inverseGetEinkaufsManager();
    }
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).aendereMenge(position, menge);
    }
    public void bestellen() 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).bestellen();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neuePosition(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelAlreadyExists, model.UserException, PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).neuePosition(artikel, menge);
    }

    
}
