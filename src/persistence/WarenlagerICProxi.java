package persistence;



import model.visitor.*;

public class WarenlagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentWarenlager{
    
    public WarenlagerICProxi(long objectId) {
        super(objectId);
    }
    public WarenlagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade
            .getWarenlager(this.getId());
    }
    
    public long getClassId() {
        return 139;
    }
    
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException {
        return ((PersistentWarenlager)this.getTheObject()).getWarenListe();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentWarenlager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentWarenlager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentWarenlager getThis() throws PersistenceException {
        return ((PersistentWarenlager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWarenlager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWarenlager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWarenlager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWarenlager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWarenlager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWarenlager(this);
    }
    
    
    public void artikelEinlagern(final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEinlagern(artikel, menge);
    }
    public void artikelEinlagern(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEinlagern(artikel, menge, invoker);
    }
    public void artikelEntfernen(final Position4Public position, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEntfernen(position, invoker);
    }
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEntnehmen(artikel, menge, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).updateObservers(event);
    }
    public void artikelEinlagernImplementation(final Artikel4Public artikel, final long menge) 
				throws model.ExcLagerbestandOverMax, PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEinlagernImplementation(artikel, menge);
    }
    public void artikelEntfernen(final Position4Public position) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEntfernen(position);
    }
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelHatKeinenHersteller, model.ExcLagerbestandUnderZero, PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEntnehmen(artikel, menge);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).initializeOnInstantiation();
    }
    public void nachbestellen(final Artikel4Public artikel, final long menge) 
				throws model.ExcArtikelHatKeinenHersteller, PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).nachbestellen(artikel, menge);
    }
    public Position4Public nichtVerfPruefen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        return ((PersistentWarenlager)this.getTheObject()).nichtVerfPruefen(positionsListe);
    }

    
}
