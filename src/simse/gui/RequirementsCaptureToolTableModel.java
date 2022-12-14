/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import java.util.Vector;

import simse.adts.objects.RequirementsCaptureTool;
import simse.state.State;

public class RequirementsCaptureToolTableModel extends TableModel<RequirementsCaptureTool> {
	
	public RequirementsCaptureToolTableModel(State s) {
		super(s);
	}

	public Object getValueAt(int row, int col) {
		RequirementsCaptureTool model = data.elementAt(col);
		Object returnVal = null;
		switch(row) {
		case 0: returnVal = model.getName();
		break;
		case 1: returnVal = model.getCost();
		break;
		case 2: returnVal = model.getProductivityIncreaseFactor();
		break;
		case 3: returnVal = model.getErrorRateDecreaseFactor();
		break;
		case 4: returnVal = model.getPurchased();
		break;
		}
		return returnVal;
	}

	public void setValueAt(Object value, int row, int col) {
		RequirementsCaptureTool model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		case 1: model.setCost((double) value);
		break;
		case 2: model.setProductivityIncreaseFactor((double) value);
		break;
		case 3: model.setErrorRateDecreaseFactor((double) value);
		break;
		case 4: model.setPurchased((boolean) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("Cost");
		columnNames.add("Purchased");
	}

	@Override
	Vector<RequirementsCaptureTool> getRepository() {
		// TODO Auto-generated method stub
		return state
				.getToolStateRepository()
				.getRequirementsCaptureToolStateRepository().getAll();
	}

//	public void update() {
//
//		if (!state.getClock().isStopped()) {
//			Vector<RequirementsCaptureTool> requirementscapturetools = state
//					.getToolStateRepository()
//					.getRequirementsCaptureToolStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Name:
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				temp.add(requirementscapturetools.elementAt(i).getName());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize Cost:
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(requirementscapturetools.elementAt(i)
//						.getCost()));
//
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize Purchased:
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				temp.add(new Boolean(requirementscapturetools.elementAt(i)
//						.getPurchased()));
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
//			Vector<RequirementsCaptureTool> requirementscapturetools = state
//					.getToolStateRepository()
//					.getRequirementsCaptureToolStateRepository().getAll();
//			Vector<Object> temp = new Vector<Object>();
//			// Initialize Name:
//			if (columnNames.contains("Name") == false) {
//				columnNames.add("Name");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				temp.add(requirementscapturetools.elementAt(i).getName());
//			}
//			if (data.size() < 1) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 0);
//			}
//
//			// Initialize Cost:
//			if (columnNames.contains("Cost") == false) {
//				columnNames.add("Cost");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(requirementscapturetools.elementAt(i)
//						.getCost()));
//			}
//			if (data.size() < 2) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 1);
//			}
//
//			// Initialize ProductivityIncreaseFactor:
//			if (columnNames.contains("ProductivityIncreaseFactor") == false) {
//				columnNames.add("ProductivityIncreaseFactor");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(requirementscapturetools.elementAt(i)
//						.getProductivityIncreaseFactor()));
//			}
//			if (data.size() < 3) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 2);
//			}
//
//			// Initialize ErrorRateDecreaseFactor:
//			if (columnNames.contains("ErrorRateDecreaseFactor") == false) {
//				columnNames.add("ErrorRateDecreaseFactor");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				numFormat.setMinimumFractionDigits(2);
//				numFormat.setMaximumFractionDigits(2);
//				temp.add(numFormat.format(requirementscapturetools.elementAt(i)
//						.getErrorRateDecreaseFactor()));
//			}
//			if (data.size() < 4) {
//				data.add(temp);
//			} else {
//				data.setElementAt(temp, 3);
//			}
//
//			// Initialize Purchased:
//			if (columnNames.contains("Purchased") == false) {
//				columnNames.add("Purchased");
//			}
//			temp = new Vector<Object>();
//			for (int i = 0; i < requirementscapturetools.size(); i++) {
//				temp.add(new Boolean(requirementscapturetools.elementAt(i)
//						.getPurchased()));
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
