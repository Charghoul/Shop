package persistence;



import model.visitor.*;

public class ArtikelICProxi extends PersistentInCacheProxiOptimistic implements PersistentArtikel{
    
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
    public common.Fraction getPreis() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getPreis();
    }
    public void setPreis(common.Fraction newValue) throws PersistenceException {
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
    public PersistentArtikel getThis() throws PersistenceException {
        return ((PersistentArtikel)this.getTheObject()).getThis();
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
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void statusAuslauf(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusAuslauf(invoker);
    }
    public void statusVerkauf(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusVerkauf(invoker);
    }
    public void aendereArtikel(final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereArtikel(bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public BooleanX4Public groesserMax(final long menge) 
				throws PersistenceException{
        return ((PersistentArtikel)this.getTheObject()).groesserMax(menge);
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
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusAuslauf();
    }
    public void statusVerkauf() 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).statusVerkauf();
    }

    
}
