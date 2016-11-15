
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
