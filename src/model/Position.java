
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;
import serverConstants.ErrorMessages;


/* Additional import section end */

public class Position extends PersistentObject implements PersistentPosition{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Position4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePositionFacade.getClass(objectId);
        return (Position4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
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
            AbstractPersistentRoot artikel = (AbstractPersistentRoot)this.getArtikel();
            if (artikel != null) {
                result.put("artikel", artikel.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    artikel.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && artikel.hasEssentialFields())artikel.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("menge", new Long(this.getMenge()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Position provideCopy() throws PersistenceException{
        Position result = this;
        result = new Position(this.artikel, 
                              this.menge, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentArtikel artikel;
    protected long menge;
    protected PersistentPosition This;
    
    public Position(PersistentArtikel artikel,long menge,PersistentPosition This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.artikel = artikel;
        this.menge = menge;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
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
        if(this.getArtikel() != null){
            this.getArtikel().store();
            ConnectionHandler.getTheConnectionHandler().thePositionFacade.artikelSet(this.getId(), getArtikel());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().thePositionFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Artikel4Public getArtikel() throws PersistenceException {
        return this.artikel;
    }
    public void setArtikel(Artikel4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.artikel)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.artikel = (PersistentArtikel)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePositionFacade.artikelSet(this.getId(), newValue);
        }
    }
    public long getMenge() throws PersistenceException {
        return this.menge;
    }
    public void setMenge(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().thePositionFacade.mengeSet(this.getId(), newValue);
        this.menge = newValue;
    }
    protected void setThis(PersistentPosition newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePositionFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentPosition getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPosition result = (PersistentPosition)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentPosition)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPosition)This);
		if(this.isTheSameAs(This)){
			this.setArtikel((PersistentArtikel)final$$Fields.get("artikel"));
			this.setMenge((Long)final$$Fields.get("menge"));
		}
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
    public Position4Public enthaeltArtikel(final Artikel4Public artikel) 
				throws PersistenceException{
        if(getThis().getArtikel().equals(artikel)){
            return getThis();
        }
        else {
            return null;
        }
    }
    public void erhoeheMenge(final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        long newMenge = getThis().getMenge() + menge;
        if( getArtikel().groesserMax(newMenge).equals(TrueX.getTheTrueX())){
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
