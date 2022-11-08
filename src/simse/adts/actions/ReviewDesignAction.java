/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.DesignDocument;
import simse.adts.objects.Employee;
import simse.adts.objects.Project;
import simse.adts.objects.RequirementsDocument;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.state.ArtifactStateRepository;
import simse.state.CustomerStateRepository;
import simse.state.EmployeeStateRepository;
import simse.state.ProjectStateRepository;
import simse.state.ToolStateRepository;

public class ReviewDesignAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Artifact, Boolean> designdocs;
	private Hashtable<Project, Boolean> projs;
	private Hashtable<Artifact, Boolean> associatedrequirementsdocs;

	public ReviewDesignAction() {
		emps = new Hashtable<Employee, Boolean>();
		designdocs = new Hashtable<Artifact, Boolean>();
		projs = new Hashtable<Project, Boolean>();
		associatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
	}

	public Object clone() {
		ReviewDesignAction cl = (ReviewDesignAction) (super.clone());
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Artifact, Boolean> cloneddesigndocs = new Hashtable<Artifact, Boolean>();
		cloneddesigndocs.putAll(designdocs);
		cl.designdocs = cloneddesigndocs;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
		Hashtable<Artifact, Boolean> clonedassociatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		clonedassociatedrequirementsdocs.putAll(associatedrequirementsdocs);
		cl.associatedrequirementsdocs = clonedassociatedrequirementsdocs;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllEmps());
		all.addAll(getAllDesignDocs());
		all.addAll(getAllProjs());
		all.addAll(getAllAssociatedRequirementsDocs());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveDesignDocs());
		all.addAll(getAllActiveProjs());
		all.addAll(getAllActiveAssociatedRequirementsDocs());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveDesignDocs());
		all.addAll(getAllInactiveProjs());
		all.addAll(getAllInactiveAssociatedRequirementsDocs());
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

	public Vector<Artifact> getAllDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = designdocs.keys();
		for (int i = 0; i < designdocs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = designdocs.keys();
		for (int i = 0; i < designdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((designdocs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = designdocs.keys();
		for (int i = 0; i < designdocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((designdocs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addDesignDoc(Artifact a) {
		if ((designdocs.containsKey(a))
				|| (((a instanceof DesignDocument) == false))
				|| (designdocs.size() >= 1)) {
			return false;
		} else {
			designdocs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeDesignDoc(Artifact a) {
		if (designdocs.containsKey(a)) {
			designdocs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setDesignDocActive(Artifact a) {
		if (designdocs.containsKey(a)) {
			designdocs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setDesignDocInactive(Artifact a) {
		if (designdocs.containsKey(a)) {
			designdocs.put(a, new Boolean(false));
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

		// designdoc participants:
		Hashtable<Artifact, Boolean> newDesignDocs = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> designdocsIterator = designdocs
				.entrySet().iterator();
		while (designdocsIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = designdocsIterator.next();
			Artifact oldDesignDoc = entry.getKey();
			if (oldDesignDoc instanceof DesignDocument) {
				Artifact newDesignDoc = artifactRep
						.getDesignDocumentStateRepository().get(
								((DesignDocument) oldDesignDoc).getName());
				Boolean activeStatus = designdocs.get(oldDesignDoc);
				newDesignDocs.put(newDesignDoc, activeStatus);
			}
		}
		designdocs.clear();
		designdocs.putAll(newDesignDocs);

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

	}
}