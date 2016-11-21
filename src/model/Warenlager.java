
package model;

import common.Fraction;
import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;
import serverConstants.ToStringConstants;

import java.util.HashMap;


/* Additional import section end */

public class Warenlager extends PersistentObject implements PersistentWarenlager{
    
    private static Warenlager4Public theWarenlager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static Warenlager4Public getTheWarenlager() throws PersistenceException{
        if (theWarenlager == null || reset$For$Test){
            if (reset$For$Test) theWarenlager = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            Warenlager4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade.getTheWarenlager();
                            theWarenlager = proxi;
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
                Warenlager4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theWarenlager== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theWarenlager;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theWarenlager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("warenListe", this.getWarenListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Warenlager provideCopy() throws PersistenceException{
        Warenlager result = this;
        result = new Warenlager(this.subService, 
                                this.This, 
                                this.getId());
        result.warenListe = this.warenListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Warenlager_WarenListeProxi warenListe;
    protected SubjInterface subService;
    protected PersistentWarenlager This;
    
    public Warenlager(SubjInterface subService,PersistentWarenlager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.warenListe = new Warenlager_WarenListeProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 193;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException {
        return this.warenListe;
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
            ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentWarenlager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentWarenlager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentWarenlager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentWarenlager result = (PersistentWarenlager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentWarenlager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWarenlager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWarenlager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWarenlager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWarenlager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getWarenListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void artikelEinlagern(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		ArtikelEinlagernCommand4Public command = model.meta.ArtikelEinlagernCommand.createArtikelEinlagernCommand(menge, now, now);
		command.setArtikel(artikel);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void artikelEntfernen(final Position4Public position, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		ArtikelEntfernenCommand4Public command = model.meta.ArtikelEntfernenCommand.createArtikelEntfernenCommand(now, now);
		command.setPosition(position);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		ArtikelEntnehmenCommand4Public command = model.meta.ArtikelEntnehmenCommand.createArtikelEntnehmenCommand(menge, now, now);
		command.setArtikel(artikel);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
        this.setThis((PersistentWarenlager)This);
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
    
    public void artikelEinlagern(final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        Position4Public p4 = getThis().getWarenListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel);
                 }
        });
        if( p4 != null) {
            p4.erhoeheMenge(menge);
        }
        else getThis().getWarenListe().add(Position.createPosition(artikel, menge));

    }
    public void artikelEntfernen(final Position4Public position) 
				throws PersistenceException{
        //TODO: CUSTOM artikelEntfernen überprüfung ob noch sachen auf lager und artikelstatus auslauf
        getThis().getWarenListe().removeAll(position);
    }
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelHatKeinenHersteller, model.ExcLagerbestandUnderZero, PersistenceException{
        Position4Public position = getThis().getWarenListe().findFirst(argument -> {
            return argument.getArtikel().equals(artikel);
        });
        if(position != null) {
            position.verringereMenge(menge);
            long posM = position.getMenge();
            if(position.getArtikel().getHersteller()!=null){
                throw new ExcArtikelHatKeinenHersteller(ErrorMessages.ArtikelHatKeinenHersteller);
            }
            if (posM < artikel.getMinLagerbestand()) {
                getThis().nachbestellen(artikel, artikel.getMaxLagerbestand() - posM);
            }
        }

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
    public void nachbestellen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ZeitManager.getTheZeitManager().neueHstLieferungImplementation(artikel,menge);
        
    }
    public Position4Public nichtVerfPruefen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        return positionsListe.findFirst(bestellungsposition -> {
            Position4Public temp = getThis().getWarenListe().findFirst(warenposition -> {
                return warenposition.getMenge() < bestellungsposition.getMenge();
            });
            return temp != null;
        });
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
