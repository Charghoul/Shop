package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class KundeProxi extends ViewProxi implements KundeView{
    
    public KundeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public KundeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String benutzername = (String)resultTable.get("benutzername");
        String passwort = (String)resultTable.get("passwort");
        KundeView result$$ = new Kunde((String)benutzername,(String)passwort, this.getId(), this.getClassId());
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
    
    public String getBenutzername()throws ModelException{
        return ((Kunde)this.getTheObject()).getBenutzername();
    }
    public void setBenutzername(String newValue) throws ModelException {
        ((Kunde)this.getTheObject()).setBenutzername(newValue);
    }
    public String getPasswort()throws ModelException{
        return ((Kunde)this.getTheObject()).getPasswort();
    }
    public void setPasswort(String newValue) throws ModelException {
        ((Kunde)this.getTheObject()).setPasswort(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
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
