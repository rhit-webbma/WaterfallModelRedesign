/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import javax.swing.table.*;
import java.util.*;
import java.lang.*;
import java.text.*;

import simse.adts.objects.*;
import simse.state.*;

public class AutomatedTestingToolTableModel extends AbstractTableModel {
	private Vector<String> columnNames; // column names
	private Vector<Vector<Object>> data; // data in table
	private State state;

	private NumberFormat numFormat;

	public AutomatedTestingToolTableModel(State s) {
		state = s;
		columnNames = new Vector<String>();
		data = new Vector<Vector<Object>>();
		numFormat = NumberFormat.getNumberInstance(Locale.US);
		initColNames();
		update();
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		if (data.size() > 0) {
			return data.elementAt(0).size();
		}
		return 0;
	}

	public String getColumnName(int col) {
		return columnNames.elementAt(col);
	}

	public int getColumnIndex(String columnName) {
		for (int i = 0; i < columnNames.size(); i++) {
			String colName = columnNames.elementAt(i);
			if (colName.equals(columnName)) {
				return i;
			}
		}
		return -1;
	}

	public Object getValueAt(int row, int col) {
		return data.elementAt(col).elementAt(row);
	}

	public void setValueAt(Object value, int row, int col) {
		data.elementAt(col).add(value);
		fireTableCellUpdated(row, col);
	}

	private void initColNames() {
		columnNames.add("Name");
		columnNames.add("Cost");
		columnNames.add("Purchased");
	}

	public void update() {

		if (!state.getClock().isStopped()) {
			Vector<AutomatedTestingTool> automatedtestingtools = state
					.getToolStateRepository()
					.getAutomatedTestingToolStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				temp.add(automatedtestingtools.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize Cost:
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				numFormat.setMinimumFractionDigits(2);
				numFormat.setMaximumFractionDigits(2);
				temp.add(numFormat.format(automatedtestingtools.elementAt(i)
						.getCost()));

			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize Purchased:
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				temp.add(new Boolean(automatedtestingtools.elementAt(i)
						.getPurchased()));
			}
			if (data.size() < 3) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 2);
			}

		} else // game over
		{
			data.clear();
			columnNames.clear();
			Vector<AutomatedTestingTool> automatedtestingtools = state
					.getToolStateRepository()
					.getAutomatedTestingToolStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			if (columnNames.contains("Name") == false) {
				columnNames.add("Name");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				temp.add(automatedtestingtools.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize Cost:
			if (columnNames.contains("Cost") == false) {
				columnNames.add("Cost");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				numFormat.setMinimumFractionDigits(2);
				numFormat.setMaximumFractionDigits(2);
				temp.add(numFormat.format(automatedtestingtools.elementAt(i)
						.getCost()));
			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize ProductivityIncreaseFactor:
			if (columnNames.contains("ProductivityIncreaseFactor") == false) {
				columnNames.add("ProductivityIncreaseFactor");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				numFormat.setMinimumFractionDigits(2);
				numFormat.setMaximumFractionDigits(2);
				temp.add(numFormat.format(automatedtestingtools.elementAt(i)
						.getProductivityIncreaseFactor()));
			}
			if (data.size() < 3) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 2);
			}

			// Initialize ErrorRateDecreaseFactor:
			if (columnNames.contains("ErrorRateDecreaseFactor") == false) {
				columnNames.add("ErrorRateDecreaseFactor");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				numFormat.setMinimumFractionDigits(2);
				numFormat.setMaximumFractionDigits(2);
				temp.add(numFormat.format(automatedtestingtools.elementAt(i)
						.getErrorRateDecreaseFactor()));
			}
			if (data.size() < 4) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 3);
			}

			// Initialize Purchased:
			if (columnNames.contains("Purchased") == false) {
				columnNames.add("Purchased");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < automatedtestingtools.size(); i++) {
				temp.add(new Boolean(automatedtestingtools.elementAt(i)
						.getPurchased()));
			}
			if (data.size() < 5) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 4);
			}

			fireTableStructureChanged();
		}

		fireTableDataChanged(); // notify listeners that table data has changed
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}