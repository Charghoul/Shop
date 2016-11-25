package model.meta;

public interface VorbestellungMssgs {
    void accept(VorbestellungMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface VorbestellungDOWNMssgs extends BestellungAbstraktDOWNMssgs, VorbestellungMssgs{}
interface VorbestellungUPMssgs extends Mssgs, VorbestellungMssgs{}
