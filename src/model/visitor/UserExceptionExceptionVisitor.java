
package model.visitor;

import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleExcAlreadyExists(model.ExcAlreadyExists excAlreadyExists) throws PersistenceException, E;
    public void handleExcArtikelAlreadyExists(model.ExcArtikelAlreadyExists excArtikelAlreadyExists) throws PersistenceException, E;
    public void handleExcArtikelDoesNotExist(model.ExcArtikelDoesNotExist excArtikelDoesNotExist) throws PersistenceException, E;
    public void handleExcArtikelHatKeinenHersteller(model.ExcArtikelHatKeinenHersteller excArtikelHatKeinenHersteller) throws PersistenceException, E;
    public void handleExcArtikelNichtVerfuegbar(model.ExcArtikelNichtVerfuegbar excArtikelNichtVerfuegbar) throws PersistenceException, E;
    public void handleExcArtikelNochNichtVerfuegbar(model.ExcArtikelNochNichtVerfuegbar excArtikelNochNichtVerfuegbar) throws PersistenceException, E;
    public void handleExcAuszahlungGroesserGutgaben(model.ExcAuszahlungGroesserGutgaben excAuszahlungGroesserGutgaben) throws PersistenceException, E;
    public void handleExcEinkaufslisteNichtVerfuegbar(model.ExcEinkaufslisteNichtVerfuegbar excEinkaufslisteNichtVerfuegbar) throws PersistenceException, E;
    public void handleExcHasChildren(model.ExcHasChildren excHasChildren) throws PersistenceException, E;
    public void handleExcHasNoParent(model.ExcHasNoParent excHasNoParent) throws PersistenceException, E;
    public void handleExcIllogicalDataEntry(model.ExcIllogicalDataEntry excIllogicalDataEntry) throws PersistenceException, E;
    public void handleExcInconsistentStatusChange(model.ExcInconsistentStatusChange excInconsistentStatusChange) throws PersistenceException, E;
    public void handleExcLagerbestandOverMax(model.ExcLagerbestandOverMax excLagerbestandOverMax) throws PersistenceException, E;
    public void handleExcLagerbestandUnderZero(model.ExcLagerbestandUnderZero excLagerbestandUnderZero) throws PersistenceException, E;
    public void handleExcLieferartAlreadyExists(model.ExcLieferartAlreadyExists excLieferartAlreadyExists) throws PersistenceException, E;
    public void handleExcStatusDidNotChange(model.ExcStatusDidNotChange excStatusDidNotChange) throws PersistenceException, E;
    public void handleExcUserAlreadyExists(model.ExcUserAlreadyExists excUserAlreadyExists) throws PersistenceException, E;
    public void handleExcWarenwertUeberKontoguthaben(model.ExcWarenwertUeberKontoguthaben excWarenwertUeberKontoguthaben) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
