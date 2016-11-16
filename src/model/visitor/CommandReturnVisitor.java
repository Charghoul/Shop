
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,ProduktgruppeCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
