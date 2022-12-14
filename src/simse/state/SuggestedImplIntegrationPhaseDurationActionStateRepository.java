/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.actions.SuggestedImplIntegrationPhaseDurationAction;
import simse.adts.objects.SSObject;

public class SuggestedImplIntegrationPhaseDurationActionStateRepository
		implements Cloneable {
	private Vector<SuggestedImplIntegrationPhaseDurationAction> actions;

	public SuggestedImplIntegrationPhaseDurationActionStateRepository() {
		actions = new Vector<SuggestedImplIntegrationPhaseDurationAction>();
	}

	public Object clone() {
		try {
			SuggestedImplIntegrationPhaseDurationActionStateRepository cl = (SuggestedImplIntegrationPhaseDurationActionStateRepository) (super
					.clone());
			Vector<SuggestedImplIntegrationPhaseDurationAction> clonedActions = new Vector<SuggestedImplIntegrationPhaseDurationAction>();
			for (int i = 0; i < actions.size(); i++) {
				clonedActions
						.add((SuggestedImplIntegrationPhaseDurationAction) actions
								.elementAt(i).clone());
			}
			cl.actions = clonedActions;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public boolean add(SuggestedImplIntegrationPhaseDurationAction a) {
		if (actions.contains(a) == false) {
			actions.add(a);
			return true;
		}
		return false;
	}

	public boolean remove(SuggestedImplIntegrationPhaseDurationAction a) {
		if (actions.contains(a)) {
			actions.remove(a);
			return true;
		}
		return false;
	}

	public Vector<SuggestedImplIntegrationPhaseDurationAction> getAllActions() {
		return actions;
	}

	public Vector<SuggestedImplIntegrationPhaseDurationAction> getAllActions(
			SSObject a) {
		Vector<SuggestedImplIntegrationPhaseDurationAction> all = new Vector<SuggestedImplIntegrationPhaseDurationAction>();
		for (int i = 0; i < actions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction b = actions
					.elementAt(i);
			Vector<SSObject> parts = b.getAllParticipants();
			for (int j = 0; j < parts.size(); j++) {
				if (parts.elementAt(j).equals(a)) {
					all.add(b);
					break;
				}
			}
		}
		return all;
	}

	public Vector<SuggestedImplIntegrationPhaseDurationAction> getAllActiveActions(
			SSObject a) {
		Vector<SuggestedImplIntegrationPhaseDurationAction> all = new Vector<SuggestedImplIntegrationPhaseDurationAction>();
		for (int i = 0; i < actions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction b = actions
					.elementAt(i);
			Vector<SSObject> parts = b.getAllActiveParticipants();
			for (int j = 0; j < parts.size(); j++) {
				if (parts.elementAt(j).equals(a)) {
					all.add(b);
					break;
				}
			}
		}
		return all;
	}

	public Vector<SuggestedImplIntegrationPhaseDurationAction> getAllInactiveActions(
			SSObject a) {
		Vector<SuggestedImplIntegrationPhaseDurationAction> all = new Vector<SuggestedImplIntegrationPhaseDurationAction>();
		for (int i = 0; i < actions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction b = actions
					.elementAt(i);
			Vector<SSObject> parts = b.getAllInactiveParticipants();
			for (int j = 0; j < parts.size(); j++) {
				if (parts.elementAt(j).equals(a)) {
					all.add(b);
					break;
				}
			}
		}
		return all;
	}

	public SuggestedImplIntegrationPhaseDurationAction getActionWithId(int id) {
		for (int i = 0; i < actions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction act = actions.get(i);
			if (act.getId() == id) {
				return act;
			}
		}
		return null;
	}

	/*
	 * Replaces all the participants in each action with their equivalent
	 * objects in the current state. Calling this function solves the problem
	 * that happens when you clone actions -- their hashtables point to
	 * participant objects that were part of the previous, non-cloned state.
	 * Hence, this function should be called after this object is cloned.
	 */
	public void refetchParticipants(ArtifactStateRepository artifactRep,
			CustomerStateRepository customerRep,
			EmployeeStateRepository employeeRep,
			ProjectStateRepository projectRep, ToolStateRepository toolRep) {
		for (int i = 0; i < actions.size(); i++) {
			SuggestedImplIntegrationPhaseDurationAction act = actions
					.elementAt(i);
			act.refetchParticipants(artifactRep, customerRep, employeeRep,
					projectRep, toolRep);
		}
	}
}