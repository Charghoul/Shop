
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handlePositionAbstrakt(PositionAbstrakt4Public positionAbstrakt) throws PersistenceException;
    
    public void handlePositionInBestellung(PositionInBestellung4Public positionInBestellung) throws PersistenceException{
        this.handlePositionAbstrakt(positionInBestellung);
    }
    public void handlePosition(Position4Public position) throws PersistenceException{
        this.handlePositionAbstrakt(position);
    }
    public abstract void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException;
    
    public abstract void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException;
    
    public abstract void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    
    public abstract void handleKundenManager(KundenManager4Public kundenManager) throws PersistenceException;
    
    public abstract void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleKomponente(Komponente4Public komponente) throws PersistenceException;
    
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException{
        this.handleKomponente(artikel);
    }
    public void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException{
        this.handleKomponente(produktgruppe);
    }
    public abstract void handleZeitManagerZeitObjektListe(ZeitManagerZeitObjektListe4Public zeitManagerZeitObjektListe) throws PersistenceException;
    
    public abstract void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException;
    
    public abstract void handleBestellstatus(Bestellstatus4Public bestellstatus) throws PersistenceException;
    
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException{
        this.handleBestellstatus(rueckversand);
    }
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException{
        this.handleBestellstatus(geliefert);
    }
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException{
        this.handleBestellstatus(hinversand);
    }
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException{
        this.handleBestellstatus(angenommen);
    }
    public abstract void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException;
    
    public abstract void handleStatus(Status4Public status) throws PersistenceException;
    
    public void handledeactivated(deactivated4Public deactivated) throws PersistenceException{
        this.handleStatus(deactivated);
    }
    public void handleactivated(activated4Public activated) throws PersistenceException{
        this.handleStatus(activated);
    }
    public abstract void handleServiceAdminKundenManager(ServiceAdminKundenManager4Public serviceAdminKundenManager) throws PersistenceException;
    
    public abstract void handleZeitObjekt(ZeitObjekt4Public zeitObjekt) throws PersistenceException;
    
    public void handleHstLieferung(HstLieferung4Public hstLieferung) throws PersistenceException{
        this.handleZeitObjekt(hstLieferung);
    }
    public void handleRetoureLieferung(RetoureLieferung4Public retoureLieferung) throws PersistenceException{
        this.handleZeitObjekt(retoureLieferung);
    }
    public void handleRetourePosition(RetourePosition4Public retourePosition) throws PersistenceException{
        this.handleZeitObjekt(retourePosition);
    }
    public void handleKndLieferung(KndLieferung4Public kndLieferung) throws PersistenceException{
        this.handleZeitObjekt(kndLieferung);
    }
    public void handleKndAnnahme(KndAnnahme4Public kndAnnahme) throws PersistenceException{
        this.handleZeitObjekt(kndAnnahme);
    }
    public abstract void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException{
        this.handleService(serviceRegister);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.handleService(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.handleService(serviceAdmin);
    }
    public abstract void handleBestellungAbstrakt(BestellungAbstrakt4Public bestellungAbstrakt) throws PersistenceException;
    
    public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException{
        this.handleBestellungAbstrakt(vorbestellung);
    }
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException{
        this.handleBestellungAbstrakt(bestellung);
    }
    public abstract void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException;
    
    public abstract void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException;
    
    public abstract void handleSubj(Subj4Public subj) throws PersistenceException;
    
    public abstract void handleSuchManager(SuchManager4Public suchManager) throws PersistenceException;
    
    public abstract void handleKonto(Konto4Public konto) throws PersistenceException;
    
    public abstract void handleHersteller(Hersteller4Public hersteller) throws PersistenceException;
    
    public abstract void handleKunde(Kunde4Public kunde) throws PersistenceException;
    
    public abstract void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    
    public abstract void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException{
        this.handleCommonDate(aendereBezeichnungCommand);
    }
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException{
        this.handleCommonDate(vorbestellenCommand);
    }
    public void handleAendereHstLieferzeitCommand(AendereHstLieferzeitCommand4Public aendereHstLieferzeitCommand) throws PersistenceException{
        this.handleCommonDate(aendereHstLieferzeitCommand);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.handleCommonDate(artikelEntfernenCommand);
    }
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException{
        this.handleCommonDate(aendereLieferartNameCommand);
    }
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException{
        this.handleCommonDate(produktgruppeEntfernenCommand);
    }
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.handleCommonDate(artikelEntnehmenCommand);
    }
    public void handleAnnehmenCommand(AnnehmenCommand4Public annehmenCommand) throws PersistenceException{
        this.handleCommonDate(annehmenCommand);
    }
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException{
        this.handleCommonDate(statusAuslaufCommand);
    }
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException{
        this.handleCommonDate(neuerArtikelCommand);
    }
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException{
        this.handleCommonDate(registerCommand);
    }
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.handleCommonDate(statusVerkaufCommand);
    }
    public void handleAuszahlenCommand(AuszahlenCommand4Public auszahlenCommand) throws PersistenceException{
        this.handleCommonDate(auszahlenCommand);
    }
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException{
        this.handleCommonDate(anzeigenCommand);
    }
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException{
        this.handleCommonDate(aendereMaxLagerbestandCommand);
    }
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.handleCommonDate(artikelEinlagernCommand);
    }
    public void handleAbbuchenCommand(AbbuchenCommand4Public abbuchenCommand) throws PersistenceException{
        this.handleCommonDate(abbuchenCommand);
    }
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException{
        this.handleCommonDate(allesZuruecksendenCommand);
    }
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException{
        this.handleCommonDate(zuruecksendenCommand);
    }
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException{
        this.handleCommonDate(bestellenCommand);
    }
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException{
        this.handleCommonDate(zuEinkaufswHinzCommand);
    }
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException{
        this.handleCommonDate(aendereMinLagerbestandCommand);
    }
    public void handleNeuePositionCommand(NeuePositionCommand4Public neuePositionCommand) throws PersistenceException{
        this.handleCommonDate(neuePositionCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    public abstract void handleArtikelstatus(Artikelstatus4Public artikelstatus) throws PersistenceException;
    
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException{
        this.handleArtikelstatus(verkauf);
    }
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException{
        this.handleArtikelstatus(auslauf);
    }
    public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException{
        this.handleArtikelstatus(neuanlage);
    }
    
}
