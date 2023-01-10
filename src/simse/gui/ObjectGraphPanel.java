package simse.gui;

import java.util.ArrayList;
import java.util.Optional;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import simse.SimSE;
import simse.explanatorytool.Branch;
import simse.explanatorytool.ObjectGraph;
import simse.state.Clock;
import simse.state.State;
import simse.state.logger.Logger;

public class ObjectGraphPanel extends Pane implements ChartMouseListenerFX{
	private ArrayList<State> log;
	private String objTypeType;
	private String objType;
	private String keyAttVal;
	private String[] attributes;
	private JFreeChart chart; // chart object
	private ChartViewer chartViewer;
	private MenuItem newBranchItem;
	private SeparatorMenuItem separator;
	private int lastRightClickedX; // last x-val that was right-clicked on
	private Branch branch; // branch from which this graph is generated
	private ObjectGraph objGraph;
	
	private EventHandler<ActionEvent> menuEvent = new EventHandler<ActionEvent>() {
        private String newBranchName = null;
		
		public void handle(ActionEvent event) {
        	Object source = event.getSource();
        	if (source == newBranchItem) {
        		TextInputDialog td = new TextInputDialog();
    			td.setTitle("Name New Branch");
    			td.setContentText("Please name this new game:");
    			td.setHeaderText(null);
    			Optional<String> result = td.showAndWait();
    			result.ifPresent(name -> {
    				this.newBranchName = name;
    			});
    			if (newBranchName != null) {
    				State tempState = (State) log.get(lastRightClickedX).clone();
    				Logger tempLogger = new Logger(tempState, new ArrayList<State>(log.subList(0, lastRightClickedX)));
    				Clock tempClock = new Clock(tempLogger, lastRightClickedX);
    				tempState.setClock(tempClock);
    				tempState.setLogger(tempLogger);
    				SimSE.startNewBranch(tempState, new Branch(newBranchName, lastRightClickedX, 
    						tempClock.getTime(), branch, null));
    			}
    		}
        }
    };
	
	public ObjectGraphPanel(String title, ArrayList<State> log, String objTypeType, String objType, 
			String keyAttVal, Branch branch) {
		VBox mainPane = new VBox();
		this.branch = branch;
		if (branch.getName() != null) {
			title = title.concat(" - " + branch.getName());
		}
		this.objTypeType = objTypeType;
		this.objType = objType;
		this.keyAttVal = keyAttVal;
		lastRightClickedX = 0;
		setAttributeList();
		this.objGraph = new ObjectGraph(title, log, objTypeType, objType, keyAttVal, attributes, false, branch);
		chart = objGraph.getChart();
		chartViewer = new ChartViewer(chart);
		chartViewer.addChartMouseListener(this);
		chartViewer.setPrefSize(500, 200);
	
		mainPane.getChildren().add(chartViewer);
		this.getChildren().add(mainPane);
		newBranchItem = new MenuItem("Start new game from here");
		newBranchItem.setOnAction(menuEvent);
		separator = new SeparatorMenuItem();
	}
	
	private void setAttributeList() {
		String selectedObject = this.objType + " " + this.objTypeType;
		if(selectedObject != null) {
			if (selectedObject.startsWith("SoftwareEngineer Employee")) {
				String[] currAttributes = { "Energy", "Mood", "PayRate", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("RequirementsDocument Artifact")) {
				String[] currAttributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("DesignDocument Artifact")) {
				String[] currAttributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("Code Artifact")) {
				String[] currAttributes = { "PercentComplete", "PercentIntegrated",
						"NumKnownErrors", "NumUnknownErrors", "PercentErroneous", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("SystemTestPlan Artifact")) {
				String[] currAttributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("SEProject Project")) {
				String[] currAttributes = { "Budget", "MoneySpent", "AllottedTime",
						"TimeUsed", "Score", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("RequirementsCaptureTool Tool")) {
				String[] currAttributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("DesignEnvironment Tool")) {
				String[] currAttributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("IDE Tool")) {
				String[] currAttributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("AutomatedTestingTool Tool")) {
				String[] currAttributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				this.attributes = currAttributes;
			} else if (selectedObject.startsWith("ACustomer Customer")) {
				String[] currAttributes = { "(No numerical attributes)" };
				this.attributes = currAttributes;
			} else {
				String[] currAttributes = {};
				this.attributes = currAttributes;
			}
		}
	}
	
	@Override
	public void chartMouseClicked(ChartMouseEventFX me) {
		MouseEvent event = me.getTrigger();
		if (event.getButton() != MouseButton.PRIMARY) { // not left-click
			XYPlot plot = chart.getXYPlot();
			Range domainRange = plot.getDataRange(plot.getDomainAxis());
			if (domainRange != null) { // chart is not blank
				javafx.geometry.Point2D pt = chartViewer.localToScreen(event.getScreenX(), event.getScreenY());
				ChartRenderingInfo info = this.chartViewer
						.getRenderingInfo();
				java.awt.geom.Rectangle2D dataArea = info.getPlotInfo().getDataArea();
				NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
				RectangleEdge domainAxisEdge = plot.getDomainAxisEdge();
				double chartX = domainAxis.java2DToValue(pt.getX(), dataArea,
						domainAxisEdge);
				lastRightClickedX = (int) Math.rint(chartX);
				if (domainRange != null
						&& lastRightClickedX >= domainRange.getLowerBound()
						&& lastRightClickedX <= (domainRange.getUpperBound() - 1)
						&& lastRightClickedX >= 0) { // clicked within domain
														// range
					if (chartViewer.getContextMenu().getItems().indexOf(
							newBranchItem) == -1) { // no new branch item on
													// menu currently
						chartViewer.getContextMenu().getItems().add(separator);
						chartViewer.getContextMenu().getItems().add(newBranchItem);
					}
				} else { // clicked outside of domain range
					if (chartViewer.getContextMenu().getItems().indexOf(
							newBranchItem) >= 0) { // new branch item currently
													// on menu
						chartViewer.getContextMenu().getItems().remove(newBranchItem);
						if (chartViewer.getContextMenu().getItems().indexOf(
								separator) >= 0) { // has separator
							chartViewer.getContextMenu().getItems().remove(separator);
						}
					}
				}
			}
		}
	}

	@Override
	public void chartMouseMoved(ChartMouseEventFX me) {}

}
