
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handlePositionAbstrakt(PositionAbstraktView positionAbstrakt) throws ModelException;
    
    public void handlePositionInBestellung(PositionInBestellungView positionInBestellung) throws ModelException{
        this.handlePositionAbstrakt(positionInBestellung);
    }
    public void handlePosition(PositionView position) throws ModelException{
        this.handlePositionAbstrakt(position);
    }
    public abstract void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException;
    
    public abstract void handleLieferart(LieferartView lieferart) throws ModelException;
    
    public abstract void handleKundenManager(KundenManagerView kundenManager) throws ModelException;
    
    public abstract void handleKomponente(KomponenteView komponente) throws ModelException;
    
    public void handleArtikel(ArtikelView artikel) throws ModelException{
        this.handleKomponente(artikel);
    }
    public void handleProduktgruppe(ProduktgruppeView produktgruppe) throws ModelException{
        this.handleKomponente(produktgruppe);
    }
    public abstract void handleProduktKatalog(ProduktKatalogView produktKatalog) throws ModelException;
    
    public abstract void handleBestellstatus(BestellstatusView bestellstatus) throws ModelException;
    
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
    public void handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException{
        this.handleBestellstatus(verarbeitung);
    }
    public abstract void handleStatus(StatusView status) throws ModelException;
    
    public void handledeactivated(deactivatedView deactivated) throws ModelException{
        this.handleStatus(deactivated);
    }
    public void handleactivated(activatedView activated) throws ModelException{
        this.handleStatus(activated);
    }
    public abstract void handleZeitObjekt(ZeitObjektView zeitObjekt) throws ModelException;
    
    public void handleHstLieferung(HstLieferungView hstLieferung) throws ModelException{
        this.handleZeitObjekt(hstLieferung);
    }
    public void handleRetoure(RetoureView retoure) throws ModelException{
        this.handleZeitObjekt(retoure);
    }
    public void handleKndLieferung(KndLieferungView kndLieferung) throws ModelException{
        this.handleZeitObjekt(kndLieferung);
    }
    public void handleKndAnnahme(KndAnnahmeView kndAnnahme) throws ModelException{
        this.handleZeitObjekt(kndAnnahme);
    }
    public abstract void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    
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
    public abstract void handleBestellungAbstrakt(BestellungAbstraktView bestellungAbstrakt) throws ModelException;
    
    public void handleVorbestellung(VorbestellungView vorbestellung) throws ModelException{
        this.handleBestellungAbstrakt(vorbestellung);
    }
    public void handleBestellung(BestellungView bestellung) throws ModelException{
        this.handleBestellungAbstrakt(bestellung);
    }
    public abstract void handleBestellManager(BestellManagerView bestellManager) throws ModelException;
    
    public abstract void handleZeitManager(ZeitManagerView zeitManager) throws ModelException;
    
    public abstract void handleSuchManager(SuchManagerView suchManager) throws ModelException;
    
    public abstract void handleKonto(KontoView konto) throws ModelException;
    
    public abstract void handleHersteller(HerstellerView hersteller) throws ModelException;
    
    public abstract void handleKunde(KundeView kunde) throws ModelException;
    
    public abstract void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    
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
