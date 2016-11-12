package view;

import view.objects.*;

import view.visitor.*;

public interface BestellstatusView extends Anything, AbstractViewRoot {
    
    
    public void accept(BestellstatusVisitor visitor) throws ModelException;
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

