package test;

import common.Fraction;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class Artikeltest {

    private static Artikel4Public artikel;
    private static Artikelstatus4Public verkauf;

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
        artikel = model.Artikel.createArtikel("1", "test", 10, 10, 100, 3, verkauf);
    }

    /* Überprüft ob der Artikel korrekt angelegt wurde */

    @Test
    public void getArtNR() throws PersistenceException, UserException {
        Assert.assertEquals("1", ((PersistentArtikel)artikel).getArtikelnummer());
    }

    @Test
    public void getBez() throws PersistenceException, UserException {
        Assert.assertEquals("test", ((PersistentArtikel)artikel).getBezeichnung());
    }

    @Test
    public void getPreis() throws PersistenceException, UserException {
        Assert.assertEquals(10, ((PersistentArtikel)artikel).getPreis());
    }

    @Test
    public void getMinLB() throws PersistenceException, UserException {
        Assert.assertEquals(10, ((PersistentArtikel)artikel).getMinLagerbestand());
    }

    @Test
    public void getMaxLB() throws PersistenceException, UserException {
        Assert.assertEquals(100, ((PersistentArtikel)artikel).getMaxLagerbestand());
    }

    @Test
    public void getHSTZ() throws PersistenceException, UserException {
        Assert.assertEquals(3, ((PersistentArtikel)artikel).getHstLieferzeit());
    }

    /**
     * Ändert die Bezeichnung des Artikel zu einer neuen Bezeichnung
     * prüft die Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereBez() throws PersistenceException, UserException {
        artikel.aendereBezeichnung("neueBezeichnung");
        Assert.assertEquals("neueBezeichnung", ((PersistentArtikel)artikel).getBezeichnung());
    }

    /**
     * Ändert den Preis des Artikels zu einem neuen Preis
     * prüft die Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aenderePreis() throws PersistenceException, UserException {
        artikel.aenderePreis(15);
        Assert.assertEquals(15, ((PersistentArtikel)artikel).getPreis());
    }

    /**
     * ändert den MindestLagerbestand
     * prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMinLB() throws PersistenceException, UserException {
        artikel.aendereMinLagerbestand(5);
        Assert.assertEquals(5, ((PersistentArtikel)artikel).getMinLagerbestand());
    }

    /**
     * Versucht den MindestLagerbestand auf einen höheren Wert als den Maximallagerbestand zu änder
     * Wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereMinLBFail() throws PersistenceException, UserException {
        artikel.aendereMinLagerbestand(artikel.getMaxLagerbestand()+1);
        Assert.assertEquals(150, ((PersistentArtikel)artikel).getMinLagerbestand());
    }

    /**
     * Ändert MaximalLagerbestand auf einen neuen
     * prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMaxLB() throws PersistenceException, UserException {
        artikel.aendereMaxLagerbestand(50);
        Assert.assertEquals(50, ((PersistentArtikel)artikel).getMaxLagerbestand());
    }

    /**
     * versucht den MaximalLagerbestand auf einen zu ändern, der kleiner ist als der MindestLagerbestand
     * Wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereMaxLBFail() throws PersistenceException, UserException {
        artikel.aendereMaxLagerbestand(artikel.getMinLagerbestand()-1);
        Assert.assertEquals(1, ((PersistentArtikel)artikel).getMaxLagerbestand());
    }

    /**
     * Ändert die HerstellerLieferzeit
     * prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereHSTZ() throws PersistenceException, UserException {
        artikel.aendereHstLieferzeit(10);
        Assert.assertEquals(10, ((PersistentArtikel)artikel).getHstLieferzeit());
    }

    /**
     * versucht die Herstellerlieferzeit auf unter 0 zu setzen
     * wirft fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereHSTZFail() throws PersistenceException, UserException {
        artikel.aendereHstLieferzeit(-1);
        Assert.assertEquals(-1, ((PersistentArtikel)artikel).getHstLieferzeit());
    }
}
