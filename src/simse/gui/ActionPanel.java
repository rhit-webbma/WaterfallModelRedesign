/* File generated by: simse.codegenerator.guigenerator.ActionPanelGenerator */
package simse.gui;

import simse.state.*;
import simse.logic.*;
import simse.adts.objects.*;
import simse.gui.util.JavaFXHelpers;
import simse.adts.actions.*;

//import java.text.*;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.*;

public class ActionPanel extends Pane implements EventHandler<MouseEvent> {
	private State state;
	private Logic logic;
	private SimSEGUI mainGUIFrame;

	private ContextMenu popup;

	private Employee selectedEmp;

	private ScrollPane actionPane;
	private Hashtable<Employee, Pane> empsToEmpPanels;
	private Hashtable<Employee, VBox> empsToPicPanels;
	// private Hashtable empsToActPanels;
	private Hashtable<Employee, Label> empsToPicLabels;
	private Hashtable<Employee, Label> empsToKeyLabels;

	private VBox layout;

	private EventHandler<ActionEvent> menuItemEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if (source instanceof MenuItem) {
				popupMenuActions((MenuItem) source);
			}
		}
	};

	public ActionPanel(SimSEGUI gui, State s, Logic l) {
		state = s;
		logic = l;
		mainGUIFrame = gui;

		layout = new VBox();

		actionPane = new ScrollPane();
		actionPane.setPrefSize(225, 495);
		actionPane.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1)));

		empsToEmpPanels = new Hashtable<Employee, Pane>();
		empsToPicPanels = new Hashtable<Employee, VBox>();
		// empsToActPanels = new Hashtable();
		empsToPicLabels = new Hashtable<Employee, Label>();
		empsToKeyLabels = new Hashtable<Employee, Label>();

		BorderPane titlePanel = new BorderPane();
		titlePanel.setBorder(Border.EMPTY);
		titlePanel.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1)));
		Label titleLabel = new Label("Current Activities:");
		Font f = titleLabel.getFont();
		Font newFont = new Font(f.getName(), 15);
		titleLabel.setFont(newFont);
		titleLabel.setTextFill(Color.WHITE);
		titlePanel.setLeft(titleLabel);

		selectedEmp = null;
		popup = new ContextMenu();

		layout.getChildren().add(titlePanel);
		layout.getChildren().add(actionPane);
		
		update();
		this.getChildren().add(layout);		
	}

	public void createPopupMenu(Node node, double x, double y) {
		popup.getItems().removeAll();

		if (mainGUIFrame.getEngine().isRunning()) {
			return;
		}

		if (selectedEmp != null) {
			Vector<String> menuItems = selectedEmp.getMenu();
			for (int i = 0; i < menuItems.size(); i++) {
				String item = menuItems.elementAt(i);
				MenuItem tempItem = new MenuItem(item);
				tempItem.setOnAction(menuItemEvent);
				popup.getItems().add(tempItem);
			}
			if (menuItems.size() >= 1) {
				popup.show(node, x, y);
			}
		}
	}

	public void update() {
		actionPane.setContent(null);;
		Vector<Employee> allEmps = state.getEmployeeStateRepository().getAll();
		for (int i = 0; i < allEmps.size(); i++) {
			Employee emp = allEmps.elementAt(i);
			if (empsToEmpPanels.get(emp) == null) {
				Pane tempPanel = new Pane();
				tempPanel.addEventHandler(MouseEvent.ANY, this);
				empsToEmpPanels.put(emp, tempPanel);
			}
			if (empsToPicPanels.get(emp) == null) {
				VBox tempPanel = new VBox();
				tempPanel.addEventHandler(MouseEvent.ANY, this);
				empsToPicPanels.put(emp, tempPanel);
			}
			/*
			 * if(empsToActPanels.get(emp) == null) { JPanel temp = new JPanel();
			 * temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
			 * temp.setMinimumSize(new Dimension(150, 10)); empsToActPanels.put(emp, temp);
			 * }
			 */
			Pane empPanel = empsToEmpPanels.get(emp);
			empPanel.getChildren().removeAll();
			VBox picPanel = (VBox) empsToPicPanels.get(emp);
			picPanel.getChildren().removeAll();

			GridPane gpLayout = new GridPane();
//			GridBagConstraints gbc = new GridBagConstraints();
//			gpLayout.fill = GridBagConstraints.NONE;
//			gpLayout.gridwidth = 3;
//			gpLayout.gridheight = 1;
			gpLayout.getChildren().add(empPanel);

			empPanel.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1)));
			picPanel.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1)));
			if (empsToPicLabels.get(emp) == null) {
				ImageView ico = JavaFXHelpers.createImageView(TabPanel.getImage(emp));
				Label temp = new Label();
				temp.setGraphic(ico);
				temp.addEventHandler(MouseEvent.ANY, this);
				empsToPicLabels.put(emp, temp);
			}

			Label picLabel = empsToPicLabels.get(emp);
			picLabel.setAlignment(Pos.BASELINE_LEFT);
			if(!picPanel.getChildren().contains(picLabel)) {
				picPanel.getChildren().add(picLabel);
			}
			if (emp instanceof SoftwareEngineer) {
				SoftwareEngineer e = (SoftwareEngineer) emp;
				if (empsToKeyLabels.get(e) == null) {
					Label temp = new Label("" + e.getName());
					temp.setTextFill(Color.WHITE);
					temp.setAlignment(Pos.BASELINE_LEFT);
					temp.setTextAlignment(TextAlignment.LEFT);
					empsToKeyLabels.put(e, temp);
				}
				Label keyLabel = empsToKeyLabels.get(e);
				if(!picPanel.getChildren().contains(keyLabel)) {
					picPanel.getChildren().add(keyLabel);
				}
			}
