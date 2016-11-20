package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ServiceKundeProxi extends ServiceShopProxi implements ServiceKundeView{
    
    public ServiceKundeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServiceKundeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi produktKatalog = null;
        String produktKatalog$String = (String)resultTable.get("produktKatalog");
        if (produktKatalog$String != null) {
            common.ProxiInformation produktKatalog$Info = common.RPCConstantsAndServices.createProxiInformation(produktKatalog$String);
            produktKatalog = view.objects.ViewProxi.createProxi(produktKatalog$Info,connectionKey);
            produktKatalog.setToString(produktKatalog$Info.getToString());
        }
        ViewProxi einkaufsManager = null;
        String einkaufsManager$String = (String)resultTable.get("einkaufsManager");
        if (einkaufsManager$String != null) {
            common.ProxiInformation einkaufsManager$Info = common.RPCConstantsAndServices.createProxiInformation(einkaufsManager$String);
            einkaufsManager = view.objects.ViewProxi.createProxi(einkaufsManager$Info,connectionKey);
            einkaufsManager.setToString(einkaufsManager$Info.getToString());
        }
        ViewProxi lieferartManager = null;
        String lieferartManager$String = (String)resultTable.get("lieferartManager");
        if (lieferartManager$String != null) {
            common.ProxiInformation lieferartManager$Info = common.RPCConstantsAndServices.createProxiInformation(lieferartManager$String);
            lieferartManager = view.objects.ViewProxi.createProxi(lieferartManager$Info,connectionKey);
            lieferartManager.setToString(lieferartManager$Info.getToString());
        }
        ViewProxi bestellManager = null;
        String bestellManager$String = (String)resultTable.get("bestellManager");
        if (bestellManager$String != null) {
            common.ProxiInformation bestellManager$Info = common.RPCConstantsAndServices.createProxiInformation(bestellManager$String);
            bestellManager = view.objects.ViewProxi.createProxi(bestellManager$Info,connectionKey);
            bestellManager.setToString(bestellManager$Info.getToString());
        }
        ServiceKundeView result$$ = new ServiceKunde(errors,(ProduktKatalogView)produktKatalog,(EinkaufsManagerView)einkaufsManager,(LieferartManagerView)lieferartManager,(BestellManagerView)bestellManager, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProduktKatalog() != null) return new ProduktKatalogServiceShopWrapper(this, originalIndex, (ViewRoot)this.getProduktKatalog());
        if(this.getProduktKatalog() != null) index = index - 1;
        if(index == 0 && this.getEinkaufsManager() != null) return new EinkaufsManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getEinkaufsManager());
        if(this.getEinkaufsManager() != null) index = index - 1;
        if(index == 0 && this.getBestellManager() != null) return new BestellManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getBestellManager());
        if(this.getBestellManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProduktKatalog() == null ? 0 : 1)
            + (this.getEinkaufsManager() == null ? 0 : 1)
            + (this.getBestellManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getProduktKatalog() == null ? true : false)
            && (this.getEinkaufsManager() == null ? true : false)
            && (this.getBestellManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProduktKatalog() != null && this.getProduktKatalog().equals(child)) return result;
        if(this.getProduktKatalog() != null) result = result + 1;
        if(this.getEinkaufsManager() != null && this.getEinkaufsManager().equals(child)) return result;
        if(this.getEinkaufsManager() != null) result = result + 1;
        if(this.getBestellManager() != null && this.getBestellManager().equals(child)) return result;
        if(this.getBestellManager() != null) result = result + 1;
        return -1;
    }
    
    public EinkaufsManagerView getEinkaufsManager()throws ModelException{
        return ((ServiceKunde)this.getTheObject()).getEinkaufsManager();
    }
    public void setEinkaufsManager(EinkaufsManagerView newValue) throws ModelException {
        ((ServiceKunde)this.getTheObject()).setEinkaufsManager(newValue);
    }
    public LieferartManagerView getLieferartManager()throws ModelException{
        return ((ServiceKunde)this.getTheObject()).getLieferartManager();
    }
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException {
        ((ServiceKunde)this.getTheObject()).setLieferartManager(newValue);
    }
    public BestellManagerView getBestellManager()throws ModelException{
        return ((ServiceKunde)this.getTheObject()).getBestellManager();
    }
    public void setBestellManager(BestellManagerView newValue) throws ModelException {
        ((ServiceKunde)this.getTheObject()).setBestellManager(newValue);
    }
    
    public void accept(ServiceShopVisitor visitor) throws ModelException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends view.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends view.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceKunde(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServiceKunde(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceKunde(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceKunde(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceKunde(this);
    }
    
    
    public ServiceKundeConnection connectServiceKunde(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServiceKundeConnection result;
		try {
			result = (ServiceKundeConnection) new ServiceKundeConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
