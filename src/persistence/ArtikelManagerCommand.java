package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ArtikelManagerCommand extends  Command {
    
    

    public void accept(ArtikelManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ArtikelManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ArtikelManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ArtikelManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

