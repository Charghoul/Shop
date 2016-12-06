
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,BestellungAbstraktExceptionVisitor<E>,CommonDateExceptionVisitor<E>,KomponenteExceptionVisitor<E>,PositionAbstraktExceptionVisitor<E>,ServiceExceptionVisitor<E>,StatusExceptionVisitor<E>,ZeitObjektExceptionVisitor<E>{
    
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException, E;
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException, E;
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException, E;
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException, E;
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException, E;
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException, E;
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException, E;
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException, E;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException, E;
    public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException, E;
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException, E;
    public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException, E;
    public void handleKonto(Konto4Public konto) throws PersistenceException, E;
    public void handleKunde(Kunde4Public kunde) throws PersistenceException, E;
    public void handleKundenManager(KundenManager4Public kundenManager) throws PersistenceException, E;
    public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException, E;
    public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException, E;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException, E;
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException, E;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleServiceAdminKundenManager(ServiceAdminKundenManager4Public serviceAdminKundenManager) throws PersistenceException, E;
    public void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException, E;
    public void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException, E;
    public void handleServiceKundeWarenlager(ServiceKundeWarenlager4Public serviceKundeWarenlager) throws PersistenceException, E;
    public void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException, E;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleSuchManager(SuchManager4Public suchManager) throws PersistenceException, E;
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException, E;
    public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException, E;
    public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException, E;
    public void handleZeitManagerZeitObjektListe(ZeitManagerZeitObjektListe4Public zeitManagerZeitObjektListe) throws PersistenceException, E;
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException, E;
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException, E;
    
}
