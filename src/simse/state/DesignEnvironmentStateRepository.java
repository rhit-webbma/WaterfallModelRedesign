/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.DesignEnvironment;

public class DesignEnvironmentStateRepository implements Cloneable {
	private Vector<DesignEnvironment> designenvironments;

	public DesignEnvironmentStateRepository() {
		designenvironments = new Vector<DesignEnvironment>();
	}

	public Object clone() {
		try {
			DesignEnvironmentStateRepository cl = (DesignEnvironmentStateRepository) super
					.clone();
			Vector<DesignEnvironment> cloneddesignenvironments = new Vector<DesignEnvironment>();
			for (int i = 0; i < designenvironments.size(); i++) {
				cloneddesignenvironments
						.addElement((DesignEnvironment) (designenvironments
								.elementAt(i).clone()));
			}
			cl.designenvironments = cloneddesignenvironments;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public void add(DesignEnvironment a) {
		boolean add = true;
		for (int i = 0; i < designenvironments.size(); i++) {
			DesignEnvironment designenvironment = designenvironments
					.elementAt(i);
			if (designenvironment.getName().equals(a.getName())) {
				add = false;
				break;
			}
		}
		if (add) {
			designenvironments.add(a);
		}
	}

	public DesignEnvironment get(String name) {
		for (int i = 0; i < designenvironments.size(); i++) {
			if (designenvironments.elementAt(i).getName().equals(name)) {
				return designenvironments.elementAt(i);
			}
		}
		return null;
	}

	public Vector<DesignEnvironment> getAll() {
		return designenvironments;
	}

	public boolean remove(DesignEnvironment a) {
		return designenvironments.remove(a);
	}
}