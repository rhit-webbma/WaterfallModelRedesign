/* File generated by: simse.codegenerator.guigenerator.WorldGenerator */
package simse.gui;

import java.util.ArrayList;
import java.util.Vector;

import animations.Character1;
import animations.DisplayableCharacter;
import animations.Path1;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import simse.adts.objects.Employee;
import simse.gui.util.JavaFXHelpers;
import simse.logic.Logic;
import simse.state.State;

//import com.sun.javafx.tk.FontMetrics;
//import com.sun.javafx.tk.Toolkit;

public class World extends SimSEMap implements EventHandler<Event> {
	private int clickedHeightModifier = 5;
	private int clickedX;
	private int clickedY;
	public final int xViewable = 9;
	public final int yViewable = 9;
	
	private final double width = 1000;
	private final double height = 450;

	private final SimSEGUI mainGUIFrame;

	// used in drawing the speech bubble:
	public static final int FREE = 0;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	public static final int TOP = -1;
	public static final int BOTTOM = 1;

	private boolean overheadTextDisplayed; // whether or not there is overhead
											// text to display

	private ContextMenu popup;
	private PopupListener popupListener;

	private DisplayedEmployee selectedUser;

	// how much to shift the map when a resize of the screen occurs:
	private double xspacer;
	private double yspacer;
	private boolean employeeGone = false;
	private Image dbImage;
	private GraphicsContext dbGraphics;

