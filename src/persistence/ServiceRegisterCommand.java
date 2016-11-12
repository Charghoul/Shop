package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ServiceRegisterCommand extends  Command {
    
    

    public void accept(ServiceRegisterCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceRegisterCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ServiceRegisterCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ServiceRegisterCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

