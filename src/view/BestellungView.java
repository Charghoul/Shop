package view;

import view.objects.*;

import view.visitor.*;

public interface BestellungView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<PositionView> getPositionsListe()throws ModelException;
    public void setPositionsListe(java.util.Vector<PositionView> newValue) throws ModelException ;
    public String getBestellID()throws ModelException;
    public void setBestellID(String newValue) throws ModelException ;
    public BestellstatusView getBestellstatus()throws ModelException;
    public void setBestellstatus(BestellstatusView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

