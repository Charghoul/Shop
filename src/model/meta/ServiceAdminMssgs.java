package model.meta;

public interface ServiceAdminMssgs {
    void accept(ServiceAdminMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceAdminDOWNMssgs extends ServiceShopDOWNMssgs, ServiceAdminMssgs{}
interface ServiceAdminUPMssgs extends Mssgs, ServiceAdminMssgs{}
