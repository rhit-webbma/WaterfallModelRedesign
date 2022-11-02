/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import javax.swing.table.*;
import java.util.*;
import java.lang.*;
import java.text.*;

import simse.adts.objects.*;
import simse.state.*;

public class SEProjectTableModel extends TableModel<SEProject> {

	public SEProjectTableModel(State s) {
		super(s);
	}

	public Object getValueAt(int row, int col) {
		SEProject model = data.elementAt(col);
		Object returnVal = null;
		switch(row) {
		case 0: returnVal = model.getDescription();
		break;
		case 1: returnVal = model.getRequiredSizeOfCode();
		break;
		case 2: returnVal = model.getBudget();
		break;
		case 3: returnVal = model.getMoneySpent();
		break;
		case 4: returnVal = model.getAllottedTime();
		break;
		case 5: returnVal = model.getTimeUsed();
		break;
		case 6: returnVal = model.getCodeCompletenessScore();
		break;
		case 7: returnVal = model.getCodeCorrectnessScore();
		break;
		case 8: returnVal = model.getBudgetScore();
		break;
		case 9: returnVal = model.getScheduleScore();
		break;
		case 10: returnVal = model.getScore();
		break;
		case 11: returnVal = model.getSuggestedRequirementsDone();
		break;
		case 12: returnVal = model.getSuggestedDesignDone();
		break;
		case 13: returnVal = model.getSuggestedImplementationIntegrationDone();
		break;
		case 14: returnVal = model.getSuggestedTestDone();
		break;
		}
		return returnVal;
	}

	public void setValueAt(Object value, int row, int col) {
		SEProject model = data.elementAt(col);
		switch(row) {
		case 0: model.setDescription((String) value);
		break;
		case 1: model.setRequiredSizeOfCode((int) value);
		break;
		case 2: model.setBudget((double) value);
		break;
		case 3: model.setMoneySpent((double) value);
		break;
		case 4: model.setAllottedTime((int) value);
		break;
		case 5: model.setTimeUsed((int) value);
		break;
		case 6: model.setCodeCompletenessScore((double) value);
		break;
		case 7: model.setCodeCorrectnessScore((double) value);
		break;
		case 8: model.setBudgetScore((double) value);
		break;
		case 9: model.setScheduleScore((double) value);
		break;
		case 10: model.setScore((int) value);
		break;
		case 11: model.setSuggestedRequirementsDone((boolean) value);
		break;
		case 12: model.setSuggestedDesignDone((boolean) value);
		break;
		case 13: model.setSuggestedImplementationIntegrationDone((boolean) value);
		break;
		case 14: model.setSuggestedTestDone((boolean) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

	@Override
	void initColNames() {
		columnNames.add("Description");
		columnNames.add("Budget");
		columnNames.add("MoneySpent");
		columnNames.add("AllottedTime");
		columnNames.add("TimeUsed");
	}

	@Override
	Vector<SEProject> getRepository() {
		// TODO Auto-generated method stub
		return state.getProjectStateRepository()
				.getSEProjectStateRepository().getAll();
	}

//	public void update() {
//
//		if (!state.getClock().isStopped()) {
//			Vector<SEProject> seprojects = state.getProjectStateRepository()
//					.getSEProjectStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Description:
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				temp.add(seprojects.elementAt(i).getDescription());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize Budget:
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(seprojects.elementAt(i).getBudget()));
//
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize MoneySpent:
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(seprojects.elementAt(i)
//						.getMoneySpent()));
//
//			}
//			if (data.size() < 3) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 2);
//			}
//
//			// Initialize AllottedTime:
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(seprojects.elementAt(i)
//						.getAllottedTime()));
//			}
//			if (data.size() < 4) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 3);
//			}
//
//			// Initialize TimeUsed:
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat
//						.format(seprojects.elementAt(i).getTimeUsed()));
//			}
//			if (data.size() < 5) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 4);
//			}
//
//		} else // game over
//		{
//			data.clear();
//			columnNames.clear();
//			Vector<SEProject> seprojects = state.getProjectStateRepository()
//					.getSEProjectStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Description:
//			if (columnNames.contains("Description") == false) {
//				columnNames.add("Description");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				temp.add(seprojects.elementAt(i).getDescription());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize Budget:
//			if (columnNames.contains("Budget") == false) {
//				columnNames.add("Budget");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(seprojects.elementAt(i).getBudget()));
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize MoneySpent:
//			if (columnNames.contains("MoneySpent") == false) {
//				columnNames.add("MoneySpent");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(seprojects.elementAt(i)
//						.getMoneySpent()));
//			}
//			if (data.size() < 3) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 2);
//			}
//
//			// Initialize AllottedTime:
//			if (columnNames.contains("AllottedTime") == false) {
//				columnNames.add("AllottedTime");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(seprojects.elementAt(i)
//						.getAllottedTime()));
//			}
//			if (data.size() < 4) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 3);
//			}
//
//			// Initialize TimeUsed:
//			if (columnNames.contains("TimeUsed") == false) {
//				columnNames.add("TimeUsed");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat
//						.format(seprojects.elementAt(i).getTimeUsed()));
//			}
//			if (data.size() < 5) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 4);
//			}
//
//			// Initialize Score:
//			if (columnNames.contains("Score") == false) {
//				columnNames.add("Score");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < seprojects.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				temp.add(numFormat.format(seprojects.elementAt(i).getScore()));
//			}
//			if (data.size() < 6) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 5);
//			}
//
//			fireTableStructureChanged();
//		}
//
//		fireTableDataChanged(); // notify listeners that table data has changed
//	}
}
