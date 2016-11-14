
package view.objects;

import view.LieferartManagerView;
import view.LieferartView;
import view.ModelException;
import view.ServiceAdminView;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class LieferartManager extends ViewObject implements LieferartManagerView{
    
    protected java.util.Vector<LieferartView> lieferartenListe;
    protected ServiceAdminView myService;
    
    public LieferartManager(java.util.Vector<LieferartView> lieferartenListe,ServiceAdminView myService,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.lieferartenListe = lieferartenListe;
        this.myService = myService;        
    }
    
    static public long getTypeId() {
        return 198;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<LieferartView> getLieferartenListe()throws ModelException{
        return this.lieferartenListe;
    }
    public void setLieferartenListe(java.util.Vector<LieferartView> newValue) throws ModelException {
        this.lieferartenListe = newValue;
    }
    public ServiceAdminView getMyService()throws ModelException{
        return this.myService;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferartManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> lieferartenListe = this.getLieferartenListe();
        if (lieferartenListe != null) {
            ViewObject.resolveVectorProxies(lieferartenListe, resultTable);
        }
        ServiceAdminView myService = this.getMyService();
        if (myService != null) {
            ((ViewProxi)myService).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myService.getClassId(), myService.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getLieferartenListe().size()) return new LieferartenListeLieferartManagerWrapper(this, originalIndex, (ViewRoot)this.getLieferartenListe().get(index));
        index = index - this.getLieferartenListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLieferartenListe().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getLieferartenListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getLieferartenListeIterator = this.getLieferartenListe().iterator();
        while(getLieferartenListeIterator.hasNext()){
            if(getLieferartenListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
