
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException;
    public R handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException;
    public R handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException;
    public R handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException;
    public R handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException;
    public R handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException;
    public R handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException;
    public R handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
