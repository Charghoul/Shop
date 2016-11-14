
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Verkauf extends model.Artikelstatus implements PersistentVerkauf{
    
    
    public static Verkauf4Public createVerkauf() throws PersistenceException{
        return createVerkauf(false);
    }
    
    public static Verkauf4Public createVerkauf(boolean delayed$Persistence) throws PersistenceException {
        PersistentVerkauf result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
                .newDelayedVerkauf();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
                .newVerkauf(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Verkauf4Public createVerkauf(boolean delayed$Persistence,Verkauf4Public This) throws PersistenceException {
        PersistentVerkauf result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
                .newDelayedVerkauf();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
                .newVerkauf(-1);
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
    
    public Verkauf provideCopy() throws PersistenceException{
        Verkauf result = this;
        result = new Verkauf(this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Verkauf(PersistentArtikelstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentArtikelstatus)This,id);        
    }
    
    static public long getTypeId() {
        return 212;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 212) ConnectionHandler.getTheConnectionHandler().theVerkaufFacade
            .newVerkauf(this.getId());
        super.store();
        
    }
    
    public PersistentVerkauf getThis() throws PersistenceException {
        if(this.This == null){
            PersistentVerkauf result = (PersistentVerkauf)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentVerkauf)this.This;
    }
    
    public void accept(ArtikelstatusVisitor visitor) throws PersistenceException {
        visitor.handleVerkauf(this);
    }
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVerkauf(this);
    }
    public <E extends model.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVerkauf(this);
    }
    public <R, E extends model.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVerkauf(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleVerkauf(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVerkauf(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVerkauf(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVerkauf(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentVerkauf)This);
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
