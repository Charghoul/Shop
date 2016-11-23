
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleExcAlreadyExists(ExcAlreadyExists excAlreadyExists) throws ModelException;
    public R handleExcArtikelAlreadyExists(ExcArtikelAlreadyExists excArtikelAlreadyExists) throws ModelException;
    public R handleExcArtikelHatKeinenHersteller(ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws ModelException;
    public R handleExcArtikelNichtVerfuegbar(ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws ModelException;
    public R handleExcArtikelNochNichtVerfuegbar(ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws ModelException;
    public R handleExcAuszahlungGroesserGutgaben(ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws ModelException;
    public R handleExcEinkaufslisteNichtVerfuegbar(ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws ModelException;
    public R handleExcHasChildren(ExcHasChildren excHasChildren) throws ModelException;
    public R handleExcHasNoParent(ExcHasNoParent excHasNoParent) throws ModelException;
    public R handleExcIllogicalDataEntry(ExcIllogicalDataEntry excIllogicalDataEntry) throws ModelException;
    public R handleExcInconsistentStatusChange(ExcInconsistentStatusChange excInconsistentStatusChange) throws ModelException;
    public R handleExcLagerbestandOverMax(ExcLagerbestandOverMax excLagerbestandOverMax) throws ModelException;
    public R handleExcLagerbestandUnderZero(ExcLagerbestandUnderZero excLagerbestandUnderZero) throws ModelException;
    public R handleExcLieferartAlreadyExists(ExcLieferartAlreadyExists excLieferartAlreadyExists) throws ModelException;
    public R handleExcStatusDidNotChange(ExcStatusDidNotChange excStatusDidNotChange) throws ModelException;
    public R handleExcUserAlreadyExists(ExcUserAlreadyExists excUserAlreadyExists) throws ModelException;
    public R handleExcWarenwertUeberKontoguthaben(ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
