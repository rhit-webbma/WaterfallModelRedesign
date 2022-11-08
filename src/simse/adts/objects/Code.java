/* File generated by: simse.codegenerator.stategenerator.ADTGenerator */
package simse.adts.objects;

public class Code extends Artifact implements Cloneable {
	private String name;
	private double size;
	private double percentcomplete;
	private double amountintegrated;
	private double percentintegrated;
	private int numauthors;
	private double numknownerrors;
	private double numunknownerrors;
	private double percenterroneous;
	private double numunknowntemp;
	private int completenessdiffreqdoc;
	private int completenessdiffdesdoc;
	private int completenessdifftestplan;
	private int pcntintegrateddiffdesdoc;

	public Code(String n0, double s1, double p2, double a3, double p4, int n5,
			double n6, double n7, double p8, double n9, int c10, int c11,
			int c12, int p13) {
		super(n0, s1, p2, n6, n7, p8, n9);
		setAmountIntegrated(a3);
		setPercentIntegrated(p4);
		setNumAuthors(n5);
		setCompletenessDiffReqDoc(c10);
		setCompletenessDiffDesDoc(c11);
		setCompletenessDiffTestPlan(c12);
		setPcntIntegratedDiffDesDoc(p13);
	}

	public Object clone() {
		Code cl = (Code) (super.clone());
		cl.name = name;
		cl.size = size;
		cl.percentcomplete = percentcomplete;
		cl.amountintegrated = amountintegrated;
		cl.percentintegrated = percentintegrated;
		cl.numauthors = numauthors;
		cl.numknownerrors = numknownerrors;
		cl.numunknownerrors = numunknownerrors;
		cl.percenterroneous = percenterroneous;
		cl.numunknowntemp = numunknowntemp;
		cl.completenessdiffreqdoc = completenessdiffreqdoc;
		cl.completenessdiffdesdoc = completenessdiffdesdoc;
		cl.completenessdifftestplan = completenessdifftestplan;
		cl.pcntintegrateddiffdesdoc = pcntintegrateddiffdesdoc;
		return cl;
	}


	public double getAmountIntegrated() {
		return amountintegrated;
	}

	public void setAmountIntegrated(double a) {
		if (a < 0.0) {
			amountintegrated = 0.0;
		} else {
			amountintegrated = a;
		}
	}

	public double getPercentIntegrated() {
		return percentintegrated;
	}

	public void setPercentIntegrated(double a) {
		if (a < 0.0) {
			percentintegrated = 0.0;
		} else if (a > 100.0) {
			percentintegrated = 100.0;
		} else {
			percentintegrated = a;
		}
	}

	public int getNumAuthors() {
		return numauthors;
	}

	public void setNumAuthors(int a) {
		if (a < 0) {
			numauthors = 0;
		} else {
			numauthors = a;
		}
	}

	public int getCompletenessDiffReqDoc() {
		return completenessdiffreqdoc;
	}

	public void setCompletenessDiffReqDoc(int a) {
		if (a < 0) {
			completenessdiffreqdoc = 0;
		} else if (a > 1) {
			completenessdiffreqdoc = 1;
		} else {
			completenessdiffreqdoc = a;
		}
	}

	public int getCompletenessDiffDesDoc() {
		return completenessdiffdesdoc;
	}

	public void setCompletenessDiffDesDoc(int a) {
		if (a < 0) {
			completenessdiffdesdoc = 0;
		} else if (a > 1) {
			completenessdiffdesdoc = 1;
		} else {
			completenessdiffdesdoc = a;
		}
	}

	public int getCompletenessDiffTestPlan() {
		return completenessdifftestplan;
	}

	public void setCompletenessDiffTestPlan(int a) {
		if (a < 0) {
			completenessdifftestplan = 0;
		} else if (a > 1) {
			completenessdifftestplan = 1;
		} else {
			completenessdifftestplan = a;
		}
	}

	public int getPcntIntegratedDiffDesDoc() {
		return pcntintegrateddiffdesdoc;
	}

	public void setPcntIntegratedDiffDesDoc(int a) {
		if (a < 0) {
			pcntintegrateddiffdesdoc = 0;
		} else if (a > 1) {
			pcntintegrateddiffdesdoc = 1;
		} else {
			pcntintegrateddiffdesdoc = a;
		}
	}

}