
package model.visitor;

import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException, E;
    public R handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException, E;
    public R handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException, E;
    
}
