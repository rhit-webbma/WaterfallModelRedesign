/* File generated by: simse.codegenerator.logicgenerator.LogicGenerator */
package simse.logic;

import javafx.stage.Stage;
import simse.state.State;

public class Logic {
	private State state;
	private MiscUpdater updater;
	private TriggerChecker trigChecker;
	private DestroyerChecker destChecker;
	private MenuInputManager menInputMgr;
	private RuleExecutor ruleEx;

	public Logic(State s) {
		state = s;
		updater = new MiscUpdater(state);
		ruleEx = new RuleExecutor(state);
		trigChecker = new TriggerChecker(state, ruleEx);
		destChecker = new DestroyerChecker(state, ruleEx, trigChecker);
		ruleEx.setTriggerChecker(trigChecker);
		ruleEx.setDestroyerChecker(destChecker);
		menInputMgr = new MenuInputManager(state, trigChecker, destChecker, ruleEx);
	}

	public MenuInputManager getMenuInputManager() {
		return menInputMgr;
	}

	public TriggerChecker getTriggerChecker() {
		return trigChecker;
	}

	public DestroyerChecker getDestroyerChecker() {
		return destChecker;
	}

	public void update(Stage mainGUI) {
		updater.update();
		trigChecker.update(false, mainGUI);
		ruleEx.update(mainGUI, RuleExecutor.UPDATE_ALL_CONTINUOUS, null, null);
		destChecker.update(false, mainGUI);
	}
}