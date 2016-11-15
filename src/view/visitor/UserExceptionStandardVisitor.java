
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException{
        this.standardHandling(excLagerbestandOverMax);
    }
    public void handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException{
        this.standardHandling(excLagerbestandUnderZero);
    }
    public void handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException{
        this.standardHandling(excAlreadyExists);
    }
    public void handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException{
        this.standardHandling(excLieferartAlreadyExists);
    }
    public void handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException{
        this.standardHandling(excStatusDidNotChange);
    }
    public void handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException{
        this.standardHandling(excUserAlreadyExists);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException{
        this.standardHandling(excArtikelAlreadyExists);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
