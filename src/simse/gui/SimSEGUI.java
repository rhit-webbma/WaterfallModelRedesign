/* File generated by: simse.codegenerator.guigenerator.GUIGenerator */
package simse.gui;

import simse.SimSE;
import simse.state.*;
import simse.logic.*;
import simse.engine.*;
import simse.explanatorytool.Branch;
import simse.explanatorytool.ExplanatoryTool;
import simse.explanatorytool.MultipleTimelinesBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import simse.engine.Engine;
import simse.logic.Logic;
import simse.state.State;

public class SimSEGUI extends Stage implements EventHandler<Event> {
	private TabPanel tabPanel;
	private InformationPanel infoPanel;
	private EmployeesPanel employeesPanel;
	private TrackPanel trackPanel;
	private MelloPanel melloPanel;
	private ObjectGraphPanel objGraphPanel;
	private VBox objGraphWrapper;
	private Pane panel1 = new Pane();
	private Pane panel2 = new Pane();
	private Pane panel3 = new Pane();

	// Analyze menu:
	private MenuBar menuBar; // menu bar at top of window
	private Menu analyzeMenu; // analyze menu
	private MenuItem analyzeSimItem; // menu item in "Analyze" menu
	private Menu extrasMenu;
	private MenuItem infoSimItem;
	private Menu resetMenu;
	private MenuItem resetSimItem;

	private State state;
	private Logic logic;
	private Engine engine;
	private World world;
	private ExplanatoryTool expTool;
	private static MultipleTimelinesBrowser timelinesBrowser;
	private Branch branch; // branch associated with this particular game
	
