package persistence;



import model.visitor.*;

public class LieferartICProxi extends PersistentInCacheProxiOptimistic implements PersistentLieferart{
    
    public LieferartICProxi(long objectId) {
        super(objectId);
    }
    public LieferartICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLieferartFacade
            .getLieferart(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setName(newValue);
    }
    public long getLieferzeit() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getLieferzeit();
    }
    public void setLieferzeit(long newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setLieferzeit(newValue);
    }
    public common.Fraction getPreis() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getPreis();
    }
    public void setPreis(common.Fraction newValue) throws PersistenceException {
        ((PersistentLieferart)this.getTheObject()).setPreis(newValue);
    }
    public PersistentLieferart getThis() throws PersistenceException {
        return ((PersistentLieferart)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferart(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferart(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void aendereLieferart(final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferart)this.getTheObject()).aendereLieferart(name, lieferzeit, preis);
    }
    public BooleanX4Public alreadyExists(final String name) 
				throws PersistenceException{
        return ((PersistentLieferart)this.getTheObject()).alreadyExists(name);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferart)this.getTheObject()).initializeOnInstantiation();
    }

    
}
