
package view.visitor;

import view.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,ServiceVisitor{
    
    public void handleArtikel(ArtikelView artikel) throws ModelException;
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    public void handleBestellung(BestellungView bestellung) throws ModelException;
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleKonto(KontoView konto) throws ModelException;
    public void handleKunde(KundeView kunde) throws ModelException;
    public void handleLieferart(LieferartView lieferart) throws ModelException;
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    public void handleLieferung(LieferungView lieferung) throws ModelException;
    public void handlePosition(PositionView position) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException;
    
}
