/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.actions.CorrectCodeAction;
import simse.adts.objects.SSObject;

public class CorrectCodeActionStateRepository implements Cloneable {
	private Vector<CorrectCodeAction> actions;

	public CorrectCodeActionStateRepository() {
		actions = new Vector<CorrectCodeAction>();
	}

	public Object clone() {
		try {
			CorrectCodeActionStateRepository cl = (CorrectCodeActionStateRepository) (super
					.clone());
			Vector<CorrectCodeAction> clonedActions = new Vector<CorrectCodeAction>();
			for (int i = 0; i < actions.size(); i++) {
				clonedActions.add((CorrectCodeAction) actions.elementAt(i)
						.clone());
			}
			cl.actions = clonedActions;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public boolean add(CorrectCodeAction a) {
		if (actions.contains(a) == false) {
			actions.add(a);
			return true;
		}
		return false;
	}

	public boolean remove(CorrectCodeAction a) {
		if (actions.contains(a)) {
			actions.remove(a);
			return true;
		}
		return false;
	}

	public Vector<CorrectCodeAction> getAllActions() {
		return actions;
	}

	public Vector<CorrectCodeAction> getAllActions(SSObject a) {
		Vector<CorrectCodeAction> all = new Vector<CorrectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			CorrectCodeAction b = actions.elementAt(i);
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

	public Vector<CorrectCodeAction> getAllActiveActions(SSObject a) {
		Vector<CorrectCodeAction> all = new Vector<CorrectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			CorrectCodeAction b = actions.elementAt(i);
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

	public Vector<CorrectCodeAction> getAllInactiveActions(SSObject a) {
		Vector<CorrectCodeAction> all = new Vector<CorrectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			CorrectCodeAction b = actions.elementAt(i);
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

	public CorrectCodeAction getActionWithId(int id) {
		for (int i = 0; i < actions.size(); i++) {
			CorrectCodeAction act = actions.get(i);
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
			CorrectCodeAction act = actions.elementAt(i);
			act.refetchParticipants(artifactRep, customerRep, employeeRep,
					projectRep, toolRep);
		}
	}
}