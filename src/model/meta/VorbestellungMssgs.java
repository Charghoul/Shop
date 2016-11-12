package model.meta;

public interface VorbestellungMssgs {
    void accept(VorbestellungMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface VorbestellungDOWNMssgs extends BestellstatusDOWNMssgs, VorbestellungMssgs{}
interface VorbestellungUPMssgs extends Mssgs, VorbestellungMssgs{}
