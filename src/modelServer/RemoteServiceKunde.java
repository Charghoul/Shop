
package modelServer;


import persistence.*;

public  class RemoteServiceKunde extends RemoteService {

	
	public RemoteServiceKunde(String connectionName, String userName, PersistentServiceKunde server){
		super (connectionName, userName , server);
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
    
    public synchronized java.util.HashMap<?,?> bestellen(String einkaufsManagerProxiString){
        try {
            PersistentEinkaufsManager einkaufsManager = (PersistentEinkaufsManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(einkaufsManagerProxiString));
            ((PersistentServiceKunde)this.server).bestellen(einkaufsManager);
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
        }
    }
    


}