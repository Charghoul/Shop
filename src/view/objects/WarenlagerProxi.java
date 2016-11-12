package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class WarenlagerProxi extends ViewProxi implements WarenlagerView{
    
    public WarenlagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public WarenlagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> warenListe_string = (java.util.Vector<String>)resultTable.get("warenListe");
        java.util.Vector<PositionView> warenListe = ViewProxi.getProxiVector(warenListe_string, connectionKey);
        WarenlagerView result$$ = new Warenlager(warenListe, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getWarenListe().size()) return new WarenListeWarenlagerWrapper(this, originalIndex, (ViewRoot)this.getWarenListe().get(index));
        index = index - this.getWarenListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getWarenListe().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getWarenListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getWarenListeIterator = this.getWarenListe().iterator();
        while(getWarenListeIterator.hasNext()){
            if(getWarenListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<PositionView> getWarenListe()throws ModelException{
        return ((Warenlager)this.getTheObject()).getWarenListe();
    }
    public void setWarenListe(java.util.Vector<PositionView> newValue) throws ModelException {
        ((Warenlager)this.getTheObject()).setWarenListe(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleWarenlager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleWarenlager(this);
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
