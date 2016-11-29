
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException{
        this.standardHandling(einkaufsManager);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException{
        this.standardHandling(herstellerManager);
    }
    public void handleLieferart(LieferartView lieferart) throws ModelException{
        this.standardHandling(lieferart);
    }
    public void handledeactivated(deactivatedView deactivated) throws ModelException{
        this.standardHandling(deactivated);
    }
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException{
        this.standardHandling(neuanlage);
    }
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.standardHandling(serviceRegister);
    }
    public void handleHstLieferung(HstLieferungView hstLieferung) throws ModelException{
        this.standardHandling(hstLieferung);
    }
    public void handleKndLieferung(KndLieferungView kndLieferung) throws ModelException{
        this.standardHandling(kndLieferung);
    }
    public void handleKndAnnahme(KndAnnahmeView kndAnnahme) throws ModelException{
        this.standardHandling(kndAnnahme);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.standardHandling(serviceKunde);
    }
    public void handleProduktKatalog(ProduktKatalogView produktKatalog) throws ModelException{
        this.standardHandling(produktKatalog);
    }
    public void handleArtikel(ArtikelView artikel) throws ModelException{
        this.standardHandling(artikel);
    }
    public void handleProduktgruppe(ProduktgruppeView produktgruppe) throws ModelException{
        this.standardHandling(produktgruppe);
    }
    public void handlePosition(PositionView position) throws ModelException{
        this.standardHandling(position);
    }
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException{
        this.standardHandling(artikelManager);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.standardHandling(serviceAdmin);
    }
    public void handleKonto(KontoView konto) throws ModelException{
        this.standardHandling(konto);
    }
    public void handleHersteller(HerstellerView hersteller) throws ModelException{
        this.standardHandling(hersteller);
    }
    public void handleAngenommen(AngenommenView angenommen) throws ModelException{
        this.standardHandling(angenommen);
    }
    public void handleRetourePosition(RetourePositionView retourePosition) throws ModelException{
        this.standardHandling(retourePosition);
    }
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException{
        this.standardHandling(warenlager);
    }
    public void handleVerkauf(VerkaufView verkauf) throws ModelException{
        this.standardHandling(verkauf);
    }
    public void handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException{
        this.standardHandling(verarbeitung);
    }
    public void handleAuslauf(AuslaufView auslauf) throws ModelException{
        this.standardHandling(auslauf);
    }
    public void handleBestellung(BestellungView bestellung) throws ModelException{
        this.standardHandling(bestellung);
    }
    public void handleKundenManager(KundenManagerView kundenManager) throws ModelException{
        this.standardHandling(kundenManager);
    }
    public void handleGeliefert(GeliefertView geliefert) throws ModelException{
        this.standardHandling(geliefert);
    }
    public void handleRetoureLieferung(RetoureLieferungView retoureLieferung) throws ModelException{
        this.standardHandling(retoureLieferung);
    }
    public void handleBestellManager(BestellManagerView bestellManager) throws ModelException{
        this.standardHandling(bestellManager);
    }
    public void handleZeitManager(ZeitManagerView zeitManager) throws ModelException{
        this.standardHandling(zeitManager);
    }
    public void handleSuchManager(SuchManagerView suchManager) throws ModelException{
        this.standardHandling(suchManager);
    }
    public void handlePositionInBestellung(PositionInBestellungView positionInBestellung) throws ModelException{
        this.standardHandling(positionInBestellung);
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
    public void handleactivated(activatedView activated) throws ModelException{
        this.standardHandling(activated);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
