
package view.visitor;

import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException, E;
    public R handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException, E;
    public R handleExcArtikelDoesNotExist(ExcArtikelDoesNotExist excArtikelDoesNotExist) throws ModelException, E;
    public R handleExcArtikelHatKeinenHersteller(ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws ModelException, E;
    public R handleExcArtikelNichtVerfuegbar(ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws ModelException, E;
    public R handleExcArtikelNochNichtVerfuegbar(ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws ModelException, E;
    public R handleExcAuszahlungGroesserGutgaben(ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws ModelException, E;
    public R handleExcEinkaufslisteNichtVerfuegbar(ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws ModelException, E;
    public R handleExcHasChildren(ExcHasChildren excHasChildren) throws ModelException, E;
    public R handleExcHasNoParent(ExcHasNoParent excHasNoParent) throws ModelException, E;
    public R handleExcIllogicalDataEntry(ExcIllogicalDataEntry excIllogicalDataEntry) throws ModelException, E;
    public R handleExcInconsistentStatusChange(ExcInconsistentStatusChange excInconsistentStatusChange) throws ModelException, E;
    public R handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException, E;
    public R handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException, E;
    public R handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException, E;
    public R handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException, E;
    public R handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException, E;
    public R handleExcWarenwertUeberKontoguthaben(ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
