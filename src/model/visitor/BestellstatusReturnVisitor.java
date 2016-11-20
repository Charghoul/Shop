
package model.visitor;

import persistence.*;

public interface BestellstatusReturnVisitor<R> {
    
    public R handleAngenommen(Angenommen4Public angenommen) throws PersistenceException;
    public R handleGeliefert(Geliefert4Public geliefert) throws PersistenceException;
    public R handleHinversand(Hinversand4Public hinversand) throws PersistenceException;
    public R handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException;
    public R handleVerarbeitung(Verarbeitung4Public verarbeitung) throws PersistenceException;
    public R handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException;
    
}
