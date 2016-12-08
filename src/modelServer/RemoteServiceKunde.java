
package modelServer;


import persistence.*;

public  class RemoteServiceKunde extends RemoteServiceShop {

	
	public RemoteServiceKunde(String connectionName, String userName, PersistentServiceKunde server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> artikel_Path_In_NeuePosition(){
        try {
            ProduktKatalog4Public result = ((PersistentServiceKunde)this.server).artikel_Path_In_NeuePosition();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> lieferart_Path_In_Bestellen(){
        try {
            LieferartManager4Public result = ((PersistentServiceKunde)this.server).lieferart_Path_In_Bestellen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> lieferart_Path_In_Vorbestellen(){
        try {
            LieferartManager4Public result = ((PersistentServiceKunde)this.server).lieferart_Path_In_Vorbestellen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> serviceKunde_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServiceKunde)this.server).serviceKunde_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereMenge(String positionProxiString, String mengeAsString){
        try {
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceKunde)this.server).aendereMenge(position, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLagerbestandUnderZero e0){
            return createExceptionResult(e0, this);
        }catch(model.ExcLagerbestandOverMax e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> allesZuruecksenden(String bestellungProxiString){
        try {
            PersistentBestellung bestellung = (PersistentBestellung)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(bestellungProxiString));
            ((PersistentServiceKunde)this.server).allesZuruecksenden(bestellung);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> annehmen(String bestellungProxiString){
        try {
            PersistentBestellung bestellung = (PersistentBestellung)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(bestellungProxiString));
            ((PersistentServiceKunde)this.server).annehmen(bestellung);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> auszahlen(String kontoProxiString, String betragAsString){
        try {
            PersistentKonto konto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(kontoProxiString));
            long betrag = new Long(betragAsString).longValue();
            ((PersistentServiceKunde)this.server).auszahlen(konto, betrag);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> bestellen(String einkaufsManagerProxiString, String lieferartProxiString){
        try {
            PersistentEinkaufsManager einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(einkaufsManagerProxiString));
            PersistentLieferart lieferart = (PersistentLieferart)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferartProxiString));
            ((PersistentServiceKunde)this.server).bestellen(einkaufsManager, lieferart);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> einzahlen(String kontoProxiString, String betragAsString){
        try {
            PersistentKonto konto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(kontoProxiString));
            long betrag = new Long(betragAsString).longValue();
            ((PersistentServiceKunde)this.server).einzahlen(konto, betrag);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> entfernePosition(String positionProxiString){
        try {
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            ((PersistentServiceKunde)this.server).entfernePosition(position);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> neuePosition(String einkaufsManagerProxiString, String artikelProxiString, String mengeAsString){
        try {
            PersistentEinkaufsManager einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(einkaufsManagerProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceKunde)this.server).neuePosition(einkaufsManager, artikel, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> suchen(String bezeichnung){
        try {
            ((PersistentServiceKunde)this.server).suchen(bezeichnung);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> vorbestellen(String einkaufsManagerProxiString, String lieferartProxiString){
        try {
            PersistentEinkaufsManager einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(einkaufsManagerProxiString));
            PersistentLieferart lieferart = (PersistentLieferart)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferartProxiString));
            ((PersistentServiceKunde)this.server).vorbestellen(einkaufsManager, lieferart);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> zuEinkaufswagenHinzufuegen(String artikelProxiString, String mengeAsString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceKunde)this.server).zuEinkaufswagenHinzufuegen(artikel, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> zuruecksenden(String positionProxiString){
        try {
            PersistentPositionInBestellung position = (PersistentPositionInBestellung)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            ((PersistentServiceKunde)this.server).zuruecksenden(position);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}