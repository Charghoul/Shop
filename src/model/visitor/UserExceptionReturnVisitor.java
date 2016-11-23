
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException;
    public R handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException;
    public R handleExcArtikelHatKeinenHersteller(model.ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws PersistenceException;
    public R handleExcArtikelNichtVerfuegbar(model.ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws PersistenceException;
    public R handleExcArtikelNochNichtVerfuegbar(model.ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws PersistenceException;
    public R handleExcAuszahlungGroesserGutgaben(model.ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws PersistenceException;
    public R handleExcEinkaufslisteNichtVerfuegbar(model.ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws PersistenceException;
    public R handleExcHasChildren(model.ExcHasChildren excHasChildren) throws PersistenceException;
    public R handleExcHasNoParent(model.ExcHasNoParent excHasNoParent) throws PersistenceException;
    public R handleExcIllogicalDataEntry(model.ExcIllogicalDataEntry excIllogicalDataEntry) throws PersistenceException;
    public R handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException;
    public R handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException;
    public R handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException;
    public R handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException;
    public R handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException;
    public R handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException;
    public R handleExcWarenwertUeberKontoguthaben(model.ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
