
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,BooleanXExceptionVisitor<E>,CommonDateExceptionVisitor<E>,ServiceExceptionVisitor<E>{
    
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException, E;
    public void handleAendereLieferartCommand(AendereLieferartCommand4Public aendereLieferartCommand) throws PersistenceException, E;
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException, E;
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException, E;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException, E;
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleKonto(Konto4Public konto) throws PersistenceException, E;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException, E;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException, E;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException, E;
    public void handleLieferung(Lieferung4Public lieferung) throws PersistenceException, E;
    public void handleNeueLieferartCommand(NeueLieferartCommand4Public neueLieferartCommand) throws PersistenceException, E;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public void handlePosition(Position4Public position) throws PersistenceException, E;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException, E;
    
}
