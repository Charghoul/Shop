package test;

import common.Fraction;
import model.ArtikelManager;
import model.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.Artikel4Public;
import persistence.PersistenceException;
import persistence.PersistentArtikel;
import persistence.PersistentArtikelManager;

/**
 * Created by Jan on 20.11.2016.
 */
public class Artikel {

    @BeforeClass
    public static void init() throws Exception{
        TestSupport.prepareDatabase();
        TestSupport.prepareSingletons();
        ArtikelManager.getTheArtikelManager().neuerArtikel("1234", "test", 999, 5, 100, 3);
    }

    @Before
    public void initEach() throws Exception{
        TestSupport.clearDatabase();
    }

    @Test
    public void neuerArtikel() throws PersistenceException, UserException {
        //Kommentar für Dennis: immer auf persistent*** casten, damit man auf alle attribute des objekts zugreifen kann

        Artikel4Public temp = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getBezeichnung().equals("test");
        });
        Assert.assertEquals( "test",((PersistentArtikel)temp).getBezeichnung());
    }
}
