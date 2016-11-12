package persistence;



import model.visitor.*;

public class BestellungICProxi extends PersistentInCacheProxiOptimistic implements PersistentBestellung{
    
    public BestellungICProxi(long objectId) {
        super(objectId);
    }
    public BestellungICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            .getBestellung(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getPositionsListe();
    }
    public String getID() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getID();
    }
    public void setID(String newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setID(newValue);
    }
    public Bestellstatus4Public getBestellstatus() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getBestellstatus();
    }
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setBestellstatus(newValue);
    }
    public PersistentBestellung getThis() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).initializeOnInstantiation();
    }

    
}
