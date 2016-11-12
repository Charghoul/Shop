
package model.visitor;

import persistence.*;

public interface ServiceRegisterCommandReturnVisitor<R> {
    
    public R handleRegisterCommand(RegisterCommand4Public registerCommand) throws PersistenceException;
    
}
