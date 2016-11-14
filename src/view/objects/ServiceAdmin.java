
package view.objects;

import view.*;
import view.visitor.*;
import viewClient.ConnectionIndex;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;
import viewClient.ServiceAdminConnection;


/* Additional import section end */

public class ServiceAdmin extends view.objects.Service implements ServiceAdminView{
    
    protected WarenlagerView warenlager;
    protected ArtikelManagerView artikelManager;
    protected LieferartManagerView lieferartManager;
    
    public ServiceAdmin(java.util.Vector<ErrorDisplayView> errors,WarenlagerView warenlager,ArtikelManagerView artikelManager,LieferartManagerView lieferartManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.warenlager = warenlager;
        this.artikelManager = artikelManager;
        this.lieferartManager = lieferartManager;        
    }
    
    static public long getTypeId() {
        return -182;
    }
    
    public long getClassId() {
        return getTypeId();
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
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getWarenlager() != null) return new WarenlagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getWarenlager());
        if(this.getWarenlager() != null) index = index - 1;
        if(index == 0 && this.getArtikelManager() != null) return new ArtikelManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getArtikelManager());
        if(this.getArtikelManager() != null) index = index - 1;
        if(index == 0 && this.getLieferartManager() != null) return new LieferartManagerServiceAdminWrapper(this, originalIndex, (ViewRoot)this.getLieferartManager());
        if(this.getLieferartManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getWarenlager() == null ? 0 : 1)
            + (this.getArtikelManager() == null ? 0 : 1)
            + (this.getLieferartManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getWarenlager() == null ? true : false)
            && (this.getArtikelManager() == null ? true : false)
            && (this.getLieferartManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getWarenlager() != null && this.getWarenlager().equals(child)) return result;
        if(this.getWarenlager() != null) result = result + 1;
        if(this.getArtikelManager() != null && this.getArtikelManager().equals(child)) return result;
        if(this.getArtikelManager() != null) result = result + 1;
        if(this.getLieferartManager() != null && this.getLieferartManager().equals(child)) return result;
        if(this.getLieferartManager() != null) result = result + 1;
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
