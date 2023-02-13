/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.objects;

public class SoftwareEngineer extends Employee implements Cloneable {
	private String name;
	private double energy;
	private double mood;
	private double health;
	private String requirementsexperience;
	private String designexperience;
	private String codingexperience;
	private String testingexperience;
	private double productivityinrequirementsunadjusted;
	private double productivityindesignunadjusted;
	private double productivityincodingunadjusted;
	private double productivityintestingunadjusted;
	private double errorrateinrequirementsunadjusted;
	private double errorrateindesignunadjusted;
	private double errorrateincodingunadjusted;
	private double errorrateintestingunadjusted;
	private double productivityinrequirements;
	private double productivityindesign;
	private double productivityincoding;
	private double productivityintesting;
	private double errorrateinrequirements;
	private double errorrateindesign;
	private double errorrateincoding;
	private double errorrateintesting;
	private boolean onbreak;
	private double payrate;

	public SoftwareEngineer(String n0, double e1, double m2, double h3,
			String r4, String d5, String c6, String t7, double p8, double p9,
			double p10, double p11, double e12, double e13, double e14,
			double e15, double p16, double p17, double p18, double p19,
			double e20, double e21, double e22, double e23, boolean o24,
			double p25) {
		super(n0, e1, m2, r4, d5, c6, t7, p25);
		setName(n0);
		setEnergy(e1);
		setMood(m2);
		setHealth(h3);
		setRequirementsExperience(r4);
		setDesignExperience(d5);
		setCodingExperience(c6);
		setTestingExperience(t7);
		setProductivityInRequirementsUnadjusted(p8);
		setProductivityInDesignUnadjusted(p9);
		setProductivityInCodingUnadjusted(p10);
		setProductivityInTestingUnadjusted(p11);
		setErrorRateInRequirementsUnadjusted(e12);
		setErrorRateInDesignUnadjusted(e13);
		setErrorRateInCodingUnadjusted(e14);
		setErrorRateInTestingUnadjusted(e15);
		setProductivityInRequirements(p16);
		setProductivityInDesign(p17);
		setProductivityInCoding(p18);
		setProductivityInTesting(p19);
		setErrorRateInRequirements(e20);
		setErrorRateInDesign(e21);
		setErrorRateInCoding(e22);
		setErrorRateInTesting(e23);
		setOnBreak(o24);
		setPayRate(p25);
	}

