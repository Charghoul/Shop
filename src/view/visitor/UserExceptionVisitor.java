
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException;
    public void handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException;
    public void handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException;
    public void handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
