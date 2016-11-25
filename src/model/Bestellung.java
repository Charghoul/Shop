
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Bestellung extends model.BestellungAbstrakt implements PersistentBestellung{
    
    
    public static Bestellung4Public createBestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart,long bestellID) throws PersistenceException{
        return createBestellung(bestellManager,warenwert,lieferart,bestellID,false);
    }
    
    public static Bestellung4Public createBestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart,long bestellID,boolean delayed$Persistence) throws PersistenceException {
        PersistentBestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newDelayedBestellung(warenwert,bestellID);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newBestellung(warenwert,bestellID,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        final$$Fields.put("warenwert", warenwert);
        final$$Fields.put("lieferart", lieferart);
        final$$Fields.put("bestellID", bestellID);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Bestellung4Public createBestellung(BestellManager4Public bestellManager,long warenwert,Lieferart4Public lieferart,long bestellID,boolean delayed$Persistence,Bestellung4Public This) throws PersistenceException {
        PersistentBestellung result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newDelayedBestellung(warenwert,bestellID);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
                .newBestellung(warenwert,bestellID,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bestellManager", bestellManager);
        final$$Fields.put("warenwert", warenwert);
        final$$Fields.put("lieferart", lieferart);
        final$$Fields.put("bestellID", bestellID);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("positionsListe", this.getPositionsListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            result.put("bestellID", new Long(this.getBestellID()).toString());
            AbstractPersistentRoot bestellstatus = (AbstractPersistentRoot)this.getBestellstatus();
            if (bestellstatus != null) {
                result.put("bestellstatus", bestellstatus.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    bestellstatus.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bestellstatus.hasEssentialFields())bestellstatus.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static BestellungSearchList getBestellungByBestellID(long bestellID) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            .getBestellungByBestellID(bestellID);
    }
    
    public Bestellung provideCopy() throws PersistenceException{
        Bestellung result = this;
        result = new Bestellung(this.bestellManager, 
                                this.warenwert, 
                                this.lieferart, 
                                this.subService, 
                                this.This, 
                                this.kndLieferung, 
                                this.bestellID, 
                                this.bestellstatus, 
                                this.getId());
        result.positionsListe = this.positionsListe.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Bestellung_PositionsListeProxi positionsListe;
    protected PersistentKndLieferung kndLieferung;
    protected long bestellID;
    protected PersistentBestellstatus bestellstatus;
    
    public Bestellung(PersistentBestellManager bestellManager,long warenwert,PersistentLieferart lieferart,SubjInterface subService,PersistentBestellungAbstrakt This,PersistentKndLieferung kndLieferung,long bestellID,PersistentBestellstatus bestellstatus,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBestellManager)bestellManager,(long)warenwert,(PersistentLieferart)lieferart,(SubjInterface)subService,(PersistentBestellungAbstrakt)This,id);
        this.positionsListe = new Bestellung_PositionsListeProxi(this);
        this.kndLieferung = kndLieferung;
        this.bestellID = bestellID;
        this.bestellstatus = bestellstatus;        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 136) ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            .newBestellung(warenwert,bestellID,this.getId());
        super.store();
        this.getPositionsListe().store();
        if(this.getKndLieferung() != null){
            this.getKndLieferung().store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.kndLieferungSet(this.getId(), getKndLieferung());
        }
        if(this.getBestellstatus() != null){
            this.getBestellstatus().store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.bestellstatusSet(this.getId(), getBestellstatus());
        }
        
    }
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return this.positionsListe;
    }
    public KndLieferung4Public getKndLieferung() throws PersistenceException {
        return this.kndLieferung;
    }
    public void setKndLieferung(KndLieferung4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.kndLieferung)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.kndLieferung = (PersistentKndLieferung)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.kndLieferungSet(this.getId(), newValue);
        }
    }
    public long getBestellID() throws PersistenceException {
        return this.bestellID;
    }
    public void setBestellID(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theBestellungFacade.bestellIDSet(this.getId(), newValue);
        this.bestellID = newValue;
    }
    public Bestellstatus4Public getBestellstatus() throws PersistenceException {
        return this.bestellstatus;
    }
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.bestellstatus)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bestellstatus = (PersistentBestellstatus)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBestellungFacade.bestellstatusSet(this.getId(), newValue);
        }
    }
    public PersistentBestellung getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBestellung result = (PersistentBestellung)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentBestellung)this.This;
    }
    
    public void accept(BestellungAbstraktVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getLieferart() != null) return 1;
        if (this.getPositionsListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void allesZuruecksenden(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		AllesZuruecksendenCommand4Public command = model.meta.AllesZuruecksendenCommand.createAllesZuruecksendenCommand(now, now);
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
        this.setThis((PersistentBestellung)This);
		if(this.isTheSameAs(This)){
			this.setBestellManager((PersistentBestellManager)final$$Fields.get("bestellManager"));
			this.setWarenwert((Long)final$$Fields.get("warenwert"));
			this.setLieferart((PersistentLieferart)final$$Fields.get("lieferart"));
			this.setBestellID((Long)final$$Fields.get("bestellID"));
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
    
    public void aendereStatus(final Bestellstatus4Public bestellstatus) 
				throws PersistenceException{
        getThis().setBestellstatus(bestellstatus);
        
    }
    public void allesZuruecksenden() 
				throws PersistenceException{
        getThis().getPositionsListe().applyToAll(x -> {
            try {
                Warenlager.getTheWarenlager().artikelEinlagern(x.getArtikel(), x.getMenge());

            } catch (ExcLagerbestandOverMax excLagerbestandOverMax) {
                excLagerbestandOverMax.printStackTrace();
            }
        });
        getThis().getBestellManager().getKonto().abbuchen(getThis().berechneWarenwert() /100 * LieferartManager.getTheLieferartManager().getRueckversandGebuehr());
        getThis().getBestellManager().getKonto().verringereReserviert(getThis().berechneWarenwert());
        getThis().getBestellManager().getBestellListe().removeFirst(getThis());

    }
    public void annehmen() 
				throws PersistenceException{
        getThis().setBestellstatus(Angenommen.getTheAngenommen());
        getThis().getBestellManager().getKonto().verringereReserviert(getThis().berechneWarenwert());
        getThis().getBestellManager().getKonto().abbuchen(getThis().getWarenwert());
    }
    public long berechneWarenwert() 
				throws PersistenceException{
        Long temp = getThis().getPositionsListe().aggregate(new Aggregtion<PositionInBestellung4Public, Long>() {
            @Override
            public Long neutral() throws PersistenceException {
                return (long) 0;
            }

            @Override
            public Long compose(Long result, PositionInBestellung4Public positionInBestellung4Public) throws PersistenceException {
                return result + (positionInBestellung4Public.getMenge() * positionInBestellung4Public.getArtikel().getPreis());
            }
        });
        temp = temp+getThis().getLieferart().getPreis();
        getThis().setWarenwert(temp);
        return temp;
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void lieferungHinzufuegen(final KndLieferung4Public lieferung) 
				throws PersistenceException{
        getThis().setKndLieferung(lieferung);
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void listeHinzufuegen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        positionsListe.applyToAll(x -> {
            getThis().getPositionsListe().add(PositionInBestellung.createPositionInBestellung(x.getArtikel(),x.getMenge(),getThis()));
        });
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
