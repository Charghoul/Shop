package model.meta;

public interface ArtikelstatusMssgsVisitor extends ArtikelstatusDOWNMssgsVisitor, ArtikelstatusUPMssgsVisitor {}


interface ArtikelstatusDOWNMssgsVisitor extends NeuanlageDOWNMssgsVisitor, VerkaufDOWNMssgsVisitor, AuslaufDOWNMssgsVisitor {

    
}


interface ArtikelstatusUPMssgsVisitor  {

    
}
