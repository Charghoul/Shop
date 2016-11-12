package view;

import view.visitor.*;

public interface RueckversandView extends BestellstatusView {
    
    
    public void accept(BestellstatusVisitor visitor) throws ModelException;
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

