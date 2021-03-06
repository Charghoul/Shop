package view;

import view.visitor.*;

public interface VerkaufView extends ArtikelstatusView {
    
    
    public void accept(ArtikelstatusVisitor visitor) throws ModelException;
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

