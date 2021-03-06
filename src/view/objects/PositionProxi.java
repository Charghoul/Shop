package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class PositionProxi extends PositionAbstraktProxi implements PositionView{
    
    public PositionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public PositionView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi artikel = null;
        String artikel$String = (String)resultTable.get("artikel");
        if (artikel$String != null) {
            common.ProxiInformation artikel$Info = common.RPCConstantsAndServices.createProxiInformation(artikel$String);
            artikel = view.objects.ViewProxi.createProxi(artikel$Info,connectionKey);
            artikel.setToString(artikel$Info.getToString());
        }
        long menge = new Long((String)resultTable.get("menge")).longValue();
        PositionView result$$ = new Position((ArtikelView)artikel,(long)menge, this.getId(), this.getClassId());
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
    
    
    public void accept(PositionAbstraktVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(PositionAbstraktReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends view.UserException>  void accept(PositionAbstraktExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends view.UserException> R accept(PositionAbstraktReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handlePosition(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePosition(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePosition(this);
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
