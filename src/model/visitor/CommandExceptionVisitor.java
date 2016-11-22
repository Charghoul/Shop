
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends ArtikelCommandExceptionVisitor<E>,ArtikelManagerCommandExceptionVisitor<E>,BestellungCommandExceptionVisitor<E>,EinkaufsManagerCommandExceptionVisitor<E>,PositionInBestellungCommandExceptionVisitor<E>,ProduktKatalogCommandExceptionVisitor<E>,ServiceRegisterCommandExceptionVisitor<E>,WarenlagerCommandExceptionVisitor<E>{
    
    
}
