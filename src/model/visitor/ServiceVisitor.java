
package model.visitor;

import persistence.*;

public interface ServiceVisitor {
    
    public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException;
    public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException;
    public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException;
    
}
