/* File generated by: simse.codegenerator.explanatorytoolgenerator.ExplanatoryToolGenerator */
package simse.explanatorytool;

import java.util.ArrayList;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simse.state.State;

public class ExplanatoryTool extends Stage implements EventHandler<MouseEvent>{
	private ArrayList<State> log; // log for current simulation
	private ArrayList<Stage> visibleGraphs; // holds all of the currently
												// visible graphs
	private static MultipleTimelinesBrowser timelinesBrowser;
	private Button multipleTimelinesButton;
	private ComboBox<String> objectList; // for choosing an object whose attributes to
									// graph
	private ListView<String> attributeList; // for choosing which attributes to show
	private ListView<String> actionList; // for choosing which actions to show
	private Button generateObjGraphButton; // for generating an object graph
	private Button generateActGraphButton; // for generating an action graph
	private Button generateCompGraphButton; // for generating a composite graph
	private ComboBox<String> actionComboBox;
	private ListView<String> triggerRuleList;
	private ListView<String> destroyerRuleList;
	private ListView<String> intermediateRuleList;
	private TextArea descriptionArea;
	private Button closeButton;
	private GridPane mainPane;
	private Branch branch;

	public ExplanatoryTool(ArrayList<State> log, Branch branch, MultipleTimelinesBrowser browser) {
		this.branch = branch;
		timelinesBrowser = browser;
		this.log = log;
		String title = "Explanatory Tool";
		if (branch.getName() != null) {
			title = title.concat(" - " + branch.getName());
		}
		this.setTitle(title);
		this.visibleGraphs = new ArrayList<Stage>();


		Pane multipleTimelinesPanel = new Pane();
		multipleTimelinesButton = new Button("Multiple Timelines Browser");
		multipleTimelinesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		multipleTimelinesPanel.getChildren().add(multipleTimelinesButton);

		// Create generate graphs title pane and label:
		Pane generateGraphsTitlePane = new Pane();
		generateGraphsTitlePane.getChildren().add(new Label("Generate Graph(s):"));

		// Create object pane and components:
		VBox objectPane = new VBox();
		BorderPane objectTitlePane = new BorderPane();
		objectTitlePane.setCenter(new Label("Object Graph:"));
		objectPane.getChildren().add(objectTitlePane);

		// object list:
		ObservableList<String> objects = FXCollections.observableArrayList(
		"SoftwareEngineer Employee Andre",
				"SoftwareEngineer Employee Anita",
				"SoftwareEngineer Employee Calvin",
				"SoftwareEngineer Employee Emily",
				"SoftwareEngineer Employee Mimi",
				"SoftwareEngineer Employee Pedro",
				"SoftwareEngineer Employee Roger",
				"RequirementsDocument Artifact Requirements",
				"DesignDocument Artifact Design", "Code Artifact Code",
				"SystemTestPlan Artifact TestPlan",
				"SEProject Project Groceries@Home",
				"RequirementsCaptureTool Tool SteelTrace",
				"DesignEnvironment Tool RationalRose", "IDE Tool Eclipse",
				"AutomatedTestingTool Tool JUnit",
				"ACustomer Customer Grocery Home Delivery Service");
		objectList = new ComboBox<String>(objects);
		objectList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				refreshAttributeList();
			}
		});
		objectPane.getChildren().add(objectList);

		// Create attribute list pane:
		Pane attributeListTitlePane = new Pane();
		attributeListTitlePane.getChildren().add(new Label("Show Attributes:"));
		attributeListTitlePane.setMinHeight(20);
		objectPane.getChildren().add(attributeListTitlePane);
		attributeList = new ListView<String>();
