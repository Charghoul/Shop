package persistence;



import model.visitor.*;

public class EinkaufsManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentEinkaufsManager{
    
    public EinkaufsManagerICProxi(long objectId) {
        super(objectId);
    }
    public EinkaufsManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
            .getEinkaufsManager(this.getId());
    }
    
    public long getClassId() {
        return 103;
    }
    
    public EinkaufsManager_EinkaufsListeProxi getEinkaufsListe() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getEinkaufsListe();
    }
    public BestellManager4Public getBestellManager() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getBestellManager();
    }
    public void setBestellManager(BestellManager4Public newValue) throws PersistenceException {
        ((PersistentEinkaufsManager)this.getTheObject()).setBestellManager(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentEinkaufsManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentEinkaufsManager getThis() throws PersistenceException {
        return ((PersistentEinkaufsManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEinkaufsManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEinkaufsManager(this);
    }
    
    
    public void bestellen(final Lieferart4Public lieferart, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).bestellen(lieferart, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).deregister(observee);
    }
    public ServiceKunde4Public getMyServiceKunde() 
				throws PersistenceException{
        return ((PersistentEinkaufsManager)this.getTheObject()).getMyServiceKunde();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).updateObservers(event);
    }
    public void vorbestellen(final Lieferart4Public lieferart, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).vorbestellen(lieferart, invoker);
    }
    public void bestellen(final Lieferart4Public lieferart) 
				throws model.ExcWarenwertUeberKontoguthaben, model.ExcArtikelNichtVerfuegbar, PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).bestellen(lieferart);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).entfernePosition(position);
    }
    public long gibGesamtPreis() 
				throws PersistenceException{
        return ((PersistentEinkaufsManager)this.getTheObject()).gibGesamtPreis();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neuePosition(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelAlreadyExists, model.ExcArtikelNochNichtVerfuegbar, model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).neuePosition(artikel, menge);
    }
    public void vorbestellen(final Lieferart4Public lieferart) 
				throws model.ExcWarenwertUeberKontoguthaben, PersistenceException{
        ((PersistentEinkaufsManager)this.getTheObject()).vorbestellen(lieferart);
    }

    
}
