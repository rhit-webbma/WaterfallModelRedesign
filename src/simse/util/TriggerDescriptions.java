/* File generated by: simse.codegenerator.explanatorytoolgenerator.TriggerDescriptionsGenerator */
package simse.util;

public class TriggerDescriptions {
	public static final String CREATEREQUIREMENTS_TRIGA = "This action occurs when the user chooses the menu item \"Create Requirements Document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nReqDoc.PercentComplete (RequirementsDocument) < 100.0 \nRequirementsCaptureTool.Purchased (RequirementsCaptureTool) = true \n";
	public static final String REVIEWREQUIREMENTS_TRIGA = "This action occurs when the user chooses the menu item \"Review requirements document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nRequirementsDoc.Size (RequirementsDocument) > 0.0 \nRequirementsDoc.NumUnknownErrors (RequirementsDocument) > 0.0 \n";
	public static final String CORRECTREQUIREMENTS_TRIGA = "This action occurs when the user chooses the menu item \"Correct the requirements document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nRequirementsDoc.NumKnownErrors (RequirementsDocument) > 0.0 \nRequirementsCaptureTool.Purchased (RequirementsCaptureTool) = true \n";
	public static final String CREATEDESIGN_TRIGA = "This action occurs when the user chooses the menu item \"Create the design document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nDesignDoc.PercentComplete (DesignDocument) < 100.0 \nDesignEnvironment.Purchased (DesignEnvironment) = true \n";
	public static final String REVIEWDESIGN_TRIGA = "This action occurs when the user chooses the menu item \"Review the design document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nDesignDoc.Size (DesignDocument) > 0.0 \nDesignDoc.NumUnknownErrors (DesignDocument) > 0.0 \n";
	public static final String CORRECTDESIGN_TRIGA = "This action occurs when the user chooses the menu item \"Correct the design document\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nDesignDoc.NumKnownErrors (DesignDocument) > 0.0 \nDesignEnvironment.Purchased (DesignEnvironment) = true \n";
	public static final String CREATECODE_TRIGA = "This action occurs when the user chooses the menu item \"Create code\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nCodeDoc.PercentComplete (Code) < 100.0 \nDevelopmentEnvironment.Purchased (IDE) = true \n";
	public static final String INSPECTCODE_TRIGA = "This action occurs when the user chooses the menu item \"Inspect the code\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nCodeDoc.Size (Code) > 0.0 \n";
	public static final String CORRECTCODE_TRIGA = "This action occurs when the user chooses the menu item \"Correct code\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nCodeDoc.NumKnownErrors (Code) > 0.0 \nDevelopmentEnvironment.Purchased (IDE) = true \n";
	public static final String INTEGRATECODE_TRIGA = "This action occurs when the user chooses the menu item \"Integrate code\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nCodeDoc.Size (Code) > 0.0 \nCodeDoc.PercentIntegrated (Code) < 100.0 \nDevelopmentEnvironment.Purchased (IDE) = true \n";
	public static final String SYSTEMTEST_TRIGA = "This action occurs when the user chooses the menu item \"Do system test\" and when the following conditions are met: \nCodeDoc.Size (Code) > 0.0 \nCodeDoc.PercentIntegrated (Code) = 100.0 \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nAssociatedSystemTestPlan.Size (SystemTestPlan) > 0.0 \nTestingTool.Purchased (AutomatedTestingTool) = true \n";
	public static final String CREATESYSTEMTESTPLAN_TRIGA = "This action occurs when the user chooses the menu item \"Create the system test plan\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nSystemTestPlanDoc.PercentComplete (SystemTestPlan) < 100.0 \nTestingTool.Purchased (AutomatedTestingTool) = true \n";
	public static final String REVIEWSYSTEMTESTPLAN_TRIGA = "This action occurs when the user chooses the menu item \"Review the system test plan\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nTestPlan.Size (SystemTestPlan) > 0.0 \n";
	public static final String CORRECTSYSTEMTESTPLAN_TRIGA = "This action occurs when the user chooses the menu item \"Correct the system test plan\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 1.0 \nEmp.OnBreak (SoftwareEngineer) = false \nTestPlan.NumKnownErrors (SystemTestPlan) > 0.0 \nTestingTool.Purchased (AutomatedTestingTool) = true \n";
	public static final String DELIVERPRODUCT_TRIGA = "This action occurs when the user chooses the menu item \"Deliver product to customer\" and when the following conditions are met: \nEmp.Health (SoftwareEngineer) >= 0.7 \n";
	public static final String BREAK_TRIGA = "This action occurs when the following conditions are met: \nBreaker.Energy (SoftwareEngineer) <= 0.2 \nBreaker.Health (SoftwareEngineer) >= 1.0 \nBreaker.OnBreak (SoftwareEngineer) = false \n";
	public static final String GETSICK_TRIGA = "This action occurs 0.25% of the time when the following conditions are met: \nSickPerson.Energy (SoftwareEngineer) >= 1.0 \nSickPerson.OnBreak (SoftwareEngineer) = false \n";
	public static final String QUIT_TRIGA = "This action occurs when the following conditions are met: \nQuitter.Mood (SoftwareEngineer) = 0.0 \n";
	public static final String INTRODUCENEWREQUIREMENTS_TRIGA = "This action occurs 0.666667% of the time when the following conditions are met: \n";
	public static final String CHANGEPAYRATE_TRIGA = "This action occurs when the user chooses the menu item \"Change pay rate\" and when the following conditions are met: \n";
	public static final String GIVEBONUS_TRIGA = "This action occurs when the user chooses the menu item \"Give bonus\" and when the following conditions are met: \n";
	public static final String FIRE_TRIGA = "This action occurs when the user chooses the menu item \"Fire\" and when the following conditions are met: \nFiredPerson.OnBreak (SoftwareEngineer) = false \n";
	public static final String PURCHASETOOL_TRIGA = "This action occurs when the user chooses the menu item \"Purchase tool(s)\" and when the following conditions are met: \nSETool.Purchased (IDE) = false \nSETool.Purchased (RequirementsCaptureTool) = false \nSETool.Purchased (AutomatedTestingTool) = false \nSETool.Purchased (DesignEnvironment) = false \n";
	public static final String SUGGESTEDREQUIREMENTSPHASEDURATION_AUTOTRIG = "This action occurs when the following conditions are met: \nProj.TimeUsed (SEProject) >= 0 \nProj.SuggestedRequirementsDone (SEProject) = false \n";
	public static final String SUGGESTEDDESIGNPHASEDURATION_AUTOTRIG = "This action occurs when the following conditions are met: \nProj.TimeUsed (SEProject) >= 407 \nProj.SuggestedDesignDone (SEProject) = false \n";
	public static final String SUGGESTEDIMPLINTEGRATIONPHASEDURATION_AUTOTRIG = "This action occurs when the following conditions are met: \nProj.TimeUsed (SEProject) >= 819 \nProj.SuggestedImplementationIntegrationDone (SEProject) = false \n";
	public static final String SUGGESTEDTESTINGPHASEDURATION_AUTOTRIG = "This action occurs when the following conditions are met: \nProj.TimeUsed (SEProject) >= 1135 \nProj.SuggestedTestDone (SEProject) = false \n";
}