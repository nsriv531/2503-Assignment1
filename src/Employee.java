public class Employee {

	private int empNo;
	private String empName;
	private String department;
	private char type;
	private double payRate;
	private double maxHours;
	
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
		final double FEDTAXREDUCTION1 = 0.075;
		final double FEDTAXREDUCTION2 = 0.12;
		final double FEDTAXREDUCTION3 = 0.17;
		
		
		if (gross < 1000) {
			gross = gross * FEDTAXREDUCTION1;
		} else if (gross >= 1000 && gross < 2000) {
			gross = gross * FEDTAXREDUCTION2;
		} else {
			gross = gross * FEDTAXREDUCTION3;
		}
		
		return gross;
		
		
	}
	
	public double calcCPP(double gross) {
		final double CPPCONTRIBUTION = 0.0475;
		
		gross = gross * CPPCONTRIBUTION;
		
		return gross;
		
		
	}
	
	public double calcEI(double gross) {
		final double EICONTRIBUTION = 0.018;
		
		
		gross = gross * EICONTRIBUTION;
		
		return gross;
		
		
	}
	
	public double calcExtHealth(double gross) {
		
		final double PREMIUMCHARGE = 0.013;
		
		gross = gross * PREMIUMCHARGE;
		
		return gross;
	
	
	}
	
	public double calcUnionDues(double gross) {
		final double UNIONDUES = 0.01;
		
		gross = gross * UNIONDUES;
		
		return gross;
	
	
	}
	
	public double calculateNetPay(double hoursWorked) {
		double netPay = 0;
		double grossWithoutReductions = 0;
		double CPPReduction = 0;
		double EIReduction = 0;
		double premiumsReduction = 0;
		double unionDuesReduction = 0;
		
		grossWithoutReductions = calcWithhold(calculateGrossWeekly(hoursWorked));
		CPPReduction = calcCPP(grossWithoutReductions);
		EIReduction = calcEI(grossWithoutReductions);
		premiumsReduction = calcExtHealth(grossWithoutReductions);
		unionDuesReduction = calcUnionDues(grossWithoutReductions);
		
		switch (this.type) {
		
		case 'S':
			
			netPay = grossWithoutReductions - CPPReduction - EIReduction - premiumsReduction;
			
			break;
		case 'H':
			
			netPay = grossWithoutReductions - CPPReduction - EIReduction - premiumsReduction - unionDuesReduction;
			
			break;
			
		case 'C':
			
			netPay = grossWithoutReductions - CPPReduction - EIReduction;
			
			break;
	}
		
		return netPay;
		
	}
	
	public int compareTo(Employee other) {
		
		int otherEmpNum = other.getEmpNo();
		
		if (this.empNo < otherEmpNum) {
			return -1;
		} else if (this.empNo == otherEmpNum) {
			return 0;
		} else {
			return 1;
		}
		
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String toString() {
		
		switch (this.type) {
		
		case 'S' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Salary";
			
		case 'H' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Hourly";
			
		case 'C' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Consultant";
		
		}
		return "Employee []";
	}
	
	
	
}
