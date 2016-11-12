
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,CommonDateVisitor,ServiceVisitor{
    
    public void handleArtikel(Artikel4Public artikel) throws PersistenceException;
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
    public void handlePosition(Position4Public position) throws PersistenceException;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
}
