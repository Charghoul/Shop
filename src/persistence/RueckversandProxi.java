package persistence;



import model.visitor.*;

public class RueckversandProxi extends BestellstatusProxi implements PersistentRueckversand{
    
    public RueckversandProxi(long objectId) {
        super(objectId);
    }
    public RueckversandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 217;
    }
    
    public PersistentRueckversand getThis() throws PersistenceException {
        return ((PersistentRueckversand)this.getTheObject()).getThis();
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleRueckversand(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRueckversand(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRueckversand(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRueckversand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRueckversand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRueckversand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRueckversand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRueckversand(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentRueckversand)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentRueckversand)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentRueckversand)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentRueckversand)this.getTheObject()).initializeOnInstantiation();
    }

    
}
