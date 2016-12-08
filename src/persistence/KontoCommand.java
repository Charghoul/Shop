package persistence;

import model.visitor.*;

/* Additional import section end */

public interface KontoCommand extends  Command {
    
    

    public void accept(KontoCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(KontoCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(KontoCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(KontoCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

