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
        java.util.Vector<PositionView> positionsListe = ViewProxi.getProxiVector(positionsListe_string, connectionKey);
        String ID = (String)resultTable.get("ID");
        ViewProxi bestellstatus = null;
        String bestellstatus$String = (String)resultTable.get("bestellstatus");
        if (bestellstatus$String != null) {
            common.ProxiInformation bestellstatus$Info = common.RPCConstantsAndServices.createProxiInformation(bestellstatus$String);
            bestellstatus = view.objects.ViewProxi.createProxi(bestellstatus$Info,connectionKey);
            bestellstatus.setToString(bestellstatus$Info.getToString());
        }
        BestellungView result$$ = new Bestellung(positionsListe,(String)ID,(BestellstatusView)bestellstatus, this.getId(), this.getClassId());
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
        if(index == 0 && this.getBestellstatus() != null) return new BestellstatusBestellungWrapper(this, originalIndex, (ViewRoot)this.getBestellstatus());
        if(this.getBestellstatus() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPositionsListe().size())
            + (this.getBestellstatus() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getPositionsListe().size() == 0)
            && (this.getBestellstatus() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPositionsListeIterator = this.getPositionsListe().iterator();
        while(getPositionsListeIterator.hasNext()){
            if(getPositionsListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getBestellstatus() != null && this.getBestellstatus().equals(child)) return result;
        if(this.getBestellstatus() != null) result = result + 1;
        return -1;
    }
    
    public java.util.Vector<PositionView> getPositionsListe()throws ModelException{
        return ((Bestellung)this.getTheObject()).getPositionsListe();
    }
    public void setPositionsListe(java.util.Vector<PositionView> newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setPositionsListe(newValue);
    }
    public String getID()throws ModelException{
        return ((Bestellung)this.getTheObject()).getID();
    }
    public void setID(String newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setID(newValue);
    }
    public BestellstatusView getBestellstatus()throws ModelException{
        return ((Bestellung)this.getTheObject()).getBestellstatus();
    }
    public void setBestellstatus(BestellstatusView newValue) throws ModelException {
        ((Bestellung)this.getTheObject()).setBestellstatus(newValue);
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
