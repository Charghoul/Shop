package view;

import view.visitor.*;

public interface LieferungView extends ZeitObjektView {
    
    
    public void accept(LieferungVisitor visitor) throws ModelException;
    public <R> R accept(LieferungReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(LieferungExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(LieferungReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

