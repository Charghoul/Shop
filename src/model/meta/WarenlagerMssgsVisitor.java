package model.meta;

public interface WarenlagerMssgsVisitor extends WarenlagerDOWNMssgsVisitor, WarenlagerUPMssgsVisitor {}


interface WarenlagerDOWNMssgsVisitor  {

    public void handleWarenlagerArtikelEinlagernArtikelIntegerMssg(WarenlagerArtikelEinlagernArtikelIntegerMssg event) throws persistence.PersistenceException;
    
}


interface WarenlagerUPMssgsVisitor  {

    public void handleWarenlagerArtikelEinlagernArtikelIntegerMssg(WarenlagerArtikelEinlagernArtikelIntegerMssg event) throws persistence.PersistenceException;
    
}
