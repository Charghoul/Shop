
package model.visitor;

import persistence.*;

public abstract class ServiceKunde$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleVerkauf(PersistentVerkauf verkauf) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleEinkaufsManager(PersistentEinkaufsManager einkaufsManager) throws PersistenceException;
    public abstract void handleAuslauf(PersistentAuslauf auslauf) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleArtikelManager(PersistentArtikelManager artikelManager) throws PersistenceException;
    public abstract void handleNeuanlage(PersistentNeuanlage neuanlage) throws PersistenceException;
    public abstract void handleHersteller(PersistentHersteller hersteller) throws PersistenceException;
    public abstract void handleServiceKunde(PersistentServiceKunde serviceKunde) throws PersistenceException;
    public abstract void handleArtikel(PersistentArtikel artikel) throws PersistenceException;
    public abstract void handleProduktgruppe(PersistentProduktgruppe produktgruppe) throws PersistenceException;
    
}
