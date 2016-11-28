package persistence;



import model.visitor.*;

public class ServiceAdminProxi extends ServiceShopProxi implements PersistentServiceAdmin{
    
    public ServiceAdminProxi(long objectId) {
        super(objectId);
    }
    public ServiceAdminProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -182;
    }
    
    public void setKundenManager(ServiceAdminKundenManager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setKundenManager(newValue);
    }
    public Warenlager4Public getWarenlager() throws PersistenceException {
        return ((PersistentServiceAdmin)this.getTheObject()).getWarenlager();
    }
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setWarenlager(newValue);
    }
    public ArtikelManager4Public getArtikelManager() throws PersistenceException {
        return ((PersistentServiceAdmin)this.getTheObject()).getArtikelManager();
    }
    public void setArtikelManager(ArtikelManager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setArtikelManager(newValue);
    }
    public LieferartManager4Public getLieferartManager() throws PersistenceException {
        return ((PersistentServiceAdmin)this.getTheObject()).getLieferartManager();
    }
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setLieferartManager(newValue);
    }
    public HerstellerManager4Public getHerstellerManager() throws PersistenceException {
        return ((PersistentServiceAdmin)this.getTheObject()).getHerstellerManager();
    }
    public void setHerstellerManager(HerstellerManager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setHerstellerManager(newValue);
    }
    public void setZeitManager(ServiceAdminZeitManager4Public newValue) throws PersistenceException {
        ((PersistentServiceAdmin)this.getTheObject()).setZeitManager(newValue);
    }
    public PersistentServiceAdmin getThis() throws PersistenceException {
        return ((PersistentServiceAdmin)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceShopVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceAdmin(this);
    }
    
    
    public ArtikelManager4Public artikel_Path_In_ArtikelAnhaengen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).artikel_Path_In_ArtikelAnhaengen();
    }
    public ArtikelManager4Public artikel_Path_In_ArtikelEinlagern() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).artikel_Path_In_ArtikelEinlagern();
    }
    public ArtikelManager4Public artikel_Path_In_ArtikelEntnehmen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).artikel_Path_In_ArtikelEntnehmen();
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).deregister(observee);
    }
    public KundenManager4Public getKundenManager() 
				throws PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).getKundenManager();
    }
    public ProduktKatalog4Public getProduktKatalog() 
				throws PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).getProduktKatalog();
    }
    public ZeitManager4Public getZeitManager() 
				throws PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).getZeitManager();
    }
    public HerstellerManager4Public hersteller_Path_In_HerstellerHinzufuegen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).hersteller_Path_In_HerstellerHinzufuegen();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Warenlager4Public position_Path_In_ArtikelEntfernen() 
				throws model.UserException, PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).position_Path_In_ArtikelEntfernen();
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).register(observee);
    }
    public String serviceAdmin_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).serviceAdmin_Menu_Filter(anything);
    }
    public void setKundenManager(final KundenManager4Public kundenManager) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).setKundenManager(kundenManager);
    }
    public void setProduktKatalog(final ProduktKatalog4Public produktKatalog) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).setProduktKatalog(produktKatalog);
    }
    public void setZeitManager(final ZeitManager4Public zeitManager) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).setZeitManager(zeitManager);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).updateObservers(event);
    }
    public void aendereAnnahmezeit(final ZeitManager4Public zeitManager, final long neueZeit) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereAnnahmezeit(zeitManager, neueZeit);
    }
    public void aendereBezeichnung(final Artikel4Public artikel, final String bezeichnung) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereBezeichnung(artikel, bezeichnung);
    }
    public void aendereHersteller(final Hersteller4Public hersteller, final String name) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereHersteller(hersteller, name);
    }
    public void aendereHstLieferzeit(final Artikel4Public artikel, final long hstLieferzeit) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereHstLieferzeit(artikel, hstLieferzeit);
    }
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereLieferart(lieferart, name, lieferzeit, preis);
    }
    public void aendereLimit(final Konto4Public konto, final long limit) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereLimit(konto, limit);
    }
    public void aendereMaxAnlieferungsVersuche(final ZeitManager4Public zeitManager, final long maxAnlieferungsVersuche) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereMaxAnlieferungsVersuche(zeitManager, maxAnlieferungsVersuche);
    }
    public void aendereMaxLagerbestand(final Artikel4Public artikel, final long maxLagerbestand) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereMaxLagerbestand(artikel, maxLagerbestand);
    }
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereMenge(position, menge);
    }
    public void aendereMinLagerbestand(final Artikel4Public artikel, final long minLagerbestand) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereMinLagerbestand(artikel, minLagerbestand);
    }
    public void aenderePreis(final Artikel4Public artikel, final long preis) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aenderePreis(artikel, preis);
    }
    public void aendereRueckversandGebuehr(final LieferartManager4Public lieferartManager, final long percent) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereRueckversandGebuehr(lieferartManager, percent);
    }
    public void aendereStandardGuthaben(final KundenManager4Public kundenManager, final long guthaben) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereStandardGuthaben(kundenManager, guthaben);
    }
    public void aendereStandardLimit(final KundenManager4Public kundenManager, final long limit) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).aendereStandardLimit(kundenManager, limit);
    }
    public void artikelAbhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).artikelAbhaengen(produktgruppe, artikel);
    }
    public void artikelAnhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).artikelAnhaengen(produktgruppe, artikel);
    }
    public void artikelEinlagern(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).artikelEinlagern(warenlager, artikel, menge);
    }
    public void artikelEntfernen(final Warenlager4Public warenlager, final Position4Public position) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).artikelEntfernen(warenlager, position);
    }
    public void artikelEntnehmen(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).artikelEntnehmen(warenlager, artikel, menge);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).disconnected();
    }
    public void erhoeheMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).erhoeheMenge(position, menge);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServiceAdmin)this.getTheObject()).hasChanged();
    }
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).herstellerHinzufuegen(artikel, hersteller);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).initializeOnInstantiation();
    }
    public void kundenManager_update(final model.meta.KundenManagerMssgs event) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).kundenManager_update(event);
    }
    public void neueLieferArt(final LieferartManager4Public lieferartManager, final String name, final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).neueLieferArt(lieferartManager, name, lieferzeit, preis);
    }
    public void neuerArtikel(final ArtikelManager4Public artikelManager, final String artikelnummer, final String bezeichnung, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).neuerArtikel(artikelManager, artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }
    public void neuerHersteller(final HerstellerManager4Public herstellerManager, final String name) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).neuerHersteller(herstellerManager, name);
    }
    public void produktKatalog_update(final model.meta.ProduktKatalogMssgs event) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).produktKatalog_update(event);
    }
    public void produktgruppeEntfernen(final Produktgruppe4Public produktgruppe) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).produktgruppeEntfernen(produktgruppe);
    }
    public void produktgruppeHinzufuegen(final Produktgruppe4Public produktgruppe, final String name) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).produktgruppeHinzufuegen(produktgruppe, name);
    }
    public void statusAuslauf(final Artikel4Public artikel) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).statusAuslauf(artikel);
    }
    public void statusVerkauf(final Artikel4Public artikel) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).statusVerkauf(artikel);
    }
    public void verringereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).verringereMenge(position, menge);
    }
    public void zeitManager_update(final model.meta.ZeitManagerMssgs event) 
				throws PersistenceException{
        ((PersistentServiceAdmin)this.getTheObject()).zeitManager_update(event);
    }

    
}
