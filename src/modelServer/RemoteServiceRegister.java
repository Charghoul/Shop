
package modelServer;


import persistence.*;

public  class RemoteServiceRegister extends RemoteService {

	
	public RemoteServiceRegister(String connectionName, String userName, PersistentServiceRegister server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> serviceRegister_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServiceRegister)this.server).serviceRegister_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> register(String username, String passwort){
        try {
            ((PersistentServiceRegister)this.server).register(username, passwort);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ExcUserAlreadyExists e0){
            return createExceptionResult(e0, this);
        }
    }
    


}