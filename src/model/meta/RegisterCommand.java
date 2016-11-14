
package model.meta;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class RegisterCommand extends PersistentObject implements PersistentRegisterCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static RegisterCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.getClass(objectId);
        return (RegisterCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static RegisterCommand4Public createRegisterCommand(String username,String passwort,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createRegisterCommand(username,passwort,createDate,commitDate,false);
    }
    
    public static RegisterCommand4Public createRegisterCommand(String username,String passwort,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (username == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (passwort == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentRegisterCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade
                .newDelayedRegisterCommand(username,passwort);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade
                .newRegisterCommand(username,passwort,-1);
        }
        ((PersistentRegisterCommand)result).setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String username;
    protected String passwort;
    protected Invoker invoker;
    protected PersistentServiceRegister commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public RegisterCommand(String username,String passwort,Invoker invoker,PersistentServiceRegister commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.username = username;
        this.passwort = passwort;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 200;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 200) ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade
            .newRegisterCommand(username,passwort,this.getId());
        super.store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getUsername() throws PersistenceException {
        return this.username;
    }
    public void setUsername(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.usernameSet(this.getId(), newValue);
        this.username = newValue;
    }
    public String getPasswort() throws PersistenceException {
        return this.passwort;
    }
    public void setPasswort(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.passwortSet(this.getId(), newValue);
        this.passwort = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public ServiceRegister4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(ServiceRegister4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentServiceRegister)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRegisterCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleRegisterCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegisterCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegisterCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegisterCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRegisterCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegisterCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegisterCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegisterCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRegisterCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegisterCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegisterCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegisterCommand(this);
    }
    public void accept(ServiceRegisterCommandVisitor visitor) throws PersistenceException {
        visitor.handleRegisterCommand(this);
    }
    public <R> R accept(ServiceRegisterCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegisterCommand(this);
    }
    public <E extends model.UserException>  void accept(ServiceRegisterCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegisterCommand(this);
    }
    public <R, E extends model.UserException> R accept(ServiceRegisterCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegisterCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.commandReceiver.register(this.getUsername(), this.getPasswort());
		}
		catch(model.ExcUserAlreadyExists e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
