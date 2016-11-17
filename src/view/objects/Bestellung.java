
package view.objects;

import view.BestellstatusView;
import view.BestellungView;
import view.ModelException;
import view.PositionView;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Bestellung extends ViewObject implements BestellungView{
    
    protected java.util.Vector<PositionView> positionsListe;
    protected String bestellID;
    protected BestellstatusView bestellstatus;
    
    public Bestellung(java.util.Vector<PositionView> positionsListe,String bestellID,BestellstatusView bestellstatus,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.positionsListe = positionsListe;
        this.bestellID = bestellID;
        this.bestellstatus = bestellstatus;        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<PositionView> getPositionsListe()throws ModelException{
        return this.positionsListe;
    }
    public void setPositionsListe(java.util.Vector<PositionView> newValue) throws ModelException {
        this.positionsListe = newValue;
    }
    public String getBestellID()throws ModelException{
        return this.bestellID;
    }
    public void setBestellID(String newValue) throws ModelException {
        this.bestellID = newValue;
    }
    public BestellstatusView getBestellstatus()throws ModelException{
        return this.bestellstatus;
    }
    public void setBestellstatus(BestellstatusView newValue) throws ModelException {
        this.bestellstatus = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBestellung(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBestellung(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> positionsListe = this.getPositionsListe();
        if (positionsListe != null) {
            ViewObject.resolveVectorProxies(positionsListe, resultTable);
        }
        BestellstatusView bestellstatus = this.getBestellstatus();
        if (bestellstatus != null) {
            ((ViewProxi)bestellstatus).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(bestellstatus.getClassId(), bestellstatus.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getPositionsListe().size()) return new PositionsListeBestellungWrapper(this, originalIndex, (ViewRoot)this.getPositionsListe().get(index));
        index = index - this.getPositionsListe().size();
        if(index == 0 && this.getBestellstatus() != null) return new BestellstatusBestellungWrapper(this, originalIndex, (ViewRoot)this.getBestellstatus());
        if(this.getBestellstatus() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPositionsListe().size())
            + (this.getBestellstatus() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPositionsListe().size() == 0)
            && (this.getBestellstatus() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPositionsListeIterator = this.getPositionsListe().iterator();
        while(getPositionsListeIterator.hasNext()){
            if(getPositionsListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getBestellstatus() != null && this.getBestellstatus().equals(child)) return result;
        if(this.getBestellstatus() != null) result = result + 1;
        return -1;
    }
    public int getBestellIDIndex() throws ModelException {
        return 0 + this.getPositionsListe().size();
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "bestellID";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getBestellID();
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
            this.setBestellID(newValue);
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
