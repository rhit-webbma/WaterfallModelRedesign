package simse.gui;

import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.Project;
import simse.state.State;

public class ProjectTableModel extends TableModel<Project>{

	public ProjectTableModel(State s) {
		super(s);
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
	Vector<Project> getRepository() {
		return state.getProjectStateRepository().getAll();
	}

	@Override
	Object getValueAt(int row, int col) {
		Project model = data.elementAt(col);
		Object returnValue = null;
		switch(row) {
		case 0: returnValue = model.getDescription();
		break;
		case 1: returnValue = model.getBudget();
		break;
		case 2: returnValue = model.getMoneySpent();
		break;
		case 3: returnValue = model.getAllottedTime();
		break;
		case 4: returnValue = model.getTimeUsed();
		break;
		}
		return returnValue;
	}

	@Override
	void setValueAt(Object value, int row, int col) {
		Project model = data.elementAt(col);
		switch(row) {
		case 0: model.setDescription((String) value);
		break;
		case 1: model.setBudget((double) value);
		break;
		case 2: model.setMoneySpent((double) value);
		break;
		case 3: model.setAllottedTime((int) value);
		break;
		case 4: model.setTimeUsed((int) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

}