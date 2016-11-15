package persistence;



import model.visitor.*;

public class LieferartManagerProxi extends PersistentProxi implements PersistentLieferartManager{
    
    public LieferartManagerProxi(long objectId) {
        super(objectId);
    }
    public LieferartManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 198;
    }
    
    public LieferartManager_LieferartenListeProxi getLieferartenListe() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getLieferartenListe();
    }
    public PersistentLieferartManager getThis() throws PersistenceException {
        return ((PersistentLieferartManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferartManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferartManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferartManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferartManager(this);
    }
    
    
    public ServiceAdmin4Public getMyService() 
				throws PersistenceException{
        return ((PersistentLieferartManager)this.getTheObject()).getMyService();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void aendereLieferart(final Lieferart4Public lieferart, final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).aendereLieferart(lieferart, name, lieferzeit, preis);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void neueLieferart(final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        ((PersistentLieferartManager)this.getTheObject()).neueLieferart(name, lieferzeit, preis);
    }

    
}
