package persistence;



import model.visitor.*;

public class KontoICProxi extends PersistentInCacheProxiOptimistic implements PersistentKonto{
    
    public KontoICProxi(long objectId) {
        super(objectId);
    }
    public KontoICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theKontoFacade
            .getKonto(this.getId());
    }
    
    public long getClassId() {
        return 146;
    }
    
    public common.Fraction getKontostand() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getKontostand();
    }
    public void setKontostand(common.Fraction newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setKontostand(newValue);
    }
    public common.Fraction getLimit() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getLimit();
    }
    public void setLimit(common.Fraction newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setLimit(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setSubService(newValue);
    }
    public PersistentKonto getThis() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initializeOnInstantiation();
    }

    
}
