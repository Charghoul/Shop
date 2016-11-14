
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handlePosition(PositionView position) throws ModelException;
    
    public abstract void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.handleService(serviceRegister);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.handleService(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.handleService(serviceAdmin);
    }
    public abstract void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    
    public abstract void handleBestellung(BestellungView bestellung) throws ModelException;
    
    public abstract void handleLieferart(LieferartView lieferart) throws ModelException;
    
    public abstract void handleKonto(KontoView konto) throws ModelException;
    
    public abstract void handleKunde(KundeView kunde) throws ModelException;
    
    public abstract void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    
    public abstract void handleLieferung(LieferungView lieferung) throws ModelException;
    
    public abstract void handleBestellstatus(BestellstatusView bestellstatus) throws ModelException;
    
    public void handleVorbestellung(VorbestellungView vorbestellung) throws ModelException{
        this.handleBestellstatus(vorbestellung);
    }
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException{
        this.handleBestellstatus(rueckversand);
    }
    public void handleGeliefert(GeliefertView geliefert) throws ModelException{
        this.handleBestellstatus(geliefert);
    }
    public void handleHinversand(HinversandView hinversand) throws ModelException{
        this.handleBestellstatus(hinversand);
    }
    public void handleAngenommen(AngenommenView angenommen) throws ModelException{
        this.handleBestellstatus(angenommen);
    }
    public abstract void handleBooleanX(BooleanXView booleanX) throws ModelException;
    
    public void handleFalseX(FalseXView falseX) throws ModelException{
        this.handleBooleanX(falseX);
    }
    public void handleTrueX(TrueXView trueX) throws ModelException{
        this.handleBooleanX(trueX);
    }
    public abstract void handleArtikel(ArtikelView artikel) throws ModelException;
    
    public abstract void handleWarenlager(WarenlagerView warenlager) throws ModelException;
    
    public abstract void handleArtikelstatus(ArtikelstatusView artikelstatus) throws ModelException;
    
    public void handleVerkauf(VerkaufView verkauf) throws ModelException{
        this.handleArtikelstatus(verkauf);
    }
    public void handleAuslauf(AuslaufView auslauf) throws ModelException{
        this.handleArtikelstatus(auslauf);
    }
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException{
        this.handleArtikelstatus(neuanlage);
    }
    
}
