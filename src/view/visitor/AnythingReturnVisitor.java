
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ArtikelstatusReturnVisitor<R> ,BestellstatusReturnVisitor<R> ,BooleanXReturnVisitor<R> ,ServiceReturnVisitor<R> {
    
    public R handleArtikel(ArtikelView artikel) throws ModelException;
    public R handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    public R handleBestellung(BestellungView bestellung) throws ModelException;
    public R handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleKonto(KontoView konto) throws ModelException;
    public R handleKunde(KundeView kunde) throws ModelException;
    public R handleLieferart(LieferartView lieferart) throws ModelException;
    public R handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    public R handleLieferung(LieferungView lieferung) throws ModelException;
    public R handlePosition(PositionView position) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleWarenlager(WarenlagerView warenlager) throws ModelException;
    
}
