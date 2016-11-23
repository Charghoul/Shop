
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    public abstract void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException;
    public abstract void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    public abstract void handledeactivated(deactivated4Public deactivated) throws PersistenceException;
    public abstract void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException;
    public abstract void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    public abstract void handleHstLieferung(HstLieferung4Public hstLieferung) throws PersistenceException;
    public abstract void handleKndLieferung(KndLieferung4Public kndLieferung) throws PersistenceException;
    public abstract void handleKndAnnahme(KndAnnahme4Public kndAnnahme) throws PersistenceException;
    public abstract void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException;
    public abstract void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException;
    public abstract void handleArtikel(Artikel4Public artikel) throws PersistenceException;
    public abstract void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException;
    public abstract void handlePosition(Position4Public position) throws PersistenceException;
    public abstract void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public abstract void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException;
    public abstract void handleKonto(Konto4Public konto) throws PersistenceException;
    public abstract void handleHersteller(Hersteller4Public hersteller) throws PersistenceException;
    public abstract void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException;
    public abstract void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    public abstract void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException;
    public abstract void handleVerarbeitung(Verarbeitung4Public verarbeitung) throws PersistenceException;
    public abstract void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException;
    public abstract void handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    public abstract void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException;
    public abstract void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException;
    public abstract void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException;
    public abstract void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException;
    public abstract void handlePositionInBestellung(PositionInBestellung4Public positionInBestellung) throws PersistenceException;
    public abstract void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException;
    public abstract void handleKunde(Kunde4Public kunde) throws PersistenceException;
    public abstract void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    public abstract void handleHinversand(Hinversand4Public hinversand) throws PersistenceException;
    public abstract void handleactivated(activated4Public activated) throws PersistenceException;
    
}
