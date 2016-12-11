package test;

import model.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class LieferartManagerTest {

    private static LieferartManager4Public lieferMan;

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

        lieferMan = model.LieferartManager.getTheLieferartManager();

        ((PersistentLieferartManager)lieferMan).neueLieferart("express", 3, 499);
    }

    /* Überprüft, ob die Attribute der Lieferart richtig gesetzt wurden */

    @Test
    public void getLiefername() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        Assert.assertEquals("express", ((PersistentLieferart)temp).getName());
    }

    @Test
    public void getLieferzeit() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        Assert.assertEquals(3, ((PersistentLieferart)temp).getLieferzeit());
    }

    @Test
    public void getLieferpreis() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        Assert.assertEquals(499, ((PersistentLieferart)temp).getPreis());
    }

    /* Ab hier werden Methoden zum Ändern der Attribute auf die Lieferart angewandt */

    @Test
    public void aendereLiefername() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartName("neuerName");
        Assert.assertEquals("neuerName", ((PersistentLieferart)temp).getName());
    }

    @Test
    public void aendereLieferzeit1() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartDauer(10);
        Assert.assertEquals(10, ((PersistentLieferart)temp).getLieferzeit());
    }

    @Test
    public void aendereLieferzeit2() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartDauer(0);
        Assert.assertEquals(0, ((PersistentLieferart)temp).getLieferzeit());
    }

    @Test
    public void aendereLieferzeitFail() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartDauer(temp.getLieferzeit()-(temp.getLieferzeit()+1));
        Assert.assertEquals(-1, ((PersistentLieferart)temp).getLieferzeit());
    }

    @Test
    public void aendereLieferzeitPreis1() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartPreis(10);
        Assert.assertEquals(10, ((PersistentLieferart)temp).getPreis());
    }

    @Test
    public void aendereLieferzeitPreis2() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartPreis(0);
        Assert.assertEquals(0, ((PersistentLieferart)temp).getPreis());
    }

    @Test
    public void aendereLieferzeitPreisFail() throws PersistenceException, UserException {
        Lieferart4Public temp = ((PersistentLieferartManager)lieferMan).getLieferartenListe().findFirst(x -> {
            return ((PersistentLieferart)x).getName().equals("express");
        });
        temp.aendereLieferartPreis(temp.getPreis()-(temp.getPreis()+1));
        Assert.assertEquals(-1, ((PersistentLieferart)temp).getPreis());
    }
}
