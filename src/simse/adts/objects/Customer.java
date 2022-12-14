/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.objects;

import simse.gui.TrackPanel;

public abstract class Customer extends SSObject implements Cloneable {
	private String overheadText;
	private TrackPanel track;

	public Customer() {
		overheadText = new String();
		track = TrackPanel.getInstance();
	}

	public Object clone() {
		Customer cl = (Customer) (super.clone());
		cl.overheadText = overheadText;
		return cl;
	}

	public String getOverheadText() {
		String temp = overheadText;
		overheadText = new String();
		return temp;
	}

	public void setOverheadText(String s) {
		overheadText = s;
	}
	
	public void setOverheadText(String s, String name) {
		track.addText(s, name);
	}

	public boolean hasOverheadText() {
		if (overheadText == null) {
			return false;
		} else {
			return true;
		}
	}
}