
package view.visitor;

import view.*;

public interface ArtikelstatusReturnVisitor<R> {
    
    public R handleAuslauf(AuslaufView auslauf) throws ModelException;
    public R handleNeuanlage(NeuanlageView neuanlage) throws ModelException;
    public R handleVerkauf(VerkaufView verkauf) throws ModelException;
    
}
