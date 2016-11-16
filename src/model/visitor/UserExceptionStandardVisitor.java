
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException{
        this.standardHandling(excLagerbestandOverMax);
    }
    public void handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException{
        this.standardHandling(excLagerbestandUnderZero);
    }
    public void handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException{
        this.standardHandling(excLieferartAlreadyExists);
    }
    public void handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException{
        this.standardHandling(excAlreadyExists);
    }
    public void handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException{
        this.standardHandling(excStatusDidNotChange);
    }
    public void handleExcHasChildren(model.ExcHasChildren excHasChildren) throws PersistenceException{
        this.standardHandling(excHasChildren);
    }
    public void handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException{
        this.standardHandling(excUserAlreadyExists);
    }
    public void handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException{
        this.standardHandling(excInconsistentStatusChange);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException{
        this.standardHandling(excArtikelAlreadyExists);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleExcHasNoParent(model.ExcHasNoParent excHasNoParent) throws PersistenceException{
        this.standardHandling(excHasNoParent);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
