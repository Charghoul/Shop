package view;

import view.objects.*;

import view.visitor.*;

public interface LieferungView extends Anything, AbstractViewRoot {
    
    public BestellungView getBestellung()throws ModelException;
    public void setBestellung(BestellungView newValue) throws ModelException ;
    public LieferartView getLieferart()throws ModelException;
    public void setLieferart(LieferartView newValue) throws ModelException ;
    public long getLieferversuche()throws ModelException;
    public void setLieferversuche(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

