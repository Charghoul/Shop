
package modelServer;


import persistence.*;

public  class RemoteServiceAdmin extends RemoteServiceShop {

	
	public RemoteServiceAdmin(String connectionName, String userName, PersistentServiceAdmin server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> artikel_Path_In_ArtikelAnhaengen(){
        try {
            ArtikelManager4Public result = ((PersistentServiceAdmin)this.server).artikel_Path_In_ArtikelAnhaengen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikel_Path_In_ArtikelEinlagern(){
        try {
            ArtikelManager4Public result = ((PersistentServiceAdmin)this.server).artikel_Path_In_ArtikelEinlagern();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikel_Path_In_ArtikelEntnehmen(){
        try {
            ArtikelManager4Public result = ((PersistentServiceAdmin)this.server).artikel_Path_In_ArtikelEntnehmen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> hersteller_Path_In_HerstellerHinzufuegen(){
        try {
            HerstellerManager4Public result = ((PersistentServiceAdmin)this.server).hersteller_Path_In_HerstellerHinzufuegen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> position_Path_In_ArtikelEntfernen(){
        try {
            Warenlager4Public result = ((PersistentServiceAdmin)this.server).position_Path_In_ArtikelEntfernen();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> serviceAdmin_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServiceAdmin)this.server).serviceAdmin_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereArtikel(String artikelProxiString, String preisAsString, String minLagerbestandAsString, String maxLagerbestandAsString, String hstLieferzeitAsString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            common.Fraction preis = common.Fraction.parse(preisAsString);
            long minLagerbestand = new Long(minLagerbestandAsString).longValue();
            long maxLagerbestand = new Long(maxLagerbestandAsString).longValue();
            long hstLieferzeit = new Long(hstLieferzeitAsString).longValue();
            ((PersistentServiceAdmin)this.server).aendereArtikel(artikel, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereHersteller(String herstellerProxiString, String name){
        try {
            PersistentHersteller hersteller = (PersistentHersteller)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(herstellerProxiString));
            ((PersistentServiceAdmin)this.server).aendereHersteller(hersteller, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereHstLieferzeit(String artikelProxiString, String hstLieferzeitAsString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long hstLieferzeit = new Long(hstLieferzeitAsString).longValue();
            ((PersistentServiceAdmin)this.server).aendereHstLieferzeit(artikel, hstLieferzeit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereLieferart(String lieferartProxiString, String name, String lieferzeitAsString, String preisAsString){
        try {
            PersistentLieferart lieferart = (PersistentLieferart)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferartProxiString));
            long lieferzeit = new Long(lieferzeitAsString).longValue();
            common.Fraction preis = common.Fraction.parse(preisAsString);
            ((PersistentServiceAdmin)this.server).aendereLieferart(lieferart, name, lieferzeit, preis);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> aendereMenge(String positionProxiString, String mengeAsString){
        try {
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).aendereMenge(position, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLagerbestandUnderZero e0){
            return createExceptionResult(e0, this);
        }catch(model.ExcLagerbestandOverMax e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelAbhaengen(String produktgruppeProxiString, String artikelProxiString){
        try {
            PersistentProduktgruppe produktgruppe = (PersistentProduktgruppe)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktgruppeProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            ((PersistentServiceAdmin)this.server).artikelAbhaengen(produktgruppe, artikel);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelAnhaengen(String produktgruppeProxiString, String artikelProxiString){
        try {
            PersistentProduktgruppe produktgruppe = (PersistentProduktgruppe)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktgruppeProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            ((PersistentServiceAdmin)this.server).artikelAnhaengen(produktgruppe, artikel);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }catch(model.CycleException e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelEinlagern(String warenlagerProxiString, String artikelProxiString, String mengeAsString){
        try {
            PersistentWarenlager warenlager = (PersistentWarenlager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(warenlagerProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).artikelEinlagern(warenlager, artikel, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelEntfernen(String warenlagerProxiString, String positionProxiString){
        try {
            PersistentWarenlager warenlager = (PersistentWarenlager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(warenlagerProxiString));
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            ((PersistentServiceAdmin)this.server).artikelEntfernen(warenlager, position);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelEntnehmen(String warenlagerProxiString, String artikelProxiString, String mengeAsString){
        try {
            PersistentWarenlager warenlager = (PersistentWarenlager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(warenlagerProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).artikelEntnehmen(warenlager, artikel, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> erhoeheMenge(String positionProxiString, String mengeAsString){
        try {
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).erhoeheMenge(position, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLagerbestandOverMax e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> herstellerHinzufuegen(String artikelProxiString, String herstellerProxiString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            PersistentHersteller hersteller = (PersistentHersteller)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(herstellerProxiString));
            ((PersistentServiceAdmin)this.server).herstellerHinzufuegen(artikel, hersteller);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> neueLieferArt(String lieferartManagerProxiString, String name, String lieferzeitAsString, String preisAsString){
        try {
            PersistentLieferartManager lieferartManager = (PersistentLieferartManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferartManagerProxiString));
            long lieferzeit = new Long(lieferzeitAsString).longValue();
            common.Fraction preis = common.Fraction.parse(preisAsString);
            ((PersistentServiceAdmin)this.server).neueLieferArt(lieferartManager, name, lieferzeit, preis);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> neuerArtikel(String artikelManagerProxiString, String artikelnummer, String bezeichnung, String preisAsString, String minLagerbestandAsString, String maxLagerbestandAsString, String hstLieferzeitAsString){
        try {
            PersistentArtikelManager artikelManager = (PersistentArtikelManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelManagerProxiString));
            common.Fraction preis = common.Fraction.parse(preisAsString);
            long minLagerbestand = new Long(minLagerbestandAsString).longValue();
            long maxLagerbestand = new Long(maxLagerbestandAsString).longValue();
            long hstLieferzeit = new Long(hstLieferzeitAsString).longValue();
            ((PersistentServiceAdmin)this.server).neuerArtikel(artikelManager, artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> neuerHersteller(String herstellerManagerProxiString, String name){
        try {
            PersistentHerstellerManager herstellerManager = (PersistentHerstellerManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(herstellerManagerProxiString));
            ((PersistentServiceAdmin)this.server).neuerHersteller(herstellerManager, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> produktgruppeEntfernen(String produktgruppeProxiString){
        try {
            PersistentProduktgruppe produktgruppe = (PersistentProduktgruppe)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktgruppeProxiString));
            ((PersistentServiceAdmin)this.server).produktgruppeEntfernen(produktgruppe);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> produktgruppeHinzufuegen(String produktgruppeProxiString, String name){
        try {
            PersistentProduktgruppe produktgruppe = (PersistentProduktgruppe)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktgruppeProxiString));
            ((PersistentServiceAdmin)this.server).produktgruppeHinzufuegen(produktgruppe, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }catch(model.CycleException e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> statusAuslauf(String artikelProxiString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            ((PersistentServiceAdmin)this.server).statusAuslauf(artikel);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> statusVerkauf(String artikelProxiString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            ((PersistentServiceAdmin)this.server).statusVerkauf(artikel);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> verringereMenge(String positionProxiString, String mengeAsString){
        try {
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).verringereMenge(position, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLagerbestandUnderZero e0){
            return createExceptionResult(e0, this);
        }
    }
    


}