package persistence;


public interface PersistentKonto extends Anything, SubjInterface, AbstractPersistentProxi, Konto4Public {
    
    public common.Fraction getKontostand() throws PersistenceException ;
    public void setKontostand(common.Fraction newValue) throws PersistenceException ;
    public common.Fraction getLimit() throws PersistenceException ;
    public void setLimit(common.Fraction newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentKonto getThis() throws PersistenceException ;
    
    

}

