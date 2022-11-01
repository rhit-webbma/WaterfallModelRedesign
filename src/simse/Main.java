package simse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		arg0.setTitle("Hello World");
		arg0.setScene(new Scene(root, 400,300));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	
}
