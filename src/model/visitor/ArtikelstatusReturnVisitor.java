
package model.visitor;

import persistence.*;

public interface ArtikelstatusReturnVisitor<R> {
    
    public R handleAuslauf(Auslauf4Public auslauf) throws PersistenceException;
    public R handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException;
    public R handleVerkauf(Verkauf4Public verkauf) throws PersistenceException;
    
}
