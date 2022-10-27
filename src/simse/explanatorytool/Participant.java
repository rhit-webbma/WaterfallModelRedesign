package simse.explanatorytool;

import javafx.beans.property.SimpleStringProperty;

public class Participant {
	
	private SimpleStringProperty status;
	private SimpleStringProperty title1;
	private SimpleStringProperty title2;

	public Participant(String status, String title1, String title2) {
		this.status = new SimpleStringProperty(status);
		this.title1 = new SimpleStringProperty(title1);
		this.title2 = new SimpleStringProperty(title2);
	}
	
	public String getStatus() {
		return status.get();
	}
	public void setStatus(SimpleStringProperty status) {
		this.status = status;
	}
	public String getTitle1() {
		return title1.get();
	}
	public void setTitle1(SimpleStringProperty title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2.get();
	}
	public void setTitle2(SimpleStringProperty title2) {
		this.title2 = title2;
	}
	
}
