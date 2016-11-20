
package view.visitor;

import view.*;

public interface ServiceVisitor extends ServiceShopVisitor{
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException;
    
}
