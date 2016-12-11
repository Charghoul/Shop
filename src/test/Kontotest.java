package test;

import model.ExcAuszahlungGroesserGutgaben;
import model.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;

/**
 * Created by Jan on 20.11.2016.
 */
public class Kontotest {

    private static Konto4Public konto;
    private static ServiceKunde4Public kundeServ;

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
        kundeServ = model.ServiceKunde.createServiceKunde();
        konto = kundeServ.getKonto();
    }

    /* überprüft die Standardwerte eines Kontos */

    @Test
    public void getKontostand() throws PersistenceException, UserException {
        Assert.assertEquals(4999, ((PersistentKonto)konto).getKontostand());
    }

    @Test
    public void getLimit() throws PersistenceException, UserException {
        Assert.assertEquals(0, ((PersistentKonto)konto).getLimit());
    }

    @Test
    public void getReserviert() throws PersistenceException, UserException {
        Assert.assertEquals(0, ((PersistentKonto)konto).getReserviert());
    }

    /* Ab hier werden methoden zum Ändern der Werte der Attribute des Kontos ausgeführt */

    /**
     * bucht das Gesamte Guthaben vom Konto ab
     * @throws ExcAuszahlungGroesserGutgaben
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void abbuchen1() throws ExcAuszahlungGroesserGutgaben, PersistenceException, UserException {
        konto.abbuchen(konto.getKontostand());
        Assert.assertEquals(0, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * bucht 1 Cent vom Konto ab
     * @throws ExcAuszahlungGroesserGutgaben
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void abbuchen2() throws ExcAuszahlungGroesserGutgaben, PersistenceException, UserException {
        konto.abbuchen(1);
        Assert.assertEquals(4998, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * versucht den Kontostand+1 abzubuchen
     * In Liveumgebung nicht möglich
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void abbuchenFail() throws PersistenceException, UserException {
        konto.abbuchen(konto.getKontostand()+1);
        Assert.assertEquals(-1, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * Lässt sich das gesamte Guthaben vom Konto auszahlen
     * @throws ExcAuszahlungGroesserGutgaben
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void auszahlen1() throws ExcAuszahlungGroesserGutgaben, PersistenceException, UserException {
        konto.auszahlen(konto.getKontostand());
        Assert.assertEquals(0, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * Lässt sich 1 Cent vom Konto auszahlen
     * @throws ExcAuszahlungGroesserGutgaben
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void auszahlen2() throws ExcAuszahlungGroesserGutgaben, PersistenceException, UserException {
        konto.auszahlen(1);
        Assert.assertEquals(4998, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * Versucht Kontostand+a auszuzahlen
     * Wirft Fehler ExcAuszahlungGroesserGutgaben
     * @throws ExcAuszahlungGroesserGutgaben
     * @throws PersistenceException
     * @throws UserException
     */
    @Test(expected = ExcAuszahlungGroesserGutgaben.class)
    public void auszahlenFail() throws PersistenceException, UserException {
        konto.auszahlen(konto.getKontostand()+1);
    }

    /**
     * Zahlt 1 Cent in das Konto ein
     * @throws PersistenceException
     */
    @Test
    public void einzahlen1() throws PersistenceException {
        konto.einzahlen(1);
        Assert.assertEquals(5000, ((PersistentKonto)konto).getKontostand());
    }

    /**
     * Zahlt 10000 Cent in das Konto ein
     * @throws PersistenceException
     */
    @Test
    public void einzahlen2() throws PersistenceException {
        konto.einzahlen(10000);
        Assert.assertEquals(14999, ((PersistentKonto)konto).getKontostand());
    }


    /**
     * Ändert den reservierten Betrag auf 100 Cent (1 Euro)
     * @throws PersistenceException
     */
    @Test
    public void reserviere1() throws PersistenceException {
        konto.reserviere(1);
        Assert.assertEquals(1, ((PersistentKonto)konto).getReserviert());
    }

    /**
     * Ändert den reservierten Betrag auf 100 Cent (1 Euro)
     * @throws PersistenceException
     */
    @Test
    public void reserviere2() throws PersistenceException {
        konto.reserviere(konto.getKontostand());
        Assert.assertEquals(4999, ((PersistentKonto)konto).getReserviert());
    }

    /**
     * Ändert den reservierten Betrag auf den Wert des Kontostandes plus 1
     * Ist in der Liveumgebung eine Operation, die vom System aus läuft und nicht manuell geändert werden kann
     * geht also live nicht über den Kontostand hinaus
     * @throws PersistenceException
     */
    @Test
    public void reserviereFail() throws PersistenceException {
        konto.reserviere(konto.getKontostand()+1);
        Assert.assertEquals(5000, ((PersistentKonto)konto).getReserviert());
    }

    /**
     * Setzt den reservierten Betrag auf 100 Cent und verringert diesen dann um 10 Cent
     * @throws PersistenceException
     */
    @Test
    public void verringereReserviert1() throws PersistenceException {
        konto.reserviere(100);
        konto.verringereReserviert(10);
        Assert.assertEquals(90, ((PersistentKonto)konto).getReserviert());
    }

    /**
     * Setzt den reservierten Betrag auf 100 Cent und verringert diesen dann um den reservierten Wert
     * @throws PersistenceException
     */
    @Test
    public void verringereReserviert2() throws PersistenceException {
        konto.reserviere(100);
        konto.verringereReserviert(konto.getReserviert());
        Assert.assertEquals(0, ((PersistentKonto)konto).getReserviert());
    }

    /**
     * Versucht den reservierten Betrag zu verringern um den reserviert+1
     * Ist in der Liveumgebung eine Operation, die vom System aus läuft und nicht manuell geändert werden kann
     * geht also live nicht unter null
     * @throws PersistenceException
     */
    @Test
    public void verringereReserviertFail() throws PersistenceException {
        konto.reserviere(100);
        konto.verringereReserviert(konto.getReserviert()+1);
        Assert.assertEquals(-1, ((PersistentKonto)konto).getReserviert());
    }
}
