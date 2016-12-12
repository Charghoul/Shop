
package view.visitor;

import view.*;

public interface BestellstatusReturnVisitor<R> {
    
    public R handleAngenommen(AngenommenView angenommen) throws ModelException;
    public R handleGeliefert(GeliefertView geliefert) throws ModelException;
    public R handleHinversand(HinversandView hinversand) throws ModelException;
    public R handleRueckversand(RueckversandView rueckversand) throws ModelException;
    
}
