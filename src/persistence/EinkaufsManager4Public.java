package persistence;


import model.visitor.*;

public interface EinkaufsManager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void bestellen(final Lieferart4Public lieferart, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void bestellen(final Lieferart4Public lieferart) 
				throws model.ExcWarenwertUeberKontoguthaben, model.ExcArtikelNichtVerfuegbar, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException;
    public long gibGesamtPreis() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void neuePosition(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelAlreadyExists, model.UserException, model.ExcLagerbestandOverMax, PersistenceException;
    public void vorbestellen() 
				throws PersistenceException;

}

