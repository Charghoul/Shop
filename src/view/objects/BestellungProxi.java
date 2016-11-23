package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class BestellungProxi extends ViewProxi implements BestellungView{
    
    public BestellungProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public BestellungView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> positionsListe_string = (java.util.Vector<String>)resultTable.get("positionsListe");
        java.util.Vector<PositionInBestellungView> positionsListe = ViewProxi.getProxiVector(positionsListe_string, connectionKey);
        long bestellID = new Long((String)resultTable.get("bestellID")).longValue();
        long warenwert = new Long((String)resultTable.get("warenwert")).longValue();
        ViewProxi bestellstatus = null;
        String bestellstatus$String = (String)resultTable.get("bestellstatus");
        if (bestellstatus$String != null) {
            common.ProxiInformation bestellstatus$Info = common.RPCConstantsAndServices.createProxiInformation(bestellstatus$String);
            bestellstatus = view.objects.ViewProxi.createProxi(bestellstatus$Info,connectionKey);
            bestellstatus.setToString(bestellstatus$Info.getToString());
        }
        ViewProxi lieferart = null;
        String lieferart$String = (String)resultTable.get("lieferart");
        if (lieferart$String != null) {
            common.ProxiInformation lieferart$Info = common.RPCConstantsAndServices.createProxiInformation(lieferart$String);
            lieferart = view.objects.ViewProxi.createProxi(lieferart$Info,connectionKey);
            lieferart.setToString(lieferart$Info.getToString());
        }
        BestellungView result$$ = new Bestellung(positionsListe,(long)bestellID,(long)warenwert,(BestellstatusView)bestellstatus,(LieferartView)lieferart, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getPositionsListe().size()) return new PositionsListeBestellungWrapper(this, originalIndex, (ViewRoot)this.getPositionsListe().get(index));
        index = index - this.getPositionsListe().size();
        if(index == 0 && this.getLieferart() != null) return new LieferartBestellungWrapper(this, originalIndex, (ViewRoot)this.getLieferart());
        if(this.getLieferart() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPositionsListe().size())
            + (this.getLieferart() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getPositionsListe().size() == 0)
            && (this.getLieferart() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPositionsListeIterator = this.getPositionsListe().iterator();
        while(getPositionsListeIterator.hasNext()){
            if(getPositionsListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getLieferart() != null && this.getLieferart().equals(child)) return result;
        if(this.getLieferart() != null) result = result + 1;
        return -1;
    }
    
    public java.util.Vector<PositionInBestellungView> getPositionsListe()throws ModelException{
        return ((Bestellung)this.getTheObject()).getPositionsListe();
    }
    public void setPositionsListe(java.util.Vector<PositionInBestellungView> newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setPositionsListe(newValue);
    }
    public long getBestellID()throws ModelException{
        return ((Bestellung)this.getTheObject()).getBestellID();
    }
    public void setBestellID(long newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setBestellID(newValue);
    }
    public long getWarenwert()throws ModelException{
        return ((Bestellung)this.getTheObject()).getWarenwert();
    }
    public void setWarenwert(long newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setWarenwert(newValue);
    }
    public BestellstatusView getBestellstatus()throws ModelException{
        return ((Bestellung)this.getTheObject()).getBestellstatus();
    }
    public void setBestellstatus(BestellstatusView newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setBestellstatus(newValue);
    }
    public LieferartView getLieferart()throws ModelException{
        return ((Bestellung)this.getTheObject()).getLieferart();
    }
    public void setLieferart(LieferartView newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setLieferart(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBestellung(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBestellung(this);
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
