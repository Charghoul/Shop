
package model;

import common.Fraction;
import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;


/* Additional import section end */

public class LieferartManager extends PersistentObject implements PersistentLieferartManager{
    
    private static LieferartManager4Public theLieferartManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static LieferartManager4Public getTheLieferartManager() throws PersistenceException{
        if (theLieferartManager == null || reset$For$Test){
            if (reset$For$Test) theLieferartManager = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            LieferartManager4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.getTheLieferartManager();
                            theLieferartManager = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                LieferartManager4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theLieferartManager== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theLieferartManager;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theLieferartManager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("lieferartenListe", this.getLieferartenListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public LieferartManager provideCopy() throws PersistenceException{
        LieferartManager result = this;
        result = new LieferartManager(this.subService, 
                                      this.This, 
                                      this.getId());
        result.lieferartenListe = this.lieferartenListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected LieferartManager_LieferartenListeProxi lieferartenListe;
    protected SubjInterface subService;
    protected PersistentLieferartManager This;
    
    public LieferartManager(SubjInterface subService,PersistentLieferartManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.lieferartenListe = new LieferartManager_LieferartenListeProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 198;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public LieferartManager_LieferartenListeProxi getLieferartenListe() throws PersistenceException {
        return this.lieferartenListe;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.subServiceSet(this.getId(), newValue);
        }
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferartManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getLieferartenListe().getLength() > 0) return 1;
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
        this.setThis((PersistentLieferartManager)This);
		if(this.isTheSameAs(This)){
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
    
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        lieferart.aendereLieferart(lieferzeit, preis);
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{

        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void neueLieferart(final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        LieferartSearchList lieferartSearchList = Lieferart.getLieferartByName(name);
        if(lieferartSearchList.iterator().hasNext()){
            throw new ExcAlreadyExists(ErrorMessages.LieferArtAlreadyExists);
        }
        getThis().getLieferartenListe().add(Lieferart.createLieferart(name, lieferzeit, preis));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
