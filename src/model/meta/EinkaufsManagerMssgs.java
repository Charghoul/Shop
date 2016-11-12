package model.meta;

public interface EinkaufsManagerMssgs {
    void accept(EinkaufsManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EinkaufsManagerDOWNMssgs extends Mssgs, EinkaufsManagerMssgs{}
interface EinkaufsManagerUPMssgs extends Mssgs, EinkaufsManagerMssgs{}
