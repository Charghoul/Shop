
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Bestellung extends view.objects.BestellungAbstrakt implements BestellungView{
    
    protected java.util.Vector<PositionInBestellungView> positionsListe;
    protected long bestellID;
    protected BestellstatusView bestellstatus;
    
    public Bestellung(long warenwert,LieferartView lieferart,java.util.Vector<PositionInBestellungView> positionsListe,long bestellID,BestellstatusView bestellstatus,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((long)warenwert,(LieferartView)lieferart,id, classId);
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
    
    public java.util.Vector<PositionInBestellungView> getPositionsListe()throws ModelException{
        return this.positionsListe;
    }
    public void setPositionsListe(java.util.Vector<PositionInBestellungView> newValue) throws ModelException {
        this.positionsListe = newValue;
    }
    public long getBestellID()throws ModelException{
        return this.bestellID;
    }
    public void setBestellID(long newValue) throws ModelException {
        this.bestellID = newValue;
    }
    public BestellstatusView getBestellstatus()throws ModelException{
        return this.bestellstatus;
    }
    public void setBestellstatus(BestellstatusView newValue) throws ModelException {
        this.bestellstatus = newValue;
    }
    
    public void accept(BestellungAbstraktVisitor visitor) throws ModelException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBestellung(this);
    }
    public <E extends view.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends view.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBestellung(this);
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
        LieferartView lieferart = this.getLieferart();
        if (lieferart != null) {
            ((ViewProxi)lieferart).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(lieferart.getClassId(), lieferart.getId())));
        }
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
        if(index == 0 && this.getLieferart() != null) return new LieferartBestellungAbstraktWrapper(this, originalIndex, (ViewRoot)this.getLieferart());
        if(this.getLieferart() != null) index = index - 1;
        if(index < this.getPositionsListe().size()) return new PositionsListeBestellungWrapper(this, originalIndex, (ViewRoot)this.getPositionsListe().get(index));
        index = index - this.getPositionsListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLieferart() == null ? 0 : 1)
            + (this.getPositionsListe().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getLieferart() == null ? true : false)
            && (this.getPositionsListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getLieferart() != null && this.getLieferart().equals(child)) return result;
        if(this.getLieferart() != null) result = result + 1;
        java.util.Iterator<?> getPositionsListeIterator = this.getPositionsListe().iterator();
        while(getPositionsListeIterator.hasNext()){
            if(getPositionsListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getWarenwertIndex() throws ModelException {
        return 0;
    }
    public int getBestellIDIndex() throws ModelException {
        return 0 + 1 + (this.getLieferart() == null ? 0 : 1) + this.getPositionsListe().size();
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "warenwert";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "bestellID";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getWarenwert());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getBestellID());
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
            this.setWarenwert(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setBestellID(Long.parseLong(newValue));
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
