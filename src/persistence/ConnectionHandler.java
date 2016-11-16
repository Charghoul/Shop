package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ConnectionHandler {

	private static final String AutoCommitName = "AUTO COMMIT (DEFAULT)";
	
	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();
	
	private static ConnectionHandler theConnectionHandler;

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

	public static Vector<ConnectionHandler> getConnections(){
		Vector<ConnectionHandler> result = new Vector<ConnectionHandler>();
		Iterator<CommitConnectionHandler> committers = connections.values().iterator();
		while (committers.hasNext())result.add(committers.next());
		result.add(theConnectionHandler);
		return result;
	}
	public static void reinitialise() {
		connections = new Hashtable<Thread,CommitConnectionHandler>();
		theConnectionHandler = null;
	}
	
	public static void disconnect() throws PersistenceException{
		Iterator<CommitConnectionHandler> connectionIterator = connections.values().iterator();
		try {
			while (connectionIterator.hasNext()){
				ConnectionHandler current = (ConnectionHandler)connectionIterator.next();
				if(!current.con.isClosed())current.con.close();
			}
			if (theConnectionHandler != null && theConnectionHandler.con != null && !theConnectionHandler.con.isClosed()){
				theConnectionHandler.con.close();
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler(thread.getName());
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		try {
			CommitConnectionHandler connection = connections.get(Thread.currentThread());
			if (connection != null && !connection.con.isClosed()){
				connection.con.close();
				connections.remove(Thread.currentThread());
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}

	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler(AutoCommitName);
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}
	
	public static String asString (char[] pw) {
		String result = "";
		for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		}
		return result;
	}

	public static final String DatabaseProtocol = "jdbc:oracle:thin:@";

	private String schemaName;
	protected Connection con;
	private String name;

    public VerkaufFacade theVerkaufFacade;
    public ServerFacade theServerFacade;
    public EinkaufsManagerFacade theEinkaufsManagerFacade;
    public AuslaufFacade theAuslaufFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public FalseXFacade theFalseXFacade;
    public BestellungFacade theBestellungFacade;
    public ArtikelEntnehmenCommandFacade theArtikelEntnehmenCommandFacade;
    public HerstellerManagerFacade theHerstellerManagerFacade;
    public LieferartFacade theLieferartFacade;
    public RegisterCommandFacade theRegisterCommandFacade;
    public AendereArtikelCommandFacade theAendereArtikelCommandFacade;
    public NeuanlageFacade theNeuanlageFacade;
    public ServiceRegisterFacade theServiceRegisterFacade;
    public KomponenteFacade theKomponenteFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public GeliefertFacade theGeliefertFacade;
    public ServiceKundeFacade theServiceKundeFacade;
    public BestellstatusFacade theBestellstatusFacade;
    public ArtikelFacade theArtikelFacade;
    public ProduktgruppeFacade theProduktgruppeFacade;
    public PositionFacade thePositionFacade;
    public ServiceFacade theServiceFacade;
    public ServiceAdminFacade theServiceAdminFacade;
    public ArtikelManagerFacade theArtikelManagerFacade;
    public StatusAuslaufCommandFacade theStatusAuslaufCommandFacade;
    public NeuerArtikelCommandFacade theNeuerArtikelCommandFacade;
    public StatusVerkaufCommandFacade theStatusVerkaufCommandFacade;
    public KontoFacade theKontoFacade;
    public VorbestellungFacade theVorbestellungFacade;
    public KundeFacade theKundeFacade;
    public HerstellerFacade theHerstellerFacade;
    public RueckversandFacade theRueckversandFacade;
    public LieferartManagerFacade theLieferartManagerFacade;
    public ProdGEntfernenCommandFacade theProdGEntfernenCommandFacade;
    public HinversandFacade theHinversandFacade;
    public AngenommenFacade theAngenommenFacade;
    public LieferungFacade theLieferungFacade;
    public BooleanXFacade theBooleanXFacade;
    public WarenlagerFacade theWarenlagerFacade;
    public CommonDateFacade theCommonDateFacade;
    public ArtikelstatusFacade theArtikelstatusFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public TrueXFacade theTrueXFacade;

	protected ConnectionHandler(String name) throws PersistenceException {
		this.name = name;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public String getName(){
		return this.name;
	}
	
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
		try {
			this.schemaName = currentSchemaName;
			oracle.jdbc.driver.OracleConnection oracleConnection = (oracle.jdbc.driver.OracleConnection) DriverManager.getConnection(DatabaseProtocol + databaseName, user, asString(pw));
//			oracleConnection.setStatementCacheSize(1000);
//			oracleConnection.setImplicitCachingEnabled(true);
			this.con = new Connection(oracleConnection);
			this.con.setAutoCommit(autoCommit);
			CallableStatement callable = this.con.prepareCall("Begin " + this.schemaName + ".ClassFacade.initialize; end;");
			callable.execute();
			callable.close();
            this.theVerkaufFacade= new VerkaufFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theEinkaufsManagerFacade= new EinkaufsManagerFacade(this.schemaName, this.con);
            this.theAuslaufFacade= new AuslaufFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theFalseXFacade= new FalseXFacade(this.schemaName, this.con);
            this.theBestellungFacade= new BestellungFacade(this.schemaName, this.con);
            this.theArtikelEntnehmenCommandFacade= new ArtikelEntnehmenCommandFacade(this.schemaName, this.con);
            this.theHerstellerManagerFacade= new HerstellerManagerFacade(this.schemaName, this.con);
            this.theLieferartFacade= new LieferartFacade(this.schemaName, this.con);
            this.theRegisterCommandFacade= new RegisterCommandFacade(this.schemaName, this.con);
            this.theAendereArtikelCommandFacade= new AendereArtikelCommandFacade(this.schemaName, this.con);
            this.theNeuanlageFacade= new NeuanlageFacade(this.schemaName, this.con);
            this.theServiceRegisterFacade= new ServiceRegisterFacade(this.schemaName, this.con);
            this.theKomponenteFacade= new KomponenteFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theGeliefertFacade= new GeliefertFacade(this.schemaName, this.con);
            this.theServiceKundeFacade= new ServiceKundeFacade(this.schemaName, this.con);
            this.theBestellstatusFacade= new BestellstatusFacade(this.schemaName, this.con);
            this.theArtikelFacade= new ArtikelFacade(this.schemaName, this.con);
            this.theProduktgruppeFacade= new ProduktgruppeFacade(this.schemaName, this.con);
            this.thePositionFacade= new PositionFacade(this.schemaName, this.con);
            this.theServiceFacade= new ServiceFacade(this.schemaName, this.con);
            this.theServiceAdminFacade= new ServiceAdminFacade(this.schemaName, this.con);
            this.theArtikelManagerFacade= new ArtikelManagerFacade(this.schemaName, this.con);
            this.theStatusAuslaufCommandFacade= new StatusAuslaufCommandFacade(this.schemaName, this.con);
            this.theNeuerArtikelCommandFacade= new NeuerArtikelCommandFacade(this.schemaName, this.con);
            this.theStatusVerkaufCommandFacade= new StatusVerkaufCommandFacade(this.schemaName, this.con);
            this.theKontoFacade= new KontoFacade(this.schemaName, this.con);
            this.theVorbestellungFacade= new VorbestellungFacade(this.schemaName, this.con);
            this.theKundeFacade= new KundeFacade(this.schemaName, this.con);
            this.theHerstellerFacade= new HerstellerFacade(this.schemaName, this.con);
            this.theRueckversandFacade= new RueckversandFacade(this.schemaName, this.con);
            this.theLieferartManagerFacade= new LieferartManagerFacade(this.schemaName, this.con);
            this.theProdGEntfernenCommandFacade= new ProdGEntfernenCommandFacade(this.schemaName, this.con);
            this.theHinversandFacade= new HinversandFacade(this.schemaName, this.con);
            this.theAngenommenFacade= new AngenommenFacade(this.schemaName, this.con);
            this.theLieferungFacade= new LieferungFacade(this.schemaName, this.con);
            this.theBooleanXFacade= new BooleanXFacade(this.schemaName, this.con);
            this.theWarenlagerFacade= new WarenlagerFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theArtikelstatusFacade= new ArtikelstatusFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theTrueXFacade= new TrueXFacade(this.schemaName, this.con);
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		Connection con = this.getConnection();
		CallableStatement callable;
		try {
			callable = con.prepareCall("Begin " + this.schemaName + ".ClassFacade.deleteObject(?,?); end;");
            callable.setLong(1, object.getId());
            callable.setLong(2, object.getClassId());
			callable.execute();
			callable.close();
		} catch (SQLException se) {
	           throw new PersistenceException(se.getMessage(), se.getErrorCode());
	    }
	}

	
	public Connection getConnection(){
		return this.con;
	}
	
}
