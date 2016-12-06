package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.PersistentArtikel;
import persistence.PersistentPosition;
import persistence.Position4Public;

/**
 * Created by Jan on 04.12.2016.
 */


public class Position {


    @BeforeClass
    public static void init() throws Exception{
        TestSupport.prepareDatabase();
        TestSupport.prepareSingletons();
        PersistentPosition persP = (PersistentPosition)new Position();
        PersistentArtikel persA = (PersistentArtikel) new Artikel();
        persA.setPreis(2);
        persA.setArtikelnummer("1234");
        persA.setBezeichnung("TestArtikel");
        persA.setHstLieferzeit(2);
        persA.setMaxLagerbestand(100);
        persA.setMinLagerbestand(10);
        persP.setMenge(5);
        persP.setArtikel(persA);
    }

    @Before
    public void initEach() throws Exception{
        TestSupport.clearDatabase();
    }

    @Test
    public void verringereMenge() throws Exception {

    }
}
