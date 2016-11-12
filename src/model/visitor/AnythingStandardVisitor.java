
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException{
        this.standardHandling(verkauf);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
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
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException{
        this.standardHandling(bestellung);
    }
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException{
        this.standardHandling(lieferart);
    }
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException{
        this.standardHandling(registerCommand);
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
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException{
        this.standardHandling(geliefert);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.standardHandling(serviceKunde);
    }
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException{
        this.standardHandling(artikel);
    }
    public void handlePosition(Position4Public position) throws PersistenceException{
        this.standardHandling(position);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.standardHandling(serviceAdmin);
    }
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException{
        this.standardHandling(artikelManager);
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
    public void handleKunde(Kunde4Public kunde) throws PersistenceException{
        this.standardHandling(kunde);
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
    public void handleLieferung(Lieferung4Public lieferung) throws PersistenceException{
        this.standardHandling(lieferung);
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
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
