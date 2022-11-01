/* File generated by: simse.codegenerator.guigenerator.LogoPanelGenerator */
package simse.gui;

import java.awt.Point;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import simse.SimSE;
import simse.engine.*;
import simse.gui.util.JavaFXHelpers;

public class LogoPanel extends Pane implements EventHandler<MouseEvent> {
	private String path = "src/simse/gui/images/layout/";

	private TabPanel tabPane;

	private Button artifactButton;
	private Button customerButton;
	private Button employeeButton;
	private Button projectButton;
	private Button toolButton;
	private Button aboutButton;
	private Button infoButton;
	private Button resetButton;

	private int selectedTabIndex = -1;

	private GridPane gridPane;

	private ImageView[] inactiveButton;
	private ImageView[] activeButton;
	private SimSEGUI gui;

	public LogoPanel(SimSEGUI g) {
		gui = g;
		gridPane = new GridPane();
		this.getChildren().add(gridPane);
		gridPane.setGridLinesVisible(true);
		// loads the tab buttons
		createButtonImageSet();

		// create the buttons
		artifactButton = new Button("", inactiveButton[0]);
		artifactButton.setMinSize(120, 16);
		artifactButton.setPadding(new Insets(0, 0, 0, 0));
		customerButton = new Button("", inactiveButton[1]);
		customerButton.setMinSize(120, 16);
		customerButton.setPadding(new Insets(0, 0, 0, 0));
		employeeButton = new Button("", inactiveButton[2]);
		employeeButton.setMinSize(120, 16);
		employeeButton.setPadding(new Insets(0, 0, 0, 0));
		projectButton = new Button("", inactiveButton[3]);
		projectButton.setMinSize(120, 16);
		projectButton.setPadding(new Insets(0, 0, 0, 0));
		toolButton = new Button("", inactiveButton[4]);
		toolButton.setMinSize(120, 16);
		toolButton.setPadding(new Insets(0, 0, 0, 0));

		// create the layout:
		createLayout();
		
		Image logo = JavaFXHelpers.createImage(path + "simselogo.gif");
		final Canvas canvas = new Canvas(250,250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(102, 102, 102, 0));
		gc.fillRect(0, 0, 340, 100);
		gc.drawImage(logo, 0, 0);
		
		gridPane.add(canvas, 0, 0, 1, 1);
//		gridPane.setGridLinesVisible(true);
	}

	public void setTabPanel(TabPanel tab) {
		if (tabPane == null)
			tabPane = tab;
	}
	
	public void createButtonImageSet() {
		inactiveButton = new ImageView[5];
		activeButton = new ImageView[5];

		inactiveButton[0] = JavaFXHelpers.createImageView(path + "btnArtifact.gif");
		inactiveButton[1] = JavaFXHelpers.createImageView(path + "btnCustomer.gif");
		inactiveButton[2] = JavaFXHelpers.createImageView(path + "btnEmployee.gif");
		inactiveButton[3] = JavaFXHelpers.createImageView(path + "btnProject.gif");
		inactiveButton[4] = JavaFXHelpers.createImageView(path + "btnTool.gif");

		activeButton[0] = JavaFXHelpers.createImageView(path + "btnArtifactClicked.gif");
		activeButton[1] = JavaFXHelpers.createImageView(path + "btnCustomerClicked.gif");
		activeButton[2] = JavaFXHelpers.createImageView(path + "btnEmployeeClicked.gif");
		activeButton[3] = JavaFXHelpers.createImageView(path + "btnProjectClicked.gif");
		activeButton[4] = JavaFXHelpers.createImageView(path + "btnToolClicked.gif");
	}

	public int getSelectedTabIndex() {
		return selectedTabIndex;
	}

	public void createLayout() {
		GridPane buttonGPane = new GridPane();
		buttonGPane.setVgap(0.8);
//		buttonGPane.setOpacity(1);
//		buttonGPane.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0, 0, 0, 0)));
//		GridPane.setConstraints(buttonGPane, 1, 0, 4, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 0));
//		buttonGPane.setGridLinesVisible(true);
		
		infoButton = new Button();
		infoButton.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0, 0, 0, 0)));
//		infoButton.setOpacity(1);
//		infoButton.setMinSize(24, 40);
//		infoButton.setPrefSize(24, 40);
//		infoButton.setBorder(null);
		infoButton.addEventHandler(MouseEvent.ANY, this);
//		GridPane.setConstraints(infoButton, 0, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 0));
//		gridPane.getChildren().add(infoButton);
//		gridPane.add(infoButton, 0, 0, 1, 1);
		resetButton = new Button();
		resetButton.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0, 0, 0, 0)));
//		resetButton.setOpacity(1);
//		resetButton.setMinSize(24, 40);
//		resetButton.setPrefSize(24, 40);
//		resetButton.setBorder(null);
		resetButton.addEventHandler(MouseEvent.ANY, this);
