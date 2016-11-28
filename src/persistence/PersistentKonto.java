package persistence;


public interface PersistentKonto extends Anything, SubjInterface, AbstractPersistentProxi, Konto4Public {
    
    public void setKontostand(long newValue) throws PersistenceException ;
    public void setReserviert(long newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentKonto getThis() throws PersistenceException ;
    
    
    public ServiceKunde4Public getMyServiceKunde() 
				throws PersistenceException;

}

