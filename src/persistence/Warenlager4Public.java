package persistence;


import model.visitor.*;

public interface Warenlager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void artikelEinlagern(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException;
    public void artikelEntfernen(final Position4Public position, final Invoker invoker) 
				throws PersistenceException;
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void artikelEinlagern(final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException;
    public void artikelEntfernen(final Position4Public position) 
				throws PersistenceException;
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelHatKeinenHersteller, model.ExcLagerbestandUnderZero, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void nachbestellen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException;
    public Position4Public nichtVerfPruefen(final PositionSearchList positionsListe) 
				throws PersistenceException;

}

