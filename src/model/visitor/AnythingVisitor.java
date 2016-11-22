
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,CommonDateVisitor,KomponenteVisitor,PositionAbstraktVisitor,ServiceVisitor,StatusVisitor,ZeitObjektVisitor{
    
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException;
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException;
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException;
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException;
    public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException;
    public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException;
    public void handleIntegerWrapper(IntegerWrapper4Public integerWrapper) throws PersistenceException;
    public void handleKonto(Konto4Public konto) throws PersistenceException;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException;
    public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException;
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException;
    public void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException;
    public void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException;
    public void handleSubj(Subj4Public subj) throws PersistenceException;
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException;
    public void handleZeitManagerZeitObjektListe(ZeitManagerZeitObjektListe4Public zeitManagerZeitObjektListe) throws PersistenceException;
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException;
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException;
    
}
