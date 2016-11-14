package persistence;



import model.visitor.*;

public class ArtikelProxi extends PersistentProxi implements PersistentArtikel{
    
    public ArtikelProxi(long objectId) {
        super(objectId);
    }
    public ArtikelProxi(PersistentInCacheProxi object) {
        super(object);
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
    public void aendereArtikel(final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereArtikel(bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
    }
    public void aendereStatus(final Artikelstatus4Public artikelstatus) 
				throws model.ExcStatusDidNotChange, PersistenceException{
        ((PersistentArtikel)this.getTheObject()).aendereStatus(artikelstatus);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentArtikel)this.getTheObject()).initializeOnInstantiation();
    }

    
}
