package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class EinkaufsManagerProxi extends ViewProxi implements EinkaufsManagerView{
    
    public EinkaufsManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public EinkaufsManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> einkaufsListe_string = (java.util.Vector<String>)resultTable.get("einkaufsListe");
        java.util.Vector<PositionView> einkaufsListe = ViewProxi.getProxiVector(einkaufsListe_string, connectionKey);
        EinkaufsManagerView result$$ = new EinkaufsManager(einkaufsListe, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<PositionView> getEinkaufsListe()throws ModelException{
        return ((EinkaufsManager)this.getTheObject()).getEinkaufsListe();
    }
    public void setEinkaufsListe(java.util.Vector<PositionView> newValue) throws ModelException {
        ((EinkaufsManager)this.getTheObject()).setEinkaufsListe(newValue);
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
