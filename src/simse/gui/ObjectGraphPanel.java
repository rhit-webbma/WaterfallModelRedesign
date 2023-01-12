package simse.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ObjectGraphPanel extends Pane implements SimSEPanel, EventHandler<MouseEvent>{

	private String title;
	private String objTypeType;
	private String objType;
	private String keyAttVal;
	private ObjectGraphPane objGraph;
	private Button updateGraph;
	private SimSEGUI gui;
	
	public ObjectGraphPanel(SimSEGUI gui) {
		VBox mainPane = new VBox();
		this.gui = gui;
		this.title = "Groceries@Home Attributes";
		this.objTypeType = "Project";
		this.objType = "SEProject";
		this.keyAttVal = "Groceries@Home";
		this.objGraph = new ObjectGraphPane(title, gui.getLog(), objTypeType, objType, keyAttVal, gui.getBranch(), gui);
	
		mainPane.getChildren().add(objGraph);
		
		updateGraph = new Button("Update Graph");
		updateGraph.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		mainPane.getChildren().add(updateGraph);
		
		this.getChildren().add(mainPane);
	}
	
	public void update() {
		if (!gui.getEngine().isRunning()) {
			this.objGraph.update();
		}
	}
	
	@Override
	public Panels getPanelType() {
		return Panels.GRAPH;
	}

	@Override
	public void handle(MouseEvent e) {
		if (e.getSource() == updateGraph) {
			this.objGraph.update();
		}
	}
}
