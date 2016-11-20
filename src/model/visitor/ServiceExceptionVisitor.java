
package model.visitor;

import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> extends ServiceShopExceptionVisitor<E>{
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException, E;
    
}
