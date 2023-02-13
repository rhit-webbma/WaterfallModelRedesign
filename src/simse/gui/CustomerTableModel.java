package simse.gui;

import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.adts.objects.Customer;
import simse.adts.objects.Employee;
import simse.state.State;

public class CustomerTableModel extends TableModel<Customer>{

	public CustomerTableModel(State s) {
		super(s);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
	}

	@Override
	Vector<Customer> getRepository() {
		return state.getCustomerStateRepository().getAll();
	}

	@Override
	Object getValueAt(int row, int col) {
		Customer model = data.elementAt(col);
		Object returnValue = null;
		switch(row) {
		case 0: returnValue = model.getName();
		break;
		}
		return returnValue;
	}

	@Override
	void setValueAt(Object value, int row, int col) {
		Customer model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

}
