package persistence;



import model.visitor.*;

public class HinversandICProxi extends BestellstatusICProxi implements PersistentHinversand{
    
    public HinversandICProxi(long objectId) {
        super(objectId);
    }
    public HinversandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theHinversandFacade
            .getHinversand(this.getId());
    }
    
    public long getClassId() {
        return 218;
    }
    
    public PersistentHinversand getThis() throws PersistenceException {
        return ((PersistentHinversand)this.getTheObject()).getThis();
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleHinversand(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleHinversand(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleHinversand(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleHinversand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleHinversand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleHinversand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleHinversand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleHinversand(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentHinversand)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentHinversand)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentHinversand)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentHinversand)this.getTheObject()).initializeOnInstantiation();
    }

    
}
