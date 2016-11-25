package persistence;


import model.visitor.*;

public interface Bestellung4Public extends BestellungAbstrakt4Public {
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException ;
    public KndLieferung4Public getKndLieferung() throws PersistenceException ;
    public Bestellstatus4Public getBestellstatus() throws PersistenceException ;
    
    public void accept(BestellungAbstraktVisitor visitor) throws PersistenceException;
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void allesZuruecksenden(final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void aendereStatus(final Bestellstatus4Public bestellstatus) 
				throws PersistenceException;
    public void allesZuruecksenden() 
				throws PersistenceException;
    public void annehmen() 
				throws PersistenceException;
    public long berechneWarenwert() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void lieferungHinzufuegen(final KndLieferung4Public lieferung) 
				throws PersistenceException;

}

