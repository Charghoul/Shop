package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ArtikelProxi extends ViewProxi implements ArtikelView{
    
    public ArtikelProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ArtikelView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String artikelnummer = (String)resultTable.get("artikelnummer");
        String bezeichnung = (String)resultTable.get("bezeichnung");
        common.Fraction preis = common.Fraction.parse((String)resultTable.get("preis"));
        long minLagerbestand = new Long((String)resultTable.get("minLagerbestand")).longValue();
        long maxLagerbestand = new Long((String)resultTable.get("maxLagerbestand")).longValue();
        long hstLieferzeit = new Long((String)resultTable.get("hstLieferzeit")).longValue();
        ArtikelView result$$ = new Artikel((String)artikelnummer,(String)bezeichnung,(common.Fraction)preis,(long)minLagerbestand,(long)maxLagerbestand,(long)hstLieferzeit, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    public String getArtikelnummer()throws ModelException{
        return ((Artikel)this.getTheObject()).getArtikelnummer();
    }
    public void setArtikelnummer(String newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setArtikelnummer(newValue);
    }
    public String getBezeichnung()throws ModelException{
        return ((Artikel)this.getTheObject()).getBezeichnung();
    }
    public void setBezeichnung(String newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setBezeichnung(newValue);
    }
    public common.Fraction getPreis()throws ModelException{
        return ((Artikel)this.getTheObject()).getPreis();
    }
    public void setPreis(common.Fraction newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setPreis(newValue);
    }
    public long getMinLagerbestand()throws ModelException{
        return ((Artikel)this.getTheObject()).getMinLagerbestand();
    }
    public void setMinLagerbestand(long newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setMinLagerbestand(newValue);
    }
    public long getMaxLagerbestand()throws ModelException{
        return ((Artikel)this.getTheObject()).getMaxLagerbestand();
    }
    public void setMaxLagerbestand(long newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setMaxLagerbestand(newValue);
    }
    public long getHstLieferzeit()throws ModelException{
        return ((Artikel)this.getTheObject()).getHstLieferzeit();
    }
    public void setHstLieferzeit(long newValue) throws ModelException {
        ((Artikel)this.getTheObject()).setHstLieferzeit(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
