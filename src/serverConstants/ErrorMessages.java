package serverConstants;

/**
 * Created by Jan on 08.11.2016.
 */
public class ErrorMessages {

    public static final String DoubleDefinitionMessage = "Ein Account mit diesem Namen existiert bereits";
    public static final String AccountNotFoundMessage = "Ein Account mit diesem Namen existiert nicht";
    public static final String ArtikelAlreadyExists= "Ein Artikel mit dieser Artikelnummer existiert bereits";
    public static final String LieferArtAlreadyExists = "Eine Lieferzeit mit diesem Namen existiert bereits";
    public static final String StatusDidNotChange = "Der Artikel ist bereits in diesem Status";
    public static final String ArtikelAlreadyInBasket = "Der Artikel ist schon im Einkaufswagen";
    public static final String LagerbestandUnderZero = "Negativer Lagerbestand nicht möglich!";
    public static final String LagerbestandOverMax = "maximale Lagerkapazitäten erreicht";
    public static final String HerstellerAlreadyExists = "Dieser Hersteller existiert bereits";
    public static final String StatusUbersprungen = "Status wurde uebersprungen";
    public static final String ProduktgruppeAlreadyExists = "Diese Produktgruppe existiert bereits";
    public static final String ArtikelAlreadyInProduktListe = "Dieses Produkt ist bereits in dieser Produktliste enthalten";

    private ErrorMessages(){}
}
