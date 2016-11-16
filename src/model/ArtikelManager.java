
package model;

import common.Fraction;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;
import serverConstants.ErrorMessages;


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
            result.put("produktgruppen", this.getProduktgruppen().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ArtikelManager provideCopy() throws PersistenceException{
        ArtikelManager result = this;
        result = new ArtikelManager(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ArtikelManager_ArtikelListeProxi artikelListe;
    protected ArtikelManager_ProduktgruppenProxi produktgruppen;
    protected PersistentArtikelManager This;
    
    public ArtikelManager(PersistentArtikelManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.artikelListe = new ArtikelManager_ArtikelListeProxi(this);
        this.produktgruppen = new ArtikelManager_ProduktgruppenProxi(this);
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
    public ArtikelManager_ProduktgruppenProxi getProduktgruppen() throws PersistenceException {
        return this.produktgruppen;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getArtikelListe().getLength() > 0) return 1;
        if (this.getProduktgruppen().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		AendereArtikelCommand4Public command = model.meta.AendereArtikelCommand.createAendereArtikelCommand(bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, now, now);
		command.setArtikel(artikel);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentArtikelManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		NeuerArtikelCommand4Public command = model.meta.NeuerArtikelCommand.createNeuerArtikelCommand(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException{
        if(artikel.alreadyExists(bezeichnung).equals(TrueX.getTheTrueX())) throw new ExcAlreadyExists(ErrorMessages.ArtikelAlreadyExists);
        else artikel.aendereArtikel(bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException{
       artikel.herstellerHinzufuegen(hersteller);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().getProduktgruppen().add(Produktgruppe.createProduktgruppe("Katalog"));
        //Test Daten
        getThis().getArtikelListe().add(Artikel.createArtikel("1234","test", Fraction.parse("5"),10,100,3, Neuanlage.getTheNeuanlage()));
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException{
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
