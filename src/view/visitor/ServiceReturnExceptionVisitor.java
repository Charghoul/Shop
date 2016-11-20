
package view.visitor;

import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends view.UserException> extends ServiceShopReturnExceptionVisitor<R, E> {
    
    public R handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException, E;
    
}
