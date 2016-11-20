
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.standardHandling(artikelEinlagernCommand);
    }
    public void handleArtikelEntfernenCommand(ArtikelEntfernenCommand4Public artikelEntfernenCommand) throws PersistenceException{
        this.standardHandling(artikelEntfernenCommand);
    }
    public void handleBestellenCommand(BestellenCommand4Public bestellenCommand) throws PersistenceException{
        this.standardHandling(bestellenCommand);
    }
    public void handleZuEinkaufswHinzCommand(ZuEinkaufswHinzCommand4Public zuEinkaufswHinzCommand) throws PersistenceException{
        this.standardHandling(zuEinkaufswHinzCommand);
    }
    public void handleProduktgruppeEntfernenCommand(ProduktgruppeEntfernenCommand4Public produktgruppeEntfernenCommand) throws PersistenceException{
        this.standardHandling(produktgruppeEntfernenCommand);
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
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
