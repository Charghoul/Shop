
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.handleService(serviceRegister);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.handleService(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.handleService(serviceAdmin);
    }
    
}
