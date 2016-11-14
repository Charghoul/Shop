
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Rueckversand extends model.Bestellstatus implements PersistentRueckversand{
    
    
    public static Rueckversand4Public createRueckversand() throws PersistenceException{
        return createRueckversand(false);
    }
    
    public static Rueckversand4Public createRueckversand(boolean delayed$Persistence) throws PersistenceException {
        PersistentRueckversand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theRueckversandFacade
                .newDelayedRueckversand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theRueckversandFacade
                .newRueckversand(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Rueckversand4Public createRueckversand(boolean delayed$Persistence,Rueckversand4Public This) throws PersistenceException {
        PersistentRueckversand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theRueckversandFacade
                .newDelayedRueckversand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theRueckversandFacade
                .newRueckversand(-1);
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
    
    public Rueckversand provideCopy() throws PersistenceException{
        Rueckversand result = this;
        result = new Rueckversand(this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Rueckversand(PersistentBestellstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBestellstatus)This,id);        
    }
    
    static public long getTypeId() {
        return 217;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 217) ConnectionHandler.getTheConnectionHandler().theRueckversandFacade
            .newRueckversand(this.getId());
        super.store();
        
    }
    
    public PersistentRueckversand getThis() throws PersistenceException {
        if(this.This == null){
            PersistentRueckversand result = (PersistentRueckversand)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentRueckversand)this.This;
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleRueckversand(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRueckversand(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRueckversand(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRueckversand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRueckversand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRueckversand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRueckversand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRueckversand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentRueckversand)This);
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
