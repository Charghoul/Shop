package view;

import view.objects.*;

import view.visitor.*;

public interface LieferartManagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<LieferartView> getLieferartenListe()throws ModelException;
    public void setLieferartenListe(java.util.Vector<LieferartView> newValue) throws ModelException ;
    public long getRueckversandGebuehr()throws ModelException;
    public void setRueckversandGebuehr(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

