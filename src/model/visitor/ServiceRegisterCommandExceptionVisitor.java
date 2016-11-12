
package model.visitor;

import persistence.*;

public interface ServiceRegisterCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    
}
