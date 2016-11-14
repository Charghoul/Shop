package persistence;

import model.visitor.*;

/* Additional import section end */

public interface WarenlagerCommand extends  Command {
    
    

    public void accept(WarenlagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(WarenlagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(WarenlagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(WarenlagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

