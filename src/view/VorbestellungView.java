package view;

import view.visitor.*;

public interface VorbestellungView extends BestellungAbstraktView {
    
    public java.util.Vector<PositionView> getPositionsListe()throws ModelException;
    public void setPositionsListe(java.util.Vector<PositionView> newValue) throws ModelException ;
    
    public void accept(BestellungAbstraktVisitor visitor) throws ModelException;
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

