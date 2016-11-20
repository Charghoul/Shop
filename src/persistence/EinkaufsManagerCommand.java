package persistence;

import model.visitor.*;

/* Additional import section end */

public interface EinkaufsManagerCommand extends  Command {
    
    

    public void accept(EinkaufsManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(EinkaufsManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(EinkaufsManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(EinkaufsManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

