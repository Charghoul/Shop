package view;

import view.objects.*;

import view.visitor.*;

public interface EinkaufsManagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<PositionView> getEinkaufsListe()throws ModelException;
    public void setEinkaufsListe(java.util.Vector<PositionView> newValue) throws ModelException ;
    public BestellManagerView getBestellManager()throws ModelException;
    public void setBestellManager(BestellManagerView newValue) throws ModelException ;
    public ServiceKundeView getMyServiceKunde()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

