
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException{
        this.standardHandling(verkauf);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.standardHandling(artikelEntfernenCommand);
    }
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException{
        this.standardHandling(einkaufsManager);
    }
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException{
        this.standardHandling(auslauf);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleFalseX(FalseX4Public falseX) throws PersistenceException{
        this.standardHandling(falseX);
    }
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException{
        this.standardHandling(bestellung);
    }
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.standardHandling(artikelEntnehmenCommand);
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
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException{
        this.standardHandling(aendereArtikelCommand);
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
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.standardHandling(artikelEinlagernCommand);
    }
    public void handleHstLieferung(HstLieferung4Public hstLieferung) throws PersistenceException{
        this.standardHandling(hstLieferung);
    }
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException{
        this.standardHandling(geliefert);
    }
    public void handleKndLieferung(KndLieferung4Public kndLieferung) throws PersistenceException{
        this.standardHandling(kndLieferung);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.standardHandling(serviceKunde);
    }
    public void handleThreadOfControl(ThreadOfControl4Public threadOfControl) throws PersistenceException{
        this.standardHandling(threadOfControl);
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
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException{
        this.standardHandling(artikelManager);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.standardHandling(serviceAdmin);
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
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.standardHandling(statusVerkaufCommand);
    }
    public void handleKonto(Konto4Public konto) throws PersistenceException{
        this.standardHandling(konto);
    }
    public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException{
        this.standardHandling(vorbestellung);
    }
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException{
        this.standardHandling(rueckversand);
    }
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException{
        this.standardHandling(hersteller);
    }
    public void handleKunde(Kunde4Public kunde) throws PersistenceException{
        this.standardHandling(kunde);
    }
    public void handleProdGEntfernenCommand(ProdGEntfernenCommand4Public prodGEntfernenCommand) throws PersistenceException{
        this.standardHandling(prodGEntfernenCommand);
    }
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException{
        this.standardHandling(lieferartManager);
    }
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException{
        this.standardHandling(hinversand);
    }
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException{
        this.standardHandling(angenommen);
    }
    public void handleIntegerWrapper(IntegerWrapper4Public integerWrapper) throws PersistenceException{
        this.standardHandling(integerWrapper);
    }
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException{
        this.standardHandling(warenlager);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleTrueX(TrueX4Public trueX) throws PersistenceException{
        this.standardHandling(trueX);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
