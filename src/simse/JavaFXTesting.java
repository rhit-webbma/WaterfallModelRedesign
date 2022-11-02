package simse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
//		try {
//			new FileInputStream("src/simse/gui/images/layout/border.gif");
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//			System.out.println(System.getProperty("user.dir"));
//		}
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
