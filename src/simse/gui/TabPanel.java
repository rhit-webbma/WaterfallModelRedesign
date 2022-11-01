/* File generated by: simse.codegenerator.guigenerator.TabPanelGenerator */
package simse.gui;

import simse.adts.objects.*;
import simse.state.*;
import simse.logic.*;
import simse.gui.util.JavaFXHelpers;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class TabPanel extends Pane implements EventHandler<Event> {
	public static final int ARTIFACT = 0;
	public static final int CUSTOMER = 1;
	public static final int EMPLOYEE = 2;
	public static final int PROJECT = 3;
	public static final int TOOL = 4;

	public static final int MAXBUTTONS = 32;

	private LogoPanel logoPane;
	private AttributePanel attributePane;
	private EmployeesAtAGlanceFrame employeeFrame;
	private ArtifactsAtAGlanceFrame artifactFrame;
	private ToolsAtAGlanceFrame toolFrame;
	private ProjectsAtAGlanceFrame projectFrame;
	private CustomersAtAGlanceFrame customerFrame;

	private GridPane gridPane;
	private boolean guiChanged;

	// the 5 different tabs:
	private Button[] artifactButton;
	private Button[] customerButton;
	private Button[] employeeButton;
	private Button[] projectButton;
	private Button[] toolButton;
	private Employee rightClickedEmployee;

	private State state;
	private Logic logic;
	private SimSEGUI gui;
	private Hashtable<SSObject, ImageView> objsToImages; // maps Objects (keys)
															// to ImageIcons
															// (values)
	private Hashtable<Button, SSObject> buttonsToObjs; // maps JButtons (keys)
														// to Objects (values)
	private FlowPane buttonsPane;
	private SSObject objInFocus = null;

	// for the blue line around the icons:
	private Border defaultBorder;
	private Border selectedBorder;
	private Color btnBlue = Color.rgb(180, 180, 255, 1.0);
	private Image border;
	private Image allIcon;
	
	private EventHandler<ActionEvent> menuItemEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event)
        {
        	guiChanged = true;
			Object source = event.getSource();
			if (source instanceof MenuItem) {
				MenuItem jm = (MenuItem) source;
				logic.getMenuInputManager().menuItemSelected(rightClickedEmployee,
						jm.getText(), gui);
				gui.getWorld().update();
			}
        }
    };

	public TabPanel(SimSEGUI g, State s, Logic l, AttributePanel a) {
		logic = l;
		gui = g;
		state = s;
		guiChanged = true;
		attributePane = a;
		objsToImages = new Hashtable<SSObject, ImageView>();
		buttonsToObjs = new Hashtable<Button, SSObject>();
		employeeFrame = new EmployeesAtAGlanceFrame(state, gui);
		artifactFrame = new ArtifactsAtAGlanceFrame(state, gui);
		toolFrame = new ToolsAtAGlanceFrame(state, gui);
		projectFrame = new ProjectsAtAGlanceFrame(state, gui);
		customerFrame = new CustomersAtAGlanceFrame(state, gui);

		border = JavaFXHelpers.createImage("src/simse/gui/images/layout/border.gif");
		allIcon = JavaFXHelpers.createImage("src/simse/gui/images/all.GIF");

		// get the Border styles:
		defaultBorder = new Button().getBorder();
		selectedBorder = new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
//				new BevelBorder(BevelBorder.RAISED, new Color(80, 80,
//				225, 255), new Color(0, 0, 115, 255));

		// Create main panel:
		gridPane = new GridPane();
		gridPane.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1.0)));
		gridPane.setPrefWidth(1024);
//		gridPane.setGridLinesVisible(true);

		logoPane = new LogoPanel(gui);
		logoPane.setMinSize(340, 90);
		logoPane.setPrefSize(340, 90);
		logoPane.setTabPanel(this);

		// Create buttons pane:
		buttonsPane = new FlowPane();
		buttonsPane.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(69, 135, 156, 1.0))); // dark green color
		ScrollPane buttonsScrollPane = new ScrollPane(buttonsPane);
		buttonsScrollPane.setPrefSize(292, 75);

		generateButtons();

		// Add panes and labels to main pane:
		
		gridPane.setHgap(200);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(0, 0, 0, 0));
	    gridPane.getColumnConstraints().add(new ColumnConstraints(logoPane.getWidth() + 100));
		
		// Add Logo Pane:
		GridPane.setConstraints(logoPane, 0, 0, 2, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 0, 0, 0));
		gridPane.add(logoPane, 0, 0);

		// Add panes and labels to main pane
		GridPane.setConstraints(buttonsScrollPane, 1, 0, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, 
				Priority.NEVER, new Insets(0, 0, 10, 0));
		gridPane.add(buttonsScrollPane, 2, 0); //TODO: Put this back :)
