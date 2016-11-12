
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,ServiceExceptionVisitor<E>{
    
    public void handleArtikel(ArtikelView artikel) throws ModelException, E;
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException, E;
    public void handleBestellung(BestellungView bestellung) throws ModelException, E;
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleKonto(KontoView konto) throws ModelException, E;
    public void handleKunde(KundeView kunde) throws ModelException, E;
    public void handleLieferart(LieferartView lieferart) throws ModelException, E;
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException, E;
    public void handleLieferung(LieferungView lieferung) throws ModelException, E;
    public void handlePosition(PositionView position) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException, E;
    
}
