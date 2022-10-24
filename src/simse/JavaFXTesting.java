package simse;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import simse.engine.Engine;
import simse.explanatorytool.Branch;
import simse.explanatorytool.MultipleTimelinesBrowser;
import simse.gui.SimSEGUI;
import simse.logic.Logic;
import simse.state.State;

public class JavaFXTesting extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		State s = new State();
		Logic l = new Logic(s);
		Engine e = new Engine(l, s);
		Branch branch = new Branch("New Branch", 0, 50, null, null);
		MultipleTimelinesBrowser browser = new MultipleTimelinesBrowser(); 
		SimSEGUI gui = new SimSEGUI(e, s, l, branch, browser);
		
		gui.initModality(Modality.WINDOW_MODAL);
		gui.initOwner(primaryStage);
//        primaryStage.show();
        gui.showAndWait();
	}
}
