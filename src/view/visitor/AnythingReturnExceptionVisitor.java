
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ArtikelstatusReturnExceptionVisitor<R, E> ,BestellstatusReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> {
    
    public R handleArtikel(ArtikelView artikel) throws ModelException, E;
    public R handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException, E;
    public R handleBestellung(BestellungView bestellung) throws ModelException, E;
    public R handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleKonto(KontoView konto) throws ModelException, E;
    public R handleKunde(KundeView kunde) throws ModelException, E;
    public R handleLieferart(LieferartView lieferart) throws ModelException, E;
    public R handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException, E;
    public R handleLieferung(LieferungView lieferung) throws ModelException, E;
    public R handlePosition(PositionView position) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleWarenlager(WarenlagerView warenlager) throws ModelException, E;
    
}
