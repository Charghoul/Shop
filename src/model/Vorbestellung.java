
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Vorbestellung extends model.Bestellstatus implements PersistentVorbestellung{
    
    
    public static Vorbestellung4Public createVorbestellung() throws PersistenceException{
        return createVorbestellung(false);
    }
    
    public static Vorbestellung4Public createVorbestellung(boolean delayed$Persistence) throws PersistenceException {
        PersistentVorbestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newDelayedVorbestellung();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newVorbestellung(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Vorbestellung4Public createVorbestellung(boolean delayed$Persistence,Vorbestellung4Public This) throws PersistenceException {
        PersistentVorbestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newDelayedVorbestellung();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newVorbestellung(-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Vorbestellung provideCopy() throws PersistenceException{
        Vorbestellung result = this;
        result = new Vorbestellung(this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Vorbestellung(PersistentBestellstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBestellstatus)This,id);        
    }
    
    static public long getTypeId() {
        return 216;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 216) ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
            .newVorbestellung(this.getId());
        super.store();
        
    }
    
    public PersistentVorbestellung getThis() throws PersistenceException {
        if(this.This == null){
            PersistentVorbestellung result = (PersistentVorbestellung)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentVorbestellung)this.This;
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentVorbestellung)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
