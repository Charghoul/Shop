
package view.visitor;

import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException, E;
    public R handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException, E;
    public R handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException, E;
    
}
