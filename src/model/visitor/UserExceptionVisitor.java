
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException;
    public void handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException;
    public void handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException;
    public void handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
