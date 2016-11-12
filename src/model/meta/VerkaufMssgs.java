package model.meta;

public interface VerkaufMssgs {
    void accept(VerkaufMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface VerkaufDOWNMssgs extends ArtikelstatusDOWNMssgs, VerkaufMssgs{}
interface VerkaufUPMssgs extends Mssgs, VerkaufMssgs{}
