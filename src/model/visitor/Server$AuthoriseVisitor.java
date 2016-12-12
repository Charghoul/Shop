
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleVerkauf(PersistentVerkauf verkauf) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleAuslauf(PersistentAuslauf auslauf) throws PersistenceException;
    public abstract void handleEinkaufsManager(PersistentEinkaufsManager einkaufsManager) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleBestellung(PersistentBestellung bestellung) throws PersistenceException;
    public abstract void handleLieferart(PersistentLieferart lieferart) throws PersistenceException;
    public abstract void handleHerstellerManager(PersistentHerstellerManager herstellerManager) throws PersistenceException;
    public abstract void handleNeuanlage(PersistentNeuanlage neuanlage) throws PersistenceException;
    public abstract void handleKundenManager(PersistentKundenManager kundenManager) throws PersistenceException;
    public abstract void handleServiceRegister(PersistentServiceRegister serviceRegister) throws PersistenceException;
    public abstract void handleHstLieferung(PersistentHstLieferung hstLieferung) throws PersistenceException;
    public abstract void handleGeliefert(PersistentGeliefert geliefert) throws PersistenceException;
    public abstract void handleKndLieferung(PersistentKndLieferung kndLieferung) throws PersistenceException;
    public abstract void handleServiceKunde(PersistentServiceKunde serviceKunde) throws PersistenceException;
    public abstract void handleKndAnnahme(PersistentKndAnnahme kndAnnahme) throws PersistenceException;
    public abstract void handleProduktKatalog(PersistentProduktKatalog produktKatalog) throws PersistenceException;
    public abstract void handleProduktgruppe(PersistentProduktgruppe produktgruppe) throws PersistenceException;
    public abstract void handleArtikel(PersistentArtikel artikel) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleRetoureLieferung(PersistentRetoureLieferung retoureLieferung) throws PersistenceException;
    public abstract void handleServiceAdmin(PersistentServiceAdmin serviceAdmin) throws PersistenceException;
    public abstract void handleArtikelManager(PersistentArtikelManager artikelManager) throws PersistenceException;
    public abstract void handleBestellManager(PersistentBestellManager bestellManager) throws PersistenceException;
    public abstract void handleZeitManager(PersistentZeitManager zeitManager) throws PersistenceException;
    public abstract void handleSuchManager(PersistentSuchManager suchManager) throws PersistenceException;
    public abstract void handleKonto(PersistentKonto konto) throws PersistenceException;
    public abstract void handlePositionInBestellung(PersistentPositionInBestellung positionInBestellung) throws PersistenceException;
    public abstract void handleVorbestellung(PersistentVorbestellung vorbestellung) throws PersistenceException;
    public abstract void handleHersteller(PersistentHersteller hersteller) throws PersistenceException;
    public abstract void handleRueckversand(PersistentRueckversand rueckversand) throws PersistenceException;
    public abstract void handleKunde(PersistentKunde kunde) throws PersistenceException;
    public abstract void handleLieferartManager(PersistentLieferartManager lieferartManager) throws PersistenceException;
    public abstract void handleHinversand(PersistentHinversand hinversand) throws PersistenceException;
    public abstract void handleAngenommen(PersistentAngenommen angenommen) throws PersistenceException;
    public abstract void handleRetourePosition(PersistentRetourePosition retourePosition) throws PersistenceException;
    public abstract void handleWarenlager(PersistentWarenlager warenlager) throws PersistenceException;
    
}
