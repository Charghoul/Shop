package persistence;



import model.visitor.*;

public class VerkaufICProxi extends ArtikelstatusICProxi implements PersistentVerkauf{
    
    public VerkaufICProxi(long objectId) {
        super(objectId);
    }
    public VerkaufICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
            .getVerkauf(this.getId());
    }
    
    public long getClassId() {
        return 212;
    }
    
    public PersistentVerkauf getThis() throws PersistenceException {
        return ((PersistentVerkauf)this.getTheObject()).getThis();
    }
    
    public void accept(ArtikelstatusVisitor visitor) throws PersistenceException {
        visitor.handleVerkauf(this);
    }
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVerkauf(this);
    }
    public <E extends model.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVerkauf(this);
    }
    public <R, E extends model.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVerkauf(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleVerkauf(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVerkauf(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVerkauf(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVerkauf(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentVerkauf)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentVerkauf)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentVerkauf)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentVerkauf)this.getTheObject()).initializeOnInstantiation();
    }

    
}
