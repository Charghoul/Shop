
package view;


import view.visitor.UserExceptionExceptionVisitor;
import view.visitor.UserExceptionReturnExceptionVisitor;
import view.visitor.UserExceptionReturnVisitor;
import view.visitor.UserExceptionVisitor;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

@SuppressWarnings("serial")
public class RestrictionException extends view.UserException{
    
    public static RestrictionException fromHashtableToRestrictionException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new RestrictionException(message);
    }
    
    public RestrictionException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleRestrictionException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleRestrictionException(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleRestrictionException(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleRestrictionException(this);
    }
    
    
}
