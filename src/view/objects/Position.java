
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Position extends ViewObject implements PositionView{
    
    protected ArtikelView artikel;
    protected long menge;
    
    public Position(ArtikelView artikel,long menge,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.artikel = artikel;
        this.menge = menge;        
    }
    
    static public long getTypeId() {
        return 144;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ArtikelView getArtikel()throws ModelException{
        return this.artikel;
    }
    public void setArtikel(ArtikelView newValue) throws ModelException {
        this.artikel = newValue;
    }
    public long getMenge()throws ModelException{
        return this.menge;
    }
    public void setMenge(long newValue) throws ModelException {
        this.menge = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ArtikelView artikel = this.getArtikel();
        if (artikel != null) {
            ((ViewProxi)artikel).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(artikel.getClassId(), artikel.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    public int getMengeIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "menge";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getMenge());
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setMenge(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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
