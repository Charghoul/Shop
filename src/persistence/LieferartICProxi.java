package persistence;



import model.visitor.*;

public class LieferartICProxi extends PersistentInCacheProxiOptimistic implements PersistentLieferart{
    
    public LieferartICProxi(long objectId) {
        super(objectId);
    }
    public LieferartICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLieferartFacade
            .getLieferart(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setName(newValue);
    }
    public long getLieferzeit() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getLieferzeit();
    }
    public void setLieferzeit(long newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setLieferzeit(newValue);
    }
    public long getPreis() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getPreis();
    }
    public void setPreis(long newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setPreis(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setSubService(newValue);
    }
    public PersistentLieferart getThis() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferart(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferart(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferart(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferart(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).updateObservers(event);
    }
    public void aendereLieferart(final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferart)this.getTheObject()).aendereLieferart(lieferzeit, preis);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initializeOnInstantiation();
    }

    
}
