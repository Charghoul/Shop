
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends ArtikelCommandExceptionVisitor<E>,ArtikelManagerCommandExceptionVisitor<E>,ProduktgruppeCommandExceptionVisitor<E>,ServiceRegisterCommandExceptionVisitor<E>,WarenlagerCommandExceptionVisitor<E>{
    
    
}
