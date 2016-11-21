
package model;

import common.Fraction;
import model.meta.ProduktKatalogMssgs;
import model.visitor.*;
import persistence.*;

import java.util.Observable;


/* Additional import section end */

public class ServiceKunde extends model.ServiceShop implements PersistentServiceKunde{
    
    
    public static ServiceKunde4Public createServiceKunde() throws PersistenceException{
        return createServiceKunde(false);
    }
    
    public static ServiceKunde4Public createServiceKunde(boolean delayed$Persistence) throws PersistenceException {
        PersistentServiceKunde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
                .newDelayedServiceKunde();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
                .newServiceKunde(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ServiceKunde4Public createServiceKunde(boolean delayed$Persistence,ServiceKunde4Public This) throws PersistenceException {
        PersistentServiceKunde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
                .newDelayedServiceKunde();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
                .newServiceKunde(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot einkaufsManager = (AbstractPersistentRoot)this.getEinkaufsManager();
            if (einkaufsManager != null) {
                result.put("einkaufsManager", einkaufsManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    einkaufsManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && einkaufsManager.hasEssentialFields())einkaufsManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot lieferartManager = (AbstractPersistentRoot)this.getLieferartManager();
            if (lieferartManager != null) {
                result.put("lieferartManager", lieferartManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    lieferartManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && lieferartManager.hasEssentialFields())lieferartManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot bestellManager = (AbstractPersistentRoot)this.getBestellManager();
            if (bestellManager != null) {
                result.put("bestellManager", bestellManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    bestellManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bestellManager.hasEssentialFields())bestellManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ServiceKunde provideCopy() throws PersistenceException{
        ServiceKunde result = this;
        result = new ServiceKunde(this.subService, 
                                  this.This, 
                                  this.konto, 
                                  this.produktKatalog, 
                                  this.einkaufsManager, 
                                  this.lieferartManager, 
                                  this.bestellManager, 
                                  this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentEinkaufsManager einkaufsManager;
    protected PersistentLieferartManager lieferartManager;
    protected PersistentServiceKundeBestellManager bestellManager;
    
    public ServiceKunde(SubjInterface subService,PersistentService This,PersistentKonto konto,PersistentServiceShopProduktKatalog produktKatalog,PersistentEinkaufsManager einkaufsManager,PersistentLieferartManager lieferartManager,PersistentServiceKundeBestellManager bestellManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,(PersistentKonto)konto,(PersistentServiceShopProduktKatalog)produktKatalog,id);
        this.einkaufsManager = einkaufsManager;
        this.lieferartManager = lieferartManager;
        this.bestellManager = bestellManager;        
    }
    
    static public long getTypeId() {
        return -181;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -181) ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
            .newServiceKunde(this.getId());
        super.store();
        if(this.getEinkaufsManager() != null){
            this.getEinkaufsManager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.einkaufsManagerSet(this.getId(), getEinkaufsManager());
        }
        if(this.getLieferartManager() != null){
            this.getLieferartManager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.lieferartManagerSet(this.getId(), getLieferartManager());
        }
        if(this.bestellManager != null){
            this.bestellManager.store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.bestellManagerSet(this.getId(), bestellManager);
        }
        
    }
    
    public EinkaufsManager4Public getEinkaufsManager() throws PersistenceException {
        return this.einkaufsManager;
    }
    public void setEinkaufsManager(EinkaufsManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.einkaufsManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.einkaufsManagerSet(this.getId(), newValue);
        }
    }
    public LieferartManager4Public getLieferartManager() throws PersistenceException {
        return this.lieferartManager;
    }
    public void setLieferartManager(LieferartManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.lieferartManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.lieferartManager = (PersistentLieferartManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.lieferartManagerSet(this.getId(), newValue);
        }
    }
    public void setBestellManager(ServiceKundeBestellManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.bestellManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bestellManager = (PersistentServiceKundeBestellManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.bestellManagerSet(this.getId(), newValue);
        }
    }
    public PersistentServiceKunde getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServiceKunde result = (PersistentServiceKunde)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServiceKunde)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getKonto() != null) return 1;
        if (this.getProduktKatalog() != null) return 1;
        if (this.getEinkaufsManager() != null) return 1;
        if (this.getBestellManager() != null) return 1;
        return 0;
    }
    
    
    public ProduktKatalog4Public artikel_Path_In_NeuePosition() 
				throws model.UserException, PersistenceException{
        	return getThis().getProduktKatalog();
    }
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public BestellManager4Public getBestellManager() 
				throws PersistenceException{
        if (this.bestellManager== null) return null;
		return this.bestellManager.getObservee();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServiceKunde)This);
		if(this.isTheSameAs(This)){
		}
    }
    public LieferartManager4Public lieferart_Path_In_Bestellen() 
				throws model.UserException, PersistenceException{
        	return getThis().getLieferartManager();
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public String serviceKunde_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		if(anything instanceof PositionInBestellung4Public) {
			if(this.filter_zuruecksenden((PositionInBestellung4Public)anything)) result = result + "zuruecksendenPRMTRPositionInBestellungPRMTR+++";
		}
		if(anything instanceof Bestellung4Public) {
			if(this.filter_annehmen((Bestellung4Public)anything)) result = result + "annehmenPRMTRBestellungPRMTR+++";
		}
		return result;
    }
    public void setBestellManager(final BestellManager4Public bestellManager) 
				throws PersistenceException{
        if (this.bestellManager == null) {
			this.setBestellManager(model.ServiceKundeBestellManager.createServiceKundeBestellManager(this.isDelayed$Persistence()));
			this.bestellManager.setObserver(getThis());
		}
		this.bestellManager.setObservee(bestellManager);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        position.aendereMenge(menge);
        getThis().signalChanged(true);
    }
    public void annehmen(final Bestellung4Public bestellung) 
				throws PersistenceException{
        bestellung.annehmen();
        getThis().signalChanged(true);
    }
    public void bestellManager_update(final model.meta.BestellManagerMssgs event) 
				throws PersistenceException{
        getThis().signalChanged(true);
    }
    public void bestellen(final EinkaufsManager4Public einkaufsManager, final Lieferart4Public lieferart) 
				throws PersistenceException{
        einkaufsManager.bestellen(lieferart,getThis());
        getThis().signalChanged(true);
    }
    public void connected(final String user) 
				throws PersistenceException{

    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

    }
    public void disconnected() 
				throws PersistenceException{

    }
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException{
        position.entfernePosition(getThis().getEinkaufsManager());
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();

        getThis().setProduktKatalog(ProduktKatalog.getTheProduktKatalog());
        getThis().setLieferartManager(LieferartManager.getTheLieferartManager());
        BestellManager4Public temp = BestellManager.createBestellManager();
        getThis().setBestellManager(temp);
        getThis().setEinkaufsManager(EinkaufsManager.createEinkaufsManager(temp));
        getThis().setKonto(Konto.createKonto(4999,0));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public void neuePosition(final EinkaufsManager4Public einkaufsManager, final Artikel4Public artikel, final long menge) 
				throws model.UserException, PersistenceException{
        getThis().getEinkaufsManager().neuePosition(artikel, menge);
        getThis().signalChanged(true);
    }
    public void vorbestellen(final EinkaufsManager4Public einkaufsManager) 
				throws PersistenceException{
        //TODO: implement method: vorbestellen
        
    }
    public void zuEinkaufswagenHinzufuegen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        artikel.zuEinkaufswHinz(menge,getThis().getEinkaufsManager(),getThis());
        getThis().signalChanged(true);
    }
    public void zuruecksenden(final PositionInBestellung4Public position) 
				throws PersistenceException{
        position.zuruecksenden(getThis());
        getThis().signalChanged(true);
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void produktKatalog_update(final model.meta.ProduktKatalogMssgs event) 
				throws PersistenceException{
        getThis().signalChanged(true);
    }

    /* Start of protected part that is not overridden by persistence generator */

    private boolean filter_zuruecksenden(PositionInBestellung4Public anything) throws PersistenceException {
       return anything.getBestellung().getBestellstatus().equals(Geliefert.getTheGeliefert());
    }

    private boolean filter_annehmen(Bestellung4Public anything) throws PersistenceException {
        return anything.getBestellstatus().equals(Geliefert.getTheGeliefert());
    }
    
    /* End of protected part that is not overridden by persistence generator */
    
}
