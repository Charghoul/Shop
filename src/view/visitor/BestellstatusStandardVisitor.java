
package view.visitor;

import view.*;

public abstract class BestellstatusStandardVisitor implements BestellstatusVisitor {
    
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException{
        this.standardHandling(rueckversand);
    }
    public void handleAngenommen(AngenommenView angenommen) throws ModelException{
        this.standardHandling(angenommen);
    }
    public void handleGeliefert(GeliefertView geliefert) throws ModelException{
        this.standardHandling(geliefert);
    }
    public void handleHinversand(HinversandView hinversand) throws ModelException{
        this.standardHandling(hinversand);
    }
    public void handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException{
        this.standardHandling(verarbeitung);
    }
    protected abstract void standardHandling(BestellstatusView bestellstatus) throws ModelException;
}
