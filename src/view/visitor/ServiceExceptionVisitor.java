
package view.visitor;

import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> extends ServiceShopExceptionVisitor<E>{
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException, E;
    
}
