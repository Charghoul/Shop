package model.meta;

public interface ServiceRegisterMssgs {
    void accept(ServiceRegisterMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceRegisterDOWNMssgs extends ServiceDOWNMssgs, ServiceRegisterMssgs{}
interface ServiceRegisterUPMssgs extends Mssgs, ServiceRegisterMssgs{}
