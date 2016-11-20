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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentArtikelManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentArtikelManager)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikelManager(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).neuerArtikel(artikelnummer, bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit, invoker);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentArtikelManager)this.getTheObject()).updateObservers(event);
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
