package view;

import view.objects.*;

import view.visitor.*;

public interface ArtikelManagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<ArtikelView> getArtikelListe()throws ModelException;
    public void setArtikelListe(java.util.Vector<ArtikelView> newValue) throws ModelException ;
    public java.util.Vector<ProduktgruppeView> getProduktgruppen()throws ModelException;
    public void setProduktgruppen(java.util.Vector<ProduktgruppeView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

