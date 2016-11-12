
package model;

import persistence.*;
import model.visitor.*;
import serverConstants.ErrorMessages;

import java.sql.Timestamp;


/* Additional import section end */

public class ServiceRegister extends model.Service implements PersistentServiceRegister{
    
    
    public static ServiceRegister4Public createServiceRegister() throws PersistenceException{
        return createServiceRegister(false);
    }
    
    public static ServiceRegister4Public createServiceRegister(boolean delayed$Persistence) throws PersistenceException {
        PersistentServiceRegister result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceRegisterFacade
                .newDelayedServiceRegister();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceRegisterFacade
                .newServiceRegister(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ServiceRegister4Public createServiceRegister(boolean delayed$Persistence,ServiceRegister4Public This) throws PersistenceException {
        PersistentServiceRegister result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServiceRegisterFacade
                .newDelayedServiceRegister();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServiceRegisterFacade
                .newServiceRegister(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ServiceRegister provideCopy() throws PersistenceException{
        ServiceRegister result = this;
        result = new ServiceRegister(this.This, 
                                     this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ServiceRegister(PersistentService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);        
    }
    
    static public long getTypeId() {
        return -189;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -189) ConnectionHandler.getTheConnectionHandler().theServiceRegisterFacade
            .newServiceRegister(this.getId());
        super.store();
        
    }
    
    public PersistentServiceRegister getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServiceRegister result = (PersistentServiceRegister)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServiceRegister)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleServiceRegister(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceRegister(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceRegister(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceRegister(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServiceRegister(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceRegister(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceRegister(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceRegister(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServiceRegister(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceRegister(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceRegister(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceRegister(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServiceRegister(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServiceRegister(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServiceRegister(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServiceRegister(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServiceRegister)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void register(final String username, final String passwort, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		RegisterCommand4Public command = model.meta.RegisterCommand.createRegisterCommand(username, passwort, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public String serviceRegister_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void connected(final String user) 
				throws PersistenceException{
        //TODO: implement method: connected
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void disconnected() 
				throws PersistenceException{
        //TODO: implement method: disconnected
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    public void register(final String username, final String passwort) 
				throws model.ExcUserAlreadyExists, PersistenceException{
        KundeSearchList kundeSearchList = Kunde.getKundeByBenutzername(username);
        if( kundeSearchList.iterator().hasNext() ) {
            throw new ExcUserAlreadyExists(ErrorMessages.AccountNotFoundMessage);
        }
        Kunde.createKunde(username, passwort);
        Server.createServer(passwort,username, 3, new Timestamp(0));
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{

    }
    public void handleResult(final Command command) 
				throws PersistenceException{

    }
    public boolean hasChanged() 
				throws PersistenceException{
        return false;
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
