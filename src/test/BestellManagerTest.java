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
public class BestellManagerTest {

    private static Vorbestellung4Public vorbestellung;

    private static ServiceKunde4Public servKunde;
    private static ServiceKunde4Public servKundeTest;
    private static BestellManager4Public bestellMan;
    private static BestellManager4Public bestellManTest;
    private static EinkaufsManager4Public einkMan;
    private static EinkaufsManager4Public einkManTest;

    private static Lieferart4Public lieferart;

    private static Bestellstatus4Public hinversand;

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

        //Bestellstatus zum Testen vorbereiten
        hinversand = Hinversand.getTheHinversand();

        servKunde = ServiceKunde.createServiceKunde();
        bestellMan = BestellManager.createBestellManager(servKunde.getKonto());
        einkMan = EinkaufsManager.createEinkaufsManager(bestellMan);

        lieferart = Lieferart.createLieferart("express", 3, 499);

        servKundeTest = ServiceKunde.createServiceKunde();
        bestellManTest = BestellManager.createBestellManager(servKundeTest.getKonto());
        einkManTest = EinkaufsManager.createEinkaufsManager(bestellManTest);
        bestellManTest.neueVorbestellung(einkMan.getEinkaufsListe().getList(), einkMan.gibGesamtPreis(), lieferart);
        vorbestellung = ((PersistentBestellManager)bestellManTest).getVorbestellListe().findFirst(new Predcate<Vorbestellung4Public>() {
            @Override
            public boolean test(Vorbestellung4Public argument) throws PersistenceException {
                return argument.getBestellManager().equals(bestellManTest);
            }
        });
    }

    /**
     * Legt eine neue Bestellung an und prüft, ob diese angelegt wurde
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neueBestellung() throws PersistenceException, UserException {
        bestellMan.neueBestellung(einkMan.getEinkaufsListe().getList(), einkMan.gibGesamtPreis(), lieferart);
        Bestellung4Public temp = ((PersistentBestellManager)bestellMan).getBestellListe().findFirst(new Predcate<Bestellung4Public>() {
            @Override
            public boolean test(Bestellung4Public argument) throws PersistenceException {
                return argument.getBestellstatus().equals(hinversand);
            }
        });
        Assert.assertEquals(499, temp.berechneWarenwert());
    }

    /**
     * sucht nach Bestellungen im Hinversand, obwohl keine angelegt wurden
     * erwartet temp == null
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neueBestellungFail() throws PersistenceException, UserException {
        Bestellung4Public temp = ((PersistentBestellManager)bestellMan).getBestellListe().findFirst(new Predcate<Bestellung4Public>() {
            @Override
            public boolean test(Bestellung4Public argument) throws PersistenceException {
                return argument.getBestellstatus().equals(bestellMan);
            }
        });
        Assert.assertEquals(null, temp);
    }

    /**
     * erstellt eine neue Vorberstellung
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neueVorbestellung() throws PersistenceException, UserException {
        bestellMan.neueVorbestellung(einkMan.getEinkaufsListe().getList(), einkMan.gibGesamtPreis(), lieferart);
        Vorbestellung4Public temp = ((PersistentBestellManager)bestellMan).getVorbestellListe().findFirst(new Predcate<Vorbestellung4Public>() {
            @Override
            public boolean test(Vorbestellung4Public argument) throws PersistenceException {
                return argument.getBestellManager().equals(bestellMan);
            }
        });
        Assert.assertEquals(vorbestellung, temp);
    }

    /**
     * sucht nach einer Vorbestellung um diese in <temp> zu speichern
     * keine Vorhanden also temp==null
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void neueVorbestellungFail() throws PersistenceException, UserException {
        Vorbestellung4Public temp = ((PersistentBestellManager)bestellMan).getVorbestellListe().findFirst(new Predcate<Vorbestellung4Public>() {
            @Override
            public boolean test(Vorbestellung4Public argument) throws PersistenceException {
                return argument.getBestellManager().equals(bestellMan);
            }
        });
        Assert.assertEquals(null, temp);
    }
}
