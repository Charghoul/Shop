
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException;
    public abstract void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException;
    public abstract void handleBestellung(Bestellung4Public bestellung) throws PersistenceException;
    public abstract void handleLieferart(Lieferart4Public lieferart) throws PersistenceException;
    public abstract void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException;
    public abstract void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    public abstract void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException;
    public abstract void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException;
    public abstract void handleArtikel(Artikel4Public artikel) throws PersistenceException;
    public abstract void handlePosition(Position4Public position) throws PersistenceException;
    public abstract void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException;
    public abstract void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException;
    public abstract void handleKonto(Konto4Public konto) throws PersistenceException;
    public abstract void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException;
    public abstract void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException;
    public abstract void handleKunde(Kunde4Public kunde) throws PersistenceException;
    public abstract void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException;
    public abstract void handleHinversand(Hinversand4Public hinversand) throws PersistenceException;
    public abstract void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException;
    public abstract void handleLieferung(Lieferung4Public lieferung) throws PersistenceException;
    public abstract void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException;
    
}
