
package model.visitor;

import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException, E;
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException, E;
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException, E;
    
}
