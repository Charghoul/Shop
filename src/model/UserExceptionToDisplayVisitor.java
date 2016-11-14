package model;

import model.visitor.UserExceptionStandardVisitor;
import persistence.ErrorDisplay4Public;
import persistence.PersistenceException;

public class UserExceptionToDisplayVisitor extends UserExceptionStandardVisitor {

	private ErrorDisplay4Public result;

	public void standardHandling(UserException userException)
			throws PersistenceException {
		this.result = ErrorDisplay.createErrorDisplay(userException.getMessage(), false);
	}
	public ErrorDisplay4Public getResult(){
		return this.result;
	}

}
