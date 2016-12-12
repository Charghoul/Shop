
package model.visitor;

import persistence.*;

public interface BestellstatusExceptionVisitor<E extends model.UserException> {
    
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException, E;
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException, E;
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException, E;
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException, E;
    
}
