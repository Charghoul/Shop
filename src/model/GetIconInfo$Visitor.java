package model;

import model.visitor.AnythingVisitor;
import persistence.*;
import serverConstants.ToStringConstants;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;

	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
	//	anything.accept(this);
		result = 0;
	}

	@Override
	public void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException {
		result = 2;
	}

	@Override
	public void handleEinkaufsManager(EinkaufsManager4Public einkaufsmanager) throws PersistenceException {
		result = 3;
	}




	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}

}
