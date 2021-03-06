import common.FrameWithIcon;
import model.DBConnectionConstants;
import modelServer.ConnectionServer;
import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;
import persistence.Cache;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class ServerStarter extends FrameWithIcon implements ServerReporter {

//	private static final long OracleWatchDogInterval = 10000;
//	private static final int OracleWatchDogValidTimeout = 3;

	private static final long serialVersionUID = 1L;
	private JRootPane jContentPane = null;
	private JPanel passwordPanel = null;
	private JLabel passwordLabel = null;
	private JPasswordField passwordField = null;
	private JLabel statusLabel = null;
	private JButton startButton = null;


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			if (args.length >= 1)
				DBConnectionConstants.DataBaseName = args[0];
			if (args.length >= 2) {
				DBConnectionConstants.UserName = args[1];
				DBConnectionConstants.SchemaName = args[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServerStarter serverStarter = new ServerStarter();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = serverStarter.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		serverStarter.setLocation((int)leftMargin,(int)topMargin);

		serverStarter.setVisible(true);
	}
	public ServerStarter() {
		super();
		this.initialize();
	}
	private void initialize() {
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("GOJA-Server");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				stopServer();
			}
		});
	}
	private JRootPane getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JRootPane();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getMainTabPane(),BorderLayout.CENTER);
