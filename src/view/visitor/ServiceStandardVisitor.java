
package view.visitor;

import view.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.standardHandling(serviceRegister);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.standardHandling(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.standardHandling(serviceAdmin);
    }
    protected abstract void standardHandling(ServiceView service) throws ModelException;
}
