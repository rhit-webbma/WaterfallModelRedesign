package simse.gui;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simse.adts.objects.SoftwareEngineer;
import simse.gui.util.JavaFXHelpers;
import simse.logic.Logic;
import simse.state.State;

public class EmployeeInfoScreen extends Stage implements EventHandler<MouseEvent>{
	ContextMenu actions;
	VBox mainPane;
	SimSEGUI gui;
	Logic logic;
	State state;
	SoftwareEngineer engineer;
	
	Button actionsButton; 
	ListView<String> attributes;
	
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
		this.mainPane = new VBox();
		this.actions = new ContextMenu();
		this.engineer = engineer;
		
		String engineerName = engineer.getName();
		this.setTitle(engineerName);
		
		Vector<String> menuItems = engineer.getMenu();
		for (int i = 0; i < menuItems.size(); i++) {
			String item = menuItems.elementAt(i);
			MenuItem tempItem = new MenuItem(item);
			tempItem.setOnAction(menuItemEvent);
			actions.getItems().add(tempItem);
		}
		
		StackPane imagePane = new StackPane();
		imagePane.setMinSize(110, 110);
		ImageView img = JavaFXHelpers.createImageView("src/simse/gui/icons/" + engineer.getName() + ".gif");
		if (img == null) {
			img = JavaFXHelpers.createImageView("src/simse/gui/icons/alex.gif");
		}
		img.setScaleX(2);
		img.setScaleY(2);
		imagePane.getChildren().add(img);
		
		
		actionsButton = new Button("Assign Employee to Tasks");
		actionsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		
		attributes = new ListView<String>();
		attributes.getItems().add("Energy: " + Double.toString(engineer.getEnergy()));
		attributes.getItems().add("Mood: " + Double.toString(engineer.getMood()));
		attributes.getItems().add("Requirements Experience: " + engineer.getRequirementsExperience());
		attributes.getItems().add("Design Experience: " + engineer.getDesignExperience());
		attributes.getItems().add("Coding Experience: " + engineer.getCodingExperience());
		attributes.getItems().add("Testing Experience: " + engineer.getTestingExperience());
		attributes.getItems().add("Pay Rate: " + Double.toString(engineer.getPayRate()));
		attributes.getItems().add("On Break: " + Boolean.toString(engineer.getOnBreak()));
		attributes.setMaxHeight(attributes.getItems().size()*24);
		
		String objTypeFull = engineer.getClass().toString();
		String[] objTypeArr = objTypeFull.split("\\.");
		String objType = objTypeArr[objTypeArr.length - 1];
		String objTypeType = "Employee";
		String title = engineerName + " Attributes";
		ObjectGraphPane objGraph = new ObjectGraphPane(title, gui.getLog(), objTypeType, objType, engineerName, gui.getBranch(), gui);		
		
		Label name = new Label(engineer.getName());
		name.setFont(new Font(30));
		mainPane.getChildren().add(name);
		mainPane.getChildren().add(imagePane);
		mainPane.getChildren().add(actionsButton);
		mainPane.getChildren().add(attributes);
		mainPane.getChildren().add(objGraph);
		mainPane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(mainPane, 500, 700);
		this.setScene(scene);
	}
	
	public void popupMenuActions(MenuItem source) {
		MenuItem item = (MenuItem) source;
		logic.getMenuInputManager().menuItemSelected(engineer, item.getText(), gui);
		gui.getWorld().update();
	}

	@Override
	public void handle(MouseEvent e) {
		actions.show(mainPane, e.getScreenX(), e.getScreenY());
	}
	
}
