/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.Code;
import simse.adts.objects.DesignDocument;
import simse.adts.objects.Employee;
import simse.adts.objects.IDE;
import simse.adts.objects.Project;
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

public class IntegrateCodeAction extends Action implements Cloneable {
	private Hashtable<Employee, Boolean> emps;
	private Hashtable<Artifact, Boolean> codedocs;
	private Hashtable<Project, Boolean> projs;
	private Hashtable<Artifact, Boolean> associatedrequirementsdocs;
	private Hashtable<Artifact, Boolean> associateddesigndocs;
	private Hashtable<Tool, Boolean> developmentenvironments;

	public IntegrateCodeAction() {
		emps = new Hashtable<Employee, Boolean>();
		codedocs = new Hashtable<Artifact, Boolean>();
		projs = new Hashtable<Project, Boolean>();
		associatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		associateddesigndocs = new Hashtable<Artifact, Boolean>();
		developmentenvironments = new Hashtable<Tool, Boolean>();
		actionName = Action.INTEGRATECODE;
	}

	public Object clone() {
		IntegrateCodeAction cl = (IntegrateCodeAction) (super.clone());
		Hashtable<Employee, Boolean> clonedemps = new Hashtable<Employee, Boolean>();
		clonedemps.putAll(emps);
		cl.emps = clonedemps;
		Hashtable<Artifact, Boolean> clonedcodedocs = new Hashtable<Artifact, Boolean>();
		clonedcodedocs.putAll(codedocs);
		cl.codedocs = clonedcodedocs;
		Hashtable<Project, Boolean> clonedprojs = new Hashtable<Project, Boolean>();
		clonedprojs.putAll(projs);
		cl.projs = clonedprojs;
		Hashtable<Artifact, Boolean> clonedassociatedrequirementsdocs = new Hashtable<Artifact, Boolean>();
		clonedassociatedrequirementsdocs.putAll(associatedrequirementsdocs);
		cl.associatedrequirementsdocs = clonedassociatedrequirementsdocs;
		Hashtable<Artifact, Boolean> clonedassociateddesigndocs = new Hashtable<Artifact, Boolean>();
		clonedassociateddesigndocs.putAll(associateddesigndocs);
		cl.associateddesigndocs = clonedassociateddesigndocs;
		Hashtable<Tool, Boolean> cloneddevelopmentenvironments = new Hashtable<Tool, Boolean>();
		cloneddevelopmentenvironments.putAll(developmentenvironments);
		cl.developmentenvironments = cloneddevelopmentenvironments;
		return cl;
	}

