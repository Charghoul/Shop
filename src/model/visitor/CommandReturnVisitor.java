
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,EinkaufsManagerCommandReturnVisitor<R> ,PositionInBestellungCommandReturnVisitor<R> ,ProduktKatalogCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