//			picPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
			picPanel.setBorder(Border.EMPTY);
//			gbc.weightx = 1;
//			gbc.weighty = 1;
//			gbc.anchor = GridBagConstraints.WEST;
			if(!empPanel.getChildren().contains(picPanel)) {
				empPanel.getChildren().add(picPanel);
			}
			VBox actsPanel = new VBox();
			// actsPanel.removeAll();

			actsPanel.setBackground(JavaFXHelpers.createBackgroundColor(Color.rgb(102, 102, 102, 1)));
			Vector<simse.adts.actions.Action> acts = state.getActionStateRepository().getAllActions(emp);
			for (int j = 0; j < acts.size(); j++) {
				simse.adts.actions.Action tempAct = acts.elementAt(j);
				if (tempAct instanceof CreateRequirementsAction) {
					Label tempLabel = new Label("Creating requirements");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof ReviewRequirementsAction) {
					Label tempLabel = new Label("Reviewing requirements");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CorrectRequirementsAction) {
					Label tempLabel = new Label("Correcting requirements");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CreateDesignAction) {
					Label tempLabel = new Label("Creating design");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof ReviewDesignAction) {
					Label tempLabel = new Label("Reviewing design");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CorrectDesignAction) {
					Label tempLabel = new Label("Correcting design");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CreateCodeAction) {
					Label tempLabel = new Label("Creating code");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof InspectCodeAction) {
					Label tempLabel = new Label("Inspecting code");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CorrectCodeAction) {
					Label tempLabel = new Label("Correcting code");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof IntegrateCodeAction) {
					Label tempLabel = new Label("Integrating code");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof SystemTestAction) {
					Label tempLabel = new Label("Doing system test");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CreateSystemTestPlanAction) {
					Label tempLabel = new Label("Creating system test plan");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof ReviewSystemTestPlanAction) {
					Label tempLabel = new Label("Reviewing system test plan");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof CorrectSystemTestPlanAction) {
					Label tempLabel = new Label("Correcting system test plan");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof BreakAction) {
					Label tempLabel = new Label("On a break");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				} else if (tempAct instanceof GetSickAction) {
					Label tempLabel = new Label("Out sick");
					tempLabel.setFont(new Font(tempLabel.getFont().getName(), 10));
					tempLabel.setTextFill(Color.WHITE);
					actsPanel.getChildren().add(tempLabel);
				}
			}
//			gbc.weightx = 2;
//			gbc.anchor = GridBagConstraints.EAST;
			actsPanel.setPrefSize(150, (int) (actsPanel.getPrefHeight()));
			empPanel.getChildren().add(actsPanel);
//			empPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}	

	public void popupMenuActions(MenuItem source) {
		MenuItem item = (MenuItem) source;
		logic.getMenuInputManager().menuItemSelected(selectedEmp, item.getText(), mainGUIFrame);
		mainGUIFrame.getWorld().update();
	}

	private Employee getEmpFromPicLabel(Label label) {
		for (Enumeration<Employee> keys = empsToPicLabels.keys(); keys.hasMoreElements();) {
			Employee keyEmp = keys.nextElement();
			if (empsToPicLabels.get(keyEmp) == label) {
				return keyEmp;
			}
		}
		return null;
	}

	private Employee getEmpFromPanel(Pane panel) {
		for (Enumeration<Employee> keys = empsToEmpPanels.keys(); keys.hasMoreElements();) {
			Employee keyEmp = keys.nextElement();
			if (empsToEmpPanels.get(keyEmp) == panel) {
				return keyEmp;
			}
		}
		for (Enumeration<Employee> keys = empsToPicPanels.keys(); keys.hasMoreElements();) {
			Employee keyEmp = keys.nextElement();
			if (empsToPicPanels.get(keyEmp) == panel) {
				return keyEmp;
			}
		}
		return null;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			if (event.getSource() instanceof Label) {
				Label label = (Label) event.getSource();
				Employee emp = getEmpFromPicLabel(label);
				if (emp != null) {
					if (event.isPrimaryButtonDown()) // left button clicked
					{
						mainGUIFrame.getTabPanel().setGUIChanged();
						mainGUIFrame.getTabPanel().setObjectInFocus(emp);
						mainGUIFrame.getAttributePanel().setGUIChanged();
						mainGUIFrame.getAttributePanel().setObjectInFocus(emp, JavaFXHelpers.createImage(TabPanel.getImage(emp)));
					} else if (event.isPopupTrigger() && (state.getClock().isStopped() == false)) // right-click
					{
						selectedEmp = emp;
						createPopupMenu(label, event.getX(), event.getY());
					}
				}
			} else if (event.getSource() instanceof Pane) {
				Pane pane = (Pane) event.getSource();
				Employee emp = getEmpFromPanel(pane);
				if (emp != null) {
					if (event.isPrimaryButtonDown()) // left button clicked
					{
						mainGUIFrame.getTabPanel().setGUIChanged();
						mainGUIFrame.getTabPanel().setObjectInFocus(emp);
						mainGUIFrame.getAttributePanel().setGUIChanged();
						mainGUIFrame.getAttributePanel().setObjectInFocus(emp,JavaFXHelpers.createImage(TabPanel.getImage(emp)));
					} else if (event.isPopupTrigger() && (state.getClock().isStopped() == false)) // right-click
					{
						selectedEmp = emp;
						createPopupMenu(pane, event.getX(), event.getY());
					}
				}
			}
		}
	}
}