//		attributeList.setVisibleRowCount(5); // make 5 items visible at a time
//		attributeList.setFixedCellWidth(250);
		attributeList.setFixedCellSize(24);
		attributeList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		attributeList.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		attributeList.setMinWidth(550);
		ScrollPane attributeListPane = new ScrollPane(attributeList);
		attributeListPane.setMinHeight(120);
		objectPane.getChildren().add(attributeListPane);

		// Create objectBottom pane & button:
		Pane objBottomPane = new Pane();
		generateObjGraphButton = new Button("Generate Object Graph");
		generateObjGraphButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		objBottomPane.getChildren().add(generateObjGraphButton);
		objectPane.getChildren().add(objBottomPane);

		// Create action pane and components:
		VBox actionPane = new VBox();
		Pane actionTitlePane = new Pane();
		actionTitlePane.getChildren().add(new Label("Action Graph:"));
		actionTitlePane.setMinHeight(20);
		actionPane.getChildren().add(actionTitlePane);

		// action list:
		ObservableList<String> actions = FXCollections.observableArrayList(
				"CreateRequirements", "ReviewRequirements",
				"CorrectRequirements", "CreateDesign", "ReviewDesign",
				"CorrectDesign", "CreateCode", "InspectCode", "CorrectCode",
				"IntegrateCode", "SystemTest", "CreateSystemTestPlan",
				"ReviewSystemTestPlan", "CorrectSystemTestPlan",
				"DeliverProduct", "Break", "GetSick", "Quit",
				"IntroduceNewRequirements", "ChangePayRate", "GiveBonus",
				"Fire", "PurchaseTool", "SuggestedRequirementsPhaseDuration",
				"SuggestedDesignPhaseDuration",
				"SuggestedImplIntegrationPhaseDuration",
				"SuggestedTestingPhaseDuration");
		actionList = new ListView<String>(actions);
//		actionList.setVisibleRowCount(5); // make 5 items visible at a time
//		actionList.setFixedCellWidth(250);
		attributeList.setFixedCellSize(24);
		actionList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		actionList.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		actionPane.getChildren().add(actionList);

		// Create actionBottom pane & buttons:
		Pane actBottomPane = new Pane();
		generateActGraphButton = new Button("Generate Action Graph");
		generateActGraphButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		actBottomPane.getChildren().add(generateActGraphButton);
		actionPane.getChildren().add(actBottomPane);

		// Create comp graph pane & button:
		Pane generateCompGraphPane = new Pane();
		generateCompGraphButton = new Button("Generate Composite Graph");
		generateCompGraphButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		generateCompGraphPane.getChildren().add(generateCompGraphButton);

		refreshAttributeList();
		if (actions.size() > 0) {
//			actionList.setSelectedIndex(0);
			actionList.scrollTo(0);
			actionList.getSelectionModel().select(0);
			actionList.getFocusModel().focus(0);
		}
		refreshButtons();

		// Create viewRuleTitlePane and label:
		Pane viewRulesTitlePane = new Pane();
		viewRulesTitlePane.getChildren().add(new Label("View Rules:"));

		// Create actionsComboBoxPane:
		Pane actionComboBoxPane = new Pane();
		actionComboBoxPane.getChildren().add(new Label("Actions:"));
		actionComboBox = new ComboBox<String>(actions);
		actionComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (actionComboBox.getItems().size() > 0) {
					refreshRuleLists((String) actionComboBox.getSelectionModel().getSelectedItem());
					descriptionArea.setText("");
				}
			}
		});
		actionComboBoxPane.getChildren().add(actionComboBox);

		// Create rulesMainPane:
		TilePane rulesMainPane = new TilePane();

		// Create ruleListsPane:
		VBox ruleListsPane = new VBox();

		// rule lists:
		Pane trigRuleTitlePane = new Pane();
		trigRuleTitlePane.getChildren().add(new Label("Trigger Rules:"));
		ruleListsPane.getChildren().add(trigRuleTitlePane);
		triggerRuleList = new ListView<String>();
//		triggerRuleList.setVisibleRowCount(4);
//		triggerRuleList.setFixedCellWidth(250);
		triggerRuleList.setFixedCellSize(24);
		triggerRuleList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		triggerRuleList.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		triggerRuleList.setMinWidth(272);
		ScrollPane triggerRuleListPane = new ScrollPane(triggerRuleList);
		triggerRuleListPane.setMaxHeight(80);
		ruleListsPane.getChildren().add(triggerRuleListPane);

		Pane destRuleTitlePane = new Pane();
		destRuleTitlePane.getChildren().add(new Label("Destroyer Rules:"));
		ruleListsPane.getChildren().add(destRuleTitlePane);
		destroyerRuleList = new ListView<String>();
