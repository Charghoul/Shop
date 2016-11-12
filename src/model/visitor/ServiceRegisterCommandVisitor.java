
package model.visitor;

import persistence.*;

public interface ServiceRegisterCommandVisitor {
    
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    
}
