
package model;

import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;


/* Additional import section end */

public class EinkaufsManager extends PersistentObject implements PersistentEinkaufsManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static EinkaufsManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.getClass(objectId);
        return (EinkaufsManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static EinkaufsManager4Public createEinkaufsManager(BestellManager4Public bestellManager) throws PersistenceException{
        return createEinkaufsManager(bestellManager,false);
    }
    
    public static EinkaufsManager4Public createEinkaufsManager(BestellManager4Public bestellManager,boolean delayed$Persistence) throws PersistenceException {
        PersistentEinkaufsManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newDelayedEinkaufsManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newEinkaufsManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static EinkaufsManager4Public createEinkaufsManager(BestellManager4Public bestellManager,boolean delayed$Persistence,EinkaufsManager4Public This) throws PersistenceException {
        PersistentEinkaufsManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newDelayedEinkaufsManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
                .newEinkaufsManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("einkaufsListe", this.getEinkaufsListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            AbstractPersistentRoot bestellManager = (AbstractPersistentRoot)this.getBestellManager();
            if (bestellManager != null) {
                result.put("bestellManager", bestellManager.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    bestellManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bestellManager.hasEssentialFields())bestellManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot myServiceKunde = (AbstractPersistentRoot)this.getMyServiceKunde();
            if (myServiceKunde != null) {
                result.put("myServiceKunde", myServiceKunde.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    myServiceKunde.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myServiceKunde.hasEssentialFields())myServiceKunde.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public EinkaufsManager provideCopy() throws PersistenceException{
        EinkaufsManager result = this;
        result = new EinkaufsManager(this.bestellManager, 
                                     this.subService, 
                                     this.This, 
                                     this.getId());
        result.einkaufsListe = this.einkaufsListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected EinkaufsManager_EinkaufsListeProxi einkaufsListe;
    protected PersistentBestellManager bestellManager;
    protected SubjInterface subService;
    protected PersistentEinkaufsManager This;
    
    public EinkaufsManager(PersistentBestellManager bestellManager,SubjInterface subService,PersistentEinkaufsManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.einkaufsListe = new EinkaufsManager_EinkaufsListeProxi(this);
        this.bestellManager = bestellManager;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 191) ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade
            .newEinkaufsManager(this.getId());
        super.store();
        this.getEinkaufsListe().store();
        if(this.getBestellManager() != null){
            this.getBestellManager().store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.bestellManagerSet(this.getId(), getBestellManager());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public EinkaufsManager_EinkaufsListeProxi getEinkaufsListe() throws PersistenceException {
        return this.einkaufsListe;
    }
    public BestellManager4Public getBestellManager() throws PersistenceException {
        return this.bestellManager;
    }
    public void setBestellManager(BestellManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.bestellManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bestellManager = (PersistentBestellManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.bestellManagerSet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentEinkaufsManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEinkaufsManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEinkaufsManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentEinkaufsManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEinkaufsManager result = (PersistentEinkaufsManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentEinkaufsManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEinkaufsManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEinkaufsManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEinkaufsListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void bestellen(final Lieferart4Public lieferart, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		BestellenCommand4Public command = model.meta.BestellenCommand.createBestellenCommand(now, now);
		command.setLieferart(lieferart);
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
    public ServiceKunde4Public getMyServiceKunde() 
				throws PersistenceException{
        ServiceKundeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServiceKundeFacade
										.inverseGetEinkaufsManager(getThis().getId(), getThis().getClassId());
		try {
			return result.iterator().next();
		} catch (java.util.NoSuchElementException nsee){
			return null;
		}
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEinkaufsManager)This);
		if(this.isTheSameAs(This)){
			this.setBestellManager((PersistentBestellManager)final$$Fields.get("bestellManager"));
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
    
    public void bestellen(final Lieferart4Public lieferart) 
				throws model.ExcWarenwertUeberKontoguthaben, model.ExcArtikelNichtVerfuegbar, PersistenceException{
        //überprüfen ob warenmenge kontoguthaben übersteigt
        if(getThis().gibGesamtPreis() > getThis().getMyServiceKunde().getKonto().getKontostand()) {
            throw new ExcWarenwertUeberKontoguthaben(ErrorMessages.WarenwertUeberKontoguthaben);
        }

        //überprüfen ob alles auf lager ist
        Position4Public temp = Warenlager.getTheWarenlager().nichtVerfPruefen(getThis().getEinkaufsListe().getList());
        //TODO: überprüfung ob artikel vorhanden ist funktioniert noch nicht!
        //TODO: prüfen ob Warenwert unter Kontostand liegt, inkl. Vorbestellungen
        if(temp == null) {
            Bestellung4Public bestellung = getThis().getBestellManager().neueBestellung(getThis().getEinkaufsListe().getList(), Verarbeitung.getTheVerarbeitung());
            getThis().getEinkaufsListe().applyToAll(new Procdure<Position4Public>() {
                @Override
                public void doItTo(Position4Public argument) throws PersistenceException {

                    try {
                        Warenlager.getTheWarenlager().artikelEntnehmen(argument.getArtikel(), argument.getMenge());
                    } catch (ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) {
                        excArtikelHatKeinenHersteller.printStackTrace();
                    } catch (ExcLagerbestandUnderZero excLagerbestandUnderZero) {
                        excLagerbestandUnderZero.printStackTrace();
                    }

                }
            });
            bestellung.aendereStatus(Hinversand.getTheHinversand());
            ZeitManager.getTheZeitManager().neueKndLieferung(bestellung,lieferart);
            //leert die Liste
            getThis().getEinkaufsListe().filter(x -> {
                return false;
            });
        }
        else {
            throw new ExcArtikelNichtVerfuegbar(temp.toString()+ ErrorMessages.ArtikelNichtVerfuegbar);
        }
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

    }
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException{
        getThis().getEinkaufsListe().removeFirst(position);
        
    }
    public long gibGesamtPreis() 
				throws PersistenceException{
         return getThis().getEinkaufsListe().aggregate(new Aggregtion<Position4Public, Long>() {

            @Override
            public Long neutral() throws PersistenceException {
                return (long) 0;
            }

            @Override
            public Long compose(Long result, Position4Public position4Public) throws PersistenceException {
                return result + position4Public.getMenge();
            }

        });
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void neuePosition(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelAlreadyExists, model.UserException, model.ExcLagerbestandOverMax, PersistenceException{
        //prüft ob Artikel schon im Verkauf ist
        if(artikel.getArtikelstatus().equals(Neuanlage.getTheNeuanlage())){
            throw new ExcArtikelNochNichtVerfuegbar(ErrorMessages.ArtikelNochNichtVerfuegbar);
        }
        //prüft ob der Artikel schon in der Einkaufsliste ist
        //TODO: überprüfung ob artikel schon im einkaufswagen ist funktioniert nicht!
        Position4Public temp = getThis().getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException{
                return argument.equals(artikel);
            }
        });
        //wenn der Artikel nicht in der Einkaufsliste gefunden wurde
        if( temp != null) throw new ExcArtikelAlreadyExists(ErrorMessages.ArtikelAlreadyInBasket);
        else {
            if(artikel.getMaxLagerbestand() < menge){
                throw new ExcLagerbestandOverMax(ErrorMessages.LagerbestandOverMax);
            }
            else getThis().getEinkaufsListe().add(Position.createPosition(artikel, menge));
        }
    }
    public void vorbestellen() 
				throws PersistenceException{
        //TODO: vorbestellen implementieren - Vorbestellungsliste und abarbeitung etc, prüfen ob warenkorb zu konto passt vom preis her
        System.out.println("gesamtpreis: " +getThis().gibGesamtPreis());


        // getThis().getBestellManager().neueBestellung(getThis().getEinkaufsListe().getList(),Vorbestellung.getTheVorbestellung());

    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
