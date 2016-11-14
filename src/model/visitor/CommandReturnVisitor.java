
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,LieferartManagerCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
