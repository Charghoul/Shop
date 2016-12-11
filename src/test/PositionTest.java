package test;

import model.ExcLagerbestandOverMax;
import model.ExcLagerbestandUnderZero;
import model.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class PositionTest {

    private static Position4Public position;
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
        Artikelstatus4Public verkauf = model.Verkauf.getTheVerkauf();
        artikel = model.Artikel.createArtikel("1", "test", 10, 10, 100, 3, verkauf);
        position = model.Position.createPosition(artikel, 10);
    }

    /* Überprüft die Attribute von <position> */

    @Test
    public void getArtikel() throws PersistenceException, UserException {
        Artikel4Public temp = position.getArtikel();
        Assert.assertEquals(artikel, temp);
    }

    @Test
    public void getMenge() throws PersistenceException, UserException {
        Assert.assertEquals(10, position.getMenge());
    }

    /* Ab hier werden Änderungen an der Position vorgenommen */

    /**
     * Die Menge der Position wird um 5 erhöht
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void erhoeheMenge1() throws PersistenceException, UserException {
        position.erhoeheMenge(5);
        Assert.assertEquals(15, position.getMenge());
    }

    /**
     * Die Menge wird um den MaximalLagerbestand des Artikel plus 1 erhöht
     * Wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandOverMax.class)
    public void erhoeheMengeFail() throws PersistenceException, UserException {
        position.erhoeheMenge(artikel.getMaxLagerbestand()+1);
    }

    /**
     * verringert die Menge um 1
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void verringereMenge1() throws  PersistenceException, UserException {
        position.verringereMenge(1);
        Assert.assertEquals(9, position.getMenge());
    }

    /**
     * Verringert die Menge um die Menge
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void verringereMenge2() throws  PersistenceException, UserException {
        position.verringereMenge(position.getMenge());
        Assert.assertEquals(0, position.getMenge());
    }

    /**
     * Versucht die Menge um die Menge+1 zu verringern
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandUnderZero.class)
    public void verringereMengeFail() throws PersistenceException, UserException {
        position.verringereMenge(position.getMenge()+1);
    }

    /**
     * Setzt die Menge auf einen kleinere Wert
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMengeRunter1() throws PersistenceException, UserException {
        position.aendereMenge(5);
        Assert.assertEquals(5, position.getMenge());
    }

    /**
     * Setzt die Menge auf die Menge-1
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMengeRunter2() throws PersistenceException, UserException {
        position.aendereMenge(position.getMenge()-1);
        Assert.assertEquals(9, position.getMenge());
    }

    /**
     * Setzt die Menge auf den Wert Menge
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMenge() throws PersistenceException, UserException {
        position.aendereMenge(position.getMenge());
        Assert.assertEquals(10, position.getMenge());
    }

    /**
     * Setzt die Menge auf einen größeren Wert
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMengeHoch1() throws  PersistenceException, UserException {
        position.aendereMenge(15);
        Assert.assertEquals(15, position.getMenge());
    }

    /**
     * Setzt die Menge auf die Menge+1
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereMengeHoch2() throws PersistenceException, UserException {
        position.aendereMenge(position.getMenge()+1);
        Assert.assertEquals(11, position.getMenge());
    }

    /**
     * Versucht die Menge auf einen Wert kleiner 0 zu setzen
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandUnderZero.class)
    public void aendereMengeFail1() throws PersistenceException, UserException {
        position.aendereMenge(-1);
    }

    /**
     * Versucht die Menge auf einen Wert größer des MaximalLagerbestandes des Artikels zu setzen
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandOverMax.class)
    public void aendereMengeFail2() throws PersistenceException, UserException {
        position.aendereMenge(artikel.getMaxLagerbestand()+1);
    }
}
