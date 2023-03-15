package membership;

public class MembershipVo {
	private String grade;
	private double rate;
	private int maxPoint;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	public MembershipVo(String grade, double rate, int maxPoint) {
		this.grade = grade;
		this.rate = rate;
		this.maxPoint = maxPoint;
	}

	@Override
	public String toString() {
		return "MemebershipVo [grade=" + grade + ", rate=" + rate + ", maxPoint=" + maxPoint + "]";
	}

}
