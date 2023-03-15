package member;

public class MemberVo {
	private String id;
	private String pwd;
	private String name;
	private String pn;
	private int point;
	private String grade;

	public MemberVo() {

	}

	public MemberVo(String id, String pwd, String name, String pn, int point, String grade) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.pn = pn;
		this.point = point;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", pn=" + pn + ", point=" + point + ", grade="
				+ grade + "]";
	}

}