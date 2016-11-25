
package model.visitor;

import persistence.*;

public interface BestellstatusVisitor {
    
    public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException;
    public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException;
    public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException;
    public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException;
    public void handleVerarbeitung(Verarbeitung4Public verarbeitung) throws PersistenceException;
    
}
