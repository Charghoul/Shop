package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class GeliefertProxi extends BestellstatusProxi implements GeliefertView{
    
    public GeliefertProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public GeliefertView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        GeliefertView result$$ = new Geliefert( this.getId(), this.getClassId());
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
    
    
    public void accept(BestellstatusVisitor visitor) throws ModelException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleGeliefert(this);
    }
    public <E extends view.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends view.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleGeliefert(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleGeliefert(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleGeliefert(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleGeliefert(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleGeliefert(this);
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
