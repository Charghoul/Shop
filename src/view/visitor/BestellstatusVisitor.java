
package view.visitor;

import view.*;

public interface BestellstatusVisitor {
    
    public void handleAngenommen(AngenommenView angenommen) throws ModelException;
    public void handleGeliefert(GeliefertView geliefert) throws ModelException;
    public void handleHinversand(HinversandView hinversand) throws ModelException;
    public void handleRueckversand(RueckversandView rueckversand) throws ModelException;
    public void handleVerarbeitung(VerarbeitungView verarbeitung) throws ModelException;
    public void handleVorbestellung(VorbestellungView vorbestellung) throws ModelException;
    
}
