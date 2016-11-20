package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends ServiceRegisterDOWNMssgsVisitor, ServiceShopDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
