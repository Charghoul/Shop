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


public class ServiceAdminClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private ServiceAdminView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public ServiceAdminClientView( ExceptionAndEventHandler parent, ServiceAdminView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private ServiceAdminView getService(){
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getServiceAdminView();
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
	public ServiceAdminConnection getConnection(){
        	return (ServiceAdminConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getServiceAdminView().getErrors();
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
				getNavigationTree().setModel((TreeModel) getConnection().getServiceAdminView());	
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
        ImageView handle(AendereArtikelPRMTRArtikelPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(AendereLieferartPRMTRLieferartPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(ArtikelEntnehmenPRMTRWarenlagerPRMTRPositionPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(StatusAuslaufPRMTRArtikelPRMTRMenuItem menuItem);
        ImageView handle(StatusVerkaufPRMTRArtikelPRMTRMenuItem menuItem);
    }
    private abstract class ServiceAdminMenuItem extends MenuItem{
        private ServiceAdminMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AendereArtikelPRMTRArtikelPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AendereLieferartPRMTRLieferartPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelEntnehmenPRMTRWarenlagerPRMTRPositionPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StatusAuslaufPRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StatusVerkaufPRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
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
                this.setPreCalculatedFilters(this.getConnection().serviceAdmin_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof LieferartManagerView){
                item = new NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem();
                item.setText("neueLieferArt ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminNeueLieferArtLieferartManagerStringIntegerFractionMssgWizard wizard = new ServiceAdminNeueLieferArtLieferartManagerStringIntegerFractionMssgWizard("neueLieferArt");
                        wizard.setFirstArgument((LieferartManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ArtikelManagerView){
                item = new NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem();
                item.setText("neuerArtikel ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminNeuerArtikelArtikelManagerStringStringFractionIntegerIntegerIntegerMssgWizard wizard = new ServiceAdminNeuerArtikelArtikelManagerStringStringFractionIntegerIntegerIntegerMssgWizard("neuerArtikel");
                        wizard.setFirstArgument((ArtikelManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof LieferartView){
                item = new AendereLieferartPRMTRLieferartPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem();
                item.setText("aendereLieferart ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminAendereLieferartLieferartStringIntegerFractionMssgWizard wizard = new ServiceAdminAendereLieferartLieferartStringIntegerFractionMssgWizard("aendereLieferart");
                        wizard.setFirstArgument((LieferartView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ArtikelView){
                item = new AendereArtikelPRMTRArtikelPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem();
                item.setText("aendereArtikel ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminAendereArtikelArtikelStringFractionIntegerIntegerIntegerMssgWizard wizard = new ServiceAdminAendereArtikelArtikelStringFractionIntegerIntegerIntegerMssgWizard("aendereArtikel");
                        wizard.setFirstArgument((ArtikelView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new StatusAuslaufPRMTRArtikelPRMTRMenuItem();
                item.setText("statusAuslauf");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("statusAuslauf" + GUIConstants.ConfirmQuestionMark);
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().statusAuslauf((ArtikelView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new StatusVerkaufPRMTRArtikelPRMTRMenuItem();
                item.setText("statusVerkauf");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("statusVerkauf" + GUIConstants.ConfirmQuestionMark);
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().statusVerkauf((ArtikelView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof WarenlagerView){
                item = new ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem();
                item.setText("artikelEinlagern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelEinlagernWarenlagerArtikelIntegerMssgWizard wizard = new ServiceAdminArtikelEinlagernWarenlagerArtikelIntegerMssgWizard("artikelEinlagern");
                        wizard.setFirstArgument((WarenlagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ArtikelEntnehmenPRMTRWarenlagerPRMTRPositionPRMTRIntegerPRMTRMenuItem();
                item.setText("artikelEntnehmen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelEntnehmenWarenlagerPositionIntegerMssgWizard wizard = new ServiceAdminArtikelEntnehmenWarenlagerPositionIntegerMssgWizard("artikelEntnehmen");
                        wizard.setFirstArgument((WarenlagerView)selected);
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
    
	class ServiceAdminAendereArtikelArtikelStringFractionIntegerIntegerIntegerMssgWizard extends Wizard {

		protected ServiceAdminAendereArtikelArtikelStringFractionIntegerIntegerIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AendereArtikelPRMTRArtikelPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminAendereArtikelArtikelStringFractionIntegerIntegerIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().aendereArtikel(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(2)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(3)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(4)).getResult().longValue());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("bezeichnung", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("preis", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("minLagerbestand", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("maxLagerbestand", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("hstLieferzeit", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ArtikelView firstArgument; 
	
		public void setFirstArgument(ArtikelView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getBezeichnung());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel1 = (SelectionPanel)getParametersPanel().getChildren().get(1);
				selectionPanel1.preset(firstArgument.getPreis());
				if (!selectionPanel1.check()) selectionPanel1.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel2 = (SelectionPanel)getParametersPanel().getChildren().get(2);
				selectionPanel2.preset(firstArgument.getMinLagerbestand());
				if (!selectionPanel2.check()) selectionPanel2.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel3 = (SelectionPanel)getParametersPanel().getChildren().get(3);
				selectionPanel3.preset(firstArgument.getMaxLagerbestand());
				if (!selectionPanel3.check()) selectionPanel3.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel4 = (SelectionPanel)getParametersPanel().getChildren().get(4);
				selectionPanel4.preset(firstArgument.getHstLieferzeit());
				if (!selectionPanel4.check()) selectionPanel4.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceAdminAendereLieferartLieferartStringIntegerFractionMssgWizard extends Wizard {

		protected ServiceAdminAendereLieferartLieferartStringIntegerFractionMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AendereLieferartPRMTRLieferartPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminAendereLieferartLieferartStringIntegerFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().aendereLieferart(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcAlreadyExists e) {
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("lieferzeit", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("preis", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private LieferartView firstArgument; 
	
		public void setFirstArgument(LieferartView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getName());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel1 = (SelectionPanel)getParametersPanel().getChildren().get(1);
				selectionPanel1.preset(firstArgument.getLieferzeit());
				if (!selectionPanel1.check()) selectionPanel1.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel2 = (SelectionPanel)getParametersPanel().getChildren().get(2);
				selectionPanel2.preset(firstArgument.getPreis());
				if (!selectionPanel2.check()) selectionPanel2.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceAdminArtikelEinlagernWarenlagerArtikelIntegerMssgWizard extends Wizard {

		protected ServiceAdminArtikelEinlagernWarenlagerArtikelIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelEinlagernWarenlagerArtikelIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelEinlagern(firstArgument, (ArtikelView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
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
			final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("artikel", "view.ArtikelView", null, this);
			getParametersPanel().getChildren().add(panel1);
			panel1.setBrowserRoot((ViewRoot) getConnection().getServiceAdminView());
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("menge", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private WarenlagerView firstArgument; 
	
		public void setFirstArgument(WarenlagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminArtikelEntnehmenWarenlagerPositionIntegerMssgWizard extends Wizard {

		protected ServiceAdminArtikelEntnehmenWarenlagerPositionIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelEntnehmenPRMTRWarenlagerPRMTRPositionPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelEntnehmenWarenlagerPositionIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelEntnehmen(firstArgument, (PositionView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue());
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
			final ObjectSelectionPanel panel2 = new ObjectSelectionPanel("position", "view.PositionView", null, this);
			getParametersPanel().getChildren().add(panel2);
			panel2.setBrowserRoot((ViewRoot) getConnection().getServiceAdminView());
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("menge", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private WarenlagerView firstArgument; 
	
		public void setFirstArgument(WarenlagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminNeueLieferArtLieferartManagerStringIntegerFractionMssgWizard extends Wizard {

		protected ServiceAdminNeueLieferArtLieferartManagerStringIntegerFractionMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminNeueLieferArtLieferartManagerStringIntegerFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neueLieferArt(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcAlreadyExists e) {
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("lieferzeit", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("preis", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private LieferartManagerView firstArgument; 
	
		public void setFirstArgument(LieferartManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminNeuerArtikelArtikelManagerStringStringFractionIntegerIntegerIntegerMssgWizard extends Wizard {

		protected ServiceAdminNeuerArtikelArtikelManagerStringStringFractionIntegerIntegerIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRFractionPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminNeuerArtikelArtikelManagerStringStringFractionIntegerIntegerIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neuerArtikel(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(2)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(3)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(4)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(5)).getResult().longValue());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("artikelnummer", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("bezeichnung", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("preis", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("minLagerbestand", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("maxLagerbestand", this));
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("hstLieferzeit", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ArtikelManagerView firstArgument; 
	
		public void setFirstArgument(ArtikelManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(ServiceAdminMenuItem menuItem){
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