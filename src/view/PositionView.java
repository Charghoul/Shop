package view;

import view.objects.*;

import view.visitor.*;

public interface PositionView extends Anything, AbstractViewRoot {
    
    public ArtikelView getArtikel()throws ModelException;
    public void setArtikel(ArtikelView newValue) throws ModelException ;
    public long getMenge()throws ModelException;
    public void setMenge(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

