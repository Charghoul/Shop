package viewClient;

import model.Artikel;
import model.ServiceAdmin;
import view.*;
import view.objects.ViewRoot;
import view.objects.ViewObjectInTree;

import view.visitor.AnythingStandardVisitor;

import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


import com.sun.javafx.geom.Point2D;

import javax.swing.tree.TreeModel;


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

			private DefaultDetailPanel result;
			
			public DetailPanel getResult() {
				return this.result;
			}
			protected void standardHandling(Anything Anything) throws ModelException {
				this.result = null;
			}



			@Override
			public void handleLieferart(LieferartView lieferart) throws ModelException {
				result = new LieferartDefaultDetailPanel(ServiceAdminClientView.this,lieferart);
				result.registerUpdater(LieferartDefaultDetailPanel.Lieferart$$name, new UpdaterForString() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereLieferartName(lieferart,text);
					}
				});
				result.registerUpdater(LieferartDefaultDetailPanel.Lieferart$$lieferzeit, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereLieferartDauer(lieferart,Long.parseLong(text));
					}
				});
				result.registerUpdater(LieferartDefaultDetailPanel.Lieferart$$preis, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereLieferartPreis(lieferart,Long.parseLong(text));
					}
				});
			}

			@Override
			public void handleKundenManager(KundenManagerView kundenManager) throws ModelException {
				result = new KundenManagerDefaultDetailPanel(ServiceAdminClientView.this,kundenManager);
				result.registerUpdater(KundenManagerDefaultDetailPanel.KundenManager$$standardGuthaben, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereStandardGuthaben(kundenManager,Long.parseLong(text));
					}
				});
				result.registerUpdater(KundenManagerDefaultDetailPanel.KundenManager$$standardLimit, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereStandardLimit(kundenManager,Long.parseLong(text));
					}
				});

			}

			@Override
			public void handleZeitManager(ZeitManagerView zeitManager) throws ModelException {
				result = new ZeitManagerDefaultDetailPanel(ServiceAdminClientView.this,zeitManager);
				result.registerUpdater(ZeitManagerDefaultDetailPanel.ZeitManager$$annahmezeit, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereAnnahmezeit(zeitManager,Long.parseLong(text));
					}
				});
				result.registerUpdater(ZeitManagerDefaultDetailPanel.ZeitManager$$maxAnlieferungsVersuche, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereMaxAnlieferungsVersuche(zeitManager,Long.parseLong(text));
					}
				});
				result.registerUpdater(ZeitManagerDefaultDetailPanel.ZeitManager$$retoureZeit, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereRetoureZeit(zeitManager,Long.parseLong(text));
					}
				});
			}

			@Override
			public void handleLieferartManager(LieferartManagerView lieferartManager) throws ModelException {
				result = new LieferartManagerDefaultDetailPanel(ServiceAdminClientView.this, lieferartManager);
				result.registerUpdater(LieferartManagerDefaultDetailPanel.LieferartManager$$rueckversandGebuehr, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereRueckversandGebuehr(lieferartManager,Long.parseLong(text));
					}
				});
			}

			//Artikelupdates im Detailpanel
			@Override
			public void handleArtikel(ArtikelView artikel) throws ModelException {
				result = new ArtikelDefaultDetailPanel(ServiceAdminClientView.this,artikel);
				result.registerUpdater(ArtikelDefaultDetailPanel.Artikel$$hstLieferzeit, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereHstLieferzeit(artikel,Integer.parseInt(text));
					}
				});
				result.registerUpdater(ArtikelDefaultDetailPanel.Artikel$$bezeichnung, new UpdaterForString() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereBezeichnung(artikel,text);
					}
				});
				result.registerUpdater(ArtikelDefaultDetailPanel.Artikel$$maxLagerbestand, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereMaxLagerbestand(artikel, Integer.parseInt(text));
					}
				});
				result.registerUpdater(ArtikelDefaultDetailPanel.Artikel$$minLagerbestand, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aendereMinLagerbestand(artikel, Integer.parseInt(text));
					}
				});
				result.registerUpdater(ArtikelDefaultDetailPanel.Artikel$$preis, new UpdaterForInteger() {
					@Override
					public void update(String text) throws ModelException {
						getConnection().aenderePreis(artikel, Integer.parseInt(text));
					}
				});
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
        ImageView handle(AendereHerstellerPRMTRHerstellerPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(ArtikelAbhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem menuItem);
        ImageView handle(ArtikelAnhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem menuItem);
        ImageView handle(ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(ArtikelEntfernenPRMTRWarenlagerPRMTRPositionPRMTRMenuItem menuItem);
        ImageView handle(ArtikelEntnehmenPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(StatusAuslaufPRMTRArtikelPRMTRMenuItem menuItem);
        ImageView handle(ErhoeheMengePRMTRPositionPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(StatusVerkaufPRMTRArtikelPRMTRMenuItem menuItem);
        ImageView handle(HerstellerHinzufuegenPRMTRArtikelPRMTRHerstellerPRMTRMenuItem menuItem);
        ImageView handle(NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem menuItem);
        ImageView handle(NeuerHerstellerPRMTRHerstellerManagerPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ProduktgruppeEntfernenPRMTRProduktgruppePRMTRMenuItem menuItem);
        ImageView handle(ProduktgruppeHinzufuegenPRMTRProduktgruppePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(VerringereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem menuItem);
    }
    private abstract class ServiceAdminMenuItem extends MenuItem{
        private ServiceAdminMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AendereHerstellerPRMTRHerstellerPRMTRStringPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelAbhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelAnhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelEinlagernPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelEntfernenPRMTRWarenlagerPRMTRPositionPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ArtikelEntnehmenPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StatusAuslaufPRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ErhoeheMengePRMTRPositionPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StatusVerkaufPRMTRArtikelPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class HerstellerHinzufuegenPRMTRArtikelPRMTRHerstellerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class NeuerHerstellerPRMTRHerstellerManagerPRMTRStringPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ProduktgruppeEntfernenPRMTRProduktgruppePRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ProduktgruppeHinzufuegenPRMTRProduktgruppePRMTRStringPRMTRMenuItem extends ServiceAdminMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class VerringereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem extends ServiceAdminMenuItem{
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
            if (selected instanceof HerstellerView){
                item = new AendereHerstellerPRMTRHerstellerPRMTRStringPRMTRMenuItem();
                item.setText("aendereHersteller ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminAendereHerstellerHerstellerStringMssgWizard wizard = new ServiceAdminAendereHerstellerHerstellerStringMssgWizard("aendereHersteller");
                        wizard.setFirstArgument((HerstellerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof LieferartManagerView){
                item = new NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRMenuItem();
                item.setText("neueLieferArt ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminNeueLieferArtLieferartManagerStringIntegerIntegerMssgWizard wizard = new ServiceAdminNeueLieferArtLieferartManagerStringIntegerIntegerMssgWizard("neueLieferArt");
                        wizard.setFirstArgument((LieferartManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof PositionView){
                item = new AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem();
                item.setText("aendereMenge ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminAendereMengePositionIntegerMssgWizard wizard = new ServiceAdminAendereMengePositionIntegerMssgWizard("aendereMenge");
                        wizard.setFirstArgument((PositionView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ErhoeheMengePRMTRPositionPRMTRIntegerPRMTRMenuItem();
                item.setText("erhoeheMenge ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminErhoeheMengePositionIntegerMssgWizard wizard = new ServiceAdminErhoeheMengePositionIntegerMssgWizard("erhoeheMenge");
                        wizard.setFirstArgument((PositionView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new VerringereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem();
                item.setText("verringereMenge ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminVerringereMengePositionIntegerMssgWizard wizard = new ServiceAdminVerringereMengePositionIntegerMssgWizard("verringereMenge");
                        wizard.setFirstArgument((PositionView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ArtikelManagerView){
                item = new NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem();
                item.setText("neuerArtikel ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminNeuerArtikelArtikelManagerStringStringIntegerIntegerIntegerIntegerMssgWizard wizard = new ServiceAdminNeuerArtikelArtikelManagerStringStringIntegerIntegerIntegerIntegerMssgWizard("neuerArtikel");
                        wizard.setFirstArgument((ArtikelManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof HerstellerManagerView){
                item = new NeuerHerstellerPRMTRHerstellerManagerPRMTRStringPRMTRMenuItem();
                item.setText("neuerHersteller ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminNeuerHerstellerHerstellerManagerStringMssgWizard wizard = new ServiceAdminNeuerHerstellerHerstellerManagerStringMssgWizard("neuerHersteller");
                        wizard.setFirstArgument((HerstellerManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ProduktgruppeView){
                item = new ArtikelAbhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem();
                item.setText("artikelAbhaengen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelAbhaengenProduktgruppeArtikelMssgWizard wizard = new ServiceAdminArtikelAbhaengenProduktgruppeArtikelMssgWizard("artikelAbhaengen");
                        wizard.setFirstArgument((ProduktgruppeView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ArtikelAnhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem();
                item.setText("artikelAnhaengen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelAnhaengenProduktgruppeArtikelMssgWizard wizard = new ServiceAdminArtikelAnhaengenProduktgruppeArtikelMssgWizard("artikelAnhaengen");
                        wizard.setFirstArgument((ProduktgruppeView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ProduktgruppeEntfernenPRMTRProduktgruppePRMTRMenuItem();
                item.setText("produktgruppeEntfernen");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("produktgruppeEntfernen" + GUIConstants.ConfirmQuestionMark);
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().produktgruppeEntfernen((ProduktgruppeView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new ProduktgruppeHinzufuegenPRMTRProduktgruppePRMTRStringPRMTRMenuItem();
                item.setText("produktgruppeHinzufuegen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminProduktgruppeHinzufuegenProduktgruppeStringMssgWizard wizard = new ServiceAdminProduktgruppeHinzufuegenProduktgruppeStringMssgWizard("produktgruppeHinzufuegen");
                        wizard.setFirstArgument((ProduktgruppeView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
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
                item = new ArtikelEntfernenPRMTRWarenlagerPRMTRPositionPRMTRMenuItem();
                item.setText("artikelEntfernen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelEntfernenWarenlagerPositionMssgWizard wizard = new ServiceAdminArtikelEntfernenWarenlagerPositionMssgWizard("artikelEntfernen");
                        wizard.setFirstArgument((WarenlagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ArtikelEntnehmenPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem();
                item.setText("artikelEntnehmen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminArtikelEntnehmenWarenlagerArtikelIntegerMssgWizard wizard = new ServiceAdminArtikelEntnehmenWarenlagerArtikelIntegerMssgWizard("artikelEntnehmen");
                        wizard.setFirstArgument((WarenlagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ArtikelView){
                if (filter_statusAuslauf((ArtikelView) selected)) {
                    item = new StatusAuslaufPRMTRArtikelPRMTRMenuItem();
                    item.setText("einstellen");
                    item.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(javafx.event.ActionEvent e) {
                            Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle(GUIConstants.ConfirmButtonText);
                            confirm.setHeaderText(null);
                            confirm.setContentText("einstellen" + GUIConstants.ConfirmQuestionMark);
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
                }
                if (filter_statusVerkauf((ArtikelView) selected)) {
                    item = new StatusVerkaufPRMTRArtikelPRMTRMenuItem();
                    item.setText("freigeben");
                    item.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(javafx.event.ActionEvent e) {
                            Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle(GUIConstants.ConfirmButtonText);
                            confirm.setHeaderText(null);
                            confirm.setContentText("freigeben" + GUIConstants.ConfirmQuestionMark);
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
                item = new HerstellerHinzufuegenPRMTRArtikelPRMTRHerstellerPRMTRMenuItem();
                item.setText("herstellerHinzufuegen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServiceAdminHerstellerHinzufuegenArtikelHerstellerMssgWizard wizard = new ServiceAdminHerstellerHinzufuegenArtikelHerstellerMssgWizard("herstellerHinzufuegen");
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
    private boolean filter_statusAuslauf(ArtikelView argument){
        return this.getPreCalculatedFilters().contains("+++statusAuslaufPRMTRArtikelPRMTR");
    }
    private boolean filter_statusVerkauf(ArtikelView argument){
        return this.getPreCalculatedFilters().contains("+++statusVerkaufPRMTRArtikelPRMTR");
    }
    
	class ServiceAdminAendereHerstellerHerstellerStringMssgWizard extends Wizard {

		protected ServiceAdminAendereHerstellerHerstellerStringMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AendereHerstellerPRMTRHerstellerPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminAendereHerstellerHerstellerStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().aendereHersteller(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private HerstellerView firstArgument; 
	
		public void setFirstArgument(HerstellerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getName());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceAdminAendereMengePositionIntegerMssgWizard extends Wizard {

		protected ServiceAdminAendereMengePositionIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AendereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminAendereMengePositionIntegerMssgWizard.help";
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

	class ServiceAdminArtikelAbhaengenProduktgruppeArtikelMssgWizard extends Wizard {

		protected ServiceAdminArtikelAbhaengenProduktgruppeArtikelMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelAbhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelAbhaengenProduktgruppeArtikelMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelAbhaengen(firstArgument, (ArtikelView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("artikel", "view.ArtikelView", null, this);
			getParametersPanel().getChildren().add(panel1);
			panel1.setBrowserRoot((ViewRoot) getConnection().getServiceAdminView());		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ProduktgruppeView firstArgument; 
	
		public void setFirstArgument(ProduktgruppeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminArtikelAnhaengenProduktgruppeArtikelMssgWizard extends Wizard {

		protected ServiceAdminArtikelAnhaengenProduktgruppeArtikelMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelAnhaengenPRMTRProduktgruppePRMTRArtikelPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelAnhaengenProduktgruppeArtikelMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelAnhaengen(firstArgument, (ArtikelView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcAlreadyExists e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(CycleException e) {
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
				panel2.setBrowserRoot((ViewRoot)getConnection().artikel_Path_In_ArtikelAnhaengen());
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
		
		
		private ProduktgruppeView firstArgument; 
	
		public void setFirstArgument(ProduktgruppeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
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
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel3 = new ObjectSelectionPanel("artikel", "view.ArtikelView", null, this);
				getParametersPanel().getChildren().add(panel3);
				panel3.setBrowserRoot((ViewRoot)getConnection().artikel_Path_In_ArtikelEinlagern());
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
		
		
		private WarenlagerView firstArgument; 
	
		public void setFirstArgument(WarenlagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminArtikelEntfernenWarenlagerPositionMssgWizard extends Wizard {

		protected ServiceAdminArtikelEntfernenWarenlagerPositionMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelEntfernenPRMTRWarenlagerPRMTRPositionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelEntfernenWarenlagerPositionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelEntfernen(firstArgument, (PositionView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
				final ObjectSelectionPanel panel4 = new ObjectSelectionPanel("position", "view.PositionView", null, this);
				getParametersPanel().getChildren().add(panel4);
				panel4.setBrowserRoot((ViewRoot)getConnection().position_Path_In_ArtikelEntfernen());
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
		
		
		private WarenlagerView firstArgument; 
	
		public void setFirstArgument(WarenlagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminArtikelEntnehmenWarenlagerArtikelIntegerMssgWizard extends Wizard {

		protected ServiceAdminArtikelEntnehmenWarenlagerArtikelIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ArtikelEntnehmenPRMTRWarenlagerPRMTRArtikelPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminArtikelEntnehmenWarenlagerArtikelIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().artikelEntnehmen(firstArgument, (ArtikelView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
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
			try{
				final ObjectSelectionPanel panel5 = new ObjectSelectionPanel("artikel", "view.ArtikelView", null, this);
				getParametersPanel().getChildren().add(panel5);
				panel5.setBrowserRoot((ViewRoot)getConnection().artikel_Path_In_ArtikelEntnehmen());
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
		
		
		private WarenlagerView firstArgument; 
	
		public void setFirstArgument(WarenlagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminErhoeheMengePositionIntegerMssgWizard extends Wizard {

		protected ServiceAdminErhoeheMengePositionIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ErhoeheMengePRMTRPositionPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminErhoeheMengePositionIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().erhoeheMenge(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
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

	class ServiceAdminHerstellerHinzufuegenArtikelHerstellerMssgWizard extends Wizard {

		protected ServiceAdminHerstellerHinzufuegenArtikelHerstellerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new HerstellerHinzufuegenPRMTRArtikelPRMTRHerstellerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminHerstellerHinzufuegenArtikelHerstellerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().herstellerHinzufuegen(firstArgument, (HerstellerView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
				final ObjectSelectionPanel panel6 = new ObjectSelectionPanel("hersteller", "view.HerstellerView", null, this);
				getParametersPanel().getChildren().add(panel6);
				panel6.setBrowserRoot((ViewRoot)getConnection().hersteller_Path_In_HerstellerHinzufuegen());
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
		
		
		private ArtikelView firstArgument; 
	
		public void setFirstArgument(ArtikelView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((Anything)firstArgument.getHersteller());
				if (!selectionPanel0.check()) selectionPanel0.preset((Anything)null);
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceAdminNeueLieferArtLieferartManagerStringIntegerIntegerMssgWizard extends Wizard {

		protected ServiceAdminNeueLieferArtLieferartManagerStringIntegerIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeueLieferArtPRMTRLieferartManagerPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminNeueLieferArtLieferartManagerStringIntegerIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neueLieferArt(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(1)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(2)).getResult().longValue());
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
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("preis", this));		
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

	class ServiceAdminNeuerArtikelArtikelManagerStringStringIntegerIntegerIntegerIntegerMssgWizard extends Wizard {

		protected ServiceAdminNeuerArtikelArtikelManagerStringStringIntegerIntegerIntegerIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeuerArtikelPRMTRArtikelManagerPRMTRStringPRMTRStringPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminNeuerArtikelArtikelManagerStringStringIntegerIntegerIntegerIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neuerArtikel(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getChildren().get(2)).getResult().longValue(),
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
			getParametersPanel().getChildren().add(new IntegerSelectionPanel("preis", this));
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

	class ServiceAdminNeuerHerstellerHerstellerManagerStringMssgWizard extends Wizard {

		protected ServiceAdminNeuerHerstellerHerstellerManagerStringMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new NeuerHerstellerPRMTRHerstellerManagerPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminNeuerHerstellerHerstellerManagerStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().neuerHersteller(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private HerstellerManagerView firstArgument; 
	
		public void setFirstArgument(HerstellerManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServiceAdminProduktgruppeHinzufuegenProduktgruppeStringMssgWizard extends Wizard {

		protected ServiceAdminProduktgruppeHinzufuegenProduktgruppeStringMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ProduktgruppeHinzufuegenPRMTRProduktgruppePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminProduktgruppeHinzufuegenProduktgruppeStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().produktgruppeHinzufuegen(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcAlreadyExists e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(CycleException e) {
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
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ProduktgruppeView firstArgument; 
	
		public void setFirstArgument(ProduktgruppeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getName());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServiceAdminVerringereMengePositionIntegerMssgWizard extends Wizard {

		protected ServiceAdminVerringereMengePositionIntegerMssgWizard(String operationName){
			super(ServiceAdminClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new VerringereMengePRMTRPositionPRMTRIntegerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServiceAdminVerringereMengePositionIntegerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().verringereMenge(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getChildren().get(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ExcLagerbestandUnderZero e) {
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