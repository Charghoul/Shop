
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ArtikelstatusReturnVisitor<R> ,BestellstatusReturnVisitor<R> ,BestellungAbstraktReturnVisitor<R> ,CommonDateReturnVisitor<R> ,KomponenteReturnVisitor<R> ,PositionAbstraktReturnVisitor<R> ,ServiceReturnVisitor<R> ,StatusReturnVisitor<R> ,ZeitObjektReturnVisitor<R> {
    
    public R handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException;
    public R handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException;
    public R handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException;
    public R handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException;
    public R handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public R handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException;
    public R handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException;
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
    public R handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException;
    public R handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException;
    public R handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException;
    public R handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException;
    public R handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException;
    public R handleServiceKundeWarenlager(ServiceKundeWarenlager4Public serviceKundeWarenlager) throws PersistenceException;
    public R handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException;
    public R handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException;
    public R handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException;
    public R handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    public R handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException;
    public R handleZeitManagerZeitObjektListe(ZeitManagerZeitObjektListe4Public zeitManagerZeitObjektListe) throws PersistenceException;
    public R handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException;
    public R handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException;
    
}
