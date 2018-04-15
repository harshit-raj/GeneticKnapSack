package filehandler;

public class CSVData {
	private int m;
	private int birthdayCount;
	private int couponCount;
	
	
	
	
	public CSVData() {
		
	}
	
	
	
	public CSVData(int m, int birthdayCount, int couponCount) {
		super();
		this.m = m;
		this.birthdayCount = birthdayCount;
		this.couponCount = couponCount;
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
