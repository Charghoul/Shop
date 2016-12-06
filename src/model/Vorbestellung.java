
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Vorbestellung extends model.BestellungAbstrakt implements PersistentVorbestellung{
    
    
    public static Vorbestellung4Public createVorbestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart) throws PersistenceException{
        return createVorbestellung(bestellManager,warenwert,lieferart,false);
    }
    
    public static Vorbestellung4Public createVorbestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart,boolean delayed$Persistence) throws PersistenceException {
        PersistentVorbestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newDelayedVorbestellung(warenwert);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newVorbestellung(warenwert,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        final$$Fields.put("warenwert", warenwert);
        final$$Fields.put("lieferart", lieferart);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Vorbestellung4Public createVorbestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart,boolean delayed$Persistence,Vorbestellung4Public This) throws PersistenceException {
        PersistentVorbestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newDelayedVorbestellung(warenwert);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
                .newVorbestellung(warenwert,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        final$$Fields.put("warenwert", warenwert);
        final$$Fields.put("lieferart", lieferart);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("positionsListe", this.getPositionsListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Vorbestellung provideCopy() throws PersistenceException{
        Vorbestellung result = this;
        result = new Vorbestellung(this.bestellManager, 
                                   this.warenwert, 
                                   this.lieferart, 
                                   this.subService, 
                                   this.This, 
                                   this.getId());
        result.positionsListe = this.positionsListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Vorbestellung_PositionsListeProxi positionsListe;
    
    public Vorbestellung(PersistentBestellManager bestellManager,long warenwert,PersistentLieferart lieferart,SubjInterface subService,PersistentBestellungAbstrakt This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBestellManager)bestellManager,(long)warenwert,(PersistentLieferart)lieferart,(SubjInterface)subService,(PersistentBestellungAbstrakt)This,id);
        this.positionsListe = new Vorbestellung_PositionsListeProxi(this);        
    }
    
    static public long getTypeId() {
        return 166;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 166) ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
            .newVorbestellung(warenwert,this.getId());
        super.store();
        this.getPositionsListe().store();
        
    }
    
    public Vorbestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return this.positionsListe;
    }
    public PersistentVorbestellung getThis() throws PersistenceException {
        if(this.This == null){
            PersistentVorbestellung result = (PersistentVorbestellung)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentVorbestellung)this.This;
    }
    
    public void accept(BestellungAbstraktVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getLieferart() != null) return 1;
        if (this.getPositionsListe().getLength() > 0) return 1;
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
        this.setThis((PersistentVorbestellung)This);
		if(this.isTheSameAs(This)){
			this.setBestellManager((PersistentBestellManager)final$$Fields.get("bestellManager"));
			this.setWarenwert((Long)final$$Fields.get("warenwert"));
			this.setLieferart((PersistentLieferart)final$$Fields.get("lieferart"));
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
        super.initializeOnCreation();

    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();

    }
    public void stornieren() 
				throws PersistenceException{
        getThis().getBestellManager().getVorbestellListe().removeFirst(getThis());
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void listeHinzufuegen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        positionsListe.applyToAll( x -> {
            getThis().getPositionsListe().add(x);
        });
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
