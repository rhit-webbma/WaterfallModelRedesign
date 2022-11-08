package simse.gui;

import java.util.Vector;

import simse.adts.objects.Tool;
import simse.state.State;

public class ToolTableModel extends TableModel<Tool>{

	public ToolTableModel(State s) {
		super(s);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("Description");
		columnNames.add("Cost");
		columnNames.add("Purchased");
	}

	@Override
	Vector<Tool> getRepository() {
		// TODO Auto-generated method stub
				return state.getToolStateRepository().getAll();
	}

	@Override
	Object getValueAt(int row, int col) {
		Tool model = data.elementAt(col);
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

	@Override
	void setValueAt(Object value, int row, int col) {
		Tool model = data.elementAt(col);
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

}
