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

	@Override
	public void handleArtikel(Artikel4Public artikel) throws PersistenceException {
		result = 1;
	}

	@Override
	public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException {
		result = 4;
	}

	@Override
	public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException {
		result = 6;
	}

	@Override
	public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException {
		result = 7;
	}

	@Override
	public void handleKonto(Konto4Public konto) throws PersistenceException {
		result = 8;
	}

	@Override
	public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException {
		result = 10;
	}

	@Override
	public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException {
		result = 11;
	}

	@Override
	public void handleKundenManager(KundenManager4Public kundenManager) throws PersistenceException {
		result = 12;
	}

	@Override
	public void handleSuchManager(SuchManager4Public suchManager) throws PersistenceException {
		result = 13;
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}

}
