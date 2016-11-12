
package view.visitor;

import view.*;

public interface ServiceVisitor {
    
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException;
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException;
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException;
    
}
