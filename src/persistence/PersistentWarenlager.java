package persistence;


public interface PersistentWarenlager extends Anything, AbstractPersistentProxi, Warenlager4Public {
    
    public Warenlager_WarenListeProxi getWarenListe() throws PersistenceException ;
    public PersistentWarenlager getThis() throws PersistenceException ;
    
    

}

