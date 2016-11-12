
package model.visitor;

import persistence.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException{
        this.standardHandling(serviceRegister);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.standardHandling(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.standardHandling(serviceAdmin);
    }
    protected abstract void standardHandling(Service4Public service) throws PersistenceException;
}
