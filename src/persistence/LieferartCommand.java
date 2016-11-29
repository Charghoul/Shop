package persistence;


/* Additional import section end */

import model.visitor.LieferartCommandExceptionVisitor;
import model.visitor.LieferartCommandReturnExceptionVisitor;
import model.visitor.LieferartCommandReturnVisitor;
import model.visitor.LieferartCommandVisitor;

public interface LieferartCommand extends  Command {
    
    

    public void accept(LieferartCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(LieferartCommandReturnVisitor<R> visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LieferartCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LieferartCommandReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E;
}

