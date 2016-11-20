
package model.visitor;

import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> extends ServiceShopReturnExceptionVisitor<R, E> {
    
    public R handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException, E;
    
}
