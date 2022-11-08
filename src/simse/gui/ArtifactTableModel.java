package simse.gui;

import java.util.Vector;

import simse.adts.objects.Artifact;
import simse.state.State;

public class ArtifactTableModel extends TableModel<Artifact>{

	public ArtifactTableModel(State s) {
		super(s);
	}

	@Override
	void initColNames() {
		columnNames.add("Name");
		columnNames.add("PercentComplete");
		columnNames.add("NumKnownErrors");
	}

	@Override
	Vector<Artifact> getRepository() {
		return state.getArtifactStateRepository().getAll();
	}

	@Override
	Object getValueAt(int row, int col) {
		Artifact model = data.elementAt(col);
		Object returnValue = null;
		switch(row) {
		case 0: returnValue = model.getName();
		break;
		case 1: returnValue = model.getSize();
		break;
		case 2: returnValue = model.getNumKnownErrors();
		break;
		case 3: returnValue = model.getNumUnknownErrors();
		break;
		case 4: returnValue = model.getPercentErroneous();
		break;
		case 5: returnValue = model.getNumUnknownTemp();
		break;
		}
		return returnValue;
	}

	@Override
	void setValueAt(Object value, int row, int col) {
		Artifact model = data.elementAt(col);
		switch(row) {
		case 0: model.setName((String) value);
		break;
		case 1: model.setSize((double) value);
		break;
		case 2: model.setPercentComplete((double) value);
		break;
		case 3: model.setNumKnownErrors((double) value);
		break;
		case 4: model.setNumUnknownErrors((double) value);
		break;
		case 5: model.setPercentErroneous((double) value);
		break;
		case 6: model.setNumUnknownTemp((double) value);
		break;
		}
		fireTableCellUpdated(row, col);
	}

}
