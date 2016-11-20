
package model;

import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;


/* Additional import section end */

public class Position extends model.PositionAbstrakt implements PersistentPosition{
    
    
    public static Position4Public createPosition(Artikel4Public artikel,long menge) throws PersistenceException{
        return createPosition(artikel,menge,false);
    }
    
    public static Position4Public createPosition(Artikel4Public artikel,long menge,boolean delayed$Persistence) throws PersistenceException {
        PersistentPosition result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
                .newDelayedPosition(menge);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
                .newPosition(menge,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikel", artikel);
        final$$Fields.put("menge", menge);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Position4Public createPosition(Artikel4Public artikel,long menge,boolean delayed$Persistence,Position4Public This) throws PersistenceException {
        PersistentPosition result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
                .newDelayedPosition(menge);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
                .newPosition(menge,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikel", artikel);
        final$$Fields.put("menge", menge);
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
    
    public Position provideCopy() throws PersistenceException{
        Position result = this;
        result = new Position(this.artikel, 
                              this.menge, 
                              this.subService, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Position(PersistentArtikel artikel,long menge,SubjInterface subService,PersistentPositionAbstrakt This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentArtikel)artikel,(long)menge,(SubjInterface)subService,(PersistentPositionAbstrakt)This,id);        
    }
    
    static public long getTypeId() {
        return 144;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 144) ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .newPosition(menge,this.getId());
        super.store();
        
    }
    
    public PersistentPosition getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPosition result = (PersistentPosition)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentPosition)this.This;
    }
    
    public void accept(PositionAbstraktVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(PositionAbstraktReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(PositionAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(PositionAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public int getLeafInfo() throws PersistenceException{
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
        this.setThis((PersistentPosition)This);
		if(this.isTheSameAs(This)){
			this.setArtikel((PersistentArtikel)final$$Fields.get("artikel"));
			this.setMenge((Long)final$$Fields.get("menge"));
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
    
    public void aendereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException{
        long aktMenge = getThis().getMenge();
        if(aktMenge > menge){
            getThis().verringereMenge(aktMenge - menge);
        }
        if(aktMenge < menge){
            getThis().erhoeheMenge(menge - aktMenge);
        }
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void erhoeheMenge(final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        long newMenge = getThis().getMenge() + menge;
        if( getArtikel().getMaxLagerbestand() < menge){
            throw new ExcLagerbestandOverMax(ErrorMessages.LagerbestandOverMax);
        }
        getThis().setMenge(newMenge);
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void verringereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException{
        long newMenge = getThis().getMenge()-menge;
        if(newMenge <0){
            throw new ExcLagerbestandUnderZero(ErrorMessages.LagerbestandUnderZero);
        }
        getThis().setMenge(newMenge);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
