
package view.objects;

import view.BestellungView;
import view.LieferartView;
import view.LieferungView;
import view.ModelException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Lieferung extends ViewObject implements LieferungView{
    
    protected BestellungView bestellung;
    protected LieferartView lieferart;
    protected long lieferversuche;
    
    public Lieferung(BestellungView bestellung,LieferartView lieferart,long lieferversuche,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.bestellung = bestellung;
        this.lieferart = lieferart;
        this.lieferversuche = lieferversuche;        
    }
    
    static public long getTypeId() {
        return 150;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public BestellungView getBestellung()throws ModelException{
        return this.bestellung;
    }
    public void setBestellung(BestellungView newValue) throws ModelException {
        this.bestellung = newValue;
    }
    public LieferartView getLieferart()throws ModelException{
        return this.lieferart;
    }
    public void setLieferart(LieferartView newValue) throws ModelException {
        this.lieferart = newValue;
    }
    public long getLieferversuche()throws ModelException{
        return this.lieferversuche;
    }
    public void setLieferversuche(long newValue) throws ModelException {
        this.lieferversuche = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferung(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferung(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferung(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        BestellungView bestellung = this.getBestellung();
        if (bestellung != null) {
            ((ViewProxi)bestellung).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(bestellung.getClassId(), bestellung.getId())));
        }
        LieferartView lieferart = this.getLieferart();
        if (lieferart != null) {
            ((ViewProxi)lieferart).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(lieferart.getClassId(), lieferart.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getBestellung() != null) return new BestellungLieferungWrapper(this, originalIndex, (ViewRoot)this.getBestellung());
        if(this.getBestellung() != null) index = index - 1;
        if(index == 0 && this.getLieferart() != null) return new LieferartLieferungWrapper(this, originalIndex, (ViewRoot)this.getLieferart());
        if(this.getLieferart() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBestellung() == null ? 0 : 1)
            + (this.getLieferart() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getBestellung() == null ? true : false)
            && (this.getLieferart() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBestellung() != null && this.getBestellung().equals(child)) return result;
        if(this.getBestellung() != null) result = result + 1;
        if(this.getLieferart() != null && this.getLieferart().equals(child)) return result;
        if(this.getLieferart() != null) result = result + 1;
        return -1;
    }
    public int getLieferversucheIndex() throws ModelException {
        return 0 + (this.getBestellung() == null ? 0 : 1) + (this.getLieferart() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "lieferversuche";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getLieferversuche());
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
            this.setLieferversuche(Long.parseLong(newValue));
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
