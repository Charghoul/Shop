package persistence;

import model.visitor.*;

/* Additional import section end */

public interface LieferartCommand extends  Command {
    
    

    public void accept(LieferartCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(LieferartCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LieferartCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LieferartCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

