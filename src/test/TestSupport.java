package test;

import model.DBConnectionConstants;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

public class TestSupport {
	

	//Manual path start
	private static final String Password = "pg"; //TODO adjust password!
	//Manual path end

	
	private static java.sql.Connection connection;	
	
	private TestSupport(){}	
	
	public static void prepareSingletons(){
        model.deactivated.reset$For$Test = true;
        model.Neuanlage.reset$For$Test = true;
        model.meta.CommandCoordinator.reset$For$Test = true;
        model.ProduktKatalog.reset$For$Test = true;
        model.ArtikelManager.reset$For$Test = true;
        model.Angenommen.reset$For$Test = true;
        model.Warenlager.reset$For$Test = true;
        model.Verkauf.reset$For$Test = true;
        model.Auslauf.reset$For$Test = true;
        model.KundenManager.reset$For$Test = true;
        model.Geliefert.reset$For$Test = true;
        model.ZeitManager.reset$For$Test = true;
        model.Rueckversand.reset$For$Test = true;
        model.LieferartManager.reset$For$Test = true;
        model.Hinversand.reset$For$Test = true;
        model.activated.reset$For$Test = true;

	}

	public static void prepareDatabase() throws PersistenceException{
		initializeConnectionHandler();
		resetDatabase();
	}
	public static void resetDatabase() throws PersistenceException{
		ConnectionHandler.disconnect();
		disconnect();
		initializeConnectionHandler();
	}
	public static void clearDatabase() throws PersistenceException{
		resetDatabase();
	}
	private static void disconnect() {
		if (connection != null) {
			connection = null;
		}		
	}
	private static void initializeConnectionHandler() throws PersistenceException{
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			Password.toCharArray(),
			true);
		ConnectionHandler.initializeMapsForMappedFields();		
	}
}
