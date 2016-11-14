
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends ArtikelCommandExceptionVisitor<E>,ArtikelManagerCommandExceptionVisitor<E>,EinkaufsManagerCommandExceptionVisitor<E>,LieferartManagerCommandExceptionVisitor<E>,ServiceRegisterCommandExceptionVisitor<E>,WarenlagerCommandExceptionVisitor<E>{
    
    
}
