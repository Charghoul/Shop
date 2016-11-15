package persistence;


public interface PersistentArtikel extends PersistentKomponente, Artikel4Public {
    
    public String getArtikelnummer() throws PersistenceException ;
    public void setArtikelnummer(String newValue) throws PersistenceException ;
    public String getBezeichnung() throws PersistenceException ;
    public void setBezeichnung(String newValue) throws PersistenceException ;
    public common.Fraction getPreis() throws PersistenceException ;
    public void setPreis(common.Fraction newValue) throws PersistenceException ;
    public long getMinLagerbestand() throws PersistenceException ;
    public void setMinLagerbestand(long newValue) throws PersistenceException ;
    public long getMaxLagerbestand() throws PersistenceException ;
    public void setMaxLagerbestand(long newValue) throws PersistenceException ;
    public long getHstLieferzeit() throws PersistenceException ;
    public void setHstLieferzeit(long newValue) throws PersistenceException ;
    public Artikelstatus4Public getArtikelstatus() throws PersistenceException ;
    public void setArtikelstatus(Artikelstatus4Public newValue) throws PersistenceException ;
    public PersistentArtikel getThis() throws PersistenceException ;
    
    

}

