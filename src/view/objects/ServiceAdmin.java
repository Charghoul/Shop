
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class ServiceAdmin extends view.objects.ServiceShop implements ServiceAdminView{
    
    protected KundenManagerView kundenManager;
    protected WarenlagerView warenlager;
    protected ArtikelManagerView artikelManager;
    protected LieferartManagerView lieferartManager;
    protected HerstellerManagerView herstellerManager;
    protected ZeitManagerView zeitManager;
    
    public ServiceAdmin(java.util.Vector<ErrorDisplayView> errors,ProduktKatalogView produktKatalog,KundenManagerView kundenManager,WarenlagerView warenlager,ArtikelManagerView artikelManager,LieferartManagerView lieferartManager,HerstellerManagerView herstellerManager,ZeitManagerView zeitManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,(ProduktKatalogView)produktKatalog,id, classId);
        this.kundenManager = kundenManager;
        this.warenlager = warenlager;
        this.artikelManager = artikelManager;
        this.lieferartManager = lieferartManager;
        this.herstellerManager = herstellerManager;
        this.zeitManager = zeitManager;        
    }
    
    static public long getTypeId() {
        return -182;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public KundenManagerView getKundenManager()throws ModelException{
        return this.kundenManager;
    }
    public void setKundenManager(KundenManagerView newValue) throws ModelException {
        this.kundenManager = newValue;
    }
    public WarenlagerView getWarenlager()throws ModelException{
        return this.warenlager;
    }
    public void setWarenlager(WarenlagerView newValue) throws ModelException {
        this.warenlager = newValue;
    }
    public ArtikelManagerView getArtikelManager()throws ModelException{
        return this.artikelManager;
    }
    public void setArtikelManager(ArtikelManagerView newValue) throws ModelException {
        this.artikelManager = newValue;
    }
    public LieferartManagerView getLieferartManager()throws ModelException{
        return this.lieferartManager;
    }
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException {
        this.lieferartManager = newValue;
    }
    public HerstellerManagerView getHerstellerManager()throws ModelException{
        return this.herstellerManager;
    }
    public void setHerstellerManager(HerstellerManagerView newValue) throws ModelException {
        this.herstellerManager = newValue;
    }
    public ZeitManagerView getZeitManager()throws ModelException{
        return this.zeitManager;
    }
    public void setZeitManager(ZeitManagerView newValue) throws ModelException {
        this.zeitManager = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        ProduktKatalogView produktKatalog = this.getProduktKatalog();
        if (produktKatalog != null) {
            ((ViewProxi)produktKatalog).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(produktKatalog.getClassId(), produktKatalog.getId())));
        }
        KundenManagerView kundenManager = this.getKundenManager();
        if (kundenManager != null) {
            ((ViewProxi)kundenManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(kundenManager.getClassId(), kundenManager.getId())));
        }
        WarenlagerView warenlager = this.getWarenlager();
        if (warenlager != null) {
            ((ViewProxi)warenlager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(warenlager.getClassId(), warenlager.getId())));
        }
        ArtikelManagerView artikelManager = this.getArtikelManager();
        if (artikelManager != null) {
            ((ViewProxi)artikelManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(artikelManager.getClassId(), artikelManager.getId())));
        }
        LieferartManagerView lieferartManager = this.getLieferartManager();
        if (lieferartManager != null) {
            ((ViewProxi)lieferartManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(lieferartManager.getClassId(), lieferartManager.getId())));
        }
        HerstellerManagerView herstellerManager = this.getHerstellerManager();
        if (herstellerManager != null) {
            ((ViewProxi)herstellerManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(herstellerManager.getClassId(), herstellerManager.getId())));
        }
        ZeitManagerView zeitManager = this.getZeitManager();
        if (zeitManager != null) {
            ((ViewProxi)zeitManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(zeitManager.getClassId(), zeitManager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProduktKatalog() != null) return new ProduktKatalogServiceShopWrapper(this, originalIndex, (ViewRoot)this.getProduktKatalog());
        if(this.getProduktKatalog() != null) index = index - 1;
        if(index == 0 && this.getKundenManager() != null) return new KundenManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getKundenManager());
        if(this.getKundenManager() != null) index = index - 1;
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
            + (this.getKundenManager() == null ? 0 : 1)
            + (this.getWarenlager() == null ? 0 : 1)
            + (this.getArtikelManager() == null ? 0 : 1)
            + (this.getLieferartManager() == null ? 0 : 1)
            + (this.getHerstellerManager() == null ? 0 : 1)
            + (this.getZeitManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProduktKatalog() == null ? true : false)
            && (this.getKundenManager() == null ? true : false)
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
        if(this.getKundenManager() != null && this.getKundenManager().equals(child)) return result;
        if(this.getKundenManager() != null) result = result + 1;
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
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
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
