
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Artikel extends PersistentObject implements PersistentArtikel{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Artikel4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theArtikelFacade.getClass(objectId);
        return (Artikel4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit) throws PersistenceException{
        return createArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,false);
    }
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,boolean delayed$Persistence) throws PersistenceException {
        if (artikelnummer == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (bezeichnung == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentArtikel result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newDelayedArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikelnummer", artikelnummer);
        final$$Fields.put("bezeichnung", bezeichnung);
        final$$Fields.put("preis", preis);
        final$$Fields.put("minLagerbestand", minLagerbestand);
        final$$Fields.put("maxLagerbestand", maxLagerbestand);
        final$$Fields.put("hstLieferzeit", hstLieferzeit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Artikel4Public createArtikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,boolean delayed$Persistence,Artikel4Public This) throws PersistenceException {
        if (artikelnummer == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (bezeichnung == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentArtikel result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newDelayedArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theArtikelFacade
                .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("artikelnummer", artikelnummer);
        final$$Fields.put("bezeichnung", bezeichnung);
        final$$Fields.put("preis", preis);
        final$$Fields.put("minLagerbestand", minLagerbestand);
        final$$Fields.put("maxLagerbestand", maxLagerbestand);
        final$$Fields.put("hstLieferzeit", hstLieferzeit);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("artikelnummer", this.getArtikelnummer());
            result.put("bezeichnung", this.getBezeichnung());
            result.put("preis", this.getPreis().toString());
            result.put("minLagerbestand", new Long(this.getMinLagerbestand()).toString());
            result.put("maxLagerbestand", new Long(this.getMaxLagerbestand()).toString());
            result.put("hstLieferzeit", new Long(this.getHstLieferzeit()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ArtikelSearchList getArtikelByArtikelnummer(String artikelnummer) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .getArtikelByArtikelnummer(artikelnummer);
    }
    
    public static ArtikelSearchList getArtikelByBezeichnung(String bezeichnung) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .getArtikelByBezeichnung(bezeichnung);
    }
    
    public Artikel provideCopy() throws PersistenceException{
        Artikel result = this;
        result = new Artikel(this.artikelnummer, 
                             this.bezeichnung, 
                             this.preis, 
                             this.minLagerbestand, 
                             this.maxLagerbestand, 
                             this.hstLieferzeit, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String artikelnummer;
    protected String bezeichnung;
    protected common.Fraction preis;
    protected long minLagerbestand;
    protected long maxLagerbestand;
    protected long hstLieferzeit;
    protected PersistentArtikel This;
    
    public Artikel(String artikelnummer,String bezeichnung,common.Fraction preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,PersistentArtikel This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.minLagerbestand = minLagerbestand;
        this.maxLagerbestand = maxLagerbestand;
        this.hstLieferzeit = hstLieferzeit;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 108) ConnectionHandler.getTheConnectionHandler().theArtikelFacade
            .newArtikel(artikelnummer,bezeichnung,preis,minLagerbestand,maxLagerbestand,hstLieferzeit,this.getId());
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getArtikelnummer() throws PersistenceException {
        return this.artikelnummer;
    }
    public void setArtikelnummer(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.artikelnummerSet(this.getId(), newValue);
        this.artikelnummer = newValue;
    }
    public String getBezeichnung() throws PersistenceException {
        return this.bezeichnung;
    }
    public void setBezeichnung(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.bezeichnungSet(this.getId(), newValue);
        this.bezeichnung = newValue;
    }
    public common.Fraction getPreis() throws PersistenceException {
        return this.preis;
    }
    public void setPreis(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.preisSet(this.getId(), newValue);
        this.preis = newValue;
    }
    public long getMinLagerbestand() throws PersistenceException {
        return this.minLagerbestand;
    }
    public void setMinLagerbestand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.minLagerbestandSet(this.getId(), newValue);
        this.minLagerbestand = newValue;
    }
    public long getMaxLagerbestand() throws PersistenceException {
        return this.maxLagerbestand;
    }
    public void setMaxLagerbestand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.maxLagerbestandSet(this.getId(), newValue);
        this.maxLagerbestand = newValue;
    }
    public long getHstLieferzeit() throws PersistenceException {
        return this.hstLieferzeit;
    }
    public void setHstLieferzeit(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theArtikelFacade.hstLieferzeitSet(this.getId(), newValue);
        this.hstLieferzeit = newValue;
    }
    protected void setThis(PersistentArtikel newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentArtikel)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theArtikelFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentArtikel getThis() throws PersistenceException {
        if(this.This == null){
            PersistentArtikel result = (PersistentArtikel)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentArtikel)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleArtikel(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleArtikel(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentArtikel)This);
		if(this.isTheSameAs(This)){
			this.setArtikelnummer((String)final$$Fields.get("artikelnummer"));
			this.setBezeichnung((String)final$$Fields.get("bezeichnung"));
			this.setPreis((common.Fraction)final$$Fields.get("preis"));
			this.setMinLagerbestand((Long)final$$Fields.get("minLagerbestand"));
			this.setMaxLagerbestand((Long)final$$Fields.get("maxLagerbestand"));
			this.setHstLieferzeit((Long)final$$Fields.get("hstLieferzeit"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void aendereArtikel(final String bezeichnung, final common.Fraction preis, final long minLagerbestand, final long maxLagerbestand, final long hstLieferzeit) 
				throws PersistenceException{
        setBezeichnung(bezeichnung);
        setPreis(preis);
        setMinLagerbestand(minLagerbestand);
        setMaxLagerbestand(maxLagerbestand);
        setHstLieferzeit(hstLieferzeit);
        
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
