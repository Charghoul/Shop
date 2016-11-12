
package model.visitor;

import persistence.*;

public interface ArtikelstatusVisitor {
    
    public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException;
    public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException;
    public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException;
    
}
