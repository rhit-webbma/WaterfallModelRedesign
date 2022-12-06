package simse.util;

import java.util.Hashtable;

public final class RuleCategories {

	private static Hashtable<String, String> ruleMapping;
	private static Hashtable<String, String[]> intRules, trigRules, destRules, trigBackendRules, destBackendRules;
	private static Hashtable<String, Hashtable<String, String>> backendRuleMapping;
	
	public static void initializeRuleCategories() {
		initializeRuleMapping();
		initializeIntRules();
		initializeTrigRules();
		initializeDestRules();
		initializeBackendRuleMapping();
		initializeBackendTrigRules();
		initializeBackendDestRules();
	}
	
	public static void initializeRuleMapping() {
		ruleMapping = new Hashtable<>();
		ruleMapping.put("CreateRequirementsEffectRuleA", RuleDescriptions.CREATEREQUIREMENTS_CREATEREQUIREMENTSEFFECTRULEA);
		ruleMapping.put("ReviewRequirementsEffectRuleA", RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEA);
		ruleMapping.put("ReviewRequirementsEffectRuleC", RuleDescriptions.REVIEWREQUIREMENTS_REVIEWREQUIREMENTSEFFECTRULEC);
		ruleMapping.put("CorrectRequirementsEffectRuleA", RuleDescriptions.CORRECTREQUIREMENTS_CORRECTREQUIREMENTSEFFECTRULEA);
		ruleMapping.put("CreateDesignEffectRuleA", RuleDescriptions.CREATEDESIGN_CREATEDESIGNEFFECTRULEA);
		ruleMapping.put("ReviewDesignEffectRuleA", RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEA);
		ruleMapping.put("ReviewDesignEffectRuleC", RuleDescriptions.REVIEWDESIGN_REVIEWDESIGNEFFECTRULEC);
		ruleMapping.put("CorrectDesignEffectRuleA", RuleDescriptions.CORRECTDESIGN_CORRECTDESIGNEFFECTRULEA);
		ruleMapping.put("CreateCodeEffectRuleA", RuleDescriptions.CREATECODE_CREATECODEEFFECTRULEA);
		ruleMapping.put("InspectCodeEffectRuleA", RuleDescriptions.INSPECTCODE_INSPECTCODEEFFECTRULEA);
		ruleMapping.put("CorrectCodeEffectRuleA", RuleDescriptions.CORRECTCODE_CORRECTCODEEFFECTRULEA);
		ruleMapping.put("IntegrateCodeEffectRuleA", RuleDescriptions.INTEGRATECODE_INTEGRATECODEEFFECTRULEA);
		ruleMapping.put("SystemTestEffectRuleA", RuleDescriptions.SYSTEMTEST_SYSTEMTESTEFFECTRULEA);
		ruleMapping.put("CreateSystemTestPlanEffectRuleA", RuleDescriptions.CREATESYSTEMTESTPLAN_CREATESYSTEMTESTPLANEFFECTRULEA);
		ruleMapping.put("ReviewTestPlanEffectRuleA", RuleDescriptions.REVIEWSYSTEMTESTPLAN_REVIEWTESTPLANEFFECTRULEA);
		ruleMapping.put("CorrectTestPlanEffectRuleA", RuleDescriptions.CORRECTSYSTEMTESTPLAN_CORRECTTESTPLANEFFECTRULEA);
		ruleMapping.put("CalculateScore", RuleDescriptions.DELIVERPRODUCT_CALCULATESCORE);
		ruleMapping.put("BreakEffectRuleA", RuleDescriptions.BREAK_BREAKEFFECTRULEA);
		ruleMapping.put("BreakTrigRule", RuleDescriptions.BREAK_BREAKTRIGRULE);
		ruleMapping.put("BreakDestRule", RuleDescriptions.BREAK_BREAKDESTRULE);
		ruleMapping.put("GetSickEffectRuleA", RuleDescriptions.GETSICK_GETSICKEFFECTRULEA);
		ruleMapping.put("GetSickTrigRule", RuleDescriptions.GETSICK_GETSICKTRIGRULE);
		ruleMapping.put("GetSickDestRule", RuleDescriptions.GETSICK_GETSICKDESTRULE);
		ruleMapping.put("QuitDestroyObjectsRuleA", RuleDescriptions.QUIT_QUITDESTROYOBJECTSRULEA);
		ruleMapping.put("IntroduceNewRequirementsEffectRuleA", RuleDescriptions.INTRODUCENEWREQUIREMENTS_INTRODUCENEWREQUIREMENTSEFFECTRULEA);
		ruleMapping.put("ChangePayRateEffectRuleA", RuleDescriptions.CHANGEPAYRATE_CHANGEPAYRATEEFFECTRULEA);
		ruleMapping.put("GiveBonusEffectRuleA", RuleDescriptions.GIVEBONUS_GIVEBONUSEFFECTRULEA);
		ruleMapping.put("FireDestroyObjectsRuleA", RuleDescriptions.FIRE_FIREDESTROYOBJECTSRULEA);
		ruleMapping.put("PurchaseToolEffectRuleA", RuleDescriptions.PURCHASETOOL_PURCHASETOOLEFFECTRULEA);
	}
	
