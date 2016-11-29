
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends ArtikelCommandExceptionVisitor<E>,ArtikelManagerCommandExceptionVisitor<E>,BestellungCommandExceptionVisitor<E>,EinkaufsManagerCommandExceptionVisitor<E>,LieferartCommandExceptionVisitor<E>,PositionInBestellungCommandExceptionVisitor<E>,ProduktKatalogCommandExceptionVisitor<E>,ServiceRegisterCommandExceptionVisitor<E>,SuchManagerCommandExceptionVisitor<E>,WarenlagerCommandExceptionVisitor<E>{
    
    
}
