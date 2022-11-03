/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import javax.swing.table.*;
import java.util.*;
import java.lang.*;
import java.text.*;

import simse.adts.objects.*;
import simse.state.*;

public class CodeTableModel extends AbstractTableModel {
	private Vector<String> columnNames; // column names
	private Vector<Vector<Object>> data; // data in table
	private State state;

	private NumberFormat numFormat;

	public CodeTableModel(State s) {
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
		columnNames.add("PercentComplete");
		columnNames.add("PercentIntegrated");
		columnNames.add("NumKnownErrors");
	}

	public void update() {

		if (!state.getClock().isStopped()) {
			Vector<Code> codes = state.getArtifactStateRepository()
					.getCodeStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				temp.add(codes.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize PercentComplete:
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getPercentComplete()));

			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize PercentIntegrated:
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getPercentIntegrated()));

			}
			if (data.size() < 3) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 2);
			}

			// Initialize NumKnownErrors:
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getNumKnownErrors()));

			}
			if (data.size() < 4) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 3);
			}

		} else // game over
		{
			data.clear();
			columnNames.clear();
			Vector<Code> codes = state.getArtifactStateRepository()
					.getCodeStateRepository().getAll();
			Vector<Object> temp = new Vector<Object>();
			// Initialize Name:
			if (columnNames.contains("Name") == false) {
				columnNames.add("Name");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				temp.add(codes.elementAt(i).getName());
			}
			if (data.size() < 1) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 0);
			}

			// Initialize PercentComplete:
			if (columnNames.contains("PercentComplete") == false) {
				columnNames.add("PercentComplete");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getPercentComplete()));
			}
			if (data.size() < 2) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 1);
			}

			// Initialize PercentIntegrated:
			if (columnNames.contains("PercentIntegrated") == false) {
				columnNames.add("PercentIntegrated");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getPercentIntegrated()));
			}
			if (data.size() < 3) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 2);
			}

			// Initialize NumKnownErrors:
			if (columnNames.contains("NumKnownErrors") == false) {
				columnNames.add("NumKnownErrors");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getNumKnownErrors()));
			}
			if (data.size() < 4) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 3);
			}

			// Initialize NumUnknownErrors:
			if (columnNames.contains("NumUnknownErrors") == false) {
				columnNames.add("NumUnknownErrors");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getNumUnknownErrors()));
			}
			if (data.size() < 5) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 4);
			}

			// Initialize PercentErroneous:
			if (columnNames.contains("PercentErroneous") == false) {
				columnNames.add("PercentErroneous");
			}
			temp = new Vector<Object>();
			for (int i = 0; i < codes.size(); i++) {
				numFormat.setMinimumFractionDigits(0);
				numFormat.setMaximumFractionDigits(0);
				temp.add(numFormat.format(codes.elementAt(i)
						.getPercentErroneous()));
			}
			if (data.size() < 6) {
				data.add(temp);
			} else {
				data.setElementAt(temp, 5);
			}

			fireTableStructureChanged();
		}

		fireTableDataChanged(); // notify listeners that table data has changed
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}