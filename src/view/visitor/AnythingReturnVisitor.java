
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ArtikelstatusReturnVisitor<R> ,BestellstatusReturnVisitor<R> ,BooleanXReturnVisitor<R> ,KomponenteReturnVisitor<R> ,ServiceReturnVisitor<R> ,ZeitObjektReturnVisitor<R> {
    
    public R handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    public R handleBestellung(BestellungView bestellung) throws ModelException;
    public R handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleHersteller(HerstellerView hersteller) throws ModelException;
    public R handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException;
    public R handleIntegerWrapper(IntegerWrapperView integerWrapper) throws ModelException;
    public R handleKonto(KontoView konto) throws ModelException;
    public R handleKunde(KundeView kunde) throws ModelException;
    public R handleLieferart(LieferartView lieferart) throws ModelException;
    public R handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    public R handlePosition(PositionView position) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleThreadOfControl(ThreadOfControlView threadOfControl) throws ModelException;
    public R handleWarenlager(WarenlagerView warenlager) throws ModelException;
    public R handleZeitManager(ZeitManagerView zeitManager) throws ModelException;
    
}
