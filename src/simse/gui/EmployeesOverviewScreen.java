package simse.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simse.state.State;

public class EmployeesOverviewScreen extends Stage implements EventHandler<MouseEvent> {
	State state;
	
	Label titleLabel;
	Button employeeTab;
	Button customerTab;
	
	TableModel tableModel;
	TableView table;
	
	VBox mainPane;

	public EmployeesOverviewScreen(State s) {
		state = s;
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
		table.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

		// Create panes:
		BorderPane tablePane = new BorderPane(table);
		tablePane.setCenter(table);
		mainPane.getChildren().add(tablePane);
		
		Scene scene = new Scene(mainPane, 900, 500);
		this.setScene(scene);
	}

	@Override
	public void handle(MouseEvent evt) {
		Object source = evt.getSource();
		if (source == employeeTab) {
			tableModel = new SoftwareEngineerTableModel(state);
			table = tableModel.createTable();
			BorderPane tablePane = new BorderPane(table);
			tablePane.setCenter(table);
			mainPane.getChildren().remove(3);
			mainPane.getChildren().add(tablePane);
		} else if (source == customerTab) {
			tableModel = new ACustomerTableModel(state);
			table = tableModel.createTable();
			BorderPane tablePane = new BorderPane(table);
			tablePane.setCenter(table);
			mainPane.getChildren().remove(3);
			mainPane.getChildren().add(tablePane);
		}
	}

}
