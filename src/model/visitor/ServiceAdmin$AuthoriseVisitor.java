
package model.visitor;

import persistence.*;

public abstract class ServiceAdmin$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleVerkauf(PersistentVerkauf verkauf) throws PersistenceException;
    public abstract void handleAuslauf(PersistentAuslauf auslauf) throws PersistenceException;
    public abstract void handleVerarbeitung(PersistentVerarbeitung verarbeitung) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleBestellung(PersistentBestellung bestellung) throws PersistenceException;
    public abstract void handleLieferart(PersistentLieferart lieferart) throws PersistenceException;
    public abstract void handleHerstellerManager(PersistentHerstellerManager herstellerManager) throws PersistenceException;
    public abstract void handleNeuanlage(PersistentNeuanlage neuanlage) throws PersistenceException;
    public abstract void handleHstLieferung(PersistentHstLieferung hstLieferung) throws PersistenceException;
    public abstract void handleGeliefert(PersistentGeliefert geliefert) throws PersistenceException;
    public abstract void handleKndLieferung(PersistentKndLieferung kndLieferung) throws PersistenceException;
    public abstract void handleProduktKatalog(PersistentProduktKatalog produktKatalog) throws PersistenceException;
    public abstract void handleProduktgruppe(PersistentProduktgruppe produktgruppe) throws PersistenceException;
    public abstract void handleArtikel(PersistentArtikel artikel) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleServiceAdmin(PersistentServiceAdmin serviceAdmin) throws PersistenceException;
    public abstract void handleArtikelManager(PersistentArtikelManager artikelManager) throws PersistenceException;
    public abstract void handleZeitManager(PersistentZeitManager zeitManager) throws PersistenceException;
    public abstract void handlePositionInBestellung(PersistentPositionInBestellung positionInBestellung) throws PersistenceException;
    public abstract void handleVorbestellung(PersistentVorbestellung vorbestellung) throws PersistenceException;
    public abstract void handleHersteller(PersistentHersteller hersteller) throws PersistenceException;
    public abstract void handleRueckversand(PersistentRueckversand rueckversand) throws PersistenceException;
    public abstract void handleLieferartManager(PersistentLieferartManager lieferartManager) throws PersistenceException;
    public abstract void handleHinversand(PersistentHinversand hinversand) throws PersistenceException;
    public abstract void handleAngenommen(PersistentAngenommen angenommen) throws PersistenceException;
    public abstract void handleIntegerWrapper(PersistentIntegerWrapper integerWrapper) throws PersistenceException;
    public abstract void handleWarenlager(PersistentWarenlager warenlager) throws PersistenceException;
    
}
