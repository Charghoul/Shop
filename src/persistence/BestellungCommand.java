package persistence;

import model.visitor.*;

/* Additional import section end */

public interface BestellungCommand extends  Command {
    
    

    public void accept(BestellungCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(BestellungCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BestellungCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BestellungCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