//			jContentPane.add(getCompletePanel(), BorderLayout.CENTER);
			jContentPane.setDefaultButton(getStartButton());
		}
		return jContentPane;
	}
	private JTabbedPane mainTabPane = null;
	private JTabbedPane getMainTabPane() {
		if (mainTabPane == null){
			this.mainTabPane = new JTabbedPane();
			this.mainTabPane.add(getCompletePanel(), "Connection");
			this.mainTabPane.add(getCachePanel(), "Cache");
			this.mainTabPane.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
				}
				public void focusGained(FocusEvent e) {
					getPasswordField().requestFocus();
				}
			});
		}
		return this.mainTabPane;
	}
	private JPanel cachePanel = null;
	private JPanel getCachePanel() {
		if (this.cachePanel == null){
			this.cachePanel = new JPanel();
			this.cachePanel.setLayout(new BorderLayout());
			this.cachePanel.add(getCacheFilterPanel(),BorderLayout.NORTH);
			this.cachePanel.add(getCacheEntryListScrollPane(),BorderLayout.CENTER);
			this.cachePanel.add(getCacheToolBar(),BorderLayout.SOUTH);
		}
		return this.cachePanel;
	}
	private JPanel cacheFilterPanel = null;
	private JPanel getCacheFilterPanel() {
		if (this.cacheFilterPanel == null){
			this.cacheFilterPanel = new JPanel();
			this.cacheFilterPanel.setLayout(new BoxLayout(this.cacheFilterPanel, BoxLayout.X_AXIS));
			this.cacheFilterPanel.add(new JLabel("Filter: "));
			this.cacheFilterPanel.add(getFilterTextPane());
		}
		return this.cacheFilterPanel;
	}
	private JTextField filterTextPane = null;
	private JTextField getFilterTextPane() {
		if (this.filterTextPane == null){
			this.filterTextPane = new JTextField();
			this.filterTextPane.addKeyListener(new  KeyListener() {
				public void keyTyped(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					filter();
				}
				public void keyPressed(KeyEvent e) {
				}
			});
		}
		return this.filterTextPane;
	}
	private JToolBar cacheToolBar = null;
	private JToolBar getCacheToolBar() {
		if (this.cacheToolBar == null){
			this.cacheToolBar = new JToolBar();
			this.cacheToolBar.add(getCacheReportButton());
		}
		return cacheToolBar;
	}
	private JButton cacheReportButton = null;
	@SuppressWarnings("rawtypes")
	private java.util.Vector backup = new java.util.Vector();
	private JButton getCacheReportButton() {
		if (cacheReportButton == null){
			this.cacheReportButton = new JButton();
			this.cacheReportButton.setText("Show cache report!");
			this.cacheReportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backup = Cache.getTheCache().getCacheReportList();
					filter();
				}
			});
		}
		return this.cacheReportButton;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void filter() {
		java.util.Vector show = new java.util.Vector();
		for (Object current : this.backup) {
			if (current.toString().contains(getFilterTextPane().getText())) show.add(current);
		}
		getCacheEntryList().setListData(show);
	}
	private JScrollPane cacheEntryListScrollPane = null;
	private JScrollPane getCacheEntryListScrollPane() {
		if (this.cacheEntryListScrollPane == null){
			this.cacheEntryListScrollPane = new JScrollPane();
			this.cacheEntryListScrollPane.setViewportView(getCacheEntryList());
		}
		return this.cacheEntryListScrollPane;
	}
	private JList cacheEntryList = null;
	private JList getCacheEntryList() {
		if (cacheEntryList == null) {
			this.cacheEntryList = new JList();
		}
		return cacheEntryList;
	}
	private JPanel completePanel = null;
	private Component getCompletePanel() {
		if(this.completePanel == null){
			completePanel = new JPanel();
			completePanel.setLayout(new BoxLayout(completePanel,BoxLayout.Y_AXIS));
			completePanel.add(getLogoPanel());
			completePanel.add(getConnectionPanel());
		}
		return completePanel;
	}
	private JPanel connectionPanel = null;
	private Component getConnectionPanel() {
		if(connectionPanel == null){
			connectionPanel = new JPanel();
			connectionPanel.setPreferredSize(new Dimension(700,700));
			connectionPanel.setLayout(new BorderLayout());
			connectionPanel.setBorder(new TitledBorder("Connections:"));
			connectionPanel.add(getConnectionScrollPane(),BorderLayout.CENTER);
			connectionPanel.add(getCacheSizePanel(),BorderLayout.SOUTH);
		}
		return connectionPanel;
	}
	private JPanel cacheSizePanel = null;
	private Component getCacheSizePanel() {
		if(cacheSizePanel == null){
			cacheSizePanel = new JPanel();
			cacheSizePanel.setLayout(new BoxLayout(cacheSizePanel,BoxLayout.X_AXIS));
			cacheSizePanel.add(new JLabel(" Current Cache Size: "));
			cacheSizePanel.add(getCacheSizeLabel());
			cacheSizePanel.add(new JLabel(" Maximal Cache Size: "));
			cacheSizePanel.add(getMaximalCacheSizeLabel());
			cacheSizePanel.add(new JLabel(" Recycled: "));
			cacheSizePanel.add(getRecycledLabel());
			cacheSizePanel.add(new JPanel());
			cacheSizePanel.add(getGCButton());
			cacheSizePanel.add(getCGCButton());
		}
		return cacheSizePanel;
	}
	private JButton cGCButton = null;
	private JButton getCGCButton(){
		if (this.cGCButton == null) {
			this.cGCButton = new JButton("Cache-GC");
			this.cGCButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cache.getTheCache().forced = true;
				}
			});
		}
		return this.cGCButton;
	}
	private JButton gCButton = null;
	private JButton getGCButton(){
		if (this.gCButton == null) {
			this.gCButton = new JButton("GC");
			this.gCButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.gc();
				}
			});
		}
		return this.gCButton;
	}
	private JLabel recycledLabel = null;
	private JLabel getRecycledLabel() {
		if(recycledLabel == null)recycledLabel = new JLabel("0");
		return recycledLabel;
	}
	private JLabel maximalCacheSizeLabel = null;
	private JLabel getMaximalCacheSizeLabel() {
		if(maximalCacheSizeLabel == null)maximalCacheSizeLabel = new JLabel("0");
		return maximalCacheSizeLabel;
	}
	private JScrollPane connectionScrollPane = null;
	private Component getConnectionScrollPane() {
		if(connectionScrollPane == null){
			connectionScrollPane = new JScrollPane();
			connectionScrollPane.setViewportView(getConnectionList());
		}
		return connectionScrollPane;
	}
	private JList connectionList = null;
	private Component getConnectionList() {
		if (connectionList == null){
			connectionList = new JList();
			connectionList.setModel(getConnectionListModel());
		}
		return connectionList;
	}
	private DefaultListModel connectionListModel = null;
	private DefaultListModel getConnectionListModel() {
		if (connectionListModel == null){
			connectionListModel = new DefaultListModel();
		}
		return connectionListModel;
	}
	private JPanel logoPanel = null;
	private JPanel getLogoPanel() {
		if(logoPanel == null){
			JLabel logoLabel = new JLabel();
//			logoLabel.setIcon(new ImageIcon(getClass().getResource("/common/logo.jpg")));
			logoPanel = new JPanel();
			logoPanel.setPreferredSize(new Dimension(700,90));
			logoPanel.setLayout(new BoxLayout(logoPanel,BoxLayout.X_AXIS));
			logoPanel.add(logoLabel);
			logoPanel.add(getPasswordContextPanel());
		}
		return logoPanel;
	}
	private JPanel passwordContextPanel = null;
	private JPanel getPasswordContextPanel() {
		if(passwordContextPanel == null){
			passwordContextPanel = new JPanel();
			passwordContextPanel.setLayout(new BoxLayout(passwordContextPanel,BoxLayout.Y_AXIS));
			JPanel fill1 = new JPanel();
			fill1.setPreferredSize(new Dimension(100,200));
			passwordContextPanel.add(fill1);
			passwordContextPanel.add(getPasswordPanel());
			JPanel fill2 = new JPanel();
			fill2.setLayout(new BorderLayout());
			fill2.setPreferredSize(new Dimension(100,200));
			statusLabel = new JLabel();
			statusLabel.setText("    ");
			fill2.add(statusLabel,BorderLayout.SOUTH);
			passwordContextPanel.add(fill2);
		}
		return passwordContextPanel;
	}

	private JPanel getPasswordPanel() {
		if (passwordPanel == null) {
			passwordLabel = new JLabel();
			passwordLabel.setText(" Password for Database: ");
			passwordPanel = new JPanel();
			passwordPanel.setLayout(new BoxLayout(getPasswordPanel(),
					BoxLayout.X_AXIS));
			passwordPanel.add(passwordLabel, null);
			passwordPanel.add(getPasswordField(), null);
			passwordPanel.add(getStartButton(), null);
			passwordPanel.add(new JLabel(" Down until: "));
			passwordPanel.add(getDownTimeTextField());
			passwordPanel.add(getSwitchOffButton());
			passwordPanel.add(getStopButton(), null);
		}
		return passwordPanel;
	}
	private JTextField downTimeTextField = null;
	private JTextField getDownTimeTextField(){
		if (this.downTimeTextField == null){
			this.downTimeTextField = new JTextField();
		}
		return this.downTimeTextField;
	}
	private JButton switchOffButton = null;
	private JButton getSwitchOffButton(){
		if (this.switchOffButton == null) {
			this.switchOffButton = new JButton();
			this.switchOffButton.setText("Switch off");
			this.switchOffButton.setEnabled(false);
			this.switchOffButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchOffServer();
				}
			});
		}
		return this.switchOffButton;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}
	private JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton();
			startButton.setText("Start");
			startButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					startServer();
				}
			});
		}
		return startButton;
	}

	protected synchronized void startServer() {
		this.statusLabel.setText("");
		try {
			DBConnectionConstants.Password = this.getPasswordField().getPassword();
			startConnectionHandler();
			ConnectionHandler.initializeMapsForMappedFields();
			Cache.setReporter(this);
			ConnectionServer.startTheConnectionServer(this);
			this.statusLabel.setForeground(Color.BLACK);
			this.statusLabel.setText("Server started!");
			this.getStartButton().setEnabled(false);
			this.getSwitchOffButton().setEnabled(true);
			this.getStopButton().setEnabled(false);
//			this.oracleWatchdog = new Thread(new OracleWatchdog(),"Oracle Watchdog");
//			this.oracleWatchdog.start();
		}catch(PersistenceException pe){
			this.statusLabel.setForeground(Color.RED);
			this.statusLabel.setText(pe.getMessage());
		}
	}
	private void startConnectionHandler() throws PersistenceException {
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			DBConnectionConstants.Password,
			true);
	}
