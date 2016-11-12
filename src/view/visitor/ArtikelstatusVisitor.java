
package view.visitor;

import view.*;

public interface ArtikelstatusVisitor {
    
    public void handleAuslauf(AuslaufView auslauf) throws ModelException;
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException;
    public void handleVerkauf(VerkaufView verkauf) throws ModelException;
    
}