	public Object clone() {
		SoftwareEngineer cl = (SoftwareEngineer) (super.clone());
		cl.name = name;
		cl.energy = energy;
		cl.mood = mood;
		cl.health = health;
		cl.requirementsexperience = requirementsexperience;
		cl.designexperience = designexperience;
		cl.codingexperience = codingexperience;
		cl.testingexperience = testingexperience;
		cl.productivityinrequirementsunadjusted = productivityinrequirementsunadjusted;
		cl.productivityindesignunadjusted = productivityindesignunadjusted;
		cl.productivityincodingunadjusted = productivityincodingunadjusted;
		cl.productivityintestingunadjusted = productivityintestingunadjusted;
		cl.errorrateinrequirementsunadjusted = errorrateinrequirementsunadjusted;
		cl.errorrateindesignunadjusted = errorrateindesignunadjusted;
		cl.errorrateincodingunadjusted = errorrateincodingunadjusted;
		cl.errorrateintestingunadjusted = errorrateintestingunadjusted;
		cl.productivityinrequirements = productivityinrequirements;
		cl.productivityindesign = productivityindesign;
		cl.productivityincoding = productivityincoding;
		cl.productivityintesting = productivityintesting;
		cl.errorrateinrequirements = errorrateinrequirements;
		cl.errorrateindesign = errorrateindesign;
		cl.errorrateincoding = errorrateincoding;
		cl.errorrateintesting = errorrateintesting;
		cl.onbreak = onbreak;
		cl.payrate = payrate;
		return cl;
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

	public double getHealth() {
		return health;
	}

	public void setHealth(double a) {
		if (a < 0.0) {
			health = 0.0;
		} else if (a > 1.0) {
			health = 1.0;
		} else {
			health = a;
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

	public double getProductivityInRequirementsUnadjusted() {
		return productivityinrequirementsunadjusted;
	}

	public void setProductivityInRequirementsUnadjusted(double a) {
		if (a < 0.0) {
			productivityinrequirementsunadjusted = 0.0;
		} else if (a > 1.0) {
			productivityinrequirementsunadjusted = 1.0;
		} else {
			productivityinrequirementsunadjusted = a;
		}
	}

	public double getProductivityInDesignUnadjusted() {
		return productivityindesignunadjusted;
	}

	public void setProductivityInDesignUnadjusted(double a) {
		if (a < 0.0) {
			productivityindesignunadjusted = 0.0;
		} else if (a > 1.0) {
			productivityindesignunadjusted = 1.0;
		} else {
			productivityindesignunadjusted = a;
		}
	}

	public double getProductivityInCodingUnadjusted() {
		return productivityincodingunadjusted;
	}

	public void setProductivityInCodingUnadjusted(double a) {
		if (a < 0.0) {
			productivityincodingunadjusted = 0.0;
		} else if (a > 1.0) {
			productivityincodingunadjusted = 1.0;
		} else {
			productivityincodingunadjusted = a;
		}
	}

	public double getProductivityInTestingUnadjusted() {
		return productivityintestingunadjusted;
	}

	public void setProductivityInTestingUnadjusted(double a) {
		if (a < 0.0) {
			productivityintestingunadjusted = 0.0;
		} else if (a > 1.0) {
			productivityintestingunadjusted = 1.0;
		} else {
			productivityintestingunadjusted = a;
		}
	}

	public double getErrorRateInRequirementsUnadjusted() {
		return errorrateinrequirementsunadjusted;
	}

	public void setErrorRateInRequirementsUnadjusted(double a) {
		if (a < 0.0) {
			errorrateinrequirementsunadjusted = 0.0;
		} else if (a > 1.0) {
			errorrateinrequirementsunadjusted = 1.0;
		} else {
			errorrateinrequirementsunadjusted = a;
		}
	}

	public double getErrorRateInDesignUnadjusted() {
		return errorrateindesignunadjusted;
	}

	public void setErrorRateInDesignUnadjusted(double a) {
		if (a < 0.0) {
			errorrateindesignunadjusted = 0.0;
		} else if (a > 1.0) {
			errorrateindesignunadjusted = 1.0;
		} else {
			errorrateindesignunadjusted = a;
		}
	}

	public double getErrorRateInCodingUnadjusted() {
		return errorrateincodingunadjusted;
	}

	public void setErrorRateInCodingUnadjusted(double a) {
		if (a < 0.0) {
			errorrateincodingunadjusted = 0.0;
		} else if (a > 1.0) {
			errorrateincodingunadjusted = 1.0;
		} else {
			errorrateincodingunadjusted = a;
		}
	}

	public double getErrorRateInTestingUnadjusted() {
		return errorrateintestingunadjusted;
	}

	public void setErrorRateInTestingUnadjusted(double a) {
		if (a < 0.0) {
			errorrateintestingunadjusted = 0.0;
		} else if (a > 1.0) {
			errorrateintestingunadjusted = 1.0;
		} else {
			errorrateintestingunadjusted = a;
		}
	}

	public double getProductivityInRequirements() {
		return productivityinrequirements;
	}

	public void setProductivityInRequirements(double a) {
		if (a < 0.0) {
			productivityinrequirements = 0.0;
		} else if (a > 1.0) {
			productivityinrequirements = 1.0;
		} else {
			productivityinrequirements = a;
		}
	}

	public double getProductivityInDesign() {
		return productivityindesign;
	}

	public void setProductivityInDesign(double a) {
		if (a < 0.0) {
			productivityindesign = 0.0;
		} else if (a > 1.0) {
			productivityindesign = 1.0;
		} else {
			productivityindesign = a;
		}
	}

	public double getProductivityInCoding() {
		return productivityincoding;
	}

	public void setProductivityInCoding(double a) {
		if (a < 0.0) {
			productivityincoding = 0.0;
		} else if (a > 1.0) {
			productivityincoding = 1.0;
		} else {
			productivityincoding = a;
		}
	}

	public double getProductivityInTesting() {
		return productivityintesting;
	}

	public void setProductivityInTesting(double a) {
		if (a < 0.0) {
			productivityintesting = 0.0;
		} else if (a > 1.0) {
			productivityintesting = 1.0;
		} else {
			productivityintesting = a;
		}
	}

	public double getErrorRateInRequirements() {
		return errorrateinrequirements;
	}

	public void setErrorRateInRequirements(double a) {
		if (a < 0.0) {
			errorrateinrequirements = 0.0;
		} else if (a > 1.0) {
			errorrateinrequirements = 1.0;
		} else {
			errorrateinrequirements = a;
		}
	}

	public double getErrorRateInDesign() {
		return errorrateindesign;
	}

	public void setErrorRateInDesign(double a) {
		if (a < 0.0) {
			errorrateindesign = 0.0;
		} else if (a > 1.0) {
			errorrateindesign = 1.0;
		} else {
			errorrateindesign = a;
		}
	}

	public double getErrorRateInCoding() {
		return errorrateincoding;
	}

	public void setErrorRateInCoding(double a) {
		if (a < 0.0) {
			errorrateincoding = 0.0;
		} else if (a > 1.0) {
			errorrateincoding = 1.0;
		} else {
			errorrateincoding = a;
		}
	}

	public double getErrorRateInTesting() {
		return errorrateintesting;
	}

	public void setErrorRateInTesting(double a) {
		if (a < 0.0) {
			errorrateintesting = 0.0;
		} else if (a > 1.0) {
			errorrateintesting = 1.0;
		} else {
			errorrateintesting = a;
		}
	}

	public boolean getOnBreak() {
		return onbreak;
	}

	public void setOnBreak(boolean a) {
		onbreak = a;
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
	
	@Override
	public void setOverheadText(String s) {
		super.setOverheadText(s, this.name);
	}

}