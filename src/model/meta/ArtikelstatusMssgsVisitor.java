package model.meta;

public interface ArtikelstatusMssgsVisitor extends ArtikelstatusDOWNMssgsVisitor, ArtikelstatusUPMssgsVisitor {}


interface ArtikelstatusDOWNMssgsVisitor extends VerkaufDOWNMssgsVisitor, AuslaufDOWNMssgsVisitor, NeuanlageDOWNMssgsVisitor {

    
}


interface ArtikelstatusUPMssgsVisitor  {

    
}
