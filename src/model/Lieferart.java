
package model;

import model.visitor.*;
import persistence.*;
import serverConstants.ErrorMessages;


/* Additional import section end */

public class Lieferart extends PersistentObject implements PersistentLieferart{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Lieferart4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLieferartFacade.getClass(objectId);
        return (Lieferart4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Lieferart4Public createLieferart(String name,long lieferzeit,common.Fraction preis) throws PersistenceException{
        return createLieferart(name,lieferzeit,preis,false);
    }
    
    public static Lieferart4Public createLieferart(String name,long lieferzeit,common.Fraction preis,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentLieferart result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferartFacade
                .newDelayedLieferart(name,lieferzeit,preis);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferartFacade
                .newLieferart(name,lieferzeit,preis,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("lieferzeit", lieferzeit);
        final$$Fields.put("preis", preis);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Lieferart4Public createLieferart(String name,long lieferzeit,common.Fraction preis,boolean delayed$Persistence,Lieferart4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentLieferart result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLieferartFacade
                .newDelayedLieferart(name,lieferzeit,preis);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLieferartFacade
                .newLieferart(name,lieferzeit,preis,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("lieferzeit", lieferzeit);
        final$$Fields.put("preis", preis);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            result.put("lieferzeit", new Long(this.getLieferzeit()).toString());
            result.put("preis", this.getPreis().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static LieferartSearchList getLieferartByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theLieferartFacade
            .getLieferartByName(name);
    }
    
    public Lieferart provideCopy() throws PersistenceException{
        Lieferart result = this;
        result = new Lieferart(this.name, 
                               this.lieferzeit, 
                               this.preis, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected long lieferzeit;
    protected common.Fraction preis;
    protected PersistentLieferart This;
    
    public Lieferart(String name,long lieferzeit,common.Fraction preis,PersistentLieferart This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.lieferzeit = lieferzeit;
        this.preis = preis;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 138;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 138) ConnectionHandler.getTheConnectionHandler().theLieferartFacade
            .newLieferart(name,lieferzeit,preis,this.getId());
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theLieferartFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theLieferartFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public long getLieferzeit() throws PersistenceException {
        return this.lieferzeit;
    }
    public void setLieferzeit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theLieferartFacade.lieferzeitSet(this.getId(), newValue);
        this.lieferzeit = newValue;
    }
    public common.Fraction getPreis() throws PersistenceException {
        return this.preis;
    }
    public void setPreis(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theLieferartFacade.preisSet(this.getId(), newValue);
        this.preis = newValue;
    }
    protected void setThis(PersistentLieferart newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLieferart)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLieferartFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentLieferart getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLieferart result = (PersistentLieferart)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentLieferart)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferart(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferart(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferart(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLieferart)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setLieferzeit((Long)final$$Fields.get("lieferzeit"));
			this.setPreis((common.Fraction)final$$Fields.get("preis"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereLieferart(final String name, final long lieferzeit, final common.Fraction preis) 
				throws model.ExcAlreadyExists, PersistenceException{
        if(getThis().alreadyExists(name).equals(TrueX.getTheTrueX())){
            throw new ExcAlreadyExists(ErrorMessages.LieferArtAlreadyExists);
        }
        else {
            getThis().setName(name);
            getThis().setPreis(preis);
            getThis().setLieferzeit(lieferzeit);
        }
        
    }
    public BooleanX4Public alreadyExists(final String name) 
				throws PersistenceException{
        if(Lieferart.getLieferartByName(name).iterator().hasNext()){
            return TrueX.getTheTrueX();
        }
        else return FalseX.getTheFalseX();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{

        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
