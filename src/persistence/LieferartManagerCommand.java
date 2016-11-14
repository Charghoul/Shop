package persistence;
import model.visitor.*;

/* Additional import section end */

public interface LieferartManagerCommand extends  Command {
    
    

    public void accept(LieferartManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(LieferartManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LieferartManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LieferartManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

