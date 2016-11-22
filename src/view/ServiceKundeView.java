package view;

import viewClient.*;

import view.visitor.*;

public interface ServiceKundeView extends ServiceShopView {
    
    public KontoView getKonto()throws ModelException;
    public void setKonto(KontoView newValue) throws ModelException ;
    public EinkaufsManagerView getEinkaufsManager()throws ModelException;
    public void setEinkaufsManager(EinkaufsManagerView newValue) throws ModelException ;
    public LieferartManagerView getLieferartManager()throws ModelException;
    public void setLieferartManager(LieferartManagerView newValue) throws ModelException ;
    public BestellManagerView getBestellManager()throws ModelException;
    public void setBestellManager(BestellManagerView newValue) throws ModelException ;
    
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
    
    public ServiceKundeConnection connectServiceKunde(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

