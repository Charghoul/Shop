package test;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by dennis on 07.12.2016.
 */
public class ServiceKundeTest {

    private static Konto4Public konto;
    private static BestellManager4Public bestellMan;
    private static EinkaufsManager4Public einkMan;
    private static LieferartManager4Public lieferartMan;
    private static ServiceKunde4Public servKunde;

    private static Verkauf4Public verkauf;
    private static Neuanlage4Public neuanlage;
    private static Artikel4Public artikel1;
    private static Artikel4Public artikel2;
    private static Artikel4Public nichtVerf;

    private static Bestellung4Public bestellung;

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
        neuanlage = Neuanlage.getTheNeuanlage();

        ArtikelManager.getTheArtikelManager().neuerArtikel("1", "test1", 10, 10, 100, 3);
        ArtikelManager.getTheArtikelManager().neuerArtikel("2", "test2", 9, 9, 99, 3);
        ArtikelManager.getTheArtikelManager().neuerArtikel("4", "nichtVerf", 7, 7, 77, 3);

        artikel1 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            ((PersistentArtikel)x).setArtikelstatus(verkauf);
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        artikel2 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            ((PersistentArtikel)x).setArtikelstatus(verkauf);
            return ((PersistentArtikel)x).getArtikelnummer().equals("2");
        });

        nichtVerf = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("4");
        });
        ((PersistentArtikel)nichtVerf).setArtikelstatus(neuanlage);


        LieferartManager.getTheLieferartManager().neueLieferart("express", 3, 499);
        lieferart = ((PersistentLieferartManager) LieferartManager.getTheLieferartManager()).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });

        servKunde = ServiceKunde.createServiceKunde();
        konto = Konto.createKonto(4999, 0, 0);
        bestellMan = BestellManager.createBestellManager(konto);
        einkMan = EinkaufsManager.createEinkaufsManager(bestellMan);
        ((PersistentServiceKunde)servKunde).setEinkaufsManager(einkMan);
        ((PersistentServiceKunde)servKunde).setBestellManager(bestellMan);
        ((PersistentServiceKunde)servKunde).setKonto(konto);
    }

    /**
     * Es wird eine neue Position mit artikel1 und der Menge 10 angelegt
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neuePosition1() throws PersistenceException, UserException {
        servKunde.neuePosition(((PersistentServiceKunde)servKunde).getEinkaufsManager(), artikel1, 10);
    }

    /**
     * Ohne Position mit artikel1 angelegt zu haben wird versucht diese Position zu finden und in <temp> zu speichern
     * erwarte bei <entfernePosition(temp)> eine NullPointerException
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = NullPointerException.class)
    public void entfernePositionFail() throws PersistenceException, UserException {
        Position4Public temp = ((PersistentServiceKunde)servKunde).getEinkaufsManager().getEinkaufsListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException{
                return argument.getArtikel().equals(artikel1);
            }
        });
        servKunde.entfernePosition(temp);
    }

    @Test
    public void bestellen() throws PersistenceException, UserException {
        servKunde.neuePosition(((PersistentServiceKunde)servKunde).getEinkaufsManager(), artikel1, 10);
        servKunde.bestellen(((PersistentServiceKunde)servKunde).getEinkaufsManager(), lieferart);
    }

    /**
     * Überprüfen des Kontostandes des Kontos des ServiceKunde
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void getKontostandServiceKunde() throws PersistenceException, UserException {
        Assert.assertEquals(4999, ((PersistentServiceKunde)servKunde).getKonto().getKontostand());
    }

}
