
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleVerkauf(VerkaufView verkauf) throws ModelException{
        this.standardHandling(verkauf);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException{
        this.standardHandling(einkaufsManager);
    }
    public void handleAuslauf(AuslaufView auslauf) throws ModelException{
        this.standardHandling(auslauf);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleBestellung(BestellungView bestellung) throws ModelException{
        this.standardHandling(bestellung);
    }
    public void handleLieferart(LieferartView lieferart) throws ModelException{
        this.standardHandling(lieferart);
    }
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException{
        this.standardHandling(neuanlage);
    }
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.standardHandling(serviceRegister);
    }
    public void handleGeliefert(GeliefertView geliefert) throws ModelException{
        this.standardHandling(geliefert);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.standardHandling(serviceKunde);
    }
    public void handleArtikel(ArtikelView artikel) throws ModelException{
        this.standardHandling(artikel);
    }
    public void handlePosition(PositionView position) throws ModelException{
        this.standardHandling(position);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.standardHandling(serviceAdmin);
    }
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException{
        this.standardHandling(artikelManager);
    }
    public void handleKonto(KontoView konto) throws ModelException{
        this.standardHandling(konto);
    }
    public void handleVorbestellung(VorbestellungView vorbestellung) throws ModelException{
        this.standardHandling(vorbestellung);
    }
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException{
        this.standardHandling(rueckversand);
    }
    public void handleKunde(KundeView kunde) throws ModelException{
        this.standardHandling(kunde);
    }
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException{
        this.standardHandling(lieferartManager);
    }
    public void handleHinversand(HinversandView hinversand) throws ModelException{
        this.standardHandling(hinversand);
    }
    public void handleAngenommen(AngenommenView angenommen) throws ModelException{
        this.standardHandling(angenommen);
    }
    public void handleLieferung(LieferungView lieferung) throws ModelException{
        this.standardHandling(lieferung);
    }
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException{
        this.standardHandling(warenlager);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
