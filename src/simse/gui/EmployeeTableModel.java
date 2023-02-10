package simse.gui;

import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.Employee;
import simse.state.State;

public class EmployeeTableModel extends TableModel<Employee>{

	public EmployeeTableModel(State s) {
		super(s);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("PercentComplete");
		columnNames.add("NumKnownErrors");
	}

	@Override
	Vector<Employee> getRepository() {
		return state.getEmployeeStateRepository().getAll();
	}

	@Override
	Object getValueAt(int row, int col) {
		Employee model = data.elementAt(col);
		Object returnValue = null;
		switch(row) {
		case 0: returnValue = model.getName();
		break;
		case 1: returnValue = model.getEnergy();
		break;
		case 2: returnValue = model.getMood();
		break;
		case 3: returnValue = model.getRequirementsExperience();
		break;
		case 4: returnValue = model.getDesignExperience();
		break;
		case 5: returnValue = model.getCodingExperience();
		break;
		case 6: returnValue = model.getTestingExperience();
		break;
		case 7: returnValue = model.getPayRate();
		break;
		}
		return returnValue;
	}

	@Override
	void setValueAt(Object value, int row, int col) {
		Employee model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		case 1: model.setEnergy((double) value);
		break;
		case 2: model.setMood((double) value);
		break;
		case 3: model.setRequirementsExperience((String) value);
		break;
		case 4: model.setDesignExperience((String) value);
		break;
		case 5: model.setCodingExperience((String) value);
		break;
		case 6: model.setTestingExperience((String) value);
		break;
		case 7: model.setPayRate((double) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

}
