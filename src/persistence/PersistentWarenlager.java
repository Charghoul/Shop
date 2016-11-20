package persistence;


public interface PersistentWarenlager extends Anything, SubjInterface, AbstractPersistentProxi, Warenlager4Public {
    
    public Warenlager_NewListProxi getNewList() throws PersistenceException ;
    public Warenlager_TemplistProxi getTemplist() throws PersistenceException ;
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentWarenlager getThis() throws PersistenceException ;
    
    

}

