package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class LieferartManagerProxi extends ViewProxi implements LieferartManagerView{
    
    public LieferartManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public LieferartManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> lieferartenListe_string = (java.util.Vector<String>)resultTable.get("lieferartenListe");
        java.util.Vector<LieferartView> lieferartenListe = ViewProxi.getProxiVector(lieferartenListe_string, connectionKey);
        ViewProxi myService = null;
        String myService$String = (String)resultTable.get("myService");
        if (myService$String != null) {
            common.ProxiInformation myService$Info = common.RPCConstantsAndServices.createProxiInformation(myService$String);
            myService = view.objects.ViewProxi.createProxi(myService$Info,connectionKey);
            myService.setToString(myService$Info.getToString());
        }
        LieferartManagerView result$$ = new LieferartManager(lieferartenListe,(ServiceAdminView)myService, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getLieferartenListe().size()) return new LieferartenListeLieferartManagerWrapper(this, originalIndex, (ViewRoot)this.getLieferartenListe().get(index));
        index = index - this.getLieferartenListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLieferartenListe().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getLieferartenListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getLieferartenListeIterator = this.getLieferartenListe().iterator();
        while(getLieferartenListeIterator.hasNext()){
            if(getLieferartenListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<LieferartView> getLieferartenListe()throws ModelException{
        return ((LieferartManager)this.getTheObject()).getLieferartenListe();
    }
    public void setLieferartenListe(java.util.Vector<LieferartView> newValue) throws ModelException {
        ((LieferartManager)this.getTheObject()).setLieferartenListe(newValue);
    }
    public ServiceAdminView getMyService()throws ModelException{
        return ((LieferartManager)this.getTheObject()).getMyService();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferartManager(this);
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
