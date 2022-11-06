/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Employee;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class BreakAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> breakers;

	public BreakAction() {
		breakers = new Hashtable<Employee, Boolean>();
	}

	public Object clone() {
		BreakAction cl = (BreakAction) (super.clone());
		Hashtable<Employee, Boolean> clonedbreakers = new Hashtable<Employee, Boolean>();
		clonedbreakers.putAll(breakers);
		cl.breakers = clonedbreakers;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllBreakers());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveBreakers());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveBreakers());
		return all;
	}

	public Vector<Employee> getAllBreakers() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = breakers.keys();
		for (int i = 0; i < breakers.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Employee> getAllActiveBreakers() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = breakers.keys();
		for (int i = 0; i < breakers.size(); i++) {
			Employee key = e.nextElement();
			if ((breakers.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Employee> getAllInactiveBreakers() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = breakers.keys();
		for (int i = 0; i < breakers.size(); i++) {
			Employee key = e.nextElement();
			if ((breakers.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addBreaker(Employee a) {
		if ((breakers.containsKey(a))
				|| (((a instanceof SoftwareEngineer) == false))
				|| (breakers.size() >= 1)) {
			return false;
		} else {
			breakers.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeBreaker(Employee a) {
		if (breakers.containsKey(a)) {
			breakers.remove(a);
			return true;
		}
		return false;
	}

	public boolean setBreakerActive(Employee a) {
		if (breakers.containsKey(a)) {
			breakers.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setBreakerInactive(Employee a) {
		if (breakers.containsKey(a)) {
			breakers.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	/*
	 * Replaces all the participants in this action with their equivalent
	 * objects in the current state. Calling this function solves the problem
	 * that happens when you clone actions -- their hashtables point to
	 * participant objects that were part of the previous, non-cloned state.
	 * Hence, this function should be called after this object is cloned.
	 */
	public void refetchParticipants(ArtifactStateRepository artifactRep,
			CustomerStateRepository customerRep,
			EmployeeStateRepository employeeRep,
			ProjectStateRepository projectRep, ToolStateRepository toolRep) {
		// breaker participants:
		Hashtable<Employee, Boolean> newBreakers = new Hashtable<Employee, Boolean>();
		Iterator<Map.Entry<Employee, Boolean>> breakersIterator = breakers
				.entrySet().iterator();
		while (breakersIterator.hasNext()) {
			Map.Entry<Employee, Boolean> entry = breakersIterator.next();
			Employee oldBreaker = entry.getKey();
			if (oldBreaker instanceof SoftwareEngineer) {
				Employee newBreaker = employeeRep
						.getSoftwareEngineerStateRepository().get(
								((SoftwareEngineer) oldBreaker).getName());
				Boolean activeStatus = breakers.get(oldBreaker);
				newBreakers.put(newBreaker, activeStatus);
			}
		}
		breakers.clear();
		breakers.putAll(newBreakers);

	}
}