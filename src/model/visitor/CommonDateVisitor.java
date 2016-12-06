
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException;
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException;
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException;
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException;
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException;
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException;
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException;
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException;
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException;
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException;
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException;
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException;
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException;
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException;
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException;
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException;
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