	public static void initializeIntRules() {
		intRules = new Hashtable<>();
		intRules.put("CreateRequirements", new String[]{"CreateRequirementsEffectRuleA"});
		intRules.put("ReviewRequirements", new String[]{"ReviewRequirementsEffectRuleC", "ReviewRequirementsEffectRuleA"});
		intRules.put("CorrectRequirements", new String[]{ "CorrectRequirementsEffectRuleA", });
		intRules.put("CreateDesign", new String[]{ "CreateDesignEffectRuleA", });
		intRules.put("ReviewDesign", new String[]{ "ReviewDesignEffectRuleA", "ReviewDesignEffectRuleC", });
		intRules.put("CorrectDesign", new String[]{ "CorrectDesignEffectRuleA", });
		intRules.put("CreateCode", new String[]{ "CreateCodeEffectRuleA", });
		intRules.put("InspectCode", new String[]{ "InspectCodeEffectRuleA", });
		intRules.put("CorrectCode", new String[]{ "CorrectCodeEffectRuleA", });
		intRules.put("IntegrateCode", new String[]{ "IntegrateCodeEffectRuleA", });
		intRules.put("SystemTest", new String[]{ "SystemTestEffectRuleA", });
		intRules.put("CreateSystemTestPlan", new String[]{ "CreateSystemTestPlanEffectRuleA", });
		intRules.put("ReviewSystemTestPlan", new String[]{ "ReviewTestPlanEffectRuleA", });
		intRules.put("CorrectSystemTestPlan", new String[]{ "CorrectTestPlanEffectRuleA", });
		intRules.put("DeliverProduct", new String[]{});
		intRules.put("Break", new String[]{ "BreakEffectRuleA", });
		intRules.put("GetSick", new String[]{ "GetSickEffectRuleA", });
		intRules.put("Quit", new String[]{});
		intRules.put("IntroduceNewRequirements", new String[]{ "IntroduceNewRequirementsEffectRuleA", });
		intRules.put("ChangePayRate", new String[]{});
		intRules.put("GiveBonus", new String[]{});
		intRules.put("Fire", new String[]{});
		intRules.put("PurchaseTool", new String[]{});
		intRules.put("SuggestedRequirementsPhaseDuration", new String[]{});
		intRules.put("SuggestedDesignPhaseDuration", new String[]{});
		intRules.put("SuggestedImplIntegrationPhaseDuration", new String[]{});
		intRules.put("SuggestedTestingPhaseDuration", new String[]{});
	}
	
	public static void initializeTrigRules() {
		trigRules = new Hashtable<>();
		trigRules.put("CreateRequirements", new String[]{});
		trigRules.put("ReviewRequirements", new String[]{});
		trigRules.put("CorrectRequirements", new String[]{});
		trigRules.put("CreateDesign", new String[]{});
		trigRules.put("ReviewDesign", new String[]{});
		trigRules.put("CorrectDesign", new String[]{});
		trigRules.put("CreateCode", new String[]{});
		trigRules.put("InspectCode", new String[]{});
		trigRules.put("CorrectCode", new String[]{});
		trigRules.put("IntegrateCode", new String[]{});
		trigRules.put("SystemTest", new String[]{});
		trigRules.put("CreateSystemTestPlan", new String[]{});
		trigRules.put("ReviewSystemTestPlan", new String[]{});
		trigRules.put("CorrectSystemTestPlan", new String[]{});
		trigRules.put("DeliverProduct", new String[]{ "CalculateScore", });
		trigRules.put("Break", new String[]{ "BreakTrigRule", });
		trigRules.put("GetSick", new String[]{ "GetSickTrigRule", });
		trigRules.put("Quit", new String[]{ "QuitDestroyObjectsRuleA", });
		trigRules.put("IntroduceNewRequirements", new String[]{});
		trigRules.put("ChangePayRate", new String[]{ "ChangePayRateEffectRuleA", });
		trigRules.put("GiveBonus", new String[]{ "GiveBonusEffectRuleA", });
		trigRules.put("Fire", new String[]{ "FireDestroyObjectsRuleA", });
		trigRules.put("PurchaseTool", new String[]{ "PurchaseToolEffectRuleA", });
		trigRules.put("SuggestedRequirementsPhaseDuration", new String[]{});
		trigRules.put("SuggestedDesignPhaseDuration", new String[]{});
		trigRules.put("SuggestedImplIntegrationPhaseDuration", new String[]{});
		trigRules.put("SuggestedTestingPhaseDuration", new String[]{});
	}
	
