/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.AutomatedTestingTool;
import simse.adts.objects.DesignEnvironment;
import simse.adts.objects.Employee;
import simse.adts.objects.IDE;
import simse.adts.objects.Project;
import simse.adts.objects.RequirementsCaptureTool;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.Tool;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class PurchaseToolAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> empwhosemenuclickedons;
	private Hashtable<Tool, Boolean> setools;
	private Hashtable<Project, Boolean> projs;
	private int timeToLive;

	public PurchaseToolAction() {
		empwhosemenuclickedons = new Hashtable<Employee, Boolean>();
		setools = new Hashtable<Tool, Boolean>();
		projs = new Hashtable<Project, Boolean>();
		timeToLive = 1;
		actionName = Action.PURCHASETOOL;
	}

	public Object clone() {
		PurchaseToolAction cl = (PurchaseToolAction) (super.clone());
		Hashtable<Employee, Boolean> clonedempwhosemenuclickedons = new Hashtable<Employee, Boolean>();
		clonedempwhosemenuclickedons.putAll(empwhosemenuclickedons);
		cl.empwhosemenuclickedons = clonedempwhosemenuclickedons;
		Hashtable<Tool, Boolean> clonedsetools = new Hashtable<Tool, Boolean>();
		clonedsetools.putAll(setools);
		cl.setools = clonedsetools;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
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
		all.addAll(getAllEmpWhoseMenuClickedOns());
		all.addAll(getAllSETools());
		all.addAll(getAllProjs());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmpWhoseMenuClickedOns());
		all.addAll(getAllActiveSETools());
		all.addAll(getAllActiveProjs());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmpWhoseMenuClickedOns());
		all.addAll(getAllInactiveSETools());
		all.addAll(getAllInactiveProjs());
		return all;
	}

	public Vector<Employee> getAllEmpWhoseMenuClickedOns() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = empwhosemenuclickedons.keys();
		for (int i = 0; i < empwhosemenuclickedons.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Employee> getAllActiveEmpWhoseMenuClickedOns() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = empwhosemenuclickedons.keys();
		for (int i = 0; i < empwhosemenuclickedons.size(); i++) {
			Employee key = e.nextElement();
			if ((empwhosemenuclickedons.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Employee> getAllInactiveEmpWhoseMenuClickedOns() {
		Vector<Employee> a = new Vector<Employee>();
		Enumeration<Employee> e = empwhosemenuclickedons.keys();
		for (int i = 0; i < empwhosemenuclickedons.size(); i++) {
			Employee key = e.nextElement();
			if ((empwhosemenuclickedons.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addEmpWhoseMenuClickedOn(Employee a) {
		if ((empwhosemenuclickedons.containsKey(a))
				|| (((a instanceof SoftwareEngineer) == false))
				|| (empwhosemenuclickedons.size() >= 1)) {
			return false;
		} else {
			empwhosemenuclickedons.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeEmpWhoseMenuClickedOn(Employee a) {
		if (empwhosemenuclickedons.containsKey(a)) {
			empwhosemenuclickedons.remove(a);
			return true;
		}
		return false;
	}

	public boolean setEmpWhoseMenuClickedOnActive(Employee a) {
		if (empwhosemenuclickedons.containsKey(a)) {
			empwhosemenuclickedons.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setEmpWhoseMenuClickedOnInactive(Employee a) {
		if (empwhosemenuclickedons.containsKey(a)) {
			empwhosemenuclickedons.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Tool> getAllSETools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = setools.keys();
		for (int i = 0; i < setools.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Tool> getAllActiveSETools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = setools.keys();
		for (int i = 0; i < setools.size(); i++) {
			Tool key = e.nextElement();
			if ((setools.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Tool> getAllInactiveSETools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = setools.keys();
		for (int i = 0; i < setools.size(); i++) {
			Tool key = e.nextElement();
			if ((setools.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addSETool(Tool a) {
		if ((setools.containsKey(a))
				|| (((a instanceof IDE) == false)
						&& ((a instanceof RequirementsCaptureTool) == false)
						&& ((a instanceof AutomatedTestingTool) == false) && ((a instanceof DesignEnvironment) == false))) {
			return false;
		} else {
			setools.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeSETool(Tool a) {
		if (setools.containsKey(a)) {
			setools.remove(a);
			return true;
		}
		return false;
	}

	public boolean setSEToolActive(Tool a) {
		if (setools.containsKey(a)) {
			setools.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setSEToolInactive(Tool a) {
		if (setools.containsKey(a)) {
			setools.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Project> getAllProjs() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projs.keys();
		for (int i = 0; i < projs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Project> getAllActiveProjs() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projs.keys();
		for (int i = 0; i < projs.size(); i++) {
			Project key = e.nextElement();
			if ((projs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Project> getAllInactiveProjs() {
		Vector<Project> a = new Vector<Project>();
		Enumeration<Project> e = projs.keys();
		for (int i = 0; i < projs.size(); i++) {
			Project key = e.nextElement();
			if ((projs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addProj(Project a) {
		if ((projs.containsKey(a)) || (((a instanceof SEProject) == false))
				|| (projs.size() >= 1)) {
			return false;
		} else {
			projs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeProj(Project a) {
		if (projs.containsKey(a)) {
			projs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setProjActive(Project a) {
		if (projs.containsKey(a)) {
			projs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setProjInactive(Project a) {
		if (projs.containsKey(a)) {
			projs.put(a, new Boolean(false));
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
		// empwhosemenuclickedon participants:
		Hashtable<Employee, Boolean> newEmpWhoseMenuClickedOns = new Hashtable<Employee, Boolean>();
		Iterator<Map.Entry<Employee, Boolean>> empwhosemenuclickedonsIterator = empwhosemenuclickedons
				.entrySet().iterator();
		while (empwhosemenuclickedonsIterator.hasNext()) {
			Map.Entry<Employee, Boolean> entry = empwhosemenuclickedonsIterator
					.next();
			Employee oldEmpWhoseMenuClickedOn = entry.getKey();
			if (oldEmpWhoseMenuClickedOn instanceof SoftwareEngineer) {
				Employee newEmpWhoseMenuClickedOn = employeeRep
						.getSoftwareEngineerStateRepository().get(
								((SoftwareEngineer) oldEmpWhoseMenuClickedOn)
										.getName());
				Boolean activeStatus = empwhosemenuclickedons
						.get(oldEmpWhoseMenuClickedOn);
				newEmpWhoseMenuClickedOns.put(newEmpWhoseMenuClickedOn,
						activeStatus);
			}
		}
		empwhosemenuclickedons.clear();
		empwhosemenuclickedons.putAll(newEmpWhoseMenuClickedOns);

		// setool participants:
		Hashtable<Tool, Boolean> newSETools = new Hashtable<Tool, Boolean>();
		Iterator<Map.Entry<Tool, Boolean>> setoolsIterator = setools.entrySet()
				.iterator();
		while (setoolsIterator.hasNext()) {
			Map.Entry<Tool, Boolean> entry = setoolsIterator.next();
			Tool oldSETool = entry.getKey();
			if (oldSETool instanceof IDE) {
				Tool newSETool = toolRep.getIDEStateRepository().get(
						((IDE) oldSETool).getName());
				Boolean activeStatus = setools.get(oldSETool);
				newSETools.put(newSETool, activeStatus);
			} else if (oldSETool instanceof RequirementsCaptureTool) {
				Tool newSETool = toolRep
						.getRequirementsCaptureToolStateRepository()
						.get(((RequirementsCaptureTool) oldSETool).getName());
				Boolean activeStatus = setools.get(oldSETool);
				newSETools.put(newSETool, activeStatus);
			} else if (oldSETool instanceof AutomatedTestingTool) {
				Tool newSETool = toolRep
						.getAutomatedTestingToolStateRepository().get(
								((AutomatedTestingTool) oldSETool).getName());
				Boolean activeStatus = setools.get(oldSETool);
				newSETools.put(newSETool, activeStatus);
			} else if (oldSETool instanceof DesignEnvironment) {
				Tool newSETool = toolRep.getDesignEnvironmentStateRepository()
						.get(((DesignEnvironment) oldSETool).getName());
				Boolean activeStatus = setools.get(oldSETool);
				newSETools.put(newSETool, activeStatus);
			}
		}
		setools.clear();
		setools.putAll(newSETools);

		// proj participants:
		Hashtable<Project, Boolean> newProjs = new Hashtable<Project, Boolean>();
		Iterator<Map.Entry<Project, Boolean>> projsIterator = projs.entrySet()
				.iterator();
		while (projsIterator.hasNext()) {
			Map.Entry<Project, Boolean> entry = projsIterator.next();
			Project oldProj = entry.getKey();
			if (oldProj instanceof SEProject) {
				Project newProj = projectRep.getSEProjectStateRepository().get(
						((SEProject) oldProj).getDescription());
				Boolean activeStatus = projs.get(oldProj);
				newProjs.put(newProj, activeStatus);
			}
		}
		projs.clear();
		projs.putAll(newProjs);

	}
}