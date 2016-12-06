
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleAendereBezeichnungCommand(AendereBezeichnungCommand4Public aendereBezeichnungCommand) throws PersistenceException{
        this.standardHandling(aendereBezeichnungCommand);
    }
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException{
        this.standardHandling(vorbestellenCommand);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.standardHandling(artikelEntfernenCommand);
    }
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException{
        this.standardHandling(aendereLieferartNameCommand);
    }
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException{
        this.standardHandling(produktgruppeEntfernenCommand);
    }
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.standardHandling(artikelEntnehmenCommand);
    }
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException{
        this.standardHandling(statusAuslaufCommand);
    }
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException{
        this.standardHandling(neuerArtikelCommand);
    }
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException{
        this.standardHandling(registerCommand);
    }
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.standardHandling(statusVerkaufCommand);
    }
    public void handleAnzeigenCommand(AnzeigenCommand4Public anzeigenCommand) throws PersistenceException{
        this.standardHandling(anzeigenCommand);
    }
    public void handleAendereMaxLagerbestandCommand(AendereMaxLagerbestandCommand4Public aendereMaxLagerbestandCommand) throws PersistenceException{
        this.standardHandling(aendereMaxLagerbestandCommand);
    }
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.standardHandling(artikelEinlagernCommand);
    }
    public void handleAllesZuruecksendenCommand(AllesZuruecksendenCommand4Public allesZuruecksendenCommand) throws PersistenceException{
        this.standardHandling(allesZuruecksendenCommand);
    }
    public void handleZuruecksendenCommand(ZuruecksendenCommand4Public zuruecksendenCommand) throws PersistenceException{
        this.standardHandling(zuruecksendenCommand);
    }
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException{
        this.standardHandling(bestellenCommand);
    }
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException{
        this.standardHandling(zuEinkaufswHinzCommand);
    }
    public void handleAendereMinLagerbestandCommand(AendereMinLagerbestandCommand4Public aendereMinLagerbestandCommand) throws PersistenceException{
        this.standardHandling(aendereMinLagerbestandCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