	public Vector<SSObject> getAllParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllEmps());
		all.addAll(getAllCodeDocs());
		all.addAll(getAllProjs());
		all.addAll(getAllAssociatedRequirementsDocs());
		all.addAll(getAllAssociatedDesignDocs());
		all.addAll(getAllDevelopmentEnvironments());
		return all;
	}

	public Vector<SSObject> getAllActiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllActiveEmps());
		all.addAll(getAllActiveCodeDocs());
		all.addAll(getAllActiveProjs());
		all.addAll(getAllActiveAssociatedRequirementsDocs());
		all.addAll(getAllActiveAssociatedDesignDocs());
		all.addAll(getAllActiveDevelopmentEnvironments());
		return all;
	}

	public Vector<SSObject> getAllInactiveParticipants() {
		Vector<SSObject> all = new Vector<SSObject>();
		all.addAll(getAllInactiveEmps());
		all.addAll(getAllInactiveCodeDocs());
		all.addAll(getAllInactiveProjs());
		all.addAll(getAllInactiveAssociatedRequirementsDocs());
		all.addAll(getAllInactiveAssociatedDesignDocs());
		all.addAll(getAllInactiveDevelopmentEnvironments());
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

	public Vector<Artifact> getAllAssociatedDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associateddesigndocs.keys();
		for (int i = 0; i < associateddesigndocs.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Artifact> getAllActiveAssociatedDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associateddesigndocs.keys();
		for (int i = 0; i < associateddesigndocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((associateddesigndocs.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Artifact> getAllInactiveAssociatedDesignDocs() {
		Vector<Artifact> a = new Vector<Artifact>();
		Enumeration<Artifact> e = associateddesigndocs.keys();
		for (int i = 0; i < associateddesigndocs.size(); i++) {
			Artifact key = e.nextElement();
			if ((associateddesigndocs.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addAssociatedDesignDoc(Artifact a) {
		if ((associateddesigndocs.containsKey(a))
				|| (((a instanceof DesignDocument) == false))
				|| (associateddesigndocs.size() >= 1)) {
			return false;
		} else {
			associateddesigndocs.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeAssociatedDesignDoc(Artifact a) {
		if (associateddesigndocs.containsKey(a)) {
			associateddesigndocs.remove(a);
			return true;
		}
		return false;
	}

	public boolean setAssociatedDesignDocActive(Artifact a) {
		if (associateddesigndocs.containsKey(a)) {
			associateddesigndocs.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setAssociatedDesignDocInactive(Artifact a) {
		if (associateddesigndocs.containsKey(a)) {
			associateddesigndocs.put(a, new Boolean(false));
			return true;
		}
		return false;
	}

	public Vector<Tool> getAllDevelopmentEnvironments() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = developmentenvironments.keys();
		for (int i = 0; i < developmentenvironments.size(); i++) {
			a.add(e.nextElement());
		}
		return a;
	}

	public Vector<Tool> getAllActiveDevelopmentEnvironments() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = developmentenvironments.keys();
		for (int i = 0; i < developmentenvironments.size(); i++) {
			Tool key = e.nextElement();
			if ((developmentenvironments.get(key)).booleanValue() == true) {
				a.add(key);
			}
		}
		return a;
	}

	public Vector<Tool> getAllInactiveDevelopmentEnvironments() {
		Vector<Tool> a = new Vector<Tool>();
		Enumeration<Tool> e = developmentenvironments.keys();
		for (int i = 0; i < developmentenvironments.size(); i++) {
			Tool key = e.nextElement();
			if ((developmentenvironments.get(key)).booleanValue() == false) {
				a.add(key);
			}
		}
		return a;
	}

	public boolean addDevelopmentEnvironment(Tool a) {
		if ((developmentenvironments.containsKey(a))
				|| (((a instanceof IDE) == false))) {
			return false;
		} else {
			developmentenvironments.put(a, new Boolean(true));
			return true;
		}
	}

	public boolean removeDevelopmentEnvironment(Tool a) {
		if (developmentenvironments.containsKey(a)) {
			developmentenvironments.remove(a);
			return true;
		}
		return false;
	}

	public boolean setDevelopmentEnvironmentActive(Tool a) {
		if (developmentenvironments.containsKey(a)) {
			developmentenvironments.put(a, new Boolean(true));
			return true;
		}
		return false;
	}

	public boolean setDevelopmentEnvironmentInactive(Tool a) {
		if (developmentenvironments.containsKey(a)) {
			developmentenvironments.put(a, new Boolean(false));
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

		// associateddesigndoc participants:
		Hashtable<Artifact, Boolean> newAssociatedDesignDocs = new Hashtable<Artifact, Boolean>();
		Iterator<Map.Entry<Artifact, Boolean>> associateddesigndocsIterator = associateddesigndocs
				.entrySet().iterator();
		while (associateddesigndocsIterator.hasNext()) {
			Map.Entry<Artifact, Boolean> entry = associateddesigndocsIterator
					.next();
			Artifact oldAssociatedDesignDoc = entry.getKey();
			if (oldAssociatedDesignDoc instanceof DesignDocument) {
				Artifact newAssociatedDesignDoc = artifactRep
						.getDesignDocumentStateRepository().get(
								((DesignDocument) oldAssociatedDesignDoc)
										.getName());
				Boolean activeStatus = associateddesigndocs
						.get(oldAssociatedDesignDoc);
				newAssociatedDesignDocs.put(newAssociatedDesignDoc,
						activeStatus);
			}
		}
		associateddesigndocs.clear();
		associateddesigndocs.putAll(newAssociatedDesignDocs);

		// developmentenvironment participants:
		Hashtable<Tool, Boolean> newDevelopmentEnvironments = new Hashtable<Tool, Boolean>();
		Iterator<Map.Entry<Tool, Boolean>> developmentenvironmentsIterator = developmentenvironments
				.entrySet().iterator();
		while (developmentenvironmentsIterator.hasNext()) {
			Map.Entry<Tool, Boolean> entry = developmentenvironmentsIterator
					.next();
			Tool oldDevelopmentEnvironment = entry.getKey();
			if (oldDevelopmentEnvironment instanceof IDE) {
				Tool newDevelopmentEnvironment = toolRep
						.getIDEStateRepository().get(
								((IDE) oldDevelopmentEnvironment).getName());
				Boolean activeStatus = developmentenvironments
						.get(oldDevelopmentEnvironment);
				newDevelopmentEnvironments.put(newDevelopmentEnvironment,
						activeStatus);
			}
		}
		developmentenvironments.clear();
		developmentenvironments.putAll(newDevelopmentEnvironments);

	}
}