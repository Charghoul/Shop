
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException{
        this.standardHandling(serviceRegister);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.standardHandling(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.standardHandling(serviceAdmin);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
