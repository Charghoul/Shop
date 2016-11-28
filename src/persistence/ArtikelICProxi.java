package persistence;



import model.visitor.*;

public class ArtikelICProxi extends KomponenteICProxi implements PersistentArtikel{
    
    public ArtikelICProxi(long objectId) {
        super(objectId);
    }
    public ArtikelICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .getArtikel(this.getId());
    }
    
    public long getClassId() {
        return 108;
    }
    
    public String getArtikelnummer() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getArtikelnummer();
    }
    public void setArtikelnummer(String newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setArtikelnummer(newValue);
    }
    public String getBezeichnung() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getBezeichnung();
    }
    public void setBezeichnung(String newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setBezeichnung(newValue);
    }
    public long getPreis() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getPreis();
    }
    public void setPreis(long newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setPreis(newValue);
    }
    public long getMinLagerbestand() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getMinLagerbestand();
    }
    public void setMinLagerbestand(long newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setMinLagerbestand(newValue);
    }
    public long getMaxLagerbestand() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getMaxLagerbestand();
    }
    public void setMaxLagerbestand(long newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setMaxLagerbestand(newValue);
    }
    public long getHstLieferzeit() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getHstLieferzeit();
    }
    public void setHstLieferzeit(long newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setHstLieferzeit(newValue);
    }
    public Artikelstatus4Public getArtikelstatus() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getArtikelstatus();
    }
    public void setArtikelstatus(Artikelstatus4Public newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setArtikelstatus(newValue);
    }
    public Hersteller4Public getHersteller() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getHersteller();
    }
    public void setHersteller(Hersteller4Public newValue) throws PersistenceException {
        ((PersistentArtikel)this.getTheObject()).setHersteller(newValue);
    }
    public PersistentArtikel getThis() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getThis();
    }
    
    public void accept(KomponenteVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(KomponenteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(KomponenteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(KomponenteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(HierarchieHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(HierarchieHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(HierarchieHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(HierarchieHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    
    
    public boolean containsHierarchie(final HierarchieHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentArtikel)this.getTheObject()).containsHierarchie(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ProduktgruppeSearchList inverseGetKomponentenListe() 
				throws PersistenceException{
        return ((PersistentArtikel)this.getTheObject()).inverseGetKomponentenListe();
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).register(observee);
    }
    public void statusAuslauf(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusAuslauf(invoker);
    }
    public void statusVerkauf(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusVerkauf(invoker);
    }
    public <T> T strategyHierarchie(final HierarchieHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentArtikel)this.getTheObject()).strategyHierarchie(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).updateObservers(event);
    }
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).zuEinkaufswHinz(menge, einkaufsManager, invoker);
    }
    public void aendereBezeichnung(final String bezeichnung) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereBezeichnung(bezeichnung);
    }
    public void aendereHstLieferzeit(final long hstLieferzeit) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereHstLieferzeit(hstLieferzeit);
    }
    public void aendereMaxLagerbestand(final long maxLagerbestand) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereMaxLagerbestand(maxLagerbestand);
    }
    public void aendereMinLagerbestand(final long minLagerbestand) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereMinLagerbestand(minLagerbestand);
    }
    public void aenderePreis(final long preis) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aenderePreis(preis);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void herstellerHinzufuegen(final Hersteller4Public hersteller) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).herstellerHinzufuegen(hersteller);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initializeOnInstantiation();
    }
    public void statusAuslauf() 
				throws model.ExcInconsistentStatusChange, PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusAuslauf();
    }
    public void statusVerkauf() 
				throws model.ExcInconsistentStatusChange, model.ExcArtikelHatKeinenHersteller, PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusVerkauf();
    }
    public void zuEinkaufswHinz(final long menge, final EinkaufsManager4Public einkaufsManager) 
				throws model.UserException, PersistenceException{
        ((PersistentArtikel)this.getTheObject()).zuEinkaufswHinz(menge, einkaufsManager);
    }

    
}
