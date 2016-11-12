package model.meta;

public interface AuslaufMssgs {
    void accept(AuslaufMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AuslaufDOWNMssgs extends ArtikelstatusDOWNMssgs, AuslaufMssgs{}
interface AuslaufUPMssgs extends Mssgs, AuslaufMssgs{}
