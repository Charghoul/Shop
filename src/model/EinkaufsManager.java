
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class EinkaufsManager extends PersistentObject implements PersistentEinkaufsManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static EinkaufsManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.getClass(objectId);
        return (EinkaufsManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static EinkaufsManager4Public createEinkaufsManager() throws PersistenceException{
        return createEinkaufsManager(false);
    }
    
    public static EinkaufsManager4Public createEinkaufsManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentEinkaufsManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newDelayedEinkaufsManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newEinkaufsManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static EinkaufsManager4Public createEinkaufsManager(boolean delayed$Persistence,EinkaufsManager4Public This) throws PersistenceException {
        PersistentEinkaufsManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newDelayedEinkaufsManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newEinkaufsManager(-1);
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
            result.put("einkaufsListe", this.getEinkaufsListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public EinkaufsManager provideCopy() throws PersistenceException{
        EinkaufsManager result = this;
        result = new EinkaufsManager(this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected EinkaufsManager_EinkaufsListeProxi einkaufsListe;
    protected PersistentEinkaufsManager This;
    
    public EinkaufsManager(PersistentEinkaufsManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.einkaufsListe = new EinkaufsManager_EinkaufsListeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 191) ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
            .newEinkaufsManager(this.getId());
        super.store();
        this.getEinkaufsListe().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public EinkaufsManager_EinkaufsListeProxi getEinkaufsListe() throws PersistenceException {
        return this.einkaufsListe;
    }
    protected void setThis(PersistentEinkaufsManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEinkaufsManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentEinkaufsManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEinkaufsManager result = (PersistentEinkaufsManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentEinkaufsManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getEinkaufsListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEinkaufsManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public ServiceKunde4Public inverseGetEinkaufsManager() 
				throws PersistenceException{
        ServiceKundeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
										.inverseGetEinkaufsManager(getThis().getId(), getThis().getClassId());
		try {
			return result.iterator().next();
		} catch (java.util.NoSuchElementException nsee){
			return null;
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereMenge(final Position4Public position, final long menge) 
				throws PersistenceException{
        position.aendereMenge(menge);
        
    }
    public void bestellen() 
				throws PersistenceException{
        //TODO: implement method: bestellen
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void neuePosition(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        //TODO: überprüfen ob Artikel schon in Positionsliste vorhanden ist
        
        getThis().getEinkaufsListe().add(Position.createPosition(artikel, menge));
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
