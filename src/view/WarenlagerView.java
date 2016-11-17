package view;

import view.objects.*;

import view.visitor.*;

public interface WarenlagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<IntegerWrapperView> getTemplist()throws ModelException;
    public void setTemplist(java.util.Vector<IntegerWrapperView> newValue) throws ModelException ;
    public java.util.Vector<PositionView> getWarenListe()throws ModelException;
    public void setWarenListe(java.util.Vector<PositionView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

