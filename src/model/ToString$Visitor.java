package model;

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
	public void handleKunde(Kunde4Public kunde) throws PersistenceException {
	}

	@Override
	public void handleLieferartManager(LieferartManager4Public lieferartManager) throws PersistenceException {
		this.result="LieferartManager";
	}

	@Override
	public void handleHinversand(Hinversand4Public hinversand) throws PersistenceException {

	}

	@Override
	public void handleAngenommen(Angenommen4Public angenommen) throws PersistenceException {

	}

	@Override
	public void handleLieferung(Lieferung4Public lieferung) throws PersistenceException {

	}


	@Override
	public void handleWarenlager(Warenlager4Public warenlager) throws PersistenceException {
		this.result= ToStringConstants.Warenlager;
	}

	@Override
	public void handleVerkauf(Verkauf4Public verkauf) throws PersistenceException {

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

	}


	@Override
	public void handleBestellung(Bestellung4Public bestellung) throws PersistenceException {

	}

	@Override
	public void handleLieferart(Lieferart4Public lieferart) throws PersistenceException {
		PersistentLieferart pLieferArt = (PersistentLieferart) lieferart;
		result = ToStringConstants.Lieferart +  pLieferArt.getName();
	}

	@Override
	public void handleNeuanlage(Neuanlage4Public neuanlage) throws PersistenceException {
		result = ToStringConstants.Neuanlage;
	}


	@Override
	public void handleServiceRegister(ServiceRegister4Public serviceRegister) throws PersistenceException {

	}

	@Override
	public void handleGeliefert(Geliefert4Public geliefert) throws PersistenceException {

	}

	@Override
	public void handleServiceKunde(ServiceKunde4Public serviceKunde) throws PersistenceException {
	}



	@Override
	public void handleKonto(Konto4Public konto) throws PersistenceException {

	}

	@Override
	public void handleVorbestellung(Vorbestellung4Public vorbestellung) throws PersistenceException {

	}

	@Override
	public void handleRueckversand(Rueckversand4Public rueckversand) throws PersistenceException {

	}

	@Override
	public void handleArtikel(Artikel4Public artikel) throws PersistenceException {
		PersistentArtikel persistentArtikel = (PersistentArtikel) artikel;
		result = ToStringConstants.Artikel + persistentArtikel.getArtikelnummer() + " | " + persistentArtikel.getBezeichnung();
	}



	@Override
	public void handlePosition(Position4Public position) throws PersistenceException {
		PersistentPosition persistentPosition = (PersistentPosition) position;
		result = persistentPosition.getMenge() + " Stck. - " + persistentPosition.getArtikel().toString();
	}


	@Override
	public void handleServiceAdmin(ServiceAdmin4Public serviceAdmin) throws PersistenceException {
	}

	@Override
	public void handleArtikelManager(ArtikelManager4Public artikelManager) throws PersistenceException {
		this.result = ToStringConstants.ArtikelManager;
	}


}



