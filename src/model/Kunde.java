
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Kunde extends PersistentObject implements PersistentKunde{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Kunde4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theKundeFacade.getClass(objectId);
        return (Kunde4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Kunde4Public createKunde(String benutzername,String passwort) throws PersistenceException{
        return createKunde(benutzername,passwort,false);
    }
    
    public static Kunde4Public createKunde(String benutzername,String passwort,boolean delayed$Persistence) throws PersistenceException {
        if (benutzername == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (passwort == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentKunde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
                .newDelayedKunde(benutzername,passwort);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
                .newKunde(benutzername,passwort,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("benutzername", benutzername);
        final$$Fields.put("passwort", passwort);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Kunde4Public createKunde(String benutzername,String passwort,boolean delayed$Persistence,Kunde4Public This) throws PersistenceException {
        if (benutzername == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (passwort == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentKunde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
                .newDelayedKunde(benutzername,passwort);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKundeFacade
                .newKunde(benutzername,passwort,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("benutzername", benutzername);
        final$$Fields.put("passwort", passwort);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("benutzername", this.getBenutzername());
            result.put("passwort", this.getPasswort());
            AbstractPersistentRoot konto = (AbstractPersistentRoot)this.getKonto();
            if (konto != null) {
                result.put("konto", konto.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    konto.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && konto.hasEssentialFields())konto.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static KundeSearchList getKundeByBenutzername(String benutzername) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .getKundeByBenutzername(benutzername);
    }
    
    public Kunde provideCopy() throws PersistenceException{
        Kunde result = this;
        result = new Kunde(this.benutzername, 
                           this.passwort, 
                           this.konto, 
                           this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String benutzername;
    protected String passwort;
    protected PersistentKonto konto;
    protected SubjInterface subService;
    protected PersistentKunde This;
    
    public Kunde(String benutzername,String passwort,PersistentKonto konto,SubjInterface subService,PersistentKunde This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.konto = konto;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 349;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 349) ConnectionHandler.getTheConnectionHandler().theKundeFacade
            .newKunde(benutzername,passwort,this.getId());
        super.store();
        if(this.getKonto() != null){
            this.getKonto().store();
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.kontoSet(this.getId(), getKonto());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getBenutzername() throws PersistenceException {
        return this.benutzername;
    }
    public void setBenutzername(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKundeFacade.benutzernameSet(this.getId(), newValue);
        this.benutzername = newValue;
    }
    public String getPasswort() throws PersistenceException {
        return this.passwort;
    }
    public void setPasswort(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKundeFacade.passwortSet(this.getId(), newValue);
        this.passwort = newValue;
    }
    public Konto4Public getKonto() throws PersistenceException {
        return this.konto;
    }
    public void setKonto(Konto4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.konto)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.konto = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.kontoSet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentKunde newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentKunde)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKundeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentKunde getThis() throws PersistenceException {
        if(this.This == null){
            PersistentKunde result = (PersistentKunde)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentKunde)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getKonto() != null) return 1;
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
        this.setThis((PersistentKunde)This);
		if(this.isTheSameAs(This)){
			this.setBenutzername((String)final$$Fields.get("benutzername"));
			this.setPasswort((String)final$$Fields.get("passwort"));
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
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
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
