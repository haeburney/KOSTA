package emp;

import java.sql.Date;
// util 말고 sql을 import 해야 한다.


public class EmpVo {
	private int empId;
	private String name;
	private int salary;
	private Date hireDate;
	private int deptId;
	
	public EmpVo() {	
	}

	public EmpVo(int empId, String name, int salary, Date hireDate, int deptId) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmpVo [empId=" + empId + ", name=" + name + ", salary=" + salary + ", hireDate=" + hireDate
				+ ", deptId=" + deptId + "]";
	}

}
