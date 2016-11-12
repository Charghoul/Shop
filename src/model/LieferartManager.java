
package model;

import common.Fraction;
import persistence.*;
import model.visitor.*;
import serverConstants.ErrorMessages;
import serverConstants.ToStringConstants;


/* Additional import section end */

public class LieferartManager extends PersistentObject implements PersistentLieferartManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static LieferartManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.getClass(objectId);
        return (LieferartManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static LieferartManager4Public createLieferartManager() throws PersistenceException{
        return createLieferartManager(false);
    }
    
    public static LieferartManager4Public createLieferartManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentLieferartManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
                .newDelayedLieferartManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
                .newLieferartManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static LieferartManager4Public createLieferartManager(boolean delayed$Persistence,LieferartManager4Public This) throws PersistenceException {
        PersistentLieferartManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
                .newDelayedLieferartManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
                .newLieferartManager(-1);
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
            result.put("lieferartenListe", this.getLieferartenListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            AbstractPersistentRoot myService = (AbstractPersistentRoot)this.getMyService();
            if (myService != null) {
                result.put("myService", myService.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    myService.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myService.hasEssentialFields())myService.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public LieferartManager provideCopy() throws PersistenceException{
        LieferartManager result = this;
        result = new LieferartManager(this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected LieferartManager_LieferartenListeProxi lieferartenListe;
    protected PersistentLieferartManager This;
    
    public LieferartManager(PersistentLieferartManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.lieferartenListe = new LieferartManager_LieferartenListeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 198;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 198) ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
            .newLieferartManager(this.getId());
        super.store();
        this.getLieferartenListe().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public LieferartManager_LieferartenListeProxi getLieferartenListe() throws PersistenceException {
        return this.lieferartenListe;
    }
    protected void setThis(PersistentLieferartManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLieferartManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentLieferartManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLieferartManager result = (PersistentLieferartManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentLieferartManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferartManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getLieferartenListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public ServiceAdmin4Public getMyService() 
				throws PersistenceException{
        ServiceAdminSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
										.inverseGetLieferartManager(getThis().getId(), getThis().getClassId());
		try {
			return result.iterator().next();
		} catch (java.util.NoSuchElementException nsee){
			return null;
		}
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLieferartManager)This);
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
        getThis().getLieferartenListe().add(Lieferart.createLieferart("Standard", 3, Fraction.parse("2/1")));
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void neueLieferart(final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcLieferartAlreadyExists, PersistenceException{
        LieferartSearchList lieferartSearchList = Lieferart.getLieferartByName(name);
        if(lieferartSearchList.iterator().hasNext()){
            throw new ExcLieferartAlreadyExists(ErrorMessages.LieferArtAlreadyExists);
        }
        getThis().getLieferartenListe().add(Lieferart.createLieferart(name, lieferzeit, preis));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
