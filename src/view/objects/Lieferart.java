
package view.objects;

import view.LieferartView;
import view.ModelException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Lieferart extends ViewObject implements LieferartView{
    
    protected String name;
    protected long lieferzeit;
    protected common.Fraction preis;
    
    public Lieferart(String name,long lieferzeit,common.Fraction preis,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.lieferzeit = lieferzeit;
        this.preis = preis;        
    }
    
    static public long getTypeId() {
        return 138;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public long getLieferzeit()throws ModelException{
        return this.lieferzeit;
    }
    public void setLieferzeit(long newValue) throws ModelException {
        this.lieferzeit = newValue;
    }
    public common.Fraction getPreis()throws ModelException{
        return this.preis;
    }
    public void setPreis(common.Fraction newValue) throws ModelException {
        this.preis = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferart(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferart(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getLieferzeitIndex() throws ModelException {
        return 0 + 1;
    }
    public int getPreisIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "lieferzeit";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "preis";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getLieferzeit());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getPreis();
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
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setLieferzeit(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setPreis(common.Fraction.parse(newValue));
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
