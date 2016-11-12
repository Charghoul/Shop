package persistence;



import model.visitor.*;

public class PositionProxi extends PersistentProxi implements PersistentPosition{
    
    public PositionProxi(long objectId) {
        super(objectId);
    }
    public PositionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 144;
    }
    
    public Artikel4Public getArtikel() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getArtikel();
    }
    public void setArtikel(Artikel4Public newValue) throws PersistenceException {
        ((PersistentPosition)this.getTheObject()).setArtikel(newValue);
    }
    public long getMenge() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getMenge();
    }
    public void setMenge(long newValue) throws PersistenceException {
        ((PersistentPosition)this.getTheObject()).setMenge(newValue);
    }
    public PersistentPosition getThis() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getThis();
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
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnInstantiation();
    }

    
}
