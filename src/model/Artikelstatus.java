
package model;

import model.visitor.AnythingVisitor;
import model.visitor.ArtikelstatusReturnExceptionVisitor;
import model.visitor.ArtikelstatusVisitor;
import persistence.*;


/* Additional import section end */

public abstract class Artikelstatus extends PersistentObject implements PersistentArtikelstatus{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Artikelstatus4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.getClass(objectId);
        return (Artikelstatus4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Artikelstatus provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentArtikelstatus This;
    
    public Artikelstatus(PersistentArtikelstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 152;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentArtikelstatus newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentArtikelstatus)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelstatusFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentArtikelstatus getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentArtikelstatus)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
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
        Artikelstatus4Public neuanlage = Neuanlage.createNeuanlage();
        //falls ich nicht weiß welcher typ neuanlage ist ->
        neuanlage.accept(new ArtikelstatusVisitor() {
                             @Override
                             public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException {

                             }

                             @Override
                             public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException {

                             }

                             @Override
                             public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException {

                             }
                         }
        );
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
