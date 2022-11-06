/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.DesignDocument;

public class DesignDocumentStateRepository implements Cloneable {
	private Vector<DesignDocument> designdocuments;

	public DesignDocumentStateRepository() {
		designdocuments = new Vector<DesignDocument>();
	}

	public Object clone() {
		try {
			DesignDocumentStateRepository cl = (DesignDocumentStateRepository) super
					.clone();
			Vector<DesignDocument> cloneddesigndocuments = new Vector<DesignDocument>();
			for (int i = 0; i < designdocuments.size(); i++) {
				cloneddesigndocuments
						.addElement((DesignDocument) (designdocuments
								.elementAt(i).clone()));
			}
			cl.designdocuments = cloneddesigndocuments;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public void add(DesignDocument a) {
		boolean add = true;
		for (int i = 0; i < designdocuments.size(); i++) {
			DesignDocument designdocument = designdocuments.elementAt(i);
			if (designdocument.getName().equals(a.getName())) {
				add = false;
				break;
			}
		}
		if (add) {
			designdocuments.add(a);
		}
	}

	public DesignDocument get(String name) {
		for (int i = 0; i < designdocuments.size(); i++) {
			if (designdocuments.elementAt(i).getName().equals(name)) {
				return designdocuments.elementAt(i);
			}
		}
		return null;
	}

	public Vector<DesignDocument> getAll() {
		return designdocuments;
	}

	public boolean remove(DesignDocument a) {
		return designdocuments.remove(a);
	}
}