package persistence;



import model.visitor.*;

public class VorbestellungICProxi extends BestellungAbstraktICProxi implements PersistentVorbestellung{
    
    public VorbestellungICProxi(long objectId) {
        super(objectId);
    }
    public VorbestellungICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theVorbestellungFacade
            .getVorbestellung(this.getId());
    }
    
    public long getClassId() {
        return 166;
    }
    
    public Vorbestellung_PositionsListeProxi getPositionsListe() throws PersistenceException {
        return ((PersistentVorbestellung)this.getTheObject()).getPositionsListe();
    }
    public PersistentVorbestellung getThis() throws PersistenceException {
        return ((PersistentVorbestellung)this.getTheObject()).getThis();
    }
    
    public void accept(BestellungAbstraktVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(BestellungAbstraktReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(BestellungAbstraktExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(BestellungAbstraktReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleVorbestellung(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleVorbestellung(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleVorbestellung(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleVorbestellung(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).initializeOnInstantiation();
    }
    public void listeHinzufuegen(final PositionSearchList positionsListe) 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).listeHinzufuegen(positionsListe);
    }
    public void stornieren() 
				throws PersistenceException{
        ((PersistentVorbestellung)this.getTheObject()).stornieren();
    }

    
}
