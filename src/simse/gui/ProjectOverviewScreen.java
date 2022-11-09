package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import simse.state.State;

public class ProjectOverviewScreen extends Stage implements EventHandler<MouseEvent>{
	
	State state;

	Label titleLabel;
	Label toolsLabel;
	
	TableModel tableModel;
	TableView table;
	
	TableModel tableModel2;
	TableView table2;
	
	BorderPane tablePane, tablePane2;
	VBox mainPane;
	
	
	public ProjectOverviewScreen(State s) {
	this.state = s;
	this.setTitle("Project Screen");
	mainPane = new VBox();
	
	mainPane = new VBox();
	BorderPane title = new BorderPane();
	titleLabel = new Label("Projects");
	titleLabel.setFont(new Font(36));
	title.setCenter(titleLabel);
	mainPane.getChildren().add(title);
	
	Separator separator = new Separator();
	separator.setPadding(new Insets(10, 0, 15, 0));
	mainPane.getChildren().add(separator);
	
	tableModel = new SEProjectTableModel(s);
	table = tableModel.createTable();
	table.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

	// Create panes:
	tablePane = new BorderPane(table);
	tablePane.setCenter(table);
	mainPane.getChildren().add(tablePane);
	
	BorderPane tools = new BorderPane();
	toolsLabel = new Label("Tools");
	toolsLabel.setFont(new Font(36));
	tools.setCenter(toolsLabel);
	mainPane.getChildren().add(tools);
	
	Separator separator2 = new Separator();
	separator2.setPadding(new Insets(10, 0, 15, 0));
	mainPane.getChildren().add(separator2);
	
	tableModel2 = new ToolTableModel(s);
	table2 = tableModel2.createTable();
	table2.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
	
	tablePane2 = new BorderPane(table2);
	tablePane2.setCenter(table2);
	mainPane.getChildren().add(tablePane2);
	
	
	Scene scene = new Scene(mainPane, 900, 500);
	this.setScene(scene);
	}

	public void update() {
		mainPane.getChildren().remove(tablePane);
		tableModel = new SEProjectTableModel(state);
		table = tableModel.createTable();
		tablePane = new BorderPane(table);
		tablePane.setCenter(table);
		mainPane.getChildren().add(2, tablePane);
		
		mainPane.getChildren().remove(tablePane2);
		tableModel2 = new ToolTableModel(state);
		table2 = tableModel2.createTable();
		tablePane2 = new BorderPane(table2);
		tablePane2.setCenter(table2);
		mainPane.getChildren().add(5, tablePane2);
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
