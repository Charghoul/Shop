
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleAendereLieferartCommand(AendereLieferartCommand4Public aendereLieferartCommand) throws PersistenceException{
        this.standardHandling(aendereLieferartCommand);
    }
    public void handleArtikelEinlagernCommand(ArtikelEinlagernCommand4Public artikelEinlagernCommand) throws PersistenceException{
        this.standardHandling(artikelEinlagernCommand);
    }
    public void handleNeueLieferartCommand(NeueLieferartCommand4Public neueLieferartCommand) throws PersistenceException{
        this.standardHandling(neueLieferartCommand);
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
    public void handleAendereArtikelCommand(AendereArtikelCommand4Public aendereArtikelCommand) throws PersistenceException{
        this.standardHandling(aendereArtikelCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleStatusVerkaufCommand(StatusVerkaufCommand4Public statusVerkaufCommand) throws PersistenceException{
        this.standardHandling(statusVerkaufCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
