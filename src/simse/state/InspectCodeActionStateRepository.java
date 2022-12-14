/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.actions.InspectCodeAction;
import simse.adts.objects.SSObject;

public class InspectCodeActionStateRepository implements Cloneable {
	private Vector<InspectCodeAction> actions;

	public InspectCodeActionStateRepository() {
		actions = new Vector<InspectCodeAction>();
	}

	public Object clone() {
		try {
			InspectCodeActionStateRepository cl = (InspectCodeActionStateRepository) (super
					.clone());
			Vector<InspectCodeAction> clonedActions = new Vector<InspectCodeAction>();
			for (int i = 0; i < actions.size(); i++) {
				clonedActions.add((InspectCodeAction) actions.elementAt(i)
						.clone());
			}
			cl.actions = clonedActions;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public boolean add(InspectCodeAction a) {
		if (actions.contains(a) == false) {
			actions.add(a);
			return true;
		}
		return false;
	}

	public boolean remove(InspectCodeAction a) {
		if (actions.contains(a)) {
			actions.remove(a);
			return true;
		}
		return false;
	}

	public Vector<InspectCodeAction> getAllActions() {
		return actions;
	}

	public Vector<InspectCodeAction> getAllActions(SSObject a) {
		Vector<InspectCodeAction> all = new Vector<InspectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			InspectCodeAction b = actions.elementAt(i);
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

	public Vector<InspectCodeAction> getAllActiveActions(SSObject a) {
		Vector<InspectCodeAction> all = new Vector<InspectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			InspectCodeAction b = actions.elementAt(i);
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

	public Vector<InspectCodeAction> getAllInactiveActions(SSObject a) {
		Vector<InspectCodeAction> all = new Vector<InspectCodeAction>();
		for (int i = 0; i < actions.size(); i++) {
			InspectCodeAction b = actions.elementAt(i);
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

	public InspectCodeAction getActionWithId(int id) {
		for (int i = 0; i < actions.size(); i++) {
			InspectCodeAction act = actions.get(i);
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
			InspectCodeAction act = actions.elementAt(i);
			act.refetchParticipants(artifactRep, customerRep, employeeRep,
					projectRep, toolRep);
		}
	}
}