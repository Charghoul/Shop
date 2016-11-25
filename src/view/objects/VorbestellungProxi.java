package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class VorbestellungProxi extends BestellungAbstraktProxi implements VorbestellungView{
    
    public VorbestellungProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public VorbestellungView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long warenwert = new Long((String)resultTable.get("warenwert")).longValue();
        ViewProxi lieferart = null;
        String lieferart$String = (String)resultTable.get("lieferart");
        if (lieferart$String != null) {
            common.ProxiInformation lieferart$Info = common.RPCConstantsAndServices.createProxiInformation(lieferart$String);
            lieferart = view.objects.ViewProxi.createProxi(lieferart$Info,connectionKey);
            lieferart.setToString(lieferart$Info.getToString());
        }
        java.util.Vector<String> positionsListe_string = (java.util.Vector<String>)resultTable.get("positionsListe");
        java.util.Vector<PositionView> positionsListe = ViewProxi.getProxiVector(positionsListe_string, connectionKey);
        VorbestellungView result$$ = new Vorbestellung((long)warenwert,(LieferartView)lieferart,positionsListe, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getLieferart() != null) return new LieferartBestellungAbstraktWrapper(this, originalIndex, (ViewRoot)this.getLieferart());
        if(this.getLieferart() != null) index = index - 1;
        if(index < this.getPositionsListe().size()) return new PositionsListeVorbestellungWrapper(this, originalIndex, (ViewRoot)this.getPositionsListe().get(index));
        index = index - this.getPositionsListe().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLieferart() == null ? 0 : 1)
            + (this.getPositionsListe().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getLieferart() == null ? true : false)
            && (this.getPositionsListe().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getLieferart() != null && this.getLieferart().equals(child)) return result;
        if(this.getLieferart() != null) result = result + 1;
        java.util.Iterator<?> getPositionsListeIterator = this.getPositionsListe().iterator();
        while(getPositionsListeIterator.hasNext()){
            if(getPositionsListeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<PositionView> getPositionsListe()throws ModelException{
        return ((Vorbestellung)this.getTheObject()).getPositionsListe();
    }
    public void setPositionsListe(java.util.Vector<PositionView> newValue) throws ModelException {
        ((Vorbestellung)this.getTheObject()).setPositionsListe(newValue);
    }
    
    public void accept(BestellungAbstraktVisitor visitor) throws ModelException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends view.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends view.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleVorbestellung(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleVorbestellung(this);
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
