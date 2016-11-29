package view;

import view.objects.*;

import view.visitor.*;

public interface KundeView extends Anything, AbstractViewRoot {
    
    public String getBenutzername()throws ModelException;
    public void setBenutzername(String newValue) throws ModelException ;
    public String getPasswort()throws ModelException;
    public void setPasswort(String newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

