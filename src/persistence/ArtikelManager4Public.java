package persistence;


import model.visitor.*;

public interface ArtikelManager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException;

}

