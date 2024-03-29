/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.objects;

import java.util.Vector;

import simse.gui.TrackPanel;

public abstract class Employee extends SSObject implements Cloneable {
	private Vector<String> menu;
	private String overheadText;
	public static final String IDLE_STRING = "I'm not doing anything right now";
	private TrackPanel track;
	private String name;
	private double energy;
	private double mood;
	private String requirementsexperience;
	private String designexperience;
	private String codingexperience;
	private String testingexperience;
	private double payrate;
	
	public Employee(String name,
						double energy,
						double mood,
						String requirementsexperience,
						String designexperience,
						String codingexperience,
						String testingexperience,
						double payrate) {
		menu = new Vector<String>();
		clearMenu();
		overheadText = new String();
		track = TrackPanel.getInstance();
		this.name = name;
		this.energy = energy;
		this.mood = mood;
		this.requirementsexperience = requirementsexperience;
		this.designexperience = designexperience;
		this.codingexperience = codingexperience;
		this.testingexperience = testingexperience;
		this.payrate = payrate;
	}

	public Object clone() {
		Employee cl = (Employee) (super.clone());
		Vector<String> clonedMenu = new Vector<String>();
		for (int i = 0; i < menu.size(); i++) {
			clonedMenu.add(menu.elementAt(i));
		}
		cl.menu = clonedMenu;
		cl.overheadText = overheadText;
		cl.name = name;
		cl.energy = energy;
		cl.mood = mood;
		cl.requirementsexperience = requirementsexperience;
		cl.designexperience = designexperience;
		cl.codingexperience = codingexperience;
		cl.testingexperience = testingexperience;
		cl.payrate = payrate;
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
	
	public String getName() {
		return name;
	}

	public void setName(String a) {
		name = a;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double a) {
		if (a < 0.0) {
			energy = 0.0;
		} else if (a > 1.0) {
			energy = 1.0;
		} else {
			energy = a;
		}
	}

	public double getMood() {
		return mood;
	}

	public void setMood(double a) {
		if (a < 0.0) {
			mood = 0.0;
		} else if (a > 1.0) {
			mood = 1.0;
		} else {
			mood = a;
		}
	}

	public String getRequirementsExperience() {
		return requirementsexperience;
	}

	public void setRequirementsExperience(String a) {
		requirementsexperience = a;
	}

	public String getDesignExperience() {
		return designexperience;
	}

	public void setDesignExperience(String a) {
		designexperience = a;
	}

	public String getCodingExperience() {
		return codingexperience;
	}

	public void setCodingExperience(String a) {
		codingexperience = a;
	}

	public String getTestingExperience() {
		return testingexperience;
	}

	public void setTestingExperience(String a) {
		testingexperience = a;
	}

	public double getPayRate() {
		return payrate;
	}

	public void setPayRate(double a) {
		if (a < 0.0) {
			payrate = 0.0;
		} else {
			payrate = a;
		}
	}
}