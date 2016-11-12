
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Bestellung extends PersistentObject implements PersistentBestellung{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Bestellung4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBestellungFacade.getClass(objectId);
        return (Bestellung4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Bestellung4Public createBestellung() throws PersistenceException{
        return createBestellung(false);
    }
    
    public static Bestellung4Public createBestellung(boolean delayed$Persistence) throws PersistenceException {
        PersistentBestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newDelayedBestellung("");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newBestellung("",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Bestellung4Public createBestellung(boolean delayed$Persistence,Bestellung4Public This) throws PersistenceException {
        PersistentBestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newDelayedBestellung("");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newBestellung("",-1);
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
            result.put("positionsListe", this.getPositionsListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            result.put("ID", this.getID());
            AbstractPersistentRoot bestellstatus = (AbstractPersistentRoot)this.getBestellstatus();
            if (bestellstatus != null) {
                result.put("bestellstatus", bestellstatus.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    bestellstatus.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bestellstatus.hasEssentialFields())bestellstatus.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Bestellung provideCopy() throws PersistenceException{
        Bestellung result = this;
        result = new Bestellung(this.ID, 
                                this.bestellstatus, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Bestellung_PositionsListeProxi positionsListe;
    protected String ID;
    protected PersistentBestellstatus bestellstatus;
    protected PersistentBestellung This;
    
    public Bestellung(String ID,PersistentBestellstatus bestellstatus,PersistentBestellung This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.positionsListe = new Bestellung_PositionsListeProxi(this);
        this.ID = ID;
        this.bestellstatus = bestellstatus;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 136) ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            .newBestellung(ID,this.getId());
        super.store();
        this.getPositionsListe().store();
        if(this.getBestellstatus() != null){
            this.getBestellstatus().store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.bestellstatusSet(this.getId(), getBestellstatus());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return this.positionsListe;
    }
    public String getID() throws PersistenceException {
        return this.ID;
    }
    public void setID(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theBestellungFacade.IDSet(this.getId(), newValue);
        this.ID = newValue;
    }
    public Bestellstatus4Public getBestellstatus() throws PersistenceException {
        return this.bestellstatus;
    }
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.bestellstatus)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bestellstatus = (PersistentBestellstatus)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.bestellstatusSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentBestellung newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBestellung)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentBestellung getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBestellung result = (PersistentBestellung)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentBestellung)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getBestellstatus() != null) return 1;
        if (this.getPositionsListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBestellung)This);
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
