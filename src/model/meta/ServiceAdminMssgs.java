package model.meta;

public interface ServiceAdminMssgs {
    void accept(ServiceAdminMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceAdminDOWNMssgs extends ServiceDOWNMssgs, ServiceAdminMssgs{}
interface ServiceAdminUPMssgs extends Mssgs, ServiceAdminMssgs{}
