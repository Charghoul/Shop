
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ArtikelManager extends ViewObject implements ArtikelManagerView{
    
    protected java.util.Vector<KomponenteView> komponentenListe;
    
    public ArtikelManager(java.util.Vector<KomponenteView> komponentenListe,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.komponentenListe = komponentenListe;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<KomponenteView> getKomponentenListe()throws ModelException{
        return this.komponentenListe;
    }
    public void setKomponentenListe(java.util.Vector<KomponenteView> newValue) throws ModelException {
        this.komponentenListe = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleArtikelManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> komponentenListe = this.getKomponentenListe();
        if (komponentenListe != null) {
            ViewObject.resolveVectorProxies(komponentenListe, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getKomponentenListe().size()) return new KomponentenListeArtikelManagerWrapper(this, originalIndex, (ViewRoot)this.getKomponentenListe().get(index));
        index = index - this.getKomponentenListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getKomponentenListe().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getKomponentenListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getKomponentenListeIterator = this.getKomponentenListe().iterator();
        while(getKomponentenListeIterator.hasNext()){
            if(getKomponentenListeIterator.next().equals(child)) return result;
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
