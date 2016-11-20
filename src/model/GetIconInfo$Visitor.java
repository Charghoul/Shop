package model;

import model.visitor.AnythingVisitor;
import persistence.*;

public class GetIconInfo$Visitor extends model.visitor.AnythingDirectVisitor {

	int result = 0;

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}

	@Override
	public void handleServer(Server4Public server) throws PersistenceException {

	}

	@Override
	public void handlePositionAbstrakt(PositionAbstrakt4Public positionAbstrakt) throws PersistenceException {

	}

	@Override
	public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException {

	}

	@Override
	public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException {

	}

	@Override
	public void handleServiceAdminZeitManager(ServiceAdminZeitManager4Public serviceAdminZeitManager) throws PersistenceException {

	}

	@Override
	public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException {

	}

	@Override
	public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException {

	}

	@Override
	public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException {

	}

	@Override
	public void handleServiceKundeBestellManager(ServiceKundeBestellManager4Public serviceKundeBestellManager) throws PersistenceException {

	}

	@Override
	public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException {

	}

	@Override
	public void handleKomponente(Komponente4Public komponente) throws PersistenceException {

	}

	@Override
	public void handleThreadOfControl(ThreadOfControl4Public threadOfControl) throws PersistenceException {

	}

	@Override
	public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException {
		result = 2;
	}

	@Override
	public void handleBestellstatus(Bestellstatus4Public bestellstatus) throws PersistenceException {

	}

	@Override
	public void handleServiceShopProduktKatalog(ServiceShopProduktKatalog4Public serviceShopProduktKatalog) throws PersistenceException {

	}

	@Override
	public void handleZeitObjekt(ZeitObjekt4Public zeitObjekt) throws PersistenceException {

	}

	@Override
	public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException {

	}

	@Override
	public void handleService(Service4Public service) throws PersistenceException {

	}

	@Override
	public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException {

	}

	@Override
	public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException {

	}

	@Override
	public void handleSubj(Subj4Public subj) throws PersistenceException {

	}

	@Override
	public void handleKonto(Konto4Public konto) throws PersistenceException {

	}

	@Override
	public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException {

	}

	@Override
	public void handleKunde(Kunde4Public kunde) throws PersistenceException {

	}

	@Override
	public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException {

	}

	@Override
	public void handleIntegerWrapper(IntegerWrapper4Public integerWrapper) throws PersistenceException {

	}

	@Override
	public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException {
		result = 1;
	}

	@Override
	public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException {

	}

	@Override
	public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException {

	}

	@Override
	public void handleArtikelstatus(Artikelstatus4Public artikelstatus) throws PersistenceException {

	}
}
