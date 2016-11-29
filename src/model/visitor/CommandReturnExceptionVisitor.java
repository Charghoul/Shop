
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends ArtikelCommandReturnExceptionVisitor<R, E> ,ArtikelManagerCommandReturnExceptionVisitor<R, E> ,BestellungCommandReturnExceptionVisitor<R, E> ,EinkaufsManagerCommandReturnExceptionVisitor<R, E> ,LieferartCommandReturnExceptionVisitor<R, E> ,PositionInBestellungCommandReturnExceptionVisitor<R, E> ,ProduktKatalogCommandReturnExceptionVisitor<R, E> ,ServiceRegisterCommandReturnExceptionVisitor<R, E> ,WarenlagerCommandReturnExceptionVisitor<R, E> {
    
    
}
