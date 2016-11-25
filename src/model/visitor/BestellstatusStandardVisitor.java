
package model.visitor;

import persistence.*;

public abstract class BestellstatusStandardVisitor implements BestellstatusVisitor {
    
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException{
        this.standardHandling(rueckversand);
    }
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException{
        this.standardHandling(geliefert);
    }
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException{
        this.standardHandling(hinversand);
    }
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException{
        this.standardHandling(angenommen);
    }
    public void handleVerarbeitung(Verarbeitung4Public verarbeitung) throws PersistenceException{
        this.standardHandling(verarbeitung);
    }
    protected abstract void standardHandling(Bestellstatus4Public bestellstatus) throws PersistenceException;
}
