/* File generated by: simse.codegenerator.guigenerator.AtAGlanceFramesGenerator */
package simse.gui;

import simse.state.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.*;
import java.text.*;
import java.awt.Color;


public class ArtifactsAtAGlanceFrame extends Stage implements EventHandler<MouseEvent> {

	private State state;

	private ContextMenu popup;
	private PopupListener popupListener;
	private TableView requirementsdocumentTable;
	private RequirementsDocumentTableModel requirementsdocumentModel;
	private TitledPane requirementsdocumentTitlePane;
	private TableView designdocumentTable;
	private DesignDocumentTableModel designdocumentModel;
	private TitledPane designdocumentTitlePane;
	private TableView codeTable;
	private CodeTableModel codeModel;
	private TitledPane codeTitlePane;
	private TableView systemtestplanTable;
	private SystemTestPlanTableModel systemtestplanModel;
	private TitledPane systemtestplanTitlePane;
	private VBox mainPane;

	private int realColumnIndex; // index of selected column
	private TableView selectedTable; // selected table

	public ArtifactsAtAGlanceFrame(State s, SimSEGUI gui) {
		state = s;
		// Set window title:
		this.setTitle("Artifacts At-A-Glance");
//		setTitle("Artifacts At-A-Glance");

		// Create tables:
		int numCols;
		ObservableList<Object> data;

		requirementsdocumentModel = new RequirementsDocumentTableModel(s);
		requirementsdocumentTable = requirementsdocumentModel.createTable();
		
//		for(int i = 0; i < requirementsdocumentModel.getColumnCount(); i++) {
//			TableColumn newCol = new TableColumn(requirementsdocumentModel.getColumnName(i));
//			requirementsdocumentTable.getColumns().add(newCol);
//		}
//		
//		data = FXCollections.observableArrayList();
//		
//		for(Vector<Object> vectorList : requirementsdocumentModel.getData()) {
//			data.add(vectorList);
//		}
//		
//		requirementsdocumentTable.setItems(data);
//		requirementsdocumentTable.getSelectionModel().setCellSelectionEnabled(true);
		
//		requirementsdocumentTable = new JTable(requirementsdocumentModel);
//		requirementsdocumentTable.setColumnSelectionAllowed(false);
//		requirementsdocumentTable.setRowSelectionAllowed(false);
//		requirementsdocumentTable.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
//		requirementsdocumentTable.getSelectionModel().get
		
//		TODO: requirementsdocumentTable.getTableHeader().setReorderingAllowed(false);
		// make it so that the user can make each column disappear if they want:
//		numCols = requirementsdocumentTable.getColumns().size();
//		TODO: for (int i = 0; i < numCols; i++) {
//			requirementsdocumentTable.getColumns().get(i)
//					.setMinWidth(0);
//		}
		
		designdocumentModel = new DesignDocumentTableModel(s);
		designdocumentTable = designdocumentModel.createTable();
//		designdocumentTable.setColumnSelectionAllowed(false);
//		designdocumentTable.setRowSelectionAllowed(false);
//		designdocumentTable.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
//		
//		for(int i = 0; i < designdocumentModel.getColumnCount(); i++) {
//			TableColumn newCol = new TableColumn(designdocumentModel.getColumnName(i));
//			designdocumentTable.getColumns().add(newCol);
//		}
//		
//		data = FXCollections.observableArrayList();
//		
//		for(Vector<Object> vectorList : designdocumentModel.getData()) {
//			data.add(vectorList);
//		}
//		
//		designdocumentTable.setItems(data);
//		designdocumentTable.getSelectionModel().setCellSelectionEnabled(true);
//		
//		requirementsdocumentTable = new JTable(requirementsdocumentModel);
//		requirementsdocumentTable.setColumnSelectionAllowed(false);
//		requirementsdocumentTable.setRowSelectionAllowed(false);
//		requirementsdocumentTable.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
//		requirementsdocumentTable.getSelectionModel().get
		
//		TODO: requirementsdocumentTable.getTableHeader().setReorderingAllowed(false);
		// make it so that the user can make each column disappear if they want:
//		numCols = designdocumentTable.getColumns().size();
		
//		designdocumentTable.getTableHeader().setReorderingAllowed(false);
//		// make it so that the user can make each column disappear if they want:
//		numCols = designdocumentTable.getColumnCount();
//		for (int i = 0; i < numCols; i++) {
//			designdocumentTable.getColumnModel().getColumn(i).setMinWidth(0);
//		}
		
		
		codeModel = new CodeTableModel(s);
		codeTable = codeModel.createTable();
//		codeTable.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
//		
//		for(int i = 0; i < codeModel.getColumnCount(); i++) {
//			TableColumn newCol = new TableColumn(codeModel.getColumnName(i));
//			codeTable.getColumns().add(newCol);
//		}
//		
//		data = FXCollections.observableArrayList();
//		
//		for(Vector<Object> vectorList : codeModel.getData()) {
//			data.add(vectorList);
//		}
//		
//		codeTable.setItems(data);
//		codeTable.getSelectionModel().setCellSelectionEnabled(true);
		
//		codeTable.setColumnSelectionAllowed(false);
//		codeTable.setRowSelectionAllowed(false);
//		codeTable.addMouseListener(this);
//		codeTable.getTableHeader().setReorderingAllowed(false);
		// make it so that the user can make each column disappear if they want:
//		numCols = codeTable.getColumnCount();
//		for (int i = 0; i < numCols; i++) {
//			codeTable.getColumnModel().getColumn(i).setMinWidth(0);
//		}
		
		
		systemtestplanModel = new SystemTestPlanTableModel(s);
		systemtestplanTable = systemtestplanModel.createTable();
//		systemtestplanTable.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
////		systemtestplanTable.setColumnSelectionAllowed(false);
////		systemtestplanTable.setRowSelectionAllowed(false);
////		systemtestplanTable.addMouseListener(this);
////		systemtestplanTable.getTableHeader().setReorderingAllowed(false);
//		// make it so that the user can make each column disappear if they want:
//		for(int i = 0; i < systemtestplanModel.getColumnCount(); i++) {
//			TableColumn newCol = new TableColumn(systemtestplanModel.getColumnName(i));
//			systemtestplanTable.getColumns().add(newCol);
//		}
//		
//		data = FXCollections.observableArrayList();
//		
//		for(Vector<Object> vectorList : systemtestplanModel.getData()) {
//			data.add(vectorList);
//		}
//		
//		systemtestplanTable.setItems(data);
//		systemtestplanTable.getSelectionModel().setCellSelectionEnabled(true);
		
//		numCols = systemtestplanTable.getColumnCount();
//		for (int i = 0; i < numCols; i++) {
//			systemtestplanTable.getColumnModel().getColumn(i).setMinWidth(0);
//		}

		// right click menu:
		popup = new ContextMenu();
//		popupListener = new PopupListener(popup, gui);

		// Create panes:
		ScrollPane requirementsdocumentPane = new ScrollPane(requirementsdocumentTable);
		ScrollPane designdocumentPane = new ScrollPane(designdocumentTable);
		ScrollPane codePane = new ScrollPane(codeTable);
		ScrollPane systemtestplanPane = new ScrollPane(systemtestplanTable);

		// Table headers:
		requirementsdocumentTitlePane = new TitledPane("RequirementsDocuments:", requirementsdocumentPane);
//		requirementsdocumentTitlePane.add(new JLabel("RequirementsDocuments:"));
		designdocumentTitlePane = new TitledPane("DesignDocuments:", designdocumentPane);
//		designdocumentTitlePane.add(new JLabel("DesignDocuments:"));
		codeTitlePane = new TitledPane("Codes:", codePane);
//		codeTitlePane.add(new JLabel("Codes:"));
		systemtestplanTitlePane = new TitledPane("SystemTestPlans:", systemtestplanPane);
//		systemtestplanTitlePane.add(new JLabel("SystemTestPlans:"));

		// Create main pane:
		mainPane = new VBox();
//		mainPane.setLayout(new S(mainPane, BoxLayout.Y_AXIS));

		// Add panes to main pane:
		mainPane.getChildren().add(requirementsdocumentTitlePane);
//		mainPane.add(requirementsdocumentPane);
		mainPane.getChildren().add(designdocumentTitlePane);
//		mainPane.add(designdocumentPane);
		mainPane.getChildren().add(codeTitlePane);
//		mainPane.add(codePane);
		mainPane.getChildren().add(systemtestplanTitlePane);
//		mainPane.add(systemtestplanPane);

		// Set main window frame properties:
//		setBackground(Color.white);
//		setContentPane(mainPane);
//		setVisible(false);
//		pack();
//		validate();

//		resetHeight();
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

//	public void mouseReleased(MouseEvent me) {
//		Point p = me.getPoint();
//
//		if (me.isPopupTrigger()) {
//			if (me.getComponent().equals(requirementsdocumentTable)) // correct
//																		// table
//			{
//				createPopupMenu(requirementsdocumentTable, p);
//			} else if (me.getComponent().equals(designdocumentTable)) // correct
//																		// table
//			{
//				createPopupMenu(designdocumentTable, p);
//			} else if (me.getComponent().equals(codeTable)) // correct table
//			{
//				createPopupMenu(codeTable, p);
//			} else if (me.getComponent().equals(systemtestplanTable)) // correct
//																		// table
//			{
//				createPopupMenu(systemtestplanTable, p);
//			}
//		}
//	}

//	public void actionPerformed(ActionEvent e) // dealing with actions generated
//												// by popup menus
//	{
//		Object source = e.getSource();
//		if (source instanceof JMenuItem) {
//			String itemText = ((JMenuItem) source).getText();
//			if (itemText.equals("Hide")) {
//				if (selectedTable != null) {
//					selectedTable.getColumnModel().getColumn(realColumnIndex)
//							.setMaxWidth(0);
//				}
//			} else // an item on the "Unhide" menu
//			{
//				if (selectedTable != null) {
//					TableModel model = selectedTable.getModel();
//					TableColumn column = null;
//					if (model instanceof RequirementsDocumentTableModel) {
//						column = selectedTable.getColumnModel().getColumn(
//								((RequirementsDocumentTableModel) selectedTable
//										.getModel()).getColumnIndex(itemText));
//					} else if (model instanceof DesignDocumentTableModel) {
//						column = selectedTable.getColumnModel().getColumn(
//								((DesignDocumentTableModel) selectedTable
//										.getModel()).getColumnIndex(itemText));
//					} else if (model instanceof CodeTableModel) {
//						column = selectedTable.getColumnModel().getColumn(
//								((CodeTableModel) selectedTable.getModel())
//										.getColumnIndex(itemText));
//					} else if (model instanceof SystemTestPlanTableModel) {
//						column = selectedTable.getColumnModel().getColumn(
//								((SystemTestPlanTableModel) selectedTable
//										.getModel()).getColumnIndex(itemText));
//					}
//					if (column != null) {
//						column.setMinWidth(0);
//						column.setMaxWidth(2147483647);
//						column.setPreferredWidth(selectedTable.getWidth()
//								/ (selectedTable.getColumnCount()
//										- getAllHiddenColumnIndices(
//												selectedTable).size() + 1));
//					}
//				}
//			}
//		}
//	}

	public void createPopupMenu(TableView table, Point2D p) {
		
		popup.getItems().clear();
		
		int colIndex = table.columnAtPoint(p);
		realColumnIndex = table.cnvertColumnIndexToModel(colIndex);

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
		requirementsdocumentModel.update();
		if (!state.getClock().isStopped()) { // game not over
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		} else { // game over
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("NumUnknownErrors"))
					.setCellRenderer(rightAlignRenderer);
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("PercentErroneous"))
					.setCellRenderer(rightAlignRenderer);
			requirementsdocumentTable
					.getColumnModel()
					.getColumn(
							requirementsdocumentModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		}
		requirementsdocumentTable.update(requirementsdocumentTable
				.getGraphics());
		designdocumentModel.update();
		if (!state.getClock().isStopped()) { // game not over
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		} else { // game over
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("NumUnknownErrors"))
					.setCellRenderer(rightAlignRenderer);
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("PercentErroneous"))
					.setCellRenderer(rightAlignRenderer);
			designdocumentTable
					.getColumnModel()
					.getColumn(
							designdocumentModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		}
		designdocumentTable.update(designdocumentTable.getGraphics());
		codeModel.update();
		if (!state.getClock().isStopped()) { // game not over
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("PercentIntegrated"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
		} else { // game over
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("PercentIntegrated"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("NumUnknownErrors"))
					.setCellRenderer(rightAlignRenderer);
			codeTable.getColumnModel()
					.getColumn(codeModel.getColumnIndex("PercentErroneous"))
					.setCellRenderer(rightAlignRenderer);
		}
		codeTable.update(codeTable.getGraphics());
		systemtestplanModel.update();
		if (!state.getClock().isStopped()) { // game not over
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		} else { // game over
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("NumKnownErrors"))
					.setCellRenderer(rightAlignRenderer);
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("NumUnknownErrors"))
					.setCellRenderer(rightAlignRenderer);
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("PercentErroneous"))
					.setCellRenderer(rightAlignRenderer);
			systemtestplanTable
					.getColumnModel()
					.getColumn(
							systemtestplanModel
									.getColumnIndex("PercentComplete"))
					.setCellRenderer(rightAlignRenderer);
		}
		systemtestplanTable.update(systemtestplanTable.getGraphics());
		resetHeight();
	}

