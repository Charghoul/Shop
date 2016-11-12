package persistence;



import model.visitor.*;

public class AuslaufICProxi extends ArtikelstatusICProxi implements PersistentAuslauf{
    
    public AuslaufICProxi(long objectId) {
        super(objectId);
    }
    public AuslaufICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAuslaufFacade
            .getAuslauf(this.getId());
    }
    
    public long getClassId() {
        return 213;
    }
    
    public PersistentAuslauf getThis() throws PersistenceException {
        return ((PersistentAuslauf)this.getTheObject()).getThis();
    }
    
    public void accept(ArtikelstatusVisitor visitor) throws PersistenceException {
        visitor.handleAuslauf(this);
    }
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAuslauf(this);
    }
    public <E extends model.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAuslauf(this);
    }
    public <R, E extends model.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAuslauf(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAuslauf(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAuslauf(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAuslauf(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAuslauf(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAuslauf)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAuslauf)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAuslauf)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAuslauf)this.getTheObject()).initializeOnInstantiation();
    }

    
}
