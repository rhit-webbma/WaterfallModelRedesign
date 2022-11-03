/* File generated by: simse.codegenerator.explanatorytoolgenerator.RuleInfoPanelGenerator */
package simse.explanatorytool;

import simse.adts.actions.*;
import simse.explanatorytool.RuleDescriptions;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Dimension;

public class RuleInfoPanel extends JPanel implements ListSelectionListener {
	private simse.adts.actions.Action action; // action in focus

	private JList triggerRuleList;
	private JList destroyerRuleList;
	private JList intermediateRuleList;
	private JTextArea descriptionArea; // for displaying a rule description

	public RuleInfoPanel(JFrame owner, simse.adts.actions.Action action) {
		this.action = action;

		// Create main panel:
		JPanel mainPane = new JPanel();
		mainPane.setPreferredSize(new Dimension(900, 550));

		// Create rule pane and components:
		Box rulePane = Box.createVerticalBox();
		JPanel trigRuleTitlePane = new JPanel();
		trigRuleTitlePane.add(new JLabel("Trigger Rules:"));
		rulePane.add(trigRuleTitlePane);

		// rule lists:
		triggerRuleList = new JList();
		triggerRuleList.setVisibleRowCount(7);
		triggerRuleList.setFixedCellWidth(400);
		triggerRuleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		triggerRuleList.addListSelectionListener(this);
		JScrollPane triggerRuleListPane = new JScrollPane(triggerRuleList);
		String trigToolTip = "Rules that execute at the beginning of the action";
		trigRuleTitlePane.setToolTipText(trigToolTip);
		triggerRuleList.setToolTipText(trigToolTip);
		rulePane.add(triggerRuleListPane);

		JPanel destRuleTitlePane = new JPanel();
		destRuleTitlePane.add(new JLabel("Destroyer Rules:"));
		rulePane.add(destRuleTitlePane);
		destroyerRuleList = new JList();
		destroyerRuleList.setVisibleRowCount(7);
		destroyerRuleList.setFixedCellWidth(400);
		destroyerRuleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		destroyerRuleList.addListSelectionListener(this);
		JScrollPane destroyerRuleListPane = new JScrollPane(destroyerRuleList);
		String destToolTip = "Rules that execute at the end of the action";
		destRuleTitlePane.setToolTipText(destToolTip);
		destroyerRuleList.setToolTipText(destToolTip);
		rulePane.add(destroyerRuleListPane);

		JPanel intRuleTitlePane = new JPanel();
		intRuleTitlePane.add(new JLabel("Intermediate Rules:"));
		rulePane.add(intRuleTitlePane);
		intermediateRuleList = new JList();
		intermediateRuleList.setVisibleRowCount(7);
		intermediateRuleList.setFixedCellWidth(400);
		intermediateRuleList
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		intermediateRuleList.addListSelectionListener(this);
		JScrollPane intermediateRuleListPane = new JScrollPane(
				intermediateRuleList);
		String intToolTip = "Rules that execute every clock tick during the life of the action";
		intRuleTitlePane.setToolTipText(intToolTip);
		intermediateRuleList.setToolTipText(intToolTip);
		rulePane.add(intermediateRuleListPane);

		initializeRuleLists();

		// description pane:
		Box descriptionPane = Box.createVerticalBox();
		JPanel descriptionTitlePane = new JPanel();
		descriptionTitlePane.add(new JLabel("Description:"));
		descriptionPane.add(descriptionTitlePane);

		// description text area:
		descriptionArea = new JTextArea(29, 30);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setEditable(false);
		JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descriptionPane.add(descriptionScrollPane);

		rulePane.add(descriptionPane);

		// Add panes to main pane:
		mainPane.add(rulePane);
		mainPane.add(descriptionPane);
		add(mainPane);

		setOpaque(true);
		validate();
		repaint();
	}

	public void valueChanged(ListSelectionEvent e) {
		if ((e.getSource() == triggerRuleList && !triggerRuleList
				.isSelectionEmpty())) {
			destroyerRuleList.clearSelection();
			intermediateRuleList.clearSelection();
			refreshDescriptionArea();
		} else if (e.getSource() == destroyerRuleList
				&& !destroyerRuleList.isSelectionEmpty()) {
			triggerRuleList.clearSelection();
			intermediateRuleList.clearSelection();
			refreshDescriptionArea();
		} else if (e.getSource() == intermediateRuleList
				&& !intermediateRuleList.isSelectionEmpty()) {
			triggerRuleList.clearSelection();
			destroyerRuleList.clearSelection();
			refreshDescriptionArea();
		}
	}

