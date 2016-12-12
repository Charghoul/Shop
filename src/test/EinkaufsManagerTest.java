package test;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class EinkaufsManagerTest {

    private static Konto4Public konto;
    private static BestellManager4Public bestellMan;
    private static EinkaufsManager4Public einkMan;
    private static ServiceKunde4Public servKunde;

    private static Verkauf4Public verkauf;
    private static Hersteller4Public hersteller;
    private static Artikel4Public artikel1;
    private static Artikel4Public artikel2;
    private static Artikel4Public artikel3;
    private static Artikel4Public nichtVerf;

    private static Lieferart4Public lieferart;

    @BeforeClass
    public static void init() throws Exception{
        TestSupport.prepareDatabase();
        TestSupport.prepareSingletons();
    }

    @Before
    public void initEach() throws Exception{
        TestSupport.clearDatabase();
        Cache.getTheCache().reset$For$Test();
        TestSupport.prepareSingletons();

        verkauf = Verkauf.getTheVerkauf();
        hersteller = Hersteller.createHersteller("TestHerteller");

        ArtikelManager.getTheArtikelManager().neuerArtikel("1", "test1", 10, 10, 100, 3);
        ArtikelManager.getTheArtikelManager().neuerArtikel("2", "test2", 9, 9, 99, 3);
        ArtikelManager.getTheArtikelManager().neuerArtikel("3", "test3", 8, 8, 88, 3);
        ArtikelManager.getTheArtikelManager().neuerArtikel("4", "nichtVerf", 7, 7, 77, 3);

        artikel1 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            ((PersistentArtikel)x).setArtikelstatus(verkauf);
            ((PersistentArtikel)x).setHersteller(hersteller);
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        artikel2 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            ((PersistentArtikel)x).setArtikelstatus(verkauf);
            ((PersistentArtikel)x).setHersteller(hersteller);
            return ((PersistentArtikel)x).getArtikelnummer().equals("2");
        });
        artikel3 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            ((PersistentArtikel)x).setArtikelstatus(verkauf);
            ((PersistentArtikel)x).setHersteller(hersteller);
            return ((PersistentArtikel)x).getArtikelnummer().equals("3");
        });
        nichtVerf = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("4");
        });

        servKunde = ServiceKunde.createServiceKunde();
        konto = Konto.createKonto(4999, 0, 0);
        bestellMan = BestellManager.createBestellManager(konto);
        einkMan = EinkaufsManager.createEinkaufsManager(bestellMan);
        ((PersistentServiceKunde)servKunde).setEinkaufsManager(einkMan);
        ((PersistentServiceKunde)servKunde).setBestellManager(bestellMan);
        ((PersistentServiceKunde)servKunde).setKonto(konto);

        lieferart = Lieferart.createLieferart("express", 3, 499);
    }

    /**
     * legt ein der Einkaufsliste eine neue Position mit <artikel1> und einer Menge 10 an
     * prüft, indem Position aus Liste gelsen und Artikel1 gegen Artiekl in Position geprüft werden
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neuePosition1() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel1, 10);
        Position4Public temp = einkMan.getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel1);
            }
        });
        Assert.assertEquals(artikel1, temp.getArtikel());
    }

    /**
     * Legt eine Neue Position in der Einkaufsliste an mit <artikel2> und der Menge 10
     * prüft, indem Position aus Liste gelsen und Artikel2 gegen Artiekl in Position geprüft werden
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neuePosition2() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel2, 10);
        Position4Public temp = einkMan.getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel2);
            }
        });
        Assert.assertEquals(artikel2, temp.getArtikel());
    }

    /**
     * Legt eine neue Position in der Einkaufsliste an mit <artikel3> und der Menge 10
     * prüft, indem Position aus Liste gelsen und Artikel3 gegen Artiekl in Position geprüft werden
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neuePosition3() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel3, 10);
        Position4Public temp = einkMan.getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel3);
            }
        });
        Assert.assertEquals(artikel3, temp.getArtikel());
    }

    /**
     * Es wird versucht zweimal eine neue Position mit dem selben Artikel anzulegen
     * wirf Fehler ExcArtikelAlreadyExists
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcArtikelAlreadyExists.class)
    public void neuePositionFail() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel1, 10);
        einkMan.neuePosition(artikel1, 15);
    }

    /**
     * Es wird versucht eine neue Position anzulegen, obwohl der Artikel <nichtVerf> noch nicht zum Verkauf steht
     * Es wird eine ExcArtikelNochNichtVerfuegbar erwartet
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcArtikelNochNichtVerfuegbar.class)
    public void nochNichtVerfuegbarFail() throws PersistenceException, UserException {
        einkMan.neuePosition(nichtVerf, 10);
    }

    /**
     * neuePosition mit einer übergroßen Menge anlegen, obwohl der Maximallagerbestand das nicht zu lässt
     * Es wird eine ExcLagerbestandOverMax erwartet
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandOverMax.class)
    public void zuVielAuswählenFail() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel1, artikel1.getMaxLagerbestand()+1);
    }

    /**
     * Ohne Position mit <artikel1> angelegt zu haben wird versucht diese Position zu finden und in <temp> zu speichern
     * erwarte bei <entfernePosition(temp)> eine NullPointerException
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = NullPointerException.class)
    public void entfernePositionFail() throws PersistenceException, UserException {
        Position4Public temp = einkMan.getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException{
                return argument.getArtikel().equals(artikel1);
            }
        });
        servKunde.entfernePosition(temp);
    }

    /**
     * Da <artikel1> nur angelegt, aber Bestand = 0 wird  ExcArtikelNichtVerfuegbar erwartet
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcArtikelNichtVerfuegbar.class)
    public void bestellen() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel1, 10);
        einkMan.bestellen(lieferart);
    }

    /**
     * <artikel1> nur angelegt, darum Bestand = 0 -> ExcArtikelNichtVerfuegbar wird geliefert, dennoch ist
     * vorbestellen() möglich
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void vorbestellt() throws PersistenceException, UserException {
        einkMan.neuePosition(artikel1, 10);
        einkMan.vorbestellen(lieferart);
    }
}
