package test;

import model.ArtikelManager;
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
public class WarenlagerTest {

    private static Warenlager4Public warenlager;

    private static Artikel4Public artikel1;
    private static Position4Public position1;

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

        ArtikelManager.getTheArtikelManager().neuerArtikel("1", "test", 10, 10, 100, 3);
        artikel1 = ((PersistentArtikelManager)ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
            return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });

        position1 = model.Position.createPosition(artikel1, 1);

        warenlager = model.Warenlager.getTheWarenlager();
    }

    /**
     * Artikel1 wird mit 10 Einheiten eingelagert
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelEinlagern() throws PersistenceException, UserException {
        warenlager.artikelEinlagern(artikel1, 10);
        Position4Public temp = warenlager.getWarenListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException{
                return argument.getArtikel().equals(artikel1);
            }
        });
        Assert.assertEquals( 10, temp.getMenge());
    }

    /**
     * Artikel soll mehr eingelagert werden als der maximale Lagerbestand her gibt
     * Wirft Fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandOverMax.class)
    public void artikelEinlagernFail() throws PersistenceException, UserException {
        warenlager.artikelEinlagern(artikel1, artikel1.getMaxLagerbestand()+1);
    }

    /**
     * Ein Artiekel wird mit der Menge 10 eingelagert
     * Dann wird der Artikel wieder entfernt
     * Nach der Position mit dem Aritkel wird gesucht und in <temp> gespeichert
     * Keine Position mit dem Artikel vorhanden also:
     * temp == 0
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelEntfernen() throws PersistenceException, UserException {
        warenlager.artikelEinlagern(artikel1, 10);
        Position4Public temp = warenlager.getWarenListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel1);
            }
        });
        warenlager.artikelEntfernen(temp);
        temp = warenlager.getWarenListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel1);
            }
        });
        Assert.assertEquals(null, temp);
    }

    /**
     * ein Artikel wird mit der Menge 20 eingelagert
     * dann werden 10 Einheiten entommen
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelEntnehmen() throws PersistenceException, UserException {
        warenlager.artikelEinlagern(artikel1, 20);
        warenlager.artikelEntnehmen(artikel1, 10);
        Position4Public temp = warenlager.getWarenListe().findFirst(new Predcate<Position4Public>() {
            @Override
            public boolean test(Position4Public argument) throws PersistenceException {
                return argument.getArtikel().equals(artikel1);
            }
        });
        Assert.assertEquals(10, temp.getMenge());
    }

    /**
     * ein Artikel wird bis zum MaximalLagerbestand eingelagert
     * dann wird der Maximallagerbestand um 1 mehr entnommen
     * Wirft fehler
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcLagerbestandUnderZero.class)
    public void artikelEntnehmenFail() throws PersistenceException, UserException {
        warenlager.artikelEinlagern(artikel1, artikel1.getMaxLagerbestand());
        warenlager.artikelEntnehmen(artikel1, artikel1.getMaxLagerbestand()+1);
    }
}
