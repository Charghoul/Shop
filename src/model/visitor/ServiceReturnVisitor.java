
package model.visitor;

import persistence.*;

public interface ServiceReturnVisitor<R> extends ServiceShopReturnVisitor<R> {
    
    public R handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    
}
