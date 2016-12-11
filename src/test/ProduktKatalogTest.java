package test;

import model.ArtikelManager;
import model.ExcAlreadyExists;
import model.Produktgruppe;
import model.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class ProduktKatalogTest {

    private static Produktgruppe4Public testproduktgrp;

    private static ProduktKatalog4Public katalog;

    private static Artikel4Public artikel1;

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

        ArtikelManager.getTheArtikelManager().neuerArtikel("1", "test1", 10, 10, 100, 3);
        artikel1 = ((PersistentArtikelManager) ArtikelManager.getTheArtikelManager()).getArtikelListe().findFirst(x -> {
           return ((PersistentArtikel)x).getArtikelnummer().equals("1");
        });

        testproduktgrp = Produktgruppe.createProduktgruppe("testgrp");
        katalog = model.ProduktKatalog.getTheProduktKatalog();
    }

    /**
     * hängt einen Artikel an die Produktgruppe an
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelAnhaengen() throws PersistenceException, UserException {
        katalog.artikelAnhaengen(testproduktgrp, artikel1);
        Komponente4Public temp = ((PersistentProduktgruppe)testproduktgrp).getKomponentenListe().findFirst(new Predcate<Komponente4Public>() {
            @Override
            public boolean test(Komponente4Public argument) throws PersistenceException {
                return argument.equals(artikel1);
            }
        });
        Assert.assertEquals(artikel1, temp);
    }

    /**
     * Versucht zweimal den selben artikel an die selbe produktgruppe anzuhängen
     * Wirf Fehler, ExcAlreadyExists
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcAlreadyExists.class)
    public void artikelAnhaengenFail() throws PersistenceException, UserException {
        katalog.artikelAnhaengen(testproduktgrp, artikel1);
        katalog.artikelAnhaengen(testproduktgrp, artikel1);
    }

    /**
     * Hängt einen Artikel an die Produktgruppe an und dann wieder ab
     * Die suche nach dem Artikel in der Produktgruppe ergibt null, als
     * temp = null, was erwartet wird
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelAbhaengen() throws PersistenceException, UserException {
        katalog.artikelAnhaengen(testproduktgrp, artikel1);
        katalog.artikelAbhaengen(testproduktgrp, artikel1);
        Komponente4Public temp = ((PersistentProduktgruppe) testproduktgrp).getKomponentenListe().findFirst(new Predcate<Komponente4Public>() {
            @Override
            public boolean test(Komponente4Public argument) throws PersistenceException {
                return argument.equals(artikel1);
            }
        });
        Assert.assertEquals(null, temp);
    }

    /**
     * Es wird eine neue Produktgruppe hinzugefügt mit dem Namen "testgrp2"
     * Diese wird in der Komponentenliste gesucht und in <temp> gepseichert
     * nun wird der Name von <temp> gegen "testgrp2" geprüft
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void produktgruppeHinzufuegen() throws PersistenceException, UserException {
        ((PersistentProduktKatalog)katalog).produktgruppeHinzufuegen((PersistentProduktgruppe)testproduktgrp, "testgrp2");
        Komponente4Public temp = ((PersistentProduktgruppe)testproduktgrp).getKomponentenListe().findFirst(x -> {
            return ((PersistentProduktgruppe)x).getName().equals("testgrp2");
        });
        Assert.assertEquals("testgrp2", ((PersistentProduktgruppe)temp).getName());
    }

    /**
     * Es wird nach Produktgruppen mit dem Namen "testgrp2" gesucht
     * nicht gefunden also null in temp speichern
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void produktgruppeHinzufuegenFail1() throws PersistenceException, UserException {
        Komponente4Public temp = ((PersistentProduktgruppe)testproduktgrp).getKomponentenListe().findFirst(x -> {
            return ((PersistentProduktgruppe)x).getName().equals("testgrp2");
        });
        Assert.assertEquals(null , temp);
    }

    /**
     * Hinzufügen einer Gruppe, die bereits existiert
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcAlreadyExists.class)
    public void produktgruppeHinzufuegenFail2() throws PersistenceException, UserException {
        katalog.produktgruppeHinzufuegen((PersistentProduktgruppe)testproduktgrp, "testgrp");
    }
}
