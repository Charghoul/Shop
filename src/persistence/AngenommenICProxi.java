package persistence;



import model.visitor.*;

public class AngenommenICProxi extends BestellstatusICProxi implements PersistentAngenommen{
    
    public AngenommenICProxi(long objectId) {
        super(objectId);
    }
    public AngenommenICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAngenommenFacade
            .getAngenommen(this.getId());
    }
    
    public long getClassId() {
        return 219;
    }
    
    public PersistentAngenommen getThis() throws PersistenceException {
        return ((PersistentAngenommen)this.getTheObject()).getThis();
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleAngenommen(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAngenommen(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAngenommen(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAngenommen(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAngenommen(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAngenommen(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAngenommen(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAngenommen(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAngenommen)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAngenommen)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAngenommen)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAngenommen)this.getTheObject()).initializeOnInstantiation();
    }

    
}
