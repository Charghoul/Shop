package model.meta;

public interface ArtikelstatusMssgs {
    void accept(ArtikelstatusMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ArtikelstatusDOWNMssgs extends Mssgs, ArtikelstatusMssgs{}
interface ArtikelstatusUPMssgs extends NeuanlageUPMssgs, VerkaufUPMssgs, AuslaufUPMssgs, ArtikelstatusMssgs{}
