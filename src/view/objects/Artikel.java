
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Artikel extends view.objects.Komponente implements ArtikelView{
    
    protected String artikelnummer;
    protected String bezeichnung;
    protected long preis;
    protected long minLagerbestand;
    protected long maxLagerbestand;
    protected long hstLieferzeit;
    protected ArtikelstatusView artikelstatus;
    protected HerstellerView hersteller;
    
    public Artikel(String artikelnummer,String bezeichnung,long preis,long minLagerbestand,long maxLagerbestand,long hstLieferzeit,ArtikelstatusView artikelstatus,HerstellerView hersteller,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.minLagerbestand = minLagerbestand;
        this.maxLagerbestand = maxLagerbestand;
        this.hstLieferzeit = hstLieferzeit;
        this.artikelstatus = artikelstatus;
        this.hersteller = hersteller;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getArtikelnummer()throws ModelException{
        return this.artikelnummer;
    }
    public void setArtikelnummer(String newValue) throws ModelException {
        this.artikelnummer = newValue;
    }
    public String getBezeichnung()throws ModelException{
        return this.bezeichnung;
    }
    public void setBezeichnung(String newValue) throws ModelException {
        this.bezeichnung = newValue;
    }
    public long getPreis()throws ModelException{
        return this.preis;
    }
    public void setPreis(long newValue) throws ModelException {
        this.preis = newValue;
    }
    public long getMinLagerbestand()throws ModelException{
        return this.minLagerbestand;
    }
    public void setMinLagerbestand(long newValue) throws ModelException {
        this.minLagerbestand = newValue;
    }
    public long getMaxLagerbestand()throws ModelException{
        return this.maxLagerbestand;
    }
    public void setMaxLagerbestand(long newValue) throws ModelException {
        this.maxLagerbestand = newValue;
    }
    public long getHstLieferzeit()throws ModelException{
        return this.hstLieferzeit;
    }
    public void setHstLieferzeit(long newValue) throws ModelException {
        this.hstLieferzeit = newValue;
    }
    public ArtikelstatusView getArtikelstatus()throws ModelException{
        return this.artikelstatus;
    }
    public void setArtikelstatus(ArtikelstatusView newValue) throws ModelException {
        this.artikelstatus = newValue;
    }
    public HerstellerView getHersteller()throws ModelException{
        return this.hersteller;
    }
    public void setHersteller(HerstellerView newValue) throws ModelException {
        this.hersteller = newValue;
    }
    
    public void accept(KomponenteVisitor visitor) throws ModelException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(KomponenteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleArtikel(this);
    }
    public <E extends view.UserException>  void accept(KomponenteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends view.UserException> R accept(KomponenteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleArtikel(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleArtikel(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleArtikel(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleArtikel(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleArtikel(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ArtikelstatusView artikelstatus = this.getArtikelstatus();
        if (artikelstatus != null) {
            ((ViewProxi)artikelstatus).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(artikelstatus.getClassId(), artikelstatus.getId())));
        }
        HerstellerView hersteller = this.getHersteller();
        if (hersteller != null) {
            ((ViewProxi)hersteller).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(hersteller.getClassId(), hersteller.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getArtikelstatus() != null && index < this.getArtikelstatus().getTheObject().getChildCount())
            return this.getArtikelstatus().getTheObject().getChild(index);
        if(this.getArtikelstatus() != null) index = index - this.getArtikelstatus().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getArtikelstatus() == null ? 0 : this.getArtikelstatus().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getArtikelstatus() == null ? true : this.getArtikelstatus().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getArtikelstatus() != null && this.getArtikelstatus().equals(child)) return result;
        if(this.getArtikelstatus() != null) result = result + 1;
        return -1;
    }
    public int getArtikelnummerIndex() throws ModelException {
        return 0;
    }
    public int getBezeichnungIndex() throws ModelException {
        return 0 + 1;
    }
    public int getPreisIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getMinLagerbestandIndex() throws ModelException {
        return 0 + 1 + 1 + 1;
    }
    public int getMaxLagerbestandIndex() throws ModelException {
        return 0 + 1 + 1 + 1 + 1;
    }
    public int getHstLieferzeitIndex() throws ModelException {
        return 0 + 1 + 1 + 1 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "artikelnummer";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "bezeichnung";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "preis";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "minLagerbestand";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "maxLagerbestand";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "hstLieferzeit";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getArtikelnummer();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getBezeichnung();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getPreis());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getMinLagerbestand());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getMaxLagerbestand());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getHstLieferzeit());
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setArtikelnummer(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setBezeichnung(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setPreis(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setMinLagerbestand(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setMaxLagerbestand(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setHstLieferzeit(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
