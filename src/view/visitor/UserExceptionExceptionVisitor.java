
package view.visitor;

import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException, E;
    public void handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException, E;
    public void handleExcArtikelDoesNotExist(ExcArtikelDoesNotExist excArtikelDoesNotExist) throws ModelException, E;
    public void handleExcArtikelHatKeinenHersteller(ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws ModelException, E;
    public void handleExcArtikelNichtVerfuegbar(ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws ModelException, E;
    public void handleExcArtikelNochNichtVerfuegbar(ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws ModelException, E;
    public void handleExcAuszahlungGroesserGutgaben(ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws ModelException, E;
    public void handleExcEinkaufslisteNichtVerfuegbar(ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws ModelException, E;
    public void handleExcHasChildren(ExcHasChildren excHasChildren) throws ModelException, E;
    public void handleExcHasNoParent(ExcHasNoParent excHasNoParent) throws ModelException, E;
    public void handleExcIllogicalDataEntry(ExcIllogicalDataEntry excIllogicalDataEntry) throws ModelException, E;
    public void handleExcInconsistentStatusChange(ExcInconsistentStatusChange excInconsistentStatusChange) throws ModelException, E;
    public void handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException, E;
    public void handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException, E;
    public void handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException, E;
    public void handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException, E;
    public void handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException, E;
    public void handleExcWarenwertUeberKontoguthaben(ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
