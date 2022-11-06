/* File generated by: simse.codegenerator.stategenerator.RepositoryGenerator */
package simse.state;

import java.util.Vector;

import simse.adts.objects.SystemTestPlan;

public class SystemTestPlanStateRepository implements Cloneable {
	private Vector<SystemTestPlan> systemtestplans;

	public SystemTestPlanStateRepository() {
		systemtestplans = new Vector<SystemTestPlan>();
	}

	public Object clone() {
		try {
			SystemTestPlanStateRepository cl = (SystemTestPlanStateRepository) super
					.clone();
			Vector<SystemTestPlan> clonedsystemtestplans = new Vector<SystemTestPlan>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				clonedsystemtestplans
						.addElement((SystemTestPlan) (systemtestplans
								.elementAt(i).clone()));
			}
			cl.systemtestplans = clonedsystemtestplans;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public void add(SystemTestPlan a) {
		boolean add = true;
		for (int i = 0; i < systemtestplans.size(); i++) {
			SystemTestPlan systemtestplan = systemtestplans.elementAt(i);
			if (systemtestplan.getName().equals(a.getName())) {
				add = false;
				break;
			}
		}
		if (add) {
			systemtestplans.add(a);
		}
	}

	public SystemTestPlan get(String name) {
		for (int i = 0; i < systemtestplans.size(); i++) {
			if (systemtestplans.elementAt(i).getName().equals(name)) {
				return systemtestplans.elementAt(i);
			}
		}
		return null;
	}

	public Vector<SystemTestPlan> getAll() {
		return systemtestplans;
	}

	public boolean remove(SystemTestPlan a) {
		return systemtestplans.remove(a);
	}
}