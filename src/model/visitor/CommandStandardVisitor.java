
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleVorbestellenCommand(VorbestellenCommand4Public vorbestellenCommand) throws PersistenceException{
        this.standardHandling(vorbestellenCommand);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.standardHandling(artikelEntfernenCommand);
    }
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException{
        this.standardHandling(produktgruppeEntfernenCommand);
    }
    public void handleAendereLieferartNameCommand(AendereLieferartNameCommand4Public aendereLieferartNameCommand) throws PersistenceException{
        this.standardHandling(aendereLieferartNameCommand);
    }
    public void handleStatusAuslaufCommand(StatusAuslaufCommand4Public statusAuslaufCommand) throws PersistenceException{
        this.standardHandling(statusAuslaufCommand);
    }
    public void handleNeuerArtikelCommand(NeuerArtikelCommand4Public neuerArtikelCommand) throws PersistenceException{
        this.standardHandling(neuerArtikelCommand);
    }
    public void handleArtikelEntnehmenCommand(ArtikelEntnehmenCommand4Public artikelEntnehmenCommand) throws PersistenceException{
        this.standardHandling(artikelEntnehmenCommand);
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
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
