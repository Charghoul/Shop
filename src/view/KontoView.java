package view;

import view.objects.*;

import view.visitor.*;

public interface KontoView extends Anything, AbstractViewRoot {
    
    public long getKontostand()throws ModelException;
    public void setKontostand(long newValue) throws ModelException ;
    public long getLimit()throws ModelException;
    public void setLimit(long newValue) throws ModelException ;
    public ServiceKundeView getMyServiceKunde()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

