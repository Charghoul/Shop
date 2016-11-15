
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handlePosition(Position4Public position) throws PersistenceException;
    
    public abstract void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
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
    public abstract void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    
    public abstract void handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    
    public abstract void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException;
    
    public abstract void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    
    public abstract void handleKonto(Konto4Public konto) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleKomponente(Komponente4Public komponente) throws PersistenceException;
    
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException{
        this.handleKomponente(artikel);
    }
    public void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException{
        this.handleKomponente(produktgruppe);
    }
    public abstract void handleKunde(Kunde4Public kunde) throws PersistenceException;
    
    public abstract void handleHersteller(Hersteller4Public hersteller) throws PersistenceException;
    
    public abstract void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    
    public abstract void handleLieferung(Lieferung4Public lieferung) throws PersistenceException;
    
    public abstract void handleBestellstatus(Bestellstatus4Public bestellstatus) throws PersistenceException;
    
    public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException{
        this.handleBestellstatus(vorbestellung);
    }
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
    public abstract void handleBooleanX(BooleanX4Public booleanX) throws PersistenceException;
    
    public void handleFalseX(FalseX4Public falseX) throws PersistenceException{
        this.handleBooleanX(falseX);
    }
    public void handleTrueX(TrueX4Public trueX) throws PersistenceException{
        this.handleBooleanX(trueX);
    }
    public abstract void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.handleCommonDate(artikelEntnehmenCommand);
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
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException{
        this.handleCommonDate(aendereArtikelCommand);
    }
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.handleCommonDate(statusVerkaufCommand);
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
