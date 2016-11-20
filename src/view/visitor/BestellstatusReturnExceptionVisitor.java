
package view.visitor;

import view.*;

public interface BestellstatusReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAngenommen(AngenommenView angenommen) throws ModelException, E;
    public R handleGeliefert(GeliefertView geliefert) throws ModelException, E;
    public R handleHinversand(HinversandView hinversand) throws ModelException, E;
    public R handleRueckversand(RueckversandView rueckversand) throws ModelException, E;
    public R handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException, E;
    public R handleVorbestellung(VorbestellungView vorbestellung) throws ModelException, E;
    
}
