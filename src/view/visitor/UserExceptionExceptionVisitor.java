
package view.visitor;

import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException, E;
    public void handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException, E;
    public void handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException, E;
    public void handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException, E;
    public void handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
