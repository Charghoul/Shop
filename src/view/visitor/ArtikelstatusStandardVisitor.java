
package view.visitor;

import view.*;

public abstract class ArtikelstatusStandardVisitor implements ArtikelstatusVisitor {
    
    public void handleVerkauf(VerkaufView verkauf) throws ModelException{
        this.standardHandling(verkauf);
    }
    public void handleAuslauf(AuslaufView auslauf) throws ModelException{
        this.standardHandling(auslauf);
    }
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException{
        this.standardHandling(neuanlage);
    }
    protected abstract void standardHandling(ArtikelstatusView artikelstatus) throws ModelException;
}
