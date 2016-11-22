package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class KontoProxi extends ViewProxi implements KontoView{
    
    public KontoProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public KontoView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long kontostand = new Long((String)resultTable.get("kontostand")).longValue();
        long limit = new Long((String)resultTable.get("limit")).longValue();
        ViewProxi myServiceKunde = null;
        String myServiceKunde$String = (String)resultTable.get("myServiceKunde");
        if (myServiceKunde$String != null) {
            common.ProxiInformation myServiceKunde$Info = common.RPCConstantsAndServices.createProxiInformation(myServiceKunde$String);
            myServiceKunde = view.objects.ViewProxi.createProxi(myServiceKunde$Info,connectionKey);
            myServiceKunde.setToString(myServiceKunde$Info.getToString());
        }
        KontoView result$$ = new Konto((long)kontostand,(long)limit,(ServiceKundeView)myServiceKunde, this.getId(), this.getClassId());
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
    
    public long getKontostand()throws ModelException{
        return ((Konto)this.getTheObject()).getKontostand();
    }
    public void setKontostand(long newValue) throws ModelException {
        ((Konto)this.getTheObject()).setKontostand(newValue);
    }
    public long getLimit()throws ModelException{
        return ((Konto)this.getTheObject()).getLimit();
    }
    public void setLimit(long newValue) throws ModelException {
        ((Konto)this.getTheObject()).setLimit(newValue);
    }
    public ServiceKundeView getMyServiceKunde()throws ModelException{
        return ((Konto)this.getTheObject()).getMyServiceKunde();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKonto(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKonto(this);
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
