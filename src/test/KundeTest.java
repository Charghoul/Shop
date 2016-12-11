package test;

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
public class KundeTest {

    private static Kunde4Public kunde;

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

        kunde = model.Kunde.createKunde("test", "test");
    }

    /* Überprüft ob der Kunde korrekt angelegt wurde */

    @Test
    public void getKundeName() throws PersistenceException, UserException {
        Assert.assertEquals("test", ((PersistentKunde) kunde).getBenutzername());
    }

    @Test
    public void getPasswort() throws PersistenceException, UserException {
        Assert.assertEquals("test", ((PersistentKunde) kunde).getPasswort());
    }
}
