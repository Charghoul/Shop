package persistence;



import model.visitor.*;

public class LieferartManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentLieferartManager{
    
    public LieferartManagerICProxi(long objectId) {
        super(objectId);
    }
    public LieferartManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
            .getLieferartManager(this.getId());
    }
    
    public long getClassId() {
        return 198;
    }
    
    public LieferartManager_LieferartenListeProxi getLieferartenListe() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getLieferartenListe();
    }
    public long getRueckversandGebuehr() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getRueckversandGebuehr();
    }
    public void setRueckversandGebuehr(long newValue) throws PersistenceException {
        ((PersistentLieferartManager)this.getTheObject()).setRueckversandGebuehr(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentLieferartManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentLieferartManager getThis() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferartManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferartManager(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).updateObservers(event);
    }
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).aendereLieferart(lieferart, name, lieferzeit, preis);
    }
    public void aendereRueckversandGebuehr(final long percent) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).aendereRueckversandGebuehr(percent);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neueLieferart(final String name, final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).neueLieferart(name, lieferzeit, preis);
    }

    
}
