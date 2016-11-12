
package model.visitor;

import persistence.*;

public abstract class ServiceRegisterCommandStandardVisitor implements ServiceRegisterCommandVisitor {
    
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException{
        this.standardHandling(registerCommand);
    }
    protected abstract void standardHandling(ServiceRegisterCommand serviceRegisterCommand) throws PersistenceException;
}
