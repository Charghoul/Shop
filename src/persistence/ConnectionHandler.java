package persistence;

import java.util.Hashtable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConnectionHandler {

	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();

	private static ConnectionHandler theConnectionHandler;

	public static void disconnect() throws PersistenceException {
	}
	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler();
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		connections.remove(Thread.currentThread());
	}

	protected static ConnectionHandler getDefaultConnectionHandler() throws PersistenceException{
		if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
		return theConnectionHandler;
	}
	
	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}

	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}



    public ServerFacade theServerFacade;
    public ArtikelEntfernenCommandFacade theArtikelEntfernenCommandFacade;
    public EinkaufsManagerFacade theEinkaufsManagerFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ServiceAdminZeitManagerFacade theServiceAdminZeitManagerFacade;
    public ArtikelEntnehmenCommandFacade theArtikelEntnehmenCommandFacade;
    public HerstellerManagerFacade theHerstellerManagerFacade;
    public LieferartFacade theLieferartFacade;
    public RegisterCommandFacade theRegisterCommandFacade;
    public deactivatedFacade thedeactivatedFacade;
    public NeuanlageFacade theNeuanlageFacade;
    public ServiceRegisterFacade theServiceRegisterFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public HstLieferungFacade theHstLieferungFacade;
    public KndLieferungFacade theKndLieferungFacade;
    public ServiceKundeFacade theServiceKundeFacade;
    public KndAnnahmeFacade theKndAnnahmeFacade;
    public ZuEinkaufswHinzCommandFacade theZuEinkaufswHinzCommandFacade;
    public ProduktKatalogFacade theProduktKatalogFacade;
    public BestellstatusFacade theBestellstatusFacade;
    public ServiceShopProduktKatalogFacade theServiceShopProduktKatalogFacade;
    public ArtikelFacade theArtikelFacade;
    public ProduktgruppeFacade theProduktgruppeFacade;
    public StatusFacade theStatusFacade;
    public PositionFacade thePositionFacade;
    public ServiceAdminFacade theServiceAdminFacade;
    public ArtikelManagerFacade theArtikelManagerFacade;
    public ProduktgruppeEntfernenCommandFacade theProduktgruppeEntfernenCommandFacade;
    public StatusVerkaufCommandFacade theStatusVerkaufCommandFacade;
    public KontoFacade theKontoFacade;
    public HerstellerFacade theHerstellerFacade;
    public AngenommenFacade theAngenommenFacade;
    public ZuruecksendenCommandFacade theZuruecksendenCommandFacade;
    public BestellenCommandFacade theBestellenCommandFacade;
    public WarenlagerFacade theWarenlagerFacade;
    public CommonDateFacade theCommonDateFacade;
    public VorbestellenCommandFacade theVorbestellenCommandFacade;
    public VerkaufFacade theVerkaufFacade;
    public PositionAbstraktFacade thePositionAbstraktFacade;
    public AuslaufFacade theAuslaufFacade;
    public VerarbeitungFacade theVerarbeitungFacade;
    public BestellungFacade theBestellungFacade;
    public ServiceKundeBestellManagerFacade theServiceKundeBestellManagerFacade;
    public KomponenteFacade theKomponenteFacade;
    public ServiceShopFacade theServiceShopFacade;
    public ZeitManagerZeitObjektListeFacade theZeitManagerZeitObjektListeFacade;
    public ArtikelEinlagernCommandFacade theArtikelEinlagernCommandFacade;
    public GeliefertFacade theGeliefertFacade;
    public ZeitObjektFacade theZeitObjektFacade;
    public ServiceFacade theServiceFacade;
    public BestellManagerFacade theBestellManagerFacade;
    public StatusAuslaufCommandFacade theStatusAuslaufCommandFacade;
    public NeuerArtikelCommandFacade theNeuerArtikelCommandFacade;
    public ZeitManagerFacade theZeitManagerFacade;
    public SubjFacade theSubjFacade;
    public PositionInBestellungFacade thePositionInBestellungFacade;
    public VorbestellungFacade theVorbestellungFacade;
    public KundeFacade theKundeFacade;
    public RueckversandFacade theRueckversandFacade;
    public LieferartManagerFacade theLieferartManagerFacade;
    public HinversandFacade theHinversandFacade;
    public AllesZuruecksendenCommandFacade theAllesZuruecksendenCommandFacade;
    public IntegerWrapperFacade theIntegerWrapperFacade;
    public ArtikelstatusFacade theArtikelstatusFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public activatedFacade theactivatedFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theServerFacade= new ServerFacade();
            this.theArtikelEntfernenCommandFacade= new ArtikelEntfernenCommandFacade();
            this.theEinkaufsManagerFacade= new EinkaufsManagerFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theServiceAdminZeitManagerFacade= new ServiceAdminZeitManagerFacade();
            this.theArtikelEntnehmenCommandFacade= new ArtikelEntnehmenCommandFacade();
            this.theHerstellerManagerFacade= new HerstellerManagerFacade();
            this.theLieferartFacade= new LieferartFacade();
            this.theRegisterCommandFacade= new RegisterCommandFacade();
            this.thedeactivatedFacade= new deactivatedFacade();
            this.theNeuanlageFacade= new NeuanlageFacade();
            this.theServiceRegisterFacade= new ServiceRegisterFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theHstLieferungFacade= new HstLieferungFacade();
            this.theKndLieferungFacade= new KndLieferungFacade();
            this.theServiceKundeFacade= new ServiceKundeFacade();
            this.theKndAnnahmeFacade= new KndAnnahmeFacade();
            this.theZuEinkaufswHinzCommandFacade= new ZuEinkaufswHinzCommandFacade();
            this.theProduktKatalogFacade= new ProduktKatalogFacade();
            this.theBestellstatusFacade= new BestellstatusFacade();
            this.theServiceShopProduktKatalogFacade= new ServiceShopProduktKatalogFacade();
            this.theArtikelFacade= new ArtikelFacade();
            this.theProduktgruppeFacade= new ProduktgruppeFacade();
            this.theStatusFacade= new StatusFacade();
            this.thePositionFacade= new PositionFacade();
            this.theServiceAdminFacade= new ServiceAdminFacade();
            this.theArtikelManagerFacade= new ArtikelManagerFacade();
            this.theProduktgruppeEntfernenCommandFacade= new ProduktgruppeEntfernenCommandFacade();
            this.theStatusVerkaufCommandFacade= new StatusVerkaufCommandFacade();
            this.theKontoFacade= new KontoFacade();
            this.theHerstellerFacade= new HerstellerFacade();
            this.theAngenommenFacade= new AngenommenFacade();
            this.theZuruecksendenCommandFacade= new ZuruecksendenCommandFacade();
            this.theBestellenCommandFacade= new BestellenCommandFacade();
            this.theWarenlagerFacade= new WarenlagerFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theVorbestellenCommandFacade= new VorbestellenCommandFacade();
            this.theVerkaufFacade= new VerkaufFacade();
            this.thePositionAbstraktFacade= new PositionAbstraktFacade();
            this.theAuslaufFacade= new AuslaufFacade();
            this.theVerarbeitungFacade= new VerarbeitungFacade();
            this.theBestellungFacade= new BestellungFacade();
            this.theServiceKundeBestellManagerFacade= new ServiceKundeBestellManagerFacade();
            this.theKomponenteFacade= new KomponenteFacade();
            this.theServiceShopFacade= new ServiceShopFacade();
            this.theZeitManagerZeitObjektListeFacade= new ZeitManagerZeitObjektListeFacade();
            this.theArtikelEinlagernCommandFacade= new ArtikelEinlagernCommandFacade();
            this.theGeliefertFacade= new GeliefertFacade();
            this.theZeitObjektFacade= new ZeitObjektFacade();
            this.theServiceFacade= new ServiceFacade();
            this.theBestellManagerFacade= new BestellManagerFacade();
            this.theStatusAuslaufCommandFacade= new StatusAuslaufCommandFacade();
            this.theNeuerArtikelCommandFacade= new NeuerArtikelCommandFacade();
            this.theZeitManagerFacade= new ZeitManagerFacade();
            this.theSubjFacade= new SubjFacade();
            this.thePositionInBestellungFacade= new PositionInBestellungFacade();
            this.theVorbestellungFacade= new VorbestellungFacade();
            this.theKundeFacade= new KundeFacade();
            this.theRueckversandFacade= new RueckversandFacade();
            this.theLieferartManagerFacade= new LieferartManagerFacade();
            this.theHinversandFacade= new HinversandFacade();
            this.theAllesZuruecksendenCommandFacade= new AllesZuruecksendenCommandFacade();
            this.theIntegerWrapperFacade= new IntegerWrapperFacade();
            this.theArtikelstatusFacade= new ArtikelstatusFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theactivatedFacade= new activatedFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

