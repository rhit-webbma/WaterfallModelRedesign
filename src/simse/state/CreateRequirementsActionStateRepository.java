/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.actions.CreateRequirementsAction;
import simse.adts.objects.SSObject;

public class CreateRequirementsActionStateRepository implements Cloneable {
	private Vector<CreateRequirementsAction> actions;

	public CreateRequirementsActionStateRepository() {
		actions = new Vector<CreateRequirementsAction>();
	}

	public Object clone() {
		try {
			CreateRequirementsActionStateRepository cl = (CreateRequirementsActionStateRepository) (super
					.clone());
			Vector<CreateRequirementsAction> clonedActions = new Vector<CreateRequirementsAction>();
			for (int i = 0; i < actions.size(); i++) {
				clonedActions.add((CreateRequirementsAction) actions.elementAt(
						i).clone());
			}
			cl.actions = clonedActions;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public boolean add(CreateRequirementsAction a) {
		if (actions.contains(a) == false) {
			actions.add(a);
			return true;
		}
		return false;
	}

	public boolean remove(CreateRequirementsAction a) {
		if (actions.contains(a)) {
			actions.remove(a);
			return true;
		}
		return false;
	}

	public Vector<CreateRequirementsAction> getAllActions() {
		return actions;
	}

	public Vector<CreateRequirementsAction> getAllActions(SSObject a) {
		Vector<CreateRequirementsAction> all = new Vector<CreateRequirementsAction>();
		for (int i = 0; i < actions.size(); i++) {
			CreateRequirementsAction b = actions.elementAt(i);
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

	public Vector<CreateRequirementsAction> getAllActiveActions(SSObject a) {
		Vector<CreateRequirementsAction> all = new Vector<CreateRequirementsAction>();
		for (int i = 0; i < actions.size(); i++) {
			CreateRequirementsAction b = actions.elementAt(i);
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

	public Vector<CreateRequirementsAction> getAllInactiveActions(SSObject a) {
		Vector<CreateRequirementsAction> all = new Vector<CreateRequirementsAction>();
		for (int i = 0; i < actions.size(); i++) {
			CreateRequirementsAction b = actions.elementAt(i);
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

	public CreateRequirementsAction getActionWithId(int id) {
		for (int i = 0; i < actions.size(); i++) {
			CreateRequirementsAction act = actions.get(i);
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
			CreateRequirementsAction act = actions.elementAt(i);
			act.refetchParticipants(artifactRep, customerRep, employeeRep,
					projectRep, toolRep);
		}
	}
}