	private EventHandler<ActionEvent> menuItemEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if (source instanceof MenuItem) {
				popupMenuActions((MenuItem) source);
			}
		}
	};

	public World(State s, Logic l, SimSEGUI parent) {
		super(s, l);
		mainGUIFrame = parent;
		overheadTextDisplayed = false;
//		int width = (int) getWidth();
//		int height = (int) getHeight();
		final Canvas canvas = new Canvas(width, height);
		dbGraphics = canvas.getGraphicsContext2D();
		
		Path newPath = new Path1();
		DisplayableCharacter char1 = new Character1(newPath, 40, 75);
		
		
		
		this.getChildren().add(canvas);
		this.getChildren().add(char1);
		char1.requestFocus();
		
		loadDefaultSettings();
		update();
		paint();
	}

	private void loadDefaultSettings() {
		selectedUser = null;
		setBackground(JavaFXHelpers.createBackgroundColor(Color.BLUE));
		addEventHandler(KeyEvent.ANY, this);
		addEventHandler(MouseEvent.ANY, this);
		setVisible(true);

		// right click menu:
		popup = new ContextMenu();
		popupListener = new PopupListener(popup, mainGUIFrame);
		popupListener.setEnabled(false);
		createPopupMenu();
	}

	public boolean overheadTextDisplayed() // returns true if there is overhead
											// text displayed, false otherwise
	{
		return overheadTextDisplayed;
	}

	public void createPopupMenu() {
		popup.getItems().removeAll();

		if (selectedUser != null) {
			Vector<String> menuItems = selectedUser.getEmployee().getMenu();
			for (int i = 0; i < menuItems.size(); i++) {
				String item = menuItems.elementAt(i);
				MenuItem tempItem = new MenuItem(item);
				tempItem.setOnAction(menuItemEvent);
				popup.getItems().add(tempItem);
			}
		}
		addEventHandler(MouseEvent.ANY, popupListener);
	}

	// double buffering to prevent flickering
	public void update(GraphicsContext gc) {
//		if (dbImage == null) {
//			dbImage = new Image(, getWidth(), getHeight(), true, true);
//		}

		// clear screen in background:
		dbGraphics.setFill(Color.BLACK);
//		dbGraphics.fillRect(0, 0, getWidth(), getHeight());
		dbGraphics.fillRect(0, 0, width, height);
		
		// draw elements in background:
		paint();
		// draw image on the screen:
		dbGraphics.drawImage(dbImage, 0, 0);

		if (employeeGone) // employee is about to disappear, need to sleep
							// thread so the user can see their overhead text
							// before they disappear
		{
			try {
				Thread.sleep(1000);
				employeeGone = false;
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void paint() {
//		int width = (int) getWidth();
//		int height = (int) getHeight();
		GraphicsContext gc = dbGraphics;

		xspacer = (width - MapData.X_MAPSIZE * MapData.TILE_SIZE) / 2;
		yspacer = (height - MapData.Y_MAPSIZE * MapData.TILE_SIZE) / 2;

		if (xspacer < 0)
			xspacer = 0;
		if (yspacer < 0)
			yspacer = 0;

		// draw the map:
		for (int i = 0; i < MapData.Y_MAPSIZE; i++) {
			for (int j = 0; j < MapData.X_MAPSIZE; j++) {
				gc.drawImage(mapRep[j][i].getBase(), xspacer + j * MapData.TILE_SIZE, yspacer + i * MapData.TILE_SIZE);
				gc.drawImage(mapRep[j][i].getFringe(), xspacer + j * MapData.TILE_SIZE,
						yspacer + i * MapData.TILE_SIZE);
			}
		}

		// draw employees:
		for (int i = 0; i < sopUsers.size(); i++) {
			DisplayedEmployee tmp = sopUsers.get(i);
			if (tmp.isDisplayed() && tmp.isActivated()) {
				gc.drawImage(tmp.getUserIcon(), xspacer + tmp.getXLocation() * MapData.TILE_SIZE,
						yspacer + tmp.getYLocation() * MapData.TILE_SIZE);
			}
		}

		// go through all employees and display their overhead text, if any:
		int numOverheadTexts = 0;
		for (int i = 0; i < sopUsers.size(); i++) {
			DisplayedEmployee tempEmp = sopUsers.get(i);
			String overheadText = tempEmp.getEmployee().getOverheadText();
			if ((overheadText != null) && (overheadText.length() > 0)) // employee
																		// has
																		// overhead
																		// text
			{
				numOverheadTexts++;
				drawText(overheadText, tempEmp.getXLocation(), tempEmp.getYLocation(), gc);
				if (state.getEmployeeStateRepository().getAll().contains(tempEmp.getEmployee()) == false) // employee
																											// is about
																											// to
																											// disappear
				{
					employeeGone = true;

				}
			}
		}
		if (numOverheadTexts > 0) {
			overheadTextDisplayed = true;
		} else // no overhead text to display
		{
			overheadTextDisplayed = false;
		}

		ArrayList<DisplayedEmployee> oldSopUsers = new ArrayList<DisplayedEmployee>(sopUsers);
		sopUsers.clear();

		// go through sop users and make sure that they are still in the state
		// (haven't been destroyed):
		for (int i = 0; i < oldSopUsers.size(); i++) {
			DisplayedEmployee tempDisEmp = oldSopUsers.get(i);
			if (state.getEmployeeStateRepository().getAll().contains(tempDisEmp.getEmployee())) // employee is still
																								// there
			{
				sopUsers.add(tempDisEmp);
			}
		}
		// check if any new emps have been added:
		if (sopUsers.size() < state.getEmployeeStateRepository().getAll().size()) // new emps have been added
		{
			Vector<Employee> allEmps = state.getEmployeeStateRepository().getAll();
			for (int i = 0; i < allEmps.size(); i++) {
				Employee tempEmp = allEmps.elementAt(i);
				boolean newEmp = true;
				for (int j = 0; j < sopUsers.size(); j++) {
					DisplayedEmployee tempDisEmp = sopUsers.get(j);
					if (tempDisEmp.getEmployee().equals(tempEmp)) {
						newEmp = false;
						break;
					}
				}
				if (newEmp) {
					// create new DisplayedEmployee and add to sopUsers:
					DisplayedEmployee newDisEmp = new DisplayedEmployee(tempEmp, getImage(tempEmp), true, true,
							getXYCoordinates(tempEmp)[0], getXYCoordinates(tempEmp)[1]);
					sopUsers.add(newDisEmp);
				}
			}
		}
	}

	// String s - text to display
	// int xLoc - x coordinate of the employee to be drawn. ->
	// UserData.xLocation
	// int yLoc - y coordinate of the employee to be drawn. ->
	// UserData.yLocation
	// Graphics g - use the graphics object from the paintComponent(Graphics g)
	public void drawText(String s, int xLoc, int yLoc, GraphicsContext gc) {
		// do not draw empty strings:
		if (s == null || s.equals("")) {
			return;
		}

		// variables for starting x, starting y, width w, height h:
		int x = FREE, y = FREE, w = 150, h = 14;
		Image speech = MapData.speechTR;

		// used to determine how much to shift the bubble:
		int xshift, yshift;

		// stores the strings
		int strlength = s.length() + 1;
		int lengthOfOneLine = 28;
		int scount = 0;
		float tmpW = 0;

		ArrayList<String> strList = new ArrayList<String>();
//		FontMetrics f = Toolkit.getToolkit().getFontLoader().getFontMetrics(dbGraphics.getFont());
		Font f = dbGraphics.getFont();
		
		// if string is longer than <lengthofOneLine> characters, break it into
		// several lines
		while (strlength > lengthOfOneLine) {
			String temp = s.substring(0, lengthOfOneLine).trim();
			int space = temp.lastIndexOf(" ");
			temp = s.substring(0, space);

			tmpW = s.length();
//			tmpW = f.computeStringWidth(temp) + 4; // offset of 4 for spacing purposes
			

			strList.add(temp);
			scount++;
			s = s.substring(space + 1, strlength - 1);
			strlength = s.length() + 1;
		}
//		tmpW = f.computeStringWidth(s) + 4;
		tmpW = s.length();

		strList.add(s); // append either the whole string or the rest of the
						// string
		scount++;
		String[] strings = strList.toArray(new String[1]);

		h = h + (12 * (scount - 1)); // modify the box to match the string

		// this checks to determine where you can draw makes sure the speech
		// bubble
		// isn't drawn off the map
		// 0 - any value, left/right (x) or top/bottom (y)
		// 1 - must be either left (x), top (y)
		// 2 - must be either right (x), bottom (y)

		// determine which of the 4 types to draw the bubble
		if (xLoc < 3)
			x = RIGHT; // must be on right side
		else if (xLoc > xViewable - 3) // may change to visible width of the
										// screen
			x = LEFT; // must be on left side
		if (yLoc < 1) // can't be top
			y = BOTTOM; // must be on bottom
		if (yLoc > yViewable - 2) // may change to visible height of the screen
			y = TOP; // must be on top

		boolean checkY = true;

		// if x is free check if the bubble may conflict with anyone
		if (x == FREE) {
			boolean lconflict = false;
			int yOffset = y;

			// yOffset may be either top or bottom depending on above if/else
			// block
			if (y == FREE)
				yOffset = TOP;

			boolean rconflict = false;

			// test if it conflicts with top left or bottom left
			for (int i = 3; i > 0 && !rconflict; i--) {
				for (int j = 0; j < sopUsers.size(); j++) {
					DisplayedEmployee tmp = sopUsers.get(j);
					boolean clash = tmp.checkXYLocations(xLoc + i, yLoc + (2 * yOffset))
							|| tmp.checkXYLocations(xLoc + i, yLoc + yOffset) || tmp.checkXYLocations(xLoc + i, yLoc);
					if (clash && tmp.isActivated())

					{
						// if a conflict occurs here, it can't be on the right
						// side either
						rconflict = true;
						x = LEFT;
					}
				}
			}

			// can be on right side
			if (!rconflict) {
				x = RIGHT;
				y = yOffset;
				checkY = false;
			} else // check the right side
			{
				// test if it conflicts with top left or bottom left (depending
				// on yOffset)
				for (int i = 4; i > 0 && !lconflict; i--) {
					for (int j = 0; j < sopUsers.size(); j++) {
						DisplayedEmployee tmp = sopUsers.get(j);
						boolean clash = tmp.checkXYLocations(xLoc - i, yLoc + (2 * yOffset))
								|| tmp.checkXYLocations(xLoc - i, yLoc + yOffset)
								|| tmp.checkXYLocations(xLoc - i, yLoc);
						if (clash && tmp.isActivated())

						{

							lconflict = true;
							x = FREE;
						}
					}
				}

				// doesn't conflict on left side, no need to check other half if
				// y is free
				if (!lconflict) {
					x = LEFT;
					y = yOffset;
					checkY = false;
				}
			}
		}
		// same for y if y is free
		if (y == FREE && checkY) {
			int xOffset = x;
			int yOffset = TOP;

			// if x is still free after above check, it means top left and top
			// right
			// are blocked so on checks left are bottom left and bottom right
			if (x == FREE) {
				xOffset = LEFT;
				yOffset = BOTTOM;
			}

			// x is fixed, y is either up or down
			if (x == LEFT) {
				boolean lconflict = false;

				// testing top left / bottom left
				for (int i = 4; i > 0 && !lconflict; i--) {
					for (int j = 0; j < sopUsers.size(); j++) {
						DisplayedEmployee tmp = sopUsers.get(j);
						boolean clash = tmp.checkXYLocations(xLoc - i, yLoc + (2 * yOffset))
								|| tmp.checkXYLocations(xLoc - i, yLoc + yOffset)
								|| tmp.checkXYLocations(xLoc - i, yLoc);
						if (clash && tmp.isActivated())

						{
							// if a conflict occurs here, it can't be on the
							// right side either
							lconflict = true;
						}
					}
				}

				if (!lconflict)
					y = yOffset;
				else
					y = -yOffset;
			} else if (x == RIGHT) {
				boolean rconflict = false;

				// testing top left / bottom left
				for (int i = 3; i > 0 && !rconflict; i--) {
					for (int j = 0; j < sopUsers.size(); j++) {
						DisplayedEmployee tmp = sopUsers.get(j);
						boolean clash = tmp.checkXYLocations(xLoc + i, yLoc + (2 * yOffset))
								|| tmp.checkXYLocations(xLoc + i, yLoc + yOffset)
								|| tmp.checkXYLocations(xLoc + i, yLoc);
						if (clash && tmp.isActivated())

						{
							// if a conflict occurs here, it can't be on the
							// right side either
							rconflict = true;
						}
					}
				}

				if (!rconflict)
					y = yOffset;
				else
					y = -yOffset;
			} else // both x and y are free, so it's either bottom left or
					// bottom right
			{
				boolean rconflict = false;

				// testing top left / bottom left
				for (int i = 3; i > 0 && !rconflict; i--) {
					for (int j = 0; j < sopUsers.size(); j++) {
						DisplayedEmployee tmp = sopUsers.get(j);
						boolean clash = tmp.checkXYLocations(xLoc + i, yLoc + (2 * yOffset))
								|| tmp.checkXYLocations(xLoc + i, yLoc + yOffset)
								|| tmp.checkXYLocations(xLoc + i, yLoc);
						if (clash && tmp.isActivated())

						{
							// if a conflict occurs here, it can't be on the
							// right side either
							rconflict = true;
						}
					}
				}

				if (!rconflict) {
					x = RIGHT;
					y = BOTTOM;
				} else {
					x = LEFT;
					y = BOTTOM;
				}
			}
		}

		// determine the speech bubble direction
		if (x == LEFT && y == TOP)
			speech = MapData.speechTL;
		else if (x == RIGHT && y == TOP)
			speech = MapData.speechTR;
		else if (x == LEFT && y == BOTTOM)
			speech = MapData.speechBL;
		else if (x == RIGHT && y == BOTTOM)
			speech = MapData.speechBR;

		// determine where to draw the bubble
		// the shifts to x or y are used to place the message
		// so that it doesn't completely cover the user object
		if (x == LEFT) {
			x = (xLoc - 2) * MapData.TILE_SIZE;
			xshift = w - 26;
		} else {
			x = xLoc * MapData.TILE_SIZE;
			xshift = 6;
		}

		if (y == TOP) {
			y = (yLoc - 1) * MapData.TILE_SIZE;
			yshift = h;
		} else {
			y = (yLoc + 1) * MapData.TILE_SIZE;
			yshift = -19;
		}

		x += xspacer;
		y += yspacer;
		gc.setFill(new Color(0.9, 0.94, 1, 1));
		gc.fillRoundRect(x, y, w, h, 4, 4);
		gc.setStroke(Color.rgb(0, 30, 110, 1));
		gc.strokeRoundRect(x, y, w, h, 8, 8);
		gc.drawImage(speech, x + xshift, y + yshift);
		gc.setStroke(Color.BLACK);

		for (int i = 0; i < scount; i++) {
			// space similar to a carriage return add 1 for first line
			int yl = 12 * (i + 1);
			gc.strokeText(strings[i], x + 2, y + yl);
		}
	}
	
	public void popupMenuActions(MenuItem source) {
		MenuItem item = (MenuItem) source;
		logic.getMenuInputManager().menuItemSelected(selectedUser.getEmployee(), item.getText(), mainGUIFrame);
		update();
	}

	public void update() {
		GraphicsContext gc = dbGraphics;
		if (gc != null) {
			update(gc);
		} else {
			paint();
		}
		if (state.getClock().isStopped()) {
			popupListener.setEnabled(false);
		}
	}

	@Override
	public void handle(Event event) {
		if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			MouseEvent mEvent = (MouseEvent) event;
			// -5 is the offset for the border around the GUI
			clickedX = (int) ((mEvent.getX() - xspacer - 5) / MapData.TILE_SIZE);
			clickedY = (int) ((mEvent.getY() - yspacer - clickedHeightModifier) / MapData.TILE_SIZE);

			if (mEvent.isPrimaryButtonDown()) // left button clicked
			{
				for (int i = 0; i < sopUsers.size(); i++) {
					DisplayedEmployee tmp = sopUsers.get(i);
					if (tmp.checkXYLocations(clickedX, clickedY) && tmp.isActivated()) {
						selectedUser = tmp;
						i = sopUsers.size();
						mainGUIFrame.getTabPanel().setGUIChanged();
						mainGUIFrame.getTabPanel().setObjectInFocus(tmp.getEmployee());
						mainGUIFrame.getAttributePanel().setGUIChanged();
						mainGUIFrame.getAttributePanel().setObjectInFocus(tmp.getEmployee(), tmp.getUserIcon());
					}
				}
			}

			else if (state.getClock().isStopped() == false) // clock not stopped,
															// and not left button
															// click
			{
				boolean found = false;
				for (int i = 0; i < sopUsers.size(); i++) {
					DisplayedEmployee tmp = sopUsers.get(i);
					if (tmp.checkXYLocations(clickedX, clickedY) && tmp.isActivated()) {
						selectedUser = tmp;
						popupListener.setEnabled(true);
						found = true;
						i = sopUsers.size();

						createPopupMenu();
					}
				}

				// did not click on a User object, disable right click
				if (!found)
					popupListener.setEnabled(false);

				paint();
			}
		}
	}
}