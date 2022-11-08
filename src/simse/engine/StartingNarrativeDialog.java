/* File generated by: simse.codegenerator.enginegenerator.StartingNarrativeDialogGenerator */
package simse.engine;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class StartingNarrativeDialog extends Stage implements EventHandler<MouseEvent> {
	
	private TextArea textArea;
	private Button okButton;
	private BorderPane root;
	
	public StartingNarrativeDialog() {
		// TODO Auto-generated method stub
		this.initModality(Modality.APPLICATION_MODAL);
		this.setTitle("Welcome!");
		
		textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setEditable(false);
		textArea.setText("     Welcome to SimSE! Your task is to create Groceries@Home, a Web-based system that will allow people to place orders over the Internet for groceries to be delivered to their homes. The customer is the Grocery Home Delivery Service, a company who, up until now, has taken orders for groceries solely by telephone, but now wants to step into the information age. \n     Your budget is $280,000, and you have 1,350 clock ticks to complete the project. However, you should keep checking your project info to monitor this information -- the customer has the tendency to introduce new requirements, and will sometimes give you more time and/or money along with those new requirements. \n     Your final score will be out of 100 points, and it will be calculated based on how complete and error-free your code is, whether your code is integrated or not, and how well you stick to your budget and schedule. \n\nTwo notes:\n* Each hired employee is always paid every clock tick regardless of whether they're busy or not. So use them wisely!\n* If you want to use a tool that you have purchased in a task, you must specify that when you assign the task. If you have already started the task without the tool, you must stop and restart the task with the tool if you want it to be used.\n\nGood luck!"
				+ "");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setContent(textArea);

		// Create okButton pane and button:
		okButton = new Button("OK");
		okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

		this.root = new BorderPane();
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		root.setCenter(scrollPane);
		root.setBottom(okButton);
		BorderPane.setAlignment(okButton, Pos.CENTER);
		
		Scene scene = new Scene(root);
		this.setScene(scene);
		this.show();
		
		// Set main window frame properties:
		
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        this.setX((primScreenBounds.getWidth() - this.getWidth()) / 2);
        this.setY((primScreenBounds.getHeight() - this.getHeight()) / 2);
        
        this.toFront();
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
	    Stage stage = (Stage) root.getScene().getWindow();
	    stage.close();
	}

}