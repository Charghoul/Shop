
package model;

import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;
import serverConstants.ToStringConstants;


/* Additional import section end */

public class Artikel extends model.Komponente implements PersistentArtikel{
    
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,long preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,Artikelstatus4Public artikelstatus) throws PersistenceException{
        return createArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,artikelstatus,false);
    }
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,long preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,Artikelstatus4Public artikelstatus,boolean delayed$Persistence) throws PersistenceException {
        if (artikelnummer == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (bezeichnung == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentArtikel result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newDelayedArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikelnummer", artikelnummer);
        final$$Fields.put("bezeichnung", bezeichnung);
        final$$Fields.put("preis", preis);
        final$$Fields.put("minLagerbestand", minLagerbestand);
        final$$Fields.put("maxLagerbestand", maxLagerbestand);
        final$$Fields.put("hstLieferzeit", hstLieferzeit);
        final$$Fields.put("artikelstatus", artikelstatus);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,long preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,Artikelstatus4Public artikelstatus,boolean delayed$Persistence,Artikel4Public This) throws PersistenceException {
        if (artikelnummer == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (bezeichnung == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentArtikel result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newDelayedArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikelnummer", artikelnummer);
        final$$Fields.put("bezeichnung", bezeichnung);
        final$$Fields.put("preis", preis);
        final$$Fields.put("minLagerbestand", minLagerbestand);
        final$$Fields.put("maxLagerbestand", maxLagerbestand);
        final$$Fields.put("hstLieferzeit", hstLieferzeit);
        final$$Fields.put("artikelstatus", artikelstatus);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("artikelnummer", this.getArtikelnummer());
            result.put("bezeichnung", this.getBezeichnung());
            result.put("preis", new Long(this.getPreis()).toString());
            result.put("minLagerbestand", new Long(this.getMinLagerbestand()).toString());
            result.put("maxLagerbestand", new Long(this.getMaxLagerbestand()).toString());
            result.put("hstLieferzeit", new Long(this.getHstLieferzeit()).toString());
            AbstractPersistentRoot artikelstatus = (AbstractPersistentRoot)this.getArtikelstatus();
            if (artikelstatus != null) {
                result.put("artikelstatus", artikelstatus.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    artikelstatus.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && artikelstatus.hasEssentialFields())artikelstatus.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot hersteller = (AbstractPersistentRoot)this.getHersteller();
            if (hersteller != null) {
                result.put("hersteller", hersteller.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    hersteller.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && hersteller.hasEssentialFields())hersteller.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ArtikelSearchList getArtikelByArtikelnummer(String artikelnummer) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .getArtikelByArtikelnummer(artikelnummer);
    }
    
    public static ArtikelSearchList getArtikelByBezeichnung(String bezeichnung) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .getArtikelByBezeichnung(bezeichnung);
    }
    
    public Artikel provideCopy() throws PersistenceException{
        Artikel result = this;
        result = new Artikel(this.subService, 
                             this.This, 
                             this.artikelnummer, 
                             this.bezeichnung, 
                             this.preis, 
                             this.minLagerbestand, 
                             this.maxLagerbestand, 
                             this.hstLieferzeit, 
                             this.artikelstatus, 
                             this.hersteller, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String artikelnummer;
    protected String bezeichnung;
    protected long preis;
    protected long minLagerbestand;
    protected long maxLagerbestand;
    protected long hstLieferzeit;
    protected PersistentArtikelstatus artikelstatus;
    protected PersistentHersteller hersteller;
    
    public Artikel(SubjInterface subService,PersistentKomponente This,String artikelnummer,String bezeichnung,long preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,PersistentArtikelstatus artikelstatus,PersistentHersteller hersteller,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentKomponente)This,id);
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.minLagerbestand = minLagerbestand;
        this.maxLagerbestand = maxLagerbestand;
        this.hstLieferzeit = hstLieferzeit;
        this.artikelstatus = artikelstatus;
        this.hersteller = hersteller;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 108) ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,this.getId());
        super.store();
        if(this.getArtikelstatus() != null){
            this.getArtikelstatus().store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.artikelstatusSet(this.getId(), getArtikelstatus());
        }
        if(this.getHersteller() != null){
            this.getHersteller().store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.herstellerSet(this.getId(), getHersteller());
        }
        
    }
    
    public String getArtikelnummer() throws PersistenceException {
        return this.artikelnummer;
    }
    public void setArtikelnummer(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.artikelnummerSet(this.getId(), newValue);
        this.artikelnummer = newValue;
    }
    public String getBezeichnung() throws PersistenceException {
        return this.bezeichnung;
    }
    public void setBezeichnung(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.bezeichnungSet(this.getId(), newValue);
        this.bezeichnung = newValue;
    }
    public long getPreis() throws PersistenceException {
        return this.preis;
    }
    public void setPreis(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.preisSet(this.getId(), newValue);
        this.preis = newValue;
    }
    public long getMinLagerbestand() throws PersistenceException {
        return this.minLagerbestand;
    }
    public void setMinLagerbestand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.minLagerbestandSet(this.getId(), newValue);
        this.minLagerbestand = newValue;
    }
    public long getMaxLagerbestand() throws PersistenceException {
        return this.maxLagerbestand;
    }
    public void setMaxLagerbestand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.maxLagerbestandSet(this.getId(), newValue);
        this.maxLagerbestand = newValue;
    }
    public long getHstLieferzeit() throws PersistenceException {
        return this.hstLieferzeit;
    }
    public void setHstLieferzeit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.hstLieferzeitSet(this.getId(), newValue);
        this.hstLieferzeit = newValue;
    }
    public Artikelstatus4Public getArtikelstatus() throws PersistenceException {
        return this.artikelstatus;
    }
    public void setArtikelstatus(Artikelstatus4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.artikelstatus)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.artikelstatus = (PersistentArtikelstatus)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.artikelstatusSet(this.getId(), newValue);
        }
    }
    public Hersteller4Public getHersteller() throws PersistenceException {
        return this.hersteller;
    }
    public void setHersteller(Hersteller4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.hersteller)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.hersteller = (PersistentHersteller)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.herstellerSet(this.getId(), newValue);
        }
    }
    public PersistentArtikel getThis() throws PersistenceException {
        if(this.This == null){
            PersistentArtikel result = (PersistentArtikel)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentArtikel)this.This;
    }
    
    public void accept(KomponenteVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(KomponenteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(KomponenteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(KomponenteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(HierarchieHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(HierarchieHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(HierarchieHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(HierarchieHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArtikelstatus() != null && this.getArtikelstatus().getTheObject().getLeafInfo() != 0) return 1;
        return 0;
    }
    
    
    public boolean containsHierarchie(final HierarchieHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
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
        this.setThis((PersistentArtikel)This);
		if(this.isTheSameAs(This)){
			this.setArtikelnummer((String)final$$Fields.get("artikelnummer"));
			this.setBezeichnung((String)final$$Fields.get("bezeichnung"));
			this.setPreis((Long)final$$Fields.get("preis"));
			this.setMinLagerbestand((Long)final$$Fields.get("minLagerbestand"));
			this.setMaxLagerbestand((Long)final$$Fields.get("maxLagerbestand"));
			this.setHstLieferzeit((Long)final$$Fields.get("hstLieferzeit"));
			this.setArtikelstatus((PersistentArtikelstatus)final$$Fields.get("artikelstatus"));
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
    public void statusAuslauf(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		StatusAuslaufCommand4Public command = model.meta.StatusAuslaufCommand.createStatusAuslaufCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void statusVerkauf(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		StatusVerkaufCommand4Public command = model.meta.StatusVerkaufCommand.createStatusVerkaufCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public <T> T strategyHierarchie(final HierarchieHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.Artikel$$finalize(getThis() );
		return result;
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
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		ZuEinkaufswHinzCommand4Public command = model.meta.ZuEinkaufswHinzCommand.createZuEinkaufswHinzCommand(menge, now, now);
		command.setEinkaufsManager(einkaufsManager);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereBezeichnung(final String bezeichnung) 
				throws PersistenceException{
        getThis().setBezeichnung(bezeichnung);
        
    }
    public void aendereHstLieferzeit(final long hstLieferzeit) 
				throws PersistenceException{
        getThis().setHstLieferzeit(hstLieferzeit);
        
    }
    public void aendereMaxLagerbestand(final long maxLagerbestand) 
				throws PersistenceException{
        getThis().setMaxLagerbestand(maxLagerbestand);
        
    }
    public void aendereMinLagerbestand(final long minLagerbestand) 
				throws PersistenceException{
        getThis().setMinLagerbestand(minLagerbestand);
        
    }
    public void aenderePreis(final long preis) 
				throws PersistenceException{
        getThis().setPreis(preis);
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void herstellerHinzufuegen(final Hersteller4Public hersteller) 
				throws PersistenceException{
        getThis().setHersteller(hersteller);
        //überprüft ob Artikelbestand 0 ist und bestellt dann nach
        Position4Public position = Warenlager.getTheWarenlager().getWarenListe().findFirst(argument -> {
            return argument.getArtikel().equals(getThis()) && argument.getMenge() < 1;
        });
        if(position != null){
            try {
                Warenlager.getTheWarenlager().nachbestellen(getThis(),getThis().getMaxLagerbestand());
            } catch (ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) {
                excArtikelHatKeinenHersteller.printStackTrace();
            }
        }
        ProduktKatalog.getTheProduktKatalog().internalUpdate();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void statusAuslauf() 
				throws model.ExcInconsistentStatusChange, PersistenceException{
        getThis().getArtikelstatus().accept(new ArtikelstatusExceptionVisitor<ExcInconsistentStatusChange>() {
            @Override
            public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException, ExcInconsistentStatusChange {
                throw new ExcInconsistentStatusChange(ErrorMessages.StatusDidNotChange);
            }

            @Override
            public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException, ExcInconsistentStatusChange {
                throw new ExcInconsistentStatusChange(ErrorMessages.StatusUbersprungen);
            }

            @Override
            public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException, ExcInconsistentStatusChange {
                getThis().setArtikelstatus(Auslauf.getTheAuslauf());
            }
        });
        ProduktKatalog.getTheProduktKatalog().internalUpdate();
    }
    public void statusVerkauf() 
				throws model.ExcInconsistentStatusChange, model.ExcArtikelHatKeinenHersteller, PersistenceException{

        if(getThis().getHersteller() != null || Warenlager.getTheWarenlager().getWarenListe().findFirst(x -> {
            return x.getArtikel().equals(getThis()) && x.getMenge() > 0;
        })!=null){
            getThis().getArtikelstatus().accept(new ArtikelstatusExceptionVisitor<ExcInconsistentStatusChange>() {
                @Override
                public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException, ExcInconsistentStatusChange {
                    getThis().setArtikelstatus(Verkauf.getTheVerkauf());
                }

                @Override
                public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException, ExcInconsistentStatusChange {
                    getThis().setArtikelstatus(Verkauf.getTheVerkauf());
                }

                @Override
                public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException, ExcInconsistentStatusChange {
                    throw new ExcInconsistentStatusChange(ErrorMessages.StatusDidNotChange);

                }
            });
            ProduktKatalog.getTheProduktKatalog().internalUpdate();
        }
        else throw new ExcArtikelHatKeinenHersteller(ErrorMessages.ArtikelHatKeinenHerstellerVerkauf);
    }
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager) 
				throws model.UserException, PersistenceException{
        einkaufsManager.neuePosition(getThis(), menge);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
