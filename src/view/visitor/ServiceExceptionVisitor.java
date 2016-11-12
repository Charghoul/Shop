
package view.visitor;

import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException, E;
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException, E;
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException, E;
    
}
