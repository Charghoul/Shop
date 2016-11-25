
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class ServiceKunde extends view.objects.ServiceShop implements ServiceKundeView{
    
    protected WarenlagerView warenlager;
    protected KontoView konto;
    protected EinkaufsManagerView einkaufsManager;
    protected LieferartManagerView lieferartManager;
    protected BestellManagerView bestellManager;
    
    public ServiceKunde(java.util.Vector<ErrorDisplayView> errors,ProduktKatalogView produktKatalog,WarenlagerView warenlager,KontoView konto,EinkaufsManagerView einkaufsManager,LieferartManagerView lieferartManager,BestellManagerView bestellManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,(ProduktKatalogView)produktKatalog,id, classId);
        this.warenlager = warenlager;
        this.konto = konto;
        this.einkaufsManager = einkaufsManager;
        this.lieferartManager = lieferartManager;
        this.bestellManager = bestellManager;        
    }
    
    static public long getTypeId() {
        return -181;
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
    public KontoView getKonto()throws ModelException{
        return this.konto;
    }
    public void setKonto(KontoView newValue) throws ModelException {
        this.konto = newValue;
    }
    public EinkaufsManagerView getEinkaufsManager()throws ModelException{
        return this.einkaufsManager;
    }
    public void setEinkaufsManager(EinkaufsManagerView newValue) throws ModelException {
        this.einkaufsManager = newValue;
    }
    public LieferartManagerView getLieferartManager()throws ModelException{
        return this.lieferartManager;
    }
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException {
        this.lieferartManager = newValue;
    }
    public BestellManagerView getBestellManager()throws ModelException{
        return this.bestellManager;
    }
    public void setBestellManager(BestellManagerView newValue) throws ModelException {
        this.bestellManager = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        ProduktKatalogView produktKatalog = this.getProduktKatalog();
        if (produktKatalog != null) {
            ((ViewProxi)produktKatalog).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(produktKatalog.getClassId(), produktKatalog.getId())));
        }
        WarenlagerView warenlager = this.getWarenlager();
        if (warenlager != null) {
            ((ViewProxi)warenlager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(warenlager.getClassId(), warenlager.getId())));
        }
        KontoView konto = this.getKonto();
        if (konto != null) {
            ((ViewProxi)konto).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(konto.getClassId(), konto.getId())));
        }
        EinkaufsManagerView einkaufsManager = this.getEinkaufsManager();
        if (einkaufsManager != null) {
            ((ViewProxi)einkaufsManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(einkaufsManager.getClassId(), einkaufsManager.getId())));
        }
        LieferartManagerView lieferartManager = this.getLieferartManager();
        if (lieferartManager != null) {
            ((ViewProxi)lieferartManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(lieferartManager.getClassId(), lieferartManager.getId())));
        }
        BestellManagerView bestellManager = this.getBestellManager();
        if (bestellManager != null) {
            ((ViewProxi)bestellManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(bestellManager.getClassId(), bestellManager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProduktKatalog() != null) return new ProduktKatalogServiceShopWrapper(this, originalIndex, (ViewRoot)this.getProduktKatalog());
        if(this.getProduktKatalog() != null) index = index - 1;
        if(index == 0 && this.getKonto() != null) return new KontoServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getKonto());
        if(this.getKonto() != null) index = index - 1;
        if(index == 0 && this.getEinkaufsManager() != null) return new EinkaufsManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getEinkaufsManager());
        if(this.getEinkaufsManager() != null) index = index - 1;
        if(index == 0 && this.getBestellManager() != null) return new BestellManagerServiceKundeWrapper(this, originalIndex, (ViewRoot)this.getBestellManager());
        if(this.getBestellManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProduktKatalog() == null ? 0 : 1)
            + (this.getKonto() == null ? 0 : 1)
            + (this.getEinkaufsManager() == null ? 0 : 1)
            + (this.getBestellManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProduktKatalog() == null ? true : false)
            && (this.getKonto() == null ? true : false)
            && (this.getEinkaufsManager() == null ? true : false)
            && (this.getBestellManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProduktKatalog() != null && this.getProduktKatalog().equals(child)) return result;
        if(this.getProduktKatalog() != null) result = result + 1;
        if(this.getKonto() != null && this.getKonto().equals(child)) return result;
        if(this.getKonto() != null) result = result + 1;
        if(this.getEinkaufsManager() != null && this.getEinkaufsManager().equals(child)) return result;
        if(this.getEinkaufsManager() != null) result = result + 1;
        if(this.getBestellManager() != null && this.getBestellManager().equals(child)) return result;
        if(this.getBestellManager() != null) result = result + 1;
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
