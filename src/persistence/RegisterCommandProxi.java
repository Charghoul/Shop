package persistence;



import model.visitor.*;

public class RegisterCommandProxi extends PersistentProxi implements PersistentRegisterCommand{
    
    public RegisterCommandProxi(long objectId) {
        super(objectId);
    }
    public RegisterCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 200;
    }
    
    public String getUsername() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getUsername();
    }
    public void setUsername(String newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setUsername(newValue);
    }
    public String getPasswort() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getPasswort();
    }
    public void setPasswort(String newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setPasswort(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setInvoker(newValue);
    }
    public ServiceRegister4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(ServiceRegister4Public newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentRegisterCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRegisterCommand)this.getTheObject()).setCommitDate(newValue);
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
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentRegisterCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentRegisterCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentRegisterCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRegisterCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentRegisterCommand)this.getTheObject()).sendResult();
    }

    
}
