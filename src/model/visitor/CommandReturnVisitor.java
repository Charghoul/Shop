
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,BestellungCommandReturnVisitor<R> ,EinkaufsManagerCommandReturnVisitor<R> ,KontoCommandReturnVisitor<R> ,LieferartCommandReturnVisitor<R> ,PositionInBestellungCommandReturnVisitor<R> ,ProduktKatalogCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,SuchManagerCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
