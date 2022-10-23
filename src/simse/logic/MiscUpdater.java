/* File generated by: simse.codegenerator.logicgenerator.MiscUpdaterGenerator */
package simse.logic;

import simse.state.*;
import simse.adts.objects.*;
import simse.adts.actions.*;
import java.util.*;

public class MiscUpdater {
	private State state;

	public MiscUpdater(State s) {
		state = s;
	}

	public void update() {
		// clear menus and overhead texts:
		Vector<Employee> employees = state.getEmployeeStateRepository()
				.getAll();
		for (int i = 0; i < employees.size(); i++) {
			employees.elementAt(i).clearOverheadText();
			employees.elementAt(i).clearMenu();
		}

		// update actions' time elapsed:
		Vector<simse.adts.actions.Action> actions = state
				.getActionStateRepository().getAllActions();
		for (int i = 0; i < actions.size(); i++) {
			simse.adts.actions.Action act = actions.elementAt(i);
			act.incrementTimeElapsed();
		}

		// decrement time to live for actions w/ timed destroyers:
		Vector<QuitAction> quitActions = state.getActionStateRepository()
				.getQuitActionStateRepository().getAllActions();
		for (int i = 0; i < quitActions.size(); i++) {
			QuitAction act = quitActions.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<IntroduceNewRequirementsAction> introducenewrequirementsActions = state
				.getActionStateRepository()
				.getIntroduceNewRequirementsActionStateRepository()
				.getAllActions();
		for (int i = 0; i < introducenewrequirementsActions.size(); i++) {
			IntroduceNewRequirementsAction act = introducenewrequirementsActions
					.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<ChangePayRateAction> changepayrateActions = state
				.getActionStateRepository()
				.getChangePayRateActionStateRepository().getAllActions();
		for (int i = 0; i < changepayrateActions.size(); i++) {
			ChangePayRateAction act = changepayrateActions.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<GiveBonusAction> givebonusActions = state
				.getActionStateRepository().getGiveBonusActionStateRepository()
				.getAllActions();
		for (int i = 0; i < givebonusActions.size(); i++) {
			GiveBonusAction act = givebonusActions.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<FireAction> fireActions = state.getActionStateRepository()
				.getFireActionStateRepository().getAllActions();
		for (int i = 0; i < fireActions.size(); i++) {
			FireAction act = fireActions.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<PurchaseToolAction> purchasetoolActions = state
				.getActionStateRepository()
				.getPurchaseToolActionStateRepository().getAllActions();
		for (int i = 0; i < purchasetoolActions.size(); i++) {
			PurchaseToolAction act = purchasetoolActions.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<SuggestedRequirementsPhaseDurationAction> suggestedrequirementsphasedurationActions = state
				.getActionStateRepository()
				.getSuggestedRequirementsPhaseDurationActionStateRepository()
				.getAllActions();
		for (int i = 0; i < suggestedrequirementsphasedurationActions.size(); i++) {
			SuggestedRequirementsPhaseDurationAction act = suggestedrequirementsphasedurationActions
					.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<SuggestedDesignPhaseDurationAction> suggesteddesignphasedurationActions = state
				.getActionStateRepository()
				.getSuggestedDesignPhaseDurationActionStateRepository()
				.getAllActions();
		for (int i = 0; i < suggesteddesignphasedurationActions.size(); i++) {
			SuggestedDesignPhaseDurationAction act = suggesteddesignphasedurationActions
					.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<SuggestedImplIntegrationPhaseDurationAction> suggestedimplintegrationphasedurationActions = state
				.getActionStateRepository()
				.getSuggestedImplIntegrationPhaseDurationActionStateRepository()
				.getAllActions();
		for (int i = 0; i < suggestedimplintegrationphasedurationActions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction act = suggestedimplintegrationphasedurationActions
					.elementAt(i);
			act.decrementTimeToLive();
		}
		Vector<SuggestedTestingPhaseDurationAction> suggestedtestingphasedurationActions = state
				.getActionStateRepository()
				.getSuggestedTestingPhaseDurationActionStateRepository()
				.getAllActions();
		for (int i = 0; i < suggestedtestingphasedurationActions.size(); i++) {
			SuggestedTestingPhaseDurationAction act = suggestedtestingphasedurationActions
					.elementAt(i);
			act.decrementTimeToLive();
		}

		// update clock:
		state.getClock().incrementTime();
	}
}
