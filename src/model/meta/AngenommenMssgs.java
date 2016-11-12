package model.meta;

public interface AngenommenMssgs {
    void accept(AngenommenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AngenommenDOWNMssgs extends BestellstatusDOWNMssgs, AngenommenMssgs{}
interface AngenommenUPMssgs extends Mssgs, AngenommenMssgs{}
