
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Geliefert extends model.Bestellstatus implements PersistentGeliefert{
    
    
    public static Geliefert4Public createGeliefert() throws PersistenceException{
        return createGeliefert(false);
    }
    
    public static Geliefert4Public createGeliefert(boolean delayed$Persistence) throws PersistenceException {
        PersistentGeliefert result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theGeliefertFacade
                .newDelayedGeliefert();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theGeliefertFacade
                .newGeliefert(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Geliefert4Public createGeliefert(boolean delayed$Persistence,Geliefert4Public This) throws PersistenceException {
        PersistentGeliefert result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theGeliefertFacade
                .newDelayedGeliefert();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theGeliefertFacade
                .newGeliefert(-1);
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
    
    public Geliefert provideCopy() throws PersistenceException{
        Geliefert result = this;
        result = new Geliefert(this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Geliefert(PersistentBestellstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBestellstatus)This,id);        
    }
    
    static public long getTypeId() {
        return 215;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 215) ConnectionHandler.getTheConnectionHandler().theGeliefertFacade
            .newGeliefert(this.getId());
        super.store();
        
    }
    
    public PersistentGeliefert getThis() throws PersistenceException {
        if(this.This == null){
            PersistentGeliefert result = (PersistentGeliefert)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentGeliefert)this.This;
    }
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGeliefert(this);
    }
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGeliefert(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGeliefert(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGeliefert(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentGeliefert)This);
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
