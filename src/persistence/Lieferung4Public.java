package persistence;


import model.visitor.*;

public interface Lieferung4Public extends ZeitObjekt4Public {
    
    
    public void accept(LieferungVisitor visitor) throws PersistenceException;
    public <R> R accept(LieferungReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LieferungExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LieferungReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