//
		setPrefSize(1024, 100);
		updateImages(EMPLOYEE);
		
		this.getChildren().add(gridPane);
	}

//	public void paintComponent(Graphics g) {
//		int width = (int) this.getWidth();
//		g.setColor(new Color(102, 102, 102, 255));
//		g.fillRect(0, 0, width, 100);
//
//		// repeat the border across the width of screen:
//		for (int i = 0; i < width; i += 100) {
//			g.drawImage(border, i, 92, this);
//		}
//	}

	public void generateButtons() {
		artifactButton = new Button[MAXBUTTONS];
		customerButton = new Button[MAXBUTTONS];
		employeeButton = new Button[MAXBUTTONS];
		projectButton = new Button[MAXBUTTONS];
		toolButton = new Button[MAXBUTTONS];

		// generate list of <maxbuttons>:
		for (int i = 0; i < MAXBUTTONS; i++) {
			artifactButton[i] = new Button();
			artifactButton[i].addEventHandler(ActionEvent.ACTION, this);
			customerButton[i] = new Button();
			customerButton[i].addEventHandler(ActionEvent.ACTION, this);
			employeeButton[i] = new Button();
			employeeButton[i].addEventHandler(ActionEvent.ACTION, this);
			projectButton[i] = new Button();
			projectButton[i].addEventHandler(ActionEvent.ACTION, this);
			toolButton[i] = new Button();
			toolButton[i].addEventHandler(ActionEvent.ACTION, this);
			ContextMenu popup = new ContextMenu();
			PopupListener popupListener = new PopupListener(popup, gui);
			popupListener.setEnabled(false);
			employeeButton[i].addEventHandler(MouseEvent.ANY, popupListener);
			employeeButton[i].addEventHandler(MouseEvent.MOUSE_RELEASED, this);
		}

		setButtonConstraints(artifactButton, buttonsPane);
		setButtonConstraints(customerButton, buttonsPane);
		setButtonConstraints(employeeButton, buttonsPane);
		setButtonConstraints(projectButton, buttonsPane);
		setButtonConstraints(toolButton, buttonsPane);
	}

	public void setButtonConstraints(Button[] button, Pane pane) {
		int shift;
		int index;
		for (int j = 0; j < 2; j++) {
			shift = 16 * j;
			for (int i = 0; i < MAXBUTTONS / 2; i++) {
				index = shift + i;
				if (button == employeeButton) {
//					PopupListener pListener = ((PopupListener) button[index].getOnMouseReleased());
//					pListener.setEnabled(false);
					button[index].disarm();
				}
//				button[index].setGraphic(JavaFXHelpers.createImageView("src/simse/gui/images/error.GIF"));
				button[index].setPrefSize(5, 5);
				button[index].setBackground(JavaFXHelpers.createBackgroundColor(Color.LIGHTGRAY));
				button[index].setBorder(defaultBorder);
				button[index].disarm();
				GridPane.setConstraints(button[index], i, j, 1, 1, HPos.LEFT, VPos.TOP, Priority.NEVER, 
						Priority.NEVER, new Insets(2, 1, 0, 0));
				if(!pane.getChildren().contains(button[index])) {
					pane.getChildren().add(button[index]);
				}
			}
		}
	}
	
	@Override
	public void handle(Event event) {
		if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			if (event.getSource() instanceof Button) {
				Button button = (Button) event.getSource();
				ImageView ico = (ImageView) button.getGraphic();
				if (ico != null) {
					rightClickedEmployee = (Employee) buttonsToObjs.get(button);
				}
			}
		} else if (event.getEventType() ==  ActionEvent.ACTION) {
			guiChanged = true;
			Object source = event.getSource();
			if (source instanceof Button) {
				Button button = (Button) source;
				if (buttonsToObjs.get(button) != null) {
					attributePane.setGUIChanged();
					objInFocus = buttonsToObjs.get(button);
					String filename = getImage(objInFocus);
					attributePane.setObjectInFocus(objInFocus, JavaFXHelpers.createImage(filename));

					Enumeration<Button> buttons = buttonsToObjs.keys();
					for (int i = 0; i < buttonsToObjs.size(); i++) {
						Button key = buttons.nextElement();
						key.setBackground(JavaFXHelpers.createBackgroundColor(Color.WHITE));
						key.setBorder(defaultBorder);
					}

					button.setBackground(JavaFXHelpers.createBackgroundColor(btnBlue));
					button.setBorder(selectedBorder);
				} else if (((ImageView) button.getGraphic()).getImage().equals(allIcon)) {
					switch (logoPane.getSelectedTabIndex()) {
					case EMPLOYEE:
						if (employeeFrame.isIconified()) {
							employeeFrame.setIconified(false);
						}
						employeeFrame.show();
						break;
					case ARTIFACT:
						if (artifactFrame.isIconified()) {
							artifactFrame.setIconified(false);
						}
						artifactFrame.show();
						break;
					case TOOL:
						if (toolFrame.isIconified()) {
							toolFrame.setIconified(false);
						}
						toolFrame.show();
						break;
					case PROJECT:
						if (projectFrame.isIconified()) {
							projectFrame.setIconified(false);
						}
						projectFrame.show();
						break;
					case CUSTOMER:
						if (customerFrame.isIconified()) {
							customerFrame.setIconified(false);
						}
						customerFrame.show();
						break;
					default:
					}
				}
			}
		}
	}

	public void setObjectInFocus(SSObject obj) {
		objInFocus = obj;
		update();
	}

	public void setGUIChanged() {
		guiChanged = true;
	}

	public void update() {
		update(logoPane.getSelectedTabIndex());
	}

	public void update(int index) {
//		attributePane.update();
//		employeeFrame.update();
//		artifactFrame.update();
//		toolFrame.update();
//		projectFrame.update();
		customerFrame.update();
		if (!guiChanged) {
			return;
		}
		// clear buttons:
		buttonsToObjs.clear();
//		buttonsPane.getChildren().removeAll();
		buttonsPane.getChildren().clear();

		// update images:
		updateImages(index);

		Button[] buttonList;
		Vector<? extends SSObject> objs;

		switch (index) {
		case ARTIFACT:
			buttonList = artifactButton;
			objs = state.getArtifactStateRepository().getAll();
			break;
		case CUSTOMER:
			buttonList = customerButton;
			objs = state.getCustomerStateRepository().getAll();
			break;
		case EMPLOYEE:
			buttonList = employeeButton;
			objs = state.getEmployeeStateRepository().getAll();
			break;
		case PROJECT:
			buttonList = projectButton;
			objs = state.getProjectStateRepository().getAll();
			break;
		case TOOL:
			buttonList = toolButton;
			objs = state.getToolStateRepository().getAll();
			break;
		default:
			buttonList = toolButton;
			objs = new Vector<SSObject>();
		}
		setButtonConstraints(buttonList, buttonsPane);

		{
			boolean atLeastOneObj = false;
			if (objs.size() > 0) // there is at least one object of the selected
									// type
			{
				atLeastOneObj = true;
				Button allButton = buttonList[0];
				allButton.arm();
				allButton.setBorder(defaultBorder);
				allButton.setGraphic(new ImageView(allIcon));
			}

			int j = 0;
			// go through all objects:
			for (int i = 0; i < objs.size(); i++) {
				SSObject obj = objs.elementAt(i);
				Button button = null;
				if (atLeastOneObj) {
					button = buttonList[++j];
				} else {
					button = buttonList[j++];
				}
				if ((index == EMPLOYEE)
						&& (state.getClock().isStopped() == false)) {
					Employee e = (Employee) obj;
					PopupListener pListener = ((PopupListener) button.getOnMouseReleased());
					pListener.setEnabled(true);
					ContextMenu p = pListener.getPopupMenu();
					p.getItems().removeAll();
					Vector<String> v = e.getMenu();
					for (int k = 0; k < v.size(); k++) {
						MenuItem tempItem = new MenuItem(v.elementAt(k));
						tempItem.setOnAction(menuItemEvent);
						p.getItems().add(tempItem);
					}
				}
				button.arm();
				button.setGraphic(objsToImages.get(obj));

				if (obj.equals(objInFocus)) {
					button.setBackground(JavaFXHelpers.createBackgroundColor(btnBlue));
					button.setBorder(selectedBorder);
				} else {
					button.setBackground(JavaFXHelpers.createBackgroundColor(Color.WHITE));
					button.setBorder(defaultBorder);
				}
				buttonsToObjs.put(button, obj);

				if (i == (MAXBUTTONS - 1)) // reached the max
				{
					break;
				}
			}
		}
		guiChanged = false;
	}

	private void updateImages(int index) {
		Vector<? extends SSObject> objs;
		switch (index) {
		case ARTIFACT:
			objs = state.getArtifactStateRepository().getAll();
			break;
		case CUSTOMER:
			objs = state.getCustomerStateRepository().getAll();
			break;
		case EMPLOYEE:
			objs = state.getEmployeeStateRepository().getAll();
			break;
		case PROJECT:
			objs = state.getProjectStateRepository().getAll();
			break;
		case TOOL:
			objs = state.getToolStateRepository().getAll();
			break;
		default:
			objs = new Vector<SSObject>();
			break;
		}

		for (int i = 0; i < objs.size(); i++) {
			String filename = getImage(objs.elementAt(i));

			ImageView scaledImage = JavaFXHelpers.createImageView(filename);
			scaledImage.resize(35, 35);

			objsToImages.put(objs.elementAt(i), scaledImage);
		}
	}

	public static String getImage(Object obj) {
		String url = "";

		if (obj instanceof SoftwareEngineer) {
			SoftwareEngineer p = (SoftwareEngineer) obj;
			if (p.getName().equals("Mimi")) {
				url = "src/simse/gui/icons/bev.gif";
			} else if (p.getName().equals("Roger")) {
				url = "src/simse/gui/icons/ping.gif";
			} else if (p.getName().equals("Calvin")) {
				url = "src/simse/gui/icons/calvin.gif";
			} else if (p.getName().equals("Anita")) {
				url = "src/simse/gui/icons/anita2.png";
			} else if (p.getName().equals("Emily")) {
				url = "src/simse/gui/icons/emily.gif";
			} else if (p.getName().equals("Pedro")) {
				url = "src/simse/gui/icons/chris2.gif";
			} else if (p.getName().equals("Andre")) {
				url = "src/simse/gui/icons/andre2.png";
			}
		} else if (obj instanceof RequirementsDocument) {
			RequirementsDocument p = (RequirementsDocument) obj;
			if (p.getName().equals("Requirements")) {
				url = "src/simse/gui/icons/3.gif";
			}
		} else if (obj instanceof DesignDocument) {
			DesignDocument p = (DesignDocument) obj;
			if (p.getName().equals("Design")) {
				url = "src/simse/gui/icons/1.gif";
			}
		} else if (obj instanceof Code) {
			Code p = (Code) obj;
			if (p.getName().equals("Code")) {
				url = "src/simse/gui/icons/6.gif";
			}
		} else if (obj instanceof SystemTestPlan) {
			SystemTestPlan p = (SystemTestPlan) obj;
			if (p.getName().equals("TestPlan")) {
				url = "src/simse/gui/icons/4.gif";
			}
		} else if (obj instanceof SEProject) {
			SEProject p = (SEProject) obj;
			if (p.getDescription().equals("Groceries@Home")) {
				url = "src/simse/gui/icons/11.gif";
			}
		} else if (obj instanceof RequirementsCaptureTool) {
			RequirementsCaptureTool p = (RequirementsCaptureTool) obj;
			if (p.getName().equals("SteelTrace")) {
				url = "src/simse/gui/icons/10.gif";
			}
		} else if (obj instanceof DesignEnvironment) {
			DesignEnvironment p = (DesignEnvironment) obj;
			if (p.getName().equals("RationalRose")) {
				url = "src/simse/gui/icons/use_case_green.GIF";
			}
		} else if (obj instanceof IDE) {
			IDE p = (IDE) obj;
			if (p.getName().equals("Eclipse")) {
				url = "src/simse/gui/icons/12.gif";
			}
		} else if (obj instanceof AutomatedTestingTool) {
			AutomatedTestingTool p = (AutomatedTestingTool) obj;
			if (p.getName().equals("JUnit")) {
				url = "src/simse/gui/icons/8.gif";
			}
		} else if (obj instanceof ACustomer) {
			ACustomer p = (ACustomer) obj;
			if (p.getName().equals("Grocery Home Delivery Service")) {
				url = "src/simse/gui/icons/eddie_murphy.gif";
			}
		}
		return url;
	}
}