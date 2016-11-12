
package model.visitor;

import persistence.*;

public abstract class ServiceRegister$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleServiceRegister(PersistentServiceRegister serviceRegister) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
