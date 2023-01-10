package simse.gui;


import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import simse.adts.objects.Artifact;
import simse.explanatorytool.Branch;
import simse.gui.util.JavaFXHelpers;
import simse.logic.Logic;
import simse.state.State;

public class ArtifactInfoScreen extends Stage implements EventHandler<MouseEvent>{
	
	ContextMenu actions;
	VBox mainPane;
	SimSEGUI gui;
	Logic logic;
	State state;
	Artifact artifact;
	
	Button actionsButton;
	ListView<String> attributes;
	
	public ArtifactInfoScreen(State s, SimSEGUI gui, Logic l, Artifact artifact) {
		this.state = s;
		this.gui = gui;
		this.logic = l;
		this.artifact = artifact;
		this.actions = new ContextMenu();
		this.mainPane = new VBox();
		String artifactName = artifact.getName();
		this.setTitle(artifactName);
		
		StackPane imagePane = new StackPane();
		imagePane.setMinSize(110, 110);
		ImageView img = JavaFXHelpers.createImageView("src/simse/gui/icons/" + artifact.getName() + ".gif");
		if (img == null) {
			img = JavaFXHelpers.createImageView("src/simse/gui/icons/3.gif");
		}
		img.setScaleX(2);
		img.setScaleY(2);
		imagePane.getChildren().add(img);
		
		actionsButton = new Button("Assign Employees to work on Artifact");
		actionsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		
		attributes = new ListView<String>();
		attributes.getItems().add("Size: " + Double.toString(artifact.getSize()));
		attributes.getItems().add("Number of Errors: " + Double.toString(artifact.getNumKnownErrors()));
		attributes.getItems().add("Percent Completed: " + Double.toString(artifact.getPercentComplete()));
		attributes.getItems().add("Percent Erroneous: " + Double.toString(artifact.getPercentErroneous()));
		attributes.setMaxHeight(attributes.getItems().size()*25);
		
		String objTypeFull = artifact.getClass().toString();
		String[] objTypeArr = objTypeFull.split("\\.");
		String objType = objTypeArr[objTypeArr.length - 1];
		String objTypeType = "Artifact";
		String title = artifactName + " Attributes";
		ObjectGraphPanel objGraph = new ObjectGraphPanel(title, gui.getLog(), objTypeType, objType, artifactName, gui.getBranch());
		
		Label name = new Label(artifact.getName());
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

	@Override
	public void handle(MouseEvent e) {
		System.out.println("click");
		actions.show(mainPane, e.getScreenX(), e.getScreenY());
	}

}
