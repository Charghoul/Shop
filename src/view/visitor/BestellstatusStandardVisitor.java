
package view.visitor;

import view.*;

public abstract class BestellstatusStandardVisitor implements BestellstatusVisitor {
    
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException{
        this.standardHandling(rueckversand);
    }
    public void handleGeliefert(GeliefertView geliefert) throws ModelException{
        this.standardHandling(geliefert);
    }
    public void handleHinversand(HinversandView hinversand) throws ModelException{
        this.standardHandling(hinversand);
    }
    public void handleAngenommen(AngenommenView angenommen) throws ModelException{
        this.standardHandling(angenommen);
    }
    protected abstract void standardHandling(BestellstatusView bestellstatus) throws ModelException;
}
