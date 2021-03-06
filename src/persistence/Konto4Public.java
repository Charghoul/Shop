package persistence;


import model.visitor.*;

public interface Konto4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public long getKontostand() throws PersistenceException ;
    public long getLimit() throws PersistenceException ;
    public void setLimit(long newValue) throws PersistenceException ;
    public long getReserviert() throws PersistenceException ;
    
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
    public void abbuchen(final long betrag) 
				throws PersistenceException;
    public void aendereLimit(final long limit) 
				throws PersistenceException;
    public void auszahlen(final long betrag) 
				throws model.ExcAuszahlungGroesserGutgaben, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void einzahlen(final long betrag) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void reserviere(final long betrag) 
				throws PersistenceException;
    public void verringereReserviert(final long betrag) 
				throws PersistenceException;

}

