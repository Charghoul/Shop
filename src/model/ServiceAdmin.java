
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class ServiceAdmin extends model.Service implements PersistentServiceAdmin{
    
    
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ServiceAdmin provideCopy() throws PersistenceException{
        ServiceAdmin result = this;
        result = new ServiceAdmin(this.This, 
                                  this.warenlager, 
                                  this.artikelManager, 
                                  this.lieferartManager, 
                                  this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentWarenlager warenlager;
    protected PersistentArtikelManager artikelManager;
    protected PersistentLieferartManager lieferartManager;
    
    public ServiceAdmin(PersistentService This,PersistentWarenlager warenlager,PersistentArtikelManager artikelManager,PersistentLieferartManager lieferartManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.warenlager = warenlager;
        this.artikelManager = artikelManager;
        this.lieferartManager = lieferartManager;        
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
    public PersistentServiceAdmin getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServiceAdmin result = (PersistentServiceAdmin)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServiceAdmin)this.This;
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
        if (this.getWarenlager() != null) return 1;
        if (this.getArtikelManager() != null) return 1;
        if (this.getLieferartManager() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServiceAdmin)This);
		if(this.isTheSameAs(This)){
		}
    }
    public String serviceAdmin_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        //TODO: implement method: aendereArtikel
        
    }
    public void artikelEinlagern(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        warenlager.artikelEinlagern(artikel, menge);
        getThis().signalChanged(true);
    }
    public void artikelEntnehmen(final Warenlager4Public warenlager, final Position4Public position, final long menge) 
				throws PersistenceException{
        warenlager.artikelEntnehmen(position, menge, getThis());
        getThis().signalChanged(true);

    }
    public void connected(final String user) 
				throws PersistenceException{
        //TODO: implement method: connected
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void disconnected() 
				throws PersistenceException{
        //TODO: implement method: disconnected
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setArtikelManager(model.ArtikelManager.createArtikelManager());
        getThis().setWarenlager(model.Warenlager.getTheWarenlager());
        getThis().setLieferartManager(LieferartManager.createLieferartManager());

    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    public void neueLieferArt(final LieferartManager4Public lieferartManager, final String name, final long lieferzeit, final common.Fraction preis) 
				throws PersistenceException{
        lieferartManager.neueLieferart(name, lieferzeit, preis, getThis());
            getThis().signalChanged(true);
        
    }
    public void neuerArtikel(final ArtikelManager4Public artikelManager, final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        artikelManager.neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, getThis());
        getThis().signalChanged(true);
    }
    public void statusAuslauf(final Artikel4Public artikel) 
				throws PersistenceException{
        artikel.statusAuslauf();
        getThis().signalChanged(true);
        
    }
    public void statusVerkauf(final Artikel4Public artikel) 
				throws PersistenceException{
       artikel.statusVerkauf();
        getThis().signalChanged(true);
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{

    }
    public void handleResult(final Command command) 
				throws PersistenceException{

    }
    public boolean hasChanged() 
				throws PersistenceException{
        return false;
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
