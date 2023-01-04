package simse.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MelloPanel extends Pane implements SimSEPanel {

	@Override
	public Panels getPanelType() {
		return Panels.MELLO;
	}

	public MelloPanel() {
		super();
		
		this.getChildren().add(new Label("MELLO"));
	}

}