//	private void resetHeight() {
//		// Set appropriate height:
//		double height = 0;
//		
//		height += ((requirementsdocumentTable.getRowHeight() + (requirementsdocumentTable
//				.getRowMargin() * 2)) * (requirementsdocumentTable
//				.getRowCount() + 1));
//		height += requirementsdocumentTitlePane.getSize().getHeight();
//		height += ((designdocumentTable.getRowHeight() + (designdocumentTable
//				.getRowMargin() * 2)) * (designdocumentTable.getRowCount() + 1));
//		height += designdocumentTitlePane.getSize().getHeight();
//		height += ((codeTable.getRowHeight() + (codeTable.getRowMargin() * 2)) * (codeTable
//				.getRowCount() + 1));
//		height += codeTitlePane.getSize().getHeight();
//		height += ((systemtestplanTable.getRowHeight() + (systemtestplanTable
//				.getRowMargin() * 2)) * (systemtestplanTable.getRowCount() + 1));
//		height += systemtestplanTitlePane.getSize().getHeight();
//
//		mainPane.setPreferredSize(new Dimension((int) (mainPane.getSize()
//				.getWidth()), (int) height));
//		pack();
//		validate();
//		repaint();
//	}

	private Vector<Integer> getAllHiddenColumnIndices(TableView table) {
		Vector<Integer> hiddenCols = new Vector<Integer>();
		int numCols = table.getColumns().size();
		for (int i = 0; i < numCols; i++) {
			TableColumn col = (TableColumn) table.getColumns().get(i);
			if (col.getWidth() == 0) // hidden
			{
				hiddenCols.add(new Integer(i));
			}
		}
		return hiddenCols;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
}
