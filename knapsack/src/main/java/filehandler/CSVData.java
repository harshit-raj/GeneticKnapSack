package filehandler;

public class CSVData {
	private int generationNum;
	private double bestGeneFitness;
	private double aveFitness;
	
	
	
	
	public CSVData() {
		
	}
	
	
	
	public CSVData(int generationNum, double bestGeneFitness, double aveFitness, int knapSackWeightCapacity) {
		super();
		this.generationNum = generationNum;
		this.bestGeneFitness = aveFitness;
		this.aveFitness = aveFitness;
	}

	
	
	@Override
	public String toString() {
		return "CSVData [m=" + m + ", birthdayCount=" + birthdayCount + ", couponCount=" + couponCount + "]";
	}



	public int getM() {
		return m;
	}



	public void setM(int m) {
		this.m = m;
	}



	public int getBirthdayCount() {
		return birthdayCount;
	}



	public void setBirthdayCount(int birthdayCount) {
		this.birthdayCount = birthdayCount;
	}



	public int getCouponCount() {
		return couponCount;
	}



	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}



	public String toFile() {
		return m+","+birthdayCount+","+couponCount+"\n";
	}
	
	
	
	

}
