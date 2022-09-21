public class Employee {

	int empNo;
	String empName;
	String department;
	char type;
	double payRate;
	double maxHours;
	
	public Employee() {
		
		this.empNo = 0;
		this.empName = null;
		this.department = null;
		this.type = 0;
		this.payRate = 0.0;
		this.maxHours = 0.0;
	}
	
	public Employee(int empNo, String empName, String department, char type, double payRate, double maxHours) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.type = type;
		this.payRate = payRate;
		this.maxHours = maxHours;
		
	}
	
	public Employee(Employee employee, int empNo, String empName, String department) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.type = employee.getType();
		this.payRate = employee.getPayRate();
		this.maxHours = employee.getMaxHours();
	}
	
	public int getEmpNo() {
		
		return empNo;
	}
	
	public void setEmpNo(int empNo) {
		
		this.empNo = empNo;
	}
	
	public String getEmpName() {
		
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public char getType( ) {
		
		return type;
	}
	
	public void setType(char type) {
		this.type = type;
		
	}
	
	public double getPayRate() {
		
		return payRate;
	}
	
	public void setPayRate(double payRate) {
		
		this.payRate = payRate;
		
	}
	
	public double getMaxHours() {
		
		return maxHours;
	}
	
	public void setMaxHours(double maxHours) {
		
		this.maxHours = maxHours;
	}
}
