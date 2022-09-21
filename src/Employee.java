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
	
	
	public double calculateGrossWeekly(Employee employee) {
		
		double grossWeeklyPay = 0;
		double overTimeHours;
		
		switch (type) {
		
			case 'S':
			
				grossWeeklyPay = (employee.getPayRate() / 52);
				
				break;
			case 'H':
				
				if (employee.getMaxHours() <= 40) {
					grossWeeklyPay = (employee.getPayRate() * employee.getMaxHours()); 
				} else if (employee.getMaxHours() > 40 && employee.getMaxHours() <= 60) {
					overTimeHours = employee.getMaxHours() - 40;
					grossWeeklyPay = (employee.getPayRate() * 40) + ((employee.getPayRate() * 1.5) * overTimeHours);
				} else {
					overTimeHours = 20;
					grossWeeklyPay = (employee.getPayRate() * 40) + ((employee.getPayRate() * 1.5) * overTimeHours);
				}
				
				break;
				
			case 'C':
		
				grossWeeklyPay = employee.getPayRate() * employee.getMaxHours();
				
				break;
		}
		
		return grossWeeklyPay;
		
		
	}
	
	public double calculateDeductions(double grossPay) {
		return grossPay;
		
		
	}
	
	public void calculateNetPay() {
		
		
	}
	
	public void compareEmployee() {
		
		
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
