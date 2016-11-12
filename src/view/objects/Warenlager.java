
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Warenlager extends ViewObject implements WarenlagerView{
    
    protected java.util.Vector<PositionView> warenListe;
    
    public Warenlager(java.util.Vector<PositionView> warenListe,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.warenListe = warenListe;        
    }
    
    static public long getTypeId() {
        return 193;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<PositionView> getWarenListe()throws ModelException{
        return this.warenListe;
    }
    public void setWarenListe(java.util.Vector<PositionView> newValue) throws ModelException {
        this.warenListe = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleWarenlager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleWarenlager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> warenListe = this.getWarenListe();
        if (warenListe != null) {
            ViewObject.resolveVectorProxies(warenListe, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getWarenListe().size()) return new WarenListeWarenlagerWrapper(this, originalIndex, (ViewRoot)this.getWarenListe().get(index));
        index = index - this.getWarenListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getWarenListe().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getWarenListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getWarenListeIterator = this.getWarenListe().iterator();
        while(getWarenListeIterator.hasNext()){
            if(getWarenListeIterator.next().equals(child)) return result;
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
