
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Lieferung extends PersistentObject implements PersistentLieferung{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Lieferung4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLieferungFacade.getClass(objectId);
        return (Lieferung4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Lieferung4Public createLieferung() throws PersistenceException{
        return createLieferung(false);
    }
    
    public static Lieferung4Public createLieferung(boolean delayed$Persistence) throws PersistenceException {
        PersistentLieferung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferungFacade
                .newDelayedLieferung(0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferungFacade
                .newLieferung(0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Lieferung4Public createLieferung(boolean delayed$Persistence,Lieferung4Public This) throws PersistenceException {
        PersistentLieferung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferungFacade
                .newDelayedLieferung(0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferungFacade
                .newLieferung(0,-1);
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
            AbstractPersistentRoot bestellung = (AbstractPersistentRoot)this.getBestellung();
            if (bestellung != null) {
                result.put("bestellung", bestellung.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    bestellung.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bestellung.hasEssentialFields())bestellung.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot lieferart = (AbstractPersistentRoot)this.getLieferart();
            if (lieferart != null) {
                result.put("lieferart", lieferart.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    lieferart.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && lieferart.hasEssentialFields())lieferart.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("lieferversuche", new Long(this.getLieferversuche()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Lieferung provideCopy() throws PersistenceException{
        Lieferung result = this;
        result = new Lieferung(this.bestellung, 
                               this.lieferart, 
                               this.lieferversuche, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentBestellung bestellung;
    protected PersistentLieferart lieferart;
    protected long lieferversuche;
    protected PersistentLieferung This;
    
    public Lieferung(PersistentBestellung bestellung,PersistentLieferart lieferart,long lieferversuche,PersistentLieferung This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.bestellung = bestellung;
        this.lieferart = lieferart;
        this.lieferversuche = lieferversuche;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 150;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 150) ConnectionHandler.getTheConnectionHandler().theLieferungFacade
            .newLieferung(lieferversuche,this.getId());
        super.store();
        if(this.getBestellung() != null){
            this.getBestellung().store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.bestellungSet(this.getId(), getBestellung());
        }
        if(this.getLieferart() != null){
            this.getLieferart().store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.lieferartSet(this.getId(), getLieferart());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Bestellung4Public getBestellung() throws PersistenceException {
        return this.bestellung;
    }
    public void setBestellung(Bestellung4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.bestellung)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bestellung = (PersistentBestellung)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.bestellungSet(this.getId(), newValue);
        }
    }
    public Lieferart4Public getLieferart() throws PersistenceException {
        return this.lieferart;
    }
    public void setLieferart(Lieferart4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.lieferart)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.lieferart = (PersistentLieferart)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.lieferartSet(this.getId(), newValue);
        }
    }
    public long getLieferversuche() throws PersistenceException {
        return this.lieferversuche;
    }
    public void setLieferversuche(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theLieferungFacade.lieferversucheSet(this.getId(), newValue);
        this.lieferversuche = newValue;
    }
    protected void setThis(PersistentLieferung newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLieferung)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferungFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentLieferung getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLieferung result = (PersistentLieferung)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentLieferung)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferung(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getBestellung() != null) return 1;
        if (this.getLieferart() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLieferung)This);
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
