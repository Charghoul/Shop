package model.meta;

public interface PositionMssgs {
    void accept(PositionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PositionDOWNMssgs extends PositionAbstraktDOWNMssgs, PositionMssgs{}
interface PositionUPMssgs extends Mssgs, PositionMssgs{}
