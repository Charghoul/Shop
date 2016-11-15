package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ArtikelManagerProxi extends ViewProxi implements ArtikelManagerView{
    
    public ArtikelManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ArtikelManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> artikelListe_string = (java.util.Vector<String>)resultTable.get("artikelListe");
        java.util.Vector<ArtikelView> artikelListe = ViewProxi.getProxiVector(artikelListe_string, connectionKey);
        java.util.Vector<String> produktgruppen_string = (java.util.Vector<String>)resultTable.get("produktgruppen");
        java.util.Vector<ProduktgruppeView> produktgruppen = ViewProxi.getProxiVector(produktgruppen_string, connectionKey);
        ArtikelManagerView result$$ = new ArtikelManager(artikelListe,produktgruppen, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<ArtikelView> getArtikelListe()throws ModelException{
        return ((ArtikelManager)this.getTheObject()).getArtikelListe();
    }
    public void setArtikelListe(java.util.Vector<ArtikelView> newValue) throws ModelException {
        ((ArtikelManager)this.getTheObject()).setArtikelListe(newValue);
    }
    public java.util.Vector<ProduktgruppeView> getProduktgruppen()throws ModelException{
        return ((ArtikelManager)this.getTheObject()).getProduktgruppen();
    }
    public void setProduktgruppen(java.util.Vector<ProduktgruppeView> newValue) throws ModelException {
        ((ArtikelManager)this.getTheObject()).setProduktgruppen(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
