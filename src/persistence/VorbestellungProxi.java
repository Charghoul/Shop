package persistence;



import model.visitor.*;

public class VorbestellungProxi extends BestellstatusProxi implements PersistentVorbestellung{
    
    public VorbestellungProxi(long objectId) {
        super(objectId);
    }
    public VorbestellungProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 216;
    }
    
    public PersistentVorbestellung getThis() throws PersistenceException {
        return ((PersistentVorbestellung)this.getTheObject()).getThis();
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initializeOnInstantiation();
    }

    
}
