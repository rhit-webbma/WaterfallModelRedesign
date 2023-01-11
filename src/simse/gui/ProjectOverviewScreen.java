package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import simse.adts.objects.SEProject;
import simse.adts.objects.Tool;
import simse.state.State;
import simse.util.RuleType;

public class ProjectOverviewScreen extends Stage implements EventHandler<MouseEvent>{
	
	State state;
	SimSEGUI gui;

	Label titleLabel;
	Label toolsLabel;
	
	TableModel<SEProject> tableModel;
	TableView<SEProject> table;
	
	TableModel<Tool> tableModel2;
	TableView<Tool> table2;
	
	Button rules, projectTab, toolsTab;
	boolean lastClickedProject;
	
	BorderPane projectPane, toolsPane;
	VBox mainPane, graphPane;
	
	
	public ProjectOverviewScreen(State s, SimSEGUI gui) {
		this.state = s;
		this.gui = gui;
		lastClickedProject = true;
		
		this.setTitle("Project Screen");
		mainPane = new VBox();
		
		HBox tabsPane = new HBox();
		tabsPane.setSpacing(0);
		projectTab = new Button("Project");
		projectTab.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		projectTab.setMinWidth(450);
		toolsTab = new Button("Tools");
		toolsTab.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		toolsTab.setMinWidth(450);
		tabsPane.getChildren().addAll(projectTab, toolsTab);
		mainPane.getChildren().add(tabsPane);
		
		createTabs();
		mainPane.getChildren().add(projectPane);
		updateGraph();
		mainPane.getChildren().add(graphPane);
		
		HBox buttonPane = new HBox();
		
		rules = new Button("Rules for Projects/Tools");
		rules.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		buttonPane.getChildren().add(rules);
		mainPane.getChildren().add(buttonPane);
		
		Scene scene = new Scene(mainPane, 900, 700);
		this.setScene(scene);
	}
	
	private void createTabs() {
		projectPane = new BorderPane();
		titleLabel = new Label("Projects");
		titleLabel.setFont(new Font(36));
		
		Separator separator = new Separator();
		separator.setPadding(new Insets(10, 0, 15, 0));
		
		VBox projectTopPane = new VBox();
		projectTopPane.getChildren().add(titleLabel);
		projectTopPane.getChildren().add(separator);
		projectPane.setTop(projectTopPane);
		projectTopPane.setAlignment(Pos.TOP_CENTER);
		BorderPane.setAlignment(projectTopPane, Pos.TOP_CENTER);
		
		tableModel = new SEProjectTableModel(this.state);
		table = tableModel.createTable();
		table.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		table.setMaxHeight(50);
		projectPane.setCenter(table);
		
		toolsPane = new BorderPane();
		toolsLabel = new Label("Tools");
		toolsLabel.setFont(new Font(36));
		
		Separator separator2 = new Separator();
		separator2.setPadding(new Insets(10, 0, 15, 0));
		VBox toolsTopPane = new VBox();
		toolsTopPane.getChildren().add(toolsLabel);
		toolsTopPane.getChildren().add(separator2);
		toolsPane.setTop(toolsTopPane);
		toolsTopPane.setAlignment(Pos.TOP_CENTER);
		BorderPane.setAlignment(toolsTopPane, Pos.TOP_CENTER);
		
		tableModel2 = new ToolTableModel(this.state);
		table2 = tableModel2.createTable();
		table2.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		table2.setMaxHeight(50);
		toolsPane.setCenter(table2);
	}
	
	private void updateGraph() {
		graphPane = new VBox();
		String objType = "";
		String objTypeType = "";
		String title = "";
		String name = "";
		if (lastClickedProject) {
			objType = "SEProject";
			objTypeType = "Project";
			name = tableModel.getData().get(0).getDescription();
		} else {
			objType = tableModel2.getData().get(0).getClass().getSimpleName();
			objTypeType = "Tool";
			name = tableModel2.getData().get(0).getDescription();
		}
		title = name + " Attributes";
		ObjectGraphPanel objGraph = new ObjectGraphPanel(title, gui.getLog(), objTypeType, objType, 
				name, gui.getBranch());
		while (graphPane.getChildren().size() > 0) {
			graphPane.getChildren().remove(0);
		}
		graphPane.getChildren().add(objGraph);
	}

	public void update() {
		if (lastClickedProject) {
			projectPane.getChildren().remove(table);
			tableModel = new SEProjectTableModel(state);
			table = tableModel.createTable();
			projectPane.setCenter(table);
			if (!mainPane.getChildren().contains(projectPane)) {
				mainPane.getChildren().add(1, projectPane);
			}
			if (mainPane.getChildren().contains(toolsPane)) {
				mainPane.getChildren().remove(toolsPane);
			}
		} else {
			toolsPane.getChildren().remove(table2);
			tableModel2 = new ToolTableModel(state);
			table2 = tableModel2.createTable();
			toolsPane.setCenter(table2);
			if (!mainPane.getChildren().contains(toolsPane)) {
				mainPane.getChildren().add(1, toolsPane);
			}
			if (mainPane.getChildren().contains(projectPane)) {
				mainPane.getChildren().remove(projectPane);
			}
		}
		updateGraph();
	}
	
	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source == rules) {
			RulesInfoScreen info = new RulesInfoScreen(state, RuleType.PROJECT);
			info.show();
		} else if (source == projectTab) {
			lastClickedProject = true;
			update();
		} else if (source == toolsTab) {
			lastClickedProject = false;
			update();
		}
	}

}
