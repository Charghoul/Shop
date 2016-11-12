
package model.visitor;

import persistence.*;

public abstract class ArtikelstatusStandardVisitor implements ArtikelstatusVisitor {
    
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException{
        this.standardHandling(verkauf);
    }
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException{
        this.standardHandling(auslauf);
    }
    public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException{
        this.standardHandling(neuanlage);
    }
    protected abstract void standardHandling(Artikelstatus4Public artikelstatus) throws PersistenceException;
}
