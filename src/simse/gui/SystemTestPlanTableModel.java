/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import java.util.Vector;

import simse.adts.objects.SystemTestPlan;
import simse.state.State;

public class SystemTestPlanTableModel extends TableModel<SystemTestPlan> {

	public SystemTestPlanTableModel(State s) {
		super(s);
	}

	public Object getValueAt(int row, int col) {
		SystemTestPlan model = data.elementAt(col);
		Object returnVal = null;
		switch(row) {
		case 0: returnVal = model.getName();
		break;
		case 1: returnVal = model.getSize();
		break;
		case 2: returnVal = model.getNumKnownErrors();
		break;
		case 3: returnVal = model.getNumUnknownErrors();
		break;
		case 4: returnVal = model.getPercentErroneous();
		break;
		case 5: returnVal = model.getPercentComplete();
		break;
		case 6: returnVal = model.getNumUnknownTemp();
		break;
		case 7: returnVal = model.getCompletnessDiffReqDoc();
		break;
		}
		return returnVal;
	}

	public void setValueAt(Object value, int row, int col) {
		SystemTestPlan model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		case 1: model.setSize((double) value);
		break;
		case 2: model.setNumKnownErrors((double) value);
		break;
		case 3: model.setNumUnknownErrors((double) value);
		break;
		case 4: model.setPercentErroneous((double) value);
		break;
		case 5: model.setPercentComplete((double) value);
		break;
		case 6: model.setNumUnknownTemp((double) value);
		break;
		case 7: model.setCompletnessDiffReqDoc((int) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("NumKnownErrors");
		columnNames.add("PercentComplete");
	}

	@Override
	Vector<SystemTestPlan> getRepository() {
		// TODO Auto-generated method stub
		return state
				.getArtifactStateRepository()
				.getSystemTestPlanStateRepository().getAll();
	}

//	public void update() {
//
//		if (!state.getClock().isStopped()) {
//			Vector<SystemTestPlan> systemtestplans = state
//					.getArtifactStateRepository()
//					.getSystemTestPlanStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Name:
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				temp.add(systemtestplans.elementAt(i).getName());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize NumKnownErrors:
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getNumKnownErrors()));
//
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize PercentComplete:
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getPercentComplete()));
//
//			}
//			if (data.size() < 3) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 2);
//			}
//
//		} else // game over
//		{
//			data.clear();
//			columnNames.clear();
//			Vector<SystemTestPlan> systemtestplans = state
//					.getArtifactStateRepository()
//					.getSystemTestPlanStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Name:
//			if (columnNames.contains("Name") == false) {
//				columnNames.add("Name");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				temp.add(systemtestplans.elementAt(i).getName());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize NumKnownErrors:
//			if (columnNames.contains("NumKnownErrors") == false) {
//				columnNames.add("NumKnownErrors");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getNumKnownErrors()));
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize NumUnknownErrors:
//			if (columnNames.contains("NumUnknownErrors") == false) {
//				columnNames.add("NumUnknownErrors");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getNumUnknownErrors()));
//			}
//			if (data.size() < 3) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 2);
//			}
//
//			// Initialize PercentErroneous:
//			if (columnNames.contains("PercentErroneous") == false) {
//				columnNames.add("PercentErroneous");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getPercentErroneous()));
//			}
//			if (data.size() < 4) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 3);
//			}
//
//			// Initialize PercentComplete:
//			if (columnNames.contains("PercentComplete") == false) {
//				columnNames.add("PercentComplete");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < systemtestplans.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(systemtestplans.elementAt(i)
//						.getPercentComplete()));
//			}
//			if (data.size() < 5) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 4);
//			}
//
//			fireTableStructureChanged();
//		}
//
//		fireTableDataChanged(); // notify listeners that table data has changed
//	}

}
