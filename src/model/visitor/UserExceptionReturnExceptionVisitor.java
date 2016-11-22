
package model.visitor;

import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException, E;
    public R handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException, E;
    public R handleExcArtikelHatKeinenHersteller(model.ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws PersistenceException, E;
    public R handleExcArtikelNichtVerfuegbar(model.ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws PersistenceException, E;
    public R handleExcArtikelNochNichtVerfuegbar(model.ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws PersistenceException, E;
    public R handleExcEinkaufslisteNichtVerfuegbar(model.ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws PersistenceException, E;
    public R handleExcHasChildren(model.ExcHasChildren excHasChildren) throws PersistenceException, E;
    public R handleExcHasNoParent(model.ExcHasNoParent excHasNoParent) throws PersistenceException, E;
    public R handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException, E;
    public R handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException, E;
    public R handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException, E;
    public R handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException, E;
    public R handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException, E;
    public R handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException, E;
    public R handleExcWarenwertUeberKontoguthaben(model.ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
