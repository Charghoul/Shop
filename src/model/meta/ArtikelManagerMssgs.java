package model.meta;

public interface ArtikelManagerMssgs {
    void accept(ArtikelManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ArtikelManagerDOWNMssgs extends Mssgs, ArtikelManagerMssgs{}
interface ArtikelManagerUPMssgs extends Mssgs, ArtikelManagerMssgs{}
