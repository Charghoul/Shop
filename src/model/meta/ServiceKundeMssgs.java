package model.meta;

public interface ServiceKundeMssgs {
    void accept(ServiceKundeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceKundeDOWNMssgs extends ServiceShopDOWNMssgs, ServiceKundeMssgs{}
interface ServiceKundeUPMssgs extends Mssgs, ServiceKundeMssgs{}
