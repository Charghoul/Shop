package model.meta;

public interface BestellstatusMssgsVisitor extends BestellstatusDOWNMssgsVisitor, BestellstatusUPMssgsVisitor {}


interface BestellstatusDOWNMssgsVisitor extends GeliefertDOWNMssgsVisitor, VorbestellungDOWNMssgsVisitor, RueckversandDOWNMssgsVisitor, HinversandDOWNMssgsVisitor, AngenommenDOWNMssgsVisitor {

    
}


interface BestellstatusUPMssgsVisitor  {

    
}
