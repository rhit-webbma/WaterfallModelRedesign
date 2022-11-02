/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import javax.swing.table.*;
import java.util.*;
import java.lang.*;
import java.text.*;

import simse.adts.objects.*;
import simse.state.*;

public class SystemTestPlanTableModel extends AbstractTableModel {
	private Vector<String> columnNames; // column names
	private Vector<Vector<Object>> data; // data in table
	private State state;

	private NumberFormat numFormat;

	public SystemTestPlanTableModel(State s) {
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
		columnNames.add("NumKnownErrors");
		columnNames.add("PercentComplete");
	}

	public void update() {

		if (!state.getClock().isStopped()) {
			Vector<SystemTestPlan> systemtestplans = state
					.getArtifactStateRepository()
					.getSystemTestPlanStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				temp.add(systemtestplans.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize NumKnownErrors:
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getNumKnownErrors()));

			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize PercentComplete:
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getPercentComplete()));

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
			Vector<SystemTestPlan> systemtestplans = state
					.getArtifactStateRepository()
					.getSystemTestPlanStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			if (columnNames.contains("Name") == false) {
				columnNames.add("Name");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				temp.add(systemtestplans.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize NumKnownErrors:
			if (columnNames.contains("NumKnownErrors") == false) {
				columnNames.add("NumKnownErrors");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getNumKnownErrors()));
			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize NumUnknownErrors:
			if (columnNames.contains("NumUnknownErrors") == false) {
				columnNames.add("NumUnknownErrors");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getNumUnknownErrors()));
			}
			if (data.size() < 3) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 2);
			}

			// Initialize PercentErroneous:
			if (columnNames.contains("PercentErroneous") == false) {
				columnNames.add("PercentErroneous");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getPercentErroneous()));
			}
			if (data.size() < 4) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 3);
			}

			// Initialize PercentComplete:
			if (columnNames.contains("PercentComplete") == false) {
				columnNames.add("PercentComplete");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < systemtestplans.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(systemtestplans.elementAt(i)
						.getPercentComplete()));
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