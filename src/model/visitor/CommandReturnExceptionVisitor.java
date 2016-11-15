
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends ArtikelCommandReturnExceptionVisitor<R, E> ,ArtikelManagerCommandReturnExceptionVisitor<R, E> ,ServiceRegisterCommandReturnExceptionVisitor<R, E> ,WarenlagerCommandReturnExceptionVisitor<R, E> {
    
    
}
