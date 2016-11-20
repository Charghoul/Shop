
package view.visitor;

import view.*;

public interface ServiceReturnVisitor<R> extends ServiceShopReturnVisitor<R> {
    
    public R handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException;
    
}
