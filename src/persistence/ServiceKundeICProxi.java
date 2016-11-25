package persistence;



import model.visitor.*;

public class ServiceKundeICProxi extends ServiceShopICProxi implements PersistentServiceKunde{
    
    public ServiceKundeICProxi(long objectId) {
        super(objectId);
    }
    public ServiceKundeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
            .getServiceKunde(this.getId());
    }
    
    public long getClassId() {
        return -181;
    }
    
    public void setWarenlager(ServiceKundeWarenlager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setWarenlager(newValue);
    }
    public Konto4Public getKonto() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getKonto();
    }
    public void setKonto(Konto4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setKonto(newValue);
    }
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getEinkaufsManager();
    }
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setEinkaufsManager(newValue);
    }
    public LieferartManager4Public getLieferartManager() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getLieferartManager();
    }
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setLieferartManager(newValue);
    }
    public void setBestellManager(ServiceKundeBestellManager4Public newValue) throws PersistenceException {
        ((PersistentServiceKunde)this.getTheObject()).setBestellManager(newValue);
    }
    public PersistentServiceKunde getThis() throws PersistenceException {
        return ((PersistentServiceKunde)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceShopVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceKunde(this);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    
    
    public ProduktKatalog4Public artikel_Path_In_NeuePosition() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).artikel_Path_In_NeuePosition();
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).deregister(observee);
    }
    public BestellManager4Public getBestellManager() 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).getBestellManager();
    }
    public ProduktKatalog4Public getProduktKatalog() 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).getProduktKatalog();
    }
    public Warenlager4Public getWarenlager() 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).getWarenlager();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public LieferartManager4Public lieferart_Path_In_Bestellen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).lieferart_Path_In_Bestellen();
    }
    public LieferartManager4Public lieferart_Path_In_Vorbestellen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).lieferart_Path_In_Vorbestellen();
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).register(observee);
    }
    public String serviceKunde_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentServiceKunde)this.getTheObject()).serviceKunde_Menu_Filter(anything);
    }
    public void setBestellManager(final BestellManager4Public bestellManager) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).setBestellManager(bestellManager);
    }
    public void setProduktKatalog(final ProduktKatalog4Public produktKatalog) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).setProduktKatalog(produktKatalog);
    }
    public void setWarenlager(final Warenlager4Public warenlager) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).setWarenlager(warenlager);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).updateObservers(event);
    }
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).aendereMenge(position, menge);
    }
    public void allesZuruecksenden(final Bestellung4Public bestellung) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).allesZuruecksenden(bestellung);
    }
    public void annehmen(final Bestellung4Public bestellung) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).annehmen(bestellung);
    }
    public void auszahlen(final Konto4Public konto, final long betrag) 
				throws model.ExcAuszahlungGroesserGutgaben, PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).auszahlen(konto, betrag);
    }
    public void bestellManager_update(final model.meta.BestellManagerMssgs event) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).bestellManager_update(event);
    }
    public void bestellen(final EinkaufsManager4Public einkaufsManager, final Lieferart4Public lieferart) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).bestellen(einkaufsManager, lieferart);
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
    public void einzahlen(final Konto4Public konto, final long betrag) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).einzahlen(konto, betrag);
    }
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).entfernePosition(position);
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
				throws model.UserException, PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).neuePosition(einkaufsManager, artikel, menge);
    }
    public void produktKatalog_update(final model.meta.ProduktKatalogMssgs event) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).produktKatalog_update(event);
    }
    public void vorbestellen(final EinkaufsManager4Public einkaufsManager, final Lieferart4Public lieferart) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).vorbestellen(einkaufsManager, lieferart);
    }
    public void warenlager_update(final model.meta.WarenlagerMssgs event) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).warenlager_update(event);
    }
    public void zuEinkaufswagenHinzufuegen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).zuEinkaufswagenHinzufuegen(artikel, menge);
    }
    public void zuruecksenden(final PositionInBestellung4Public position) 
				throws PersistenceException{
        ((PersistentServiceKunde)this.getTheObject()).zuruecksenden(position);
    }

    
}
