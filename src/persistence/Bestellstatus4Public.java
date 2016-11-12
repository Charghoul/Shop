package persistence;


import model.visitor.*;

public interface Bestellstatus4Public extends Anything, AbstractPersistentProxi {
    
    
    public void accept(BestellstatusVisitor visitor) throws PersistenceException;
    public <R> R accept(BestellstatusReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BestellstatusExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BestellstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

