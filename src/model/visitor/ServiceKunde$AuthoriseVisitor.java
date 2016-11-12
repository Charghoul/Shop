
package model.visitor;

import persistence.*;

public abstract class ServiceKunde$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleEinkaufsManager(PersistentEinkaufsManager einkaufsManager) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleServiceKunde(PersistentServiceKunde serviceKunde) throws PersistenceException;
    public abstract void handleArtikel(PersistentArtikel artikel) throws PersistenceException;
    
}
