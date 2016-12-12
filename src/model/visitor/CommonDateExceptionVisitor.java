
package model.visitor;

import persistence.*;

public interface CommonDateExceptionVisitor<E extends model.UserException> {
    
    public void handleAbbuchenCommand(AbbuchenCommand4Public abbuchenCommand) throws PersistenceException, E;
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException, E;
    public void handleAendereHstLieferzeitCommand(AendereHstLieferzeitCommand4Public aendereHstLieferzeitCommand) throws PersistenceException, E;
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException, E;
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException, E;
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException, E;
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException, E;
    public void handleAnnehmenCommand(AnnehmenCommand4Public annehmenCommand) throws PersistenceException, E;
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException, E;
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException, E;
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException, E;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException, E;
    public void handleAuszahlenCommand(AuszahlenCommand4Public auszahlenCommand) throws PersistenceException, E;
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException, E;
    public void handleNeuePositionCommand(NeuePositionCommand4Public neuePositionCommand) throws PersistenceException, E;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException, E;
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException, E;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException, E;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException, E;
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException, E;
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException, E;
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
