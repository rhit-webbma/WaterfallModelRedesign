/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.AutomatedTestingTool;

public class AutomatedTestingToolStateRepository implements Cloneable {
	private Vector<AutomatedTestingTool> automatedtestingtools;

	public AutomatedTestingToolStateRepository() {
		automatedtestingtools = new Vector<AutomatedTestingTool>();
	}

	public Object clone() {
		try {
			AutomatedTestingToolStateRepository cl = (AutomatedTestingToolStateRepository) super
					.clone();
			Vector<AutomatedTestingTool> clonedautomatedtestingtools = new Vector<AutomatedTestingTool>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				clonedautomatedtestingtools
						.addElement((AutomatedTestingTool) (automatedtestingtools
								.elementAt(i).clone()));
			}
			cl.automatedtestingtools = clonedautomatedtestingtools;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public void add(AutomatedTestingTool a) {
		boolean add = true;
		for (int i = 0; i < automatedtestingtools.size(); i++) {
			AutomatedTestingTool automatedtestingtool = automatedtestingtools
					.elementAt(i);
			if (automatedtestingtool.getName().equals(a.getName())) {
				add = false;
				break;
			}
		}
		if (add) {
			automatedtestingtools.add(a);
		}
	}

	public AutomatedTestingTool get(String name) {
		for (int i = 0; i < automatedtestingtools.size(); i++) {
			if (automatedtestingtools.elementAt(i).getName().equals(name)) {
				return automatedtestingtools.elementAt(i);
			}
		}
		return null;
	}

	public Vector<AutomatedTestingTool> getAll() {
		return automatedtestingtools;
	}

	public boolean remove(AutomatedTestingTool a) {
		return automatedtestingtools.remove(a);
	}
}