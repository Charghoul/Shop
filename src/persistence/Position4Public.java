package persistence;


import model.visitor.*;

public interface Position4Public extends Anything, AbstractPersistentProxi {
    
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void aendereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public Position4Public enthaeltArtikel(final Artikel4Public artikel) 
				throws PersistenceException;
    public void erhoeheMenge(final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void verringereMenge(final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException;

}

