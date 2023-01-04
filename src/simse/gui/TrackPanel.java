package simse.gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TrackPanel extends Pane implements SimSEPanel {

	@Override
	public Panels getPanelType() {
		return Panels.TRACK;
	}

	public TrackPanel() {
		super();
		
		this.getChildren().add(new Label("TRACK"));
	}

}
