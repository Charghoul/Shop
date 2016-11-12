package view;

import view.objects.*;

import view.visitor.*;

public interface ArtikelView extends Anything, AbstractViewRoot {
    
    public String getArtikelnummer()throws ModelException;
    public void setArtikelnummer(String newValue) throws ModelException ;
    public String getBezeichnung()throws ModelException;
    public void setBezeichnung(String newValue) throws ModelException ;
    public common.Fraction getPreis()throws ModelException;
    public void setPreis(common.Fraction newValue) throws ModelException ;
    public long getMinLagerbestand()throws ModelException;
    public void setMinLagerbestand(long newValue) throws ModelException ;
    public long getMaxLagerbestand()throws ModelException;
    public void setMaxLagerbestand(long newValue) throws ModelException ;
    public long getHstLieferzeit()throws ModelException;
    public void setHstLieferzeit(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

