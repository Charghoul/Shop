package model.meta;

public interface BestellungMssgs {
    void accept(BestellungMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BestellungDOWNMssgs extends Mssgs, BestellungMssgs{}
interface BestellungUPMssgs extends Mssgs, BestellungMssgs{}
