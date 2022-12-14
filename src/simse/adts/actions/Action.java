/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.actions;

import java.util.Vector;

import simse.adts.objects.SSObject;
import simse.util.IDGenerator;

public abstract class Action implements Cloneable {
	public static final String CREATEREQUIREMENTS = "CreateRequirements";
	public static final String REVIEWREQUIREMENTS = "ReviewRequirements";
	public static final String CORRECTREQUIREMENTS = "CorrectRequirements";
	public static final String CREATEDESIGN = "CreateDesign";
	public static final String REVIEWDESIGN = "ReviewDesign";
	public static final String CORRECTDESIGN = "CorrectDesign";
	public static final String CREATECODE = "CreateCode";
	public static final String INSPECTCODE = "InspectCode";
	public static final String CORRECTCODE = "CorrectCode";
	public static final String INTEGRATECODE = "IntegrateCode";
	public static final String SYSTEMTEST = "SystemTest";
	public static final String CREATESYSTEMTESTPLAN = "CreateSystemTestPlan";
	public static final String REVIEWSYSTEMTESTPLAN = "ReviewSystemTestPlan";
	public static final String CORRECTSYSTEMTESTPLAN = "CorrectSystemTestPlan";
	public static final String DELIVERPRODUCT = "DeliverProduct";
	public static final String BREAK = "Break";
	public static final String GETSICK = "GetSick";
	public static final String QUIT = "Quit";
	public static final String INTRODUCENEWREQUIREMENTS = "IntroduceNewRequirements";
	public static final String CHANGEPAYRATE = "ChangePayRate";
	public static final String GIVEBONUS = "GiveBonus";
	public static final String FIRE = "Fire";
	public static final String PURCHASETOOL = "PurchaseTool";
	public static final String SUGGESTEDREQUIREMENTSPHASEDURATION = "SuggestedRequirementsPhaseDuration";
	public static final String SUGGESTEDDESIGNPHASEDURATION = "SuggestedDesignPhaseDuration";
	public static final String SUGGESTEDIMPLINTEGRATIONPHASEDURATION = "SuggestedImplIntegrationPhaseDuration";
	public static final String SUGGESTEDTESTINGPHASEDURATION = "SuggestedTestingPhaseDuration";
	
	private int id;
	private int timeElapsed;
	protected String actionName;

	public Action() {
		id = IDGenerator.getNextID();
		timeElapsed = 0;
		actionName = "";
	}

	public Object clone() {
		try {
			Action cl = (Action) (super.clone());
			cl.id = id;
			cl.timeElapsed = timeElapsed;
			return cl;
		} catch (CloneNotSupportedException c) {
			System.out.println(c.getMessage());
		}
		return null;
	}

	public int getId() {
		return id;
	}
	
	public String getActionName() {
		return actionName;
	}

	public void incrementTimeElapsed() {
		timeElapsed++;
	}

	public int getTimeElapsed() {
		return timeElapsed;
	}

	public abstract Vector<SSObject> getAllParticipants();

	public abstract Vector<SSObject> getAllActiveParticipants();

	public abstract Vector<SSObject> getAllInactiveParticipants();
}