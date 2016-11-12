
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Konto extends PersistentObject implements PersistentKonto{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Konto4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theKontoFacade.getClass(objectId);
        return (Konto4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Konto4Public createKonto() throws PersistenceException{
        return createKonto(false);
    }
    
    public static Konto4Public createKonto(boolean delayed$Persistence) throws PersistenceException {
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(common.Fraction.Null,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(common.Fraction.Null,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Konto4Public createKonto(boolean delayed$Persistence,Konto4Public This) throws PersistenceException {
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(common.Fraction.Null,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(common.Fraction.Null,common.Fraction.Null,-1);
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
            result.put("kontostand", this.getKontostand().toString());
            result.put("limit", this.getLimit().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Konto provideCopy() throws PersistenceException{
        Konto result = this;
        result = new Konto(this.kontostand, 
                           this.limit, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction kontostand;
    protected common.Fraction limit;
    protected PersistentKonto This;
    
    public Konto(common.Fraction kontostand,common.Fraction limit,PersistentKonto This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.kontostand = kontostand;
        this.limit = limit;
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
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public common.Fraction getKontostand() throws PersistenceException {
        return this.kontostand;
    }
    public void setKontostand(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.kontostandSet(this.getId(), newValue);
        this.kontostand = newValue;
    }
    public common.Fraction getLimit() throws PersistenceException {
        return this.limit;
    }
    public void setLimit(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.limitSet(this.getId(), newValue);
        this.limit = newValue;
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
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentKonto)This);
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
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
