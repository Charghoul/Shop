package persistence;



import model.visitor.*;

public class PositionICProxi extends PositionAbstraktICProxi implements PersistentPosition{
    
    public PositionICProxi(long objectId) {
        super(objectId);
    }
    public PositionICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .getPosition(this.getId());
    }
    
    public long getClassId() {
        return 125;
    }
    
    public PersistentPosition getThis() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getThis();
    }
    
    public void accept(PositionAbstraktVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(PositionAbstraktReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(PositionAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(PositionAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).updateObservers(event);
    }
    public void aendereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentPosition)this.getTheObject()).aendereMenge(menge);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void entfernePosition(final EinkaufsManager4Public einkaufsManager) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).entfernePosition(einkaufsManager);
    }
    public void erhoeheMenge(final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentPosition)this.getTheObject()).erhoeheMenge(menge);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnInstantiation();
    }
    public void verringereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException{
        ((PersistentPosition)this.getTheObject()).verringereMenge(menge);
    }

    
}
