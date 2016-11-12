package model.meta;

public interface RueckversandMssgs {
    void accept(RueckversandMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RueckversandDOWNMssgs extends BestellstatusDOWNMssgs, RueckversandMssgs{}
interface RueckversandUPMssgs extends Mssgs, RueckversandMssgs{}
