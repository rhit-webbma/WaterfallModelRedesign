package simse.gui;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simse.adts.objects.SoftwareEngineer;
import simse.logic.Logic;
import simse.state.State;

public class EmployeeInfoScreen extends Stage {
	ListView<MenuItem> actions;
	GridPane mainPane;
	SimSEGUI gui;
	Logic logic;
	State state;
	SoftwareEngineer engineer;
	
	private EventHandler<ActionEvent> menuItemEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if (source instanceof MenuItem) {
				popupMenuActions((MenuItem) source);
			}
		}
	};

	public EmployeeInfoScreen(State s, SimSEGUI gui, Logic l, SoftwareEngineer engineer) {
		this.state = s;
		this.gui = gui;
		this.logic = l;
		this.mainPane = new GridPane();
		this.actions = new ListView<MenuItem>();
		
		this.setTitle(engineer.getName());
		
		Vector<String> menuItems = engineer.getMenu();
		for (int i = 0; i < menuItems.size(); i++) {
			String item = menuItems.elementAt(i);
			MenuItem tempItem = new MenuItem(item);
			tempItem.setOnAction(menuItemEvent);
			actions.getItems().add(tempItem);
		}
		
		StackPane imagePane = new StackPane();
		imagePane.setMinSize(200, 200);
		
		
		mainPane.add(new Label(engineer.getName()), 0, 0, 2, 1);
		mainPane.add(imagePane, 0, 1);
		mainPane.add(actions, 1, 1);
	}
	
	public void popupMenuActions(MenuItem source) {
		MenuItem item = (MenuItem) source;
		logic.getMenuInputManager().menuItemSelected(engineer, item.getText(), gui);
		gui.getWorld().update();
	}
	
}
