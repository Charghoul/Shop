
package view.visitor;

import view.*;

public interface BestellstatusExceptionVisitor<E extends view.UserException> {
    
    public void handleAngenommen(AngenommenView angenommen) throws ModelException, E;
    public void handleGeliefert(GeliefertView geliefert) throws ModelException, E;
    public void handleHinversand(HinversandView hinversand) throws ModelException, E;
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException, E;
    public void handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException, E;
    
}
