
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException;
    public R handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException;
    public R handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException;
    public R handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