	public static void initializeDestRules() {
		destRules = new Hashtable<>();
		destRules.put("CreateRequirements", new String[]{});
		destRules.put("ReviewRequirements", new String[]{});
		destRules.put("CorrectRequirements", new String[]{});
		destRules.put("CreateDesign", new String[]{});
		destRules.put("ReviewDesign", new String[]{});
		destRules.put("CorrectDesign", new String[]{});
		destRules.put("CreateCode", new String[]{});
		destRules.put("InspectCode", new String[]{});
		destRules.put("CorrectCode", new String[]{});
		destRules.put("IntegrateCode", new String[]{});
		destRules.put("SystemTest", new String[]{});
		destRules.put("CreateSystemTestPlan", new String[]{});
		destRules.put("ReviewSystemTestPlan", new String[]{});
		destRules.put("CorrectSystemTestPlan", new String[]{});
		destRules.put("DeliverProduct", new String[]{});
		destRules.put("Break", new String[]{ "BreakDestRule", });
		destRules.put("GetSick", new String[]{ "GetSickDestRule", });
		destRules.put("Quit", new String[]{});
		destRules.put("IntroduceNewRequirements", new String[]{});
		destRules.put("ChangePayRate", new String[]{});
		destRules.put("GiveBonus", new String[]{});
		destRules.put("Fire", new String[]{});
		destRules.put("PurchaseTool", new String[]{});
		destRules.put("SuggestedRequirementsPhaseDuration", new String[]{});
		destRules.put("SuggestedDesignPhaseDuration", new String[]{});
		destRules.put("SuggestedImplIntegrationPhaseDuration", new String[]{});
		destRules.put("SuggestedTestingPhaseDuration", new String[]{});
	}
	
