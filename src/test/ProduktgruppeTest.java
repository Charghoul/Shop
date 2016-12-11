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
public class ProduktgruppeTest {

    private static Produktgruppe4Public testproduktgrp;

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
    }

    /* Überprüfen der Attribute von <testproduktgrp> */

    @Test
    public void getProdGrpName() throws PersistenceException, UserException {
        Assert.assertEquals("testgrp", ((PersistentProduktgruppe)testproduktgrp).getName());
    }

    /* Methoden auf <testproduktgrp> anwenden */

    /**
     * ein Artikel wird an die Produktgruppe angehängt
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelAnhaengen() throws PersistenceException, UserException {
        testproduktgrp.artikelAnhaengen(artikel1);
        Komponente4Public temp = ((PersistentProduktgruppe)testproduktgrp).getKomponentenListe().findFirst(new Predcate<Komponente4Public>() {
            @Override
            public boolean test(Komponente4Public argument) throws PersistenceException {
                return argument.equals(artikel1);
            }
        });
        Assert.assertEquals(artikel1, temp);
    }

    /**
     * Versucht zweimal den selben Artikel an die Produktgruppe anzuhängen
     * Wirf Fehler ExcAlreadyExists
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcAlreadyExists.class)
    public void artikelAnheangenFail() throws PersistenceException, UserException {
        testproduktgrp.artikelAnhaengen(artikel1);
        testproduktgrp.artikelAnhaengen(artikel1);
    }

    /**
     * Es wird <artikel> an die Produktgruppe angehängt
     * Dann wird der Artikel wieder abgehängt
     * <temp> wird nun mit einem Null-Wert erwartet
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void artikelAbhaengen() throws PersistenceException, UserException {
        testproduktgrp.artikelAnhaengen(artikel1);
        testproduktgrp.artikelAbhaengen(artikel1);
        Komponente4Public temp = ((PersistentProduktgruppe) testproduktgrp).getKomponentenListe().findFirst(new Predcate<Komponente4Public>() {
            @Override
            public boolean test(Komponente4Public argument) throws PersistenceException {
                return argument.equals(artikel1);
            }
        });
        Assert.assertEquals(null, temp);
    }

    /**
     * legt eine neue Produktgruppe mit dem Namen "testgrp2" an
     * sucht diese aus der KomponentenListe heraus und speichert sie in temp
     * vergleicht den Namen von temp mit "testgrp2"
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void produktgruppeHinzufuegen() throws PersistenceException, UserException {
        ((PersistentProduktgruppe)testproduktgrp).produktgruppeHinzufuegen("testgrp2");
        Komponente4Public temp = ((PersistentProduktgruppe)testproduktgrp).getKomponentenListe().findFirst(x -> {
            return ((PersistentProduktgruppe)x).getName().equals("testgrp2");
        });
        Assert.assertEquals("testgrp2", ((PersistentProduktgruppe)temp).getName());
    }

    /**
     * sucht in der KomponentenListe nach einer Produktgruppe mit dem Namen "testgrp2"
     * speichert diese in temp
     * es wird erwartet, dass temp = null
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
        testproduktgrp.produktgruppeHinzufuegen("testgrp");
    }
}