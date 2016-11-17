
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends ArtikelstatusReturnExceptionVisitor<R, E> ,BestellstatusReturnExceptionVisitor<R, E> ,BooleanXReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,KomponenteReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> ,ZeitObjektReturnExceptionVisitor<R, E> {
    
    public R handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException, E;
    public R handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException, E;
    public R handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException, E;
    public R handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public R handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException, E;
    public R handleBestellung(Bestellung4Public bestellung) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleHersteller(Hersteller4Public hersteller) throws PersistenceException, E;
    public R handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException, E;
    public R handleIntegerWrapper(IntegerWrapper4Public integerWrapper) throws PersistenceException, E;
    public R handleKonto(Konto4Public konto) throws PersistenceException, E;
    public R handleKunde(Kunde4Public kunde) throws PersistenceException, E;
    public R handleLieferart(Lieferart4Public lieferart) throws PersistenceException, E;
    public R handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException, E;
    public R handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public R handlePosition(Position4Public position) throws PersistenceException, E;
    public R handleProdGEntfernenCommand(ProdGEntfernenCommand4Public prodGEntfernenCommand) throws PersistenceException, E;
    public R handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public R handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public R handleThreadOfControl(ThreadOfControl4Public threadOfControl) throws PersistenceException, E;
    public R handleWarenlager(Warenlager4Public warenlager) throws PersistenceException, E;
    public R handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException, E;
    
}
