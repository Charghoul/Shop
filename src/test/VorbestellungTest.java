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
public class VorbestellungTest {

    private static Vorbestellung4Public vorbestellung;

    private static ServiceKunde4Public servKunde;
    private static BestellManager4Public bestellMan;
    private static EinkaufsManager4Public einkMan;

    private static Lieferart4Public lieferart;

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

        servKunde = ServiceKunde.createServiceKunde();
        bestellMan = BestellManager.createBestellManager(servKunde.getKonto());
        einkMan = EinkaufsManager.createEinkaufsManager(bestellMan);

        lieferart = Lieferart.createLieferart("express", 3, 499);

        vorbestellung = ((PersistentBestellManager)bestellMan).neueVorbestellung(einkMan.getEinkaufsListe().getList(), einkMan.gibGesamtPreis(), lieferart);
    }

    /**
     * lässt die <vorbestellung> stornieren
     * sucht dann in der Liste des BestellManagers nach der Vorbestellung und speichert in temp
     * daher temp == null
     * @throws PersistenceException
     * @throws UserException
     */
    @Test
    public void stornieren() throws PersistenceException, UserException {
        vorbestellung.stornieren();
        Vorbestellung4Public temp = ((PersistentBestellManager)bestellMan).getVorbestellListe().findFirst(new Predcate<Vorbestellung4Public>() {
            @Override
            public boolean test(Vorbestellung4Public argument) throws PersistenceException {
                return argument.getBestellManager().equals(bestellMan);
            }
        });
        Assert.assertEquals(null, temp);
    }
}
