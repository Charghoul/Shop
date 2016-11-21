
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,CommonDateExceptionVisitor<E>,KomponenteExceptionVisitor<E>,PositionAbstraktExceptionVisitor<E>,ServiceExceptionVisitor<E>,StatusExceptionVisitor<E>,ZeitObjektExceptionVisitor<E>{
    
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException, E;
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException, E;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException, E;
    public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException, E;
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException, E;
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException, E;
    public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException, E;
    public void handleIntegerWrapper(IntegerWrapper4Public integerWrapper) throws PersistenceException, E;
    public void handleKonto(Konto4Public konto) throws PersistenceException, E;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException, E;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException, E;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException, E;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException, E;
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException, E;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException, E;
    public void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException, E;
    public void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException, E;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException, E;
    public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException, E;
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException, E;
    
}
