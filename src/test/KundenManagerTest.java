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
public class KundenManagerTest {

    private static KundenManager4Public kundeMan;

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

        kundeMan = model.KundenManager.getTheKundenManager();
        kundeMan.getKundenListe().add(model.Kunde.createKunde("test", "test"));
    }

    /* Überprüft ob der Kunde korrekt angelegt wurde */

    @Test
    public void getKundeName() throws PersistenceException, UserException {
        Kunde4Public temp = ((PersistentKundenManager)kundeMan).getKundenListe().findFirst(x -> {
            return ((PersistentKunde)x).getBenutzername().equals("test");
        });
        Assert.assertEquals("test", ((PersistentKunde) temp).getBenutzername());
    }

    @Test
    public void getPasswort() throws PersistenceException, UserException {
        Kunde4Public temp = ((PersistentKundenManager)kundeMan).getKundenListe().findFirst(x -> {
            return ((PersistentKunde)x).getBenutzername().equals("test");
        });
        Assert.assertEquals("test", ((PersistentKunde) temp).getPasswort());
    }
}
