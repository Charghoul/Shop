
package view.visitor;

import view.*;

public interface AnythingVisitor extends ArtikelstatusVisitor,BestellstatusVisitor,BestellungAbstraktVisitor,KomponenteVisitor,PositionAbstraktVisitor,ServiceVisitor,StatusVisitor,ZeitObjektVisitor{
    
    public void handleArtikelManager(ArtikelManagerView artikelManager) throws ModelException;
    public void handleBestellManager(BestellManagerView bestellManager) throws ModelException;
    public void handleEinkaufsManager(EinkaufsManagerView einkaufsManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleHersteller(HerstellerView hersteller) throws ModelException;
    public void handleHerstellerManager(HerstellerManagerView herstellerManager) throws ModelException;
    public void handleKonto(KontoView konto) throws ModelException;
    public void handleKunde(KundeView kunde) throws ModelException;
    public void handleKundenManager(KundenManagerView kundenManager) throws ModelException;
    public void handleLieferart(LieferartView lieferart) throws ModelException;
    public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException;
    public void handleProduktKatalog(ProduktKatalogView produktKatalog) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleSuchManager(SuchManagerView suchManager) throws ModelException;
    public void handleWarenlager(WarenlagerView warenlager) throws ModelException;
    public void handleZeitManager(ZeitManagerView zeitManager) throws ModelException;
    
}
