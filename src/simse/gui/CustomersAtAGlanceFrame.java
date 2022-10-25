/* File generated by: simse.codegenerator.guigenerator.AtAGlanceFramesGenerator */
package simse.gui;

import simse.state.*;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.awt.Color;
import java.awt.Point;

public class CustomersAtAGlanceFrame extends Stage implements EventHandler<MouseEvent> {

	private State state;

	private Popup popup;
	private PopupListener popupListener;
	private TableView acustomerTable;
	private ACustomerTableModel acustomerModel;
	private TitledPane acustomerTitlePane;
	private Pane mainPane;

	private int realColumnIndex; // index of selected column
	private TableView selectedTable; // selected table

	public CustomersAtAGlanceFrame(State s, SimSEGUI gui) {
		state = s;
		// Set window title:
		setTitle("Customers At-A-Glance");

		// Create tables:
		int numCols;

		acustomerModel = new ACustomerTableModel(s);
		acustomerTable = new TableView(acustomerModel);
		acustomerTable.setColumnSelectionAllowed(false);
		acustomerTable.setRowSelectionAllowed(false);
		acustomerTable.addMouseListener(this);
		acustomerTable.getTableHeader().setReorderingAllowed(false);
		// make it so that the user can make each column disappear if they want:
		numCols = acustomerTable.getColumnCount();
		for (int i = 0; i < numCols; i++) {
			acustomerTable.getColumnModel().getColumn(i).setMinWidth(0);
		}

		// right click menu:
		popup = new Popup();
		popupListener = new PopupListener(popup, gui);

		// Create panes:
		ScrollPane acustomerPane = new ScrollPane(acustomerTable);

		// Table headers:
		acustomerTitlePane = new TitledPane("ACustomers:", acustomerPane);

		// Create main pane:
		mainPane = new VBox();

		// Add panes to main pane:
		mainPane.getChildren().add(acustomerTitlePane);
		Scene scene = new Scene(mainPane);
		this.setScene(scene);

		// Set main window frame properties:
//		setBackground(Color.white);
//		setContentPane(mainPane);
//		setVisible(false);
//		pack();
//		validate();

		resetHeight();
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
		Point p = me.getPoint();

		if (me.isPopupTrigger()) {
			if (me.getComponent().equals(acustomerTable)) // correct table
			{
				createPopupMenu(acustomerTable, p);
			}
		}
	}

	public void actionPerformed(ActionEvent e) // dealing with actions generated
												// by popup menus
	{
		Object source = e.getSource();
		if (source instanceof JMenuItem) {
			String itemText = ((JMenuItem) source).getText();
			if (itemText.equals("Hide")) {
				if (selectedTable != null) {
					selectedTable.getColumnModel().getColumn(realColumnIndex)
							.setMaxWidth(0);
				}
			} else // an item on the "Unhide" menu
			{
				if (selectedTable != null) {
					TableModel model = selectedTable.getModel();
					TableColumn column = null;
					if (model instanceof ACustomerTableModel) {
						column = selectedTable.getColumnModel()
								.getColumn(
										((ACustomerTableModel) selectedTable
												.getModel())
												.getColumnIndex(itemText));
					}
					if (column != null) {
						column.setMinWidth(0);
						column.setMaxWidth(2147483647);
						column.setPreferredWidth(selectedTable.getWidth()
								/ (selectedTable.getColumnCount()
										- getAllHiddenColumnIndices(
												selectedTable).size() + 1));
					}
				}
			}
		}
	}

	public void createPopupMenu(TableView table, Point p) {
		popup.removeAll();

		int colIndex = table.columnAtPoint(p);
		realColumnIndex = table.convertColumnIndexToModel(colIndex);

		Vector<Integer> hiddenCols = getAllHiddenColumnIndices(table);

		if ((realColumnIndex >= 0) || (hiddenCols.size() > 0)) // user clicked
																// on a column
																// and/or there
																// is at least
																// one hidden
																// column
		{
			if (realColumnIndex >= 0) {
				JMenuItem hideItem = new JMenuItem("Hide");
				hideItem.addActionListener(this);
				popup.add(hideItem);
			}

			if (hiddenCols.size() > 0) // there is at least one hidden column
			{
				JMenu unhideMenu = new JMenu("Unhide");
				for (int i = 0; i < hiddenCols.size(); i++) {
					int index = hiddenCols.elementAt(i).intValue();
					JMenuItem tempItem = new JMenuItem(
							table.getColumnName(index));
					tempItem.addActionListener(this);
					unhideMenu.add(tempItem);
				}
				if (popup.getComponents().length > 0) // already has the hide
														// menu item
				{
					popup.addSeparator();
				}
				popup.add(unhideMenu);
			}

			addMouseListener(popupListener);
			popup.show(table, (int) p.getX(), (int) p.getY());
			selectedTable = table;
			repaint();
		}
	}

	public void update() {
		DefaultTableCellRenderer rightAlignRenderer = new DefaultTableCellRenderer();
		rightAlignRenderer.setHorizontalAlignment(JLabel.RIGHT);
		acustomerModel.update();
		if (!state.getClock().isStopped()) { // game not over
		} else { // game over
		}
		acustomerTable.update(acustomerTable.getGraphics());
		resetHeight();
	}

	private void resetHeight() {
		// Set appropriate height:
		double height = 0;
		height += ((acustomerTable.getRowHeight() + (acustomerTable
				.getRowMargin() * 2)) * (acustomerTable.getRowCount() + 1));
		height += acustomerTitlePane.getSize().getHeight();

		mainPane.setPreferredSize(new Dimension((int) (mainPane.getSize()
				.getWidth()), (int) height));
		pack();
		validate();
		repaint();
	}

	private Vector<Integer> getAllHiddenColumnIndices(JTable table) {
		Vector<Integer> hiddenCols = new Vector<Integer>();
		int numCols = table.getColumnModel().getColumnCount();
		for (int i = 0; i < numCols; i++) {
			TableColumn col = table.getColumnModel().getColumn(i);
			if (col.getWidth() == 0) // hidden
			{
				hiddenCols.add(new Integer(i));
			}
		}
		return hiddenCols;
	}
}