//		GridPane.setConstraints(resetButton, 0, 0, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 0));
//		gridPane.getChildren().add(resetButton);
//		gridPane.add(resetButton, 0, 1, 1, 1);
//		addButton(resetButton, 0, 0, 1, 1, gridPane);
		aboutButton = new Button();
//		aboutButton.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0, 0, 0, 0)));
//		aboutButton.setOpacity(1);
//		aboutButton.setMinSize(170, 88);
//		aboutButton.setPrefSize(170, 88);
//		addButton(aboutButton, 0, 0, 1, 1, gridPane);
		// spacers to get the angled tab effect:

		addButton(artifactButton, 0, 0, 1, 1, buttonGPane);
//		addLabel(lblCustSpacer1, 0, 1, 1, 1, buttonGPane);
		addButton(customerButton, 0, 2, 1, 1, buttonGPane);
//		addLabel(lblEmpSpacer1, 0, 3, 1, 1, buttonGPane);
//		addLabel(lblEmpSpacer2, 0, 4, 1, 1, buttonGPane);
		addButton(employeeButton, 0, 5, 1, 1, buttonGPane);
//		addLabel(lblProjSpacer1, 0, 6, 1, 1, buttonGPane);
		addButton(projectButton, 0, 7, 1, 1, buttonGPane);
		addButton(toolButton, 0, 8, 1, 1, buttonGPane);
		
		gridPane.add(buttonGPane, 1, 0);
//		buttonGPane.setGridLinesVisible(true);
		
//		gridPane.getChildren().add(buttonGPane);
	}

	public void addLabel(Label lb, int x, int y, int rowspan, int colspan, GridPane gp) {
		lb.setBackground(JavaFXHelpers.createBackgroundColor(new Color(0, 0, 0, 0)));
		gp.add(lb, x, y, colspan, rowspan);
//		gridPane.getChildren().add(lb);
//		GridPane.setConstraints(lb, x, y, colspan, rowspan, HPos.LEFT, VPos.TOP, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 0));

	}

	public void addButton(Button jb, int x, int y, int rowspan, int colspan, GridPane gp) {
//		gridPane.getChildren().add(jb);
		jb.setBorder(null);
		jb.addEventHandler(MouseEvent.ANY, this);
		jb.setOpacity(1);
		gp.add(jb, x, y, colspan, rowspan);
//		GridPane.setConstraints(jb, x, y, colspan, rowspan, HPos.LEFT, VPos.TOP, Priority.NEVER, Priority.NEVER, new Insets(0, 0, 0, 0));

	}

//	public void paintComponent(Graphics g) {
//		Image logo = ImageLoader.getImageFromURL(path + "simselogo.gif");
//		g.setColor(new Color(102, 102, 102, 255));
//		g.fillRect(0, 0, 340, 100);
//		g.drawImage(logo, 0, 0, this);
//	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			if (source instanceof Button) {
				setCursor(Cursor.HAND);
			}
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			setCursor(Cursor.DEFAULT);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			if (source.equals(aboutButton)) {
				SimSEAboutDialog about = new SimSEAboutDialog();
				about.setX(300);
				about.setY(300);
				about.show();
			} else if (source.equals(infoButton)) {
				new StartingNarrativeDialog();
			} else if (source.equals(resetButton)) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Reset Game?");
				String s = "Are You Sure You Want To Reset?";
				alert.setContentText(s);
				 
				Optional<ButtonType> result = alert.showAndWait();
				 
				if (result.get() == ButtonType.OK) {
					if (gui.getEngine().getTimer() != null) {
						gui.getEngine().getTimer().stop();
					}
					gui.close();
					SimSE.main(new String[] {});
				}
			} else {
				// clear all buttons to default setting:
				if (source instanceof Button) {
					artifactButton.setGraphic(inactiveButton[0]);
					customerButton.setGraphic(inactiveButton[1]);
					employeeButton.setGraphic(inactiveButton[2]);
					projectButton.setGraphic(inactiveButton[3]);
					toolButton.setGraphic(inactiveButton[4]);
				}

				if (source.equals(artifactButton)) {
					artifactButton.setGraphic(activeButton[0]);
					selectedTabIndex = 0;
				} else if (source.equals(customerButton)) {
					customerButton.setGraphic(activeButton[1]);
					selectedTabIndex = 1;
				} else if (source.equals(employeeButton)) {
					employeeButton.setGraphic(activeButton[2]);
					selectedTabIndex = 2;
				} else if (source.equals(projectButton)) {
					projectButton.setGraphic(activeButton[3]);
					selectedTabIndex = 3;
				} else if (source.equals(toolButton)) {
					toolButton.setGraphic(activeButton[4]);
					selectedTabIndex = 4;
				}
			}

			tabPane.setGUIChanged();
			if (tabPane != null)
				tabPane.update();
		}
	}
}