package persistence;



import model.visitor.*;

public class GeliefertProxi extends BestellstatusProxi implements PersistentGeliefert{
    
    public GeliefertProxi(long objectId) {
        super(objectId);
    }
    public GeliefertProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 215;
    }
    
    public PersistentGeliefert getThis() throws PersistenceException {
        return ((PersistentGeliefert)this.getTheObject()).getThis();
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGeliefert(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGeliefert(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGeliefert(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGeliefert(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGeliefert)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGeliefert)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGeliefert)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGeliefert)this.getTheObject()).initializeOnInstantiation();
    }

    
}
