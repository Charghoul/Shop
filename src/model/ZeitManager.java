
package model;

import model.meta.Mssgs;
import model.meta.ZeitObjektMssgs;
import persistence.*;
import model.visitor.*;
import view.objects.*;

import view.objects.Server;



/* Additional import section end */

public class ZeitManager extends PersistentObject implements PersistentZeitManager{
    
    private static ZeitManager4Public theZeitManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ZeitManager4Public getTheZeitManager() throws PersistenceException{
        if (theZeitManager == null || reset$For$Test){
            if (reset$For$Test) theZeitManager = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ZeitManager4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.getTheZeitManager();
                            theZeitManager = proxi;
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
                ZeitManager4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theZeitManager== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theZeitManager;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theZeitManager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("zeitObjektListe", this.getZeitObjektListe().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            result.put("annahmezeit", new Long(this.getAnnahmezeit()).toString());
            result.put("maxAnlieferungsVersuche", new Long(this.getMaxAnlieferungsVersuche()).toString());
            result.put("retoureZeit", new Long(this.getRetoureZeit()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ZeitManager provideCopy() throws PersistenceException{
        ZeitManager result = this;
        result = new ZeitManager(this.zeitObjektListe, 
                                 this.annahmezeit, 
                                 this.maxAnlieferungsVersuche, 
                                 this.retoureZeit, 
                                 this.subService, 
                                 this.This, 
                                 this.getId());
        result.annahmeZeiten = this.annahmeZeiten.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentZeitManagerZeitObjektListe zeitObjektListe;
    protected ZeitManager_AnnahmeZeitenProxi annahmeZeiten;
    protected long annahmezeit;
    protected long maxAnlieferungsVersuche;
    protected long retoureZeit;
    protected SubjInterface subService;
    protected PersistentZeitManager This;
    
    public ZeitManager(PersistentZeitManagerZeitObjektListe zeitObjektListe,long annahmezeit,long maxAnlieferungsVersuche,long retoureZeit,SubjInterface subService,PersistentZeitManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.zeitObjektListe = zeitObjektListe;
        this.annahmeZeiten = new ZeitManager_AnnahmeZeitenProxi(this);
        this.annahmezeit = annahmezeit;
        this.maxAnlieferungsVersuche = maxAnlieferungsVersuche;
        this.retoureZeit = retoureZeit;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 163;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public void setZeitObjektListe(ZeitManagerZeitObjektListe4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.zeitObjektListe)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.zeitObjektListe = (PersistentZeitManagerZeitObjektListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.zeitObjektListeSet(this.getId(), newValue);
        }
    }
    public ZeitManager_AnnahmeZeitenProxi getAnnahmeZeiten() throws PersistenceException {
        return this.annahmeZeiten;
    }
    public long getAnnahmezeit() throws PersistenceException {
        return this.annahmezeit;
    }
    public void setAnnahmezeit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.annahmezeitSet(this.getId(), newValue);
        this.annahmezeit = newValue;
    }
    public long getMaxAnlieferungsVersuche() throws PersistenceException {
        return this.maxAnlieferungsVersuche;
    }
    public void setMaxAnlieferungsVersuche(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.maxAnlieferungsVersucheSet(this.getId(), newValue);
        this.maxAnlieferungsVersuche = newValue;
    }
    public long getRetoureZeit() throws PersistenceException {
        return this.retoureZeit;
    }
    public void setRetoureZeit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.retoureZeitSet(this.getId(), newValue);
        this.retoureZeit = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentZeitManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentZeitManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theZeitManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentZeitManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentZeitManager result = (PersistentZeitManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentZeitManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleZeitManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZeitManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZeitManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZeitManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleZeitManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZeitManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZeitManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZeitManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getZeitObjektListe().getObservee().getLength() > 0) return 1;
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
    public void forwardInternalEvent() 
				throws PersistenceException{
        model.meta.ZeitManagerForwardInternalEventMssg event = new model.meta.ZeitManagerForwardInternalEventMssg(getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public ZeitManagerZeitObjektListe4Public getZeitObjektListe() 
				throws PersistenceException{
        if (this.zeitObjektListe == null) {
			this.setZeitObjektListe(model.ZeitManagerZeitObjektListe.createZeitManagerZeitObjektListe(this.isDelayed$Persistence()));
			this.zeitObjektListe.setObserver(this);
		}
		return this.zeitObjektListe;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentZeitManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void neueHstLieferung(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        model.meta.ZeitManagerNeueHstLieferungArtikelIntegerMssg event = new model.meta.ZeitManagerNeueHstLieferungArtikelIntegerMssg(artikel, menge, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void neueKndAnnahme(final KndLieferung4Public kndLieferung) 
				throws PersistenceException{
        model.meta.ZeitManagerNeueKndAnnahmeKndLieferungMssg event = new model.meta.ZeitManagerNeueKndAnnahmeKndLieferungMssg(kndLieferung, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void neueKndLieferung(final Bestellung4Public bestellung) 
				throws PersistenceException{
        model.meta.ZeitManagerNeueKndLieferungBestellungMssg event = new model.meta.ZeitManagerNeueKndLieferungBestellungMssg(bestellung, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void neueRetoureLieferung(final KndLieferung4Public kndLieferung) 
				throws PersistenceException{
        model.meta.ZeitManagerNeueRetoureLieferungKndLieferungMssg event = new model.meta.ZeitManagerNeueRetoureLieferungKndLieferungMssg(kndLieferung, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void neueRetourePosition(final PositionInBestellung4Public position) 
				throws PersistenceException{
        model.meta.ZeitManagerNeueRetourePositionPositionInBestellungMssg event = new model.meta.ZeitManagerNeueRetourePositionPositionInBestellungMssg(position, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
    
    public void aendereAnnahmezeit(final long neueZeit) 
				throws PersistenceException{
        getThis().setAnnahmezeit(neueZeit);
        
    }
    public void aendereMaxAnlieferungsVersuche(final long maxAnlieferungsVersuche) 
				throws PersistenceException{
        getThis().setMaxAnlieferungsVersuche(maxAnlieferungsVersuche);
        
    }
    public void aendereRetoureZeit(final long retoureZeit) 
				throws PersistenceException{
        getThis().setRetoureZeit(retoureZeit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void forwardInternalEventImplementation() 
				throws PersistenceException{
        //updated durch sein event nur den zeitmanager im service
    }
    public void handleTimeUnitElapsed() 
				throws PersistenceException{
        getThis().getZeitObjektListe().applyToAll(argument -> {
            argument.reduceTime();
        });
        getThis().getAnnahmeZeiten().applyToAll( argument -> {
            argument.reduceTime();
        });
        System.out.println("TICK");
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setAnnahmezeit(2);
        getThis().setMaxAnlieferungsVersuche(3);
        getThis().setRetoureZeit(1);
        this.timeThread = new Thread(new ZeitRunnable(TIME_UNIT_IN_MILLIS));
        this.timeThread.start();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        this.timeThread = new Thread(new ZeitRunnable(TIME_UNIT_IN_MILLIS));
        this.timeThread.start();
    }
    public void neueHstLieferungImplementation(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        getThis().getZeitObjektListe().add(model.HstLieferung.createHstLieferung(artikel.getHstLieferzeit(), activated.getTheactivated(), artikel,menge));
    }
    public void neueKndAnnahmeImplementation(final KndLieferung4Public kndLieferung) 
				throws PersistenceException{
        getThis().getAnnahmeZeiten().add(KndAnnahme.createKndAnnahme(getThis().getAnnahmezeit(), activated.getTheactivated(),kndLieferung));
        
    }
    public void neueKndLieferungImplementation(final Bestellung4Public bestellung) 
				throws PersistenceException{
        KndLieferung4Public kndL = KndLieferung.createKndLieferung(bestellung.getLieferart().getLieferzeit(),activated.getTheactivated(), bestellung);
        bestellung.lieferungHinzufuegen(kndL);
        getThis().getZeitObjektListe().add(kndL);

    }
    public void neueRetoureLieferungImplementation(final KndLieferung4Public kndLieferung) 
				throws PersistenceException{
        getThis().getZeitObjektListe().add(RetoureLieferung.createRetoureLieferung(getThis().getRetoureZeit(),activated.getTheactivated(),kndLieferung));
        
    }
    public void neueRetourePositionImplementation(final PositionInBestellung4Public position) 
				throws PersistenceException{
        getThis().getZeitObjektListe().add(RetourePosition.createRetourePosition(getThis().getRetoureZeit(),activated.getTheactivated(),position));
        
    }
    public void removeZeitObjekt(final ZeitObjekt4Public zeitObjekt) 
				throws PersistenceException{
        //TODO removezeitobjekt noch implementieren!
        getTheZeitManager();
        
    }
    public void zeitObjektListe_update(final model.meta.ZeitObjektMssgs event) 
				throws PersistenceException{
        getThis().forwardInternalEvent();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    private static long TIME_UNIT_IN_MILLIS = 4000;
    private Thread timeThread;

    private class ZeitRunnable implements Runnable {

        private long timeUnitInMS;
        private boolean mayRun;

        protected ZeitRunnable(long timeUnitInMS) {
            this.mayRun = true;
            this.timeUnitInMS = timeUnitInMS;
        }
        @Override
        public void run() {

            while (this.mayRun) {
                try {
                    Thread.sleep(this.timeUnitInMS);
                    ZeitManager.getTheZeitManager().handleTimeUnitElapsed();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (PersistenceException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /* End of protected part that is not overridden by persistence generator */
    
}
