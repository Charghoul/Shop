
package model.visitor;

import persistence.*;

public interface ServiceVisitor extends ServiceShopVisitor{
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    
}
