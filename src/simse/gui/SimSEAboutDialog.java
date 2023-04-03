/* File generated by: simse.codegenerator.guigenerator.SimSEAboutDialogGenerator */
package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import simse.gui.util.JavaFXHelpers;

public class SimSEAboutDialog extends Stage implements EventHandler<MouseEvent> {
	private String path = "src/simse/gui/images/layout/";
	
	Label lblIcon;
	private Button btnOK;

	private String versionNo = "v2.0";

//	public SimSEAboutDialog(Frame f) {
//		super(f, "About SimSE", true);
//		setDefaultCloseOperation(2);
//		setSize(380, 350);
//		buildGUI();
//	}
	
	public SimSEAboutDialog() {
		this.setTitle("About SimSE");
		buildGUI();
	}

	public void buildGUI() {
//		GridBagConstraints gbc;
//		gbl = new GridBagLayout();
//		con.setLayout(gbl);
		GridPane con = new GridPane();
		
		// logo
//		JPanel top = new JPanel(gbl);
//		VBox top = new VBox();
//		top.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
//													null, new BorderWidths(2))));
//		top.setBackground(new Color(102, 102, 102, 255));
//		top.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0.4, 0.4, 0.4, 1)));
//		Label lblLogo = new Label("", 
//				ImageLoader.getImageFromURL("/simse/gui/images/layout/simselogo-about.gif"));
//		lblLogo.setPrefSize(100, 200);
//		lblLogo.relocate(0, 0); //Probably correct
//		GridPane.setConstraints(lblLogo, 0, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
//				Priority.NEVER, new Insets(5, 0, 5, 0));
		
		Image logo = JavaFXHelpers.createImage(path + "simselogo-about.gif");
		final Canvas canvas = new Canvas(250,250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(102, 102, 102, 0));
		gc.fillRect(0, 0, 250, 250);
		gc.drawImage(logo, 20, 100); //TODO: Remove Hardcode :)
		
//		top.getChildren().add(canvas);

		VBox mid = new VBox();
		Label lblSimse = new Label("SimSE: " + versionNo);
		Label lblDesc = new Label(
				"An Educational Software Engineering Simulation Environment");
		Label lblUrl = new Label("http://www.ics.uci.edu/~emilyo/SimSE");
		Label lblSpacer = new Label(" ");

		GridPane.setConstraints(lblSimse, 0, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblSimse);
		
		GridPane.setConstraints(lblDesc, 0, 1, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblDesc);
		
		GridPane.setConstraints(lblUrl, 0, 2, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblUrl);

		GridPane.setConstraints(lblSpacer, 0, 3, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblSpacer);

		Label lblLead = new Label("Lead Developer:");
		Label lblEmily = new Label("  Emily Oh Navarro");
		Label lblCont = new Label("Contributing Developer:");
		Label lblCalvin = new Label("  Calvin Lee");
		Label lblSup = new Label("Supervising Faculty:");
		Label lblAndre = new Label("  Andre van der Hoek");

		GridPane.setConstraints(lblLead, 0, 5, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblLead);

		GridPane.setConstraints(lblEmily, 0, 5, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblEmily);

		GridPane.setConstraints(lblCont, 0, 6, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblCont);

		GridPane.setConstraints(lblCalvin, 0, 7, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblCalvin);
		
		GridPane.setConstraints(lblSup, 0, 9, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblSup);

		GridPane.setConstraints(lblAndre, 0, 9, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 10, 0, 0));
		mid.getChildren().add(lblAndre);

		// add the panels

		GridPane.setConstraints(canvas, 0, 0, 1, 1, HPos.CENTER, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 0, 0, 0));
		con.getChildren().add(canvas);

		GridPane.setConstraints(mid, 0, 1, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 0, 0, 0));
		con.getChildren().add(mid);

		ButtonBar buttonBar = new ButtonBar();
		
		btnOK = new Button("Close");
		ButtonBar.setButtonData(btnOK, ButtonData.CANCEL_CLOSE);
		btnOK.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

		GridPane.setConstraints(buttonBar, 0, 2, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, 
				Priority.NEVER, new Insets(10, 10, 10, 10));
		con.getChildren().add(buttonBar);
//		canvas.setAlignment(Pos.CENTER);
		mid.setAlignment(Pos.CENTER);
		con.setAlignment(Pos.CENTER);
		Scene scene = new Scene(con, 400, 450);
		scene.getStylesheets().add("src\\simse\\style.css");
		this.setScene(scene);
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		// handle the okay / cancel button
		if (source instanceof Button) {
			if (source == btnOK) {
				close();
			}
		}
	}
}