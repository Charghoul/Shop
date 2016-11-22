package persistence;


import model.visitor.*;

public interface ServiceAdmin4Public extends ServiceShop4Public {
    
    
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
    
    public ArtikelManager4Public artikel_Path_In_ArtikelAnhaengen() 
				throws model.UserException, PersistenceException;
    public ArtikelManager4Public artikel_Path_In_ArtikelEinlagern() 
				throws model.UserException, PersistenceException;
    public ArtikelManager4Public artikel_Path_In_ArtikelEntnehmen() 
				throws model.UserException, PersistenceException;
    public HerstellerManager4Public hersteller_Path_In_HerstellerHinzufuegen() 
				throws model.UserException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public Warenlager4Public position_Path_In_ArtikelEntfernen() 
				throws model.UserException, PersistenceException;
    public String serviceAdmin_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void aendereAnnahmezeit(final ZeitManager4Public zeitManager, final long neueZeit) 
				throws PersistenceException;
    public void aendereArtikel(final Artikel4Public artikel, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void aendereHersteller(final Hersteller4Public hersteller, final String name) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void aendereHstLieferzeit(final Artikel4Public artikel, final long hstLieferzeit) 
				throws PersistenceException;
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void aendereMaxAnlieferungsVersuche(final ZeitManager4Public zeitManager, final long maxAnlieferungsVersuche) 
				throws PersistenceException;
    public void aendereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, model.ExcLagerbestandOverMax, PersistenceException;
    public void aendereRueckversandGebuehr(final LieferartManager4Public lieferartManager, final long percent) 
				throws PersistenceException;
    public void artikelAbhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws PersistenceException;
    public void artikelAnhaengen(final Produktgruppe4Public produktgruppe, final Artikel4Public artikel) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException;
    public void artikelEinlagern(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException;
    public void artikelEntfernen(final Warenlager4Public warenlager, final Position4Public position) 
				throws PersistenceException;
    public void artikelEntnehmen(final Warenlager4Public warenlager, final Artikel4Public artikel, final long menge) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void erhoeheMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException;
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void neueLieferArt(final LieferartManager4Public lieferartManager, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void neuerArtikel(final ArtikelManager4Public artikelManager, final String artikelnummer, final String bezeichnung, final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException;
    public void neuerHersteller(final HerstellerManager4Public herstellerManager, final String name) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void produktgruppeEntfernen(final Produktgruppe4Public produktgruppe) 
				throws PersistenceException;
    public void produktgruppeHinzufuegen(final Produktgruppe4Public produktgruppe, final String name) 
				throws model.ExcAlreadyExists, model.CycleException, PersistenceException;
    public void statusAuslauf(final Artikel4Public artikel) 
				throws PersistenceException;
    public void statusVerkauf(final Artikel4Public artikel) 
				throws PersistenceException;
    public void verringereMenge(final Position4Public position, final long menge) 
				throws model.ExcLagerbestandUnderZero, PersistenceException;

}

