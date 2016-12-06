package serverConstants;

/**
 * Created by Jan on 08.11.2016.
 */
public class ErrorMessages {

    public static final String DoubleDefinitionMessage = "Ein Account mit diesem Namen existiert bereits";
    public static final String ArtikelAlreadyExists= "Ein Artikel mit dieser Artikelnummer existiert bereits";
    public static final String LieferArtAlreadyExists = "Eine Lieferzeit mit diesem Namen existiert bereits";
    public static final String StatusDidNotChange = "Der Artikel ist bereits in diesem Status";
    public static final String ArtikelAlreadyInBasket = "Der Artikel ist schon im Einkaufswagen";
    public static final String LagerbestandUnderZero = "Negativer Lagerbestand ist nicht erlaubt!";
    public static final String LagerbestandOverMax = "Der maximale Lagerbestand wurde überschritten";
    public static final String HerstellerAlreadyExists = "Dieser Hersteller existiert bereits";
    public static final String StatusUbersprungen = "Status wurde übersprungen";
    public static final String ProduktgruppeAlreadyExists = "Diese Produktgruppe existiert bereits";
    public static final String ArtikelAlreadyInProduktListe = "Dieses Produkt ist bereits in dieser Produktliste enthalten";
    public static final String ProduktgruppeHasNoParent = "Diese Produktgruppe ist der Katalog und daher nicht löschbar";
    public static final String ArtikelNichtVerfuegbar = " ist nicht ausreichend verfügbar";
    public static final String ArtikelHatKeinenHerstellerNachlieferung = "Ein Artikel ohne Hersteller kann nicht nachgeliefert werden";
    public static final String ArtikelHatKeinenHerstellerVerkauf = "Ein Artikel ohne Hersteller kann nicht verkauft werden";
    public static final String ArtikelNochNichtVerfuegbar = "Dieser Artikel steht in naher Zukunft zum Verkauf bereit";
    public static final String WarenwertUeberKontoguthaben = "Der Warenwert der Bestellung (zzgl. Vorbestellungen) liegt über ihrem Kontoguthaben";
    public static final String AuszahlungGroesserGuthaben= "Die Auszahlungssumme ist grösser als ihr aktuelles Guthaben";
    public static final String LagerbestandMinGroesserMax = "Der minimale Lagerbestand darf nicht grösser als der maximale sein";
    public static final String ArtikelDoesNotExist = "Ein Artikel mit dieser Bezeichung existiert nicht";
    public static final String ArtikelMitDiesemHerstellerExistiertBereits = "Ein Artikel mit dieser Bezeichung und diesem Hersteller existiert bereits";

    private ErrorMessages(){}
}
