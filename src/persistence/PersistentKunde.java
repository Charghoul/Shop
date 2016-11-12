package persistence;


public interface PersistentKunde extends Anything, AbstractPersistentProxi, Kunde4Public {
    
    public String getBenutzername() throws PersistenceException ;
    public void setBenutzername(String newValue) throws PersistenceException ;
    public String getPasswort() throws PersistenceException ;
    public void setPasswort(String newValue) throws PersistenceException ;
    public void setKonto(Konto4Public newValue) throws PersistenceException ;
    public PersistentKunde getThis() throws PersistenceException ;
    
    

}

