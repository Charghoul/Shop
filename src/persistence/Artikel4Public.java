package persistence;


import model.visitor.*;

public interface Artikel4Public extends Anything, AbstractPersistentProxi {
    
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void statusAuslauf(final Invoker invoker) 
				throws PersistenceException;
    public void statusVerkauf(final Invoker invoker) 
				throws PersistenceException;
    public void aendereArtikel(final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void statusAuslauf() 
				throws PersistenceException;
    public void statusVerkauf() 
				throws PersistenceException;

}

