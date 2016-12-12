
package model.visitor;

import persistence.*;

public interface BestellstatusReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAngenommen(Angenommen4Public angenommen) throws PersistenceException, E;
    public R handleGeliefert(Geliefert4Public geliefert) throws PersistenceException, E;
    public R handleHinversand(Hinversand4Public hinversand) throws PersistenceException, E;
    public R handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException, E;
    
}
