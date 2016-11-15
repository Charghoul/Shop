
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,BooleanXExceptionVisitor<E>,CommonDateExceptionVisitor<E>,KomponenteExceptionVisitor<E>,ServiceExceptionVisitor<E>{
    
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException, E;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException, E;
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException, E;
    public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException, E;
    public void handleKonto(Konto4Public konto) throws PersistenceException, E;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException, E;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException, E;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException, E;
    public void handleLieferung(Lieferung4Public lieferung) throws PersistenceException, E;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public void handlePosition(Position4Public position) throws PersistenceException, E;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException, E;
    
}
