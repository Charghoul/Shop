package model.meta;

public interface BestellstatusMssgsVisitor extends BestellstatusDOWNMssgsVisitor, BestellstatusUPMssgsVisitor {}


interface BestellstatusDOWNMssgsVisitor extends AngenommenDOWNMssgsVisitor, VerarbeitungDOWNMssgsVisitor, GeliefertDOWNMssgsVisitor, RueckversandDOWNMssgsVisitor, HinversandDOWNMssgsVisitor {

    
}


interface BestellstatusUPMssgsVisitor  {

    
}
