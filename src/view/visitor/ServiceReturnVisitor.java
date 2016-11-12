
package view.visitor;

import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException;
    public R handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException;
    public R handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException;
    
}
