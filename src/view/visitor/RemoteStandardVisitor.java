
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleServiceRegister(ServiceRegisterView serviceRegister) throws ModelException{
        this.standardHandling(serviceRegister);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleServiceKunde(ServiceKundeView serviceKunde) throws ModelException{
        this.standardHandling(serviceKunde);
    }
    public void handleServiceAdmin(ServiceAdminView serviceAdmin) throws ModelException{
        this.standardHandling(serviceAdmin);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
