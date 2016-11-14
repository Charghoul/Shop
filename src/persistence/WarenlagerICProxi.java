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
        return 193;
    }
    
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException {
        return ((PersistentWarenlager)this.getTheObject()).getWarenListe();
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
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void artikelEinlagern(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
        ((PersistentWarenlager)this.getTheObject()).artikelEinlagern(artikel, menge);
    }
    public void artikelEntnehmen(final Artikel4Public artikel, final long menge) 
				throws PersistenceException{
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

    
}