/*	Thread oracleWatchdog;
	class OracleWatchdog implements Runnable {
		
		private boolean oracleDown = false;
		oracle.jdbc.driver.OracleConnection oracleConnection;
		
		@Override
		public void run() {
			while (true) {
				try {
					oracleConnection = 
							(oracle.jdbc.driver.OracleConnection) DriverManager.getConnection(ConnectionHandler.DatabaseProtocol + DBConnectionConstants.DataBaseName, 
							                                                                  DBConnectionConstants.UserName, 
							                                                                  ConnectionHandler.asString(DBConnectionConstants.Password));
					do {
						this.handleOracleUp();
						try {
							synchronized(this) {this.wait(OracleWatchDogInterval);}
						} catch (InterruptedException e) {
							return;
						}	
					} while (oracleConnection.isValid(OracleWatchDogValidTimeout)); 					
					this.handleOracleDown();
				} catch (SQLException e) {
					this.handleOracleDown();
				}
			}
		}
		private void handleOracleDown() {
			if (this.oracleDown) return;
			System.out.println("handleDown");
			this.oracleDown = true;
			try {
				CommandCoordinator.getTheCommandCoordinator().interrupt();
			} catch (PersistenceException e) {
				System.out.println("Command coordinator is not running!");
			}
		}
		private void handleOracleUp() {
			if (!this.oracleDown) return;
			System.out.println("handleUp");
			this.oracleDown = false;
			try {
				ConnectionHandler.reinitialise();
				startConnectionHandler();
				CommandCoordinator.getTheCommandCoordinator().restart();
			} catch (PersistenceException e) {
				throw new Error("Oracle watchdog terminated: command coordinator operation 'restart' shall not throw PersistenceException, if Oracle is up!");
			}
		}
		
	}*/

	private JButton stopButton = null;
	private JComponent getStopButton() {
		if(stopButton == null){
			stopButton = new JButton();
			stopButton.setText("Stop");
			stopButton.setEnabled(false);
			stopButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					stopServer();
				}
			});
		}
		return stopButton;
	}

	protected void stopServer() {
		try {
			ConnectionServer.stopTheConnectionServer();
			ConnectionHandler.disconnect();
			this.statusLabel.setText("Server terminated!");
			this.getStopButton().setEnabled(false);
			this.getSwitchOffButton().setEnabled(false);
			this.getStartButton().setEnabled(true);
		} catch (PersistenceException e) {
			this.statusLabel.setForeground(Color.RED);
			this.statusLabel.setText(e.getMessage());
		}
	}
	protected void switchOffServer() {
		try {
			ConnectionServer.switchOffTheConnectionServer(getDownTimeTextField().getText());
			ConnectionHandler.disconnect();
			this.statusLabel.setText("Server switched off!");
			this.getSwitchOffButton().setEnabled(false);
			this.getStartButton().setEnabled(false);
			this.getStopButton().setEnabled(true);
		} catch (PersistenceException e) {
			this.statusLabel.setForeground(Color.RED);
			this.statusLabel.setText(e.getMessage());
		}
	}

	public void reportCancelledConnection(final RemoteServerMaster server) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				getConnectionListModel().removeElement(server);			
			}
		});
	}

	public void reportNewConnection(final RemoteServerMaster server) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				getConnectionListModel().addElement(server);
			}
		});
	}

	@Override
	public void reportCurrentCacheSize(final int size, final long recycledICProxies) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				int currentMaximum = Integer.parseInt(getMaximalCacheSizeLabel().getText());
				if (size > currentMaximum)getMaximalCacheSizeLabel().setText(new Integer(size).toString());
				getCacheSizeLabel().setText(new Integer(size).toString());
				getRecycledLabel().setText(new Long(recycledICProxies).toString());
			}
			
		});
	}

	private JLabel cacheSizeLabel = null;
	private JLabel getCacheSizeLabel() {
		if(cacheSizeLabel == null)cacheSizeLabel = new JLabel("0");
		return cacheSizeLabel;
	}

}