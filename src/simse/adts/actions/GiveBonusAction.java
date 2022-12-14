/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Employee;
import simse.adts.objects.Project;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class GiveBonusAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Project, Boolean> projectwithbudgets;
	private int timeToLive;

	public GiveBonusAction() {
		emps = new Hashtable<Employee, Boolean>();
		projectwithbudgets = new Hashtable<Project, Boolean>();
		timeToLive = 1;
		actionName = Action.GIVEBONUS;
	}

	public Object clone() {
		GiveBonusAction cl = (GiveBonusAction) (super.clone());
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Project, Boolean> clonedprojectwithbudgets = new Hashtable<Project, Boolean>();
		clonedprojectwithbudgets.putAll(projectwithbudgets);
		cl.projectwithbudgets = clonedprojectwithbudgets;
		return cl;
	}

	public int getTimeToLive() {
		return timeToLive;
	}

	public void decrementTimeToLive() {
		timeToLive--;
		if (timeToLive < 0) {
			timeToLive = 0;
		}
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllEmps());
		all.addAll(getAllProjectWithBudgets());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveProjectWithBudgets());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveProjectWithBudgets());
		return all;
	}

	public Vector<Employee> getAllEmps() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = emps.keys();
		for (int i = 0; i < emps.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Employee> getAllActiveEmps() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = emps.keys();
		for (int i = 0; i < emps.size(); i++) {
			Employee key = e.nextElement();
			if ((emps.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Employee> getAllInactiveEmps() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = emps.keys();
		for (int i = 0; i < emps.size(); i++) {
			Employee key = e.nextElement();
			if ((emps.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addEmp(Employee a) {
		if ((emps.containsKey(a))
				|| (((a instanceof SoftwareEngineer) == false))
				|| (emps.size() >= 1)) {
			return false;
		} else {
			emps.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeEmp(Employee a) {
		if (emps.containsKey(a)) {
			emps.remove(a);
			return true;
		}
		return false;
	}

	public boolean setEmpActive(Employee a) {
		if (emps.containsKey(a)) {
			emps.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setEmpInactive(Employee a) {
		if (emps.containsKey(a)) {
			emps.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Project> getAllProjectWithBudgets() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projectwithbudgets.keys();
		for (int i = 0; i < projectwithbudgets.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Project> getAllActiveProjectWithBudgets() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projectwithbudgets.keys();
		for (int i = 0; i < projectwithbudgets.size(); i++) {
			Project key = e.nextElement();
			if ((projectwithbudgets.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Project> getAllInactiveProjectWithBudgets() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projectwithbudgets.keys();
		for (int i = 0; i < projectwithbudgets.size(); i++) {
			Project key = e.nextElement();
			if ((projectwithbudgets.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addProjectWithBudget(Project a) {
		if ((projectwithbudgets.containsKey(a))
				|| (((a instanceof SEProject) == false))
				|| (projectwithbudgets.size() >= 1)) {
			return false;
		} else {
			projectwithbudgets.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeProjectWithBudget(Project a) {
		if (projectwithbudgets.containsKey(a)) {
			projectwithbudgets.remove(a);
			return true;
		}
		return false;
	}

	public boolean setProjectWithBudgetActive(Project a) {
		if (projectwithbudgets.containsKey(a)) {
			projectwithbudgets.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setProjectWithBudgetInactive(Project a) {
		if (projectwithbudgets.containsKey(a)) {
			projectwithbudgets.put(a, new Boolean(false));
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
		// emp participants:
		Hashtable<Employee, Boolean> newEmps = new Hashtable<Employee, Boolean>();
		Iterator<Map.Entry<Employee, Boolean>> empsIterator = emps.entrySet()
				.iterator();
		while (empsIterator.hasNext()) {
			Map.Entry<Employee, Boolean> entry = empsIterator.next();
			Employee oldEmp = entry.getKey();
			if (oldEmp instanceof SoftwareEngineer) {
				Employee newEmp = employeeRep
						.getSoftwareEngineerStateRepository().get(
								((SoftwareEngineer) oldEmp).getName());
				Boolean activeStatus = emps.get(oldEmp);
				newEmps.put(newEmp, activeStatus);
			}
		}
		emps.clear();
		emps.putAll(newEmps);

		// projectwithbudget participants:
		Hashtable<Project, Boolean> newProjectWithBudgets = new Hashtable<Project, Boolean>();
		Iterator<Map.Entry<Project, Boolean>> projectwithbudgetsIterator = projectwithbudgets
				.entrySet().iterator();
		while (projectwithbudgetsIterator.hasNext()) {
			Map.Entry<Project, Boolean> entry = projectwithbudgetsIterator
					.next();
			Project oldProjectWithBudget = entry.getKey();
			if (oldProjectWithBudget instanceof SEProject) {
				Project newProjectWithBudget = projectRep
						.getSEProjectStateRepository().get(
								((SEProject) oldProjectWithBudget)
										.getDescription());
				Boolean activeStatus = projectwithbudgets
						.get(oldProjectWithBudget);
				newProjectWithBudgets.put(newProjectWithBudget, activeStatus);
			}
		}
		projectwithbudgets.clear();
		projectwithbudgets.putAll(newProjectWithBudgets);

	}
}