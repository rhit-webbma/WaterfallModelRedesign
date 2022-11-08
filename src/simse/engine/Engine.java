/* File generated by: simse.codegenerator.enginegenerator.EngineGenerator */
package simse.engine;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import simse.adts.objects.ACustomer;
import simse.adts.objects.AutomatedTestingTool;
import simse.adts.objects.Code;
import simse.adts.objects.DesignDocument;
import simse.adts.objects.DesignEnvironment;
import simse.adts.objects.IDE;
import simse.adts.objects.RequirementsCaptureTool;
import simse.adts.objects.RequirementsDocument;
import simse.adts.objects.SEProject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.SystemTestPlan;
import simse.gui.SimSEGUI;
import simse.logic.Logic;
import simse.state.State;

public class Engine extends TimerTask implements EventHandler<ActionEvent> {
	private Logic logic;
	private State state;
	private SimSEGUI gui;
	private int numSteps;
	private boolean stopClock;
	private boolean stopAtEvents;
	private Timer timer;

	public Engine(Logic l, State s) {
		numSteps = 0;
		logic = l;
		state = s;
		timer = new Timer();
		timer.scheduleAtFixedRate(this, 50, 50);
		SoftwareEngineer a0 = new SoftwareEngineer("Andre", 1.0, 0.9, 1.0,
				"10 years", "11 years, considers himself an expert",
				"7 years, fast but careless at times", "9 years", 0.9, 0.9,
				0.8, 0.8, 0.05, 0.05, 0.2, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, false, 35.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a0);
		SoftwareEngineer a1 = new SoftwareEngineer("Anita", 0.7, 0.6, 1.0,
				"8 years", "5 years", "2 years, hates coding", "6 months", 0.8,
				0.5, 0.3, 0.1, 0.005, 0.1, 0.25, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, false, 33.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a1);
		SoftwareEngineer a2 = new SoftwareEngineer("Calvin", 0.3, 0.6, 1.0,
				"9 years, considers himself an expert", "8 months", "6 years",
				"2 weeks", 0.9, 0.1, 0.7, 0.1, 0.05, 0.4, 0.1, 0.6, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 32.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a2);
		SoftwareEngineer a3 = new SoftwareEngineer("Emily", 0.7, 0.8, 1.0,
				"3 years", "5 years", "6 years", "1.5 years", 0.3, 0.6, 0.7,
				0.3, 0.05, 0.1, 0.1, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, false, 30.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a3);
		SoftwareEngineer a4 = new SoftwareEngineer("Mimi", 1.0, 0.8, 1.0,
				"3 months, beginner", "5 months, beginner",
				"3 months, beginner", "8 years, testing is her life", 0.1, 0.2,
				0.3, 0.95, 0.15, 0.1, 0.15, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, false, 20.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a4);
		SoftwareEngineer a5 = new SoftwareEngineer("Pedro", 0.5, 0.4, 1.0,
				"7 years", "2 years, but hates design", "8 years", "15 years",
				0.7, 0.2, 0.8, 1.0, 0.1, 0.25, 0.2, 0.01, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, false, 28.5);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a5);
		SoftwareEngineer a6 = new SoftwareEngineer("Roger", 0.3, 0.8, 1.0,
				"Beginner", "Beginner", "Beginner", "Beginner", 0.1, 0.1, 0.1,
				0.1, 0.05, 0.1, 0.15, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, false, 10.0);
		state.getEmployeeStateRepository().getSoftwareEngineerStateRepository()
				.add(a6);
		RequirementsDocument a7 = new RequirementsDocument("Requirements", 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0);
		state.getArtifactStateRepository()
				.getRequirementsDocumentStateRepository().add(a7);
		DesignDocument a8 = new DesignDocument("Design", 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0);
		state.getArtifactStateRepository().getDesignDocumentStateRepository()
				.add(a8);
		Code a9 = new Code("Code", 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0,
				0, 0, 0, 0);
		state.getArtifactStateRepository().getCodeStateRepository().add(a9);
		SystemTestPlan a10 = new SystemTestPlan("TestPlan", 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0);
		state.getArtifactStateRepository().getSystemTestPlanStateRepository()
				.add(a10);
		SEProject a11 = new SEProject("Groceries@Home", 1000, 280000.0, 0.0,
				1350, 0, 0.0, 0.0, 0.0, 0.0, 0, false, false, false, false);
		state.getProjectStateRepository().getSEProjectStateRepository()
				.add(a11);
		RequirementsCaptureTool a12 = new RequirementsCaptureTool("SteelTrace",
				10000.0, 0.2, 0.3, false);
		state.getToolStateRepository()
				.getRequirementsCaptureToolStateRepository().add(a12);
		DesignEnvironment a13 = new DesignEnvironment("RationalRose", 5000.0,
				0.5, 0.5, false);
		state.getToolStateRepository().getDesignEnvironmentStateRepository()
				.add(a13);
		IDE a14 = new IDE("Eclipse", 0.0, 0.7, 0.1, false);
		state.getToolStateRepository().getIDEStateRepository().add(a14);
		AutomatedTestingTool a15 = new AutomatedTestingTool("JUnit", 0.0, 0.3,
				0.6, false);
		state.getToolStateRepository().getAutomatedTestingToolStateRepository()
				.add(a15);
		ACustomer a16 = new ACustomer("Grocery Home Delivery Service");
		state.getCustomerStateRepository().getACustomerStateRepository()
				.add(a16);
	}

	public void giveGUI(SimSEGUI g) {
		gui = g;
		new StartingNarrativeDialog();
	}

	public boolean isRunning() {
		return numSteps > 0;
	}

	public void setStopAtEvents(boolean t) {
		stopClock = false;
		stopAtEvents = t;
	}

	public void setSteps(int ns) {
		restartTimer();
		numSteps += ns;
	}

	public void stop() {
		numSteps = 0;
		timer.cancel();
	}
	
	public void restartTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(this, 50, 50);
	}

	public boolean stopClock() {
		return stopClock;
	}

	public Timer getTimer() {
		return timer;
	}

	@Override
	public void handle(ActionEvent ae) {
		this.run();
	}

	@Override
	public void run() {
		if (isRunning()) {
			gui.getAttributePanel().getClockPanel().setAdvClockImage();
			if (state.getClock().isStopped()) {
				numSteps = 0;
			} else {
				gui.getAttributePanel().setGUIChanged();
				state.getLogger().update();
				logic.update(gui);
				gui.update();
				numSteps--;
				if (stopAtEvents && gui.getWorld().overheadTextDisplayed()) {
					stopClock = true;
					numSteps = 0;
				}
			}
		} else {
			gui.getAttributePanel().getClockPanel().resetAdvClockImage();
		}
	}
}