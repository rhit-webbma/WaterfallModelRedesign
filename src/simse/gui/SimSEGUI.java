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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SimSEGUI extends Stage implements EventHandler<Event> {
	private TabPanel tabPanel;
	private AttributePanel attribPanel;
	private ActionPanel actionPanel;

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
					engine.getTimer().stop();
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

		attribPanel = new AttributePanel(this, state, engine);
		tabPanel = new TabPanel(this, state, logic, attribPanel);
		actionPanel = new ActionPanel(this, state, logic);

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
		bPane.setBottom(attribPanel);
		world = new World(state, logic, this);
		bPane.setCenter(world);
		bPane.setRight(actionPanel);
		
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

	public AttributePanel getAttributePanel() {
		return attribPanel;
	}

	public TabPanel getTabPanel() {
		return tabPanel;
	}

	// forces gui to update, used when the game ends
	public void forceGUIUpdate() {
		tabPanel.setGUIChanged();
		attribPanel.setGUIChanged();
		update();
	}

	// Update the GUI to reflect the current state:
	public void update() {
		tabPanel.update();
		attribPanel.update();
		world.update();
		actionPanel.update();
		expTool.update();
		branch.update(state);
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
}