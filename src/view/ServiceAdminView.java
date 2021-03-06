package view;

import viewClient.*;

import view.visitor.*;

public interface ServiceAdminView extends ServiceShopView {
    
    public KundenManagerView getKundenManager()throws ModelException;
    public void setKundenManager(KundenManagerView newValue) throws ModelException ;
    public WarenlagerView getWarenlager()throws ModelException;
    public void setWarenlager(WarenlagerView newValue) throws ModelException ;
    public ArtikelManagerView getArtikelManager()throws ModelException;
    public void setArtikelManager(ArtikelManagerView newValue) throws ModelException ;
    public LieferartManagerView getLieferartManager()throws ModelException;
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException ;
    public HerstellerManagerView getHerstellerManager()throws ModelException;
    public void setHerstellerManager(HerstellerManagerView newValue) throws ModelException ;
    public ZeitManagerView getZeitManager()throws ModelException;
    public void setZeitManager(ZeitManagerView newValue) throws ModelException ;
    
    public void accept(ServiceShopVisitor visitor) throws ModelException;
    public <R> R accept(ServiceShopReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ServiceShopExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ServiceShopReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(ServiceVisitor visitor) throws ModelException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServiceAdminConnection connectServiceAdmin(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

