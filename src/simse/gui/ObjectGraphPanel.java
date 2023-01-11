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
import simse.adts.objects.ACustomer;
import simse.adts.objects.AutomatedTestingTool;
import simse.adts.objects.Code;
import simse.adts.objects.DesignDocument;
import simse.adts.objects.DesignEnvironment;
import simse.adts.objects.IDE;
import simse.adts.objects.RequirementsCaptureTool;
import simse.adts.objects.RequirementsDocument;
import simse.adts.objects.SEProject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.SystemTestPlan;
import simse.explanatorytool.Branch;
import simse.explanatorytool.ObjectGraph;
import simse.state.Clock;
import simse.state.State;
import simse.state.logger.Logger;

public class ObjectGraphPanel extends Pane implements ChartMouseListenerFX, SimSEPanel{
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
		chartViewer.setPrefSize(500, 300);
	
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
	
	public void update() {
		this.objGraph.update();
//		if ((log.size() > 0) && (log.get(log.size() - 1) != null)) { // there is
//																		// a log
//																		// that
//																		// has
//																		// not
//																		// been
//																		// graphed
//																		// yet
//		// add a new end data point for each series/attribute
//			for (int j = 0; j < attributes.length; j++) {
//				if (objTypeType.equals("Employee")
//						&& objType.equals("SoftwareEngineer")) {
//					SoftwareEngineer softwareengineer = log.get(log.size() - 1)
//								.getEmployeeStateRepository()
//								.getSoftwareEngineerStateRepository()
//								.get(keyAttVal);
//					if (softwareengineer != null) {
//						if (attributes[j].equals("Energy")) {
//							series[j].add(log.size(),
//									softwareengineer.getEnergy());
//						} else if (attributes[j].equals("Mood")) {
//							series[j].add(log.size(),
//									softwareengineer.getMood());
//						} else if (attributes[j].equals("PayRate")) {
//							series[j].add(log.size(),
//									softwareengineer.getPayRate());
//						}
//					}
//				} else if (objTypeType.equals("Artifact")
//						&& objType.equals("RequirementsDocument")) {
//					RequirementsDocument requirementsdocument = null;
//					if (keyAttVal.equals("Requirements")) {
//						requirementsdocument = log.get(log.size() - 1)
//								.getArtifactStateRepository()
//								.getRequirementsDocumentStateRepository()
//								.get("Requirements");
//					}
//					if (requirementsdocument != null) {
//						if (attributes[j].equals("NumKnownErrors")) {
//							series[j].add(log.size(),
//									requirementsdocument.getNumKnownErrors());
//						} else if (attributes[j].equals("NumUnknownErrors")) {
//							series[j].add(log.size(),
//									requirementsdocument.getNumUnknownErrors());
//						} else if (attributes[j].equals("PercentErroneous")) {
//							series[j].add(log.size(),
//									requirementsdocument.getPercentErroneous());
//						} else if (attributes[j].equals("PercentComplete")) {
//							series[j].add(log.size(),
//									requirementsdocument.getPercentComplete());
//						}
//					}
//				} else if (objTypeType.equals("Artifact")
//						&& objType.equals("DesignDocument")) {
//					DesignDocument designdocument = null;
//					if (keyAttVal.equals("Design")) {
//						designdocument = log.get(log.size() - 1)
//								.getArtifactStateRepository()
//								.getDesignDocumentStateRepository()
//								.get("Design");
//					}
//					if (designdocument != null) {
//						if (attributes[j].equals("NumKnownErrors")) {
//							series[j].add(log.size(),
//									designdocument.getNumKnownErrors());
//						} else if (attributes[j].equals("NumUnknownErrors")) {
//							series[j].add(log.size(),
//									designdocument.getNumUnknownErrors());
//						} else if (attributes[j].equals("PercentErroneous")) {
//							series[j].add(log.size(),
//									designdocument.getPercentErroneous());
//						} else if (attributes[j].equals("PercentComplete")) {
//							series[j].add(log.size(),
//									designdocument.getPercentComplete());
//						}
//					}
//				} else if (objTypeType.equals("Artifact")
//						&& objType.equals("Code")) {
//					Code code = null;
//					if (keyAttVal.equals("Code")) {
//						code = log.get(log.size() - 1)
//								.getArtifactStateRepository()
//								.getCodeStateRepository().get("Code");
//					}
//					if (code != null) {
//						if (attributes[j].equals("PercentComplete")) {
//							series[j]
//									.add(log.size(), code.getPercentComplete());
//						} else if (attributes[j].equals("PercentIntegrated")) {
//							series[j].add(log.size(),
//									code.getPercentIntegrated());
//						} else if (attributes[j].equals("NumKnownErrors")) {
//							series[j].add(log.size(), code.getNumKnownErrors());
//						} else if (attributes[j].equals("NumUnknownErrors")) {
//							series[j].add(log.size(),
//									code.getNumUnknownErrors());
//						} else if (attributes[j].equals("PercentErroneous")) {
//							series[j].add(log.size(),
//									code.getPercentErroneous());
//						}
//					}
//				} else if (objTypeType.equals("Artifact")
//						&& objType.equals("SystemTestPlan")) {
//					SystemTestPlan systemtestplan = null;
//					if (keyAttVal.equals("TestPlan")) {
//						systemtestplan = log.get(log.size() - 1)
//								.getArtifactStateRepository()
//								.getSystemTestPlanStateRepository()
//								.get("TestPlan");
//					}
//					if (systemtestplan != null) {
//						if (attributes[j].equals("NumKnownErrors")) {
//							series[j].add(log.size(),
//									systemtestplan.getNumKnownErrors());
//						} else if (attributes[j].equals("NumUnknownErrors")) {
//							series[j].add(log.size(),
//									systemtestplan.getNumUnknownErrors());
//						} else if (attributes[j].equals("PercentErroneous")) {
//							series[j].add(log.size(),
//									systemtestplan.getPercentErroneous());
//						} else if (attributes[j].equals("PercentComplete")) {
//							series[j].add(log.size(),
//									systemtestplan.getPercentComplete());
//						}
//					}
//				} else if (objTypeType.equals("Project")
//						&& objType.equals("SEProject")) {
//					SEProject seproject = null;
//					if (keyAttVal.equals("Groceries@Home")) {
//						seproject = log.get(log.size() - 1)
//								.getProjectStateRepository()
//								.getSEProjectStateRepository()
//								.get("Groceries@Home");
//					}
//					if (seproject != null) {
//						if (attributes[j].equals("Budget")) {
//							series[j].add(log.size(), seproject.getBudget());
//						} else if (attributes[j].equals("MoneySpent")) {
//							series[j]
//									.add(log.size(), seproject.getMoneySpent());
//						} else if (attributes[j].equals("AllottedTime")) {
//							series[j].add(log.size(),
//									seproject.getAllottedTime());
//						} else if (attributes[j].equals("TimeUsed")) {
//							series[j].add(log.size(), seproject.getTimeUsed());
//						} else if (attributes[j].equals("Score")) {
//							series[j].add(log.size(), seproject.getScore());
//						}
//					}
//				} else if (objTypeType.equals("Tool")
//						&& objType.equals("RequirementsCaptureTool")) {
//					RequirementsCaptureTool requirementscapturetool = null;
//					if (keyAttVal.equals("SteelTrace")) {
//						requirementscapturetool = log.get(log.size() - 1)
//								.getToolStateRepository()
//								.getRequirementsCaptureToolStateRepository()
//								.get("SteelTrace");
//					}
//					if (requirementscapturetool != null) {
//						if (attributes[j].equals("Cost")) {
//							series[j].add(log.size(),
//									requirementscapturetool.getCost());
//						} else if (attributes[j]
//								.equals("ProductivityIncreaseFactor")) {
//							series[j].add(log.size(), requirementscapturetool
//									.getProductivityIncreaseFactor());
//						} else if (attributes[j]
//								.equals("ErrorRateDecreaseFactor")) {
//							series[j].add(log.size(), requirementscapturetool
//									.getErrorRateDecreaseFactor());
//						}
//					}
//				} else if (objTypeType.equals("Tool")
//						&& objType.equals("DesignEnvironment")) {
//					DesignEnvironment designenvironment = null;
//					if (keyAttVal.equals("RationalRose")) {
//						designenvironment = log.get(log.size() - 1)
//								.getToolStateRepository()
//								.getDesignEnvironmentStateRepository()
//								.get("RationalRose");
//					}
//					if (designenvironment != null) {
//						if (attributes[j].equals("Cost")) {
//							series[j].add(log.size(),
//									designenvironment.getCost());
//						} else if (attributes[j]
//								.equals("ProductivityIncreaseFactor")) {
//							series[j].add(log.size(), designenvironment
//									.getProductivityIncreaseFactor());
//						} else if (attributes[j]
//								.equals("ErrorRateDecreaseFactor")) {
//							series[j].add(log.size(), designenvironment
//									.getErrorRateDecreaseFactor());
//						}
//					}
//				} else if (objTypeType.equals("Tool") && objType.equals("IDE")) {
//					IDE ide = null;
//					if (keyAttVal.equals("Eclipse")) {
//						ide = log.get(log.size() - 1).getToolStateRepository()
//								.getIDEStateRepository().get("Eclipse");
//					}
//					if (ide != null) {
//						if (attributes[j].equals("Cost")) {
//							series[j].add(log.size(), ide.getCost());
//						} else if (attributes[j]
//								.equals("ProductivityIncreaseFactor")) {
//							series[j].add(log.size(),
//									ide.getProductivityIncreaseFactor());
//						} else if (attributes[j]
//								.equals("ErrorRateDecreaseFactor")) {
//							series[j].add(log.size(),
//									ide.getErrorRateDecreaseFactor());
//						}
//					}
//				} else if (objTypeType.equals("Tool")
//						&& objType.equals("AutomatedTestingTool")) {
//					AutomatedTestingTool automatedtestingtool = null;
//					if (keyAttVal.equals("JUnit")) {
//						automatedtestingtool = log.get(log.size() - 1)
//								.getToolStateRepository()
//								.getAutomatedTestingToolStateRepository()
//								.get("JUnit");
//					}
//					if (automatedtestingtool != null) {
//						if (attributes[j].equals("Cost")) {
//							series[j].add(log.size(),
//									automatedtestingtool.getCost());
//						} else if (attributes[j]
//								.equals("ProductivityIncreaseFactor")) {
//							series[j].add(log.size(), automatedtestingtool
//									.getProductivityIncreaseFactor());
//						} else if (attributes[j]
//								.equals("ErrorRateDecreaseFactor")) {
//							series[j].add(log.size(), automatedtestingtool
//									.getErrorRateDecreaseFactor());
//						}
//					}
//				} else if (objTypeType.equals("Customer")
//						&& objType.equals("ACustomer")) {
//					ACustomer acustomer = null;
//					if (keyAttVal.equals("Grocery Home Delivery Service")) {
//						acustomer = log.get(log.size() - 1)
//								.getCustomerStateRepository()
//								.getACustomerStateRepository()
//								.get("Grocery Home Delivery Service");
//					}
//					if (acustomer != null) {
//					}
//				}
//			}
//		}
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

	@Override
	public Panels getPanelType() {
		return Panels.GRAPH;
	}

}
