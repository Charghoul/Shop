
package model;

import common.Fraction;
import model.meta.*;
import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;

import java.util.EventListener;


/* Additional import section end */

public class ArtikelManager extends PersistentObject implements PersistentArtikelManager{
    
    private static ArtikelManager4Public theArtikelManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ArtikelManager4Public getTheArtikelManager() throws PersistenceException{
        if (theArtikelManager == null || reset$For$Test){
            if (reset$For$Test) theArtikelManager = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ArtikelManager4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.getTheArtikelManager();
                            theArtikelManager = proxi;
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
                ArtikelManager4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theArtikelManager== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theArtikelManager;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theArtikelManager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("artikelListe", this.getArtikelListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ArtikelManager provideCopy() throws PersistenceException{
        ArtikelManager result = this;
        result = new ArtikelManager(this.subService, 
                                    this.This, 
                                    this.getId());
        result.artikelListe = this.artikelListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ArtikelManager_ArtikelListeProxi artikelListe;
    protected SubjInterface subService;
    protected PersistentArtikelManager This;
    
    public ArtikelManager(SubjInterface subService,PersistentArtikelManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.artikelListe = new ArtikelManager_ArtikelListeProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ArtikelManager_ArtikelListeProxi getArtikelListe() throws PersistenceException {
        return this.artikelListe;
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
            ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentArtikelManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentArtikelManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentArtikelManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentArtikelManager result = (PersistentArtikelManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentArtikelManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikelManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikelManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArtikelListe().getLength() > 0) return 1;
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
        this.setThis((PersistentArtikelManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		NeuerArtikelCommand4Public command = model.meta.NeuerArtikelCommand.createNeuerArtikelCommand(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException{

        if(minLagerbestand > maxLagerbestand) throw new ExcIllogicalDataEntry(ErrorMessages.LagerbestandMinGroesserMax);
        ArtikelSearchList artikelSearchList = Artikel.getArtikelByArtikelnummer(artikelnummer);
        if( artikelSearchList.iterator().hasNext()){
            throw new ExcArtikelAlreadyExists(serverConstants.ErrorMessages.ArtikelAlreadyExists);
        }
        Artikel4Public artikel = Artikel.createArtikel(artikelnummer,bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, Neuanlage.getTheNeuanlage());
        getThis().getArtikelListe().add(artikel);
        Warenlager.getTheWarenlager().artikelEinlagern(artikel,0);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
