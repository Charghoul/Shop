
package model;

import model.visitor.*;
import persistence.*;


/* Additional import section end */

public class Neuanlage extends model.Artikelstatus implements PersistentNeuanlage{
    
    private static Neuanlage4Public theNeuanlage = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static Neuanlage4Public getTheNeuanlage() throws PersistenceException{
        if (theNeuanlage == null || reset$For$Test){
            if (reset$For$Test) theNeuanlage = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            Neuanlage4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theNeuanlageFacade.getTheNeuanlage();
                            theNeuanlage = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                Neuanlage4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theNeuanlage== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theNeuanlage;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theNeuanlage;
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
    
    public Neuanlage provideCopy() throws PersistenceException{
        Neuanlage result = this;
        result = new Neuanlage(this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Neuanlage(PersistentArtikelstatus This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentArtikelstatus)This,id);        
    }
    
    static public long getTypeId() {
        return 214;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNeuanlage getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNeuanlage result = (PersistentNeuanlage)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentNeuanlage)this.This;
    }
    
    public void accept(ArtikelstatusVisitor visitor) throws PersistenceException {
        visitor.handleNeuanlage(this);
    }
    public <R> R accept(ArtikelstatusReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNeuanlage(this);
    }
    public <E extends model.UserException>  void accept(ArtikelstatusExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNeuanlage(this);
    }
    public <R, E extends model.UserException> R accept(ArtikelstatusReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNeuanlage(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNeuanlage(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNeuanlage(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNeuanlage(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNeuanlage(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNeuanlage)This);
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
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
