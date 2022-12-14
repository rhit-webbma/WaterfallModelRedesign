/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.Artifact;

public class ArtifactStateRepository implements Cloneable {
	RequirementsDocumentStateRepository r0;
	DesignDocumentStateRepository d1;
	CodeStateRepository c2;
	SystemTestPlanStateRepository s3;

	public ArtifactStateRepository() {
		r0 = new RequirementsDocumentStateRepository();
		d1 = new DesignDocumentStateRepository();
		c2 = new CodeStateRepository();
		s3 = new SystemTestPlanStateRepository();
	}

	public Object clone() {
		try {
			ArtifactStateRepository cl = (ArtifactStateRepository) (super
					.clone());
			cl.r0 = (RequirementsDocumentStateRepository) (r0.clone());
			cl.d1 = (DesignDocumentStateRepository) (d1.clone());
			cl.c2 = (CodeStateRepository) (c2.clone());
			cl.s3 = (SystemTestPlanStateRepository) (s3.clone());
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public Vector<Artifact> getAll() {
		Vector<Artifact> all = new Vector<Artifact>();
		all.addAll(r0.getAll());
		all.addAll(d1.getAll());
		all.addAll(c2.getAll());
		all.addAll(s3.getAll());
		return all;
	}

	public RequirementsDocumentStateRepository getRequirementsDocumentStateRepository() {
		return r0;
	}

	public DesignDocumentStateRepository getDesignDocumentStateRepository() {
		return d1;
	}

	public CodeStateRepository getCodeStateRepository() {
		return c2;
	}

	public SystemTestPlanStateRepository getSystemTestPlanStateRepository() {
		return s3;
	}
}