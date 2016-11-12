package persistence;



import model.visitor.*;

public class KundeICProxi extends PersistentInCacheProxiOptimistic implements PersistentKunde{
    
    public KundeICProxi(long objectId) {
        super(objectId);
    }
    public KundeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .getKunde(this.getId());
    }
    
    public long getClassId() {
        return 102;
    }
    
    public String getBenutzername() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getBenutzername();
    }
    public void setBenutzername(String newValue) throws PersistenceException {
        ((PersistentKunde)this.getTheObject()).setBenutzername(newValue);
    }
    public String getPasswort() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getPasswort();
    }
    public void setPasswort(String newValue) throws PersistenceException {
        ((PersistentKunde)this.getTheObject()).setPasswort(newValue);
    }
    public Konto4Public getKonto() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getKonto();
    }
    public void setKonto(Konto4Public newValue) throws PersistenceException {
        ((PersistentKunde)this.getTheObject()).setKonto(newValue);
    }
    public PersistentKunde getThis() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initializeOnInstantiation();
    }

    
}
