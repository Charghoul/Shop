package model.meta;

public interface GeliefertMssgs {
    void accept(GeliefertMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GeliefertDOWNMssgs extends BestellstatusDOWNMssgs, GeliefertMssgs{}
interface GeliefertUPMssgs extends Mssgs, GeliefertMssgs{}