//		destroyerRuleList.setVisibleRowCount(4);
//		destroyerRuleList.setFixedCellWidth(250);
		destroyerRuleList.setFixedCellSize(24);
		destroyerRuleList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		destroyerRuleList.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		destroyerRuleList.setMinWidth(272);
		ScrollPane destroyerRuleListPane = new ScrollPane(destroyerRuleList);
		destroyerRuleListPane.setMaxHeight(80);
		ruleListsPane.getChildren().add(destroyerRuleListPane);

		Pane intRuleTitlePane = new Pane();
		intRuleTitlePane.getChildren().add(new Label("Intermediate Rules:"));
		ruleListsPane.getChildren().add(intRuleTitlePane);
		intermediateRuleList = new ListView<String>();
//		intermediateRuleList.setVisibleRowCount(4);
//		intermediateRuleList.setFixedCellWidth(250);
		intermediateRuleList.setFixedCellSize(24);
		intermediateRuleList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		intermediateRuleList.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		intermediateRuleList.setMinWidth(272);
		ScrollPane intermediateRuleListPane = new ScrollPane(intermediateRuleList);
		intermediateRuleListPane.setMaxHeight(80);
		ruleListsPane.getChildren().add(intermediateRuleListPane);
		ruleListsPane.setPadding(new Insets(0,40,0,40));
		rulesMainPane.getChildren().add(ruleListsPane);

		// description pane:
		VBox descriptionPane = new VBox();
		Pane descriptionTitlePane = new Pane();
		descriptionTitlePane.getChildren().add(new Label("Description:"));
		descriptionPane.getChildren().add(descriptionTitlePane);

		// description text area:
		descriptionArea = new TextArea();
		descriptionArea.setWrapText(true);
		descriptionArea.setPrefRowCount(16);
		descriptionArea.setPrefColumnCount(30);
//		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setEditable(false);
		ScrollPane descriptionScrollPane = new ScrollPane(descriptionArea);
		descriptionScrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		descriptionScrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		descriptionPane.getChildren().add(descriptionScrollPane);

		rulesMainPane.getChildren().add(descriptionPane);

		// Create close button pane:
		Pane closeButtonPane = new Pane();
		closeButton = new Button("Close");
		closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		closeButtonPane.getChildren().add(closeButton);

		if (actions.size() > 0) { // at least one action in list
//			actionComboBox.setSelectedIndex(0);
			actionComboBox.getSelectionModel().select(0);
		}

		// set up tool tips:
		setUpToolTips();
		
		mainPane = new GridPane();
	    mainPane.setHgap(10);
	    mainPane.setVgap(30);
	    mainPane.setPadding(new Insets(0, 10, 0, 10));

		// Add panes to main pane and main sub-pane:
	    Pane spacerPane = new Pane();
	    spacerPane.setMinWidth(300);
	    mainPane.add(spacerPane, 0, 0);
		mainPane.add(multipleTimelinesPanel, 1, 0);
//		Separator separator0 = new Separator();
//		separator0.setMaxSize(2900, 1);
//		mainPane.add(separator0, 0, 1, 3, 1);
		mainPane.add(generateGraphsTitlePane, 1, 1);
//		Separator separator1 = new Separator();
//		separator1.setMaxSize(2900, 1);
//		mainPane.add(separator1, 0, 3, 3, 1);
		mainPane.add(objectPane, 0, 2, 2, 1);
		mainPane.add(actionPane, 2, 2);
//		Separator separator2 = new Separator();
//		separator2.setMaxSize(2900, 1);
//		mainPane.add(separator2, 0, 5, 3, 1);
		mainPane.add(generateCompGraphPane, 1, 3);
//		Separator separator3 = new Separator();
//		separator3.setMaxSize(2900, 1);
//		mainPane.add(separator3, 0, 7, 3, 1);
		mainPane.add(viewRulesTitlePane, 1, 4);
//		Separator separator4 = new Separator();
//		separator4.setMaxSize(2900, 1);
//		mainPane.add(separator4, 0, 9, 3, 1);
		mainPane.add(actionComboBoxPane, 1, 5);
		mainPane.add(rulesMainPane, 0, 6, 3, 1);
		mainPane.add(closeButtonPane, 1, 7);
		Pane spacerPane2 = new Pane();
		mainPane.add(spacerPane2, 0, 8, 3, 1);
		
		Scene scene = new Scene(mainPane, 900, 720);
		scene.getStylesheets().add("style.css");
		this.setScene(scene);

		// Set main window frame properties:
//		setBackground(Color.black);
//		setContentPane(mainPane);
//		validate();
//		pack();
//		repaint();
		toFront();
		// Make it show up in the center of the screen:
