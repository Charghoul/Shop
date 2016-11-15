package persistence;



import model.visitor.*;

public class ArtikelManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentArtikelManager{
    
    public ArtikelManagerICProxi(long objectId) {
        super(objectId);
    }
    public ArtikelManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
            .getArtikelManager(this.getId());
    }
    
    public long getClassId() {
        return 228;
    }
    
    public ArtikelManager_KomponentenListeProxi getKomponentenListe() throws PersistenceException {
        return ((PersistentArtikelManager)this.getTheObject()).getKomponentenListe();
    }
    public PersistentArtikelManager getThis() throws PersistenceException {
        return ((PersistentArtikelManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikelManager(this);
    }
    
    
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).aendereArtikel(artikel, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ServiceAdmin4Public inverseGetArtikelManager() 
				throws PersistenceException{
        return ((PersistentArtikelManager)this.getTheObject()).inverseGetArtikelManager();
    }
    public void neueProduktgruppe(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neueProduktgruppe(name, invoker);
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, invoker);
    }
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).aendereArtikel(artikel, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neueProduktgruppe(final String name) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neueProduktgruppe(name);
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }

    
}
