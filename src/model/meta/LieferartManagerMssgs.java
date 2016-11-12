package model.meta;

public interface LieferartManagerMssgs {
    void accept(LieferartManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LieferartManagerDOWNMssgs extends Mssgs, LieferartManagerMssgs{}
interface LieferartManagerUPMssgs extends Mssgs, LieferartManagerMssgs{}
