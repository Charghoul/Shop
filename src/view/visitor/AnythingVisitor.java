
package view.visitor;

import view.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,BooleanXVisitor,KomponenteVisitor,ServiceVisitor,ZeitObjektVisitor{
    
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    public void handleBestellung(BestellungView bestellung) throws ModelException;
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleHersteller(HerstellerView hersteller) throws ModelException;
    public void handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException;
    public void handleIntegerWrapper(IntegerWrapperView integerWrapper) throws ModelException;
    public void handleKonto(KontoView konto) throws ModelException;
    public void handleKunde(KundeView kunde) throws ModelException;
    public void handleLieferart(LieferartView lieferart) throws ModelException;
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    public void handlePosition(PositionView position) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleThreadOfControl(ThreadOfControlView threadOfControl) throws ModelException;
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException;
    public void handleZeitManager(ZeitManagerView zeitManager) throws ModelException;
    
}
