package model.meta;

public interface ArtikelMssgs {
    void accept(ArtikelMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ArtikelDOWNMssgs extends KomponenteDOWNMssgs, ArtikelMssgs{}
interface ArtikelUPMssgs extends Mssgs, ArtikelMssgs{}
