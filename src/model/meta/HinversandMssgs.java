package model.meta;

public interface HinversandMssgs {
    void accept(HinversandMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface HinversandDOWNMssgs extends BestellstatusDOWNMssgs, HinversandMssgs{}
interface HinversandUPMssgs extends Mssgs, HinversandMssgs{}
