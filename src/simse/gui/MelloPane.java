package simse.gui;

import java.util.Vector;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import simse.gui.util.JavaFXHelpers;

public class MelloPane extends Pane {
	
	private GridPane mello;
	private ScrollPane inProgress;
	private ScrollPane complete;
	private VBox prog;
	private VBox comp;
	
	public MelloPane() {
		VBox pane = new VBox();
		HBox top = new HBox();
		top.getChildren().add(JavaFXHelpers.createImageView("src/simse/gui/icons/mello.png"));
		top.getChildren().add(new Text("Mello"));
		top.setPrefWidth(600);
		top.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(128, 128, 128)));
		
		inProgress = new ScrollPane();
		prog = new VBox();
		prog.heightProperty().addListener(observable -> inProgress.setVvalue(1D));
		prog.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		inProgress.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		inProgress.setContent(prog);
		inProgress.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		inProgress.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		inProgress.setPrefHeight(400);
		inProgress.setMaxHeight(400);
		inProgress.setVvalue(1.0);
		inProgress.setFitToWidth(true);
		
		complete = new ScrollPane();
		comp = new VBox();
		comp.heightProperty().addListener(observable -> complete.setVvalue(1D));
		comp.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		complete.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		complete.setContent(comp);
		complete.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		complete.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		complete.setPrefHeight(400);
		complete.setMaxHeight(400);
		complete.setVvalue(1.0);
		complete.setFitToWidth(true);
		
		mello = new GridPane();
		mello.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		inProgress.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		complete.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		prog.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		comp.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(217, 217, 217)));
		
		mello.add(new Text("In Progress"), 0, 0);
		mello.add(new Text("Complete"), 1, 0);
		mello.add(inProgress, 0, 1);
		mello.add(complete, 1, 1);
		
		pane.getChildren().add(top);
		pane.getChildren().add(mello);
		
		

		this.getChildren().add(pane);
	}
	
	public void addTaskInProgress(String task, Vector<String> employees) {
		prog.getChildren().add(new MelloItem(task, employees));
	}
	
	public void completeTask(String task) {
		MelloItem found = findTaskInProgress(task);
		if (found != null) prog.getChildren().remove(found);
		comp.getChildren().add(found);
	}
	
	private MelloItem findTaskInProgress(String task) {
		for (Node n : prog.getChildren()) {
			if (n instanceof MelloItem) {
				if (((MelloItem) n).isTask(task)) return (MelloItem) n;
			}
		}
		return null;
	}

}