	private EventHandler<ActionEvent> menuEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event)
        {
        	Object source = event.getSource(); // get which component the action came from
			if (source == analyzeSimItem) {
				if (expTool.isIconified()) {
					expTool.setIconified(false);
				}
			expTool.show();
			}
        }
    };
    
    private EventHandler<ActionEvent> infoEvent = new EventHandler<ActionEvent>() {
    	public void handle(ActionEvent event) {
    		new StartingNarrativeDialog();
    	}
    };
    
    private EventHandler<ActionEvent> resetEvent = new EventHandler<ActionEvent>() {
    	public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Reset Game?");
			String s = "Are You Sure You Want To Reset?";
			alert.setContentText(s);
			 
			Optional<ButtonType> result = alert.showAndWait();
			 
			if (result.get() == ButtonType.OK) {
				if (engine.getTimer() != null) {
					engine.stopTimer();
				}
				close();
				SimSE.main(new String[] {});
			}
    	}
    };
	
	public SimSEGUI(Engine e, State s, Logic l, Branch branch,
			MultipleTimelinesBrowser browser) {
		this.branch = branch;
		timelinesBrowser = browser;
		reset(e, s, l);
	}

	public void reset(Engine e, State s, Logic l) {
		state = s;
		logic = l;
		engine = e;

		expTool = new ExplanatoryTool(state.getLogger().getLog(), branch, timelinesBrowser);

		infoPanel = new InformationPanel(this, state, engine);
		tabPanel = new TabPanel(this, state, logic, engine, infoPanel, expTool);
		employeesPanel = new EmployeesPanel(this, state, logic);
//		objGraphWrapper = new VBox();
		objGraphPanel = new ObjectGraphPanel("Groceries@Home Attributes", getLog(), "Project", "SEProject", 
				"Groceries@Home", this.branch, this);
//		objGraphWrapper.getChildren().add(objGraphPanel);
		trackPanel = TrackPanel.getInstance();
		melloPanel = MelloPanel.getInstance();

		// Set window title:
		String title = "SimSE";
		if (branch.getName() != null) {
			title = title.concat(" - " + branch.getName());
		}
		this.setTitle(title);

		menuBar = new MenuBar();
		// Analyze menu:
		analyzeMenu = new Menu("Analyze"); // "Analyze" menu
		extrasMenu = new Menu("Extra");
		infoSimItem = new MenuItem("Info");
		resetSimItem = new MenuItem("Reset");
		analyzeSimItem = new MenuItem("Analyze Simulation");
		
		analyzeMenu.getItems().add(analyzeSimItem);
		extrasMenu.getItems().add(infoSimItem);
		extrasMenu.getItems().add(resetSimItem);
		analyzeSimItem.setOnAction(menuEvent);
		infoSimItem.setOnAction(infoEvent);
		resetSimItem.setOnAction(resetEvent);
		menuBar.getMenus().add(analyzeMenu);
		menuBar.getMenus().add(extrasMenu);
		
		// Create main panel:
        BorderPane bPane = new BorderPane();
		bPane.setTop(tabPanel);
		world = new World(state, logic, this);
		bPane.setCenter(world);
		HBox panelContainer = new HBox(panel1, panel2);
		panel1.getChildren().add(infoPanel);
		panelContainer.setPrefWidth(bPane.getWidth());
		bPane.setBottom(panelContainer);
		panel3.getChildren().add(employeesPanel);
		panel3.setPrefHeight(450);
		bPane.setRight(panel3);
		
		bPane.setPrefSize(1024, 710);
		VBox panes = new VBox();
		panes.getChildren().addAll(menuBar, bPane);
		Scene mainPane = new Scene(panes);

		// Set main window frame properties:
		mainPane.setFill(Color.WHITE);
		mainPane.getStylesheets().add("style.css");
		this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
		this.setScene(mainPane);
//		this.setSize(bPane.getLayout().preferredLayoutSize(this));
		// Make it show up in the center of the screen:
//		setLocationRelativeTo(null);
		
//		this.show();
	}

	public Engine getEngine() {
		return engine;
	}

	public State getSimSEState() {
		return state;
	}

	public World getWorld() {
		return world;
	}

	public InformationPanel getAttributePanel() {
		return infoPanel;
	}

	public TabPanel getTabPanel() {
		return tabPanel;
	}
	
	public ArrayList<State> getLog() {
		return this.expTool.getLog();
	}
	
	public Branch getBranch() {
		return this.branch;
	}

	// forces gui to update, used when the game ends
	public void forceGUIUpdate() {
		tabPanel.setGUIChanged();
		infoPanel.setGUIChanged();
		update();
	}

	// Update the GUI to reflect the current state:
	public void update() {
		tabPanel.update();
		infoPanel.update();
		world.update();
		employeesPanel.update();
		expTool.update();
		branch.update(state);
//		updateGraph();
		objGraphPanel.update();
	}
	
	public void updateGraph() {
		if (objGraphWrapper.getChildren().contains(objGraphPanel)) {
			objGraphWrapper.getChildren().remove(objGraphPanel);
			objGraphPanel = new ObjectGraphPanel("Groceries@Home Attributes", getLog(), "Project", "SEProject", 
					"Groceries@Home", this.branch, this);
			objGraphWrapper.getChildren().add(objGraphPanel);
		}
	}

	public void close() {
		branch.setClosed();
		if (!timelinesBrowser.isShowing() && SimSE.getNumOpenBranches() == 0) {
			System.exit(0);
		}
		timelinesBrowser.update();
	}

	@Override
	public void handle(Event event) {
		if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
			close();
		} else if (event.getEventType() ==  ActionEvent.ACTION) {
			Object source = event.getSource(); // get which component the action came from
			System.out.println("Got action event from " + source.toString());
			if (source == analyzeSimItem) {
				if (expTool.isIconified()) {
					expTool.setIconified(false);
				}
			expTool.show();
			}
		}
		
	}

	public List<Panels> getPresentPanels() {
		List<Panels> panels = new ArrayList<>();
		if (panel1.getChildren().size() != 0) {
			SimSEPanel subPanel1= (SimSEPanel) panel1.getChildren().get(0);
			panels.add(subPanel1.getPanelType());
		}
		if (panel2.getChildren().size() != 0) {
			SimSEPanel subPanel2= (SimSEPanel) panel2.getChildren().get(0);
			panels.add(subPanel2.getPanelType());
		}
		if (panel3.getChildren().size() != 0) {
			SimSEPanel subPanel3= (SimSEPanel) panel3.getChildren().get(0);
			panels.add(subPanel3.getPanelType());
		}
		return panels;
	}
	
	public void addBottomPanel(Panels panelType) {
		if (panel1.getChildren().size() == 0) {
			switch (panelType) {
			
			case INFORMATION:
				panel1.getChildren().add(infoPanel);
				break;
				
			case TRACK:
				panel1.getChildren().add(trackPanel);
				break;
				
			case MELLO:
				panel1.getChildren().add(melloPanel);
				break;
				
			case GRAPH:
				objGraphPanel.update();
				panel1.getChildren().add(objGraphPanel);
				break;
				
			default:
				break;
			}
		} else if (panel2.getChildren().size() == 0) {
			switch (panelType) {
			
			case INFORMATION:
				panel2.getChildren().add(infoPanel);
				break;
				
			case TRACK:
				panel2.getChildren().add(trackPanel);
				break;
				
			case MELLO:
				panel2.getChildren().add(melloPanel);
				break;
				
			case GRAPH:
				objGraphPanel.update();
				panel2.getChildren().add(objGraphPanel);
				break;
				
			default:
				break;
			}
		} else {
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("Panels Full");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			Panels p1Type = ((SimSEPanel) panel1.getChildren().get(0)).getPanelType();
			Panels p2Type = ((SimSEPanel) panel2.getChildren().get(0)).getPanelType();
			dialog.setContentText("Bottom of GUI is full, remove either " + p1Type.toString() +
					" or " + p2Type.toString() + " from the view to make space");
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.showAndWait();
		}
		
		tabPanel.update();
	}
	
	public void addSidePanel(Panels panelType) {
		if (panel3.getChildren().size() == 0) {
			switch (panelType) {
			
			case EMPLOYEES:
				panel3.getChildren().add(employeesPanel);
				break;
				
			default:
				break;
			}
		} else {
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("Panels Full");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			Panels p3Type = ((SimSEPanel) panel1.getChildren().get(0)).getPanelType();
			dialog.setContentText("Side of GUI is full, remove " + p3Type.toString() +
					" from the view to make space");
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.showAndWait();
		}
		
		tabPanel.update();
	}
	
	public void removePanel(Panels panelType) {
		boolean p1Empty = (panel1.getChildren().size() == 0);
		boolean p2Empty = (panel2.getChildren().size() == 0);
		boolean p3Empty = (panel3.getChildren().size() == 0);
		switch (panelType) {
		
		case INFORMATION:
			if (!p1Empty && panel1.getChildren().get(0) instanceof InformationPanel) {
				panel1.getChildren().clear();
			} else if (!p2Empty && panel2.getChildren().get(0) instanceof InformationPanel) {
				panel2.getChildren().clear();
			}
			break;
			
		case EMPLOYEES:
			if (!p3Empty&& panel3.getChildren().get(0) instanceof EmployeesPanel) {
				panel3.getChildren().clear();
			}
			break;
			
		case TRACK:
			if (!p1Empty && panel1.getChildren().get(0) instanceof TrackPanel) {
				panel1.getChildren().clear();
			} else if (!p2Empty && panel2.getChildren().get(0) instanceof TrackPanel) {
				panel2.getChildren().clear();
			}
			break;
			
		case MELLO:
			if (!p1Empty && panel1.getChildren().get(0) instanceof MelloPanel) {
				panel1.getChildren().clear();
			} else if (!p2Empty && panel2.getChildren().get(0) instanceof MelloPanel) {
				panel2.getChildren().clear();
			}
			break;
			
		case GRAPH:
			if (!p1Empty && panel1.getChildren().get(0) instanceof ObjectGraphPanel) {
				panel1.getChildren().clear();
			} else if (!p2Empty && panel2.getChildren().get(0) instanceof ObjectGraphPanel) {
				panel2.getChildren().clear();
			}
			break;
			
		default:
			break;
		}
		
		tabPanel.update();
	}
}