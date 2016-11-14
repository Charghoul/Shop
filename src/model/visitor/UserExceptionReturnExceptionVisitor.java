
package model.visitor;

import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException, E;
    public R handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException, E;
    public R handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException, E;
    public R handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
