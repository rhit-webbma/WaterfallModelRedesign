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

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SimSEGUI extends Stage implements EventHandler<Event> {
	private TabPanel tabPanel;
	private AttributePanel attribPanel;
	private ActionPanel actionPanel;

	// Analyze menu:
	private MenuBar menuBar; // menu bar at top of window
	private Menu analyzeMenu; // analyze menu
	private MenuItem analyzeSimItem; // menu item in "Analyze" menu

	private State state;
	private Logic logic;
	private Engine engine;
	private World world;
	private ExplanatoryTool expTool;
	private static MultipleTimelinesBrowser timelinesBrowser;
	private Branch branch; // branch associated with this particular game
	
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

		expTool = new ExplanatoryTool(this, state.getLogger().getLog(), branch,
				timelinesBrowser);

//		attribPanel = new AttributePanel(this, state, engine);
		tabPanel = new TabPanel(this, state, logic, attribPanel);
//		actionPanel = new ActionPanel(this, state, logic);

		// Set window title:
		String title = "SimSE";
		if (branch.getName() != null) {
			title = title.concat(" - " + branch.getName());
		}
		this.setTitle(title);

		menuBar = new MenuBar();
		// Analyze menu:
		analyzeMenu = new Menu("Analyze"); // "Analyze" menu
		analyzeSimItem = new MenuItem("Analyze Simulation");
		analyzeMenu.getItems().add(analyzeSimItem);
//		analyzeSimItem.setOnAction((EventHandler<ActionEvent>) this);
		menuBar.getMenus().add(analyzeMenu);

		// Add menu bar to this frame:
		// create a scene
        Scene sc = new Scene(menuBar, 500, 300);
  
        // set the scene
        this.setScene(sc);

		// Create main panel:
        BorderPane bPane = new BorderPane();
		bPane.setTop(tabPanel);
		bPane.setBottom(attribPanel);
//		world = new World(state, logic, this);
		bPane.setCenter(world);
		bPane.setRight(actionPanel);
		
		bPane.setPrefSize(1024, 710);
		Scene mainPane = new Scene(bPane);

		// Set main window frame properties:
		mainPane.setFill(Color.WHITE);
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
		if (!timelinesBrowser.isVisible() && SimSE.getNumOpenBranches() == 0) {
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
			if (source == analyzeSimItem) {
				if (expTool.isIconified()) {
					expTool.setIconified(false);
				}
			expTool.show();
			}
		}
		
	}
}