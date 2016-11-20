package view;

import view.visitor.*;

public interface PositionView extends PositionAbstraktView {
    
    
    public void accept(PositionAbstraktVisitor visitor) throws ModelException;
    public <R> R accept(PositionAbstraktReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(PositionAbstraktExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(PositionAbstraktReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

