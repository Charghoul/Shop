package view;

import view.objects.*;

import view.visitor.*;

public interface ArtikelstatusView extends Anything, AbstractViewRoot {
    
    
    public void accept(ArtikelstatusVisitor visitor) throws ModelException;
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

