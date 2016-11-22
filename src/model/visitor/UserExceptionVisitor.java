
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException;
    public void handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException;
    public void handleExcArtikelHatKeinenHersteller(model.ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws PersistenceException;
    public void handleExcArtikelNichtVerfuegbar(model.ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws PersistenceException;
    public void handleExcArtikelNochNichtVerfuegbar(model.ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws PersistenceException;
    public void handleExcEinkaufslisteNichtVerfuegbar(model.ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws PersistenceException;
    public void handleExcHasChildren(model.ExcHasChildren excHasChildren) throws PersistenceException;
    public void handleExcHasNoParent(model.ExcHasNoParent excHasNoParent) throws PersistenceException;
    public void handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException;
    public void handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException;
    public void handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException;
    public void handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException;
    public void handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException;
    public void handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException;
    public void handleExcWarenwertUeberKontoguthaben(model.ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
