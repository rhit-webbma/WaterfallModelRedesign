/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.SEProject;

public class SEProjectStateRepository implements Cloneable {
	private Vector<SEProject> seprojects;

	public SEProjectStateRepository() {
		seprojects = new Vector<SEProject>();
	}

	public Object clone() {
		try {
			SEProjectStateRepository cl = (SEProjectStateRepository) super
					.clone();
			Vector<SEProject> clonedseprojects = new Vector<SEProject>();
			for (int i = 0; i < seprojects.size(); i++) {
				clonedseprojects.addElement((SEProject) (seprojects
						.elementAt(i).clone()));
			}
			cl.seprojects = clonedseprojects;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public void add(SEProject a) {
		boolean add = true;
		for (int i = 0; i < seprojects.size(); i++) {
			SEProject seproject = seprojects.elementAt(i);
			if (seproject.getDescription().equals(a.getDescription())) {
				add = false;
				break;
			}
		}
		if (add) {
			seprojects.add(a);
		}
	}

	public SEProject get(String description) {
		for (int i = 0; i < seprojects.size(); i++) {
			if (seprojects.elementAt(i).getDescription().equals(description)) {
				return seprojects.elementAt(i);
			}
		}
		return null;
	}

	public Vector<SEProject> getAll() {
		return seprojects;
	}

	public boolean remove(SEProject a) {
		return seprojects.remove(a);
	}
}