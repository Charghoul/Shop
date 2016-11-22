
package view.objects;

import view.KontoView;
import view.ModelException;
import view.ServiceKundeView;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Konto extends ViewObject implements KontoView{
    
    protected long kontostand;
    protected long limit;
    protected ServiceKundeView myServiceKunde;
    
    public Konto(long kontostand,long limit,ServiceKundeView myServiceKunde,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.kontostand = kontostand;
        this.limit = limit;
        this.myServiceKunde = myServiceKunde;        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getKontostand()throws ModelException{
        return this.kontostand;
    }
    public void setKontostand(long newValue) throws ModelException {
        this.kontostand = newValue;
    }
    public long getLimit()throws ModelException{
        return this.limit;
    }
    public void setLimit(long newValue) throws ModelException {
        this.limit = newValue;
    }
    public ServiceKundeView getMyServiceKunde()throws ModelException{
        return this.myServiceKunde;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKonto(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKonto(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ServiceKundeView myServiceKunde = this.getMyServiceKunde();
        if (myServiceKunde != null) {
            ((ViewProxi)myServiceKunde).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myServiceKunde.getClassId(), myServiceKunde.getId())));
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
    public int getKontostandIndex() throws ModelException {
        return 0;
    }
    public int getLimitIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "kontostand";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "limit";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getKontostand());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getLimit());
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
            this.setKontostand(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setLimit(Long.parseLong(newValue));
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
