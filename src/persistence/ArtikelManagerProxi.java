package persistence;



import model.visitor.*;

public class ArtikelManagerProxi extends PersistentProxi implements PersistentArtikelManager{
    
    public ArtikelManagerProxi(long objectId) {
        super(objectId);
    }
    public ArtikelManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 228;
    }
    
    public ArtikelManager_ArtikelListeProxi getArtikelListe() throws PersistenceException {
        return ((PersistentArtikelManager)this.getTheObject()).getArtikelListe();
    }
    public ArtikelManager_ProduktgruppenProxi getProduktgruppen() throws PersistenceException {
        return ((PersistentArtikelManager)this.getTheObject()).getProduktgruppen();
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
    public void herstellerHinzufuegen(final Artikel4Public artikel, final Hersteller4Public hersteller) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).herstellerHinzufuegen(artikel, hersteller);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }

    
}
