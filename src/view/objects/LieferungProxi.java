package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class LieferungProxi extends ViewProxi implements LieferungView{
    
    public LieferungProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public LieferungView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi bestellung = null;
        String bestellung$String = (String)resultTable.get("bestellung");
        if (bestellung$String != null) {
            common.ProxiInformation bestellung$Info = common.RPCConstantsAndServices.createProxiInformation(bestellung$String);
            bestellung = view.objects.ViewProxi.createProxi(bestellung$Info,connectionKey);
            bestellung.setToString(bestellung$Info.getToString());
        }
        ViewProxi lieferart = null;
        String lieferart$String = (String)resultTable.get("lieferart");
        if (lieferart$String != null) {
            common.ProxiInformation lieferart$Info = common.RPCConstantsAndServices.createProxiInformation(lieferart$String);
            lieferart = view.objects.ViewProxi.createProxi(lieferart$Info,connectionKey);
            lieferart.setToString(lieferart$Info.getToString());
        }
        long lieferversuche = new Long((String)resultTable.get("lieferversuche")).longValue();
        LieferungView result$$ = new Lieferung((BestellungView)bestellung,(LieferartView)lieferart,(long)lieferversuche, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getBestellung() != null) return new BestellungLieferungWrapper(this, originalIndex, (ViewRoot)this.getBestellung());
        if(this.getBestellung() != null) index = index - 1;
        if(index == 0 && this.getLieferart() != null) return new LieferartLieferungWrapper(this, originalIndex, (ViewRoot)this.getLieferart());
        if(this.getLieferart() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBestellung() == null ? 0 : 1)
            + (this.getLieferart() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBestellung() == null ? true : false)
            && (this.getLieferart() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBestellung() != null && this.getBestellung().equals(child)) return result;
        if(this.getBestellung() != null) result = result + 1;
        if(this.getLieferart() != null && this.getLieferart().equals(child)) return result;
        if(this.getLieferart() != null) result = result + 1;
        return -1;
    }
    
    public BestellungView getBestellung()throws ModelException{
        return ((Lieferung)this.getTheObject()).getBestellung();
    }
    public void setBestellung(BestellungView newValue) throws ModelException {
        ((Lieferung)this.getTheObject()).setBestellung(newValue);
    }
    public LieferartView getLieferart()throws ModelException{
        return ((Lieferung)this.getTheObject()).getLieferart();
    }
    public void setLieferart(LieferartView newValue) throws ModelException {
        ((Lieferung)this.getTheObject()).setLieferart(newValue);
    }
    public long getLieferversuche()throws ModelException{
        return ((Lieferung)this.getTheObject()).getLieferversuche();
    }
    public void setLieferversuche(long newValue) throws ModelException {
        ((Lieferung)this.getTheObject()).setLieferversuche(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLieferung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLieferung(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLieferung(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLieferung(this);
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
