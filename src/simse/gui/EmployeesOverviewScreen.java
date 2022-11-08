package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simse.adts.objects.Employee;
import simse.adts.objects.SoftwareEngineer;
import simse.logic.Logic;
import simse.state.State;

public class EmployeesOverviewScreen extends Stage implements EventHandler<MouseEvent> {
	State state;
	SimSEGUI gui;
	Logic logic;
	
	Label titleLabel;
	Button employeeTab;
	Button customerTab;
	Button moreDetail;
	BorderPane tablePane;
	
	TableModel tableModel;
	TableView table;
	
	VBox mainPane;

	public EmployeesOverviewScreen(State s, SimSEGUI gui, Logic l) {
		this.state = s;
		this.gui = gui;
		this.logic = l;
		this.setTitle("Employee Screen");
		
		mainPane = new VBox();
		BorderPane title = new BorderPane();
		titleLabel = new Label("Employee Screen");
		titleLabel.setFont(new Font(36));
		title.setCenter(titleLabel);
		mainPane.getChildren().add(title);
		
		HBox tabsPane = new HBox();
		tabsPane.setSpacing(0);
		employeeTab = new Button("Employees");
		employeeTab.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		employeeTab.setMinWidth(450);
		customerTab = new Button("Customers");
		customerTab.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		customerTab.setMinWidth(450);
		tabsPane.getChildren().addAll(employeeTab, customerTab);
		mainPane.getChildren().add(tabsPane);
		
		Separator separator = new Separator();
		separator.setPadding(new Insets(10, 0, 15, 0));
		mainPane.getChildren().add(separator);
		
		tableModel = new SoftwareEngineerTableModel(s);
		table = tableModel.createTable();

		// Create panes:
		tablePane = new BorderPane(table);
		tablePane.setCenter(table);
		mainPane.getChildren().add(tablePane);
		
		moreDetail = new Button ("More Detail on Selected Employee");
		moreDetail.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		mainPane.getChildren().add(moreDetail);
		
		Scene scene = new Scene(mainPane, 900, 500);
		this.setScene(scene);
	}

	@Override
	public void handle(MouseEvent evt) {
		Object source = evt.getSource();
		if (source == employeeTab) {
			mainPane.getChildren().remove(tablePane);
			tableModel = new SoftwareEngineerTableModel(state);
			table = tableModel.createTable();
			tablePane = new BorderPane(table);
			tablePane.setCenter(table);
			if (mainPane.getChildren().contains(moreDetail)) mainPane.getChildren().remove(moreDetail);
			mainPane.getChildren().add(tablePane);
			mainPane.getChildren().add(moreDetail);
		} else if (source == customerTab) {
			mainPane.getChildren().remove(tablePane);
			tableModel = new ACustomerTableModel(state);
			table = tableModel.createTable();
			tablePane = new BorderPane(table);
			tablePane.setCenter(table);
			mainPane.getChildren().add(tablePane);
			mainPane.getChildren().remove(moreDetail);
		} else if (source == moreDetail) {
			SoftwareEngineer selected = (SoftwareEngineer) table.getSelectionModel().getSelectedItem();
			if (selected == null) {
				Alert alert = new Alert(AlertType.WARNING, "Please select an employee to get detailed information on");
				alert.show();
			} else {
				EmployeeInfoScreen info = new EmployeeInfoScreen(state, gui, logic, selected);
				info.show();
			}
		}
	}

}