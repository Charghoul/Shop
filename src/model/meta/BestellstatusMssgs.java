package model.meta;

public interface BestellstatusMssgs {
    void accept(BestellstatusMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BestellstatusDOWNMssgs extends Mssgs, BestellstatusMssgs{}
interface BestellstatusUPMssgs extends GeliefertUPMssgs, VorbestellungUPMssgs, RueckversandUPMssgs, HinversandUPMssgs, AngenommenUPMssgs, BestellstatusMssgs{}
