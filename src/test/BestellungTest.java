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
public class BestellungTest {

    private static Bestellung4Public bestellung;

    private static ServiceKunde4Public servKunde;
    private static BestellManager4Public bestellMan;

    private static Lieferart4Public lieferart;

    private static Bestellstatus4Public hinversand;
    private static Bestellstatus4Public geliefert;
    private static Bestellstatus4Public angenommen;
    private static Bestellstatus4Public rueckversand;

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

        //Bestellstati zum Testen vorbereiten
        hinversand = Hinversand.getTheHinversand();
        geliefert = Geliefert.getTheGeliefert();
        angenommen = Angenommen.getTheAngenommen();
        rueckversand = Rueckversand.getTheRueckversand();

        servKunde = ServiceKunde.createServiceKunde();
        bestellMan = BestellManager.createBestellManager(servKunde.getKonto());

        lieferart = Lieferart.createLieferart("express", 3, 499);

        //Bestellung anlegen
        bestellung = Bestellung.createBestellung(bestellMan, 10, lieferart, 1);
    }

    @Test
    public void annehmen() throws PersistenceException, UserException {
        bestellung.annehmen();
        Assert.assertEquals(angenommen, bestellung.getBestellstatus());
    }

    @Test
    public void aendereBestellstatus2() throws PersistenceException, UserException {
        bestellung.aendereStatus(Hinversand.getTheHinversand());
        Assert.assertEquals(hinversand, bestellung.getBestellstatus());
    }

    @Test
    public void aendereBestellstatus3() throws PersistenceException, UserException {
        bestellung.aendereStatus(Geliefert.getTheGeliefert());
        Assert.assertEquals(geliefert, bestellung.getBestellstatus());
    }

    @Test
    public void aendereBestellstatus4() throws PersistenceException, UserException {
        bestellung.aendereStatus(Angenommen.getTheAngenommen());
        Assert.assertEquals(angenommen, bestellung.getBestellstatus());
    }

    @Test
    public void aendereBestellstatus5() throws PersistenceException, UserException {
        bestellung.aendereStatus(Rueckversand.getTheRueckversand());
        Assert.assertEquals(rueckversand, bestellung.getBestellstatus());
    }

    /**
     * lieferart = 499 -> bestellungWarenwert = 499
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void berechneWarenwert() throws PersistenceException, UserException {
        bestellung.berechneWarenwert();
        Assert.assertEquals(499, bestellung.getWarenwert());
    }
}
