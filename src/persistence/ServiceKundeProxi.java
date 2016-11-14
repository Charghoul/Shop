package persistence;



import model.visitor.*;

public class ServiceKundeProxi extends ServiceProxi implements PersistentServiceKunde{
    
    public ServiceKundeProxi(long objectId) {
        super(objectId);
    }
    public ServiceKundeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -181;
    }
    
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getEinkaufsManager();
    }
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setEinkaufsManager(newValue);
    }
    public Warenlager4Public getWarenlager() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getWarenlager();
    }
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setWarenlager(newValue);
    }
    public PersistentServiceKunde getThis() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceKunde(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String serviceKunde_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).serviceKunde_Menu_Filter(anything);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).signalChanged(signal);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).initializeOnInstantiation();
    }
    public void neuePosition(final EinkaufsManager4Public einkaufsManager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).neuePosition(einkaufsManager, artikel, menge);
    }

    
}
