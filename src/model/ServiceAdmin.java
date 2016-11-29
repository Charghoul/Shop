
package model;

import common.Fraction;
import model.visitor.*;
import persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/* Additional import section end */

public class ServiceAdmin extends model.ServiceShop implements PersistentServiceAdmin{
    
    
    public static ServiceAdmin4Public createServiceAdmin() throws PersistenceException{
        return createServiceAdmin(false);
    }
    
    public static ServiceAdmin4Public createServiceAdmin(boolean delayed$Persistence) throws PersistenceException {
        PersistentServiceAdmin result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
                .newDelayedServiceAdmin();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
                .newServiceAdmin(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ServiceAdmin4Public createServiceAdmin(boolean delayed$Persistence,ServiceAdmin4Public This) throws PersistenceException {
        PersistentServiceAdmin result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
                .newDelayedServiceAdmin();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
                .newServiceAdmin(-1);
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
            AbstractPersistentRoot kundenManager = (AbstractPersistentRoot)this.getKundenManager();
            if (kundenManager != null) {
                result.put("kundenManager", kundenManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    kundenManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && kundenManager.hasEssentialFields())kundenManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot warenlager = (AbstractPersistentRoot)this.getWarenlager();
            if (warenlager != null) {
                result.put("warenlager", warenlager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    warenlager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && warenlager.hasEssentialFields())warenlager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot artikelManager = (AbstractPersistentRoot)this.getArtikelManager();
            if (artikelManager != null) {
                result.put("artikelManager", artikelManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    artikelManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && artikelManager.hasEssentialFields())artikelManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
            AbstractPersistentRoot herstellerManager = (AbstractPersistentRoot)this.getHerstellerManager();
            if (herstellerManager != null) {
                result.put("herstellerManager", herstellerManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    herstellerManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && herstellerManager.hasEssentialFields())herstellerManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot zeitManager = (AbstractPersistentRoot)this.getZeitManager();
            if (zeitManager != null) {
                result.put("zeitManager", zeitManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    zeitManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && zeitManager.hasEssentialFields())zeitManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ServiceAdmin provideCopy() throws PersistenceException{
        ServiceAdmin result = this;
        result = new ServiceAdmin(this.subService, 
                                  this.This, 
                                  this.produktKatalog, 
                                  this.kundenManager, 
                                  this.warenlager, 
                                  this.artikelManager, 
                                  this.lieferartManager, 
                                  this.herstellerManager, 
                                  this.zeitManager, 
                                  this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentServiceAdminKundenManager kundenManager;
    protected PersistentWarenlager warenlager;
    protected PersistentArtikelManager artikelManager;
    protected PersistentLieferartManager lieferartManager;
    protected PersistentHerstellerManager herstellerManager;
    protected PersistentServiceAdminZeitManager zeitManager;
    
    public ServiceAdmin(SubjInterface subService,PersistentService This,PersistentServiceShopProduktKatalog produktKatalog,PersistentServiceAdminKundenManager kundenManager,PersistentWarenlager warenlager,PersistentArtikelManager artikelManager,PersistentLieferartManager lieferartManager,PersistentHerstellerManager herstellerManager,PersistentServiceAdminZeitManager zeitManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,(PersistentServiceShopProduktKatalog)produktKatalog,id);
        this.kundenManager = kundenManager;
        this.warenlager = warenlager;
        this.artikelManager = artikelManager;
        this.lieferartManager = lieferartManager;
        this.herstellerManager = herstellerManager;
        this.zeitManager = zeitManager;        
    }
    
    static public long getTypeId() {
        return -182;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -182) ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
            .newServiceAdmin(this.getId());
        super.store();
        if(this.kundenManager != null){
            this.kundenManager.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.kundenManagerSet(this.getId(), kundenManager);
        }
        if(this.getWarenlager() != null){
            this.getWarenlager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.warenlagerSet(this.getId(), getWarenlager());
        }
        if(this.getArtikelManager() != null){
            this.getArtikelManager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.artikelManagerSet(this.getId(), getArtikelManager());
        }
        if(this.getLieferartManager() != null){
            this.getLieferartManager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.lieferartManagerSet(this.getId(), getLieferartManager());
        }
        if(this.getHerstellerManager() != null){
            this.getHerstellerManager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.herstellerManagerSet(this.getId(), getHerstellerManager());
        }
        if(this.zeitManager != null){
            this.zeitManager.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.zeitManagerSet(this.getId(), zeitManager);
        }
        
    }
    
    public void setKundenManager(ServiceAdminKundenManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.kundenManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.kundenManager = (PersistentServiceAdminKundenManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.kundenManagerSet(this.getId(), newValue);
        }
    }
    public Warenlager4Public getWarenlager() throws PersistenceException {
        return this.warenlager;
    }
    public void setWarenlager(Warenlager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.warenlager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.warenlager = (PersistentWarenlager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.warenlagerSet(this.getId(), newValue);
        }
    }
    public ArtikelManager4Public getArtikelManager() throws PersistenceException {
        return this.artikelManager;
    }
    public void setArtikelManager(ArtikelManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.artikelManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.artikelManager = (PersistentArtikelManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.artikelManagerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.lieferartManagerSet(this.getId(), newValue);
        }
    }
    public HerstellerManager4Public getHerstellerManager() throws PersistenceException {
        return this.herstellerManager;
    }
    public void setHerstellerManager(HerstellerManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.herstellerManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.herstellerManager = (PersistentHerstellerManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.herstellerManagerSet(this.getId(), newValue);
        }
    }
    public void setZeitManager(ServiceAdminZeitManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.zeitManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.zeitManager = (PersistentServiceAdminZeitManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade.zeitManagerSet(this.getId(), newValue);
        }
    }
    public PersistentServiceAdmin getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServiceAdmin result = (PersistentServiceAdmin)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServiceAdmin)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getProduktKatalog() != null) return 1;
        if (this.getKundenManager() != null) return 1;
        if (this.getWarenlager() != null) return 1;
        if (this.getArtikelManager() != null) return 1;
        if (this.getLieferartManager() != null) return 1;
        if (this.getHerstellerManager() != null) return 1;
        if (this.getZeitManager() != null) return 1;
        return 0;
    }
    
    
    public ArtikelManager4Public artikel_Path_In_ArtikelAnhaengen() 
				throws model.UserException, PersistenceException{
        	return getThis().getArtikelManager();
    }
    public ArtikelManager4Public artikel_Path_In_ArtikelEinlagern() 
				throws model.UserException, PersistenceException{
        	return getThis().getArtikelManager();
    }
    public ArtikelManager4Public artikel_Path_In_ArtikelEntnehmen() 
				throws model.UserException, PersistenceException{
        	return getThis().getArtikelManager();
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
    public KundenManager4Public getKundenManager() 
				throws PersistenceException{
        if (this.kundenManager== null) return null;
		return this.kundenManager.getObservee();
    }
    public ZeitManager4Public getZeitManager() 
				throws PersistenceException{
        if (this.zeitManager== null) return null;
		return this.zeitManager.getObservee();
    }
    public HerstellerManager4Public hersteller_Path_In_HerstellerHinzufuegen() 
				throws model.UserException, PersistenceException{
        	return getThis().getHerstellerManager();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServiceAdmin)This);
		if(this.isTheSameAs(This)){
		}
    }
    public Warenlager4Public position_Path_In_ArtikelEntfernen() 
				throws model.UserException, PersistenceException{
        	return getThis().getWarenlager();
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
    public String serviceAdmin_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		if(anything instanceof Artikel4Public) {
			if(this.filter_statusAuslauf((Artikel4Public)anything)) result = result + "statusAuslaufPRMTRArtikelPRMTR+++";
			if(this.filter_statusVerkauf((Artikel4Public)anything)) result = result + "statusVerkaufPRMTRArtikelPRMTR+++";
		}
		return result;
    }
    public void setKundenManager(final KundenManager4Public kundenManager) 
				throws PersistenceException{
        if (this.kundenManager == null) {
			this.setKundenManager(model.ServiceAdminKundenManager.createServiceAdminKundenManager(this.isDelayed$Persistence()));
			this.kundenManager.setObserver(getThis());
		}
		this.kundenManager.setObservee(kundenManager);
    }
    public void setZeitManager(final ZeitManager4Public zeitManager) 
				throws PersistenceException{
        if (this.zeitManager == null) {
			this.setZeitManager(model.ServiceAdminZeitManager.createServiceAdminZeitManager(this.isDelayed$Persistence()));
			this.zeitManager.setObserver(getThis());
		}
		this.zeitManager.setObservee(zeitManager);
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
    
    public void aendereAnnahmezeit(final ZeitManager4Public zeitManager, final long neueZeit) 
				throws PersistenceException{
        zeitManager.aendereAnnahmezeit(neueZeit);
        getThis().signalChanged(true);
        
    }
    public void aendereBezeichnung(final Artikel4Public artikel, final String bezeichnung) 
				throws PersistenceException{
        artikel.aendereBezeichnung(bezeichnung);
        getThis().signalChanged(true);
        
    }
    public void aendereHersteller(final Hersteller4Public hersteller, final String name) 
				throws model.ExcAlreadyExists, PersistenceException{
        hersteller.aendereHersteller(name);
        getThis().signalChanged(true);
    }
    public void aendereHstLieferzeit(final Artikel4Public artikel, final long hstLieferzeit) 
				throws PersistenceException{
        artikel.aendereHstLieferzeit(hstLieferzeit);
        getThis().signalChanged(true);
    }
    public void aendereLieferartDauer(final Lieferart4Public lieferart, final long dauer) 
				throws PersistenceException{
       lieferart.aendereLieferartDauer(dauer);
       getThis().signalChanged(true);
    }
    public void aendereLieferartName(final Lieferart4Public lieferart, final String name) 
				throws PersistenceException{
        lieferart.aendereLieferartName(name,getThis());
        getThis().signalChanged(true);
        
    }
    public void aendereLieferartPreis(final Lieferart4Public lieferart, final long preis) 
				throws PersistenceException{
        lieferart.aendereLieferartPreis(preis);
        getThis().signalChanged(true);
        
    }
    public void aendereMaxAnlieferungsVersuche(final ZeitManager4Public zeitManager, final long maxAnlieferungsVersuche) 
				throws PersistenceException{
        zeitManager.aendereMaxAnlieferungsVersuche(maxAnlieferungsVersuche);
        getThis().signalChanged(true);
        
    }
    public void aendereMaxLagerbestand(final Artikel4Public artikel, final long maxLagerbestand) 
				throws PersistenceException{
        artikel.aendereMaxLagerbestand(maxLagerbestand);
        getThis().signalChanged(true);
    }
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        position.aendereMenge(menge);
        getThis().signalChanged(true);
    }
    public void aendereMinLagerbestand(final Artikel4Public artikel, final long minLagerbestand) 
				throws PersistenceException{
        artikel.aendereMinLagerbestand(minLagerbestand);
        getThis().signalChanged(true);
        
    }
    public void aenderePreis(final Artikel4Public artikel, final long preis) 
				throws PersistenceException{
        artikel.aenderePreis(preis);
        getThis().signalChanged(true);
        
    }
    public void aendereRueckversandGebuehr(final LieferartManager4Public lieferartManager, final long percent) 
				throws PersistenceException{
        lieferartManager.aendereRueckversandGebuehr(percent);
        getThis().signalChanged(true);
    }
    public void aendereStandardGuthaben(final KundenManager4Public kundenManager, final long guthaben) 
				throws PersistenceException{
        kundenManager.aendereStandardGuthaben(guthaben);
        getThis().signalChanged(true);
        
    }
    public void aendereStandardLimit(final KundenManager4Public kundenManager, final long limit) 
				throws PersistenceException{
        kundenManager.aendereStandardLimit(limit);
        getThis().signalChanged(true);
        
    }
    public void artikelAbhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws PersistenceException{
        getThis().getProduktKatalog().artikelAbhaengen(produktgruppe, artikel);
        getThis().signalChanged(true);
    }
    public void artikelAnhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException{
        getThis().getProduktKatalog().artikelAnhaengen(produktgruppe,artikel);
        getThis().signalChanged(true);
        
    }
    public void artikelEinlagern(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        warenlager.artikelEinlagern(artikel, menge,getThis());
        getThis().signalChanged(true);

    }
    public void artikelEntfernen(final Warenlager4Public warenlager, final Position4Public position) 
				throws PersistenceException{
        warenlager.artikelEntfernen(position);
        getThis().signalChanged(true);
        
    }
    public void artikelEntnehmen(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        warenlager.artikelEntnehmen(artikel,menge, getThis());
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
    public void erhoeheMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        position.erhoeheMenge(menge);
        getThis().signalChanged(true);
        
    }
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException{
        artikel.herstellerHinzufuegen(hersteller);
        getThis().signalChanged(true);

    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setArtikelManager(ArtikelManager.getTheArtikelManager());
        getThis().setWarenlager(model.Warenlager.getTheWarenlager());
        getThis().setLieferartManager(LieferartManager.getTheLieferartManager());
        getThis().setHerstellerManager(HerstellerManager.createHerstellerManager());
        getThis().setProduktKatalog(ProduktKatalog.getTheProduktKatalog());
        getThis().setZeitManager(ZeitManager.getTheZeitManager());
        getThis().setKundenManager(KundenManager.getTheKundenManager());


        //Test Daten
        Hersteller4Public hst1 = Hersteller.createHersteller("Nintendo");
        Hersteller4Public hst2 = Hersteller.createHersteller("Sony");
        Lieferart4Public l1 = Lieferart.createLieferart("Standard", 3, 199);
        Lieferart4Public l2 = Lieferart.createLieferart("Express", 1, 499);
        Artikel4Public art1 = Artikel.createArtikel("1234","Switch", 999,10,100,3, Verkauf.getTheVerkauf());
        Artikel4Public art2 = Artikel.createArtikel("31415626","Raspberry", 1999,5,200,4, Neuanlage.getTheNeuanlage());
        Artikel4Public art3 = Artikel.createArtikel("666","Teufel's Dreizack", 666,2,100,3,Verkauf.getTheVerkauf());
       // art1.herstellerHinzufuegen(hst1);
       // art3.herstellerHinzufuegen(hst2);

        //Listen
        ((PersistentArtikelManager)getThis().getArtikelManager()).getArtikelListe().add(art1);
        ((PersistentArtikelManager)getThis().getArtikelManager()).getArtikelListe().add(art2);
        ((PersistentArtikelManager)getThis().getArtikelManager()).getArtikelListe().add(art3);
        getThis().getLieferartManager().getLieferartenListe().add(l1);
        getThis().getLieferartManager().getLieferartenListe().add(l2);
        ((PersistentHerstellerManager)getThis().getHerstellerManager()).getHerstellerListe().add(hst1);
        ((PersistentHerstellerManager)getThis().getHerstellerManager()).getHerstellerListe().add(hst2);
        Server.createServer("test","test",0,new Timestamp(new Date().getTime()));

        try {
            ProduktKatalog.getTheProduktKatalog().produktgruppeHinzufuegen(ProduktKatalog.getTheProduktKatalog().getProduktgruppen(), "Langweiliges");
            ProduktKatalog.getTheProduktKatalog().produktgruppeHinzufuegen(ProduktKatalog.getTheProduktKatalog().getProduktgruppen(), "Interessantes");
            ProduktKatalog.getTheProduktKatalog().artikelAnhaengen(ProduktKatalog.getTheProduktKatalog().getProduktgruppen(),art1);
            ProduktKatalog.getTheProduktKatalog().artikelAnhaengen(ProduktKatalog.getTheProduktKatalog().getProduktgruppen(),art3);
            ProduktKatalog.getTheProduktKatalog().artikelAnhaengen(ProduktKatalog.getTheProduktKatalog().getProduktgruppen(),art2);
        } catch (ExcAlreadyExists excAlreadyExists) {
            excAlreadyExists.printStackTrace();
        } catch (CycleException e) {
            e.printStackTrace();
        }
        try {
            getThis().getWarenlager().artikelEinlagern(art1, 50);
            getThis().getWarenlager().artikelEinlagern(art2, 17);
            getThis().getWarenlager().artikelEinlagern(art3,10);
        } catch (ExcLagerbestandOverMax excLagerbestandOverMax) {
            excLagerbestandOverMax.printStackTrace();
        }
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public void kundenManager_update(final model.meta.KundenManagerMssgs event) 
				throws PersistenceException{
        getThis().signalChanged(true);
        
    }
    public void neueLieferArt(final LieferartManager4Public lieferartManager, final String name, final long lieferzeit, final long preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        lieferartManager.neueLieferart(name, lieferzeit, preis);
            getThis().signalChanged(true);
        
    }
    public void neuerArtikel(final ArtikelManager4Public artikelManager, final String artikelnummer, final String bezeichnung, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        artikelManager.neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, getThis());
        getThis().signalChanged(true);
    }
    public void neuerHersteller(final HerstellerManager4Public herstellerManager, final String name) 
				throws model.ExcAlreadyExists, PersistenceException{
        herstellerManager.neuerHersteller(name);
        getThis().signalChanged(true);
    }
    public void produktgruppeEntfernen(final Produktgruppe4Public produktgruppe) 
				throws PersistenceException{
        getThis().getProduktKatalog().produktgruppeEntfernen(produktgruppe, getThis());
        getThis().signalChanged(true);
    }
    public void produktgruppeHinzufuegen(final Produktgruppe4Public produktgruppe, final String name) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException{
        getThis().getProduktKatalog().produktgruppeHinzufuegen(produktgruppe,name);
        getThis().signalChanged(true);
    }
    public void statusAuslauf(final Artikel4Public artikel) 
				throws PersistenceException{
        artikel.statusAuslauf(getThis());
        getThis().signalChanged(true);
        
    }
    public void statusVerkauf(final Artikel4Public artikel) 
				throws PersistenceException{
        artikel.statusVerkauf(getThis());
        getThis().signalChanged(true);
    }
    public void verringereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException{
        position.verringereMenge(menge);
        getThis().signalChanged(true);
        
    }
    public void zeitManager_update(final model.meta.ZeitManagerMssgs event) 
				throws PersistenceException{
        getThis().signalChanged(true);
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void produktKatalog_update(final model.meta.ProduktKatalogMssgs event) 
				throws PersistenceException{
        getThis().signalChanged(true);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
