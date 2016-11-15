package persistence;


import model.visitor.*;

public interface ServiceAdmin4Public extends Service4Public {
    
    
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
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public String serviceAdmin_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void aendereHersteller(final Hersteller4Public hersteller, final String name) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void artikelEinlagern(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException;
    public void artikelEntnehmen(final Warenlager4Public warenlager, final Position4Public position, final long menge) 
				throws PersistenceException;
    public void artikelHinzufuegen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void neueLieferArt(final LieferartManager4Public lieferartManager, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void neuerArtikel(final ArtikelManager4Public artikelManager, final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException;
    public void neuerHersteller(final HerstellerManager4Public herstellerManager, final String name) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void produktgruppeHinzufuegen(final Produktgruppe4Public produktgruppe, final String name) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException;
    public void statusAuslauf(final Artikel4Public artikel) 
				throws PersistenceException;
    public void statusVerkauf(final Artikel4Public artikel) 
				throws PersistenceException;

}