	public static void initializeBackendRuleMapping() {
		backendRuleMapping = new Hashtable<>();
		backendRuleMapping.put("CreateRequirements", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
						new String[]{TriggerDescriptions.CREATEREQUIREMENTS_TRIGA, DestroyerDescriptions.CREATEREQUIREMENTS_USERDEST, 
								DestroyerDescriptions.CREATEREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put("ReviewRequirements", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWREQUIREMENTS_TRIGA, DestroyerDescriptions.REVIEWREQUIREMENTS_USERDEST, 
						DestroyerDescriptions.REVIEWREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put("CorrectRequirements", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTREQUIREMENTS_TRIGA, DestroyerDescriptions.CORRECTREQUIREMENTS_USERDEST, 
						DestroyerDescriptions.CORRECTREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put("CreateDesign", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATEDESIGN_TRIGA, DestroyerDescriptions.CREATEDESIGN_USERDEST, 
						DestroyerDescriptions.CREATEDESIGN_AUTODEST}));
		backendRuleMapping.put("ReviewDesign", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWDESIGN_TRIGA, DestroyerDescriptions.REVIEWDESIGN_USERDEST, 
						DestroyerDescriptions.REVIEWDESIGN_AUTODEST}));
		backendRuleMapping.put("CorrectDesign", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTDESIGN_TRIGA, DestroyerDescriptions.CORRECTDESIGN_USERDEST, 
						DestroyerDescriptions.CORRECTDESIGN_AUTODEST}));
		backendRuleMapping.put("CreateCode", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATECODE_TRIGA, DestroyerDescriptions.CREATECODE_USERDEST, 
						DestroyerDescriptions.CREATECODE_AUTODEST}));
		backendRuleMapping.put("InspectCode", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.INSPECTCODE_TRIGA, DestroyerDescriptions.INSPECTCODE_USERDEST, 
						DestroyerDescriptions.INSPECTCODE_AUTODEST}));
		backendRuleMapping.put("CorrectCode", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTCODE_TRIGA, DestroyerDescriptions.CORRECTCODE_USERDEST, 
						DestroyerDescriptions.CORRECTCODE_AUTODEST}));
		backendRuleMapping.put("IntegrateCode", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.INTEGRATECODE_TRIGA, DestroyerDescriptions.INTEGRATECODE_USERDEST, 
						DestroyerDescriptions.INTEGRATECODE_AUTODEST}));
		backendRuleMapping.put("SystemTest", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.SYSTEMTEST_TRIGA, DestroyerDescriptions.SYSTEMTEST_USERDEST, 
						DestroyerDescriptions.SYSTEMTEST_AUTODEST}));
		backendRuleMapping.put("CreateSystemTestPlan", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATESYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.CREATESYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.CREATESYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put("ReviewSystemTestPlan", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWSYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.REVIEWSYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.REVIEWSYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put("CorrectSystemTestPlan", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTSYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.CORRECTSYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.CORRECTSYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put("DeliverProduct", makeRuleMappingTable(new String[]{"TrigA"}, new String[]{TriggerDescriptions.DELIVERPRODUCT_TRIGA}));
		backendRuleMapping.put("Break", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.BREAK_TRIGA, DestroyerDescriptions.BREAK_DESTA}));
		backendRuleMapping.put("GetSick", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.GETSICK_TRIGA, DestroyerDescriptions.GETSICK_DESTA}));
		backendRuleMapping.put("Quit", makeRuleMappingTable(new String[]{"TrigA", "DestO"}, 
				new String[]{TriggerDescriptions.QUIT_TRIGA, DestroyerDescriptions.QUIT_DESTO}));
		backendRuleMapping.put("IntroduceNewRequirements", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.INTRODUCENEWREQUIREMENTS_TRIGA, DestroyerDescriptions.INTRODUCENEWREQUIREMENTS_DESTA}));
		backendRuleMapping.put("ChangePayRate", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.CHANGEPAYRATE_TRIGA, DestroyerDescriptions.CHANGEPAYRATE_DESTA}));
		backendRuleMapping.put("GiveBonus", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.GIVEBONUS_TRIGA, DestroyerDescriptions.GIVEBONUS_DESTA}));
		backendRuleMapping.put("Fire", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.FIRE_TRIGA, DestroyerDescriptions.FIRE_DESTA}));
		backendRuleMapping.put("PurchaseTool", makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.PURCHASETOOL_TRIGA, DestroyerDescriptions.PURCHASETOOL_DESTA}));
		backendRuleMapping.put("SuggestedRequirementsPhaseDuration", makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDREQUIREMENTSPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDREQUIREMENTSPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put("SuggestedDesignPhaseDuration", makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDDESIGNPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDDESIGNPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put("SuggestedImplIntegrationPhaseDuration", makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDIMPLINTEGRATIONPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDIMPLINTEGRATIONPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put("SuggestedTestingPhaseDuration", makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDTESTINGPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDTESTINGPHASEDURATION_TIMEDDEST}));
	}
	
	public static void initializeBackendTrigRules() {
		trigBackendRules = new Hashtable<>();
		trigBackendRules.put("CreateRequirements", new String[]{ "TrigA", });
		trigBackendRules.put("ReviewRequirements", new String[]{"TrigA"});
		trigBackendRules.put("CorrectRequirements", new String[]{"TrigA"});
		trigBackendRules.put("CreateDesign", new String[]{"TrigA"});
		trigBackendRules.put("ReviewDesign", new String[]{"TrigA"});
		trigBackendRules.put("CorrectDesign", new String[]{"TrigA"});
		trigBackendRules.put("CreateCode", new String[]{"TrigA"});
		trigBackendRules.put("InspectCode", new String[]{"TrigA"});
		trigBackendRules.put("CorrectCode", new String[]{"TrigA"});
		trigBackendRules.put("IntegrateCode", new String[]{"TrigA"});
		trigBackendRules.put("SystemTest", new String[]{"TrigA"});
		trigBackendRules.put("CreateSystemTestPlan", new String[]{"TrigA"});
		trigBackendRules.put("ReviewSystemTestPlan", new String[]{"TrigA"});
		trigBackendRules.put("CorrectSystemTestPlan", new String[]{"TrigA"});
		trigBackendRules.put("DeliverProduct", new String[]{"TrigA"});
		trigBackendRules.put("Break", new String[]{"TrigA"});
		trigBackendRules.put("GetSick", new String[]{"TrigA"});
		trigBackendRules.put("Quit", new String[]{"TrigA"});
		trigBackendRules.put("IntroduceNewRequirements", new String[]{"TrigA"});
		trigBackendRules.put("ChangePayRate", new String[]{"TrigA"});
		trigBackendRules.put("GiveBonus", new String[]{"TrigA"});
		trigBackendRules.put("Fire", new String[]{"TrigA"});
		trigBackendRules.put("PurchaseTool", new String[]{"TrigA"});
		trigBackendRules.put("SuggestedRequirementsPhaseDuration", new String[]{"AutoTrig"});
		trigBackendRules.put("SuggestedDesignPhaseDuration", new String[]{"AutoTrig"});
		trigBackendRules.put("SuggestedImplIntegrationPhaseDuration", new String[]{"AutoTrig"});
		trigBackendRules.put("SuggestedTestingPhaseDuration", new String[]{"AutoTrig"});
	}
	
	public static void initializeBackendDestRules() {
		destBackendRules = new Hashtable<>();
		destBackendRules.put("CreateRequirements", new String[]{ "UserDest", "AutoDest", });
		destBackendRules.put("ReviewRequirements", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CorrectRequirements", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CreateDesign", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("ReviewDesign", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CorrectDesign", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CreateCode", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("InspectCode", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CorrectCode", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("IntegrateCode", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("SystemTest", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CreateSystemTestPlan", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("ReviewSystemTestPlan", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("CorrectSystemTestPlan", new String[]{"UserDest", "AutoDest",});
		destBackendRules.put("DeliverProduct", new String[]{});
		destBackendRules.put("Break", new String[]{"DestA"});
		destBackendRules.put("GetSick", new String[]{"DestA"});
		destBackendRules.put("Quit", new String[]{"DestO"});
		destBackendRules.put("IntroduceNewRequirements", new String[]{"DestA"});
		destBackendRules.put("ChangePayRate", new String[]{"DestA"});
		destBackendRules.put("GiveBonus", new String[]{"DestA"});
		destBackendRules.put("Fire", new String[]{"DestA"});
		destBackendRules.put("PurchaseTool", new String[]{"DestA"});
		destBackendRules.put("SuggestedRequirementsPhaseDuration", new String[]{"TimedDest"});
		destBackendRules.put("SuggestedDesignPhaseDuration", new String[]{"TimedDest"});
		destBackendRules.put("SuggestedImplIntegrationPhaseDuration", new String[]{"TimedDest"});
		destBackendRules.put("SuggestedTestingPhaseDuration", new String[]{"TimedDest"});
	}
	
	public static Hashtable<String, String> makeRuleMappingTable(String[] rules, String[] ruleDesc) {
		Hashtable<String, String> ruleMaps = new Hashtable<>();
		if (rules.length == ruleDesc.length) {
			for (int i = 0; i < rules.length; i++) {
				ruleMaps.put(rules[i], ruleDesc[i]);
			}
		}
		return ruleMaps;
	}
	
	public static String getRuleMapping(String ruleName) {
		String text = ruleMapping.get(ruleName);
		if (text == null) {
			text = "";
		}
		return text;
	}
	
	public static String[] getIntRulesForAction(String actionName) {
		String[] rules = intRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		}
		return rules;
	}
	
	public static String[] getTrigRulesForAction(String actionName) {
		String[] rules = trigRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		}
		return rules;
	}
	
	public static String[] getDestRulesForAction(String actionName) {
		String[] rules = destRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		} 
		return rules;
	}
	
	public static String getBackendRuleMappings(String actionName, String ruleName) {
		String text = backendRuleMapping.get(actionName).get(ruleName);
		if (text == null) {
			text = "";
		}
		return text;
	}
	
	public static String[] getBackendTrigRulesForAction(String actionName) {
		String[] rules = trigBackendRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		}
		return rules;
	}
	
	public static String[] getBackendDestRulesForAction(String actionName) {
		String[] rules = destBackendRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		} 
		return rules;
	}
	
	public static String getAllRuleMappings(String actionName, String ruleName) {
		String text = getRuleMapping(ruleName);
		if (text == "") {
			text = getBackendRuleMappings(actionName, ruleName);
		}
		return text;
	}
	
	public static String[] getAllTrigRulesForAction(String actionName) {
		String[] rules = getTrigRulesForAction(actionName);
		String[] backendRules = getBackendTrigRulesForAction(actionName);
		int rulesLen = rules.length;
		int bRulesLen = backendRules.length;
		String[] result = new String[rulesLen + bRulesLen];
		System.arraycopy(rules, 0, result, 0, rulesLen);  
		System.arraycopy(backendRules, 0, result, rulesLen, bRulesLen);  
		return result;
	}
	
	public static String[] getAllDestRulesForAction(String actionName) {
		String[] rules = getDestRulesForAction(actionName);
		String[] backendRules = getBackendDestRulesForAction(actionName);
		int rulesLen = rules.length;
		int bRulesLen = backendRules.length;
		String[] result = new String[rulesLen + bRulesLen];
		System.arraycopy(rules, 0, result, 0, rulesLen);  
		System.arraycopy(backendRules, 0, result, rulesLen, bRulesLen);  
		return result;
	}
	
}
