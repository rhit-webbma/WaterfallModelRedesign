/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.actions.ReviewDesignAction;
import simse.adts.objects.SSObject;

public class ReviewDesignActionStateRepository implements Cloneable {
	private Vector<ReviewDesignAction> actions;

	public ReviewDesignActionStateRepository() {
		actions = new Vector<ReviewDesignAction>();
	}

	public Object clone() {
		try {
			ReviewDesignActionStateRepository cl = (ReviewDesignActionStateRepository) (super
					.clone());
			Vector<ReviewDesignAction> clonedActions = new Vector<ReviewDesignAction>();
			for (int i = 0; i < actions.size(); i++) {
				clonedActions.add((ReviewDesignAction) actions.elementAt(i)
						.clone());
			}
			cl.actions = clonedActions;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public boolean add(ReviewDesignAction a) {
		if (actions.contains(a) == false) {
			actions.add(a);
			return true;
		}
		return false;
	}

	public boolean remove(ReviewDesignAction a) {
		if (actions.contains(a)) {
			actions.remove(a);
			return true;
		}
		return false;
	}

	public Vector<ReviewDesignAction> getAllActions() {
		return actions;
	}

	public Vector<ReviewDesignAction> getAllActions(SSObject a) {
		Vector<ReviewDesignAction> all = new Vector<ReviewDesignAction>();
		for (int i = 0; i < actions.size(); i++) {
			ReviewDesignAction b = actions.elementAt(i);
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

	public Vector<ReviewDesignAction> getAllActiveActions(SSObject a) {
		Vector<ReviewDesignAction> all = new Vector<ReviewDesignAction>();
		for (int i = 0; i < actions.size(); i++) {
			ReviewDesignAction b = actions.elementAt(i);
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

	public Vector<ReviewDesignAction> getAllInactiveActions(SSObject a) {
		Vector<ReviewDesignAction> all = new Vector<ReviewDesignAction>();
		for (int i = 0; i < actions.size(); i++) {
			ReviewDesignAction b = actions.elementAt(i);
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

	public ReviewDesignAction getActionWithId(int id) {
		for (int i = 0; i < actions.size(); i++) {
			ReviewDesignAction act = actions.get(i);
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
			ReviewDesignAction act = actions.elementAt(i);
			act.refetchParticipants(artifactRep, customerRep, employeeRep,
					projectRep, toolRep);
		}
	}
}