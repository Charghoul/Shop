package model.meta;

public interface BestellstatusMssgsVisitor extends BestellstatusDOWNMssgsVisitor, BestellstatusUPMssgsVisitor {}


interface BestellstatusDOWNMssgsVisitor extends VerarbeitungDOWNMssgsVisitor, GeliefertDOWNMssgsVisitor, RueckversandDOWNMssgsVisitor, HinversandDOWNMssgsVisitor, AngenommenDOWNMssgsVisitor {

    
}


interface BestellstatusUPMssgsVisitor  {

    
}
