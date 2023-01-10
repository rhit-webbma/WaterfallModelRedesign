/* File generated by: simse.codegenerator.explanatorytoolgenerator.ObjectGraphGenerator */
package simse.explanatorytool;

import java.util.ArrayList;
import java.util.Optional;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
import simse.gui.util.JavaFXHelpers;
import simse.state.Clock;
import simse.state.State;
import simse.state.logger.Logger;

public class ObjectGraph extends Stage implements ChartMouseListenerFX {
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
	private XYSeries[] series;
	private Branch branch; // branch from which this graph is generated
	
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

	public ObjectGraph(String title, ArrayList<State> log, String objTypeType,
			String objType, String keyAttVal, String[] attributes,
			boolean showChart, Branch branch) {
		super();
		this.branch = branch;
		if (branch.getName() != null) {
			title = title.concat(" - " + branch.getName());
		}
		setTitle(title);
		this.log = log;
		this.objTypeType = objTypeType;
		this.objType = objType;
		this.keyAttVal = keyAttVal;
		this.attributes = attributes;
		lastRightClickedX = 0;
		XYDataset dataset = createDataset();
		chart = createChart(dataset);
		chartViewer = new ChartViewer(chart);
		setChartColors();
		chartViewer.addChartMouseListener(this);
		chartViewer.setPrefSize(500, 270);
		setScene(new Scene(chartViewer));
		newBranchItem = new MenuItem("Start new game from here");
		newBranchItem.setOnAction(menuEvent);
		separator = new SeparatorMenuItem();
		
		if (showChart) show();
	
	}

