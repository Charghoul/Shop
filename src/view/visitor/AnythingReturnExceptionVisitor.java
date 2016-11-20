
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ArtikelstatusReturnExceptionVisitor<R, E> ,BestellstatusReturnExceptionVisitor<R, E> ,KomponenteReturnExceptionVisitor<R, E> ,PositionAbstraktReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> ,ZeitObjektReturnExceptionVisitor<R, E> {
    
    public R handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException, E;
    public R handleBestellManager(BestellManagerView bestellManager) throws ModelException, E;
    public R handleBestellung(BestellungView bestellung) throws ModelException, E;
    public R handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleHersteller(HerstellerView hersteller) throws ModelException, E;
    public R handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException, E;
    public R handleIntegerWrapper(IntegerWrapperView integerWrapper) throws ModelException, E;
    public R handleKonto(KontoView konto) throws ModelException, E;
    public R handleKunde(KundeView kunde) throws ModelException, E;
    public R handleLieferart(LieferartView lieferart) throws ModelException, E;
    public R handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException, E;
    public R handleProduktKatalog(ProduktKatalogView produktKatalog) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleThreadOfControl(ThreadOfControlView threadOfControl) throws ModelException, E;
    public R handleWarenlager(WarenlagerView warenlager) throws ModelException, E;
    public R handleZeitManager(ZeitManagerView zeitManager) throws ModelException, E;
    
}
