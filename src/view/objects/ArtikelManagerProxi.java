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
        java.util.Vector<String> komponentenListe_string = (java.util.Vector<String>)resultTable.get("komponentenListe");
        java.util.Vector<KomponenteView> komponentenListe = ViewProxi.getProxiVector(komponentenListe_string, connectionKey);
        ArtikelManagerView result$$ = new ArtikelManager(komponentenListe, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<KomponenteView> getKomponentenListe()throws ModelException{
        return ((ArtikelManager)this.getTheObject()).getKomponentenListe();
    }
    public void setKomponentenListe(java.util.Vector<KomponenteView> newValue) throws ModelException {
        ((ArtikelManager)this.getTheObject()).setKomponentenListe(newValue);
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
