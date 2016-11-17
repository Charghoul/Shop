
package view.objects;

import view.*;
import view.visitor.*;
import viewClient.ConnectionIndex;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;
import viewClient.ServiceKundeConnection;


/* Additional import section end */

public class ServiceKunde extends view.objects.Service implements ServiceKundeView{
    
    protected EinkaufsManagerView einkaufsManager;
    protected ArtikelManagerView artikelManager;
    protected WarenlagerView warenlager;
    
    public ServiceKunde(java.util.Vector<ErrorDisplayView> errors,EinkaufsManagerView einkaufsManager,ArtikelManagerView artikelManager,WarenlagerView warenlager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.einkaufsManager = einkaufsManager;
        this.artikelManager = artikelManager;
        this.warenlager = warenlager;        
    }
    
    static public long getTypeId() {
        return -181;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public EinkaufsManagerView getEinkaufsManager()throws ModelException{
        return this.einkaufsManager;
    }
    public void setEinkaufsManager(EinkaufsManagerView newValue) throws ModelException {
        this.einkaufsManager = newValue;
    }
    public ArtikelManagerView getArtikelManager()throws ModelException{
        return this.artikelManager;
    }
    public void setArtikelManager(ArtikelManagerView newValue) throws ModelException {
        this.artikelManager = newValue;
    }
    public WarenlagerView getWarenlager()throws ModelException{
        return this.warenlager;
    }
    public void setWarenlager(WarenlagerView newValue) throws ModelException {
        this.warenlager = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        EinkaufsManagerView einkaufsManager = this.getEinkaufsManager();
        if (einkaufsManager != null) {
            ((ViewProxi)einkaufsManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(einkaufsManager.getClassId(), einkaufsManager.getId())));
        }
        ArtikelManagerView artikelManager = this.getArtikelManager();
        if (artikelManager != null) {
            ((ViewProxi)artikelManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(artikelManager.getClassId(), artikelManager.getId())));
        }
        WarenlagerView warenlager = this.getWarenlager();
        if (warenlager != null) {
            ((ViewProxi)warenlager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(warenlager.getClassId(), warenlager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getEinkaufsManager() != null) return new EinkaufsManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getEinkaufsManager());
        if(this.getEinkaufsManager() != null) index = index - 1;
        if(index == 0 && this.getArtikelManager() != null) return new ArtikelManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getArtikelManager());
        if(this.getArtikelManager() != null) index = index - 1;
        if(index == 0 && this.getWarenlager() != null) return new WarenlagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getWarenlager());
        if(this.getWarenlager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getEinkaufsManager() == null ? 0 : 1)
            + (this.getArtikelManager() == null ? 0 : 1)
            + (this.getWarenlager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getEinkaufsManager() == null ? true : false)
            && (this.getArtikelManager() == null ? true : false)
            && (this.getWarenlager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getEinkaufsManager() != null && this.getEinkaufsManager().equals(child)) return result;
        if(this.getEinkaufsManager() != null) result = result + 1;
        if(this.getArtikelManager() != null && this.getArtikelManager().equals(child)) return result;
        if(this.getArtikelManager() != null) result = result + 1;
        if(this.getWarenlager() != null && this.getWarenlager().equals(child)) return result;
        if(this.getWarenlager() != null) result = result + 1;
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
