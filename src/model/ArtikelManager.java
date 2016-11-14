
package model;

import common.Fraction;
import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ArtikelManager extends PersistentObject implements PersistentArtikelManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ArtikelManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.getClass(objectId);
        return (ArtikelManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ArtikelManager4Public createArtikelManager() throws PersistenceException{
        return createArtikelManager(false);
    }
    
    public static ArtikelManager4Public createArtikelManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentArtikelManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
                .newDelayedArtikelManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
                .newArtikelManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ArtikelManager4Public createArtikelManager(boolean delayed$Persistence,ArtikelManager4Public This) throws PersistenceException {
        PersistentArtikelManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
                .newDelayedArtikelManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
                .newArtikelManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("artikelListe", this.getArtikelListe().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ArtikelManager provideCopy() throws PersistenceException{
        ArtikelManager result = this;
        result = new ArtikelManager(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ArtikelManager_ArtikelListeProxi artikelListe;
    protected PersistentArtikelManager This;
    
    public ArtikelManager(PersistentArtikelManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.artikelListe = new ArtikelManager_ArtikelListeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 228) ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
            .newArtikelManager(this.getId());
        super.store();
        this.getArtikelListe().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ArtikelManager_ArtikelListeProxi getArtikelListe() throws PersistenceException {
        return this.artikelListe;
    }
    protected void setThis(PersistentArtikelManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentArtikelManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentArtikelManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentArtikelManager result = (PersistentArtikelManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentArtikelManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikelManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikelManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikelManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikelManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArtikelListe().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentArtikelManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public ServiceAdmin4Public inverseGetArtikelManager() 
				throws PersistenceException{
        ServiceAdminSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServiceAdminFacade
										.inverseGetArtikelManager(getThis().getId(), getThis().getClassId());
		try {
			return result.iterator().next();
		} catch (java.util.NoSuchElementException nsee){
			return null;
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereArtikel(final Artikel4Public artikel, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        artikel.aendereArtikel(bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit);
        
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().getArtikelListe().add(Artikel.createArtikel("1234","test", Fraction.parse("5"),10,100,3));
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void neuerArtikel(final String artikelnummer, final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws model.UserException, PersistenceException{
        ArtikelSearchList artikelSearchList = Artikel.getArtikelByArtikelnummer(artikelnummer);
        if( artikelSearchList.iterator().hasNext()){
            throw new ExcArtikelAlreadyExists(serverConstants.ErrorMessages.ArtikelAlreadyExists);
        }
        ;
        getThis().getArtikelListe().add(Artikel.createArtikel(artikelnummer,
                bezeichnung, preis, minLagerbestand, maxLagerbestand, hstLieferzeit));
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
