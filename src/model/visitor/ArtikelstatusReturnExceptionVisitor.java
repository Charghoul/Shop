
package model.visitor;

import persistence.*;

public interface ArtikelstatusReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAuslauf(Auslauf4Public auslauf) throws PersistenceException, E;
    public R handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException, E;
    public R handleVerkauf(Verkauf4Public verkauf) throws PersistenceException, E;
    
}
