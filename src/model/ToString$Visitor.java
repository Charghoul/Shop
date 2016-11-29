package model;

import model.visitor.ZeitObjektReturnVisitor;
import persistence.*;
import serverConstants.ToStringConstants;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;

	public ToString$Visitor() {
	}

	public synchronized String toString(Anything anything) throws PersistenceException {
		try {
			result = null;
			anything.accept(this);
			if (result == null) {
				this.standardHandling(anything);
			} else {
				if (common.RPCConstantsAndServices.test)
					result = " " + anything.getClassId() + " , " + anything.getId() + "::  " + result;
			}
		} catch (Exception ex) {
			System.out.println("During toString of " + anything.getClass() + " happened " + ex);
			this.standardHandling(anything);
		}
		return result;
	}

	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}

	@Override
	public void handleHersteller(Hersteller4Public hersteller) throws PersistenceException {
		result = ToStringConstants.Hersteller + ((PersistentHersteller) hersteller).getName();
	}

	@Override
	public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException {
		this.result="LieferartManager";
	}

	@Override
	public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException {
		result = ToStringConstants.Hinversand;
	}

	@Override
	public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException {
		result = ToStringConstants.Angenommen;
	}

	@Override
	public void handleRetoure(Retoure4Public retoure) throws PersistenceException {

	}


	@Override
	public void handleactivated(activated4Public activated) throws PersistenceException {
		result = ToStringConstants.activated;
	}


	@Override
	public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException {
		this.result= ToStringConstants.Warenlager;
	}


	@Override
	public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException {
		result = ToStringConstants.Artikelstatus +ToStringConstants.Verkauf;
	}

	@Override
	public void handleVerarbeitung(Verarbeitung4Public verarbeitung) throws PersistenceException {
		result = ToStringConstants.Verarbeitung;
	}

	@Override
	public void handleServer(Server4Public server) throws PersistenceException {

	}

	@Override
	public void handleEinkaufsManager(EinkaufsManager4Public einkaufsManager) throws PersistenceException {
		this.result=ToStringConstants.Einkaufswagen;
	}

	@Override
	public void handleAuslauf(Auslauf4Public auslauf) throws PersistenceException {
		result = ToStringConstants.Artikelstatus + ToStringConstants.Auslauf;
	}

	@Override
	public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException {
		PersistentBestellung persB = (PersistentBestellung)bestellung;
		String temp = ToStringConstants.Bestellung + persB.getBestellID() + " | " + persB.getBestellstatus() + " | Versuch (" +
				((PersistentKndLieferung)persB.getKndLieferung()).getLieferversuche() + "/" + ZeitManager.getTheZeitManager().getMaxAnlieferungsVersuche() + ")";
		result = temp;
	}

	@Override
	public void handleKundenManager(KundenManager4Public kundenManager) throws PersistenceException {
		result = ToStringConstants.KundenManager;
	}

	@Override
	public void handleHerstellerManager(HerstellerManager4Public herstellerManager) throws PersistenceException {
		result = ToStringConstants.HerstellerManager;
	}

	@Override
	public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException {
		PersistentLieferart persL = (PersistentLieferart) lieferart;
		long preis = persL.getPreis();
		result = ToStringConstants.Lieferart +  persL.getName() + " - " + preis/100 + "." + preis%100 + " Euro";
	}

	@Override
	public void handledeactivated(deactivated4Public deactivated) throws PersistenceException {
		result = ToStringConstants.deactived;
	}

	@Override
	public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException {
		result = ToStringConstants.Artikelstatus + ToStringConstants.Neuanlage;
	}


	@Override
	public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException {

	}

	@Override
	public void handleHstLieferung(HstLieferung4Public hstLieferung) throws PersistenceException {
		result = ToStringConstants.HstLieferung + " "+hstLieferung.getId() +" | "+ hstLieferung.getStatus();
	}

	@Override
	public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException {
		result = ToStringConstants.Geliefert;
	}

	@Override
	public void handleKndLieferung(KndLieferung4Public kndLieferung) throws PersistenceException {
		PersistentKndLieferung persKnd = (PersistentKndLieferung) kndLieferung;
		result =  ToStringConstants.Kundenlieferung + persKnd.getBestellung().getLieferart().toString() +" (" + persKnd.getLieferversuche() + "/" + ZeitManager.getTheZeitManager().getMaxAnlieferungsVersuche()+")";
	}

	@Override
	public void handleKndAnnahme(KndAnnahme4Public kndAnnahme) throws PersistenceException {
		PersistentKndAnnahme persKndA = (PersistentKndAnnahme) kndAnnahme;
		result = ToStringConstants.KndAnnahme;
	}

	@Override
	public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException {
		result = ToStringConstants.Kunde;
	}


	@Override
	public void handleBestellManager(BestellManager4Public bestellManager) throws PersistenceException {
		result = ToStringConstants.BestellManager;
	}

	@Override
	public void handleProduktKatalog(ProduktKatalog4Public produktKatalog) throws PersistenceException {
		result = ToStringConstants.ProduktKatalog;
	}


	@Override
	public void handleKonto(Konto4Public konto) throws PersistenceException {
		result = ToStringConstants.Konto + " - " + konto.getKontostand()/100 + "." + konto.getKontostand()%100 +" Euro (" + (+ konto.getReserviert()/100 + "." + konto.getReserviert()%100 +" Euro)");
	}

	@Override
	public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException {
		result = ToStringConstants.Vorbestellung;
	}

	@Override
	public void handlePositionInBestellung(PositionInBestellung4Public positionInBestellung) throws PersistenceException {
		result = positionInBestellung.getMenge() + " Stck. - " + positionInBestellung.getArtikel().toString();
	}

	@Override
	public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException {
		result = ToStringConstants.Rückversand;
	}

	@Override
	public void handleKunde(Kunde4Public kunde) throws PersistenceException {
		result = ToStringConstants.Kunde + ((PersistentKunde)kunde).getBenutzername();
	}

	@Override
	public void handleArtikel(Artikel4Public artikel) throws PersistenceException {
		PersistentArtikel persistentArtikel = (PersistentArtikel) artikel;
		String temp = "("+persistentArtikel.getArtikelnummer() + ") " + persistentArtikel.getBezeichnung()
				+" | " + persistentArtikel.getArtikelstatus() + " | " + persistentArtikel.getPreis()/100 + "."+persistentArtikel.getPreis()%100 + " Euro";
		if(persistentArtikel.getHersteller()!=null){
			temp = temp +" | " + persistentArtikel.getHersteller();
		}
		Position4Public bestand = Warenlager.getTheWarenlager().getWarenListe().findFirst(x -> {
			return x.getArtikel().equals(artikel);
		});
		if(bestand != null) {
			temp = temp + " | Bestand: " + bestand.getMenge();
		}
		result = temp;
	}

	@Override
	public void handleProduktgruppe(Produktgruppe4Public produktgruppe) throws PersistenceException {
		PersistentProduktgruppe persistentProduktgruppe = (PersistentProduktgruppe) produktgruppe;
		result = ToStringConstants.Produktgruppe + persistentProduktgruppe.getName();
	}

	@Override
	public void handlePosition(Position4Public position) throws PersistenceException {
		result = position.getMenge() + " Stck. - " + position.getArtikel().toString();
	}


	@Override
	public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException {
	}

	@Override
	public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException {
		this.result = ToStringConstants.ArtikelManager;
	}

	@Override
	public void handleZeitManager(ZeitManager4Public zeitManager) throws PersistenceException {
		result = ToStringConstants.ZeitManager;
	}

	@Override
	public void handleSuchManager(SuchManager4Public suchManager) throws PersistenceException {
		result = ToStringConstants.SuchManager;
	}


}



