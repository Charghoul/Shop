package persistence;



import model.visitor.*;

public class LieferungICProxi extends PersistentInCacheProxiOptimistic implements PersistentLieferung{
    
    public LieferungICProxi(long objectId) {
        super(objectId);
    }
    public LieferungICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLieferungFacade
            .getLieferung(this.getId());
    }
    
    public long getClassId() {
        return 150;
    }
    
    public Bestellung4Public getBestellung() throws PersistenceException {
        return ((PersistentLieferung)this.getTheObject()).getBestellung();
    }
    public void setBestellung(Bestellung4Public newValue) throws PersistenceException {
        ((PersistentLieferung)this.getTheObject()).setBestellung(newValue);
    }
    public Lieferart4Public getLieferart() throws PersistenceException {
        return ((PersistentLieferung)this.getTheObject()).getLieferart();
    }
    public void setLieferart(Lieferart4Public newValue) throws PersistenceException {
        ((PersistentLieferung)this.getTheObject()).setLieferart(newValue);
    }
    public long getLieferversuche() throws PersistenceException {
        return ((PersistentLieferung)this.getTheObject()).getLieferversuche();
    }
    public void setLieferversuche(long newValue) throws PersistenceException {
        ((PersistentLieferung)this.getTheObject()).setLieferversuche(newValue);
    }
    public PersistentLieferung getThis() throws PersistenceException {
        return ((PersistentLieferung)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferung(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferung)this.getTheObject()).initializeOnInstantiation();
    }

    
}
