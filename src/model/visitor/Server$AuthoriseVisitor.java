
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleEinkaufsManager(PersistentEinkaufsManager einkaufsManager) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleServiceAdmin(PersistentServiceAdmin serviceAdmin) throws PersistenceException;
    public abstract void handleArtikelManager(PersistentArtikelManager artikelManager) throws PersistenceException;
    public abstract void handleLieferart(PersistentLieferart lieferart) throws PersistenceException;
    public abstract void handleServiceRegister(PersistentServiceRegister serviceRegister) throws PersistenceException;
    public abstract void handleLieferartManager(PersistentLieferartManager lieferartManager) throws PersistenceException;
    public abstract void handleServiceKunde(PersistentServiceKunde serviceKunde) throws PersistenceException;
    public abstract void handleArtikel(PersistentArtikel artikel) throws PersistenceException;
    public abstract void handleWarenlager(PersistentWarenlager warenlager) throws PersistenceException;
    
}
