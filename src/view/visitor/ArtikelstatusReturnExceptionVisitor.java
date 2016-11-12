
package view.visitor;

import view.*;

public interface ArtikelstatusReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAuslauf(AuslaufView auslauf) throws ModelException, E;
    public R handleNeuanlage(NeuanlageView neuanlage) throws ModelException, E;
    public R handleVerkauf(VerkaufView verkauf) throws ModelException, E;
    
}
