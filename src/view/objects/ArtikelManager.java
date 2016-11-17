
package view.objects;

import view.ArtikelManagerView;
import view.ArtikelView;
import view.ModelException;
import view.ProduktgruppeView;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class ArtikelManager extends ViewObject implements ArtikelManagerView{
    
    protected java.util.Vector<ArtikelView> artikelListe;
    protected java.util.Vector<ProduktgruppeView> produktgruppen;
    
    public ArtikelManager(java.util.Vector<ArtikelView> artikelListe,java.util.Vector<ProduktgruppeView> produktgruppen,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.artikelListe = artikelListe;
        this.produktgruppen = produktgruppen;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ArtikelView> getArtikelListe()throws ModelException{
        return this.artikelListe;
    }
    public void setArtikelListe(java.util.Vector<ArtikelView> newValue) throws ModelException {
        this.artikelListe = newValue;
    }
    public java.util.Vector<ProduktgruppeView> getProduktgruppen()throws ModelException{
        return this.produktgruppen;
    }
    public void setProduktgruppen(java.util.Vector<ProduktgruppeView> newValue) throws ModelException {
        this.produktgruppen = newValue;
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
        java.util.Vector<?> artikelListe = this.getArtikelListe();
        if (artikelListe != null) {
            ViewObject.resolveVectorProxies(artikelListe, resultTable);
        }
        java.util.Vector<?> produktgruppen = this.getProduktgruppen();
        if (produktgruppen != null) {
            ViewObject.resolveVectorProxies(produktgruppen, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getArtikelListe().size()) return new ArtikelListeArtikelManagerWrapper(this, originalIndex, (ViewRoot)this.getArtikelListe().get(index));
        index = index - this.getArtikelListe().size();
        if(index < this.getProduktgruppen().size()) return new ProduktgruppenArtikelManagerWrapper(this, originalIndex, (ViewRoot)this.getProduktgruppen().get(index));
        index = index - this.getProduktgruppen().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getArtikelListe().size())
            + (this.getProduktgruppen().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getArtikelListe().size() == 0)
            && (this.getProduktgruppen().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getArtikelListeIterator = this.getArtikelListe().iterator();
        while(getArtikelListeIterator.hasNext()){
            if(getArtikelListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getProduktgruppenIterator = this.getProduktgruppen().iterator();
        while(getProduktgruppenIterator.hasNext()){
            if(getProduktgruppenIterator.next().equals(child)) return result;
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
