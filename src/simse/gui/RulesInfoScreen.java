package simse.gui;

import java.util.Hashtable;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simse.logic.Logic;
import simse.state.State;
import simse.util.RuleCategories;
import simse.util.RuleDescriptions;
import simse.util.RuleType;

public class RulesInfoScreen  extends Stage implements EventHandler<MouseEvent>{
	State state;

	Label titleLabel;
	Label toolsLabel;
	
	BorderPane tablePane;
	VBox mainPane;
	
	private ComboBox<String> actionComboBox;
	private ListView triggerRuleList;
	private ListView destroyerRuleList;
	private ListView intermediateRuleList;
	private TextArea descriptionArea;
	private String lastSelectedAction;

	public RulesInfoScreen(State s, RuleType ruleType) {
		this.state = s;

		this.setTitle("Rules Screen");
		mainPane = new VBox();
		
		ObservableList<String> actions = setActionsByType(ruleType);
		
		// Create viewRuleTitlePane and label:
		Pane viewRulesTitlePane = new Pane();
		viewRulesTitlePane.getChildren().add(new Label("View Rules:"));
		mainPane.getChildren().add(viewRulesTitlePane);

		// Create actionsComboBoxPane:
		Pane actionComboBoxPane = new Pane();
		actionComboBoxPane.getChildren().add(new Label("Actions:"));
		actionComboBox = new ComboBox<String>(actions);
		actionComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (actionComboBox.getItems().size() > 0) {
					lastSelectedAction = (String) actionComboBox.getSelectionModel().getSelectedItem();
					refreshRuleLists(lastSelectedAction);
					descriptionArea.setText("");
				}
			}
		});
		actionComboBoxPane.getChildren().add(actionComboBox);
		mainPane.getChildren().add(actionComboBoxPane);

		// Create rulesMainPane:
		TilePane rulesMainPane = new TilePane();

		// Create ruleListsPane:
		VBox ruleListsPane = new VBox();

		// rule lists:
		Pane trigRuleTitlePane = new Pane();
		trigRuleTitlePane.getChildren().add(new Label("Trigger Rules:"));
		ruleListsPane.getChildren().add(trigRuleTitlePane);
		triggerRuleList = new ListView<String>();
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
		descriptionArea.setEditable(false);
		ScrollPane descriptionScrollPane = new ScrollPane(descriptionArea);
		descriptionScrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		descriptionScrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		descriptionPane.getChildren().add(descriptionScrollPane);

		rulesMainPane.getChildren().add(descriptionPane);

		// Add panes to main pane:
		mainPane.getChildren().add(rulesMainPane);
		
		Scene scene = new Scene(mainPane, 900, 550);
		this.setScene(scene);
	}

	private ObservableList<String> setActionsByType(RuleType ruleType) {
		ObservableList<String> actions = null;
		
		switch(ruleType) {
		case ARTIFACT:
			actions = FXCollections.observableArrayList(
					"CreateRequirements", "ReviewRequirements",
					"CorrectRequirements", "CreateDesign", "ReviewDesign",
					"CorrectDesign", "CreateCode", "InspectCode", "CorrectCode",
					"IntegrateCode", "SystemTest", "CreateSystemTestPlan",
					"ReviewSystemTestPlan", "CorrectSystemTestPlan",
					"DeliverProduct", "IntroduceNewRequirements");
			break;
		case PROJECT:
			actions = FXCollections.observableArrayList("DeliverProduct", "Quit",
					"IntroduceNewRequirements", "GiveBonus", "Fire", "PurchaseTool");
			break;
		case PEOPLE:
			actions = FXCollections.observableArrayList(
					"CreateRequirements", "ReviewRequirements",
					"CorrectRequirements", "CreateDesign", "ReviewDesign",
					"CorrectDesign", "CreateCode", "InspectCode", "CorrectCode",
					"IntegrateCode", "SystemTest", "CreateSystemTestPlan",
					"ReviewSystemTestPlan", "CorrectSystemTestPlan", "DeliverProduct", 
					"Break", "GetSick", "Quit", "ChangePayRate", "GiveBonus", "Fire");
			break;
		default:
			actions = FXCollections.observableArrayList(
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
		}
		return actions;
	}

	private void refreshRuleLists(String actionName) {
		triggerRuleList.getItems().setAll(new Vector<String>());
		destroyerRuleList.getItems().setAll(new Vector<String>());
		intermediateRuleList.getItems().setAll(new Vector<String>());
		
		String[] intList = RuleCategories.getIntRulesForAction(actionName);
		String[] trigList = RuleCategories.getAllTrigRulesForAction(actionName);
		String[] destList = RuleCategories.getAllDestRulesForAction(actionName);
		
		intermediateRuleList.getItems().setAll(intList);
		triggerRuleList.getItems().setAll(trigList);
		destroyerRuleList.getItems().setAll(destList);
	}

	// refreshes the description area with the selected rule description
	private void refreshDescriptionArea(String ruleName) {
		if (ruleName != null) {
			String text = RuleCategories.getRuleMapping(ruleName);
			if (text == "") {
				text = RuleCategories.getBackendRuleMappings(lastSelectedAction, ruleName);
			}
			descriptionArea.setText(text);
			descriptionArea.positionCaret(0);
		}
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		
		if ((source == triggerRuleList && !triggerRuleList.getSelectionModel().isEmpty())) {
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
		}
	}
}
