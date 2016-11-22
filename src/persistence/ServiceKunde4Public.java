package persistence;


import model.visitor.*;

public interface ServiceKunde4Public extends ServiceShop4Public {
    
    public Konto4Public getKonto() throws PersistenceException ;
    
    public void accept(ServiceShopVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public ProduktKatalog4Public artikel_Path_In_NeuePosition() 
				throws model.UserException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public LieferartManager4Public lieferart_Path_In_Bestellen() 
				throws model.UserException, PersistenceException;
    public String serviceKunde_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException;
    public void annehmen(final Bestellung4Public bestellung) 
				throws PersistenceException;
    public void auszahlen(final Konto4Public konto, final long betrag) 
				throws model.ExcAuszahlungGroesserGutgaben, PersistenceException;
    public void bestellen(final EinkaufsManager4Public einkaufsManager, final Lieferart4Public lieferart) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void einzahlen(final Konto4Public konto, final long betrag) 
				throws PersistenceException;
    public void entfernePosition(final Position4Public position) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void neuePosition(final EinkaufsManager4Public einkaufsManager, final Artikel4Public artikel, final long menge) 
				throws model.UserException, PersistenceException;
    public void vorbestellen(final EinkaufsManager4Public einkaufsManager) 
				throws PersistenceException;
    public void zuEinkaufswagenHinzufuegen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException;
    public void zuruecksenden(final PositionInBestellung4Public position) 
				throws PersistenceException;

}

