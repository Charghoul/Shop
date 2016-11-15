
package view.visitor;

import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException, E;
    public R handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException, E;
    public R handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException, E;
    public R handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException, E;
    public R handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException, E;
    public R handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException, E;
    public R handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
