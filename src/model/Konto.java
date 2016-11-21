
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Konto extends PersistentObject implements PersistentKonto{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Konto4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theKontoFacade.getClass(objectId);
        return (Konto4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Konto4Public createKonto(long kontostand,long limit) throws PersistenceException{
        return createKonto(kontostand,limit,false);
    }
    
    public static Konto4Public createKonto(long kontostand,long limit,boolean delayed$Persistence) throws PersistenceException {
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(kontostand,limit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(kontostand,limit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("kontostand", kontostand);
        final$$Fields.put("limit", limit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Konto4Public createKonto(long kontostand,long limit,boolean delayed$Persistence,Konto4Public This) throws PersistenceException {
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(kontostand,limit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(kontostand,limit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("kontostand", kontostand);
        final$$Fields.put("limit", limit);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("kontostand", new Long(this.getKontostand()).toString());
            result.put("limit", new Long(this.getLimit()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Konto provideCopy() throws PersistenceException{
        Konto result = this;
        result = new Konto(this.kontostand, 
                           this.limit, 
                           this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long kontostand;
    protected long limit;
    protected SubjInterface subService;
    protected PersistentKonto This;
    
    public Konto(long kontostand,long limit,SubjInterface subService,PersistentKonto This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.kontostand = kontostand;
        this.limit = limit;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 146) ConnectionHandler.getTheConnectionHandler().theKontoFacade
            .newKonto(kontostand,limit,this.getId());
        super.store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getKontostand() throws PersistenceException {
        return this.kontostand;
    }
    public void setKontostand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.kontostandSet(this.getId(), newValue);
        this.kontostand = newValue;
    }
    public long getLimit() throws PersistenceException {
        return this.limit;
    }
    public void setLimit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.limitSet(this.getId(), newValue);
        this.limit = newValue;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentKonto newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentKonto getThis() throws PersistenceException {
        if(this.This == null){
            PersistentKonto result = (PersistentKonto)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentKonto)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentKonto)This);
		if(this.isTheSameAs(This)){
			this.setKontostand((Long)final$$Fields.get("kontostand"));
			this.setLimit((Long)final$$Fields.get("limit"));
		}
    }
    public ServiceShop4Public inverseGetKonto() 
				throws PersistenceException{
        ServiceShopSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServiceShopFacade
										.inverseGetKonto(getThis().getId(), getThis().getClassId());
		try {
			return result.iterator().next();
		} catch (java.util.NoSuchElementException nsee){
			return null;
		}
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
    
    public void abbuchen(final common.Fraction betrag) 
				throws PersistenceException{
        //TODO: implement method: abbuchen
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void einzahlen(final common.Fraction betrag) 
				throws PersistenceException{
        //TODO: implement method: einzahlen
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
