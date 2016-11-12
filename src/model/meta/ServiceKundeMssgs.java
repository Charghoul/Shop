package model.meta;

public interface ServiceKundeMssgs {
    void accept(ServiceKundeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceKundeDOWNMssgs extends ServiceDOWNMssgs, ServiceKundeMssgs{}
interface ServiceKundeUPMssgs extends Mssgs, ServiceKundeMssgs{}
