package model.meta;

public interface NeuanlageMssgs {
    void accept(NeuanlageMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NeuanlageDOWNMssgs extends ArtikelstatusDOWNMssgs, NeuanlageMssgs{}
interface NeuanlageUPMssgs extends Mssgs, NeuanlageMssgs{}
