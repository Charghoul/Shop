
package model.visitor;

import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException;
    public R handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException;
    public R handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    
}
