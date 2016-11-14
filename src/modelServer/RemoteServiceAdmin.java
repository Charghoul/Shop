
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
    
    public synchronized java.util.HashMap<?,?> aendereStatus(String artikelManagerProxiString, String artikelProxiString, String artikelstatusProxiString){
        try {
            PersistentArtikelManager artikelManager = (PersistentArtikelManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelManagerProxiString));
            PersistentArtikel artikel = (PersistentArtikel)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelProxiString));
            PersistentArtikelstatus artikelstatus = (PersistentArtikelstatus)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(artikelstatusProxiString));
            ((PersistentServiceAdmin)this.server).aendereStatus(artikelManager, artikel, artikelstatus);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcStatusDidNotChange e0){
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
    
    public synchronized java.util.HashMap<?,?> neueLieferArt(String lieferartManagerProxiString, String name, String lieferzeitAsString, String preisAsString){
        try {
            PersistentLieferartManager lieferartManager = (PersistentLieferartManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferartManagerProxiString));
            long lieferzeit = new Long(lieferzeitAsString).longValue();
            common.Fraction preis = common.Fraction.parse(preisAsString);
            ((PersistentServiceAdmin)this.server).neueLieferArt(lieferartManager, name, lieferzeit, preis);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcLieferartAlreadyExists e0){
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
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}