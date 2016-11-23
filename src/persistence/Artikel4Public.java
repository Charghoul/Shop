package persistence;


import model.visitor.*;

public interface Artikel4Public extends Komponente4Public {
    
    public long getPreis() throws PersistenceException ;
    public long getMinLagerbestand() throws PersistenceException ;
    public long getMaxLagerbestand() throws PersistenceException ;
    public long getHstLieferzeit() throws PersistenceException ;
    public void setHstLieferzeit(long newValue) throws PersistenceException ;
    public Artikelstatus4Public getArtikelstatus() throws PersistenceException ;
    public Hersteller4Public getHersteller() throws PersistenceException ;
    
    public void accept(KomponenteVisitor visitor) throws PersistenceException;
    public <R> R accept(KomponenteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(KomponenteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(KomponenteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager, final Invoker invoker) 
				throws PersistenceException;
    public void aendereArtikel(final long preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void herstellerHinzufuegen(final Hersteller4Public hersteller) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void statusAuslauf() 
				throws model.ExcInconsistentStatusChange, PersistenceException;
    public void statusVerkauf() 
				throws model.ExcInconsistentStatusChange, model.ExcArtikelHatKeinenHersteller, PersistenceException;
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager) 
				throws model.UserException, PersistenceException;

}

