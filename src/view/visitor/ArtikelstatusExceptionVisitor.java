
package view.visitor;

import view.*;

public interface ArtikelstatusExceptionVisitor<E extends view.UserException> {
    
    public void handleAuslauf(AuslaufView auslauf) throws ModelException, E;
    public void handleNeuanlage(NeuanlageView neuanlage) throws ModelException, E;
    public void handleVerkauf(VerkaufView verkauf) throws ModelException, E;
    
}
