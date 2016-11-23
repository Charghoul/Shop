package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class LieferartProxi extends ViewProxi implements LieferartView{
    
    public LieferartProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public LieferartView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        long lieferzeit = new Long((String)resultTable.get("lieferzeit")).longValue();
        long preis = new Long((String)resultTable.get("preis")).longValue();
        LieferartView result$$ = new Lieferart((String)name,(long)lieferzeit,(long)preis, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    public String getName()throws ModelException{
        return ((Lieferart)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Lieferart)this.getTheObject()).setName(newValue);
    }
    public long getLieferzeit()throws ModelException{
        return ((Lieferart)this.getTheObject()).getLieferzeit();
    }
    public void setLieferzeit(long newValue) throws ModelException {
        ((Lieferart)this.getTheObject()).setLieferzeit(newValue);
    }
    public long getPreis()throws ModelException{
        return ((Lieferart)this.getTheObject()).getPreis();
    }
    public void setPreis(long newValue) throws ModelException {
        ((Lieferart)this.getTheObject()).setPreis(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferart(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferart(this);
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