//		RefineryUtilities.centerFrameOnScreen(this);
//		setVisible(false);
//		mainPane.setPrefSize(100, 70);
		hide();
	}
	
	@Override
	public void handle(MouseEvent evt) {
		Object source = evt.getSource(); // get which component the action came from
		
		if (source == multipleTimelinesButton) {
			if (timelinesBrowser.isIconified()) {
				timelinesBrowser.setIconified(false);
			}
			timelinesBrowser.show();
		} else if (source == generateObjGraphButton) { // generateObjGraphButton
														// has been pressed
			String selectedObj = (String) objectList.getSelectionModel().getSelectedItem();
			String[] words = selectedObj.split("\\s");
			String title = selectedObj + " Attributes";
			String objType = words[0];
			String objTypeType = words[1];

			// add 2 for the 2 spaces:
			String keyAttVal = selectedObj.substring(objType.length()
					+ objTypeType.length() + 2);

			Object[] selectedAtts = attributeList.getSelectionModel().getSelectedItems().toArray();
			String[] attributes = new String[selectedAtts.length];
			for (int i = 0; i < selectedAtts.length; i++) {
				attributes[i] = new String((String) selectedAtts[i]);
			}
			if (attributes.length > 0) { // at least one attribute is selected
				ObjectGraph graph = new ObjectGraph(title, log, objTypeType,
						objType, keyAttVal, attributes, true, branch);
//				visibleGraphs.add(graph);
			} else {
				Alert alert = new Alert(AlertType.WARNING, "Please select at least one attribute");
				alert.show();
			}
		} else if (source == generateActGraphButton) { // generateActGraphButton
														// has been pressed
			Object[] selectedActions = actionList.getSelectionModel().getSelectedItems().toArray();
			String[] actions = new String[selectedActions.length];
			for (int i = 0; i < selectedActions.length; i++) {
				actions[i] = new String((String) selectedActions[i]);
			}
			if (actions.length > 0) { // at least one attribute is selected
				ActionGraph graph = new ActionGraph(log, actions, true, branch);
//				visibleGraphs.add(graph);
			} else {
				Alert alert = new Alert(AlertType.WARNING, "Please select at least one action");
				alert.show();
			}
		} else if (source == generateCompGraphButton) { // generateCompGraphButton
														// has been pressed
			String selectedObj = (String) objectList.getSelectionModel().getSelectedItem();
			String[] words = selectedObj.split("\\s");
			String title = selectedObj + " Attributes";
			String objType = words[0];
			String objTypeType = words[1];

			// add 2 for the 2 spaces:
			String keyAttVal = selectedObj.substring(objType.length()
					+ objTypeType.length() + 2);

			Object[] selectedAtts = attributeList.getSelectionModel().getSelectedItems().toArray();
			String[] attributes = new String[selectedAtts.length];
			for (int i = 0; i < selectedAtts.length; i++) {
				attributes[i] = new String((String) selectedAtts[i]);
			}
			if (attributes.length > 0) { // at least one attribute is selected
				ObjectGraph objGraph = new ObjectGraph(title, log, objTypeType,
						objType, keyAttVal, attributes, false, branch);

				Object[] selectedActions = actionList.getSelectionModel().getSelectedItems().toArray();
				String[] actions = new String[selectedActions.length];
				for (int i = 0; i < selectedActions.length; i++) {
					actions[i] = new String((String) selectedActions[i]);
				}
				if (actions.length > 0) { // at least one attribute is selected
					ActionGraph actGraph = new ActionGraph(log, actions, false,
							branch);

					// generate composite graph:
					CompositeGraph compGraph = new CompositeGraph(objGraph,
							actGraph, branch);
//					visibleGraphs.add(compGraph);
				} else {
					Alert alert = new Alert(AlertType.WARNING, "Please select at least one action");
					alert.show();
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING, "Please select at least one attribute");
				alert.show();
			}
		} else if ((source == attributeList) || (source == actionList)) {
			refreshButtons();
		} else if ((source == triggerRuleList && !triggerRuleList.getSelectionModel().isEmpty())) {
			destroyerRuleList.getSelectionModel().clearSelection();
			intermediateRuleList.getSelectionModel().clearSelection();
			refreshDescriptionArea((String) triggerRuleList.getSelectionModel().getSelectedItem());
		} else if (source == destroyerRuleList && !destroyerRuleList.getSelectionModel().isEmpty()) {
			triggerRuleList.getSelectionModel().clearSelection();
			intermediateRuleList.getSelectionModel().clearSelection();
			refreshDescriptionArea((String) destroyerRuleList.getSelectionModel().getSelectedItem());
		} else if (source == intermediateRuleList && !intermediateRuleList.getSelectionModel().isEmpty()) {
			triggerRuleList.getSelectionModel().clearSelection();
			destroyerRuleList.getSelectionModel().clearSelection();
			refreshDescriptionArea((String) intermediateRuleList.getSelectionModel().getSelectedItem());
		}  else if (source == closeButton) {
//			setVisible(false);
//			dispose();
			close();
		}
	}

	// Updates all of the visible graphs
	public void update() {
		for (int i = 0; i < visibleGraphs.size(); i++) {
			Stage graph = visibleGraphs.get(i);
			// remove graphs whose windows have been closed from visibleGraphs:
			if (!graph.isShowing()) {
				visibleGraphs.remove(graph);
			} 
//				else if (graph instanceof ObjectGraph) {
//				((ObjectGraph) graph).update();
//			} else if (graph instanceof ActionGraph) {
//				((ActionGraph) graph).update();
//			} else if (graph instanceof CompositeGraph) {
//				((CompositeGraph) graph).update();
//			}
		}

		// update timelines browser:
		if (timelinesBrowser != null) {
			timelinesBrowser.update();
		}
	}

	private void refreshAttributeList() {
		attributeList.getItems().removeAll();
		String selectedObject = (String) objectList.getSelectionModel().getSelectedItem();
		if(selectedObject != null) {
			if (selectedObject.startsWith("SoftwareEngineer Employee")) {
				String[] attributes = { "Energy", "Mood", "PayRate", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("RequirementsDocument Artifact")) {
				String[] attributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("DesignDocument Artifact")) {
				String[] attributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("Code Artifact")) {
				String[] attributes = { "PercentComplete", "PercentIntegrated",
						"NumKnownErrors", "NumUnknownErrors", "PercentErroneous", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("SystemTestPlan Artifact")) {
				String[] attributes = { "NumKnownErrors", "NumUnknownErrors",
						"PercentErroneous", "PercentComplete", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("SEProject Project")) {
				String[] attributes = { "Budget", "MoneySpent", "AllottedTime",
						"TimeUsed", "Score", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("RequirementsCaptureTool Tool")) {
				String[] attributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("DesignEnvironment Tool")) {
				String[] attributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("IDE Tool")) {
				String[] attributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("AutomatedTestingTool Tool")) {
				String[] attributes = { "Cost", "ProductivityIncreaseFactor",
						"ErrorRateDecreaseFactor", };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(true);
				attributeList.scrollTo(0);
				attributeList.getSelectionModel().select(0);
				attributeList.getFocusModel().focus(0);
			} else if (selectedObject.startsWith("ACustomer Customer")) {
				String[] attributes = { "(No numerical attributes)" };
				attributeList.getItems().setAll(attributes);
				attributeList.setEditable(false);
			}
		}

	}

	private void setUpToolTips() {
		objectList.setTooltip(new Tooltip("Choose an object to graph"));
		attributeList.setTooltip(new Tooltip("Choose which attributes to graph"));
		actionList.setTooltip(new Tooltip("Choose which actions to graph"));
		actionComboBox.setTooltip(new Tooltip("Choose which action to show rules for"));
		triggerRuleList
				.setTooltip(new Tooltip("Rules that execute at the beginning of the action"));
		destroyerRuleList
				.setTooltip(new Tooltip("Rules that execute at the end of the action"));
		intermediateRuleList
				.setTooltip(new Tooltip("Rules that execute every clock tick during the life of the action"));
	}

	private void refreshButtons() {
		if (attributeList.getSelectionModel().isEmpty()) { // no attributes selected
			generateObjGraphButton.setDisable(true);
			generateCompGraphButton.setDisable(true);
		} else { // an attribute is selected
			generateObjGraphButton.setDisable(false);
			if (!actionList.getSelectionModel().isEmpty()) { // an action is also selected
				generateCompGraphButton.setDisable(false);
			}
		}
		if (actionList.getSelectionModel().isEmpty()) { // no actions selected
			generateActGraphButton.setDisable(true);
			generateCompGraphButton.setDisable(true);
		} else { // an action is selected
			generateActGraphButton.setDisable(false);
		}
	}

	private void refreshRuleLists(String actionName) {
		triggerRuleList.getItems().setAll(new Vector<String>());
		destroyerRuleList.getItems().setAll(new Vector<String>());
		intermediateRuleList.getItems().setAll(new Vector<String>());

		if (actionName.equals("CreateRequirements")) {
			String[] intList = { "CreateRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ReviewRequirements")) {
			String[] intList = { "ReviewRequirementsEffectRuleC",
					"ReviewRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CorrectRequirements")) {
			String[] intList = { "CorrectRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CreateDesign")) {
			String[] intList = { "CreateDesignEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ReviewDesign")) {
			String[] intList = { "ReviewDesignEffectRuleA",
					"ReviewDesignEffectRuleC", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CorrectDesign")) {
			String[] intList = { "CorrectDesignEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CreateCode")) {
			String[] trigList = {};
			triggerRuleList.getItems().setAll(trigList);
			String[] intList = { "CreateCodeEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("InspectCode")) {
			String[] intList = { "InspectCodeEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CorrectCode")) {
			String[] intList = { "CorrectCodeEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("IntegrateCode")) {
			String[] intList = { "IntegrateCodeEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("SystemTest")) {
			String[] intList = { "SystemTestEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CreateSystemTestPlan")) {
			String[] intList = { "CreateSystemTestPlanEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ReviewSystemTestPlan")) {
			String[] intList = { "ReviewTestPlanEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CorrectSystemTestPlan")) {
			String[] intList = { "CorrectTestPlanEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("DeliverProduct")) {
			String[] trigList = { "CalculateScore", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("Break")) {
			String[] trigList = { "BreakTrigRule", };
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = { "BreakDestRule", };
			destroyerRuleList.getItems().setAll(destList);
			String[] intList = { "BreakEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("GetSick")) {
			String[] trigList = { "GetSickTrigRule", };
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = { "GetSickDestRule", };
			destroyerRuleList.getItems().setAll(destList);
			String[] intList = { "GetSickEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("Quit")) {
			String[] trigList = { "QuitDestroyObjectsRuleA", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("IntroduceNewRequirements")) {
			String[] intList = { "IntroduceNewRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ChangePayRate")) {
			String[] trigList = { "ChangePayRateEffectRuleA", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("GiveBonus")) {
			String[] trigList = { "GiveBonusEffectRuleA", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("Fire")) {
			String[] trigList = { "FireDestroyObjectsRuleA", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("PurchaseTool")) {
			String[] trigList = { "PurchaseToolEffectRuleA", };
			triggerRuleList.getItems().setAll(trigList);
		} else if (actionName.equals("SuggestedRequirementsPhaseDuration")) {
			String[] trigList = {};
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = {};
			destroyerRuleList.getItems().setAll(destList);
		} else if (actionName.equals("SuggestedDesignPhaseDuration")) {
			String[] trigList = {};
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = {};
			destroyerRuleList.getItems().setAll(destList);
		} else if (actionName.equals("SuggestedImplIntegrationPhaseDuration")) {
			String[] trigList = {};
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = {};
			destroyerRuleList.getItems().setAll(destList);
		} else if (actionName.equals("SuggestedTestingPhaseDuration")) {
			String[] trigList = {};
			triggerRuleList.getItems().setAll(trigList);
			String[] destList = {};
			destroyerRuleList.getItems().setAll(destList);
		}
	}

	// refreshes the description area with the selected rule description
	private void refreshDescriptionArea(String ruleName) {
		if (ruleName != null) {
			String text = "";
			if (ruleName.equals("CreateRequirementsEffectRuleA")) {
				text = RuleDescriptions.CREATEREQUIREMENTS_CREATEREQUIREMENTSEFFECTRULEA;
			} else if (ruleName.equals("ReviewRequirementsEffectRuleA")) {
				text = RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEA;
			} else if (ruleName.equals("ReviewRequirementsEffectRuleC")) {
				text = RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEC;
			} else if (ruleName.equals("CorrectRequirementsEffectRuleA")) {
				text = RuleDescriptions.CORRECTREQUIREMENTS_CORRECTREQUIREMENTSEFFECTRULEA;
			} else if (ruleName.equals("CreateDesignEffectRuleA")) {
				text = RuleDescriptions.CREATEDESIGN_CREATEDESIGNEFFECTRULEA;
			} else if (ruleName.equals("ReviewDesignEffectRuleA")) {
				text = RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEA;
			} else if (ruleName.equals("ReviewDesignEffectRuleC")) {
				text = RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEC;
			} else if (ruleName.equals("CorrectDesignEffectRuleA")) {
				text = RuleDescriptions.CORRECTDESIGN_CORRECTDESIGNEFFECTRULEA;
			} else if (ruleName.equals("CreateCodeEffectRuleA")) {
				text = RuleDescriptions.CREATECODE_CREATECODEEFFECTRULEA;
			} else if (ruleName.equals("InspectCodeEffectRuleA")) {
				text = RuleDescriptions.INSPECTCODE_INSPECTCODEEFFECTRULEA;
			} else if (ruleName.equals("CorrectCodeEffectRuleA")) {
				text = RuleDescriptions.CORRECTCODE_CORRECTCODEEFFECTRULEA;
			} else if (ruleName.equals("IntegrateCodeEffectRuleA")) {
				text = RuleDescriptions.INTEGRATECODE_INTEGRATECODEEFFECTRULEA;
			} else if (ruleName.equals("SystemTestEffectRuleA")) {
				text = RuleDescriptions.SYSTEMTEST_SYSTEMTESTEFFECTRULEA;
			} else if (ruleName.equals("CreateSystemTestPlanEffectRuleA")) {
				text = RuleDescriptions.CREATESYSTEMTESTPLAN_CREATESYSTEMTESTPLANEFFECTRULEA;
			} else if (ruleName.equals("ReviewTestPlanEffectRuleA")) {
				text = RuleDescriptions.REVIEWSYSTEMTESTPLAN_REVIEWTESTPLANEFFECTRULEA;
			} else if (ruleName.equals("CorrectTestPlanEffectRuleA")) {
				text = RuleDescriptions.CORRECTSYSTEMTESTPLAN_CORRECTTESTPLANEFFECTRULEA;
			} else if (ruleName.equals("CalculateScore")) {
				text = RuleDescriptions.DELIVERPRODUCT_CALCULATESCORE;
			} else if (ruleName.equals("BreakEffectRuleA")) {
				text = RuleDescriptions.BREAK_BREAKEFFECTRULEA;
			} else if (ruleName.equals("BreakTrigRule")) {
				text = RuleDescriptions.BREAK_BREAKTRIGRULE;
			} else if (ruleName.equals("BreakDestRule")) {
				text = RuleDescriptions.BREAK_BREAKDESTRULE;
			} else if (ruleName.equals("GetSickEffectRuleA")) {
				text = RuleDescriptions.GETSICK_GETSICKEFFECTRULEA;
			} else if (ruleName.equals("GetSickTrigRule")) {
				text = RuleDescriptions.GETSICK_GETSICKTRIGRULE;
			} else if (ruleName.equals("GetSickDestRule")) {
				text = RuleDescriptions.GETSICK_GETSICKDESTRULE;
			} else if (ruleName.equals("QuitDestroyObjectsRuleA")) {
				text = RuleDescriptions.QUIT_QUITDESTROYOBJECTSRULEA;
			} else if (ruleName.equals("IntroduceNewRequirementsEffectRuleA")) {
				text = RuleDescriptions.INTRODUCENEWREQUIREMENTS_INTRODUCENEWREQUIREMENTSEFFECTRULEA;
			} else if (ruleName.equals("ChangePayRateEffectRuleA")) {
				text = RuleDescriptions.CHANGEPAYRATE_CHANGEPAYRATEEFFECTRULEA;
			} else if (ruleName.equals("GiveBonusEffectRuleA")) {
				text = RuleDescriptions.GIVEBONUS_GIVEBONUSEFFECTRULEA;
			} else if (ruleName.equals("FireDestroyObjectsRuleA")) {
				text = RuleDescriptions.FIRE_FIREDESTROYOBJECTSRULEA;
			} else if (ruleName.equals("PurchaseToolEffectRuleA")) {
				text = RuleDescriptions.PURCHASETOOL_PURCHASETOOLEFFECTRULEA;
			}
			descriptionArea.setText(text);
			descriptionArea.positionCaret(0);
		}
	}
}