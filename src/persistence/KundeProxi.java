package persistence;



import model.visitor.*;

public class KundeProxi extends PersistentProxi implements PersistentKunde{
    
    public KundeProxi(long objectId) {
        super(objectId);
    }
    public KundeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 349;
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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentKunde)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentKunde)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKunde(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKunde(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentKunde)this.getTheObject()).updateObservers(event);
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