	// Creates the dataset for this graph
	private XYDataset createDataset() {
		series = new XYSeries[attributes.length];
		for (int i = 0; i < attributes.length; i++) {
			series[i] = new XYSeries(attributes[i]);
		}

		for (int i = 0; i < log.size(); i++) {
			for (int j = 0; j < attributes.length; j++) {
				if (objTypeType.equals("Employee")
						&& objType.equals("SoftwareEngineer")) {
					SoftwareEngineer softwareengineer = null;
					if (keyAttVal.equals("Andre")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Andre");
					} else if (keyAttVal.equals("Anita")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Anita");
					} else if (keyAttVal.equals("Calvin")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Calvin");
					} else if (keyAttVal.equals("Emily")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Emily");
					} else if (keyAttVal.equals("Mimi")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Mimi");
					} else if (keyAttVal.equals("Pedro")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Pedro");
					} else if (keyAttVal.equals("Roger")) {
						softwareengineer = log.get(i)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Roger");
					}
					if (softwareengineer != null) {
						if (attributes[j].equals("Energy")) {
							series[j].add(i, softwareengineer.getEnergy());
						} else if (attributes[j].equals("Mood")) {
							series[j].add(i, softwareengineer.getMood());
						} else if (attributes[j].equals("PayRate")) {
							series[j].add(i, softwareengineer.getPayRate());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("RequirementsDocument")) {
					RequirementsDocument requirementsdocument = null;
					if (keyAttVal.equals("Requirements")) {
						requirementsdocument = log.get(i)
								.getArtifactStateRepository()
								.getRequirementsDocumentStateRepository()
								.get("Requirements");
					}
					if (requirementsdocument != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(i,
									requirementsdocument.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(i,
									requirementsdocument.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(i,
									requirementsdocument.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(i,
									requirementsdocument.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("DesignDocument")) {
					DesignDocument designdocument = null;
					if (keyAttVal.equals("Design")) {
						designdocument = log.get(i)
								.getArtifactStateRepository()
								.getDesignDocumentStateRepository()
								.get("Design");
					}
					if (designdocument != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j]
									.add(i, designdocument.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(i,
									designdocument.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(i,
									designdocument.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(i,
									designdocument.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("Code")) {
					Code code = null;
					if (keyAttVal.equals("Code")) {
						code = log.get(i).getArtifactStateRepository()
								.getCodeStateRepository().get("Code");
					}
					if (code != null) {
						if (attributes[j].equals("PercentComplete")) {
							series[j].add(i, code.getPercentComplete());
						} else if (attributes[j].equals("PercentIntegrated")) {
							series[j].add(i, code.getPercentIntegrated());
						} else if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(i, code.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(i, code.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(i, code.getPercentErroneous());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("SystemTestPlan")) {
					SystemTestPlan systemtestplan = null;
					if (keyAttVal.equals("TestPlan")) {
						systemtestplan = log.get(i)
								.getArtifactStateRepository()
								.getSystemTestPlanStateRepository()
								.get("TestPlan");
					}
					if (systemtestplan != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j]
									.add(i, systemtestplan.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(i,
									systemtestplan.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(i,
									systemtestplan.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(i,
									systemtestplan.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Project")
						&& objType.equals("SEProject")) {
					SEProject seproject = null;
					if (keyAttVal.equals("Groceries@Home")) {
						seproject = log.get(i).getProjectStateRepository()
								.getSEProjectStateRepository()
								.get("Groceries@Home");
					}
					if (seproject != null) {
						if (attributes[j].equals("Budget")) {
							series[j].add(i, seproject.getBudget());
						} else if (attributes[j].equals("MoneySpent")) {
							series[j].add(i, seproject.getMoneySpent());
						} else if (attributes[j].equals("AllottedTime")) {
							series[j].add(i, seproject.getAllottedTime());
						} else if (attributes[j].equals("TimeUsed")) {
							series[j].add(i, seproject.getTimeUsed());
						} else if (attributes[j].equals("Score")) {
							series[j].add(i, seproject.getScore());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("RequirementsCaptureTool")) {
					RequirementsCaptureTool requirementscapturetool = null;
					if (keyAttVal.equals("SteelTrace")) {
						requirementscapturetool = log.get(i)
								.getToolStateRepository()
								.getRequirementsCaptureToolStateRepository()
								.get("SteelTrace");
					}
					if (requirementscapturetool != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(i, requirementscapturetool.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(i, requirementscapturetool
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(i, requirementscapturetool
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("DesignEnvironment")) {
					DesignEnvironment designenvironment = null;
					if (keyAttVal.equals("RationalRose")) {
						designenvironment = log.get(i).getToolStateRepository()
								.getDesignEnvironmentStateRepository()
								.get("RationalRose");
					}
					if (designenvironment != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(i, designenvironment.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(i, designenvironment
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(i, designenvironment
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool") && objType.equals("IDE")) {
					IDE ide = null;
					if (keyAttVal.equals("Eclipse")) {
						ide = log.get(i).getToolStateRepository()
								.getIDEStateRepository().get("Eclipse");
					}
					if (ide != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(i, ide.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(i,
									ide.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(i, ide.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("AutomatedTestingTool")) {
					AutomatedTestingTool automatedtestingtool = null;
					if (keyAttVal.equals("JUnit")) {
						automatedtestingtool = log.get(i)
								.getToolStateRepository()
								.getAutomatedTestingToolStateRepository()
								.get("JUnit");
					}
					if (automatedtestingtool != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(i, automatedtestingtool.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(i, automatedtestingtool
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(i, automatedtestingtool
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Customer")
						&& objType.equals("ACustomer")) {
					ACustomer acustomer = null;
					if (keyAttVal.equals("Grocery Home Delivery Service")) {
						acustomer = log.get(i).getCustomerStateRepository()
								.getACustomerStateRepository()
								.get("Grocery Home Delivery Service");
					}
					if (acustomer != null) {
					}
				}
			}
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		for (int i = 0; i < series.length; i++) {
			dataset.addSeries(series[i]);
		}
		return dataset;
	}

	private void setChartColors() {
		chartViewer.backgroundProperty().set(JavaFXHelpers.createBackgroundColor(Color.WHITE));
	}
	
	// Creates the chart for this graph
	private JFreeChart createChart(XYDataset dataset) {
		// create the chart:
		JFreeChart chart = ChartFactory.createXYLineChart(this.getTitle(),
				"Clock Ticks", null, dataset, PlotOrientation.VERTICAL, true,
				true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(java.awt.Color.LIGHT_GRAY);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(java.awt.Color.WHITE);
		plot.setRangeGridlinePaint(java.awt.Color.WHITE);
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setDefaultShapesVisible(true);
		renderer.setDefaultShapesFilled(true);

		// change the auto tick unit selection to integer units only:
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

	public void update() {
		if ((log.size() > 0) && (log.get(log.size() - 1) != null)) { // there is
																		// a log
																		// that
																		// has
																		// not
																		// been
																		// graphed
																		// yet
		// add a new end data point for each series/attribute
			for (int j = 0; j < attributes.length; j++) {
				if (objTypeType.equals("Employee")
						&& objType.equals("SoftwareEngineer")) {
					SoftwareEngineer softwareengineer = null;
					if (keyAttVal.equals("Andre")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Andre");
					} else if (keyAttVal.equals("Anita")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Anita");
					} else if (keyAttVal.equals("Calvin")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Calvin");
					} else if (keyAttVal.equals("Emily")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Emily");
					} else if (keyAttVal.equals("Mimi")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Mimi");
					} else if (keyAttVal.equals("Pedro")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Pedro");
					} else if (keyAttVal.equals("Roger")) {
						softwareengineer = log.get(log.size() - 1)
								.getEmployeeStateRepository()
								.getSoftwareEngineerStateRepository()
								.get("Roger");
					}
					if (softwareengineer != null) {
						if (attributes[j].equals("Energy")) {
							series[j].add(log.size(),
									softwareengineer.getEnergy());
						} else if (attributes[j].equals("Mood")) {
							series[j].add(log.size(),
									softwareengineer.getMood());
						} else if (attributes[j].equals("PayRate")) {
							series[j].add(log.size(),
									softwareengineer.getPayRate());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("RequirementsDocument")) {
					RequirementsDocument requirementsdocument = null;
					if (keyAttVal.equals("Requirements")) {
						requirementsdocument = log.get(log.size() - 1)
								.getArtifactStateRepository()
								.getRequirementsDocumentStateRepository()
								.get("Requirements");
					}
					if (requirementsdocument != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(log.size(),
									requirementsdocument.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(log.size(),
									requirementsdocument.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(log.size(),
									requirementsdocument.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(log.size(),
									requirementsdocument.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("DesignDocument")) {
					DesignDocument designdocument = null;
					if (keyAttVal.equals("Design")) {
						designdocument = log.get(log.size() - 1)
								.getArtifactStateRepository()
								.getDesignDocumentStateRepository()
								.get("Design");
					}
					if (designdocument != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(log.size(),
									designdocument.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(log.size(),
									designdocument.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(log.size(),
									designdocument.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(log.size(),
									designdocument.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("Code")) {
					Code code = null;
					if (keyAttVal.equals("Code")) {
						code = log.get(log.size() - 1)
								.getArtifactStateRepository()
								.getCodeStateRepository().get("Code");
					}
					if (code != null) {
						if (attributes[j].equals("PercentComplete")) {
							series[j]
									.add(log.size(), code.getPercentComplete());
						} else if (attributes[j].equals("PercentIntegrated")) {
							series[j].add(log.size(),
									code.getPercentIntegrated());
						} else if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(log.size(), code.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(log.size(),
									code.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(log.size(),
									code.getPercentErroneous());
						}
					}
				} else if (objTypeType.equals("Artifact")
						&& objType.equals("SystemTestPlan")) {
					SystemTestPlan systemtestplan = null;
					if (keyAttVal.equals("TestPlan")) {
						systemtestplan = log.get(log.size() - 1)
								.getArtifactStateRepository()
								.getSystemTestPlanStateRepository()
								.get("TestPlan");
					}
					if (systemtestplan != null) {
						if (attributes[j].equals("NumKnownErrors")) {
							series[j].add(log.size(),
									systemtestplan.getNumKnownErrors());
						} else if (attributes[j].equals("NumUnknownErrors")) {
							series[j].add(log.size(),
									systemtestplan.getNumUnknownErrors());
						} else if (attributes[j].equals("PercentErroneous")) {
							series[j].add(log.size(),
									systemtestplan.getPercentErroneous());
						} else if (attributes[j].equals("PercentComplete")) {
							series[j].add(log.size(),
									systemtestplan.getPercentComplete());
						}
					}
				} else if (objTypeType.equals("Project")
						&& objType.equals("SEProject")) {
					SEProject seproject = null;
					if (keyAttVal.equals("Groceries@Home")) {
						seproject = log.get(log.size() - 1)
								.getProjectStateRepository()
								.getSEProjectStateRepository()
								.get("Groceries@Home");
					}
					if (seproject != null) {
						if (attributes[j].equals("Budget")) {
							series[j].add(log.size(), seproject.getBudget());
						} else if (attributes[j].equals("MoneySpent")) {
							series[j]
									.add(log.size(), seproject.getMoneySpent());
						} else if (attributes[j].equals("AllottedTime")) {
							series[j].add(log.size(),
									seproject.getAllottedTime());
						} else if (attributes[j].equals("TimeUsed")) {
							series[j].add(log.size(), seproject.getTimeUsed());
						} else if (attributes[j].equals("Score")) {
							series[j].add(log.size(), seproject.getScore());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("RequirementsCaptureTool")) {
					RequirementsCaptureTool requirementscapturetool = null;
					if (keyAttVal.equals("SteelTrace")) {
						requirementscapturetool = log.get(log.size() - 1)
								.getToolStateRepository()
								.getRequirementsCaptureToolStateRepository()
								.get("SteelTrace");
					}
					if (requirementscapturetool != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(log.size(),
									requirementscapturetool.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(log.size(), requirementscapturetool
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(log.size(), requirementscapturetool
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("DesignEnvironment")) {
					DesignEnvironment designenvironment = null;
					if (keyAttVal.equals("RationalRose")) {
						designenvironment = log.get(log.size() - 1)
								.getToolStateRepository()
								.getDesignEnvironmentStateRepository()
								.get("RationalRose");
					}
					if (designenvironment != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(log.size(),
									designenvironment.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(log.size(), designenvironment
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(log.size(), designenvironment
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool") && objType.equals("IDE")) {
					IDE ide = null;
					if (keyAttVal.equals("Eclipse")) {
						ide = log.get(log.size() - 1).getToolStateRepository()
								.getIDEStateRepository().get("Eclipse");
					}
					if (ide != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(log.size(), ide.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(log.size(),
									ide.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(log.size(),
									ide.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Tool")
						&& objType.equals("AutomatedTestingTool")) {
					AutomatedTestingTool automatedtestingtool = null;
					if (keyAttVal.equals("JUnit")) {
						automatedtestingtool = log.get(log.size() - 1)
								.getToolStateRepository()
								.getAutomatedTestingToolStateRepository()
								.get("JUnit");
					}
					if (automatedtestingtool != null) {
						if (attributes[j].equals("Cost")) {
							series[j].add(log.size(),
									automatedtestingtool.getCost());
						} else if (attributes[j]
								.equals("ProductivityIncreaseFactor")) {
							series[j].add(log.size(), automatedtestingtool
									.getProductivityIncreaseFactor());
						} else if (attributes[j]
								.equals("ErrorRateDecreaseFactor")) {
							series[j].add(log.size(), automatedtestingtool
									.getErrorRateDecreaseFactor());
						}
					}
				} else if (objTypeType.equals("Customer")
						&& objType.equals("ACustomer")) {
					ACustomer acustomer = null;
					if (keyAttVal.equals("Grocery Home Delivery Service")) {
						acustomer = log.get(log.size() - 1)
								.getCustomerStateRepository()
								.getACustomerStateRepository()
								.get("Grocery Home Delivery Service");
					}
					if (acustomer != null) {
					}
				}
			}
		}
	}

	public XYPlot getXYPlot() {
		return chart.getXYPlot();
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public String getChartTitle() {
		return this.getTitle();
	}

	public ArrayList<State> getLog() {
		return log;
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
	public void chartMouseMoved(ChartMouseEventFX arg0) {}
}