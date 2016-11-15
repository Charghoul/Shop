
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ArtikelstatusReturnVisitor<R> ,BestellstatusReturnVisitor<R> ,BooleanXReturnVisitor<R> ,CommonDateReturnVisitor<R> ,KomponenteReturnVisitor<R> ,ServiceReturnVisitor<R> {
    
    public R handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException;
    public R handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException;
    public R handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public R handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleHersteller(Hersteller4Public hersteller) throws PersistenceException;
    public R handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException;
    public R handleKonto(Konto4Public konto) throws PersistenceException;
    public R handleKunde(Kunde4Public kunde) throws PersistenceException;
    public R handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    public R handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    public R handleLieferung(Lieferung4Public lieferung) throws PersistenceException;
    public R handleNeueProduktgruppeCommand(NeueProduktgruppeCommand4Public neueProduktgruppeCommand) throws PersistenceException;
    public R handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException;
    public R handlePosition(Position4Public position) throws PersistenceException;
    public R handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException;
    public R handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException;
    public R handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
}
