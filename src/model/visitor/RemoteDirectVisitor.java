
package model.visitor;

import persistence.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException{
        this.handleService(serviceRegister);
    }
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException{
        this.handleService(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException{
        this.handleService(serviceAdmin);
    }
    
}
