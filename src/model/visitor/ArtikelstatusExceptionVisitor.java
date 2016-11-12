
package model.visitor;

import persistence.*;

public interface ArtikelstatusExceptionVisitor<E extends model.UserException> {
    
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException, E;
    public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException, E;
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException, E;
    
}
