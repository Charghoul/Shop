
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,BooleanXVisitor,CommonDateVisitor,ServiceVisitor{
    
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException;
    public void handleAendereLieferartCommand(AendereLieferartCommand4Public aendereLieferartCommand) throws PersistenceException;
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleKonto(Konto4Public konto) throws PersistenceException;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    public void handleLieferung(Lieferung4Public lieferung) throws PersistenceException;
    public void handleNeueLieferartCommand(NeueLieferartCommand4Public neueLieferartCommand) throws PersistenceException;
    public void handleNeuePositionCommand(NeuePositionCommand4Public neuePositionCommand) throws PersistenceException;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException;
    public void handlePosition(Position4Public position) throws PersistenceException;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
}
