
package model;

import persistence.*;
import model.visitor.*;
import view.objects.*;


/* Additional import section end */

public class ServiceKunde extends model.Service implements PersistentServiceKunde{
    
    
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
            AbstractPersistentRoot warenlager = (AbstractPersistentRoot)this.getWarenlager();
            if (warenlager != null) {
                result.put("warenlager", warenlager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    warenlager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && warenlager.hasEssentialFields())warenlager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ServiceKunde provideCopy() throws PersistenceException{
        ServiceKunde result = this;
        result = new ServiceKunde(this.This, 
                                  this.einkaufsManager, 
                                  this.warenlager, 
                                  this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentEinkaufsManager einkaufsManager;
    protected PersistentWarenlager warenlager;
    
    public ServiceKunde(PersistentService This,PersistentEinkaufsManager einkaufsManager,PersistentWarenlager warenlager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.einkaufsManager = einkaufsManager;
        this.warenlager = warenlager;        
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
        if(this.getWarenlager() != null){
            this.getWarenlager().store();
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.warenlagerSet(this.getId(), getWarenlager());
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
            ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade.warenlagerSet(this.getId(), newValue);
        }
    }
    public PersistentServiceKunde getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServiceKunde result = (PersistentServiceKunde)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServiceKunde)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getEinkaufsManager() != null) return 1;
        if (this.getWarenlager() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServiceKunde)This);
		if(this.isTheSameAs(This)){
		}
    }
    public String serviceKunde_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void connected(final String user) 
				throws PersistenceException{

    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

    }
    public void disconnected() 
				throws PersistenceException{

    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		getThis().setEinkaufsManager(EinkaufsManager.createEinkaufsManager());
        getThis().setWarenlager(Warenlager.getTheWarenlager());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public void neuePosition(final EinkaufsManager4Public einkaufsManager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        getThis().getEinkaufsManager().neuePosition(artikel, menge);
        
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
