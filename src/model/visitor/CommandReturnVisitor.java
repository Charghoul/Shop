
package model.visitor;

public interface CommandReturnVisitor<R> extends ArtikelCommandReturnVisitor<R> ,ArtikelManagerCommandReturnVisitor<R> ,EinkaufsManagerCommandReturnVisitor<R> ,LieferartManagerCommandReturnVisitor<R> ,ServiceRegisterCommandReturnVisitor<R> ,WarenlagerCommandReturnVisitor<R> {
    
    
}
