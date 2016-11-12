
package model.visitor;

import persistence.*;

public interface ServiceRegisterCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException, E;
    
}
