
package modelServer;


import persistence.*;

public  class RemoteServiceAdmin extends RemoteService {

	
	public RemoteServiceAdmin(String connectionName, String userName, PersistentServiceAdmin server){
		super (connectionName, userName , server);
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
    
    public synchronized java.util.HashMap<?,?> aendereArtikel(String artikelProxiString, String bezeichnung, String preisAsString, String minLagerbestandAsString, String maxLagerbestandAsString, String hstLieferzeitAsString){
        try {
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            common.Fraction preis = common.Fraction.parse(preisAsString);
            long minLagerbestand = new Long(minLagerbestandAsString).longValue();
            long maxLagerbestand = new Long(maxLagerbestandAsString).longValue();
            long hstLieferzeit = new Long(hstLieferzeitAsString).longValue();
            ((PersistentServiceAdmin)this.server).aendereArtikel(artikel, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
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
    
    public synchronized java.util.HashMap<?,?> artikelEinlagern(String warenlagerProxiString, String artikelProxiString, String mengeAsString){
        try {
            PersistentWarenlager warenlager = (PersistentWarenlager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(warenlagerProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).artikelEinlagern(warenlager, artikel, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLagerbestandOverMax e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelEntnehmen(String warenlagerProxiString, String positionProxiString, String mengeAsString){
        try {
            PersistentWarenlager warenlager = (PersistentWarenlager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(warenlagerProxiString));
            PersistentPosition position = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionProxiString));
            long menge = new Long(mengeAsString).longValue();
            ((PersistentServiceAdmin)this.server).artikelEntnehmen(warenlager, position, menge);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> artikelHinzufuegen(String produktgruppeProxiString, String artikelProxiString){
        try {
            PersistentProduktgruppe produktgruppe = (PersistentProduktgruppe)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktgruppeProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            ((PersistentServiceAdmin)this.server).artikelHinzufuegen(produktgruppe, artikel);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcAlreadyExists e0){
            return createExceptionResult(e0, this);
        }catch(model.CycleException e1){
            return createExceptionResult(e1, this);
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
    


}