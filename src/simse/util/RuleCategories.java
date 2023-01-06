package simse.util;

import java.util.Hashtable;

import simse.adts.actions.Action;

public final class RuleCategories {

	private static Hashtable<String, String> ruleMapping;
	private static Hashtable<String, String[]> intRules, trigRules, destRules, trigBackendRules, destBackendRules;
	private static Hashtable<String, Hashtable<String, String>> backendRuleMapping;
	
	private static String[] actions = {Action.CREATEREQUIREMENTS, Action.REVIEWREQUIREMENTS,
		Action.CORRECTREQUIREMENTS, Action.CREATEDESIGN, Action.REVIEWDESIGN,
		Action.CORRECTDESIGN, Action.CREATECODE, Action.INSPECTCODE, Action.CORRECTCODE,
		Action.INTEGRATECODE, Action.SYSTEMTEST, Action.CREATESYSTEMTESTPLAN,
		Action.REVIEWSYSTEMTESTPLAN, Action.CORRECTSYSTEMTESTPLAN,
		Action.DELIVERPRODUCT, Action.BREAK, Action.GETSICK, Action.QUIT,
		Action.INTRODUCENEWREQUIREMENTS, Action.CHANGEPAYRATE, Action.GIVEBONUS,
		Action.FIRE, Action.PURCHASETOOL, Action.SUGGESTEDREQUIREMENTSPHASEDURATION,
		Action.SUGGESTEDDESIGNPHASEDURATION, Action.SUGGESTEDIMPLINTEGRATIONPHASEDURATION,
		Action.SUGGESTEDTESTINGPHASEDURATION};
	
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
		String[][] actionRules = {new String[]{"CreateRequirementsEffectRuleA"}, 
				new String[]{"ReviewRequirementsEffectRuleC", "ReviewRequirementsEffectRuleA"},
				new String[]{ "CorrectRequirementsEffectRuleA", }, 
				new String[]{ "CreateDesignEffectRuleA", }, 
				new String[]{ "ReviewDesignEffectRuleA", "ReviewDesignEffectRuleC", },
				new String[]{ "CorrectDesignEffectRuleA", }, 
				new String[]{ "CreateCodeEffectRuleA", }, 
				new String[]{ "InspectCodeEffectRuleA", }, 
				new String[]{ "CorrectCodeEffectRuleA", },
				new String[]{ "IntegrateCodeEffectRuleA", }, 
				new String[]{ "SystemTestEffectRuleA", }, 
				new String[]{ "CreateSystemTestPlanEffectRuleA", },
				new String[]{ "ReviewTestPlanEffectRuleA", }, 
				new String[]{ "CorrectTestPlanEffectRuleA", },
				new String[]{}, 
				new String[]{ "BreakEffectRuleA", }, 
				new String[]{ "GetSickEffectRuleA", }, 
				new String[]{}, 
				new String[]{ "IntroduceNewRequirementsEffectRuleA", }, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{}, new String[]{},
				new String[]{}, new String[]{}, new String[]{}};
		if (actions.length == actionRules.length) {
			for (int i = 0; i < actions.length; i++) {
				intRules.put(actions[i], actionRules[i]);
			}
		}
	}
	
	public static void initializeTrigRules() {
		trigRules = new Hashtable<>();
		String[][] actionRules = {new String[]{}, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{},
				new String[]{}, new String[]{}, new String[]{}, new String[]{},
				new String[]{}, new String[]{}, new String[]{}, new String[]{}, 
				new String[]{},
				new String[]{"CalculateScore", }, 
				new String[]{ "BreakTrigRule", }, 
				new String[]{ "GetSickTrigRule",  }, 
				new String[]{"QuitDestroyObjectsRuleA", }, 
				new String[]{}, 
				new String[]{"ChangePayRateEffectRuleA",}, 
				new String[]{"GiveBonusEffectRuleA",}, 
				new String[]{"FireDestroyObjectsRuleA",}, 
				new String[]{"PurchaseToolEffectRuleA",}, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{}};
		if (actions.length == actionRules.length) {
			for (int i = 0; i < actions.length; i++) {
				trigRules.put(actions[i], actionRules[i]);
			}
		}
	}
	
	public static void initializeDestRules() {
		destRules = new Hashtable<>();
		String[][] actionRules = {new String[]{}, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{},
				new String[]{}, new String[]{}, new String[]{}, new String[]{},
				new String[]{}, new String[]{}, new String[]{}, new String[]{}, 
				new String[]{}, new String[]{}, 
				new String[]{ "BreakDestRule", }, 
				new String[]{ "GetSickDestRule",  }, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{}, 
				new String[]{}, new String[]{}, 
				new String[]{}, new String[]{}, new String[]{}, new String[]{}};
		if (actions.length == actionRules.length) {
			for (int i = 0; i < actions.length; i++) {
				destRules.put(actions[i], actionRules[i]);
			}
		}
	}
	
	public static void initializeBackendRuleMapping() {
		backendRuleMapping = new Hashtable<>();
		backendRuleMapping.put(Action.CREATEREQUIREMENTS, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
						new String[]{TriggerDescriptions.CREATEREQUIREMENTS_TRIGA, DestroyerDescriptions.CREATEREQUIREMENTS_USERDEST, 
								DestroyerDescriptions.CREATEREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put(Action.REVIEWREQUIREMENTS, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWREQUIREMENTS_TRIGA, DestroyerDescriptions.REVIEWREQUIREMENTS_USERDEST, 
						DestroyerDescriptions.REVIEWREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put(Action.CORRECTREQUIREMENTS, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTREQUIREMENTS_TRIGA, DestroyerDescriptions.CORRECTREQUIREMENTS_USERDEST, 
						DestroyerDescriptions.CORRECTREQUIREMENTS_AUTODEST}));
		backendRuleMapping.put(Action.CREATEDESIGN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATEDESIGN_TRIGA, DestroyerDescriptions.CREATEDESIGN_USERDEST, 
						DestroyerDescriptions.CREATEDESIGN_AUTODEST}));
		backendRuleMapping.put(Action.REVIEWDESIGN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWDESIGN_TRIGA, DestroyerDescriptions.REVIEWDESIGN_USERDEST, 
						DestroyerDescriptions.REVIEWDESIGN_AUTODEST}));
		backendRuleMapping.put(Action.CORRECTDESIGN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTDESIGN_TRIGA, DestroyerDescriptions.CORRECTDESIGN_USERDEST, 
						DestroyerDescriptions.CORRECTDESIGN_AUTODEST}));
		backendRuleMapping.put(Action.CREATECODE, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATECODE_TRIGA, DestroyerDescriptions.CREATECODE_USERDEST, 
						DestroyerDescriptions.CREATECODE_AUTODEST}));
		backendRuleMapping.put(Action.INSPECTCODE, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.INSPECTCODE_TRIGA, DestroyerDescriptions.INSPECTCODE_USERDEST, 
						DestroyerDescriptions.INSPECTCODE_AUTODEST}));
		backendRuleMapping.put(Action.CORRECTCODE, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTCODE_TRIGA, DestroyerDescriptions.CORRECTCODE_USERDEST, 
						DestroyerDescriptions.CORRECTCODE_AUTODEST}));
		backendRuleMapping.put(Action.INTEGRATECODE, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.INTEGRATECODE_TRIGA, DestroyerDescriptions.INTEGRATECODE_USERDEST, 
						DestroyerDescriptions.INTEGRATECODE_AUTODEST}));
		backendRuleMapping.put(Action.SYSTEMTEST, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.SYSTEMTEST_TRIGA, DestroyerDescriptions.SYSTEMTEST_USERDEST, 
						DestroyerDescriptions.SYSTEMTEST_AUTODEST}));
		backendRuleMapping.put(Action.CREATESYSTEMTESTPLAN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CREATESYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.CREATESYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.CREATESYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put(Action.REVIEWSYSTEMTESTPLAN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.REVIEWSYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.REVIEWSYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.REVIEWSYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put(Action.CORRECTSYSTEMTESTPLAN, makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
				new String[]{TriggerDescriptions.CORRECTSYSTEMTESTPLAN_TRIGA, DestroyerDescriptions.CORRECTSYSTEMTESTPLAN_USERDEST, 
						DestroyerDescriptions.CORRECTSYSTEMTESTPLAN_AUTODEST}));
		backendRuleMapping.put(Action.DELIVERPRODUCT, makeRuleMappingTable(new String[]{"TrigA"}, new String[]{TriggerDescriptions.DELIVERPRODUCT_TRIGA}));
		backendRuleMapping.put(Action.BREAK, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.BREAK_TRIGA, DestroyerDescriptions.BREAK_DESTA}));
		backendRuleMapping.put(Action.GETSICK, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.GETSICK_TRIGA, DestroyerDescriptions.GETSICK_DESTA}));
		backendRuleMapping.put(Action.QUIT, makeRuleMappingTable(new String[]{"TrigA", "DestO"}, 
				new String[]{TriggerDescriptions.QUIT_TRIGA, DestroyerDescriptions.QUIT_DESTO}));
		backendRuleMapping.put(Action.INTRODUCENEWREQUIREMENTS, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.INTRODUCENEWREQUIREMENTS_TRIGA, DestroyerDescriptions.INTRODUCENEWREQUIREMENTS_DESTA}));
		backendRuleMapping.put(Action.CHANGEPAYRATE, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.CHANGEPAYRATE_TRIGA, DestroyerDescriptions.CHANGEPAYRATE_DESTA}));
		backendRuleMapping.put(Action.GIVEBONUS, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.GIVEBONUS_TRIGA, DestroyerDescriptions.GIVEBONUS_DESTA}));
		backendRuleMapping.put(Action.FIRE, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.FIRE_TRIGA, DestroyerDescriptions.FIRE_DESTA}));
		backendRuleMapping.put(Action.PURCHASETOOL, makeRuleMappingTable(new String[]{"TrigA", "DestA"}, 
				new String[]{TriggerDescriptions.PURCHASETOOL_TRIGA, DestroyerDescriptions.PURCHASETOOL_DESTA}));
		backendRuleMapping.put(Action.SUGGESTEDREQUIREMENTSPHASEDURATION, makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDREQUIREMENTSPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDREQUIREMENTSPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put(Action.SUGGESTEDDESIGNPHASEDURATION, makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDDESIGNPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDDESIGNPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put(Action.SUGGESTEDIMPLINTEGRATIONPHASEDURATION, makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDIMPLINTEGRATIONPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDIMPLINTEGRATIONPHASEDURATION_TIMEDDEST}));
		backendRuleMapping.put(Action.SUGGESTEDTESTINGPHASEDURATION, makeRuleMappingTable(new String[]{"AutoTrig", "TimedDest"}, 
				new String[]{TriggerDescriptions.SUGGESTEDTESTINGPHASEDURATION_AUTOTRIG, 
						DestroyerDescriptions.SUGGESTEDTESTINGPHASEDURATION_TIMEDDEST}));
	}
	
	public static void initializeBackendTrigRules() {
		trigBackendRules = new Hashtable<>();
		String[][] actionRules = {new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", }, 
				new String[]{ "TrigA", },
				new String[]{ "AutoTrig", },
				new String[]{ "AutoTrig", }, 
				new String[]{ "AutoTrig", }, 
				new String[]{ "AutoTrig", }};
		if (actions.length == actionRules.length) {
			for (int i = 0; i < actions.length; i++) {
				trigBackendRules.put(actions[i], actionRules[i]);
			}
		}
	}
	
	public static void initializeBackendDestRules() {
		destBackendRules = new Hashtable<>();
		String[][] actionRules = {new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",},
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",},
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",},
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",},
				new String[]{"UserDest", "AutoDest",}, 
				new String[]{"UserDest", "AutoDest",},
				new String[]{}, 
				new String[]{"DestA"}, 
				new String[]{"DestA"}, 
				new String[]{"DestO"}, 
				new String[]{"DestA"}, 
				new String[]{"DestA"}, 
				new String[]{"DestA"}, 
				new String[]{"DestA"}, 
				new String[]{"DestA"},
				new String[]{"TimedDest"},
				new String[]{"TimedDest"}, 
				new String[]{"TimedDest"}, 
				new String[]{"TimedDest"}};
		if (actions.length == actionRules.length) {
			for (int i = 0; i < actions.length; i++) {
				destBackendRules.put(actions[i], actionRules[i]);
			}
		}
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
