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
	
	
	public double calculateGrossWeekly(double hoursWorked) {
		
		double grossWeeklyPay = 0;
		double overTimeHours;
		
		switch (type) {
		
			case 'S':
			
				grossWeeklyPay = payRate / 52;
				
				break;
			case 'H':
				
				if (maxHours <= 40) {
					grossWeeklyPay = (payRate * maxHours); 
				} else if (maxHours > 40 && maxHours <= 60) {
					overTimeHours = maxHours - 40;
					grossWeeklyPay = (payRate * 40) + ((payRate * 1.5) * overTimeHours);
				} else {
					overTimeHours = 20;
					grossWeeklyPay = (payRate * 40) + ((payRate * 1.5) * overTimeHours);
				}
				
				break;
				
			case 'C':
		
				grossWeeklyPay = payRate * maxHours;
				
				break;
		}
		
		return grossWeeklyPay;
		
		
	}
	
	public double calcWithhold(double gross) {
		
		if (gross < 1000) {
			gross = gross * 0.075;
		} else if (gross >= 1000 && gross < 2000) {
			gross = gross * 0.12;
		} else {
			gross = gross * 0.17;
		}
		
		return gross;
		
		
	}
	
	public double calcCPP(double gross) {
		
		gross = gross * 0.0475;
		
		return gross;
		
		
	}
	
	public double calcEI(double gross) {
		
		gross = gross * 0.018;
		
		return gross;
		
		
	}
	
	public double calcExtHealth(double gross) {
		
		gross = gross * 0.013;
		
		return gross;
	
	
	}
	
	public double calcUnionDues(double gross) {
		
		gross = gross * 0.01;
		
		return gross;
	
	
	}
	
	public double calculateNetPay(Employee employee, double gross) {
		double netPay = 0;
		
		switch (type) {
		
		case 'S':
		
			
			
			break;
		case 'H':
			
			
			
			break;
			
		case 'C':
	
			
			
			break;
	}
		
		return netPay;
		
		
	}
	
	public void compareTo(Employee other) {
		
		
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
