package persistence;
import model.visitor.*;

/* Additional import section end */

public interface ArtikelCommand extends  Command {
    
    

    public void accept(ArtikelCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ArtikelCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ArtikelCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ArtikelCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

