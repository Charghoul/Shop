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
public class ArtikelManagerTest {

    private static Artikel4Public artikel;

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
        ArtikelManager.getTheArtikelManager().neuerArtikel("1", "test" +
                "", 10, 5, 15, 3);
        artikel = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel) x).getArtikelnummer().equals("1");
        });
    }

    /* Überprüft, ob der Artikel korrekt angelegt wurde */

    @Test
    public void getArtNR() throws PersistenceException, UserException {
        Assert.assertEquals("1", ((PersistentArtikel)artikel).getArtikelnummer());
    }

    @Test
    public void getBezeichnung() throws PersistenceException, UserException {
        Assert.assertEquals("test", ((PersistentArtikel)artikel).getBezeichnung());
    }

    @Test
    public void getPreis() throws PersistenceException, UserException {
        Assert.assertEquals(10, ((PersistentArtikel)artikel).getPreis());
    }

    @Test
    public void getMinLB() throws PersistenceException, UserException {
        Assert.assertEquals(5, ((PersistentArtikel)artikel).getMinLagerbestand());
    }

    @Test
    public void getMaxLB() throws PersistenceException, UserException {
        Assert.assertEquals(15, ((PersistentArtikel)artikel).getMaxLagerbestand());
    }

    @Test
    public void getHSTZ() throws PersistenceException, UserException {
        Assert.assertEquals(3, ((PersistentArtikel)artikel).getHstLieferzeit());
    }

    /* ab hier werden Tests durchgeführt den Artikel zu ändern*/

    /**
     * sucht in der Artikelliste des ArtikelManagers nach dem Artikel mit der Nummer "1"
     * speichert gefundenen Artikel in <temp>
     *     ändert Bezeichnung von temp
     *     prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereBezeichnung() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereBezeichnung("neueBezeichnung");
        Assert.assertEquals("neueBezeichnung", ((PersistentArtikel)temp).getBezeichnung());
    }

    /**
     * sucht in der Artikelliste des ArtikelManagers nach dem Artikel mit der Nummer "1"
     * speichert gefundenen Artikel in <temp>
     *     ändert Preis von temp
     *     prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aenderePreis() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aenderePreis(15);
        Assert.assertEquals(15, ((PersistentArtikel)temp).getPreis());
    }

    /**
     * sucht in der Artikelliste des ArtikelManagers nach dem Artikel mit der Nummer "1"
     * speichert gefundenen Artikel in <temp>
     *     ändert mindestLagerbestand
     *     prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMinLB() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereMinLagerbestand(10);
        Assert.assertEquals(10, ((PersistentArtikel)temp).getMinLagerbestand());
    }

    /**
     * versucht den MindestLagerbestand größer zu setzen als den MaximalLagerbestand
     * wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereMinLBFail() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereMinLagerbestand(temp.getMaxLagerbestand()+1);
    }

    /**
     * sucht in der Artikelliste des ArtikelManagers nach dem Artikel mit der Nummer "1"
     * speichert gefundenen Artikel in <temp>
     *     ändert maximalLagerbestand
     *     prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMaxLB() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereMaxLagerbestand(50);
        Assert.assertEquals(50, ((PersistentArtikel)temp).getMaxLagerbestand());
    }

    /**
     * versucht den MaximalLagerbestand kleiner zu setzen als den MindestLagerbestand
     * wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereMaxLBFail() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereMaxLagerbestand(temp.getMinLagerbestand()-1);
    }

    /**
     * sucht in der Artikelliste des ArtikelManagers nach dem Artikel mit der Nummer "1"
     * speichert gefundenen Artikel in <temp>
     *     ändert HerstellerLieferzeit
     *     prüft Änderung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereHSTZ() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereHstLieferzeit(10);
        Assert.assertEquals(10, ((PersistentArtikel)temp).getHstLieferzeit());
    }

    /**
     * Versucht HerstellerLieferzeit auf -1 zu setzen
     * wird Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcIllogicalDataEntry.class)
    public void aendereHSTZFail() throws PersistenceException, UserException {
        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });
        temp.aendereHstLieferzeit(-1);
        Assert.assertEquals(-1, ((PersistentArtikel)temp).getHstLieferzeit());
    }
}
