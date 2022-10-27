/* File generated by: simse.codegenerator.guigenerator.AtAGlanceTableModelGenerator */
package simse.gui;

import javax.swing.table.*;
import java.util.*;
import java.lang.*;
import java.text.*;

import simse.adts.objects.*;
import simse.state.*;

public class CodeTableModel extends TableModel<Code>{

	public CodeTableModel(State s) {
		super(s);
	}

	@Override
	public Object getValueAt(int row, int col) {
		Code model = data.elementAt(col);
		Object returnValue = null;
		switch(row) {
		case 0: returnValue = model.getName();
		break;
		case 1: returnValue = model.getSize();
		break;
		case 2: returnValue = model.getPercentComplete();
		break;
		case 3: returnValue = model.getAmountIntegrated();
		break;
		case 4: returnValue = model.getPercentIntegrated();
		break;
		case 5: returnValue = model.getNumAuthors();
		break;
		case 6: returnValue = model.getNumKnownErrors();
		break;
		case 7: returnValue = model.getNumUnknownErrors();
		break;
		case 8: returnValue = model.getPercentErroneous();
		break;
		case 9: returnValue = model.getNumUnknownTemp();
		break;
		case 10: returnValue = model.getCompletenessDiffReqDoc();
		break;
		case 11: returnValue = model.getCompletenessDiffDesDoc();
		break;
		case 12: returnValue = model.getCompletenessDiffTestPlan();
		break;
		case 13: returnValue = model.getPcntIntegratedDiffDesDoc();
		break;
		}
		return returnValue;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		Code model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		case 1: model.setSize((double) value);
		break;
		case 2: model.setPercentComplete((double) value);
		break;
		case 3: model.setAmountIntegrated((double) value);
		break;
		case 4: model.setPercentIntegrated((double) value);
		break;
		case 5: model.setNumAuthors((int) value);
		break;
		case 6: model.setNumKnownErrors((double) value);
		break;
		case 7: model.setNumUnknownErrors((double) value);
		break;
		case 8: model.setPercentErroneous((double) value);
		break;
		case 9: model.setNumUnknownTemp((double) value);
		break;
		case 10: model.setCompletenessDiffReqDoc((int) value);
		break;
		case 11: model.setCompletenessDiffDesDoc((int) value);
		break;
		case 12: model.setCompletenessDiffTestPlan((int) value);
		break;
		case 13: model.setPcntIntegratedDiffDesDoc((int) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("PercentComplete");
		columnNames.add("PercentIntegrated");
		columnNames.add("NumKnownErrors");
	}

//	@Override
//	public void update() {
//
//		if (!state.getClock().isStopped()) {
//			Vector<Code> codes = state.getArtifactStateRepository()
//					.getCodeStateRepository().getAll();
//			// Initialize Name:
//			Vector<String> names = new Vector<String>();
//			for (int i = 0; i < codes.size(); i++) {
//				names.add(codes.elementAt(i).getName());
//			}
////			if (data.size() < 1) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 0);
////			}
//
//			// Initialize PercentComplete:
//			Vector<Double> percentagesComplete = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				percentagesComplete.add(codes.elementAt(i)
//						.getPercentComplete());
//
//			}
////			if (data.size() < 2) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 1);
////			}
//
//			// Initialize PercentIntegrated:
//			Vector<Double> percentagesIntegrated = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				percentagesIntegrated.add(codes.elementAt(i)
//						.getPercentIntegrated());
//
//			}
////			if (data.size() < 3) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 2);
////			}
//
//			// Initialize NumKnownErrors:
//			Vector<Double> knownErrors = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				knownErrors.add(codes.elementAt(i)
//						.getNumKnownErrors());
//
//			}
////			if (data.size() < 4) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 3);
////			}
//			
//			for(int i = 0; i < codes.size(); i++) {
//				Code newModel = new Code(
//						names.get(i),
//						0.0,
//						percentagesComplete.get(i),
//						0.0,
//						percentagesIntegrated.get(i),
//						0,
//						knownErrors.get(i),
//						0.0,
//						0.0,
//						0.0,
//						0,0,0,0);
//				data.add(newModel);
//			}
//
//		} else // game over
//		{
//			data.clear();
//			columnNames.clear();
//			Vector<Code> codes = state.getArtifactStateRepository()
//					.getCodeStateRepository().getAll();
//			Vector<String> names = new Vector<String>();
//			// Initialize Name:
//			if (columnNames.contains("Name") == false) {
//				columnNames.add("Name");
//			}
//			for (int i = 0; i < codes.size(); i++) {
//				names.add(codes.elementAt(i).getName());
//			}
////			if (data.size() < 1) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 0);
////			}
//
//			// Initialize PercentComplete:
//			if (columnNames.contains("PercentComplete") == false) {
//				columnNames.add("PercentComplete");
//			}
//			Vector<Double> percentagesComplete = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				percentagesComplete.add(codes.elementAt(i)
//						.getPercentComplete());
//			}
////			if (data.size() < 2) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 1);
////			}
//
//			// Initialize PercentIntegrated:
//			if (columnNames.contains("PercentIntegrated") == false) {
//				columnNames.add("PercentIntegrated");
//			}
//			Vector<Double> percentagesIntegrated = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				percentagesIntegrated.add(codes.elementAt(i)
//						.getPercentIntegrated());
//			}
////			if (data.size() < 3) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 2);
////			}
//
//			// Initialize NumKnownErrors:
//			if (columnNames.contains("NumKnownErrors") == false) {
//				columnNames.add("NumKnownErrors");
//			}
//			Vector<Double> knownErrors = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				knownErrors.add(codes.elementAt(i)
//						.getNumKnownErrors());
//			}
////			if (data.size() < 4) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 3);
////			}
//
//			// Initialize NumUnknownErrors:
//			if (columnNames.contains("NumUnknownErrors") == false) {
//				columnNames.add("NumUnknownErrors");
//			}
//			Vector<Double> unknownErrors = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				unknownErrors.add(codes.elementAt(i)
//						.getNumUnknownErrors());
//			}
////			if (data.size() < 5) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 4);
////			}
//
//			// Initialize PercentErroneous:
//			if (columnNames.contains("PercentErroneous") == false) {
//				columnNames.add("PercentErroneous");
//			}
//			Vector<Double> percentsErroneous = new Vector<Double>();
//			for (int i = 0; i < codes.size(); i++) {
//				numFormat.setMinimumFractionDigits(0);
//				numFormat.setMaximumFractionDigits(0);
//				percentsErroneous.add(codes.elementAt(i)
//						.getPercentErroneous());
//			}
////			if (data.size() < 6) {
////				data.add(temp);
////			} else {
////				data.setElementAt(temp, 5);
////			}
//			
//			for(int i = 0; i < codes.size(); i++) {
//				Code newModel = new Code(
//						names.get(i),
//						0.0,
//						percentagesComplete.get(i),
//						0.0,
//						percentagesIntegrated.get(i),
//						0,
//						knownErrors.get(i),
//						unknownErrors.get(i),
//						percentsErroneous.get(i),
//						0.0,
//						0,0,0,0);
//				data.add(newModel);
//			}
//
//			fireTableStructureChanged();
//		}
//
//		fireTableDataChanged(); // notify listeners that table data has changed
//	}

	@Override
	Vector<Code> getRepository() {
		// TODO Auto-generated method stub
		return state.getArtifactStateRepository()
				.getCodeStateRepository().getAll();
	}
}