package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import simse.logic.Logic;
import simse.state.State;

public class PanelsScreen extends Stage implements EventHandler<MouseEvent> {
	State state;
	SimSEGUI gui;
	Logic logic;
	
	GridPane mainPane;

	@Override
	public void handle(MouseEvent arg0) {
		
	}

	public PanelsScreen(State state, SimSEGUI gui, Logic logic) {
		super();
		this.state = state;
		this.gui = gui;
		this.logic = logic;
		
		this.setTitle("Windows Screen");
		
		mainPane = new GridPane();
		mainPane.setGridLinesVisible(true);
		mainPane.getColumnConstraints().add(new ColumnConstraints(100, 100, 100, Priority.SOMETIMES,
				HPos.CENTER, false));
		mainPane.getColumnConstraints().add(new ColumnConstraints(200, 200, 200, Priority.SOMETIMES,
				HPos.CENTER, false));
		mainPane.getColumnConstraints().add(new ColumnConstraints(70, 70, 70, Priority.SOMETIMES,
				HPos.CENTER, false));
		mainPane.getColumnConstraints().add(new ColumnConstraints(100, 100, 100, Priority.SOMETIMES,
				HPos.CENTER, false));
		
		mainPane.add(new Label("Window Name"), 0, 0);
		mainPane.add(new Label("Description"), 1, 0);
		mainPane.add(new Label("Possible\nLocations"), 2, 0);
		mainPane.add(new Label("Add/Remove"), 3, 0);
		
		mainPane.setPrefSize(300, 200);
		this.setScene(new Scene(mainPane));
		
	}

}
