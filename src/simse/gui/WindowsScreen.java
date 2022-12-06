package simse.gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import simse.logic.Logic;
import simse.state.State;

public class WindowsScreen extends Stage implements EventHandler<MouseEvent> {
	State state;
	SimSEGUI gui;
	Logic logic;

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public WindowsScreen(State state, SimSEGUI gui, Logic logic) {
		super();
		this.state = state;
		this.gui = gui;
		this.logic = logic;
		
		this.setTitle("Windows Screen");
	}

}
