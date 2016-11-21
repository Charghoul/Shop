
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ArtikelstatusExceptionVisitor<E>,BestellstatusExceptionVisitor<E>,KomponenteExceptionVisitor<E>,PositionAbstraktExceptionVisitor<E>,ServiceExceptionVisitor<E>,StatusExceptionVisitor<E>,ZeitObjektExceptionVisitor<E>{
    
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException, E;
    public void handleBestellManager(BestellManagerView bestellManager) throws ModelException, E;
    public void handleBestellung(BestellungView bestellung) throws ModelException, E;
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleHersteller(HerstellerView hersteller) throws ModelException, E;
    public void handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException, E;
    public void handleIntegerWrapper(IntegerWrapperView integerWrapper) throws ModelException, E;
    public void handleKonto(KontoView konto) throws ModelException, E;
    public void handleKunde(KundeView kunde) throws ModelException, E;
    public void handleLieferart(LieferartView lieferart) throws ModelException, E;
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException, E;
    public void handleProduktKatalog(ProduktKatalogView produktKatalog) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException, E;
    public void handleZeitManager(ZeitManagerView zeitManager) throws ModelException, E;
    
}