	private void initializeRuleLists() {
		if (action instanceof CreateRequirementsAction) {
			String[] intList = { "CreateRequirementsEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof ReviewRequirementsAction) {
			String[] intList = { "ReviewRequirementsEffectRuleC",
					"ReviewRequirementsEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CorrectRequirementsAction) {
			String[] intList = { "CorrectRequirementsEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CreateDesignAction) {
			String[] intList = { "CreateDesignEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof ReviewDesignAction) {
			String[] intList = { "ReviewDesignEffectRuleA",
					"ReviewDesignEffectRuleC", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CorrectDesignAction) {
			String[] intList = { "CorrectDesignEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CreateCodeAction) {
			String[] trigList = {};
			triggerRuleList.setListData(trigList);
			String[] intList = { "CreateCodeEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof InspectCodeAction) {
			String[] intList = { "InspectCodeEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CorrectCodeAction) {
			String[] intList = { "CorrectCodeEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof IntegrateCodeAction) {
			String[] intList = { "IntegrateCodeEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof SystemTestAction) {
			String[] intList = { "SystemTestEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CreateSystemTestPlanAction) {
			String[] intList = { "CreateSystemTestPlanEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof ReviewSystemTestPlanAction) {
			String[] intList = { "ReviewTestPlanEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof CorrectSystemTestPlanAction) {
			String[] intList = { "CorrectTestPlanEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof DeliverProductAction) {
			String[] trigList = { "CalculateScore", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof BreakAction) {
			String[] trigList = { "BreakTrigRule", };
			triggerRuleList.setListData(trigList);
			String[] destList = { "BreakDestRule", };
			destroyerRuleList.setListData(destList);
			String[] intList = { "BreakEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof GetSickAction) {
			String[] trigList = { "GetSickTrigRule", };
			triggerRuleList.setListData(trigList);
			String[] destList = { "GetSickDestRule", };
			destroyerRuleList.setListData(destList);
			String[] intList = { "GetSickEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof QuitAction) {
			String[] trigList = { "QuitDestroyObjectsRuleA", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof IntroduceNewRequirementsAction) {
			String[] intList = { "IntroduceNewRequirementsEffectRuleA", };
			intermediateRuleList.setListData(intList);
		} else if (action instanceof ChangePayRateAction) {
			String[] trigList = { "ChangePayRateEffectRuleA", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof GiveBonusAction) {
			String[] trigList = { "GiveBonusEffectRuleA", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof FireAction) {
			String[] trigList = { "FireDestroyObjectsRuleA", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof PurchaseToolAction) {
			String[] trigList = { "PurchaseToolEffectRuleA", };
			triggerRuleList.setListData(trigList);
		} else if (action instanceof SuggestedRequirementsPhaseDurationAction) {
			String[] trigList = {};
			triggerRuleList.setListData(trigList);
			String[] destList = {};
			destroyerRuleList.setListData(destList);
		} else if (action instanceof SuggestedDesignPhaseDurationAction) {
			String[] trigList = {};
			triggerRuleList.setListData(trigList);
			String[] destList = {};
			destroyerRuleList.setListData(destList);
		} else if (action instanceof SuggestedImplIntegrationPhaseDurationAction) {
			String[] trigList = {};
			triggerRuleList.setListData(trigList);
			String[] destList = {};
			destroyerRuleList.setListData(destList);
		} else if (action instanceof SuggestedTestingPhaseDurationAction) {
			String[] trigList = {};
			triggerRuleList.setListData(trigList);
			String[] destList = {};
			destroyerRuleList.setListData(destList);
		}
	}

	// refreshes the description area with the selected rule description
	private void refreshDescriptionArea() {
		String name = null;
		if (!triggerRuleList.isSelectionEmpty()) {
			name = (String) triggerRuleList.getSelectedValue();
		} else if (!destroyerRuleList.isSelectionEmpty()) {
			name = (String) destroyerRuleList.getSelectedValue();
		} else if (!intermediateRuleList.isSelectionEmpty()) {
			name = (String) intermediateRuleList.getSelectedValue();
		}
		if (name != null) {
			String text = "";
			if (action instanceof CreateRequirementsAction) {
				if (name.equals("CreateRequirementsEffectRuleA")) {
					text = RuleDescriptions.CREATEREQUIREMENTS_CREATEREQUIREMENTSEFFECTRULEA;
				}
			} else if (action instanceof ReviewRequirementsAction) {
				if (name.equals("ReviewRequirementsEffectRuleA")) {
					text = RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEA;
				} else if (name.equals("ReviewRequirementsEffectRuleC")) {
					text = RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEC;
				}
			} else if (action instanceof CorrectRequirementsAction) {
				if (name.equals("CorrectRequirementsEffectRuleA")) {
					text = RuleDescriptions.CORRECTREQUIREMENTS_CORRECTREQUIREMENTSEFFECTRULEA;
				}
			} else if (action instanceof CreateDesignAction) {
				if (name.equals("CreateDesignEffectRuleA")) {
					text = RuleDescriptions.CREATEDESIGN_CREATEDESIGNEFFECTRULEA;
				}
			} else if (action instanceof ReviewDesignAction) {
				if (name.equals("ReviewDesignEffectRuleA")) {
					text = RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEA;
				} else if (name.equals("ReviewDesignEffectRuleC")) {
					text = RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEC;
				}
			} else if (action instanceof CorrectDesignAction) {
				if (name.equals("CorrectDesignEffectRuleA")) {
					text = RuleDescriptions.CORRECTDESIGN_CORRECTDESIGNEFFECTRULEA;
				}
			} else if (action instanceof CreateCodeAction) {
				if (name.equals("CreateCodeEffectRuleA")) {
					text = RuleDescriptions.CREATECODE_CREATECODEEFFECTRULEA;
				}
			} else if (action instanceof InspectCodeAction) {
				if (name.equals("InspectCodeEffectRuleA")) {
					text = RuleDescriptions.INSPECTCODE_INSPECTCODEEFFECTRULEA;
				}
			} else if (action instanceof CorrectCodeAction) {
				if (name.equals("CorrectCodeEffectRuleA")) {
					text = RuleDescriptions.CORRECTCODE_CORRECTCODEEFFECTRULEA;
				}
			} else if (action instanceof IntegrateCodeAction) {
				if (name.equals("IntegrateCodeEffectRuleA")) {
					text = RuleDescriptions.INTEGRATECODE_INTEGRATECODEEFFECTRULEA;
				}
			} else if (action instanceof SystemTestAction) {
				if (name.equals("SystemTestEffectRuleA")) {
					text = RuleDescriptions.SYSTEMTEST_SYSTEMTESTEFFECTRULEA;
				}
			} else if (action instanceof CreateSystemTestPlanAction) {
				if (name.equals("CreateSystemTestPlanEffectRuleA")) {
					text = RuleDescriptions.CREATESYSTEMTESTPLAN_CREATESYSTEMTESTPLANEFFECTRULEA;
				}
			} else if (action instanceof ReviewSystemTestPlanAction) {
				if (name.equals("ReviewTestPlanEffectRuleA")) {
					text = RuleDescriptions.REVIEWSYSTEMTESTPLAN_REVIEWTESTPLANEFFECTRULEA;
				}
			} else if (action instanceof CorrectSystemTestPlanAction) {
				if (name.equals("CorrectTestPlanEffectRuleA")) {
					text = RuleDescriptions.CORRECTSYSTEMTESTPLAN_CORRECTTESTPLANEFFECTRULEA;
				}
			} else if (action instanceof DeliverProductAction) {
				if (name.equals("CalculateScore")) {
					text = RuleDescriptions.DELIVERPRODUCT_CALCULATESCORE;
				}
			} else if (action instanceof BreakAction) {
				if (name.equals("BreakEffectRuleA")) {
					text = RuleDescriptions.BREAK_BREAKEFFECTRULEA;
				} else if (name.equals("BreakTrigRule")) {
					text = RuleDescriptions.BREAK_BREAKTRIGRULE;
				} else if (name.equals("BreakDestRule")) {
					text = RuleDescriptions.BREAK_BREAKDESTRULE;
				}
			} else if (action instanceof GetSickAction) {
				if (name.equals("GetSickEffectRuleA")) {
					text = RuleDescriptions.GETSICK_GETSICKEFFECTRULEA;
				} else if (name.equals("GetSickTrigRule")) {
					text = RuleDescriptions.GETSICK_GETSICKTRIGRULE;
				} else if (name.equals("GetSickDestRule")) {
					text = RuleDescriptions.GETSICK_GETSICKDESTRULE;
				}
			} else if (action instanceof QuitAction) {
				if (name.equals("QuitDestroyObjectsRuleA")) {
					text = RuleDescriptions.QUIT_QUITDESTROYOBJECTSRULEA;
				}
			} else if (action instanceof IntroduceNewRequirementsAction) {
				if (name.equals("IntroduceNewRequirementsEffectRuleA")) {
					text = RuleDescriptions.INTRODUCENEWREQUIREMENTS_INTRODUCENEWREQUIREMENTSEFFECTRULEA;
				}
			} else if (action instanceof ChangePayRateAction) {
				if (name.equals("ChangePayRateEffectRuleA")) {
					text = RuleDescriptions.CHANGEPAYRATE_CHANGEPAYRATEEFFECTRULEA;
				}
			} else if (action instanceof GiveBonusAction) {
				if (name.equals("GiveBonusEffectRuleA")) {
					text = RuleDescriptions.GIVEBONUS_GIVEBONUSEFFECTRULEA;
				}
			} else if (action instanceof FireAction) {
				if (name.equals("FireDestroyObjectsRuleA")) {
					text = RuleDescriptions.FIRE_FIREDESTROYOBJECTSRULEA;
				}
			} else if (action instanceof PurchaseToolAction) {
				if (name.equals("PurchaseToolEffectRuleA")) {
					text = RuleDescriptions.PURCHASETOOL_PURCHASETOOLEFFECTRULEA;
				}
			} else if (action instanceof SuggestedRequirementsPhaseDurationAction) {
			} else if (action instanceof SuggestedDesignPhaseDurationAction) {
			} else if (action instanceof SuggestedImplIntegrationPhaseDurationAction) {
			} else if (action instanceof SuggestedTestingPhaseDurationAction) {
			}
			descriptionArea.setText(text);
			descriptionArea.setCaretPosition(0);
		}
	}
}