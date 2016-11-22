package viewClient;

import com.sun.javafx.geom.Point2D;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import view.*;
import view.objects.ViewObjectInTree;
import view.objects.ViewRoot;
import view.visitor.AnythingStandardVisitor;

import javax.swing.tree.TreeModel;
import java.util.Optional;


public class ServiceKundeClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private ServiceKundeView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public ServiceKundeClientView( ExceptionAndEventHandler parent, ServiceKundeView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private ServiceKundeView getService(){
		return this.service;
	}
	private void initialize() {
        this.setCenter( this.getMainSplitPane());
        if( !WithStaticOperations && this.getMainToolBar().getItems().size() > 0){
        	this.setTop( this.getMainToolBar() );
        }
	}
	private ToolBar mainToolBar = null;
	private ToolBar getMainToolBar() {
		if( this.mainToolBar == null){
			this.mainToolBar = new ToolBar();
			for( Button current : this.getToolButtonsForStaticOperations()) {
				this.mainToolBar.getItems().add( current );
			}
		}
		return this.mainToolBar;
	}
	private SplitPane mainSplitPane = null;
	private SplitPane getMainSplitPane() {
		if( this.mainSplitPane == null) {
			this.mainSplitPane = new SplitPane();
			this.mainSplitPane.setOrientation( Orientation.HORIZONTAL);
			this.mainSplitPane.getItems().addAll( this.getNavigationSplitPane(), this.getTitledDetailsPane() );	
			this.mainSplitPane.setDividerPosition( 0, 0.5);
			this.mainSplitPane.prefHeightProperty().bind( this.heightProperty());
			this.mainSplitPane.prefWidthProperty().bind( this.widthProperty());
		}
		return this.mainSplitPane;
	}
	private SplitPane navigationSplitPane = null;
	private SplitPane getNavigationSplitPane(){
		if( this.navigationSplitPane == null ){
			this.navigationSplitPane = new SplitPane();
			this.navigationSplitPane.setOrientation( Orientation.VERTICAL);
			this.navigationSplitPane.getItems().addAll( this.getNavigationPanel(), this.getErrorPanel());
			this.navigationSplitPane.prefHeightProperty().bind( this.getMainSplitPane().heightProperty());
			this.navigationSplitPane.setDividerPosition( 0, 1.0);
			this.navigationSplitPane.heightProperty().addListener(new ChangeListener<Number>() {
				public void changed(
						ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if(! getErrorPanel().isVisible()) {						
						navigationSplitPane.setDividerPosition(0, 1.0);
					} else {						
						navigationSplitPane.setDividerPosition(0, 0.7);
					}
				}
			});
			this.getErrorPanel().setMinHeight(0);
		}
		return this.navigationSplitPane;
	}
	private TitledPane treePanel = null;
	private TitledPane getNavigationPanel() {
		if( this.treePanel == null) {
			this.treePanel = new TitledPane( GUIConstants.NaviationTitle, this.getNavigationTree() );
			this.treePanel.setCollapsible( false );
			this.treePanel.prefHeightProperty().bind( this.getNavigationSplitPane().heightProperty());
		}
		return treePanel;
	}
	private TitledPane errorPanel = null;
	private TitledPane getErrorPanel(){
		if( this.errorPanel == null){
			this.errorPanel = new TitledPane( GUIConstants.ErrorTitle, this.getErrorTree());
			this.errorPanel.setCollapsible( false );
			this.errorPanel.setVisible( false );
		}
		return this.errorPanel;
	}

	private TreeRefresh errorTree = null;
	private TreeRefresh getErrorTree(){
		if( this.errorTree == null){
			this.errorTree = new TreeRefresh(parent);
			this.errorTree.setOnContextMenuRequested( new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, errorTree, false);					
				}
			});
		}
		return this.errorTree;
	}
	private void setErrors( TreeModel errors){
		this.getErrorPanel().setVisible(true);
		this.getErrorTree().setModel( errors );
		this.getNavigationSplitPane().setDividerPosition(0, 0.7);
	}
	private void setNoErrors(){
		this.getErrorPanel().setVisible(false);
        this.getNavigationSplitPane().setDividerPosition(0, 1.0);
	}
	private TitledPane titledDetailsPane = null;
	private TitledPane getTitledDetailsPane() {
		if( this.titledDetailsPane == null ){
			this.titledDetailsPane = new TitledPane();
			this.titledDetailsPane.setText( GUIConstants.DetailsTitle);
			this.titledDetailsPane.setCollapsible(false);			
			this.titledDetailsPane.prefHeightProperty().bind(this.getMainSplitPane().heightProperty());
		}
		return this.titledDetailsPane;		
	}	
	private TreeRefresh navigationTree = null;
	private TreeRefresh getNavigationTree() {
		if( this.navigationTree == null) {
			this.navigationTree = new TreeRefresh( parent );
			this.navigationTree.getSelectionModel().setSelectionMode( SelectionMode.SINGLE);
			this.navigationTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ViewObjectInTree>>() {
				public void changed(
					ObservableValue<? extends TreeItem<ViewObjectInTree>> observable,
					TreeItem<ViewObjectInTree> oldValue,
					TreeItem<ViewObjectInTree> newValue) {
					if( menu !=null) menu.hide();
					if( newValue != null ){						
						setDetailsTable( (Anything) newValue.getValue().getWrappedObject());				
					}
				}
			});
			this.navigationTree.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, navigationTree, WithStaticOperations);					
				}
			});
			navigationTree.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCode() == KeyCode.F5 ){
						Platform.runLater( new Runnable() {
							public void run() {								
								try {
									getNavigationTree().refreshTree();
								} catch (ModelException e) {
									handleException(e);
								}			
							}
						});
					}
				}
			});
		}
		return this.navigationTree;
	}
	private DetailPanel currentDetails = null;
	protected void setDetailsTable( Anything object) {
		this.getTitledDetailsPane().setVisible( false );
		if (object == null && this.getConnection() != null) object = this.getConnection().getServiceKundeView();
		if (object == null){
			this.currentDetails = getNoDetailsPanel();
		}else{
			try {
				this.currentDetails = this.getDetailView(object);
			} catch (ModelException e) {
				this.handleException(e);
				this.currentDetails = null;
			}
			if(this.currentDetails == null) this.currentDetails = getStandardDetailsTable(object);
		}
		this.getTitledDetailsPane().setContent( this.currentDetails );
		this.getTitledDetailsPane().setVisible( true );
		this.currentDetails.prefWidthProperty().bind( this.getTitledDetailsPane().widthProperty() );
	}

	private DetailPanel getDetailView(final Anything anything) throws ModelException {
		class PanelDecider extends AnythingStandardVisitor {

			private DetailPanel result;
			
			public DetailPanel getResult() {
				return this.result;
			}
			protected void standardHandling(Anything Anything) throws ModelException {
				this.result = null;
			}

			@Override
			public void handleArtikel(ArtikelView artikel) throws ModelException {
				//super.handleArtikel(artikel);
				this.result=new NoDetailPanel(ServiceKundeClientView.this);
			}
//TODO Overwrite all handle methods for the types for which you intend to provide a special panel!
		}
		PanelDecider decider = new PanelDecider();
		anything.accept(decider);
		return decider.getResult();
	}
	private NoDetailPanel noDetailPanel = null;
	public DetailPanel getNoDetailsPanel() {
		if( this.noDetailPanel == null) this.noDetailPanel = new NoDetailPanel(this);
		return noDetailPanel;
	}
	private ContextMenu menu = null;
	protected void tryShowContextMenu( ContextMenuEvent e, TreeRefresh tree, boolean withStaticOperations) {
		if( this.menu !=null ) this.menu.hide();
		SelectionModel<TreeItem<ViewObjectInTree>> selMod = tree.getSelectionModel();
		ViewObjectInTree selVal = selMod.getSelectedItem().getValue();
		ViewRoot selected = selVal.getWrappedObject();
		this.menu = this.getContextMenu( selected, withStaticOperations , new Point2D((float)e.getScreenX(), (float)e.getScreenY() ) );
		if( this.menu.getItems().size() > 0) {
			this.menu.show( this.getNavigationPanel(),  e.getScreenX(), e.getScreenY() );
		}
	}
	
	private DetailPanel getStandardDetailsTable(Anything object) {
		try {
			return DefaultDetailPanel.getStandardDetailPanel(object,this);
		} catch (ModelException e) {
			this.handleException(e);
			return new NoDetailPanel(this);
		}
	}

	public void setConnection(ConnectionMaster connection){
		this.connection = connection;
	}
	public ServiceKundeConnection getConnection(){
        	return (ServiceKundeConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getServiceKundeView().getErrors();
					if (errors.size() >0 )setErrors( new ListRoot(errors));
					else setNoErrors();
				} catch (ModelException e) {
					handleException(e);
				}			
			}
		});
		//TODO adjust implementation: handleRefresh()!
	}
	/** Is called only once after the connection has been established
	**/
	public void initializeConnection(){
		Platform.runLater( new  Runnable() {
			public void run() {
				getNavigationTree().setModel((TreeModel) getConnection().getServiceKundeView());	
				getNavigationTree().getRoot().setExpanded(true);
				getNavigationTree().getSelectionModel().select( getNavigationTree().getRoot());
			}
		});
		//TODO adjust implementation: initializeConnection
	}
	public void handleException(ModelException exception) {
		this.parent.handleException(exception);
	}
	public void handleOKMessage(String message) {
		this.parent.handleOKMessage(message);
	}
	public void handleUserException(UserException exception) {
		this.parent.handleUserException(exception);	
	}	
	
	/* Menu and wizard section start */

	static boolean WithStaticOperations = false;


    interface MenuItemVisitor{
        ImageView handle(AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(AllesZuruecksendenPRMTRBestellungPRMTRMenuItem menuItem);
        ImageView handle(AnnehmenPRMTRBestellungPRMTRMenuItem menuItem);
        ImageView handle(AuszahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(BestellenPRMTREinkaufsManagerPRMTRLieferartPRMTRMenuItem menuItem);
        ImageView handle(EinzahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(EntfernePositionPRMTRPositionPRMTRMenuItem menuItem);
        ImageView handle(NeuePositionPRMTREinkaufsManagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(VorbestellenPRMTREinkaufsManagerPRMTRMenuItem menuItem);
        ImageView handle(ZuEinkaufswagenHinzufuegenPRMTRArtikelPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(ZuruecksendenPRMTRPositionInBestellungPRMTRMenuItem menuItem);
    }
    private abstract class ServiceKundeMenuItem extends MenuItem{
        private ServiceKundeMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AllesZuruecksendenPRMTRBestellungPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AnnehmenPRMTRBestellungPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AuszahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class BestellenPRMTREinkaufsManagerPRMTRLieferartPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class EinzahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class EntfernePositionPRMTRPositionPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeuePositionPRMTREinkaufsManagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class VorbestellenPRMTREinkaufsManagerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ZuEinkaufswagenHinzufuegenPRMTRArtikelPRMTRIntegerPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ZuruecksendenPRMTRPositionInBestellungPRMTRMenuItem extends ServiceKundeMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        return result;
    }
    private ContextMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations, final Point2D menuPos) {
        final ContextMenu result = new ContextMenu();
        MenuItem item = null;
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().serviceKunde_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof KontoView){
                item = new AuszahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem();
                item.setText("auszahlen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeAuszahlenKontoIntegerMssgWizard wizard = new ServiceKundeAuszahlenKontoIntegerMssgWizard("auszahlen");
                        wizard.setFirstArgument((KontoView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new EinzahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem();
                item.setText("einzahlen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeEinzahlenKontoIntegerMssgWizard wizard = new ServiceKundeEinzahlenKontoIntegerMssgWizard("einzahlen");
                        wizard.setFirstArgument((KontoView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof PositionInBestellungView){
                if (filter_zuruecksenden((PositionInBestellungView) selected)) {
                    item = new ZuruecksendenPRMTRPositionInBestellungPRMTRMenuItem();
                    item.setText("zuruecksenden");
                    item.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(javafx.event.ActionEvent e) {
                            Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle(GUIConstants.ConfirmButtonText);
                            confirm.setHeaderText(null);
                            confirm.setContentText("zuruecksenden" + GUIConstants.ConfirmQuestionMark);
                            Optional<ButtonType> buttonResult = confirm.showAndWait();
                            if (buttonResult.get() == ButtonType.OK) {
                                try {
                                    getConnection().zuruecksenden((PositionInBestellungView)selected);
                                    getConnection().setEagerRefresh();
                                    
                                }catch(ModelException me){
                                    handleException(me);
                                }
                            }
                        }
                    });
                    result.getItems().add(item);
                }
            }
            if (selected instanceof PositionView){
                item = new AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem();
                item.setText("aendereMenge ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeAendereMengePositionIntegerMssgWizard wizard = new ServiceKundeAendereMengePositionIntegerMssgWizard("aendereMenge");
                        wizard.setFirstArgument((PositionView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new EntfernePositionPRMTRPositionPRMTRMenuItem();
                item.setText("entfernePosition");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("entfernePosition" + GUIConstants.ConfirmQuestionMark);
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().entfernePosition((PositionView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof EinkaufsManagerView){
                item = new BestellenPRMTREinkaufsManagerPRMTRLieferartPRMTRMenuItem();
                item.setText("bestellen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeBestellenEinkaufsManagerLieferartMssgWizard wizard = new ServiceKundeBestellenEinkaufsManagerLieferartMssgWizard("bestellen");
                        wizard.setFirstArgument((EinkaufsManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new NeuePositionPRMTREinkaufsManagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem();
                item.setText("neuePosition ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeNeuePositionEinkaufsManagerArtikelIntegerMssgWizard wizard = new ServiceKundeNeuePositionEinkaufsManagerArtikelIntegerMssgWizard("neuePosition");
                        wizard.setFirstArgument((EinkaufsManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new VorbestellenPRMTREinkaufsManagerPRMTRMenuItem();
                item.setText("vorbestellen");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("vorbestellen" + GUIConstants.ConfirmQuestionMark);
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().vorbestellen((EinkaufsManagerView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof BestellungView){
                if (filter_allesZuruecksenden((BestellungView) selected)) {
                    item = new AllesZuruecksendenPRMTRBestellungPRMTRMenuItem();
                    item.setText("allesZuruecksenden");
                    item.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(javafx.event.ActionEvent e) {
                            Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle(GUIConstants.ConfirmButtonText);
                            confirm.setHeaderText(null);
                            confirm.setContentText("allesZuruecksenden" + GUIConstants.ConfirmQuestionMark);
                            Optional<ButtonType> buttonResult = confirm.showAndWait();
                            if (buttonResult.get() == ButtonType.OK) {
                                try {
                                    getConnection().allesZuruecksenden((BestellungView)selected);
                                    getConnection().setEagerRefresh();
                                    
                                }catch(ModelException me){
                                    handleException(me);
                                }
                            }
                        }
                    });
                    result.getItems().add(item);
                }
                if (filter_annehmen((BestellungView) selected)) {
                    item = new AnnehmenPRMTRBestellungPRMTRMenuItem();
                    item.setText("annehmen");
                    item.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(javafx.event.ActionEvent e) {
                            Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle(GUIConstants.ConfirmButtonText);
                            confirm.setHeaderText(null);
                            confirm.setContentText("annehmen" + GUIConstants.ConfirmQuestionMark);
                            Optional<ButtonType> buttonResult = confirm.showAndWait();
                            if (buttonResult.get() == ButtonType.OK) {
                                try {
                                    getConnection().annehmen((BestellungView)selected);
                                    getConnection().setEagerRefresh();
                                    
                                }catch(ModelException me){
                                    handleException(me);
                                }
                            }
                        }
                    });
                    result.getItems().add(item);
                }
            }
            if (selected instanceof ArtikelView){
                item = new ZuEinkaufswagenHinzufuegenPRMTRArtikelPRMTRIntegerPRMTRMenuItem();
                item.setText("zuEinkaufswagenHinzufuegen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceKundeZuEinkaufswagenHinzufuegenArtikelIntegerMssgWizard wizard = new ServiceKundeZuEinkaufswagenHinzufuegenArtikelIntegerMssgWizard("zuEinkaufswagenHinzufuegen");
                        wizard.setFirstArgument((ArtikelView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            
        }
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    private String preCalculatedFilters = "";
    private String getPreCalculatedFilters() {
        return this.preCalculatedFilters;
    }
    private void setPreCalculatedFilters(String switchOff) {
        this.preCalculatedFilters = switchOff;
    }
    private boolean filter_allesZuruecksenden(BestellungView argument){
        return this.getPreCalculatedFilters().contains("+++allesZuruecksendenPRMTRBestellungPRMTR");
    }
    private boolean filter_annehmen(BestellungView argument){
        return this.getPreCalculatedFilters().contains("+++annehmenPRMTRBestellungPRMTR");
    }
    private boolean filter_zuruecksenden(PositionInBestellungView argument){
        return this.getPreCalculatedFilters().contains("+++zuruecksendenPRMTRPositionInBestellungPRMTR");
    }
    
	class ServiceKundeAendereMengePositionIntegerMssgWizard extends Wizard {

		protected ServiceKundeAendereMengePositionIntegerMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeAendereMengePositionIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().aendereMenge(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcLagerbestandUnderZero e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(ExcLagerbestandOverMax e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("menge", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private PositionView firstArgument; 
	
		public void setFirstArgument(PositionView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getMenge());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceKundeAuszahlenKontoIntegerMssgWizard extends Wizard {

		protected ServiceKundeAuszahlenKontoIntegerMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AuszahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeAuszahlenKontoIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().auszahlen(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcAuszahlungGroesserGutgaben e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("betrag", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private KontoView firstArgument; 
	
		public void setFirstArgument(KontoView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceKundeBestellenEinkaufsManagerLieferartMssgWizard extends Wizard {

		protected ServiceKundeBestellenEinkaufsManagerLieferartMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new BestellenPRMTREinkaufsManagerPRMTRLieferartPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeBestellenEinkaufsManagerLieferartMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().bestellen(firstArgument, (LieferartView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("lieferart", "view.LieferartView", null, this);
				getParametersPanel().getChildren().add(panel1);
				panel1.setBrowserRoot((ViewRoot)getConnection().lieferart_Path_In_Bestellen());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private EinkaufsManagerView firstArgument; 
	
		public void setFirstArgument(EinkaufsManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceKundeEinzahlenKontoIntegerMssgWizard extends Wizard {

		protected ServiceKundeEinzahlenKontoIntegerMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new EinzahlenPRMTRKontoPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeEinzahlenKontoIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().einzahlen(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("betrag", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private KontoView firstArgument; 
	
		public void setFirstArgument(KontoView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceKundeNeuePositionEinkaufsManagerArtikelIntegerMssgWizard extends Wizard {

		protected ServiceKundeNeuePositionEinkaufsManagerArtikelIntegerMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeuePositionPRMTREinkaufsManagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeNeuePositionEinkaufsManagerArtikelIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neuePosition(firstArgument, (ArtikelView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(UserException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel2 = new ObjectSelectionPanel("artikel", "view.ArtikelView", null, this);
				getParametersPanel().getChildren().add(panel2);
				panel2.setBrowserRoot((ViewRoot)getConnection().artikel_Path_In_NeuePosition());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("menge", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private EinkaufsManagerView firstArgument; 
	
		public void setFirstArgument(EinkaufsManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceKundeZuEinkaufswagenHinzufuegenArtikelIntegerMssgWizard extends Wizard {

		protected ServiceKundeZuEinkaufswagenHinzufuegenArtikelIntegerMssgWizard(String operationName){
			super(ServiceKundeClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ZuEinkaufswagenHinzufuegenPRMTRArtikelPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceKundeZuEinkaufswagenHinzufuegenArtikelIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().zuEinkaufswagenHinzufuegen(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("menge", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ArtikelView firstArgument; 
	
		public void setFirstArgument(ArtikelView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(ServiceKundeMenuItem menuItem){
		return new ImageView(new javafx.scene.image.Image("/viewResources/default.gif")); //TODO Pimp-up your menu items!
	}
	
	
	private void addNotGeneratedItems(ContextMenu result, ViewRoot selected) {
		// TODO Add items to menue if you have not generated service calls!!!
	}
	protected boolean getMultiSelectionFor(String parameterInBrowser){
		return false;
	}
	public int getPartsPerHour(String parameterInBrowser) {
		// divides 60 minutes into the returned number of parts
		return 59;
	}
	
	
}