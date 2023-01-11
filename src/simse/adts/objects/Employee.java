/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.objects;

import java.util.Vector;

import simse.gui.TrackPanel;

public abstract class Employee extends SSObject implements Cloneable {
	private Vector<String> menu;
	private String overheadText;
	public static final String IDLE_STRING = "I'm not doing anything right now";
	private TrackPanel track;

	public Employee() {
		menu = new Vector<String>();
		clearMenu();
		overheadText = new String();
		track = TrackPanel.getInstance();
	}

	public Object clone() {
		Employee cl = (Employee) (super.clone());
		Vector<String> clonedMenu = new Vector<String>();
		for (int i = 0; i < menu.size(); i++) {
			clonedMenu.add(menu.elementAt(i));
		}
		cl.menu = clonedMenu;
		cl.overheadText = overheadText;
		return cl;
	}

	public Vector<String> getMenu() {
		return menu;
	}

	public void clearMenu() {
		menu.removeAllElements();
		menu.add("Everyone stop what you're doing");
	}

	public boolean addMenuItem(String s) {
		for (int i = 0; i < menu.size(); i++) {
			String item = menu.elementAt(i);
			if (item.equals(s)) {
				return false;
			}
		}
		// insert at correct alpha order:
		for (int i = 0; i < menu.size(); i++) {
			String item = menu.elementAt(i);
			if (s.compareToIgnoreCase(item) < 0) { // should be inserted before
													// 'item'
				menu.insertElementAt(s, i);
				return true;
			}
		}
		// only reaches here if menu is empty or 's' should be placed at the end
		menu.add(s);
		return true;
	}

	public boolean removeMenuItem(String s) {
		for (int i = 0; i < menu.size(); i++) {
			String item = menu.elementAt(i);
			if (item.equals(s)) {
				menu.remove(item);
				return true;
			}
		}
		return false;
	}

	public String getOverheadText() {
		return overheadText;
	}
	
	public void setOverheadText(String s) {
		if ((s != null) && (s.length() > 0)) {
			if ((overheadText != null) && (overheadText.length() > 0)) {
				if (overheadText.equals(IDLE_STRING)) {
					overheadText = s;
				} else if (!overheadText.endsWith(s)) // string has not just
														// been said
				{
					overheadText = overheadText.concat(" AND " + s);
				}
			} else {
				overheadText = s;
			}
		}
	}

	public void setOverheadText(String s, String name) {
		track.addText(s, name);
		overheadText = s;
	}

	public void clearOverheadText() {
		overheadText = new String();
	}

}