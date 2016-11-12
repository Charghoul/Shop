package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends ServiceRegisterDOWNMssgsVisitor, ServiceKundeDOWNMssgsVisitor, ServiceAdminDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
