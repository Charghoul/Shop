
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.standardHandling(artikelEntfernenCommand);
    }
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException{
        this.standardHandling(einkaufsManager);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException{
        this.standardHandling(serviceAdminZeitManager);
    }
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.standardHandling(artikelEntnehmenCommand);
    }
    public void handleAnnehmenCommand(AnnehmenCommand4Public annehmenCommand) throws PersistenceException{
        this.standardHandling(annehmenCommand);
    }
    public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException{
        this.standardHandling(herstellerManager);
    }
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException{
        this.standardHandling(lieferart);
    }
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException{
        this.standardHandling(registerCommand);
    }
    public void handledeactivated(deactivated4Public deactivated) throws PersistenceException{
        this.standardHandling(deactivated);
    }
    public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException{
        this.standardHandling(neuanlage);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException{
        this.standardHandling(serviceRegister);
    }
    public void handleHstLieferung(HstLieferung4Public hstLieferung) throws PersistenceException{
        this.standardHandling(hstLieferung);
    }
    public void handleAbbuchenCommand(AbbuchenCommand4Public abbuchenCommand) throws PersistenceException{
        this.standardHandling(abbuchenCommand);
    }
    public void handleKndLieferung(KndLieferung4Public kndLieferung) throws PersistenceException{
        this.standardHandling(kndLieferung);
    }
    public void handleKndAnnahme(KndAnnahme4Public kndAnnahme) throws PersistenceException{
        this.standardHandling(kndAnnahme);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.standardHandling(serviceKunde);
    }
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException{
        this.standardHandling(zuEinkaufswHinzCommand);
    }
    public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException{
        this.standardHandling(produktKatalog);
    }
    public void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException{
        this.standardHandling(serviceShopProduktKatalog);
    }
    public void handleNeuePositionCommand(NeuePositionCommand4Public neuePositionCommand) throws PersistenceException{
        this.standardHandling(neuePositionCommand);
    }
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException{
        this.standardHandling(artikel);
    }
    public void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException{
        this.standardHandling(produktgruppe);
    }
    public void handlePosition(Position4Public position) throws PersistenceException{
        this.standardHandling(position);
    }
    public void handleServiceAdminKundenManager(ServiceAdminKundenManager4Public serviceAdminKundenManager) throws PersistenceException{
        this.standardHandling(serviceAdminKundenManager);
    }
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException{
        this.standardHandling(artikelManager);
    }
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException{
        this.standardHandling(aendereLieferartNameCommand);
    }
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException{
        this.standardHandling(produktgruppeEntfernenCommand);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.standardHandling(serviceAdmin);
    }
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.standardHandling(statusVerkaufCommand);
    }
    public void handleAuszahlenCommand(AuszahlenCommand4Public auszahlenCommand) throws PersistenceException{
        this.standardHandling(auszahlenCommand);
    }
    public void handleKonto(Konto4Public konto) throws PersistenceException{
        this.standardHandling(konto);
    }
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException{
        this.standardHandling(hersteller);
    }
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException{
        this.standardHandling(angenommen);
    }
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException{
        this.standardHandling(zuruecksendenCommand);
    }
    public void handleRetourePosition(RetourePosition4Public retourePosition) throws PersistenceException{
        this.standardHandling(retourePosition);
    }
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException{
        this.standardHandling(bestellenCommand);
    }
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException{
        this.standardHandling(aendereMinLagerbestandCommand);
    }
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException{
        this.standardHandling(warenlager);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException{
        this.standardHandling(aendereBezeichnungCommand);
    }
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException{
        this.standardHandling(vorbestellenCommand);
    }
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException{
        this.standardHandling(verkauf);
    }
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException{
        this.standardHandling(auslauf);
    }
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException{
        this.standardHandling(bestellung);
    }
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException{
        this.standardHandling(anzeigenCommand);
    }
    public void handleKundenManager(KundenManager4Public kundenManager) throws PersistenceException{
        this.standardHandling(kundenManager);
    }
    public void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException{
        this.standardHandling(serviceKundeBestellManager);
    }
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.standardHandling(artikelEinlagernCommand);
    }
    public void handleZeitManagerZeitObjektListe(ZeitManagerZeitObjektListe4Public zeitManagerZeitObjektListe) throws PersistenceException{
        this.standardHandling(zeitManagerZeitObjektListe);
    }
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException{
        this.standardHandling(geliefert);
    }
    public void handleAendereHstLieferzeitCommand(AendereHstLieferzeitCommand4Public aendereHstLieferzeitCommand) throws PersistenceException{
        this.standardHandling(aendereHstLieferzeitCommand);
    }
    public void handleRetoureLieferung(RetoureLieferung4Public retoureLieferung) throws PersistenceException{
        this.standardHandling(retoureLieferung);
    }
    public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException{
        this.standardHandling(bestellManager);
    }
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException{
        this.standardHandling(statusAuslaufCommand);
    }
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException{
        this.standardHandling(neuerArtikelCommand);
    }
    public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException{
        this.standardHandling(zeitManager);
    }
    public void handleSubj(Subj4Public subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleSuchManager(SuchManager4Public suchManager) throws PersistenceException{
        this.standardHandling(suchManager);
    }
    public void handlePositionInBestellung(PositionInBestellung4Public positionInBestellung) throws PersistenceException{
        this.standardHandling(positionInBestellung);
    }
    public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException{
        this.standardHandling(vorbestellung);
    }
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException{
        this.standardHandling(rueckversand);
    }
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException{
        this.standardHandling(aendereMaxLagerbestandCommand);
    }
    public void handleKunde(Kunde4Public kunde) throws PersistenceException{
        this.standardHandling(kunde);
    }
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException{
        this.standardHandling(lieferartManager);
    }
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException{
        this.standardHandling(hinversand);
    }
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException{
        this.standardHandling(allesZuruecksendenCommand);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleactivated(activated4Public activated) throws PersistenceException{
        this.standardHandling(activated);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
