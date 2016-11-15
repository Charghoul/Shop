package persistence;


import model.visitor.*;

public interface Artikel4Public extends Komponente4Public {
    
    
    public void accept(KomponenteVisitor visitor) throws PersistenceException;
    public <R> R accept(KomponenteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(KomponenteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(KomponenteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(HierarchieHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(HierarchieHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(HierarchieHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(HierarchieHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsHierarchie(final HierarchieHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void statusAuslauf(final Invoker invoker) 
				throws PersistenceException;
    public void statusVerkauf(final Invoker invoker) 
				throws PersistenceException;
    public <T> T strategyHierarchie(final HierarchieHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void aendereArtikel(final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException;
    public BooleanX4Public alreadyExists(final String bezeichung) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public BooleanX4Public groesserMax(final long menge) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void statusAuslauf() 
				throws model.ExcInconsistentStatusChange, PersistenceException;
    public void statusVerkauf() 
				throws model.ExcInconsistentStatusChange, PersistenceException;

}

