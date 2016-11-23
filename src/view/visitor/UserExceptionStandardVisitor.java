
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleExcIllogicalDataEntry(ExcIllogicalDataEntry excIllogicalDataEntry) throws ModelException{
        this.standardHandling(excIllogicalDataEntry);
    }
    public void handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException{
        this.standardHandling(excLagerbestandOverMax);
    }
    public void handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException{
        this.standardHandling(excLagerbestandUnderZero);
    }
    public void handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException{
        this.standardHandling(excLieferartAlreadyExists);
    }
    public void handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException{
        this.standardHandling(excStatusDidNotChange);
    }
    public void handleExcAuszahlungGroesserGutgaben(ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws ModelException{
        this.standardHandling(excAuszahlungGroesserGutgaben);
    }
    public void handleExcArtikelHatKeinenHersteller(ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws ModelException{
        this.standardHandling(excArtikelHatKeinenHersteller);
    }
    public void handleExcHasChildren(ExcHasChildren excHasChildren) throws ModelException{
        this.standardHandling(excHasChildren);
    }
    public void handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException{
        this.standardHandling(excUserAlreadyExists);
    }
    public void handleExcInconsistentStatusChange(ExcInconsistentStatusChange excInconsistentStatusChange) throws ModelException{
        this.standardHandling(excInconsistentStatusChange);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleExcArtikelNochNichtVerfuegbar(ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws ModelException{
        this.standardHandling(excArtikelNochNichtVerfuegbar);
    }
    public void handleExcArtikelNichtVerfuegbar(ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws ModelException{
        this.standardHandling(excArtikelNichtVerfuegbar);
    }
    public void handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException{
        this.standardHandling(excArtikelAlreadyExists);
    }
    public void handleExcEinkaufslisteNichtVerfuegbar(ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws ModelException{
        this.standardHandling(excEinkaufslisteNichtVerfuegbar);
    }
    public void handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException{
        this.standardHandling(excAlreadyExists);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    public void handleExcHasNoParent(ExcHasNoParent excHasNoParent) throws ModelException{
        this.standardHandling(excHasNoParent);
    }
    public void handleExcWarenwertUeberKontoguthaben(ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws ModelException{
        this.standardHandling(excWarenwertUeberKontoguthaben);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
