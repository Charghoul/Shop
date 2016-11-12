package model.meta;

public interface WarenlagerMssgs {
    void accept(WarenlagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface WarenlagerDOWNMssgs extends Mssgs, WarenlagerMssgs{}
interface WarenlagerUPMssgs extends Mssgs, WarenlagerMssgs{}
