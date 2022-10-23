/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import simse.adts.objects.*;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;
import java.util.*;

public class ReviewSystemTestPlanAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Artifact, Boolean> testplans;
	private Hashtable<Artifact, Boolean> associatedrequirementsdocs;
	private Hashtable<Project, Boolean> projs;

	public ReviewSystemTestPlanAction() {
		emps = new Hashtable<Employee, Boolean>();
		testplans = new Hashtable<Artifact, Boolean>();
		associatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		projs = new Hashtable<Project, Boolean>();
	}

	public Object clone() {
		ReviewSystemTestPlanAction cl = (ReviewSystemTestPlanAction) (super
				.clone());
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Artifact, Boolean> clonedtestplans = new Hashtable<Artifact, Boolean>();
		clonedtestplans.putAll(testplans);
		cl.testplans = clonedtestplans;
		Hashtable<Artifact, Boolean> clonedassociatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		clonedassociatedrequirementsdocs.putAll(associatedrequirementsdocs);
		cl.associatedrequirementsdocs = clonedassociatedrequirementsdocs;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllEmps());
		all.addAll(getAllTestPlans());
		all.addAll(getAllAssociatedRequirementsDocs());
		all.addAll(getAllProjs());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveTestPlans());
		all.addAll(getAllActiveAssociatedRequirementsDocs());
		all.addAll(getAllActiveProjs());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveTestPlans());
		all.addAll(getAllInactiveAssociatedRequirementsDocs());
		all.addAll(getAllInactiveProjs());
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

	public Vector<Artifact> getAllTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = testplans.keys();
		for (int i = 0; i < testplans.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = testplans.keys();
		for (int i = 0; i < testplans.size(); i++) {
			Artifact key = e.nextElement();
			if ((testplans.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveTestPlans() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = testplans.keys();
		for (int i = 0; i < testplans.size(); i++) {
			Artifact key = e.nextElement();
			if ((testplans.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addTestPlan(Artifact a) {
		if ((testplans.containsKey(a))
				|| (((a instanceof SystemTestPlan) == false))
				|| (testplans.size() >= 1)) {
			return false;
		} else {
			testplans.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeTestPlan(Artifact a) {
		if (testplans.containsKey(a)) {
			testplans.remove(a);
			return true;
		}
		return false;
	}

	public boolean setTestPlanActive(Artifact a) {
		if (testplans.containsKey(a)) {
			testplans.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setTestPlanInactive(Artifact a) {
		if (testplans.containsKey(a)) {
			testplans.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Artifact> getAllAssociatedRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedrequirementsdocs.keys();
		for (int i = 0; i < associatedrequirementsdocs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveAssociatedRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedrequirementsdocs.keys();
		for (int i = 0; i < associatedrequirementsdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((associatedrequirementsdocs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveAssociatedRequirementsDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associatedrequirementsdocs.keys();
		for (int i = 0; i < associatedrequirementsdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((associatedrequirementsdocs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addAssociatedRequirementsDoc(Artifact a) {
		if ((associatedrequirementsdocs.containsKey(a))
				|| (((a instanceof RequirementsDocument) == false))
				|| (associatedrequirementsdocs.size() >= 1)) {
			return false;
		} else {
			associatedrequirementsdocs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeAssociatedRequirementsDoc(Artifact a) {
		if (associatedrequirementsdocs.containsKey(a)) {
			associatedrequirementsdocs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setAssociatedRequirementsDocActive(Artifact a) {
		if (associatedrequirementsdocs.containsKey(a)) {
			associatedrequirementsdocs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setAssociatedRequirementsDocInactive(Artifact a) {
		if (associatedrequirementsdocs.containsKey(a)) {
			associatedrequirementsdocs.put(a, new Boolean(false));
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

		// testplan participants:
		Hashtable<Artifact, Boolean> newTestPlans = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> testplansIterator = testplans
				.entrySet().iterator();
		while (testplansIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = testplansIterator.next();
			Artifact oldTestPlan = entry.getKey();
			if (oldTestPlan instanceof SystemTestPlan) {
				Artifact newTestPlan = artifactRep
						.getSystemTestPlanStateRepository().get(
								((SystemTestPlan) oldTestPlan).getName());
				Boolean activeStatus = testplans.get(oldTestPlan);
				newTestPlans.put(newTestPlan, activeStatus);
			}
		}
		testplans.clear();
		testplans.putAll(newTestPlans);

		// associatedrequirementsdoc participants:
		Hashtable<Artifact, Boolean> newAssociatedRequirementsDocs = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> associatedrequirementsdocsIterator = associatedrequirementsdocs
				.entrySet().iterator();
		while (associatedrequirementsdocsIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = associatedrequirementsdocsIterator
					.next();
			Artifact oldAssociatedRequirementsDoc = entry.getKey();
			if (oldAssociatedRequirementsDoc instanceof RequirementsDocument) {
				Artifact newAssociatedRequirementsDoc = artifactRep
						.getRequirementsDocumentStateRepository()
						.get(((RequirementsDocument) oldAssociatedRequirementsDoc)
								.getName());
				Boolean activeStatus = associatedrequirementsdocs
						.get(oldAssociatedRequirementsDoc);
				newAssociatedRequirementsDocs.put(newAssociatedRequirementsDoc,
						activeStatus);
			}
		}
		associatedrequirementsdocs.clear();
		associatedrequirementsdocs.putAll(newAssociatedRequirementsDocs);

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