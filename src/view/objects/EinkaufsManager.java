
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class EinkaufsManager extends ViewObject implements EinkaufsManagerView{
    
    protected java.util.Vector<PositionView> einkaufsListe;
    protected BestellManagerView bestellManager;
    protected ServiceKundeView myServiceKunde;
    
    public EinkaufsManager(java.util.Vector<PositionView> einkaufsListe,BestellManagerView bestellManager,ServiceKundeView myServiceKunde,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.einkaufsListe = einkaufsListe;
        this.bestellManager = bestellManager;
        this.myServiceKunde = myServiceKunde;        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<PositionView> getEinkaufsListe()throws ModelException{
        return this.einkaufsListe;
    }
    public void setEinkaufsListe(java.util.Vector<PositionView> newValue) throws ModelException {
        this.einkaufsListe = newValue;
    }
    public BestellManagerView getBestellManager()throws ModelException{
        return this.bestellManager;
    }
    public void setBestellManager(BestellManagerView newValue) throws ModelException {
        this.bestellManager = newValue;
    }
    public ServiceKundeView getMyServiceKunde()throws ModelException{
        return this.myServiceKunde;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleEinkaufsManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleEinkaufsManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleEinkaufsManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleEinkaufsManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> einkaufsListe = this.getEinkaufsListe();
        if (einkaufsListe != null) {
            ViewObject.resolveVectorProxies(einkaufsListe, resultTable);
        }
        BestellManagerView bestellManager = this.getBestellManager();
        if (bestellManager != null) {
            ((ViewProxi)bestellManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(bestellManager.getClassId(), bestellManager.getId())));
        }
        ServiceKundeView myServiceKunde = this.getMyServiceKunde();
        if (myServiceKunde != null) {
            ((ViewProxi)myServiceKunde).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myServiceKunde.getClassId(), myServiceKunde.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getEinkaufsListe().size()) return new EinkaufsListeEinkaufsManagerWrapper(this, originalIndex, (ViewRoot)this.getEinkaufsListe().get(index));
        index = index - this.getEinkaufsListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getEinkaufsListe().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getEinkaufsListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getEinkaufsListeIterator = this.getEinkaufsListe().iterator();
        while(getEinkaufsListeIterator.hasNext()){
            if(getEinkaufsListeIterator.next().equals(child)) return result;
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
