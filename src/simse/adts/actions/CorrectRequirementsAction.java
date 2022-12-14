/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.Employee;
import simse.adts.objects.Project;
import simse.adts.objects.RequirementsCaptureTool;
import simse.adts.objects.RequirementsDocument;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.Tool;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class CorrectRequirementsAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Artifact, Boolean> requirementsdocs;
	private Hashtable<Project, Boolean> projs;
	private Hashtable<Tool, Boolean> requirementscapturetools;

	public CorrectRequirementsAction() {
		emps = new Hashtable<Employee, Boolean>();
		requirementsdocs = new Hashtable<Artifact, Boolean>();
		projs = new Hashtable<Project, Boolean>();
		requirementscapturetools = new Hashtable<Tool, Boolean>();
		actionName = Action.CORRECTREQUIREMENTS;
	}

	public Object clone() {
		CorrectRequirementsAction cl = (CorrectRequirementsAction) (super
				.clone());
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Artifact, Boolean> clonedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		clonedrequirementsdocs.putAll(requirementsdocs);
		cl.requirementsdocs = clonedrequirementsdocs;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
		Hashtable<Tool, Boolean> clonedrequirementscapturetools = new Hashtable<Tool, Boolean>();
		clonedrequirementscapturetools.putAll(requirementscapturetools);
		cl.requirementscapturetools = clonedrequirementscapturetools;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllEmps());
		all.addAll(getAllRequirementsDocs());
		all.addAll(getAllProjs());
		all.addAll(getAllRequirementsCaptureTools());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveRequirementsDocs());
		all.addAll(getAllActiveProjs());
		all.addAll(getAllActiveRequirementsCaptureTools());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveRequirementsDocs());
		all.addAll(getAllInactiveProjs());
		all.addAll(getAllInactiveRequirementsCaptureTools());
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
				|| (((a instanceof SoftwareEngineer) == false))) {
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

	public Vector<Artifact> getAllRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = requirementsdocs.keys();
		for (int i = 0; i < requirementsdocs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = requirementsdocs.keys();
		for (int i = 0; i < requirementsdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((requirementsdocs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = requirementsdocs.keys();
		for (int i = 0; i < requirementsdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((requirementsdocs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addRequirementsDoc(Artifact a) {
		if ((requirementsdocs.containsKey(a))
				|| (((a instanceof RequirementsDocument) == false))
				|| (requirementsdocs.size() >= 1)) {
			return false;
		} else {
			requirementsdocs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeRequirementsDoc(Artifact a) {
		if (requirementsdocs.containsKey(a)) {
			requirementsdocs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setRequirementsDocActive(Artifact a) {
		if (requirementsdocs.containsKey(a)) {
			requirementsdocs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setRequirementsDocInactive(Artifact a) {
		if (requirementsdocs.containsKey(a)) {
			requirementsdocs.put(a, new Boolean(false));
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

	public Vector<Tool> getAllRequirementsCaptureTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = requirementscapturetools.keys();
		for (int i = 0; i < requirementscapturetools.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Tool> getAllActiveRequirementsCaptureTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = requirementscapturetools.keys();
		for (int i = 0; i < requirementscapturetools.size(); i++) {
			Tool key = e.nextElement();
			if ((requirementscapturetools.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Tool> getAllInactiveRequirementsCaptureTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = requirementscapturetools.keys();
		for (int i = 0; i < requirementscapturetools.size(); i++) {
			Tool key = e.nextElement();
			if ((requirementscapturetools.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addRequirementsCaptureTool(Tool a) {
		if ((requirementscapturetools.containsKey(a))
				|| (((a instanceof RequirementsCaptureTool) == false))) {
			return false;
		} else {
			requirementscapturetools.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeRequirementsCaptureTool(Tool a) {
		if (requirementscapturetools.containsKey(a)) {
			requirementscapturetools.remove(a);
			return true;
		}
		return false;
	}

	public boolean setRequirementsCaptureToolActive(Tool a) {
		if (requirementscapturetools.containsKey(a)) {
			requirementscapturetools.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setRequirementsCaptureToolInactive(Tool a) {
		if (requirementscapturetools.containsKey(a)) {
			requirementscapturetools.put(a, new Boolean(false));
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

		// requirementsdoc participants:
		Hashtable<Artifact, Boolean> newRequirementsDocs = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> requirementsdocsIterator = requirementsdocs
				.entrySet().iterator();
		while (requirementsdocsIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = requirementsdocsIterator
					.next();
			Artifact oldRequirementsDoc = entry.getKey();
			if (oldRequirementsDoc instanceof RequirementsDocument) {
				Artifact newRequirementsDoc = artifactRep
						.getRequirementsDocumentStateRepository().get(
								((RequirementsDocument) oldRequirementsDoc)
										.getName());
				Boolean activeStatus = requirementsdocs.get(oldRequirementsDoc);
				newRequirementsDocs.put(newRequirementsDoc, activeStatus);
			}
		}
		requirementsdocs.clear();
		requirementsdocs.putAll(newRequirementsDocs);

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

		// requirementscapturetool participants:
		Hashtable<Tool, Boolean> newRequirementsCaptureTools = new Hashtable<Tool, Boolean>();
		Iterator<Map.Entry<Tool, Boolean>> requirementscapturetoolsIterator = requirementscapturetools
				.entrySet().iterator();
		while (requirementscapturetoolsIterator.hasNext()) {
			Map.Entry<Tool, Boolean> entry = requirementscapturetoolsIterator
					.next();
			Tool oldRequirementsCaptureTool = entry.getKey();
			if (oldRequirementsCaptureTool instanceof RequirementsCaptureTool) {
				Tool newRequirementsCaptureTool = toolRep
						.getRequirementsCaptureToolStateRepository()
						.get(((RequirementsCaptureTool) oldRequirementsCaptureTool)
								.getName());
				Boolean activeStatus = requirementscapturetools
						.get(oldRequirementsCaptureTool);
				newRequirementsCaptureTools.put(newRequirementsCaptureTool,
						activeStatus);
			}
		}
		requirementscapturetools.clear();
		requirementscapturetools.putAll(newRequirementsCaptureTools);

	}
}