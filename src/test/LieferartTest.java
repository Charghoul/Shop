package test;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import model.Artikel;
import model.ExcIllogicalDataEntry;
import model.UserException;
import model.Verkauf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class LieferartTest {

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

        lieferart = model.Lieferart.createLieferart("express", 3, 499);
    }

    /* Überprüft ob die Lieferart korrekt angelegt wurde */

    @Test
    public void getName() throws PersistenceException, UserException {
        Assert.assertEquals("express", ((PersistentLieferart)lieferart).getName());
    }

    @Test
    public void getLieferzeit() throws PersistenceException, UserException {
        Assert.assertEquals(3, ((PersistentLieferart)lieferart).getLieferzeit());
    }

    @Test
    public void getLieferpreis() throws PersistenceException, UserException {
        Assert.assertEquals(499, ((PersistentLieferart)lieferart).getPreis());
    }

    /* Aber hier werden Methoden zum Ändern der Attribute von <lieferart> getestet */

    /**
     * Ändert den Namen
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereLieferName() throws PersistenceException, UserException {
        lieferart.aendereLieferartName("neuerName");
        Assert.assertEquals("neuerName", ((PersistentLieferart)lieferart).getName());
    }

    /**
     * ändert die Lieferzeit
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereLieferzeit1() throws PersistenceException, UserException {
        lieferart.aendereLieferartDauer(10);
        Assert.assertEquals(10, ((PersistentLieferart)lieferart).getLieferzeit());
    }

    /**
     * Ändert die Lieferzeit auf 0
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereLieferzeit2() throws PersistenceException, UserException {
        lieferart.aendereLieferartDauer(0);
        Assert.assertEquals(0, ((PersistentLieferart)lieferart).getLieferzeit());
    }

    /**
     * ändert die Lieferzeit auf unter null
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aendereLieferzeitFail() throws PersistenceException, UserException {
        lieferart.aendereLieferartDauer(lieferart.getLieferzeit()-(lieferart.getLieferzeit()+1));
        Assert.assertEquals(-1, ((PersistentLieferart)lieferart).getLieferzeit());
    }

    /**
     * Ändert den Preis der Lieferart
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aenderePreis1() throws PersistenceException, UserException {
        lieferart.aendereLieferartPreis(10);
        Assert.assertEquals(10, ((PersistentLieferart)lieferart).getPreis());
    }

    /**
     * ändert den Preis der Lieferart auf 0
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aenderePreis2() throws PersistenceException, UserException {
        lieferart.aendereLieferartPreis(0);
        Assert.assertEquals(0, ((PersistentLieferart)lieferart).getPreis());
    }

    /**
     * Ändert den Preis der Lieferart auf unter 0
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void aenderePreisFail() throws PersistenceException, UserException {
        lieferart.aendereLieferartPreis(lieferart.getPreis()-(lieferart.getPreis()+1));
        Assert.assertEquals(-1, ((PersistentLieferart)lieferart).getPreis());
    }
}
