package simse.util;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.util.Pair;

public final class RuleCategories {

	private static Hashtable<String, String> ruleMapping;
	private static Hashtable<String, String[]> intRules, trigRules, destRules, trigBackendRules, destBackendRules;
	private static Hashtable<String, Hashtable<String, String>> backendRuleMapping;
	
	public static void initializeRuleCategories() {
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
		
		backendRuleMapping = new Hashtable<>();
		backendRuleMapping.put("CreateRequirements", makeRuleMappingTable(new String[]{"TrigA", "UserDest", "AutoDest"}, 
						new String[]{TriggerDescriptions.CREATEREQUIREMENTS_TRIGA, DestroyerDescriptions.CREATEREQUIREMENTS_USERDEST, 
								DestroyerDescriptions.CREATEREQUIREMENTS_AUTODEST}));
		
		trigBackendRules = new Hashtable<>();
		trigBackendRules.put("CreateRequirements", new String[]{ "TrigA", });
		
		destBackendRules = new Hashtable<>();
		destBackendRules.put("CreateRequirements", new String[]{ "UserDest", "AutoDest", });
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
	
	public static String[] getAllTrigRulesForAction(String actionName) {
		String[] rules = trigRules.get(actionName);
		String[] backendRules = trigBackendRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		}
		if (backendRules == null) {
			backendRules = new String[]{};
		}
		int rulesLen = rules.length;
		int bRulesLen = backendRules.length;
		String[] result = new String[rulesLen + bRulesLen];
		System.arraycopy(rules, 0, result, 0, rulesLen);  
		System.arraycopy(backendRules, 0, result, rulesLen, bRulesLen);  
		return result;
	}
	
	public static String[] getAllDestRulesForAction(String actionName) {
		String[] rules = destRules.get(actionName);
		String[] backendRules = destBackendRules.get(actionName);
		if (rules == null) {
			rules = new String[]{};
		}
		if (backendRules == null) {
			backendRules = new String[]{};
		}
		int rulesLen = rules.length;
		int bRulesLen = backendRules.length;
		String[] result = new String[rulesLen + bRulesLen];
		System.arraycopy(rules, 0, result, 0, rulesLen);  
		System.arraycopy(backendRules, 0, result, rulesLen, bRulesLen);  
		return result;
	}
	
}
