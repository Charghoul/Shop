package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ServiceAdminProxi extends ServiceShopProxi implements ServiceAdminView{
    
    public ServiceAdminProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServiceAdminView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi produktKatalog = null;
        String produktKatalog$String = (String)resultTable.get("produktKatalog");
        if (produktKatalog$String != null) {
            common.ProxiInformation produktKatalog$Info = common.RPCConstantsAndServices.createProxiInformation(produktKatalog$String);
            produktKatalog = view.objects.ViewProxi.createProxi(produktKatalog$Info,connectionKey);
            produktKatalog.setToString(produktKatalog$Info.getToString());
        }
        ViewProxi warenlager = null;
        String warenlager$String = (String)resultTable.get("warenlager");
        if (warenlager$String != null) {
            common.ProxiInformation warenlager$Info = common.RPCConstantsAndServices.createProxiInformation(warenlager$String);
            warenlager = view.objects.ViewProxi.createProxi(warenlager$Info,connectionKey);
            warenlager.setToString(warenlager$Info.getToString());
        }
        ViewProxi artikelManager = null;
        String artikelManager$String = (String)resultTable.get("artikelManager");
        if (artikelManager$String != null) {
            common.ProxiInformation artikelManager$Info = common.RPCConstantsAndServices.createProxiInformation(artikelManager$String);
            artikelManager = view.objects.ViewProxi.createProxi(artikelManager$Info,connectionKey);
            artikelManager.setToString(artikelManager$Info.getToString());
        }
        ViewProxi lieferartManager = null;
        String lieferartManager$String = (String)resultTable.get("lieferartManager");
        if (lieferartManager$String != null) {
            common.ProxiInformation lieferartManager$Info = common.RPCConstantsAndServices.createProxiInformation(lieferartManager$String);
            lieferartManager = view.objects.ViewProxi.createProxi(lieferartManager$Info,connectionKey);
            lieferartManager.setToString(lieferartManager$Info.getToString());
        }
        ViewProxi herstellerManager = null;
        String herstellerManager$String = (String)resultTable.get("herstellerManager");
        if (herstellerManager$String != null) {
            common.ProxiInformation herstellerManager$Info = common.RPCConstantsAndServices.createProxiInformation(herstellerManager$String);
            herstellerManager = view.objects.ViewProxi.createProxi(herstellerManager$Info,connectionKey);
            herstellerManager.setToString(herstellerManager$Info.getToString());
        }
        ViewProxi zeitManager = null;
        String zeitManager$String = (String)resultTable.get("zeitManager");
        if (zeitManager$String != null) {
            common.ProxiInformation zeitManager$Info = common.RPCConstantsAndServices.createProxiInformation(zeitManager$String);
            zeitManager = view.objects.ViewProxi.createProxi(zeitManager$Info,connectionKey);
            zeitManager.setToString(zeitManager$Info.getToString());
        }
        ServiceAdminView result$$ = new ServiceAdmin(errors,(ProduktKatalogView)produktKatalog,(WarenlagerView)warenlager,(ArtikelManagerView)artikelManager,(LieferartManagerView)lieferartManager,(HerstellerManagerView)herstellerManager,(ZeitManagerView)zeitManager, this.getId(), this.getClassId());
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
        if(index == 0 && this.getWarenlager() != null) return new WarenlagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getWarenlager());
        if(this.getWarenlager() != null) index = index - 1;
        if(index == 0 && this.getArtikelManager() != null) return new ArtikelManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getArtikelManager());
        if(this.getArtikelManager() != null) index = index - 1;
        if(index == 0 && this.getLieferartManager() != null) return new LieferartManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getLieferartManager());
        if(this.getLieferartManager() != null) index = index - 1;
        if(index == 0 && this.getHerstellerManager() != null) return new HerstellerManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getHerstellerManager());
        if(this.getHerstellerManager() != null) index = index - 1;
        if(index == 0 && this.getZeitManager() != null) return new ZeitManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getZeitManager());
        if(this.getZeitManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProduktKatalog() == null ? 0 : 1)
            + (this.getWarenlager() == null ? 0 : 1)
            + (this.getArtikelManager() == null ? 0 : 1)
            + (this.getLieferartManager() == null ? 0 : 1)
            + (this.getHerstellerManager() == null ? 0 : 1)
            + (this.getZeitManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getProduktKatalog() == null ? true : false)
            && (this.getWarenlager() == null ? true : false)
            && (this.getArtikelManager() == null ? true : false)
            && (this.getLieferartManager() == null ? true : false)
            && (this.getHerstellerManager() == null ? true : false)
            && (this.getZeitManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProduktKatalog() != null && this.getProduktKatalog().equals(child)) return result;
        if(this.getProduktKatalog() != null) result = result + 1;
        if(this.getWarenlager() != null && this.getWarenlager().equals(child)) return result;
        if(this.getWarenlager() != null) result = result + 1;
        if(this.getArtikelManager() != null && this.getArtikelManager().equals(child)) return result;
        if(this.getArtikelManager() != null) result = result + 1;
        if(this.getLieferartManager() != null && this.getLieferartManager().equals(child)) return result;
        if(this.getLieferartManager() != null) result = result + 1;
        if(this.getHerstellerManager() != null && this.getHerstellerManager().equals(child)) return result;
        if(this.getHerstellerManager() != null) result = result + 1;
        if(this.getZeitManager() != null && this.getZeitManager().equals(child)) return result;
        if(this.getZeitManager() != null) result = result + 1;
        return -1;
    }
    
    public WarenlagerView getWarenlager()throws ModelException{
        return ((ServiceAdmin)this.getTheObject()).getWarenlager();
    }
    public void setWarenlager(WarenlagerView newValue) throws ModelException {
        ((ServiceAdmin)this.getTheObject()).setWarenlager(newValue);
    }
    public ArtikelManagerView getArtikelManager()throws ModelException{
        return ((ServiceAdmin)this.getTheObject()).getArtikelManager();
    }
    public void setArtikelManager(ArtikelManagerView newValue) throws ModelException {
        ((ServiceAdmin)this.getTheObject()).setArtikelManager(newValue);
    }
    public LieferartManagerView getLieferartManager()throws ModelException{
        return ((ServiceAdmin)this.getTheObject()).getLieferartManager();
    }
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException {
        ((ServiceAdmin)this.getTheObject()).setLieferartManager(newValue);
    }
    public HerstellerManagerView getHerstellerManager()throws ModelException{
        return ((ServiceAdmin)this.getTheObject()).getHerstellerManager();
    }
    public void setHerstellerManager(HerstellerManagerView newValue) throws ModelException {
        ((ServiceAdmin)this.getTheObject()).setHerstellerManager(newValue);
    }
    public ZeitManagerView getZeitManager()throws ModelException{
        return ((ServiceAdmin)this.getTheObject()).getZeitManager();
    }
    public void setZeitManager(ZeitManagerView newValue) throws ModelException {
        ((ServiceAdmin)this.getTheObject()).setZeitManager(newValue);
    }
    
    public void accept(ServiceShopVisitor visitor) throws ModelException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends view.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends view.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceAdmin(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServiceAdmin(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServiceAdmin(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServiceAdmin(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServiceAdmin(this);
    }
    
    
    public ServiceAdminConnection connectServiceAdmin(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServiceAdminConnection result;
		try {
			result = (ServiceAdminConnection) new ServiceAdminConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
