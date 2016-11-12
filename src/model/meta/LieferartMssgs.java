package model.meta;

public interface LieferartMssgs {
    void accept(LieferartMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LieferartDOWNMssgs extends Mssgs, LieferartMssgs{}
interface LieferartUPMssgs extends Mssgs, LieferartMssgs{}
