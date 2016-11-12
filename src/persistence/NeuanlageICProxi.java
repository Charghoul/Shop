package persistence;



import model.visitor.*;

public class NeuanlageICProxi extends ArtikelstatusICProxi implements PersistentNeuanlage{
    
    public NeuanlageICProxi(long objectId) {
        super(objectId);
    }
    public NeuanlageICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNeuanlageFacade
            .getNeuanlage(this.getId());
    }
    
    public long getClassId() {
        return 214;
    }
    
    public PersistentNeuanlage getThis() throws PersistenceException {
        return ((PersistentNeuanlage)this.getTheObject()).getThis();
    }
    
    public void accept(ArtikelstatusVisitor visitor) throws PersistenceException {
        visitor.handleNeuanlage(this);
    }
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNeuanlage(this);
    }
    public <E extends model.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNeuanlage(this);
    }
    public <R, E extends model.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNeuanlage(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNeuanlage(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNeuanlage(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNeuanlage(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNeuanlage(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNeuanlage)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNeuanlage)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNeuanlage)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNeuanlage)this.getTheObject()).initializeOnInstantiation();
    }

    
}
