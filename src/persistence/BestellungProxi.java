package persistence;



import model.visitor.*;

public class BestellungProxi extends PersistentProxi implements PersistentBestellung{
    
    public BestellungProxi(long objectId) {
        super(objectId);
    }
    public BestellungProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 136;
    }
    
    public Bestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getPositionsListe();
    }
    public BestellManager4Public getBestellManager() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getBestellManager();
    }
    public void setBestellManager(BestellManager4Public newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setBestellManager(newValue);
    }
    public long getBestellID() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getBestellID();
    }
    public void setBestellID(long newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setBestellID(newValue);
    }
    public Bestellstatus4Public getBestellstatus() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getBestellstatus();
    }
    public void setBestellstatus(Bestellstatus4Public newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setBestellstatus(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBestellung)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBestellung)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBestellung(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBestellung(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBestellung(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBestellung(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).updateObservers(event);
    }
    public void aendereStatus(final Bestellstatus4Public bestellstatus) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).aendereStatus(bestellstatus);
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
    public void listeHinzufuegen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        ((PersistentBestellung)this.getTheObject()).listeHinzufuegen(positionsListe);
    }

    
}
