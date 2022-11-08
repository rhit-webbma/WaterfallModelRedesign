/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.AutomatedTestingTool;
import simse.adts.objects.Code;
import simse.adts.objects.Employee;
import simse.adts.objects.Project;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.SystemTestPlan;
import simse.adts.objects.Tool;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class SystemTestAction extends Action implements Cloneable {
	private Hashtable<Artifact, Boolean> codedocs;
	private Hashtable<Project, Boolean> projs;
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Artifact, Boolean> associatedsystemtestplans;
	private Hashtable<Tool, Boolean> testingtools;

	public SystemTestAction() {
		codedocs = new Hashtable<Artifact, Boolean>();
		projs = new Hashtable<Project, Boolean>();
		emps = new Hashtable<Employee, Boolean>();
		associatedsystemtestplans = new Hashtable<Artifact, Boolean>();
		testingtools = new Hashtable<Tool, Boolean>();
	}

	public Object clone() {
		SystemTestAction cl = (SystemTestAction) (super.clone());
		Hashtable<Artifact, Boolean> clonedcodedocs = new Hashtable<Artifact, Boolean>();
		clonedcodedocs.putAll(codedocs);
		cl.codedocs = clonedcodedocs;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Artifact, Boolean> clonedassociatedsystemtestplans = new Hashtable<Artifact, Boolean>();
		clonedassociatedsystemtestplans.putAll(associatedsystemtestplans);
		cl.associatedsystemtestplans = clonedassociatedsystemtestplans;
		Hashtable<Tool, Boolean> clonedtestingtools = new Hashtable<Tool, Boolean>();
		clonedtestingtools.putAll(testingtools);
		cl.testingtools = clonedtestingtools;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllCodeDocs());
		all.addAll(getAllProjs());
		all.addAll(getAllEmps());
		all.addAll(getAllAssociatedSystemTestPlans());
		all.addAll(getAllTestingTools());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveCodeDocs());
		all.addAll(getAllActiveProjs());
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveAssociatedSystemTestPlans());
		all.addAll(getAllActiveTestingTools());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveCodeDocs());
		all.addAll(getAllInactiveProjs());
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveAssociatedSystemTestPlans());
		all.addAll(getAllInactiveTestingTools());
		return all;
	}

	public Vector<Artifact> getAllCodeDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = codedocs.keys();
		for (int i = 0; i < codedocs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveCodeDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = codedocs.keys();
		for (int i = 0; i < codedocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((codedocs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveCodeDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = codedocs.keys();
		for (int i = 0; i < codedocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((codedocs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addCodeDoc(Artifact a) {
		if ((codedocs.containsKey(a)) || (((a instanceof Code) == false))
				|| (codedocs.size() >= 1)) {
			return false;
		} else {
			codedocs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeCodeDoc(Artifact a) {
		if (codedocs.containsKey(a)) {
			codedocs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setCodeDocActive(Artifact a) {
		if (codedocs.containsKey(a)) {
			codedocs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setCodeDocInactive(Artifact a) {
		if (codedocs.containsKey(a)) {
			codedocs.put(a, new Boolean(false));
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

	public Vector<Artifact> getAllAssociatedSystemTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedsystemtestplans.keys();
		for (int i = 0; i < associatedsystemtestplans.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveAssociatedSystemTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedsystemtestplans.keys();
		for (int i = 0; i < associatedsystemtestplans.size(); i++) {
			Artifact key = e.nextElement();
			if ((associatedsystemtestplans.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveAssociatedSystemTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedsystemtestplans.keys();
		for (int i = 0; i < associatedsystemtestplans.size(); i++) {
			Artifact key = e.nextElement();
			if ((associatedsystemtestplans.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addAssociatedSystemTestPlan(Artifact a) {
		if ((associatedsystemtestplans.containsKey(a))
				|| (((a instanceof SystemTestPlan) == false))
				|| (associatedsystemtestplans.size() >= 1)) {
			return false;
		} else {
			associatedsystemtestplans.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeAssociatedSystemTestPlan(Artifact a) {
		if (associatedsystemtestplans.containsKey(a)) {
			associatedsystemtestplans.remove(a);
			return true;
		}
		return false;
	}

	public boolean setAssociatedSystemTestPlanActive(Artifact a) {
		if (associatedsystemtestplans.containsKey(a)) {
			associatedsystemtestplans.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setAssociatedSystemTestPlanInactive(Artifact a) {
		if (associatedsystemtestplans.containsKey(a)) {
			associatedsystemtestplans.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Tool> getAllTestingTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = testingtools.keys();
		for (int i = 0; i < testingtools.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Tool> getAllActiveTestingTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = testingtools.keys();
		for (int i = 0; i < testingtools.size(); i++) {
			Tool key = e.nextElement();
			if ((testingtools.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Tool> getAllInactiveTestingTools() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = testingtools.keys();
		for (int i = 0; i < testingtools.size(); i++) {
			Tool key = e.nextElement();
			if ((testingtools.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addTestingTool(Tool a) {
		if ((testingtools.containsKey(a))
				|| (((a instanceof AutomatedTestingTool) == false))) {
			return false;
		} else {
			testingtools.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeTestingTool(Tool a) {
		if (testingtools.containsKey(a)) {
			testingtools.remove(a);
			return true;
		}
		return false;
	}

	public boolean setTestingToolActive(Tool a) {
		if (testingtools.containsKey(a)) {
			testingtools.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setTestingToolInactive(Tool a) {
		if (testingtools.containsKey(a)) {
			testingtools.put(a, new Boolean(false));
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
		// codedoc participants:
		Hashtable<Artifact, Boolean> newCodeDocs = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> codedocsIterator = codedocs
				.entrySet().iterator();
		while (codedocsIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = codedocsIterator.next();
			Artifact oldCodeDoc = entry.getKey();
			if (oldCodeDoc instanceof Code) {
				Artifact newCodeDoc = artifactRep.getCodeStateRepository().get(
						((Code) oldCodeDoc).getName());
				Boolean activeStatus = codedocs.get(oldCodeDoc);
				newCodeDocs.put(newCodeDoc, activeStatus);
			}
		}
		codedocs.clear();
		codedocs.putAll(newCodeDocs);

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

		// associatedsystemtestplan participants:
		Hashtable<Artifact, Boolean> newAssociatedSystemTestPlans = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> associatedsystemtestplansIterator = associatedsystemtestplans
				.entrySet().iterator();
		while (associatedsystemtestplansIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = associatedsystemtestplansIterator
					.next();
			Artifact oldAssociatedSystemTestPlan = entry.getKey();
			if (oldAssociatedSystemTestPlan instanceof SystemTestPlan) {
				Artifact newAssociatedSystemTestPlan = artifactRep
						.getSystemTestPlanStateRepository().get(
								((SystemTestPlan) oldAssociatedSystemTestPlan)
										.getName());
				Boolean activeStatus = associatedsystemtestplans
						.get(oldAssociatedSystemTestPlan);
				newAssociatedSystemTestPlans.put(newAssociatedSystemTestPlan,
						activeStatus);
			}
		}
		associatedsystemtestplans.clear();
		associatedsystemtestplans.putAll(newAssociatedSystemTestPlans);

		// testingtool participants:
		Hashtable<Tool, Boolean> newTestingTools = new Hashtable<Tool, Boolean>();
		Iterator<Map.Entry<Tool, Boolean>> testingtoolsIterator = testingtools
				.entrySet().iterator();
		while (testingtoolsIterator.hasNext()) {
			Map.Entry<Tool, Boolean> entry = testingtoolsIterator.next();
			Tool oldTestingTool = entry.getKey();
			if (oldTestingTool instanceof AutomatedTestingTool) {
				Tool newTestingTool = toolRep
						.getAutomatedTestingToolStateRepository().get(
								((AutomatedTestingTool) oldTestingTool)
										.getName());
				Boolean activeStatus = testingtools.get(oldTestingTool);
				newTestingTools.put(newTestingTool, activeStatus);
			}
		}
		testingtools.clear();
		testingtools.putAll(newTestingTools);

	}
}