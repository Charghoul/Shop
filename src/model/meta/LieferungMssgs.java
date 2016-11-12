package model.meta;

public interface LieferungMssgs {
    void accept(LieferungMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LieferungDOWNMssgs extends Mssgs, LieferungMssgs{}
interface LieferungUPMssgs extends Mssgs, LieferungMssgs{}
