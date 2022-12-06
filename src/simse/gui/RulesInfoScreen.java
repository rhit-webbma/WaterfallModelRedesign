package simse.gui;

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
import simse.util.RuleDescriptions;
import simse.util.RuleType;

public class RulesInfoScreen  extends Stage implements EventHandler<MouseEvent>{
	State state;
	SimSEGUI gui;
	Logic logic;

	Label titleLabel;
	Label toolsLabel;
	
	BorderPane tablePane;
	VBox mainPane;
	
	private ComboBox<String> actionComboBox;
	private ListView triggerRuleList;
	private ListView destroyerRuleList;
	private ListView intermediateRuleList;
	private TextArea descriptionArea; // for displaying a rule description

	public RulesInfoScreen(State s, SimSEGUI gui, Logic l, RuleType ruleType) {
		this.state = s;
		this.gui = gui;
		this.logic = l;

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
					refreshRuleLists((String) actionComboBox.getSelectionModel().getSelectedItem());
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
		
		if (actionName.equals("CreateRequirements")) {
			String[] intList = { "CreateRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ReviewRequirements")) {
			String[] intList = { "ReviewRequirementsEffectRuleC", "ReviewRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CorrectRequirements")) {
			String[] intList = { "CorrectRequirementsEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("CreateDesign")) {
			String[] intList = { "CreateDesignEffectRuleA", };
			intermediateRuleList.getItems().setAll(intList);
		} else if (actionName.equals("ReviewDesign")) {
			String[] intList = { "ReviewDesignEffectRuleA", "ReviewDesignEffectRuleC", };
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
